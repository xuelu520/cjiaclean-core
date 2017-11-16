/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrderDebitServiceImpl.java
 * Author:   lijing
 * Date:     2016-04-28 10:44:26
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-28 10:44:26> <version>   <desc>
 *
 */

package com.huazhu.hvip.order.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.order.ord.manager.OrderDebitManager;
import com.huazhu.hvip.order.ord.manager.OrderManager;
import com.huazhu.hvip.order.ord.model.OrderDebit;
import com.huazhu.hvip.order.qo.OrderDebitQO;
import com.huazhu.hvip.order.service.OrderDebitService;
import com.huazhu.hvip.order.vo.OrderDebitVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("orderDebitService")
public class OrderDebitServiceImpl implements OrderDebitService {
    private static Logger logger = LogManager.getLogger(OrderDebitServiceImpl.class);

    @Autowired
    private OrderDebitManager orderDebitManager;

    @Autowired
    private OrderManager orderManager;

    /**
     * 创建订单挂账
     *
     * @param orderDebitVO
     * @return
     */
    @Override
    public ReturnObject<OrderDebitVO> addOrderDebit(OrderDebitVO orderDebitVO) {
        logger.info("call addOrderDebit({\"orderDebitVO:\"" + JsonUtil.JSON_Bean2String(orderDebitVO) + "})");
        ReturnObject<OrderDebitVO> ret = new ReturnObject<>();

        try {
            OrderDebit orderDebit = new OrderDebit();
            BeanUtils.copyProperties(orderDebitVO, orderDebit);

            orderDebit = orderDebitManager.addOrderDebit(orderDebit);
            BeanUtils.copyProperties(orderDebit, orderDebitVO);

            ret.setData(orderDebitVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("创建成功");
        } catch (Exception e) {
            logger.error("创建失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("创建失败");
        }

        return ret;
    }


    /**
     * 查询入账记录
     *
     * @param orderDebitQO
     * @return
     */
    @Override
    public ReturnObject<OrderDebitVO> searchOrderDebit(OrderDebitQO orderDebitQO) {
        logger.info("call searchOrderDebit({\"orderDebitQO:\"" + JsonUtil.JSON_Bean2String(orderDebitQO) + "})");

        ReturnObject<OrderDebitVO> returnObject = new ReturnObject<>();
        List<OrderDebitVO> orderDebitVOList = null;
        OrderDebitVO orderDebitVO = null;

        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("orderDebitId",orderDebitQO.getOrderDebitId());
            queryModel.addColumnValueCondition("orderId",orderDebitQO.getOrderId());
            queryModel.addColumnValueCondition("orderItemId",orderDebitQO.getOrderItemId());
            queryModel.addColumnValueCondition("type",orderDebitQO.getType());
            queryModel.addColumnValueCondition("billType",orderDebitQO.getBillType());
            queryModel.addColumnValueCondition("billNo",orderDebitQO.getBillNo());
            queryModel.addColumnValueCondition("status",orderDebitQO.getStatus());
            List<OrderDebit> orderDebitList = orderDebitManager.search(queryModel);

            if (orderDebitList!=null){
                orderDebitVOList = new ArrayList<>();
                for (OrderDebit orderDebit : orderDebitList){
                    orderDebitVO = new OrderDebitVO();
                    BeanUtils.copyProperties(orderDebit,orderDebitVO);
                    orderDebitVOList.add(orderDebitVO);
                }
            }

            returnObject.setDataList(orderDebitVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");

        } catch (BeansException e) {
            logger.error("查询入账信息失败",e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        return returnObject;
    }
}
