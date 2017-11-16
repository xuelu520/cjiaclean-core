package com.huazhu.hvip.base.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XUEYONGPING001 on 2016/4/12.
 */
public class DicMap {

    private static Map<Object, Object> dicMap = new HashMap<Object, Object>();

    static {
        //=======================订单货物状态名称=================================

        //=======================订单状态名称=================================
        dicMap.put(Constants.ORDER_STATUS_PREFIX + Constants.ORDER_STATUS_WAITPAY, "未付款");

        /**************************** asstype类型 ***********************************/
        dicMap.put(Constants.ASSTYPE_UNIONCREDITCARDPAY, "JY");//银联信用卡支付
        dicMap.put(Constants.ASSTYPE_CRMVALUE, "IDC");//储值卡
        dicMap.put(Constants.ASSTYPE_ALIPAYWAP, "JZ");//支付宝
        dicMap.put(Constants.ASSTYPE_CASH, "CA");//现金
        dicMap.put(Constants.ASSTYPE_CRMPOINT, "PTS01");//积分
        dicMap.put(Constants.ASSTYPE_WECHATJSAPI, "JW");//微信

        /**************************** 支付方式 ***********************************/
        dicMap.put(Constants.PAYMENT_TYPE_PREFIX + Constants.PAYMENT_TYPE_ONLINE, "在线支付");
        dicMap.put(Constants.PAYMENT_TYPE_PREFIX + Constants.PAYMENT_TYPE_STORE, "门店支付");

        /**************************** 酒店的审核状态 ***********************************/
        dicMap.put(Constants.HOTELCONTROLPRICE_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICE_OPERATE_STATUS_REJECT, "未审核");
        dicMap.put(Constants.HOTELCONTROLPRICE_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICE_OPERATE_STATUS_PASS, "通过");
        dicMap.put(Constants.HOTELCONTROLPRICE_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICE_OPERATE_STATUS_BACK, "已退回");
        dicMap.put(Constants.HOTELCONTROLPRICE_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICE_OPERATE_STATUS_CANCEL, "已取消");
        dicMap.put(Constants.HOTELCONTROLPRICE_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICE_OPERATE_STATUS_PASSING, "审核中");
        dicMap.put(Constants.HOTELCONTROLPRICE_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICE_OPERATE_STATUS_SOMEPASS, "部分通过");

        dicMap.put(Constants.HOTELCONTROLPRICEITEM_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_REJECT, "未审核");
        dicMap.put(Constants.HOTELCONTROLPRICEITEM_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_PASS, "通过");
        dicMap.put(Constants.HOTELCONTROLPRICEITEM_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_BACK, "已退回");
        dicMap.put(Constants.HOTELCONTROLPRICEITEM_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_CANCEL, "已取消");
        dicMap.put(Constants.HOTELCONTROLPRICEITEM_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_PASSING, "审核中");
        dicMap.put(Constants.HOTELCONTROLPRICEITEM_OPEARTE_STATUS_PREFIX + Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_BACKREJECT, "已退回");
        /**************************** 开通渠道状态 ***********************************/
        dicMap.put(Constants.HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_PREFIX + Constants.HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_ONLINE, "线上");
        dicMap.put(Constants.HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_PREFIX + Constants.HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_STORE, "线下");
        dicMap.put(Constants.HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_PREFIX + Constants.HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_ALL, "全部");
        /**************************** 订单商品状态 ***********************************/
        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.GOODSTYPE_BIZSCOPE_CLEAN,"保洁服务");
        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.GOODSTYPE_BIZSCOPE_GOODS,"小商品");

        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.CLEANER_STATUS_WROKING,"上岗中");
        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.CLEANER_STATUS_WAITTRAIN,"待培训");
        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.CLEANER_STATUS_TRAINING,"培训中");
        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.CLEANER_STATUS_TRAINED,"培训完成");
        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.CLEANER_STATUS_WAITINTERVIEW,"待面试");
        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.CLEANER_STATUS_WAITWROKING,"待入职");
        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.CLEANER_STATUS_NOPASS,"面试未通过");
        dicMap.put(Constants.GOODSTYPE_BIZSCOPE_PREFIX+Constants.CLEANER_STATUS_NOWROKING,"已离职");




    }

    public static String getDicValue(Object dicKey) {
        Object obj = dicMap.get(dicKey);
        if (obj != null) {
            return obj.toString();
        }
        return "";
    }


}
