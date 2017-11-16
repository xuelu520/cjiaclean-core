package com.huazhu.hvip.thirdparty.utils;

public class Const {
    // ------------------------------------h5 session key------------------------------------------ //
    public static final String SESSION_KEY_HUSER = "_SESSION_HUSER"; //登录用户
    public static final String SESSION_KEY_HHOTEL = "_SESSION_HHOTEL";//华住订单关联酒店
    public static final String SESSION_KEY_HORDER = "_SESSION_HORDER";//华住订单
    public static final String SESSION_KEY_HORDERLIST = "_SESSION_HORDERLIST";//华住订单list

    public static final String SESSION_USERTOKEN = "_SESSION_USERTOKEN";//用户token
    public static final String SESSION_ACCESSTOKEN = "_SESSION_ACCESSTOKEN";//中枢accessToken
    public static final String SESSION_ACCOUNT = "_SESSION_ACCOUNT";//wifiportal 标识
    public static final String SESSION_HOTELID = "_SESSION_HOTELID";//wifiportal 酒店id

    public static final String LAST_OP_TIME = "_LAST_OP_TIME";
    // ------------------------------------ /h5 session key------------------------------------------ //

    // ------------------------------------h5 login type------------------------------------------ //
    public static final Integer LOGIN_TYPE_0 = 0; //登录成功
    public static final Integer LOGIN_TYPE_1 = 1;//登录没有订单
    public static final Integer LOGIN_TYPE_8 = 8;//wifi portal 未登录
    public static final Integer LOGIN_TYPE_9 = 9;//未登录
    // ------------------------------------ /h5 login type------------------------------------------ //

    // ------------------------------------解密 key------------------------------------------ //
    public static final String WECHAT_DES_KEY = "3!#dexr*&(%ed"; // 微信des解密key
    public static final String WECHAT_CHECK_KEY = "hua@0!4zhu{0}#{1}"; // 微信checkkey
    // ------------------------------------ /解密 key------------------------------------------ //

    // ------------------------------------ HTMS 挂账操作类型------------------------------------------ //
    public static final Integer HTMS_CREDIT_0 = 0; // 创建挂账
    public static final Integer HTMS_CREDIT_1 = 1; // 支付成功挂账
    public static final Integer HTMS_CREDIT_9 = 9; // 支付失败挂账
// ------------------------------------ /HTMS 挂账操作类型------------------------------------------ //

    // ------------------------------------ Wifiporal 参数------------------------------------------ //
    public static final String WIFI_PORTAL_KEY = "hua@0!4zhu{0}#"; // wifiportal checkkey

    public static final String WIFI_PORTAL_HOTELID = "hotelid"; // 酒店id
    public static final String WIFI_PORTAL_MEMBERID = "memberid"; // 用户id
    public static final String WIFI_PORTAL_ACCOUNT = "account"; // portal标识
    public static final String WIFI_PORTAL_TOKEN = "token"; // 用户token
    public static final String WIFI_PORTAL_SIGN = "sign"; // 签名
// ------------------------------------ /HTMS 挂账操作类型------------------------------------------ //

    // ------------------------------------ 华住订单类型------------------------------------------ //
//   订单详情返回订单状态 E 入住 X 取消 D 删除 R 预订中 N no show O 挂账
    public static final String HZ_ORDER_STATUS_0 = "0"; // 未设置
    public static final String HZ_ORDER_STATUS_1 = "1"; // 预订中
    public static final String HZ_ORDER_STATUS_2 = "2"; // 已入住
    public static final String HZ_ORDER_STATUS_3 = "3"; // no show
    public static final String HZ_ORDER_STATUS_4 = "4"; // 已取消
    public static final String HZ_ORDER_STATUS_5 = "5"; // 已删除
// ------------------------------------ /HTMS 挂账操作类型------------------------------------------ //
}
