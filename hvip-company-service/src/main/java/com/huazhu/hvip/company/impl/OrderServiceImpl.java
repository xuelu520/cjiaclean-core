package com.huazhu.hvip.company.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.company.manager.OrderManager;
import com.huazhu.hvip.company.model.Order;
import com.huazhu.hvip.company.qo.OrderQO;
import com.huazhu.hvip.company.service.OrderService;
import com.huazhu.hvip.company.vo.OrderVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmy
 * @create 2017-11-02 10:25
 **/
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    private static Logger logger = LogManager.getLogger(ProgramServiceImpl.class);

    @Autowired
    private OrderManager orderManager;

    /**
     * 查询下的工程列表
     *
     * @param orderQO
     * @return
     */
    @Override
    public ReturnObject orderListJson(OrderQO orderQO) {
        logger.info("call orderListJson({" + JsonUtil.JSON_Bean2String(orderQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            List<OrderVO> orderVOList=new ArrayList<>();
            QueryModel queryModel = new QueryModel();
            queryModel.setPageNo(orderQO.getPageNo());
            queryModel.setPageSize(orderQO.getPageSize());
            queryModel.addColumnValueCondition("ProgramID", orderQO.getProgramId());
            List<Order> orderList = orderManager.search(queryModel);
            if (CheckUtil.checkListIsNull(orderList)) {
                orderVOList= CopyBeanUtil.copyList(orderList,OrderVO.class);
            }
            returnObject.setDataList(orderVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.info("call orderListJson error()",e);
        }
        return returnObject;
    }
}
