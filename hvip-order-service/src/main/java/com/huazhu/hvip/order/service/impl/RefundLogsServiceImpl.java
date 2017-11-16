/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: RefundLogsServiceImpl.java
 * Author:   HUQIANBO001
 * Date:     2016-04-08 10:46:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-08 10:46:41><version><desc>
 */

package com.huazhu.hvip.order.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.service.SerialNumService;
import com.huazhu.hvip.common.vo.SerialName;
import com.huazhu.hvip.order.ord.manager.OrderManager;
import com.huazhu.hvip.order.ord.model.extend.OrderExt;
import com.huazhu.hvip.order.payment.manager.PaymentManager;
import com.huazhu.hvip.order.payment.manager.RefundLogsManager;
import com.huazhu.hvip.order.payment.model.Payment;
import com.huazhu.hvip.order.payment.model.RefundLogs;
import com.huazhu.hvip.order.service.RefundLogsService;
import com.huazhu.hvip.order.vo.AddRefundLogsVO;
import com.huazhu.hvip.order.vo.RefundLogsVO;
import com.huazhu.hvip.util.CopyBeanUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("refundLogsService")
public class RefundLogsServiceImpl implements RefundLogsService {

    private static Logger logger = LogManager.getLogger(RefundLogsServiceImpl.class);

    @Autowired
    private PaymentManager paymentManager;

    @Autowired
    private OrderManager orderManager;

    @Autowired
    private RefundLogsManager refundLogsManager;

    @Autowired
    private SerialNumService serialNumService;




    /**
     * 创建退款单
     *
     * @param addRefundLogsVO
     * @param orderExt
     * @param payment
     * @return
     */
    private ReturnObject<RefundLogs> saveRefundLogs(AddRefundLogsVO addRefundLogsVO, OrderExt orderExt, Payment payment) {

        ReturnObject<RefundLogs> ret = new ReturnObject<>();
        Date nowDate = new Date();

        // TODO 这里目前还缺orderItemsId和order的校验

        RefundLogs refundLogs = new RefundLogs();

        String refundSn = serialNumService.generateSnCommon(SerialName.REFUND_SN);
        refundLogs.setRefundSn(refundSn);

        refundLogs.setOrderId(orderExt.getOrderId());
        refundLogs.setOrderSn(orderExt.getOrderSn());
        refundLogs.setOrderItemsId(addRefundLogsVO.getOrderItemsId());
        refundLogs.setMemberId(orderExt.getMemberId());
        refundLogs.setPaymentSn(payment.getPaymentSn());
        refundLogs.setPayMemberName(payment.getPayMemberName());
        refundLogs.setPayType(payment.getPayType());
        refundLogs.setPayMethod(payment.getPayMethod());

        // TODO 这里目前还缺退款金额的计算及验证
        refundLogs.setAmount(addRefundLogsVO.getRefundAmount());

        refundLogs.setRefundUser(addRefundLogsVO.getRefundName());
        refundLogs.setRefundTime(nowDate);
        if(StringUtils.isNotBlank(addRefundLogsVO.getStatus())) {
            refundLogs.setStatus(addRefundLogsVO.getStatus());
        }else{
            refundLogs.setStatus(Constants.REFUND_STATUS_WAIT);
        }
        refundLogs.setRemark(addRefundLogsVO.getRemark());

        refundLogs.setCreateTime(nowDate);
        refundLogs.setCreateUser(addRefundLogsVO.getRefundName());
        refundLogs.setUpdateTime(nowDate);
        refundLogs.setUpdateUser(addRefundLogsVO.getRefundName());

        refundLogs = refundLogsManager.save(refundLogs);

        if(refundLogs.getRefundId()==null){
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
        }else{
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setData(refundLogs);
        }

        return ret;
    }

    @Override
    public ReturnObject getRefundLogsByOrderId(Long orderId) {
        logger.info(" call getRefundLogsByOrderId({"+orderId+"})");
        ReturnObject returnObject=new ReturnObject();
        try {
            if(null!=orderId){
                QueryModel queryModel=new QueryModel();
                queryModel.addColumnValueCondition("orderId",orderId);
                RefundLogs refundLogs=refundLogsManager.getUniqueResult(queryModel);
                if (null!=refundLogs) {
                    RefundLogsVO refundLogsVO=new RefundLogsVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(refundLogs,refundLogsVO);
                    returnObject.setData(refundLogsVO);
                    returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                }
            }
        } catch (Exception e) {
            logger.error(" call getRefundLogsByOrderId error({"+orderId+"})",e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }
}
