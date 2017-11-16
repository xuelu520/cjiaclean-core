/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrderServiceImpl.java
 * Author:   admin
 * Date:     2016-03-08 18:52:35
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 18:52:35><version><desc><source>
 */

package com.huazhu.hvip.order.service.impl;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.constants.DicMap;
import com.huazhu.hvip.base.model.OperatorInfo;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.service.SerialNumService;
import com.huazhu.hvip.common.service.SmsSendService;
import com.huazhu.hvip.common.vo.SerialName;
import com.huazhu.hvip.member.service.MemberService;
import com.huazhu.hvip.member.vo.MemberVO;
import com.huazhu.hvip.operation.service.HotelService;
import com.huazhu.hvip.operation.vo.HotelVO;
import com.huazhu.hvip.order.ord.manager.*;
import com.huazhu.hvip.order.ord.model.*;
import com.huazhu.hvip.order.ord.model.extend.HotelOrderSale;
import com.huazhu.hvip.order.ord.model.extend.OrderExt;
import com.huazhu.hvip.order.payment.manager.PaymentManager;
import com.huazhu.hvip.order.payment.model.Payment;
import com.huazhu.hvip.order.payment.model.RefundLogs;
import com.huazhu.hvip.order.qo.OrderQO;
import com.huazhu.hvip.order.qo.ServiceQO;
import com.huazhu.hvip.order.service.OrderDebitService;
import com.huazhu.hvip.order.service.OrderService;
import com.huazhu.hvip.order.vo.*;
import com.huazhu.hvip.product.service.GoodsService;
import com.huazhu.hvip.product.service.GoodsStoreService;
import com.huazhu.hvip.product.vo.*;
import com.huazhu.hvip.user.qo.CleanerQO;
import com.huazhu.hvip.user.service.CleanerService;
import com.huazhu.hvip.user.vo.CleanerVO;
import com.huazhu.hvip.util.*;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 订单相关接口实现
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderManager orderManager;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private SerialNumService serialNumService;
    @Autowired
    private GoodsStoreService goodsStoreService;
    @Autowired
    private PaymentManager paymentManager;
    @Autowired
    private OrderItemsManager orderItemsManager;
    @Autowired
    private ThreadPoolTaskExecutor threadPool;
    @Autowired
    private SmsSendService smsSendService;
    @Autowired
    private OrderDebitService orderDebitService;
    @Autowired
    private ServiceManager serviceManager;
    @Autowired
    private OpOrderListViewManager opOrderListViewManager;
    @Autowired
    private CleanerService cleanerService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ServiceitemManager serviceitemManager;

    /**
     * 根据商品id获取商品默认图片
     *
     * @param goodsId
     * @return
     */
    private OrderGoodsPictureVO getOrderGoodsPictureVO(Long goodsId) {
        OrderGoodsPictureVO orderGoodsPictureVO = null;

        try {
            ReturnObject<GoodsPictureVO> picRet = goodsService.getGoodsPictureByGoodsId(goodsId);
            GoodsPictureVO goodsPictureVO = picRet.getData();

            if (goodsPictureVO != null) {
                orderGoodsPictureVO = new OrderGoodsPictureVO();
                BeanUtils.copyProperties(goodsPictureVO, orderGoodsPictureVO);
            }

        } catch (BeansException e) {
            logger.error("获取商品图片失败", e);
        }

        return orderGoodsPictureVO;
    }


    /**
     * 获取订单取消规则
     *
     * @param orderVO
     * @param goodsId
     * @return
     */

    private OrderVO getCateCancelRule(OrderVO orderVO, Long goodsId) {
        if (orderVO.getStatus().equals(Constants.ORDER_STATUS_WAITSERVICE)) {

            try {
                //根据商品id获取商品分类取消规则
                ReturnObject<CateCancelRuleVO> ruleRet = goodsService.getCateCancelRuleByGoodsId(goodsId);
                CateCancelRuleVO cateCancelRuleVO = ruleRet.getData();
                if (cateCancelRuleVO == null) {
                    cateCancelRuleVO = new CateCancelRuleVO();
                }
                orderVO.setCancelType(cateCancelRuleVO.getCancelType()); //取消类型：0 取消全额退款 1 取消按照固定金额退款 2 取消按照百分比退款 9 取消不退款
                orderVO.setLastCancelHours(cateCancelRuleVO.getLastCancelHours()); //最晚取消时间（精确到小时）：     判断时间 - 当前日期 >= hours
                orderVO.setLastCancelTime(cateCancelRuleVO.getLastCancelTime()); //最后可取消时间  例：19:00 计算日期当天 19:00
                orderVO.setCancelCalcFee(cateCancelRuleVO.getCancelCalcFee()); //取消后扣款金额
                orderVO.setReturnsFlag(cateCancelRuleVO.getReturnsFlag());//发货后是否可以退货：0否  1是
                orderVO.setReturnsMinutes(cateCancelRuleVO.getReturnsMinutes());//多少时间(分钟)内前台有退货权限
            } catch (Exception e) {
                logger.info("获取商品分类订单规则异常。。。", e);
            }
        }

        return orderVO;
    }


    /**
     * 状态扭转操作权限判断
     * 待付款 --》取消、已付款
     * 已付款 --》取消、已发货
     * 已发货 --》取消、已完成
     * 已完成 --》删除
     * 取消   --》删除
     * nowShow--》删除
     *
     * @param status    原始状态
     * @param newStatus 新状态
     * @return
     */
    private boolean verifyStatus(String status, String newStatus) {

        boolean flag = false;
        //待支付
        if (status.equals(Constants.ORDER_STATUS_WAITPAY)
                && (newStatus.equals(Constants.ORDER_STATUS_CAL)
                || newStatus.equals(Constants.ORDER_STATUS_WAITSERVICE))) {
            flag = true;
        }
        //待服务
        if (status.equals(Constants.ORDER_STATUS_WAITSERVICE)
                && (newStatus.equals(Constants.ORDER_STATUS_SERVICING)
                || newStatus.equals(Constants.ORDER_STATUS_WAITREFUND))
                || newStatus.equals(Constants.ORDER_STATUS_REFUNDING)
                || newStatus.equals(Constants.ORDER_STATUS_REFUNDED)
                || newStatus.equals(Constants.ORDER_STATUS_WAITSERVICE)) {
            flag = true;
        }
        //待退款（人工退）
        if (status.equals(Constants.ORDER_STATUS_WAITREFUND)
                && (newStatus.equals(Constants.ORDER_STATUS_REFUNDING) || newStatus.equals(Constants.ORDER_STATUS_REFUNDED))) {
            flag = true;
        }
        //退款中
        if (status.equals(Constants.ORDER_STATUS_REFUNDING)
                && (newStatus.equals(Constants.ORDER_STATUS_REFUNDED))) {
            flag = true;
        }
        //退款中
        if (status.equals(Constants.ORDER_STATUS_SERVICING)
                && (newStatus.equals(Constants.ORDER_STATUS_DON)
                || newStatus.equals(Constants.ORDER_STATUS_WAITREFUND))
                || newStatus.equals(Constants.ORDER_STATUS_SERVICING)) {
            flag = true;
        }
        return flag;
    }


    /**
     * 扣商品库存
     *
     * @param hotelVO
     * @param order
     * @param orderItemsList
     */
    private void deductGoodsStore(HotelVO hotelVO, Order order, List<OrderItems> orderItemsList) {

        ChangeGoodsStoreVO changeGoodsStoreVO = new ChangeGoodsStoreVO();
        changeGoodsStoreVO.setHotelId(hotelVO.getHotelId());

        List<ChangeStoreInfoVO> changeStoreInfoVOList = new ArrayList<>();
        ChangeStoreInfoVO changeStoreInfoVO = null;
        for (OrderItems orderItems : orderItemsList) {
            changeStoreInfoVO = new ChangeStoreInfoVO();
            changeStoreInfoVO.setGoodsId(orderItems.getGoodsId());
            changeStoreInfoVO.setChangeType(Constants.CHANGESTORE_TYPE_BOOK);
            changeStoreInfoVO.setChangeNum(orderItems.getSalesNum());
            String remark = "创建订单[" + order.getOrderSn() + "],减少可用库存";
            changeStoreInfoVO.setRemark(remark);

            changeStoreInfoVOList.add(changeStoreInfoVO);
        }
        changeGoodsStoreVO.setChangeStoreInfoVOList(changeStoreInfoVOList);

        OperatorInfo operatorInfo = new OperatorInfo();
        operatorInfo.setOperatorId(0L);
        operatorInfo.setOperatorName("系统");
        changeGoodsStoreVO.setOperatorInfo(operatorInfo);

        ReturnObject ret = goodsStoreService.changeGoodsStore(changeGoodsStoreVO);

        logger.info("扣除商品库存，回调结果：" + JsonUtil.JSON_Bean2String(ret));

    }

    /**
     * 商品下单数+1
     *
     * @param orderItemsList
     */
    private void addGoodsOrderCount(List<OrderItems> orderItemsList) {

        List<Long> goodsIdList = new ArrayList<>();

        for (OrderItems items : orderItemsList) {
            goodsIdList.add(items.getGoodsId());
        }

        ReturnObject ret = goodsService.addGoodsOrderCount(goodsIdList);

        logger.info("商品下单数+1，回调结果：" + JsonUtil.JSON_Bean2String(ret));

    }


    /**
     * (hms)根据酒店统一编号,日期，名称，电话等模糊查找获取订单商品数量统计
     *
     * @param orderQO 酒店统一编号,日期，名称，电话等模糊查找
     * @return
     */
    @Override
    public ReturnObject<OrderItemsVO> itemsCount(OrderQO orderQO) {
        logger.info("call itemsCount({\"orderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "}");

        ReturnObject<OrderItemsVO> returnObject = new ReturnObject<>();
        List<OrderItems> orderItemsList = new ArrayList<>();
        List<OrderItemsVO> orderItemsVOList = new ArrayList<>();
        try {
            if (orderQO.getHotelUniqueNo() == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("查询失败，酒店统一编号为空");
                return returnObject;
            }
            ParamObject paramObject = new ParamObject();
            List<String> statusList = orderQO.getStatusList();
            List<Long> goodsIdList = orderQO.getGoodsIdList();
            if (orderQO.getHotelUniqueNo() != null) {
                paramObject.add("hotelUniqueNo", orderQO.getHotelUniqueNo());
            }
            if (orderQO.getIndex() != null) {
                paramObject.add("index", orderQO.getIndex());
            }
            if (orderQO.getQuery() != null) {
                paramObject.add("query", orderQO.getQuery());
            }
            if (goodsIdList != null && goodsIdList.size() != 0) {
                paramObject.add("goodsId", StringUtils.join(goodsIdList.toArray(), ","));
            }
            if (statusList != null && statusList.size() != 0) {
                paramObject.add("statusArray", StringUtils.join(statusList.toArray(), ","));
            }
            orderItemsList.addAll(orderItemsManager.searchOrderItemsList(paramObject));
            Map<Long, Integer> countMap = new HashMap();
            Map<Long, OrderItems> orderItemsMap = new HashMap();
            for (OrderItems orderItems : orderItemsList) {
                if (!orderItemsMap.containsKey(orderItems.getGoodsId())) {
                    orderItemsMap.put(orderItems.getGoodsId(), orderItems);
                }
                Integer count = 0;
                if (countMap.containsKey(orderItems.getGoodsId())) {
                    count = countMap.get(orderItems.getGoodsId());
                }
                countMap.put(orderItems.getGoodsId(), count + (orderItems.getSalesNum() != null ? orderItems.getSalesNum() : 0));
            }

            OrderItemsVO orderItemsVO = null;
            for (Map.Entry<Long, OrderItems> entry : orderItemsMap.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                OrderItems tempOrderItems = entry.getValue();
                orderItemsVO = new OrderItemsVO();

                orderItemsVO.setGoodsId(tempOrderItems.getGoodsId());
                orderItemsVO.setGoodsName(tempOrderItems.getGoodsName());
                orderItemsVO.setGoodsNo(tempOrderItems.getGoodsNo());
                orderItemsVO.setGoodsSn(tempOrderItems.getGoodsSn());
                if (countMap.containsKey(entry.getKey())) {
                    orderItemsVO.setSalesNum(countMap.get(entry.getKey()));
                } else {
                    orderItemsVO.setSalesNum(0);
                }
                orderItemsVOList.add(orderItemsVO);
            }
            returnObject.setDataList(orderItemsVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("统计商品数量成功");
        } catch (Exception e) {
            logger.error("根据酒店统一编号,日期，名称，电话等统计商品数量失败", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("统计商品数量失败");
        }
        return returnObject;
    }


    /**
     * (hms)根据货物编号获取货物明细列表打印出来
     *
     * @param orderQO 货物编号
     * @return
     */
    @Override
    public ReturnObject<OrderItemsVO> printOrderOrderItemsList(OrderQO orderQO) {
        logger.info("call printOrderOrderItemsList({\"orderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "})");

        ReturnObject<OrderItemsVO> returnObject = new ReturnObject<>();
        List<OrderItemsVO> orderItemsVOList = new ArrayList<>();
        try {
            List<Long> itemsIdList = orderQO.getItemsIdList();
            if (itemsIdList != null && itemsIdList.size() != 0) {
                OrderItems orderItems = null;
                Order order = null;
                OrderVO orderVO = null;
                OrderItemsVO orderItemsVO = null;
                orderItems = orderItemsManager.get(itemsIdList.get(0));
                order = orderManager.get(orderItems.getOrderId());
                ReturnObject<HotelVO> retHotel = hotelService.getHotelByHotelUniqueNo(order.getHotelUniqueNo());
                HotelVO hotelVO = retHotel.getData();
                for (Long itemsId : itemsIdList) {
                    orderItems = orderItemsManager.get(itemsId);
                    order = orderManager.get(orderItems.getOrderId());
                    orderVO = new OrderVO();
                    orderItemsVO = new OrderItemsVO();
                    BeanUtils.copyProperties(order, orderVO);
                    BeanUtils.copyProperties(orderItems, orderItemsVO);
                    orderItemsVO.setOrderVO(orderVO);
                    orderItemsVO.setAddress(hotelVO.getAddress());
                    orderItemsVO.setTelNo(Long.valueOf(hotelVO.getTelNo()));
                    orderItemsVOList.add(orderItemsVO);
                }
            }
            returnObject.setDataList(orderItemsVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("根据货物编号获取货物明细列表打印成功");
        } catch (Exception e) {
            logger.error("根据货物编号获取货物明细列表打印失败", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("根据货物编号获取货物明细列表打印失败");
        }
        return returnObject;
    }


    //设置订单支付规则
    private OrderVO setCateOrderRule(OrderVO orderVO, CateOrderRuleVO cateOrderRuleVO) {
//        //查询商品分类支付规则
//        ReturnObject<CateOrderRuleVO> ruRet = goodsService.getCateOrderRuleByGoodsId(goodsId);
//        CateOrderRuleVO cateOrderRuleVO = ruRet.getData();
        if (cateOrderRuleVO == null) {
            cateOrderRuleVO = new CateOrderRuleVO();
        }
        orderVO.setStorePayFlag(cateOrderRuleVO.getStorePayFlag());
        orderVO.setPaidCancelFlag(cateOrderRuleVO.getPaidCancelFlag());
        orderVO.setPayCountdown(cateOrderRuleVO.getPayCountdown());
        orderVO.setCanReservationTime(cateOrderRuleVO.getCanReservationTime());
        //orderVO.setRulePromptMsg(cateOrderRuleVO.getRulePromptMsg());
        orderVO.setOrderRuleDescription(cateOrderRuleVO.getDescription());
        orderVO.setReservationFlag(cateOrderRuleVO.getReservationFlag());
        orderVO.setAccountingFlag(cateOrderRuleVO.getAccountingFlag());
        orderVO.setCrmPayFlag(cateOrderRuleVO.getCrmPayFlag());

        return orderVO;
    }


    /**
     * (hms)获取DebitVO
     *
     * @param orderItemsVO 订单货物
     * @return
     */
    @Override
    public ReturnObject<DebitVO> getDebitVO(OrderItemsVO orderItemsVO) {
        logger.info("call getDebitVO({\"orderItemsVO\":" + JsonUtil.JSON_Bean2String(orderItemsVO) + "})");
        ReturnObject<DebitVO> returnObject = new ReturnObject<>();

        try {
            //根据商品id得到财务科目信息
            ReturnObject<FinanceSubInfoVO> financeSubjectVOReturnObject = goodsService.getFinanceSubjectByGoodsId(orderItemsVO.getGoodsId());

            if (!financeSubjectVOReturnObject.getReturnCode().equals(Constants.RETURN_CODE_SUCCESS)) {
                logger.error("根据商品id得到财务科目信息失败", financeSubjectVOReturnObject.getReturnMsg());
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("获取DebitVO失败");
                return returnObject;
            }

            DebitVO debitVO = new DebitVO();

            OrderItems orderItems = orderItemsManager.get(orderItemsVO.getItemsId());
            Order order = orderManager.get(orderItems.getOrderId());
            debitVO.setBillId(order.getHoBillId());
            debitVO.setHotelId(order.getHotelNo());
            debitVO.setOperatorId(orderItemsVO.getOperatorId());

            BigDecimal sum = orderItems.getPrice().multiply(new BigDecimal(orderItems.getSalesNum()));
            FinanceSubInfoVO financeSubInfoVO = financeSubjectVOReturnObject.getData();

            //创建payno
            String payNo = serialNumService.generateSnCommon(SerialName.DEBITPAY_NO);

            if (orderItemsVO.getFlag()) {//入账
                debitVO.setPayNo("VIPS" + payNo);
                debitVO.setDebitType(financeSubInfoVO.getSubjectCode());
            } else {//调账
                debitVO.setPayNo("VIPR" + payNo);
                debitVO.setDebitType(financeSubInfoVO.getSubjectAdjustCode());
                sum = sum.multiply(new BigDecimal(-1));
            }
            debitVO.setDebitSum(sum.toString());
            debitVO.setMemo(orderItems.getGoodsName() + "*" + orderItems.getSalesNum());
            logger.info("call getDebitVO({\"debitVO\":" + JsonUtil.JSON_Bean2String(debitVO) + "})");

            OrderDebitVO orderDebitVO = new OrderDebitVO();

            orderDebitVO.setOrderId(orderItems.getOrderId());
            orderDebitVO.setOrderItemId(orderItems.getItemsId());
            orderDebitVO.setHotelId(debitVO.getHotelId());
            orderDebitVO.setHotelOrderSn(order.getHotelOrderSn());
            orderDebitVO.setHotelBillId(debitVO.getBillId());
            orderDebitVO.setPayNo(debitVO.getPayNo());
            orderDebitVO.setAmount(new BigDecimal(debitVO.getDebitSum()));
            orderDebitVO.setRemark(debitVO.getMemo());
            orderDebitVO.setUserName(debitVO.getOperatorId());
            orderDebitVO.setDebitType(debitVO.getDebitType());
            orderDebitVO.setStatus(Constants.COMMON_STATUS_0);
            orderDebitVO.setCreateTime(new Date());
            orderDebitVO.setBillType(Constants.BILL_TYPE_0);
            orderDebitVO.setType(Constants.BILL_TYPE_DEBIT);
            orderDebitVO.setBizDate(orderItemsVO.getBizDate());
            ReturnObject<OrderDebitVO> debitVOReturnObject = orderDebitService.addOrderDebit(orderDebitVO);
            if (Constants.RETURN_CODE_SUCCESS.equals(debitVOReturnObject.getReturnCode())) {
                debitVO.setOrderDebitId(debitVOReturnObject.getData().getOrderDebitId());
                returnObject.setData(debitVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                returnObject.setReturnMsg("创建DebitVO成功");
            } else {
                logger.error("创建debit记录失败{}", debitVOReturnObject.getReturnMsg());
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("创建DebitVO成功失败");
            }

        } catch (Exception e) {
            logger.error("获取DebitVO失败", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("获取DebitVO失败");
        }
        return returnObject;
    }


    /**
     * (hms)获取CreditVO （新）
     *
     * @param orderVO
     * @return
     */
    @Override
    public ReturnObject<CreditVO> getOrderCreditVO(OrderVO orderVO) {
        logger.info("call getOrderCreditVO({\"orderVO\":" + JsonUtil.JSON_Bean2String(orderVO) + "})");

        ReturnObject<CreditVO> returnObject = new ReturnObject<>();
        try {
            CreditVO creditVO = new CreditVO();

            creditVO.setBillId(orderVO.getHoBillId());
            creditVO.setHotelId(orderVO.getHotelNo());
            creditVO.setOperatorId(orderVO.getOperatorName());
            String assType = DicMap.getDicValue(orderVO.getPayMethod());
            creditVO.setPayType(orderVO.getPayType());

            //创建payno
            String payNo = serialNumService.generateSnCommon(SerialName.DEBITPAY_NO);
            //BigDecimal refundAmount = orderVO.getRefundAmount() == null ? new BigDecimal("0.00") : orderVO.getRefundAmount();
            //BigDecimal sum = orderVO.getOrderAmount().subtract(refundAmount);

            String point = "0";

            Double payAmount = 0.0;
            if (orderVO.getPaymentVO() != null && StringUtils.isNotBlank(orderVO.getPaymentVO().getPayResponse())) {
                String payResponse = orderVO.getPaymentVO().getPayResponse();
                JSONObject jsonobject = JSONObject.fromObject(payResponse);
                String paymentDetail = jsonobject.get("PaymentDetail") == null ? null : jsonobject.get("PaymentDetail").toString();
                payAmount = CommonUtil.getPayAmount(paymentDetail, orderVO.getPayMethod());
                if (orderVO.getPayMethod().equals(Constants.ASSTYPE_CRMPOINT)) {
                    point = payAmount.intValue() * 100 + "";
                }
            }

            if (orderVO.getAdjustFlag()) {//调账
                creditVO.setPayNo("VIPR" + payNo);
                payAmount = payAmount * -1;
            } else {  //入账
                creditVO.setPayNo("VIPS" + payNo);
            }
            creditVO.setAmount(payAmount.toString());


            creditVO.setPoint(point);
            creditVO.setAssType(assType);
            logger.info("call getCreditVO({\"creditVO\":" + JsonUtil.JSON_Bean2String(creditVO) + "})");

            OrderDebitVO orderDebitVO = new OrderDebitVO();
            orderDebitVO.setOrderId(orderVO.getOrderId());
            orderDebitVO.setHotelId(creditVO.getHotelId());
            orderDebitVO.setHotelOrderSn(orderVO.getHotelOrderSn());
            orderDebitVO.setHotelBillId(creditVO.getBillId());
            orderDebitVO.setPayNo(creditVO.getPayNo());
            orderDebitVO.setAmount(new BigDecimal(creditVO.getAmount()));
            orderDebitVO.setBizDate(orderVO.getBizDate());
            orderDebitVO.setPoint(new Integer(creditVO.getPoint()));
            orderDebitVO.setUserName(creditVO.getOperatorId());
            orderDebitVO.setAssType(creditVO.getAssType());
            orderDebitVO.setType(Constants.BILL_TYPE_CREDIT);
            orderDebitVO.setStatus(Constants.COMMON_STATUS_0);
            orderDebitVO.setCreateTime(new Date());
            orderDebitVO.setBillType(Constants.BILL_TYPE_0);

            ReturnObject<OrderDebitVO> debitVOReturnObject = orderDebitService.addOrderDebit(orderDebitVO);
            if (Constants.RETURN_CODE_SUCCESS.equals(debitVOReturnObject.getReturnCode())) {
                creditVO.setOrderDebitId(debitVOReturnObject.getData().getOrderDebitId());
                returnObject.setData(creditVO);

                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                returnObject.setReturnMsg("创建credit记录成功");
            } else {
                logger.error("创建Credit记录失败{}", debitVOReturnObject.getReturnMsg());
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("创建Credit记录失败");
            }

        } catch (Exception e) {
            logger.error("创建CreditVO记录失败", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("创建CreditVO记录失败");
        }
        return returnObject;
    }


    /**
     * (hms)是否是线上下单线上支付
     *
     * @param orderItemsVO 订单货物
     * @return
     */
    @Override
    public boolean isOnlinePay(OrderItemsVO orderItemsVO) {
        boolean isOnlinePay = false;
        OrderItems orderItems = orderItemsManager.get(orderItemsVO.getItemsId());
        Order order = orderManager.get(orderItems.getOrderId());

        //线上下单
        if (!Constants.ORDER_SOURCE_HMS.equals(order.getSource())) {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("orderId", orderItems.getOrderId());
            queryModel.addColumnValueCondition("status", Constants.PAYMENT_STATUS_PAID);
            List<Payment> paymentList = paymentManager.search(queryModel);
            if (paymentList != null && paymentList.size() != 0) {
                Payment payment = paymentList.get(0);
                if (Constants.PAYMENT_TYPE_ONLINE.equals(payment.getPayType())) {
                    isOnlinePay = true;
                }
            }
        }
        return isOnlinePay;
    }

    /**
     * 根据orderSn获取订单详情
     *
     * @param orderSn
     * @return
     */
    @Override
    public ReturnObject<OrderVO> getOrderDetailForHms(String orderSn) {
        logger.info("call getOrderDetail({\"orderSn\":" + orderSn + "})");

        ReturnObject<OrderVO> returnObject = new ReturnObject<>();

        OrderVO orderVO = null;

        try {

            if (orderSn == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("查询失败，orderSn为空");
                return returnObject;
            }

            orderSn = ParamsFilterUtil.cleanXSS(orderSn);
            ParamObject paramObject = new ParamObject();
            paramObject.add("orderSn", orderSn);
            List<OrderExt> orderExtList = orderManager.getOrderDetail(paramObject);

            if (orderExtList == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("未查询到该订单信息，orderSn:" + orderSn);
                return returnObject;
            }

            orderVO = new OrderVO();
            OrderExt orderExt = orderExtList.get(0);
            BeanUtils.copyProperties(orderExt, orderVO);

            List<OrderItemsVO> orderItemsVOList = new ArrayList<>();
            OrderItemsVO orderItemsVO = null;
            Long goodsId = null;
            Date minServiceTime = null;
            List<OrderItems> orderItemsList = orderExt.getOrderItemsList();

            for (OrderItems orderItems : orderItemsList) {
                orderItemsVO = new OrderItemsVO();
                BeanUtils.copyProperties(orderItems, orderItemsVO);
                orderItemsVO.setOrderSn(orderSn);

                orderItemsVOList.add(orderItemsVO);
            }
            orderVO.setOrderItemsVOList(orderItemsVOList);
            returnObject.setData(orderVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("订单查询成功");
        } catch (Exception e) {
            logger.error("查询订单失败", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询订单失败");
        }
        return returnObject;
    }


    /**
     * (op)根据关键字：订单唯一号，或者订货人或者全查询订单列表
     *
     * @param orderQO
     * @param pageCondition
     * @return
     */
    @Override
    public ReturnObject<OrderVO> searchOrderListForOp(OrderQO orderQO, PageCondition pageCondition) {
        logger.info("call searchOrderList({\"orderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "},{\"pageCondition\":" + JsonUtil.JSON_Bean2String(pageCondition) + "})");

        ReturnObject<OrderVO> ret = new ReturnObject<>();
        List<OrderVO> orderVOList = new ArrayList<>();

        try {
            ParamObject paramObject = new ParamObject();

            paramObject.setPageNo(pageCondition.getPageNo());
            paramObject.setPageSize(pageCondition.getPageSize());
            paramObject.add("keyword", orderQO.getKeyword());
            paramObject.add("status", orderQO.getStatus());
            paramObject.add("billType", orderQO.getBillType());
            paramObject.add("source", orderQO.getSource());
            paramObject.add("deleteFlag", Constants.DELETE_FLAG_FALSE);
            paramObject.add("beginTime", orderQO.getBeginTime());
            paramObject.add("endTime", orderQO.getEndTime());

            List<OrderExt> orderExtList = orderManager.searchOrderListForOp(paramObject);
            OrderVO orderVO = null;
            if (orderExtList != null && orderExtList.size() > 0) {
                for (OrderExt orderExt : orderExtList) {
                    orderVO = new OrderVO();
                    BeanUtils.copyProperties(orderExt, orderVO);
                    orderVOList.add(orderVO);
                }
            }

            ret.setTotalSize(paramObject.getTotalNum());
            ret.setDataList(orderVOList);
            ret.setReturnMsg("查询订单列表成功");
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("根据订单唯一号，订货人等或者全查询查找订单列表失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询订单列表失败");
        }

        return ret;
    }


    /**
     * 异步发送短信通知(订单相关)
     *
     * @param orderExt
     */
    private void asyncSmsSend(final OrderExt orderExt, final String smsType) {

        try {
            threadPool.execute(new Runnable() {
                public void run() {
                    OrderItems orderItems = orderExt.getOrderItemsList().get(0);

                    String assignTime = ""; //预约服务时间
                    if (orderItems.getAssignTime() != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DEFAULT_DATE_PATTERN);
                        assignTime = sdf.format(orderItems.getAssignTime());
                    }

                    String hotelTelNo = orderExt.getHotelTelNo(); //酒店门店电话

                    Map paramMap = new HashMap();
                    paramMap.put("serviceTime", assignTime);
                    paramMap.put("hotelTelNo", hotelTelNo);

                    String memberMobile = orderExt.getMemberMobile();

                    if (StringUtils.isNotBlank(memberMobile)) {
                        ReturnObject ret = smsSendService.smsSend(smsType, memberMobile, paramMap);
                        logger.info("进行异步的发送短信通知ReturnObject:{}", JsonUtil.JSON_Bean2String(ret));
                    }
                }
            });

        } catch (Exception e) {
            logger.error("OrderController.asyncSmsSend error", e);
        }

    }


    /**
     * 根据酒店订单号查询订单列表
     *
     * @param hotelOrderSn
     * @return
     */
    @Override
    public ReturnObject<OrderVO> searchOrderListByHotelOrderSn(String hotelOrderSn) {
        logger.info("call searchOrderListByHotelOrderSn({\"hotelOrderSn\":" + hotelOrderSn + "})");

        ReturnObject<OrderVO> ret = new ReturnObject<>();
        List<OrderVO> orderVOList = new ArrayList<>();
        OrderVO orderVO = null;

        try {
            if (hotelOrderSn == null) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("查询失败，酒店订单号为空");
                return ret;
            }

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("hotelOrderSn", hotelOrderSn);
            //queryModel.addColumnValueCondition("deleteFlag",Constants.DELETE_FLAG_FALSE);
            List<Order> orderList = orderManager.search(queryModel);

            for (Order order : orderList) {
                orderVO = new OrderVO();
                BeanUtils.copyProperties(order, orderVO);

                orderVOList.add(orderVO);
            }

            ret.setDataList(orderVOList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询订单列表成功");

        } catch (Exception e) {
            logger.error("查询订单列表失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询订单列表失败");
        }
        return ret;
    }


    /**
     * 获取订单的来源
     *
     * @return
     */
    @Override
    public ReturnObject searchOrderSourceList() {
        logger.info("call searchOrderSourceList()");
        ReturnObject ret = new ReturnObject();
        try {
            List<String> sourceList = orderManager.searchOrderSourceList();
            if (sourceList != null && sourceList.size() != 0) {
                ret.setDataList(sourceList);
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            } else {
                ret.setReturnCode(Constants.RETURN_CODE_ERROR);
                ret.setReturnMsg("查询来源失败");
            }
        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询来源失败");
        }
        return ret;
    }


    /**
     * 2016年7月5日09:53:27
     * 对listjson进行修改
     *
     * @param orderQO
     * @return
     */
    @Override
    public ReturnObject newOrderListJson(OrderQO orderQO) {
        ReturnObject returnObject = new ReturnObject();
        logger.info("call newOrderListJson({\"OrderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "})");
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("status", orderQO.getStatus());
            queryModel.addColumnValueCondition("cycle", orderQO.getCycle());
            queryModel.addColumnValueCondition("orderSn", orderQO.getOrderSn());
            if (StringUtils.isNotBlank(orderQO.getMemberKeyWord())) {
                queryModel.addHqlCondition(" memberMobile like '%" + orderQO.getMemberKeyWord() + "%' or memberName like '%" + orderQO.getMemberKeyWord() + "%'" + "%' or shipMobile like '%" + orderQO.getMemberKeyWord() + "%'");
            }
            if (StringUtils.isNotBlank(orderQO.getGoodsKeyWord())) {
                queryModel.addHqlCondition(" goodsName like '%" + orderQO.getGoodsKeyWord() + "%' or goodsSn like '%" + orderQO.getGoodsKeyWord() + "%'");
            }
            if (StringUtils.isNotBlank(orderQO.getBeginTime())) {
                queryModel.addHqlCondition(" createTime >='" + orderQO.getBeginTime() + "'");
            }
            if (StringUtils.isNotBlank(orderQO.getEndTime())) {
                queryModel.addHqlCondition(" createTime <='" + orderQO.getEndTime() + "'");
            }
            if (orderQO.getPageNo() != null && orderQO.getPageSize() != null) {
                queryModel.setPageNo(orderQO.getPageNo());
                queryModel.setPageSize(orderQO.getPageSize());
            }
            List<OpOrderListView> opOrderListViews = opOrderListViewManager.search(queryModel);
            List<OpOrderListViewVO> opOrderListViewVOs = new ArrayList<>();
            if (CheckUtil.checkListIsNull(opOrderListViews)) {
                for (OpOrderListView opOrderListView : opOrderListViews) {
                    OpOrderListViewVO opOrderListViewVO = new OpOrderListViewVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(opOrderListView, opOrderListViewVO);
                    opOrderListViewVOs.add(opOrderListViewVO);
                }
            }
            returnObject.setTotalSize(queryModel.getTotalNum());
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setDataList(opOrderListViewVOs);
        } catch (BeansException e) {
            e.printStackTrace();
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
            returnObject.setReturnMsg("查询失败");
        }
        return returnObject;
    }


    /**
     * 计算订单预订、取消规则
     * <p/>
     * 取消类型：0 取消全额退款 1 取消按照固定金额退款 2 取消按照百分比退款 9 取消不退款
     *
     * @return
     */
    private RulesVO calcOrderRule(RulesVO rulesVO) {
        try {
            rulesVO = checkDebitRule(rulesVO);
            if (Constants.CANCEL_TYPE_0.equals(rulesVO.getCancelType())) {
                rulesVO.setCancelRemark("取消后全额退款");
                rulesVO.setCancelAmount(new BigDecimal(0));
            } else if (Constants.CANCEL_TYPE_1.equals(rulesVO.getCancelType())) {
                if (rulesVO.getNeedDebit().booleanValue() == true) {
                    rulesVO.setCancelAmount(rulesVO.getCancelCalcFee());
                    rulesVO.setCancelRemark("取消后固定扣款，扣款金额：￥" + rulesVO.getCancelCalcFee());
                } else {
                    rulesVO.setCancelRemark("取消后全额退款");
                }
            } else if (Constants.CANCEL_TYPE_2.equals(rulesVO.getCancelType())) {
                if (rulesVO.getNeedDebit().booleanValue() == true) {
                    rulesVO.setCancelAmount(rulesVO.getOrderAmount().multiply(rulesVO.getCancelCalcFee()).setScale(2, BigDecimal.ROUND_HALF_UP));
                    rulesVO.setCancelRemark("取消后按百分比扣款，扣款金额：￥" + rulesVO.getCancelAmount());
                } else {
                    rulesVO.setCancelRemark("取消后全额退款");
                }
            } else if (Constants.CANCEL_TYPE_9.equals(rulesVO.getCancelType())) {
                rulesVO.setCancelAmount(rulesVO.getOrderAmount());
                rulesVO.setCancelRemark("取消后不退款");
            } else {
                rulesVO.setCancelRemark("取消后全额退款");
                rulesVO.setCancelAmount(new BigDecimal(0));
            }
        } catch (Exception e) {
            logger.error("call calcOrderRule error", e);
        }

        return rulesVO;
    }

    /**
     * 检查是否需要扣款
     *
     * @param rulesVO 规则对象
     * @return
     */
    private RulesVO checkDebitRule(RulesVO rulesVO) throws Exception {
        Date minAssignTime = rulesVO.getMinServiceTime();

        if (StringUtils.isNotBlank(rulesVO.getLastCancelTime())) {
            String lastCancelTime = DateUtil.convertDateToString(minAssignTime, DateUtil.DEFAULT_DATE_PATTERN) + " " + rulesVO.getLastCancelTime();
            if (DateUtil.convertStringToDate(DateUtil.DEFAULT_DATE_PATTERN + " " + DateUtil.TIME_PATTERN, lastCancelTime.toString()).before(new Date())) {
                rulesVO.setCanCancel(false);//设置不能取消
                return rulesVO;
            }
        }

        if (rulesVO.getLastCancelHours() != null) {
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();//当前时间

            calendar1.setTime(minAssignTime);//服务时间

            int hours = (int) (((long) (calendar1.getTime().getTime() - calendar2.getTime().getTime())) / 1000 / 3600);
            if (hours < rulesVO.getLastCancelHours()) {//如果服务时间减去当前时间 小于 取消小时数，设置需要扣款
                rulesVO.setNeedDebit(true);
                rulesVO.setCancelCalcFee(rulesVO.getCancelCalcFee());
            }
        }
        return rulesVO;
    }

    /**
     * 统计酒店销售额
     *
     * @param orderQO
     * @return
     */
    @Override
    public ReturnObject<HotelOrderSaleVO> searchHotelOrderSale(OrderQO orderQO) {
        logger.info("call searchHotelOrderSale({\"OrderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "})");
        ReturnObject<HotelOrderSaleVO> ret = new ReturnObject();
        List<HotelOrderSaleVO> hotelOrderSaleVOList = new ArrayList<>();
        HotelOrderSaleVO hotelOrderSaleVO = null;

        try {
            ParamObject paramObject = new ParamObject();
            if (orderQO != null) {
                paramObject.setPageNo(orderQO.getPageNo());
                paramObject.setPageSize(orderQO.getPageSize());
                paramObject.add("year", orderQO.getYear());
                paramObject.add("month", orderQO.getMonth());
                paramObject.add("billType", orderQO.getBillType());
                paramObject.add("statusList", orderQO.getStatusList());
                paramObject.add("deleteFlag", Constants.DELETE_FLAG_FALSE);
            }

            List<HotelOrderSale> list = orderManager.searchHotelOrderSale(paramObject);
            for (HotelOrderSale hotelOrderSale : list) {
                hotelOrderSaleVO = new HotelOrderSaleVO();
                BeanUtils.copyProperties(hotelOrderSale, hotelOrderSaleVO);
                hotelOrderSaleVOList.add(hotelOrderSaleVO);
            }


            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setDataList(hotelOrderSaleVOList);
            ret.setTotalSize(paramObject.getTotalNum());
        } catch (BeansException e) {
            e.printStackTrace();
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询报表列表失败");
        }
        return ret;
    }


    /**
     * 积分报表查询
     *
     * @param orderQO
     * @return
     */
    @Override
    public ReturnObject<OrderPointVO> searchpointListJson(OrderQO orderQO) {
        logger.info("call searchpointListJson({\"OrderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "})");
        List<OrderPointVO> orderPointVOList = new ArrayList<>();
        ReturnObject returnObject = null;
        try {
            returnObject = new ReturnObject();
            ParamObject paramObject = new ParamObject();
            paramObject.add("payMethod", orderQO.getPayMethod());
            paramObject.add("pageNo", orderQO.getPageNo());
            paramObject.add("pageSize", orderQO.getPageSize());
            paramObject.add("beginTime", orderQO.getBeginTime());
            paramObject.add("endTime", orderQO.getEndTime());
            paramObject.add("keyword", orderQO.getKeyword());
            List<Map<String, Object>> pointListJson = orderItemsManager.searchPointListJson(paramObject);
            if (pointListJson != null && pointListJson.size() > 0) {
                for (Map<String, Object> map : pointListJson) {
                    OrderPointVO orderPointVO = new OrderPointVO();
                    for (String key : map.keySet()) {
                        if (key.equals("rate")) {
                            orderPointVO.setRate(map.get(key) + "");
                        } else if (key.equals("amount")) {
                            orderPointVO.setAmount((BigDecimal) map.get(key));
                        } else if (key.equals("hotelId")) {
                            orderPointVO.setHotelId(map.get(key) + "");
                        } else if (key.equals("bizDate")) {
                            orderPointVO.setBizDate(map.get(key) + "");
                        }
                    }
                    orderPointVOList.add(orderPointVO);
                }
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            }
            returnObject.setTotalSize(paramObject.getTotalNum());
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setDataList(orderPointVOList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }

    /**
     * 城家订单保存
     *
     * @param orderVO
     * @return
     */
    @Override
    public ReturnObject<OrderVO> saveOrder(OrderVO orderVO) {
        logger.info("call saveOrder({\"orderVO\":" + JsonUtil.JSON_Bean2String(orderVO) + "})");
        ReturnObject returnObject = new ReturnObject();
        Order order = new Order();
        try {
            CopyBeanUtil.copyPropertiesIgnoreNull(orderVO, order);
            List<com.huazhu.hvip.order.ord.model.Service> serviceList = new ArrayList<>();
            List<ServiceVO> serviceVOList = orderVO.getServiceVOList();
            if (CheckUtil.checkListIsNull(serviceVOList)) {
                for (ServiceVO serviceVO : serviceVOList) {
                    com.huazhu.hvip.order.ord.model.Service service = new com.huazhu.hvip.order.ord.model.Service();
                    CopyBeanUtil.copyPropertiesIgnoreNull(serviceVO, service);
                    serviceList.add(service);
                }
            }
            List<OrderItemsVO> orderItemsVOList = orderVO.getOrderItemsVOList();
            List<OrderItems> orderItemsList = new ArrayList<>();
            final List<Long> goodsIdList = new ArrayList<>();
            for (OrderItemsVO orderItemsVO : orderItemsVOList) {
                OrderItems orderItems = new OrderItems();
                CopyBeanUtil.copyPropertiesIgnoreNull(orderItemsVO, orderItems);
                goodsIdList.add(orderItems.getGoodsId());
                orderItemsList.add(orderItems);
            }
            OrderAction orderAction = setOrderActionParam(orderVO, null);
            Payment payment = setPaymentParam(Constants.ASSTYPE_WECHATJSAPI, orderVO);
            Paymentlog paymentlog = setPaymentLog(order);
            ParamObject paramObject = new ParamObject();
            paramObject.add("serviceList", serviceList);
            paramObject.add("order", order);
            paramObject.add("orderItemsList", orderItemsList);
            paramObject.add("orderAction", orderAction);
            paramObject.add("payment", payment);
            paramObject.add("paymentlog", paymentlog);
            order = orderManager.saveOrder(paramObject);
            CopyBeanUtil.copyPropertiesIgnoreNull(order, orderVO);
            returnObject.setData(orderVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    goodsService.addGoodsOrderCount(goodsIdList);
                }
            });
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call saveOrder error({})", e);
        }
        return returnObject;
    }


    /**
     * 查询订单
     *
     * @param orderSn
     * @return
     */
    @Override
    public ReturnObject<OrderVO> getOrderDetailByOrderSn(String orderSn) {
        logger.info("call getOrderDetailByOrderSn({\"orderSn\":" + orderSn + "})");
        ReturnObject returnObject = new ReturnObject();
        orderSn = ParamsFilterUtil.cleanXSS(orderSn);
        try {
            if (StringUtils.isNotBlank(orderSn)) {
                QueryModel queryModel = new QueryModel();
                queryModel.addColumnValueCondition("orderSn", orderSn);
                List<Order> orderList = orderManager.search(queryModel);
                if (CheckUtil.checkListIsNull(orderList)) {
                    Order order = orderList.get(0);
                    OrderVO orderVO = new OrderVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(order, orderVO);
                    returnObject.setData(orderVO);
                    returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                }
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call getOrderDetailByOrderSn error({})");
        }
        return returnObject;
    }


    /**
     * 扭转订单状态
     *
     * @param orderVO
     * @return
     */
    @Override
    public ReturnObject<OrderVO> reverseOrder(OrderVO orderVO) {
        logger.info("call reverseOrder({\"orderVO\":" + JsonUtil.JSON_Bean2String(orderVO) + "})");
        ReturnObject<OrderVO> returnObject = new ReturnObject<>();
        try {
            if (orderVO == null) {
                returnObject.setReturnMsg("扭转订单失败");
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                return returnObject;
            }
            List<Order> orderList = null;
            if (StringUtils.isNotBlank(orderVO.getOrderSn())) {
                QueryModel queryModel = new QueryModel();
                queryModel.addColumnValueCondition("orderSn", orderVO.getOrderSn());
                orderList = orderManager.search(queryModel);//查询订单
            }

            if (!CheckUtil.checkListIsNull(orderList)) {
                returnObject.setReturnMsg("扭转订单失败,查不到该订单");
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                return returnObject;
            }
            String newStatus = orderVO.getStatus();
            Order order = orderList.get(0);
            String oldStatus = order.getStatus();
            boolean flag = verifyStatus(oldStatus, newStatus);//订单状态校验
            boolean serviceFlag = false;
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("orderId", order.getOrderId());
            List<com.huazhu.hvip.order.ord.model.Service> serviceList = serviceManager.search(queryModel);//查询工单
            Date nowDate = new Date();
            if (CheckUtil.checkListIsNull(serviceList)) {
                for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                    newStatus = orderVO.getServiceStatus();
                    oldStatus = service.getStatus();
                    serviceFlag = verifyServiceStatus(oldStatus, newStatus);//工单状态校验
                    service.setStatus(orderVO.getServiceStatus());
                    service.setUpdateTime(nowDate);
                    service.setUpdateUser(orderVO.getUpdateUser());
                }
            } else {
                serviceFlag = true;
            }
            if (flag && serviceFlag) {
                ParamObject paramObject = new ParamObject();
                OrderAction orderAction = setOrderActionParam(orderVO, order);
                paramObject.add("orderAction", orderAction);
                paramObject.add("serviceList", serviceList);
                order.setPayStatus(orderVO.getPayStatus());
                order.setStatus(newStatus);
                order.setUpdateTime(nowDate);
                order.setUpdateUser(orderVO.getUpdateUser());
                paramObject.add("order", order);
                queryModel = new QueryModel();
                queryModel.addColumnValueCondition("orderId", order.getOrderId());
                List<OrderItems> orderItemsList = orderItemsManager.search(queryModel);
                if (CheckUtil.checkListIsNull(orderItemsList)) {
                    for (OrderItems orderItems : orderItemsList) {
                        orderItems.setStatus(newStatus);
                        orderItems.setUpdateTime(nowDate);
                        orderItems.setUpdateUser(orderVO.getUpdateUser());
                    }
                    paramObject.add("orderItemsList", orderItemsList);
                }
                Payment payment = new Payment();
                if (Constants.ORDER_STATUS_WAITSERVICE.equals(newStatus)) {
                    List<Payment> paymentList = paymentManager.search(queryModel);
                    if (CheckUtil.checkListIsNull(paymentList)) {
                        payment = paymentList.get(0);
                        payment.setStatus(Constants.PAYMENT_STATUS_PAID);//扭转支付单
                        payment.setUpdateTime(nowDate);
                        payment.setUpdateUser(orderVO.getUpdateUser());
                        paramObject.add("payment", payment);
                    }
                    Paymentlog paymentlog = setPaymentLog(order);
                    paramObject.add("paymentlog", paymentlog);
                }
                order = orderManager.saveOrder(paramObject);
                if ((Constants.ORDER_STATUS_WAITSERVICE.equals(order.getStatus())
                        || Constants.ORDER_STATUS_REFUNDED.equals(order.getStatus()))
                        && Constants.PAYMENT_STATUS_PAID.equals(order.getPayStatus())) {
                    MemberVO memberVO = setMemberVOPoint(order, payment);
                    memberService.saveWechatMember(memberVO);
                }
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("状态错误无法扭转");
                return returnObject;
            }
            CopyBeanUtil.copyPropertiesIgnoreNull(order, orderVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setData(orderVO);
        } catch (Exception e) {
            logger.info("call reverseOrder error({})", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }

    /**
     * 查询订单下的工单
     *
     * @param orderQO
     * @return
     */
    @Override
    public ReturnObject<OrderVO> getOrderServiceByOrderQO(OrderQO orderQO) {
        logger.info("call getOrderServiceByOrderId({\"orderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "})");
        List<ServiceVO> serviceVOList = new ArrayList<>();
        ReturnObject returnObject = new ReturnObject();
        try {
            Order order = orderManager.get(orderQO.getOrderId());
            if (order != null) {
                OrderVO orderVO = new OrderVO();
                List<Long> cleanIdList = new ArrayList<>();
                CopyBeanUtil.copyPropertiesIgnoreNull(order, orderVO);
                QueryModel queryModel = new QueryModel();
                if (StringUtils.isNotBlank(orderQO.getServiceStatus())) {
                    queryModel.addHqlCondition(" status in(" + orderQO.getServiceStatus() + ")");
                }
                queryModel.addColumnValueCondition("orderId", order.getOrderId());
                List<com.huazhu.hvip.order.ord.model.Service> serviceList = serviceManager.search(queryModel);
                if (CheckUtil.checkListIsNull(serviceList)) {
                    for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                        ServiceVO serviceVO = new ServiceVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
                        serviceVOList.add(serviceVO);
                        String cleanId = serviceVO.getCleanId();
                        if (StringUtils.isNotBlank(cleanId)) {
                            String[] cleanIdArray = StringUtils.split(cleanId, ",");
                            for (int i = 0; i < cleanIdArray.length; i++) {
                                cleanIdList.add(Long.valueOf(cleanIdArray[i]));
                            }
                        }
                    }
                    orderVO.setServiceVOList(serviceVOList);
                }
                if (CheckUtil.checkListIsNull(cleanIdList)) {
                    CleanerQO cleanerQO = new CleanerQO();
                    cleanerQO.setCleanIdList(cleanIdList);
                    returnObject = cleanerService.listJson(cleanerQO);
                    Map<Long, CleanerVO> cleanerVOMap = new HashMap<>();
                    if (Constants.RETURN_CODE_SUCCESS.equals(returnObject.getReturnCode())) {
                        List<CleanerVO> cleanerVOList = returnObject.getDataList();
                        if (CheckUtil.checkListIsNull(cleanerVOList)) {
                            for (CleanerVO cleanerVO : cleanerVOList) {
                                cleanerVOMap.put(cleanerVO.getCleanId(), cleanerVO);
                            }
                        }
                    }
                    for (ServiceVO serviceVO : serviceVOList) {
                        List<CleanerVO> cleanerVOList = new ArrayList<>();
                        String cleanId = serviceVO.getCleanId();
                        if (StringUtils.isNotBlank(cleanId)) {
                            String[] cleanIdArray = StringUtils.split(cleanId, ",");
                            for (int i = 0; i < cleanIdArray.length; i++) {
                                CleanerVO cleanerVO = cleanerVOMap.get(Long.valueOf(cleanIdArray[i]));
                                if (cleanerVO != null) {
                                    cleanerVOList.add(cleanerVO);
                                }
                            }
                        }
                        serviceVO.setCleanerVOList(cleanerVOList);
                    }
                }
                queryModel = new QueryModel();
                queryModel.addColumnValueCondition("orderId", order.getOrderId());
                List<OrderItems> orderItemsList = orderItemsManager.search(queryModel);
                if (CheckUtil.checkListIsNull(orderItemsList)) {
                    List<OrderItemsVO> orderItemsVOList = new ArrayList<>();
                    for (OrderItems orderItems : orderItemsList) {
                        OrderItemsVO orderItemsVO = new OrderItemsVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(orderItems, orderItemsVO);
                        orderItemsVOList.add(orderItemsVO);
                    }
                    orderVO.setOrderItemsVOList(orderItemsVOList);
                }
                returnObject.setData(orderVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call getOrderServiceByOrderId error({})", e);
        }
        return returnObject;
    }


    /**
     * 查询工单列表
     *
     * @param orderQO
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> serviceListJson(OrderQO orderQO) {
        logger.info("call serviceListJson({\"orderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        QueryModel queryModel = new QueryModel();
        List<ServiceVO> serviceVOList = new ArrayList<>();
        queryModel.addColumnValueCondition("orderId", orderQO.getOrderId());
        try {
            if (orderQO.getPageNo() != null && orderQO.getPageSize() != null) {
                queryModel.setPageNo(orderQO.getPageNo());
                queryModel.setPageSize(orderQO.getPageSize());
                queryModel.setSortHql(" createTime desc");
                List<com.huazhu.hvip.order.ord.model.Service> serviceList = serviceManager.search(queryModel);
                if (CheckUtil.checkListIsNull(serviceList)) {
                    for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                        ServiceVO serviceVO = new ServiceVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
                        serviceVOList.add(serviceVO);
                    }
                }
            }
            returnObject.setDataList(serviceVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setTotalSize(queryModel.getTotalNum());
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call serviceListJson error({})", e);
        }
        return returnObject;
    }

    /**
     * 分配工单员工
     *
     * @param serviceVO
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> addServiceCleaner(ServiceVO serviceVO) {
        logger.info("call addserviceCleaner({\"orderQO\":" + JsonUtil.JSON_Bean2String(serviceVO) + "})");
        ReturnObject returnObject = null;
        try {
            returnObject = new ReturnObject();
            com.huazhu.hvip.order.ord.model.Service service = serviceManager.get(serviceVO.getServiceId());
            CleanerQO cleanerQO = new CleanerQO();
            List<Long> cleanIdList = new ArrayList<>();
            CopyBeanUtil.copyPropertiesIgnoreNull(serviceVO, service);
            String cleanIds = serviceVO.getCleanIds();
            service.setCleanId(cleanIds);
            String[] cleanIdArray = StringUtils.split(cleanIds, ",");
            for (Integer i = 0; i < cleanIdArray.length; i++) {
                cleanIdList.add(Long.valueOf(cleanIdArray[i]));
            }
            cleanerQO.setCleanIdList(cleanIdList);
            returnObject = cleanerService.listJson(cleanerQO);
            if (Constants.RETURN_CODE_SUCCESS.equals(returnObject.getReturnCode())) {
                List<CleanerVO> cleanerVOList = (List<CleanerVO>) returnObject.getDataList();
                List<Serviceitem> serviceitemList = new ArrayList<>();
                List<String> cleanNameList = new ArrayList<>();
                Date date = new Date();
                if (CheckUtil.checkListIsNull(cleanerVOList)) {
                    for (CleanerVO cleanerVO : cleanerVOList) {
                        Serviceitem serviceitem = new Serviceitem();
                        serviceitem.setServiceId(service.getServiceId());
                        serviceitem.setCleanId(cleanerVO.getCleanId());
                        serviceitem.setCleanName(cleanerVO.getName());
                        cleanNameList.add(cleanerVO.getName());
                        serviceitem.setStatus(serviceVO.getStatus());
                        serviceitem.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
                        serviceitem.setCreateTime(date);
                        serviceitem.setUpdateTime(date);
                        serviceitem.setCreateUser(service.getCreateUser());
                        serviceitem.setUpdateUser(serviceVO.getUpdateUser());
                        serviceitemList.add(serviceitem);
                    }
                }
                if (CheckUtil.checkListIsNull(cleanNameList)) {
                    service.setCleanName(StringUtils.join(cleanNameList, ","));
                }
                ParamObject paramObject = new ParamObject();
                paramObject.add("service", service);
                paramObject.add("serviceitemList", serviceitemList);
                service = orderManager.saveServiceItem(paramObject);
                serviceVO = new ServiceVO();
                CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
                returnObject = new ReturnObject();
                returnObject.setData(serviceVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            } else {
                return returnObject;
            }
        } catch (Exception e) {
            logger.error("call addserviceCleaner error({})", e);
        }
        return returnObject;
    }


    /**
     * 查询订单
     *
     * @param orderQO
     * @return
     */
    @Override
    public ReturnObject<OrderVO> getOrderListByQO(OrderQO orderQO) {
        logger.info("call getOrderListByQO({\"orderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        List<OrderVO> orderVOList = new ArrayList<>();
        QueryModel queryModel = new QueryModel();
        try {
            queryModel.addColumnValueCondition("memberId", orderQO.getMemberId());
            queryModel.addColumnValueCondition("status", orderQO.getStatus());
            queryModel.addColumnValueCondition("orderSn", orderQO.getOrderSn());
            queryModel.addColumnValueCondition("orderId", orderQO.getOrderId());
            List<Order> orderList = orderManager.search(queryModel);
            if (CheckUtil.checkListIsNull(orderList)) {
                for (Order order : orderList) {
                    OrderVO orderVO = new OrderVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(order, orderVO);
                    orderVOList.add(orderVO);
                }
            }
            returnObject.setDataList(orderVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call getOrderListByQO error({})", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }


    /**
     * 周期添加工单
     *
     * @param serviceVOs
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> saveServiceVo(List<ServiceVO> serviceVOs) {
        logger.info("call saveServiceVo({\"serviceVOs\":" + JsonUtil.JSON_List2String(serviceVOs) + "})");
        ReturnObject returnObject = new ReturnObject();
        ParamObject paramObject = new ParamObject();
        List<com.huazhu.hvip.order.ord.model.Service> services = new ArrayList<>();
        for (ServiceVO serviceVO : serviceVOs) {
            com.huazhu.hvip.order.ord.model.Service service = new com.huazhu.hvip.order.ord.model.Service();
            CopyBeanUtil.copyPropertiesIgnoreNull(serviceVO, service);
            services.add(service);
        }
        paramObject.add("services", services);
        try {
            List<com.huazhu.hvip.order.ord.model.Service> serviceList = orderManager.saveServiceVos(paramObject);
            if (CheckUtil.checkListIsNull(serviceList)) {
                List<ServiceVO> serviceVOList = new ArrayList<>();
                for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                    ServiceVO serviceVO = new ServiceVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
                    serviceVOList.add(serviceVO);
                }
                returnObject.setDataList(serviceVOList);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call saveServiceVo error({})", e);
        }
        return returnObject;
    }


    /**
     * 用户取消工单
     *
     * @param serviceVO
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> cancelOrderService(ServiceVO serviceVO) {
        logger.info("call cancelOrderService({\"serviceVO\":" + JsonUtil.JSON_Bean2String(serviceVO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            if (serviceVO != null && serviceVO.getServiceId() != null) {
                com.huazhu.hvip.order.ord.model.Service service = serviceManager.get(serviceVO.getServiceId());
                String newStatus = serviceVO.getStatus();
                String oldStatus = service.getStatus();
                if (verifyServiceStatus(oldStatus, newStatus)) {
                    CopyBeanUtil.copyPropertiesIgnoreNull(serviceVO, service);
                    QueryModel queryModel = new QueryModel();
                    queryModel.addColumnValueCondition("serviceId", service.getServiceId());
                    List<Serviceitem> serviceitemList = serviceitemManager.search(queryModel);
                    if (CheckUtil.checkListIsNull(serviceitemList)) {
                        for (Serviceitem serviceitem : serviceitemList) {
                            serviceitem.setStatus(service.getStatus());
                            serviceitem.setUpdateTime(service.getUpdateTime());
                            serviceitem.setUpdateUser(service.getUpdateUser());
                        }
                    }
                    ParamObject paramObject = new ParamObject();
                    paramObject.add("service", service);
                    paramObject.add("serviceitemList", serviceitemList);
                    service = serviceManager.updateOrderService(paramObject);
                    CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
                    returnObject.setData(serviceVO);
                    returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                } else {
                    returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                    returnObject.setReturnMsg("扭转工单状态失败");
                }
            }
        } catch (Exception e) {
            logger.info("call cancelOrderService error({})", e);
        }
        return returnObject;
    }

    /**
     * 查询保洁员下的工单
     *
     * @param serviceQO
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> getOrderServiceByCleanMobile(ServiceQO serviceQO) {
        logger.info("call getOrderServiceByClean({\"serviceQO\":" + JsonUtil.JSON_Bean2String(serviceQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        List<ServiceVO> serviceVOList = new ArrayList<>();
        try {
            QueryModel queryModel = new QueryModel();
            if (StringUtils.isNotBlank(serviceQO.getCleanId())) {
                queryModel.addColumnValueCondition("cleanId", serviceQO.getCleanId());
                queryModel.addColumnValueCondition("status", serviceQO.getStatus());
                if (CheckUtil.checkListIsNull(serviceQO.getStatusList())) {
                    String status = StringUtils.join(serviceQO.getStatusList(), ",");
                    if (StringUtils.isNotBlank(status)) {
                        queryModel.addHqlCondition(" status in(" + status + ")");
                    }
                }
                List<Serviceitem> serviceitemList = serviceitemManager.search(queryModel);
                Map<Long, List<ServiceVO>> serviceMap = new HashMap<>();
                List<Long> orderIdList = new ArrayList<>();
                if (CheckUtil.checkListIsNull(serviceitemList)) {
                    List<Long> serviceIdList = new ArrayList<>();
                    for (Serviceitem serviceitem : serviceitemList) {
                        serviceIdList.add(serviceitem.getServiceId());
                    }
                    if (CheckUtil.checkListIsNull(serviceIdList)) {
                        String ids = StringUtils.join(serviceIdList, ",");
                        if (StringUtils.isNotBlank(ids)) {
                            queryModel = new QueryModel();
                            queryModel.addHqlCondition(" serviceId in(" + ids + ")");
                            queryModel.setSortHql(" serviceTime asc");
                            List<com.huazhu.hvip.order.ord.model.Service> serviceList = serviceManager.search(queryModel);
                            if (CheckUtil.checkListIsNull(serviceList)) {
                                for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                                    ServiceVO serviceVO = new ServiceVO();
                                    CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
                                    serviceVOList.add(serviceVO);
                                    orderIdList.add(service.getOrderId());
                                    List<ServiceVO> serviceVOs = serviceMap.get(service.getOrderId());
                                    if (CheckUtil.checkListIsNull(serviceVOs)) {
                                        serviceVOs.add(serviceVO);
                                        serviceMap.put(service.getOrderId(), serviceVOs);
                                    } else {
                                        serviceVOs = new ArrayList<>();
                                        serviceVOs.add(serviceVO);
                                        serviceMap.put(service.getOrderId(), serviceVOs);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CheckUtil.checkListIsNull(orderIdList)) {
                    queryModel = new QueryModel();
                    queryModel.addHqlCondition(" orderId in(" + StringUtils.join(orderIdList, ",") + ")");
                    List<Order> orderList = orderManager.search(queryModel);
                    for (Order order : orderList) {
                        List<ServiceVO> serviceVOs = serviceMap.get(order.getOrderId());
                        if (CheckUtil.checkListIsNull(serviceVOs)) {
                            for (ServiceVO serviceVO : serviceVOList) {
                                serviceVO.setCycle(order.getCycle());
                            }
                        }
                    }
                }
            }
            returnObject.setDataList(serviceVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call getOrderServiceByClean error({})", e);
        }
        return returnObject;
    }

    /**
     * 查询员工工单
     *
     * @param serviceQO
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> getOrderServiceByMemberMobile(ServiceQO serviceQO) {
        logger.info("call getOrderServiceByClean({\"serviceQO\":" + JsonUtil.JSON_Bean2String(serviceQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        List<ServiceVO> serviceVOList = new ArrayList<>();
        try {
            QueryModel queryModel = new QueryModel();
            if (StringUtils.isNotBlank(serviceQO.getCleanId())) {
                queryModel.addColumnValueCondition("cleanId", serviceQO.getCleanId());
                List<Serviceitem> serviceitemList = serviceitemManager.search(queryModel);
                if (CheckUtil.checkListIsNull(serviceitemList)) {
                    List<Long> serviceIdList = new ArrayList<>();
                    for (Serviceitem serviceitem : serviceitemList) {
                        serviceIdList.add(serviceitem.getServiceId());
                    }
                    if (CheckUtil.checkListIsNull(serviceIdList)) {
                        String ids = StringUtils.join(serviceIdList, ",");
                        if (StringUtils.isNotBlank(ids)) {
                            queryModel = new QueryModel();
                            queryModel.addHqlCondition(" serviceId in(" + ids + ")");
                            List<com.huazhu.hvip.order.ord.model.Service> serviceList = serviceManager.search(queryModel);
                            if (CheckUtil.checkListIsNull(serviceList)) {
                                for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                                    ServiceVO serviceVO = new ServiceVO();
                                    CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
                                    serviceVOList.add(serviceVO);
                                }
                            }
                        }
                    }
                }
            }
            returnObject.setDataList(serviceVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call getOrderServiceByClean error({})", e);
        }
        return returnObject;
    }

    /**
     * 保洁员上下班
     *
     * @param serviceVO
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> updateCleanerService(ServiceVO serviceVO) {
        ReturnObject returnObject = new ReturnObject();
        logger.info("call getOrderServiceBySn({\"serviceVO\":" + JsonUtil.JSON_Bean2String(serviceVO) + "})");
        try {
            if (StringUtils.isNotBlank(serviceVO.getServiceSn())) {
                QueryModel queryModel = new QueryModel();
                queryModel.addColumnValueCondition("serviceSn", serviceVO.getServiceSn());
                List<com.huazhu.hvip.order.ord.model.Service> serviceList = serviceManager.search(queryModel);
                if (CheckUtil.checkListIsNull(serviceList)) {
                    com.huazhu.hvip.order.ord.model.Service service = serviceList.get(0);
                    if (!StringUtils.contains(service.getCleanId(), serviceVO.getCleanId())) {
                        returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                        returnObject.setReturnMsg("查不到工单");
                        return returnObject;
                    }
                    if (!verifyServiceStatus(service.getStatus(), serviceVO.getStatus())) {
                        returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                        returnObject.setReturnMsg("工单状态扭转失败");
                        return returnObject;
                    }
                    Order order = orderManager.get(service.getOrderId());
                    String newStatus = null;
                    String oldStatus = order.getStatus();
                    if (Constants.SERVICE_STATUS_SERVICING.equals(serviceVO.getStatus())) {
                        newStatus = Constants.ORDER_STATUS_SERVICING;
                    } else if (Constants.SERVICE_STATUS_DON.equals(serviceVO.getStatus())) {//最后一次完成才扭转状态
                        order.setFinishService(order.getFinishService() + 1);
                        order.setWaitServiceCount(order.getWaitServiceCount() - 1);
                        if (order.getFinishService() == order.getTotalServiceCount()) {
                            newStatus = Constants.ORDER_STATUS_DON;
                        } else {
                            newStatus = oldStatus;
                        }

                    } else {
                        newStatus = oldStatus;
                    }
                    if (!verifyStatus(oldStatus, newStatus)) {
                        returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                        returnObject.setReturnMsg("订单状态扭转失败");
                        return returnObject;
                    }
                    order.setStatus(newStatus);
                    order.setUpdateTime(serviceVO.getUpdateTime());
                    order.setUpdateUser(serviceVO.getUpdateUser());
                    OrderAction orderAction = setOrderActionParam(order, oldStatus, newStatus);
                    CopyBeanUtil.copyPropertiesIgnoreNull(serviceVO, service);
                    queryModel = new QueryModel();
                    queryModel.addColumnValueCondition("orderId", order.getOrderId());
                    List<OrderItems> orderItemsList = orderItemsManager.search(queryModel);
                    if (CheckUtil.checkListIsNull(orderItemsList)) {
                        for (OrderItems orderItems : orderItemsList) {
                            orderItems.setStatus(newStatus);
                            orderItems.setUpdateTime(serviceVO.getUpdateTime());
                            orderItems.setUpdateUser(serviceVO.getUpdateUser());
                        }
                    }
                    ParamObject p = new ParamObject();
                    p.add("orderItemsList", orderItemsList);
                    p.add("orderAction", orderAction);
                    p.add("order", order);
                    p.add("service", service);
                    serviceManager.updateBeginService(p);
                }
            }
            returnObject.setData(serviceVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call getOrderServiceBySn error({})", e);
        }
        return returnObject;
    }

    /**
     * 取消订单
     *
     * @param orderVOList
     * @return
     */
    @Override
    public ReturnObject<OrderVO> cancelOrderVO(List<OrderVO> orderVOList) {
        logger.info("call cancelOrderVO({\"orderVOList\":" + JsonUtil.JSON_List2String(orderVOList) + "})");
        ReturnObject returnObject = new ReturnObject();
        Map<Long, OrderVO> orderVOMap = new HashMap<>();
        List<OrderAction> orderActionList = new ArrayList<>();
        try {
            List<Long> orderIdList = new ArrayList<>();
            if (CheckUtil.checkListIsNull(orderVOList)) {
                for (OrderVO orderVO : orderVOList) {
                    orderIdList.add(orderVO.getOrderId());
                    orderVOMap.put(orderVO.getOrderId(), orderVO);
                }
            }
            ParamObject paramObject = new ParamObject();
            if (CheckUtil.checkListIsNull(orderIdList)) {
                QueryModel queryModel = new QueryModel();
                queryModel.addHqlCondition(" orderId in (" + StringUtils.join(orderIdList, ",") + ")");
                List<Order> orderList = orderManager.search(queryModel);
                for (Order order : orderList) {
                    OrderVO orderVO = orderVOMap.get(order.getOrderId());
                    if (orderVO != null) {
                        String newStatus = orderVO.getStatus();
                        String oldStatus = order.getStatus();
                        if (!verifyStatus(oldStatus, newStatus)) {
                            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                            returnObject.setReturnMsg("扭转订单失败");
                            return returnObject;
                        }
                        OrderAction orderAction = setOrderActionParam(orderVO, order);
                        orderActionList.add(orderAction);
                        CopyBeanUtil.copyPropertiesIgnoreNull(orderVO, order);
                    }
                }
                paramObject.add("orderList", orderList);
                List<OrderItems> orderItemsList = orderItemsManager.search(queryModel);
                for (OrderItems orderItems : orderItemsList) {
                    OrderVO orderVO = orderVOMap.get(orderItems.getOrderId());
                    if (orderVO != null) {
                        orderItems.setStatus(orderVO.getStatus());
                        orderItems.setUpdateTime(orderVO.getUpdateTime());
                        orderItems.setUpdateUser(orderVO.getUpdateUser());
                    }
                }
                paramObject.add("orderItemsList", orderItemsList);
                paramObject.add("orderActionList", orderActionList);
                List<com.huazhu.hvip.order.ord.model.Service> serviceList = serviceManager.search(queryModel);
                List<Long> serviceIdList = new ArrayList<>();
                if (CheckUtil.checkListIsNull(serviceList)) {
                    for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                        OrderVO orderVO = orderVOMap.get(service.getOrderId());
                        if (orderVO != null) {
                            if (!verifyServiceStatus(service.getStatus(), orderVO.getServiceStatus())) {
                                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                                returnObject.setReturnMsg("扭转工单失败");
                                return returnObject;
                            }
                            serviceIdList.add(service.getServiceId());
                            service.setStatus(orderVO.getServiceStatus());
                            service.setUpdateUser(orderVO.getUpdateUser());
                            service.setUpdateTime(orderVO.getUpdateTime());
                        }
                    }
                    if (CheckUtil.checkListIsNull(serviceList)) {
                        String ids = StringUtils.join(serviceIdList, ",");
                        queryModel = new QueryModel();
                        queryModel.addHqlCondition(" serviceId in(" + ids + ")");
                        List<Serviceitem> serviceitemList = serviceitemManager.search(queryModel);
                        paramObject.add("serviceitemList", serviceitemList);
                    }
                    paramObject.add("serviceList", serviceList);
                }
                List<Order> orders = orderManager.updateCancelOrder(paramObject);
                orderVOList = new ArrayList<>();
                for (Order order : orders) {
                    OrderVO orderVO = new OrderVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(order, orderVO);
                    orderVOList.add(orderVO);
                }
                returnObject.setDataList(orderVOList);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call cancelOrderVO error({})", e);
        }
        return returnObject;
    }

    /**
     * 退款
     *
     * @param orderVO
     * @return
     */
    @Override
    public ReturnObject<OrderVO> refundOrderVO(OrderVO orderVO) {
        logger.info("call refundOrderVO({\"orderVO\":" + JsonUtil.JSON_Bean2String(orderVO) + "})");
        ReturnObject returnObject = new ReturnObject();
        ParamObject paramObject = new ParamObject();
        try {
            Order order = orderManager.get(orderVO.getOrderId());
            if (!verifyStatus(order.getStatus(), orderVO.getStatus())) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("扭转订单失败");
                return returnObject;
            }
            OrderAction orderAction = setOrderActionParam(orderVO, order);
            CopyBeanUtil.copyPropertiesIgnoreNull(orderVO, order);
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("orderId", order.getOrderId());
            List<OrderItems> orderItemsList = orderItemsManager.search(queryModel);
            for (OrderItems orderItems : orderItemsList) {
                orderItems.setStatus(orderVO.getStatus());
                orderItems.setUpdateTime(orderVO.getUpdateTime());
                orderItems.setUpdateUser(orderVO.getUpdateUser());
            }
            RefundLogsVO refundLogsVO = orderVO.getRefundLogsVO();
            RefundLogs refundLogs = new RefundLogs();
            CopyBeanUtil.copyPropertiesIgnoreNull(refundLogsVO, refundLogs);
            paramObject.add("order", order);
            paramObject.add("orderItemsList", orderItemsList);
            paramObject.add("orderAction", orderAction);
            paramObject.add("refundLogs", refundLogs);
            queryModel.addHqlCondition(" status in(" + Constants.SERVICE_STATUS_PAY + "," + Constants.SERVICE_STATUS_WAITSERVICE + ")");
            List<com.huazhu.hvip.order.ord.model.Service> serviceList = serviceManager.search(queryModel);
            if (CheckUtil.checkListIsNull(serviceList)) {
                List<Long> serviceIdList = new ArrayList<>();
                for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                    service.setStatus(Constants.SERVICE_STATUS_CAL);
                    service.setUpdateTime(orderVO.getUpdateTime());
                    service.setUpdateUser(orderVO.getUpdateUser());
                    serviceIdList.add(service.getServiceId());
                }
                paramObject.add("serviceList", serviceList);
                if (CheckUtil.checkListIsNull(serviceIdList)) {
                    String ids = StringUtils.join(serviceIdList, ",");
                    queryModel = new QueryModel();
                    queryModel.addHqlCondition(" serviceId in(" + ids + ")");
                    List<Serviceitem> serviceitemList = serviceitemManager.search(queryModel);
                    for (Serviceitem serviceitem : serviceitemList) {
                        serviceitem.setStatus(Constants.SERVICE_STATUS_CAL);
                        serviceitem.setUpdateTime(orderVO.getUpdateTime());
                        serviceitem.setUpdateUser(orderVO.getUpdateUser());
                    }
                    paramObject.add("serviceitemList", serviceitemList);
                }
            }
            order = orderManager.updateRefundOrder(paramObject);
            if ((Constants.ORDER_STATUS_WAITSERVICE.equals(order.getStatus())
                    || Constants.ORDER_STATUS_REFUNDED.equals(order.getStatus()))
                    && Constants.PAYMENT_STATUS_PAID.equals(order.getPayStatus())) {
                queryModel = new QueryModel();
                queryModel.addColumnValueCondition("orderId", order.getOrderId());
                Payment payment = paymentManager.getUniqueResult(queryModel);
                MemberVO memberVO = setMemberVOPoint(order, payment);
                memberService.saveWechatMember(memberVO);
            }
            orderVO = new OrderVO();
            CopyBeanUtil.copyPropertiesIgnoreNull(order, orderVO);
            returnObject.setData(orderVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call refundOrderVO error({})", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }


    /**
     * 获取特地工单
     *
     * @param serviceQO
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> getServiceVO(ServiceQO serviceQO) {
        logger.info("call getServiceVO({\"serviceQO\":" + JsonUtil.JSON_Bean2String(serviceQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            com.huazhu.hvip.order.ord.model.Service service = serviceManager.get(serviceQO.getServiceId());
            ServiceVO serviceVO = new ServiceVO();
            CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
            returnObject.setData(serviceVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call getServiceVO error({})", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }

    /**
     * @param serviceQO
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> getServiceAndGoods(ServiceQO serviceQO) {
        logger.info("call getServiceAndGoods({\"serviceQO\":" + JsonUtil.JSON_Bean2String(serviceQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("serviceSn", serviceQO.getServiceSn());
            queryModel.addColumnValueCondition("serviceId", serviceQO.getServiceId());
            com.huazhu.hvip.order.ord.model.Service service = serviceManager.getUniqueResult(queryModel);
            if (service != null) {
                returnObject = goodsService.getGoodsById(service.getGoodsId());
                if (Constants.RETURN_CODE_SUCCESS.equals(returnObject.getReturnCode())) {
                    GoodsVO goodsVO = (GoodsVO) returnObject.getData();
                    ServiceVO serviceVO = new ServiceVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
                    serviceVO.setGoodsVO(goodsVO);
                    returnObject.setData(serviceVO);
                    returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                }
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call getServiceAndGoods error({})", e);
        }
        return returnObject;
    }


    /**
     * 获取订单及工单信息
     *
     * @param orderQO
     * @return
     */
    @Override
    public ReturnObject<OrderVO> getOrderService(OrderQO orderQO) {
        logger.info("call getOrderService({\"orderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            List<OrderVO> orderVOList = new ArrayList<>();
            QueryModel queryModel = new QueryModel();
            Map<Long, List<String>> goodsNameMap = new HashMap<>();
            Map<Long, com.huazhu.hvip.order.ord.model.Service> serviceMap = new HashMap<>();
            queryModel.addColumnValueCondition("orderId", orderQO.getOrderId());
            queryModel.addColumnValueCondition("memberId", orderQO.getMemberId());
            queryModel.setSortHql(" FIELD(status,0,1,3,7,6,2,4,5) asc,orderId DESC");
            List<Order> orderList = orderManager.search(queryModel);
            List<Long> orderIdList = new ArrayList<>();
            List<String> goodsNameList = new ArrayList<>();
            if (CheckUtil.checkListIsNull(orderList)) {
                for (Order order : orderList) {
                    OrderVO orderVO = new OrderVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(order, orderVO);
                    orderVOList.add(orderVO);
                    orderIdList.add(order.getOrderId());
                }
            }
            if (CheckUtil.checkListIsNull(orderIdList)) {
                queryModel = new QueryModel();
                queryModel.addHqlCondition(" orderId in(" + StringUtils.join(orderIdList, ",") + ")");
                List<com.huazhu.hvip.order.ord.model.Service> serviceList = serviceManager.search(queryModel);
                if (CheckUtil.checkListIsNull(serviceList)) {
                    for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                        serviceMap.put(service.getOrderId(), service);
                    }
                    for (OrderVO orderVO : orderVOList) {
                        com.huazhu.hvip.order.ord.model.Service service = serviceMap.get(orderVO.getOrderId());
                        if (service != null) {
                            orderVO.setServiceAddress(service.getServiceAddress());
                            orderVO.setServiceName(service.getServiceName());
                            orderVO.setServiceMobile(service.getServiceMobile());
                        }
                    }
                }
                List<OrderItems> orderItemsList = orderItemsManager.search(queryModel);
                if (CheckUtil.checkListIsNull(orderItemsList)) {
                    for (OrderItems orderItems : orderItemsList) {
                        goodsNameList = goodsNameMap.get(orderItems.getOrderId());
                        if (CheckUtil.checkListIsNull(goodsNameList)) {
                            if (StringUtils.isNotBlank(orderItems.getGoodsName())) {
                                goodsNameList.add(orderItems.getGoodsName());
                                goodsNameMap.put(orderItems.getOrderId(), goodsNameList);
                            }
                        } else {
                            goodsNameList = new ArrayList<>();
                            goodsNameList.add(orderItems.getGoodsName());
                            goodsNameMap.put(orderItems.getOrderId(), goodsNameList);
                        }
                    }
                }
            }
            for (OrderVO orderVO : orderVOList) {
                goodsNameList = goodsNameMap.get(orderVO.getOrderId());
                if (CheckUtil.checkListIsNull(goodsNameList)) {
                    orderVO.setGoodsName(StringUtils.join(goodsNameList, ","));
                }
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setDataList(orderVOList);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.info("call getOrderService error({})", e);
        }
        return returnObject;
    }

    /**
     * 查询订单下的item
     *
     * @param orderQO
     * @return
     */
    @Override
    public ReturnObject<OrderItemsVO> searchOrderItemList(OrderQO orderQO) {
        logger.info("call searchOrderItemList({\"orderQO\":" + JsonUtil.JSON_Bean2String(orderQO) + "})");
        ReturnObject returnObject = null;
        try {
            returnObject = new ReturnObject();
            List<OrderItemsVO> orderItemsVOList = new ArrayList<>();
            QueryModel queryModel = new QueryModel();
            List<Long> orderIdList = new ArrayList<>();
            List<OrderItems> orderItemsList = new ArrayList<>();
            if (StringUtils.isNotBlank(orderQO.getMemberId()) && StringUtils.isNotBlank(orderQO.getBizType())) {
                queryModel.addColumnValueCondition("memberId", orderQO.getMemberId());
                queryModel.addColumnValueCondition("payStatus", Constants.PAYMENT_STATUS_PAID);
                queryModel.addHqlCondition(" status in(" + Constants.ORDER_STATUS_DON +
                        "," + Constants.ORDER_STATUS_WAITSERVICE + "," + Constants.ORDER_STATUS_SERVICING + ")");
                queryModel.addColumnValueCondition("bizScope", orderQO.getBizType());
                List<Order> orderList = orderManager.search(queryModel);
                if (CheckUtil.checkListIsNull(orderList)) {
                    for (Order order : orderList) {
                        orderIdList.add(order.getOrderId());
                    }
                }
                if (CheckUtil.checkListIsNull(orderIdList)) {
                    queryModel = new QueryModel();
                    queryModel.addHqlCondition(" orderId in(" + StringUtils.join(orderIdList, ",") + ")");
                    orderItemsList = orderItemsManager.search(queryModel);
                }
            } else {
                queryModel = new QueryModel();
                queryModel.addColumnValueCondition("orderId", orderQO.getOrderId());
                orderItemsList = orderItemsManager.search(queryModel);
            }
            if (CheckUtil.checkListIsNull(orderItemsList)) {
                for (OrderItems orderItems : orderItemsList) {
                    OrderItemsVO orderItemsVO = new OrderItemsVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(orderItems, orderItemsVO);
                    orderItemsVOList.add(orderItemsVO);
                }
            }
            returnObject.setDataList(orderItemsVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.info("call searchOrderItemList error({})", e);
        }
        return returnObject;
    }


    /**
     * 保存修改
     *
     * @param serviceVO
     * @return
     */
    @Override
    public ReturnObject<ServiceVO> saveServiceVO(ServiceVO serviceVO) {
        logger.info("call saveServiceVO({\"serviceVO\":" + JsonUtil.JSON_Bean2String(serviceVO) + "})");
        ReturnObject returnObject = new ReturnObject();
        com.huazhu.hvip.order.ord.model.Service service = null;
        try {
            if (serviceVO != null) {
                if (serviceVO.getServiceId() != null) {
                    service = serviceManager.get(serviceVO.getServiceId());
                    if (service == null) {
                        service = new com.huazhu.hvip.order.ord.model.Service();
                    }
                    CopyBeanUtil.copyPropertiesIgnoreNull(serviceVO, service);
                    service = serviceManager.save(service);
                    CopyBeanUtil.copyPropertiesIgnoreNull(service, serviceVO);
                }
                returnObject.setData(serviceVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }


    /**
     * 批量保存
     *
     * @param orderVO
     * @return
     */
    @Override
    public ReturnObject<OrderVO> saveOrderParam(OrderVO orderVO) {
        logger.info("call saveOrderParam({\"orderVO\":" + JsonUtil.JSON_Bean2String(orderVO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            if (orderVO != null) {
                Order order = orderManager.get(orderVO.getOrderId());
                ParamObject paramObject=new ParamObject();
                paramObject.add("oldorder",order);
                CopyBeanUtil.copyPropertiesIgnoreNull(orderVO, order);
                paramObject.add("neworder",order);
                orderManager.saveOrderParam(paramObject);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            }
        } catch (Exception e) {
            logger.info("call saveOrderList error({})", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }


    /**
     * @param order
     * @param order
     * @return
     */
    private OrderAction setOrderActionParam(Order order, String oldStatus, String nenStatus) {
        OrderAction orderAction = new OrderAction();
        orderAction.setOrderId(order.getOrderId());
        orderAction.setActionType(nenStatus);
        if (Constants.ORDER_STATUS_SERVICING.equals(nenStatus) && order != null) {
            orderAction.setDescription("订单的(orderSn:" + order.getOrderSn() + ")订单原状态为:" + oldStatus + "新的状态为:" + nenStatus);
            orderAction.setMessage("订单变为服务中!操作人为:" + order.getUpdateUser());
        } else if (Constants.ORDER_STATUS_DON.equals(nenStatus) && order != null) {
            orderAction.setDescription("订单的(orderSn:" + order.getOrderSn() + ")订单原状态为:" + oldStatus + "新的状态为:" + nenStatus);
            orderAction.setMessage("订单变为完成!操作人为:" + order.getUpdateUser());

        }
        orderAction.setOpName(order.getUpdateUser());
        orderAction.setOpTime(new Date());
        return orderAction;
    }

    /**
     * 扭转工单状态
     *
     * @param
     * @return
     */
    private boolean verifyServiceStatus(String oldStatus, String newStatus) {
        boolean flag = false;
        //待支付
        if (oldStatus.equals(Constants.SERVICE_STATUS_WAITPAY)
                && (newStatus.equals(Constants.SERVICE_STATUS_CAL)
                || newStatus.equals(Constants.SERVICE_STATUS_PAY))) {
            flag = true;
        }
        //支付完成待分配
        if (oldStatus.equals(Constants.SERVICE_STATUS_PAY)
                && (newStatus.equals(Constants.SERVICE_STATUS_WAITSERVICE)
                || newStatus.equals(Constants.SERVICE_STATUS_CAL))) {
            flag = true;
        }//分配完成待服务
        if (oldStatus.equals(Constants.SERVICE_STATUS_WAITSERVICE)
                && (newStatus.equals(Constants.SERVICE_STATUS_CAL)
                || newStatus.equals(Constants.SERVICE_STATUS_SERVICING))) {
            flag = true;
        }
        //服务中
        if (oldStatus.equals(Constants.SERVICE_STATUS_SERVICING)
                && (newStatus.equals(Constants.SERVICE_STATUS_DON))) {
            flag = true;
        }
        return flag;
    }


    /**
     * 支付日志信息
     */
    private Paymentlog setPaymentLog(Order order) {
        Paymentlog paymentlog = new Paymentlog();
        paymentlog.setOpTime(new Date());
        paymentlog.setPayMemberName(order.getMemberName());
        return paymentlog;
    }


    /**
     * 设置支付信息
     *
     * @param payMethod
     * @param orderVO
     * @return
     */
    private Payment setPaymentParam(String payMethod, OrderVO orderVO) {
        Payment payment = new Payment();
        payment.setPayMethod(payMethod);
        payment.setPaymentSn(serialNumService.generatePaymentSn());
        payment.setMemberId(orderVO.getMemberId());
        payment.setPayMemberName(orderVO.getMemberName());
        payment.setAmount(orderVO.getGoodsAmount());
        if (orderVO.getPoint() != null) {
            payment.setRealPoint(orderVO.getPoint());
        } else {
            payment.setRealPoint(new BigDecimal(0));
        }
        payment.setRealAmount(orderVO.getOrderAmount());
        payment.setPayType(Constants.PAYMENT_TYPE_ONLINE);
        payment.setStatus(Constants.COMMON_STATUS_0);//未确定
        Date date = new Date();
        payment.setCreateTime(date);
        payment.setUpdateTime(date);
        payment.setCreateUser(orderVO.getCreateUser());
        payment.setUpdateUser(orderVO.getUpdateUser());
        return payment;
    }

    /**
     * @param order
     * @param payment
     * @return
     */
    private MemberVO setMemberVOPoint(Order order, Payment payment) {
        MemberVO memberVO = new MemberVO();
        if (order.getMemberId() != null) {
            ReturnObject returnObject = memberService.getMemberDetailByMemberId(order.getMemberId());
            if (Constants.RETURN_CODE_SUCCESS.equals(returnObject.getReturnCode())) {
                memberVO = (MemberVO) returnObject.getData();
                BigDecimal realAmount = payment.getRealAmount();//支付的钱
                BigDecimal point = payment.getRealPoint();
                if (Constants.ORDER_STATUS_WAITSERVICE.equals(order.getStatus())) {
                    memberVO.setPoint(memberVO.getPoint() + realAmount.intValue() - point.intValue());
                } else if (Constants.ORDER_STATUS_REFUNDED.equals(order.getStatus())) {
                    memberVO.setPoint(memberVO.getPoint() - realAmount.intValue() + point.intValue());
                }
            }
        }
        return memberVO;
    }


    /**
     * @param orderVO
     * @param order
     * @return
     */
    private OrderAction setOrderActionParam(OrderVO orderVO, Order order) {
        OrderAction orderAction = new OrderAction();
        if (orderVO.getOrderId() != null) {
            orderAction.setOrderId(orderVO.getOrderId());
        }
        orderAction.setActionType(orderVO.getStatus());
        if (Constants.ORDER_STATUS_WAITSERVICE.equals(orderVO.getStatus()) && order != null) {
            orderAction.setDescription("订单的(orderSn:" + order.getOrderSn() + ")订单原状态为:" + order.getStatus() + "新的状态为:" + orderVO.getStatus());
            orderAction.setMessage("支付回调，订单已付款!操作人为:" + orderVO.getUpdateUser());
        } else if (Constants.ORDER_STATUS_WAITPAY.equals(orderVO.getStatus())) {
            orderAction.setDescription("订单的(orderSn:" + orderVO.getOrderSn() + ")订单状态为:" + orderVO.getStatus());
            orderAction.setMessage("创建订单!操作人为:" + orderVO.getUpdateUser());
        } else if (Constants.ORDER_STATUS_CAL.equals(orderVO.getStatus()) && order != null) {
            orderAction.setDescription("订单的(orderSn:" + order.getOrderSn() + ")订单原状态为:" + order.getStatus() + "新的状态为:" + orderVO.getStatus());
            orderAction.setMessage("订单取消!操作人为:" + orderVO.getUpdateUser());
        } else if (Constants.ORDER_STATUS_SERVICING.equals(orderVO.getStatus()) && order != null) {
            orderAction.setDescription("订单的(orderSn:" + order.getOrderSn() + ")订单原状态为:" + order.getStatus() + "新的状态为:" + orderVO.getStatus());
            orderAction.setMessage("订单服务中!操作人为:" + orderVO.getUpdateUser());
        } else if (Constants.ORDER_STATUS_WAITREFUND.equals(orderVO.getStatus()) && order != null) {
            orderAction.setDescription("订单的(orderSn:" + order.getOrderSn() + ")订单原状态为:" + order.getStatus() + "新的状态为:" + orderVO.getStatus());
            orderAction.setMessage("订单退款请求操作!操作人为:" + orderVO.getUpdateUser());
        } else if (Constants.ORDER_STATUS_REFUNDING.equals(orderVO.getStatus()) && order != null) {
            orderAction.setDescription("订单的(orderSn:" + order.getOrderSn() + ")订单原状态为:" + order.getStatus() + "新的状态为:" + orderVO.getStatus());
            orderAction.setMessage("订单退款中操作!操作人为:" + orderVO.getUpdateUser());
        } else if (Constants.ORDER_STATUS_REFUNDED.equals(orderVO.getStatus()) && order != null) {
            orderAction.setDescription("订单的(orderSn:" + order.getOrderSn() + ")订单原状态为:" + order.getStatus() + "新的状态为:" + orderVO.getStatus());
            orderAction.setMessage("订单已退款!操作人为:" + orderVO.getUpdateUser());
        } else if (Constants.ORDER_STATUS_DON.equals(orderVO.getStatus()) && order != null) {
            orderAction.setDescription("订单的(orderSn:" + order.getOrderSn() + ")订单原状态为:" + order.getStatus() + "新的状态为:" + orderVO.getStatus());
            orderAction.setMessage("订单已完成!操作人为:" + orderVO.getUpdateUser());
        }
        orderAction.setOpName(orderVO.getUpdateUser());
        orderAction.setOpTime(new Date());
        return orderAction;
    }


}
