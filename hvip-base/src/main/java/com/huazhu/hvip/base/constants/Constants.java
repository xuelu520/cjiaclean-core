package com.huazhu.hvip.base.constants;


/**
 * Constant values used throughout the application.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class Constants {

    private Constants() {
        // hide me
    }

    /**
     * The name of the Administrator role, as specified in web.xml
     */
    public static final String ADMIN_ROLE = "ROLE_ADMIN";

    /**
     * The name of the User role, as specified in web.xml
     */
    public static final String USER_ROLE = "ROLE_USER";

    /**
     * 公共状态
     */
    public static final String COMMON_STATUS_0 = "0";//初始化状态
    public static final String COMMON_STATUS_1 = "1";//成功
    public static final String COMMON_STATUS_8 = "8";//失败
    public static final String COMMON_STATUS_9 = "9";//删除

    /****
     * 图片
     ****/
    public static String fileUploadPath = "fileUploadPath";
    public static String fileUrlContext = "fileUrlContext";

    /**
     * 图片尺寸
     */
    public static int IMAGE_WIDTH = 320; //图片宽度
    public static int IMAGE_HEIGTH = 320; //图片高度

    /****
     * 图片类型
     ****/
    public static String PICTURE_BIZTYPE_CATE = "1";                                //分类图片
    public static String PICTURE_BIZTYPE_GOODS = "2";                               //商品图片
    public static String PICTURE_BIZTYPE_TAG = "3";                                 //标签图片
    public static String PICTURE_BIZTYPE_STORE = "4";                               //店铺图片
    public static String PIC_DEFAULTSIZE="400x400";                    //默认图片大小

    /****
     * Message 状态
     ****/
    public static String MESSAGE_STATUS_NEW = "01";
    public static String MESSAGE_STATUS_READED = "02";
    public static String MESSAGE_STATUS_DELETE = "03";

    /****
     * YES/NO
     ****/
    public static String COMMMON_YES = "1";
    public static String COMMMON_NO = "0";


    // 登录返回code
    public static String RETURN_CODE_SUCCESS = "0";                                           // 成功
    public static String RETURN_CODE_FAIL = "1";                                           // 失败
    public static String RETURN_CODE_ERROR = "9";                                           // 错误
    public static String RETURN_CODE_USERNOTEXIST = "2";                                           // 用户不存在
    public static String RETURN_CODE_PASSWORDERROR = "4";                                           // 密码错误
    public static String RETURN_CODE_ISHUAZHUUSER = "11";                                          // 华住用户
    public static String RETURN_CODE_USEREXISTED = "12";                                          // 用户已存在

    public static String RETURN_CODE_PARAMFAIL = "-1"; //参数验证失败

    public static String RETURN_CODE_HOTELNOTEXIST = "8"; //未找到酒店信息


    // 短信
    public static final String SMS_WS_URL = "sms.ws.url";
    public static final String SMS_WS_BIZCODE = "sms.ws.bizCode";
    public static final String SMS_WS_CLIENTSYSTEM = "sms.ws.clientSystem";
    public static final String SMS_WS_HOTELID = "sms.ws.hotelId";

    // 短信相关
    public static final Integer SENDVC_MAX_SEC = 10;
    public static final Integer SENDVC_MAX_DAY = 20;
    public static final Integer SENDVC_MAX_VALIDATE = 3;
    // 相差1分钟
    public static final Integer VALIDCODE_LOSE_SEC = 30 * 60;                                          // 相差30分钟
    public static final Integer LIMIT_SUBMIT = 10;                                            // 找回密码，验证手机提交次数


    /****************************
     * 发送短信模块的信息类型
     ***********************************/
    public static final String SMS_TYPE_CREATEORDER = "createOrder"; //预订成功(可门店支付)
    public static final String SMS_TYPE_PAIDORDER = "paidOrder"; //付款成功(线上支付)
    public static final String SMS_TYPE_CANCELORDER = "cancelOrder"; //取消(包括自行取消和超时未支付)

    /****************************
     * 发送短信模块的信息类型
     ***********************************/

    // 华住会员中心
    public static final String CRM_URL_CLIENTID = "crm.url.client_id";
    public static final String CRM_URL_CLIENTSECRET = "crm.url.client_secret";
    public static final String CRM_URL_AUTH = "crm.url.auth";
    public static final String CRM_URL_LOGIN = "crm.url.login";
    public static final String CRM_URL_REGISTER = "crm.url.register";
    public static final String CRM_URL_VALIDATEMOBILE = "crm.url.validatemobile";
    public static final String CRM_URL_CHANGEMOBILE = "crm.url.changemobile";
    public static final String CRM_URL_CHANGEPASSWORD = "crm.url.changepassword";
    public static final String CRM_URL_RESETPASSWORD = "crm.url.resetpassword";
    public static final String CRM_URL_MEMBERINFOUPDATE = "crm.url.memberinfoupdate";
    public static final String CRM_URL_GETMEMBERINFO = "crm.url.getmemberinfo";

    //FLAG标记
    public static final String FLAG_FALSE = "0"; //否
    public static final String FLAG_TRUE = "1"; //是

    //是否删除
    public static final String DELETE_FLAG_FALSE = "0"; //未删除
    public static final String DELETE_FLAG_TRUE = "1"; //已删除


    //serialNum.serialName
    public static final String SERIALNUM_NAME_ORDERNO = "orderNo"; //订单号
    public static final String SERIALNUM_NAME_ORDERSN = "orderSn"; //订单唯一号
    public static final String SERIALNUM_NAME_PAYMENTSN = "paymentSn"; //支付单唯一流水号
    public static final String SERIALNUM_NAME_REFUNDSN = "refundSn"; //退货单唯一流水号
    public static final String SERIALNUM_NAME_GOODSNO = "goodsNo"; // 商品号
    public static final String SERIALNUM_NAME_GOODSSN = "goodsSn"; // 商品唯一号
    public static final String SERIALNUM_NAME_DEBITPAYNO = "debitPayNo";
    public static final String SERIALNUM_NAME_VOUCHERNO = "voucherNo"; //凭证号
    public static final String SERIALNUM_NAME_EMPLOYEENO = "employeeNo"; //凭证号
    public static final String SERIALNUM_NAME_SERVICESN = "serviceSn"; //凭证号
    public static final String SERIALNUM_NAME_HOTELSN = "hotelSn"; //凭证号


    /****************************
     * 酒店状态
     ***********************************/
    public static final String HOTEL_STATUS_SUSPEND = "-1";                //酒店停业
    public static final String HOTEL_STATUS_OPERATION = "1";               //酒店运营
    public static final String HOTEL_STATUS_CONSTRUCTION = "2";            //酒店营建

    /****************************
     * 酒店是否开通私人订制
     ***********************************/
    public static final String HOTEL_OPENVIP_TRUE = "1";                //已开通
    public static final String HOTEL_OPENVIP_FALSE = "0";            //未开通

    /****************************
     * 店铺状态
     ***********************************/
    public static final String STORE_STATUS_AUDIT_REJECT = "-1";           //店铺未通过审核
    public static final String STORE_STATUS_AUDIT_WAIT = "0";              //店铺待审核
    public static final String STORE_STATUS_AUDIT_PASS = "1";              //店铺审核通过
    public static final String STORE_STATUS_CLOSED = "2";                  //店铺审核关闭

    /****************************
     * 商品
     ***********************************/
    //是否上下架
    public static final String GOODS_MARKETENABLE_NO = "0"; //未上架
    public static final String GOODS_MARKETENABLE_YES = "1"; //已上架

    /****************************
     * 分类
     ***********************************/
    //分类状态
    public static final String CATE_STATUS_ENABLE_FALSE = "0"; //未启用
    public static final String CATE_STATUS_ENABLE_TRUE = "1"; //已启用

    //分类是否支持门店支付
    public static final String CATEORDERRULE_STOREPAYFLAG_FALSE = "0"; //否  不支持
    public static final String CATEORDERRULE_STOREPAYFLAG_TRUE = "1"; //是   支持

    //分类付款后是否能取消
    public static final String CATEORDERRULE_PAIDCANCELFLAG_FALSE = "0"; //否
    public static final String CATEORDERRULE_PAIDCANCELFLAG_TRUE = "1"; //是

    //分类预定类型
    public static final String CATEORDERRULE_RESERVATIONFLAG_0 = "0"; //需要预约详情
    public static final String CATEORDERRULE_RESERVATIONFLAG_1 = "1"; //不需要预约详情
    public static final String CATEORDERRULE_RESERVATIONFLAG_9 = "9"; //不可预约

    //付款默认倒计时（60分钟）
    public static final Integer CATEORDERRULE_PAYCOUNTDOWN_DEFAULT = 60; //默认60分钟


    //价格渠道定义名称审核
    public static final String CHANNEL_TYPE_ONLINE = "0"; //未审核
    public static final String CHANNEL_TYPE_OFFLINE = "1"; //审核

    //价格渠道定义名称审核
    public static final String CHANNELRATE_CODE_NOPASS = "0"; //未审核
    public static final String CHANNELRATE_CODE_PASS = "1"; //审核

    //渠道价格Code
    public static final String CHANNEL_CODE_ONLINE = "online"; //线上
    public static final String CHANNEL_CODE_STORE = "store"; //门店

    //渠道对象的对象类型
    public static final String CHANNELOBJECT_TYPE_HOTEL = "1"; //酒店
    public static final String CHANNELOBJECT_TYPE_STORE = "2"; //店铺
    public static final String CHANNELOBJECT_TYPE_COMPANY = "3"; //公司

    //渠道对象的状态
    public static final String CHANNELOBJECT_STATUS_AVAIL = "1"; //可用
    public static final String CHANNELOBJECT_STATUS_UNAVAIL = "0"; //不可用


    //开通渠道
    public static final String OPEN_CHANNEL_ALL = "0"; //全部
    public static final String OPEN_CHANNEL_ONLINE = "1"; //线上
    public static final String OPEN_CHANNEL_OFFLINE = "2"; //线下

    //分类业务范围
    public static final String GOODSTYPE_BIZSCOPE_PREFIX ="GOODSTYPE_BIZSCOPE_";
    public static final String GOODSTYPE_BIZSCOPE_CLEAN = "1"; //保洁服务
    public static final String GOODSTYPE_BIZSCOPE_GOODS = "2"; //小商品
    public static final String GOODSTYPE_BIZSCOPE_APARTMENTCLEAN = "3"; //公寓保洁
    public static final String GOODSTYPE_BIZSCOPE_FIRSTCLEAN = "4"; //首次保洁
    public static final String GOODSTYPE_BIZSCOPE_DISCOUNTCLEAN = "5"; //打折保洁

    /****************************
     * 库存相关
     ***********************************/
    //仓库库房 关联类型
    public static final String DEPOT_ORGTYPE_NO = "0"; //无关联
    public static final String DEPOT_ORGTYPE_HOTEL = "1"; //关联公司
    public static final String DEPOT_ORGTYPE_COMPANY = "2"; //关联公司


    public static final String WARHOUSETYPE_DEFAULT_TYPE = "1"; //WARHOUSETYPE默认字段

    //库存操作类型
    public static final Integer CHANGESTORE_TYPE_BOOK = 1; //下单
    public static final Integer CHANGESTORE_TYPE_SHIP = 2; //发货
    public static final Integer CHANGESTORE_TYPE_REFUND = 3; //退货收货
    public static final Integer CHANGESTORE_TYPE_CAL = 4; //取消
    public static final Integer CHANGESTORE_TYPE_DEL = -9; //未付款删除
    public static final Integer CHANGESTORE_TYPE_OPSET = 11; //后台设置库存


    //H5 首页展示的四款商品唯一编号 goodsSn
    public static final String H5_HOMEPAGE_GOODSSN_1 = "G00000001"; //时令果盘
    public static final String H5_HOMEPAGE_GOODSSN_2 = "G00000002"; //宝洁洗漱套装
    public static final String H5_HOMEPAGE_GOODSSN_3 = "G00000003"; //全棉毛巾
    public static final String H5_HOMEPAGE_GOODSSN_4 = "G00000004"; //纳米牙具套装


    public static final String GOODSSN_1 = "G00000001"; //水果拼盘
    public static final String GOODSSN_2 = "G00000002"; //纳米牙具套装
    public static final String GOODSSN_3 = "G00000003"; //舒蕾洗漱宝
    public static final String GOODSSN_4 = "G00000004"; //高级商务毛巾
    public static final String GOODSSN_6 = "G00000006"; //单人牙具套装


    //分类代码
    public static final String CATE_SN_MASSAGE = "MASSAGE"; //推拿
    public static final String CATE_SN_CARRENT = "CARRENT"; //汽车租赁
    public static final String CATE_SN_INTERNET = "INTERNET"; //急速上网
    public static final String CATE_SN_ROMANTIC = "ROMANTIC"; //浪漫房
    public static final String CATE_SN_GOODS = "GOODS"; //小商品
    public static final String CATE_SN_QWERTR = "QWERTR"; //便捷租赁
    public static final String CATE_SN_MOVIE = "MOVIE"; //电影主题房
    public static final String CATE_SN_FRUITPLATE = "FRUITPLATE"; //果盘

    /****************************
     * 订单相关
     ***********************************/
    //订单状态 order status状态
    public static final String ORDER_STATUS_PREFIX = "ORDER_STATUS_";
    public static final String ORDER_STATUS_WAITPAY = "0"; //未付款
    public static final String ORDER_STATUS_WAITSERVICE = "1"; //待服务
    public static final String ORDER_STATUS_CAL = "2"; //取消
    public static final String ORDER_STATUS_SERVICING = "3"; //服务中
    public static final String ORDER_STATUS_WAITREFUND = "4"; //待退款
    public static final String ORDER_STATUS_REFUNDING = "5"; //退款中
    public static final String ORDER_STATUS_REFUNDED = "6"; //已退款
    public static final String ORDER_STATUS_DON = "7"; //已完成
    //订单来源 order source
    public static final String ORDER_SOURCE_HMS = "Hotel"; //HMS
    public static final String ORDER_SOURCE_H5 = "H5"; //h5
    public static final String ORDER_SOURCE_APP = "APP"; //app
    public static final String ORDER_SOURCE_WECHAT = "WECHAT"; //WECHAT
    public static final String ORDER_SOURCE_WIFIPORTAL = "WIFIPORTAL"; //WECHAT

    //订单付款状态 order payStatus
    public static final String ORDER_PAYSTATUS_PREFIX = "ORDER_PAYSTATUS_";
    public static final String ORDER_PAYSTATUS_WAITPAY = "0"; //待支付
    public static final String ORDER_PAYSTATUS_PAID = "1"; //已支付
    public static final String ORDER_PAYSTATUS_REFUNDPAY = "2"; //已退款
    public static final String ORDER_PAYSTATUS_PARTREFUND = "3"; //部分退款
    public static final String ORDER_PAYSTATUS_PARTPAID = "4"; //部分付款


    public static final String ORDERITEM_STATUSNAME_NONSHIP = "未发货";
    public static final String ORDERITEM_STATUSNAME_SHIPPED = "已发货";
    public static final String ORDERITEM_STATUSNAME_RETURN = "已退货";
    public static final String ORDERITEM_STATUSNAME_CAL = "已取消";

    public static final String ORDERITEM_STATUS_DEL = "-9"; //删除

    //支付类型
    public static final String PAYMENT_TYPE_PREFIX = "PAYMENT_TYPE_";
    public static final String PAYMENT_TYPE_ONLINE = "1"; //在线支付
    public static final String PAYMENT_TYPE_STORE = "2"; //门店支付

    //支付状态
    public static final String PAYMENT_STATUS_PREFIX = "PAYMENT_STATUS_";
    public static final String PAYMENT_STATUS_WAITPAY = "0"; //待付款
    public static final String PAYMENT_STATUS_PAID = "1"; //已支付

    //发货类型
    public static final String SHIPMENTS_TYPE_SHIP = "1"; //发货

    //退款状态
    public static final String REFUND_STATUS_WAIT = "0"; //退款中
    public static final String REFUND_STATUS_SUCCESS = "1"; //退款成功
    public static final String REFUND_STATUS_FAIL = "-1"; //退款失败



    public static final String SERVICE_STATUS_WAITPAY = "0"; //工单状态待付款
    public static final String SERVICE_STATUS_PAY = "1"; //已付款待分配
    public static final String SERVICE_STATUS_WAITSERVICE = "2"; //待服务
    public static final String SERVICE_STATUS_CAL = "3"; //取消
    public static final String SERVICE_STATUS_SERVICING = "4"; //服务中
    public static final String SERVICE_STATUS_DON = "5"; //服务完成


    /**************************
     * HPAY的配置变量名称 START
     *****************************/
    public static final String HPAY_SERVICE_NAME = "Create_Direct_Pay";   //服务的接口名称
    public static final String HPAY_INPUT_CHARSET = "UTF-8"; //输入的字符集
    public static final String HPAY_REFUND_SERVICE = "Create_Direct_Refund";   //服务的接口名称
    // 接口调用者，WebSite=0, APP=1,  H5=2, PMS=8, CRM=9, CRS=10,CallCenter=16, HWorld =256, Other=1024
    public static final String HPAY_CALLER = "hpay.caller";
    public static final String HPAY_MERCHANT_ID = "hpay.merchantId";    //商家的ID
    public static final String HPAY_MERCHANT_KEY = "hpay.merchantKey";
    public static final String HPAY_ENTRY_URL = "hpay.entryUrl";
    public static final String HPAY_TARGET_ADDRESS = "hpay.postUrl";
    public static final String HPAY_RETURN_URL = "hpay.returnUrl";
    public static final String HPAY_NOTIFY_URL = "hpay.notifyUrl";
    public static final String HPAY_PAY_BACK = "hpay.backUrl";
    public static final String HPAY_REFUND_BILL = "hpay.refundBill";
    public static final String HPAY_REFUND_NOTIFY = "hpay.refundNotify";
    /**************************HPAY的配置变量名称 END*****************************/

    /****************************
     * 取消订单类型
     ***********************************/
    public static final String CANCEL_TYPE_0 = "0";                //取消全额退款
    public static final String CANCEL_TYPE_1 = "1";                //取消按照固定金额退款
    public static final String CANCEL_TYPE_2 = "2";                //取消按照百分比退款
    public static final String CANCEL_TYPE_9 = "9";                //取消不退款

    /****************************
     * 系统参数
     ***********************************/
    //参数类型
    public static final String SYSPARAM_TYPE_DIANDAO = "1";  //点到
    public static final String SYSPARAM_TYPE_GOODSFINANCESUBJECT = "2";  //商品财务科目
    public static final String SYSPARAM_TYPE_SPLITPROPORTION = "3";  //分成比例
    public static final String SYSPARAM_TYPE_PROFITRATE = "4";  //商品调价利润率及利润额
    public static final String SYSPARAM_TYPE_FINANCESUBJECT = "5";  //财务科目
    public static final String SYSPARAM_TYPE_REWADRATE = "6"; //百宝箱服务奖励提成

    /****************************系统参数 ***********************************/

    /****************************
     * 商品类型
     ***********************************/
    public static final Long GOODS_TYPE_ID_SERVICE = 1L; //服务升级
    public static final Long GOODS_TYPE_ID_GOODS = 2L; //商品升级
    public static final Long GOODS_TYPE_ID_THIRDPARTY = 3L; //第三方服务
    /**************************** 商品类型 ***********************************/
    //商品是否是周期
    public static final String GOODS_CYCLE_TRUE="0";
    public static final String GOODS_CYCLE_FALSE="1";



    /****************************
     * 财务科目
     ***********************************/

    //科目代码
    public static final String SUBJECT_CODE_THIRDPARTY_8300 = "8300"; //百宝箱--第三方服务
    public static final String SUBJECT_CODE_THIRDPARTY_ADJUST_8310 = "8310"; //调整百宝箱--第三方服务
    public static final String SUBJECT_CODE_SERVICE_6600 = "6600"; //百宝箱--服务升级
    public static final String SUBJECT_CODE_SERVICE_ADJUST_6610 = "6610"; //调整百宝箱--服务升级
    public static final String SUBJECT_CODE_GOODS_8200 = "8200"; //百宝箱--商品升级
    public static final String SUBJECT_CODE_GOODS_ADJUST_8210 = "8210"; //调整百宝箱--商品升级

    //科目代码描述
    public static final String SUBJECT_DESC_THIRDPARTY_8300 = "百宝箱--第三方服务"; //百宝箱--第三方服务
    public static final String SUBJECT_DESC_THIRDPARTY_ADJUST_8310 = "调整百宝箱--第三方服务"; //调整百宝箱--第三方服务
    public static final String SUBJECT_DESC_SERVICE_6600 = "百宝箱--服务升级"; //百宝箱--服务升级
    public static final String SUBJECT_DESC_SERVICE_ADJUST_6610 = "调整百宝箱--服务升级"; //调整百宝箱--服务升级
    public static final String SUBJECT_DESC_GOODS_8200 = "百宝箱--商品升级"; //百宝箱--商品升级
    public static final String SUBJECT_DESC_GOODS_ADJUST_8210 = "调整百宝箱--商品升级"; //调整百宝箱--商品升级

    /**************************** 商品类型 ***********************************/


    /****************************
     * asstype类型
     ***********************************/
    public static final String ASSTYPE_UNIONCREDITCARDPAY = "UnionCreditCardPay";  //银联信用卡支付
    public static final String ASSTYPE_CRMVALUE = "CRMValue";  //储值卡
    public static final String ASSTYPE_ALIPAYWAP = "AlipayWap";  //支付宝
    public static final String ASSTYPE_CASH = "Cash";  //现金
    public static final String ASSTYPE_CRMPOINT = "CRMPoint"; //积分
    public static final String ASSTYPE_WECHATJSAPI = "WeChatJSAPI";

    //权限类型
    public static final String AUTHTYPE_MENU = "1";  //菜单
    public static final String AUTHTYPE_PAGEELEMENT = "2";  //页面元素
    public static final String AUTHTYPE_METHOT = "3";  //方法


    //账单状态
    public static final String BILL_TYPE_0 = "0";//未入账
    public static final String BILL_TYPE_1 = "1";//已入账
    public static final String BILL_TYPE_2 = "2";//已调账
    public static final String BILL_TYPE_1F = "-1";//入账失败
    public static final String BILL_TYPE_2F = "-2";//调账失败

    //账单类型
    public static final String BILL_TYPE_DEBIT = "debit";
    public static final String BILL_TYPE_CREDIT = "credit";

    //图片上传类型
    public static final String UPLOADTYPE_NOMAL = "0";//普通上传
    public static final String UPLOADTYPE_MULTI = "1";//批量上传
    public static final String UPLOADTYPE_ICON = "2";//上传图标
    public static final String UPLOADTYPE_TGPIC = "3";//推广图标
    public static final String UPLOADTYPE_CATEGROY = "4"; //上传分类


    //关联外部订单类型
    public static final String ORGTYPE_DIANDAO = "1";//点到
    //非会员  中介/旅行社
    public static final Long MEMBER_ID_NON = -1L; //非会员
    public static final Long MEMBER_ID_AG = -2L; //中介/旅行社




    public static final String HOTELCONTROLPRICE_OPEARTE_STATUS_PREFIX = "HOTELCONTROLPRICE_OPERATE_STATUS_";
    public static final String HOTELCONTROLPRICE_OPERATE_STATUS_REJECT = "0";  //未审核
    public static final String HOTELCONTROLPRICE_OPERATE_STATUS_PASS = "1";   //已审核
    public static final String HOTELCONTROLPRICE_OPERATE_STATUS_BACK = "2";   //已退回
    public static final String HOTELCONTROLPRICE_OPERATE_STATUS_CANCEL = "3";   //已取消
    public static final String HOTELCONTROLPRICE_OPERATE_STATUS_PASSING = "4";   //审核中
    public static final String HOTELCONTROLPRICE_OPERATE_STATUS_SOMEPASS = "5";   //部分审核

    public static final String HOTELCONTROLPRICEITEM_OPEARTE_STATUS_PREFIX = "HOTELCONTROLPRICEITEM_OPERATE_STATUS_";
    public static final String HOTELCONTROLPRICEITEM_OPERATE_STATUS_REJECT = "0";  //未审核
    public static final String HOTELCONTROLPRICEITEM_OPERATE_STATUS_PASS = "1";   //已审核
    public static final String HOTELCONTROLPRICEITEM_OPERATE_STATUS_BACK = "2";   //已退回
    public static final String HOTELCONTROLPRICEITEM_OPERATE_STATUS_CANCEL = "3";   //已取消
    public static final String HOTELCONTROLPRICEITEM_OPERATE_STATUS_PASSING = "4";   //审核中
    public static final String HOTELCONTROLPRICEITEM_OPERATE_STATUS_OLD = "5";   //已过期
    public static final String HOTELCONTROLPRICEITEM_OPERATE_STATUS_BACKREJECT = "20";   //已退重新申请

    public static final String HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_PREFIX = "HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_";
    public static final String HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_ALL = "0"; //全部
    public static final String HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_ONLINE = "1"; //线上
    public static final String HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_STORE = "2"; //门店


    public static final String CATEORDERRULE_CATERULE_CHARGE="1"; //收费商品
    public static final String CATEORDERRULE_CATERULE_CHARGELEASE="2"; //收费租赁
    public static final String CATEORDERRULE_CATERULE_FREE="3"; //免费商品
    public static final String CATEORDERRULE_CATERULE_FREELEASE="4"; //免费租赁


    public static final String GOODTYPE_FREEE = "18"; //免费的商品（后面待优化）

    public static  final String GOODS_PIC_DEFAULTFLAG="1";
    public static  final String GOODS_PIC_NODEFAULTFLAG="0";


    public static final String INVENTORYRECORD_OPERATETYPE_CREATEORDER="1"; //下单减可用库存
    public static final String INVENTORYRECORD_OPERATETYPE_CANCELORDER="2"; //取消订单增加订单
    public static final String INVENTORYRECORD_OPERATETYPE_INVENTORY="3"; //保存库存增加

    public static final String INVENTORYRECORD_FLOWTYPE_OUT="1"; //减少
    public static final String INVENTORYRECORD_FLOWTYPE_IN="2"; //增加


    //百宝箱服务奖励提成(默认)
    public static final Double SYSPARAM_REWADRATE_DEFAULTVALUE = 0.06;

    //推送渠道
    public static final String NOTIFY_CHANNEL_PMS = "1";

    public static final String GIFTPACKS_TYPE_COMMON="0";
    public static final String GIFTPACKS_TYPE_SOVEREIGN="1";
    public static final String GIFTPACKS_TYPE_OTHER="9";

    public static final String INVENTORY_RECORD_USING="0";//使用中
    public static final String INVENTORY_RECORD_RETURNPART="1";//归还
    public static final String INVENTORY_RECORD_RETURNAll="1";//归还
    public static final String INVENTORY_RECORD_USED="2";// 消耗掉


    //保洁员状态
    public static final String CLEANER_STATUS_WROKING_PREFIX="CLEANER_STATUS_";
    public static final String CLEANER_STATUS_WROKING="0";// 上岗中
    public static final String CLEANER_STATUS_WAITTRAIN="1";// 待培训
    public static final String CLEANER_STATUS_TRAINING="2";// 培训中
    public static final String CLEANER_STATUS_TRAINED="3";// 培训完成
    public static final String CLEANER_STATUS_WAITINTERVIEW="4";// 待面试
    public static final String CLEANER_STATUS_WAITWROKING="5";// 待入职
    public static final String CLEANER_STATUS_NOPASS="6";// 面试未通过
    public static final String CLEANER_STATUS_NOWROKING="7";// 已离职


    //redis存储目录
    public static final String REDIS_WECHATUSER_USERINFO="cjclean:wechat:userinfo";//
    public static final String REDIS_CJCLEAN_CLEAN="cjclean:cleaner:cleanerInfo";//
    public static final String REDIS_CJCLEAN_COMPANYINFO="cjclean:cleaner:companyinfo";//


    //保洁员状态
    public static final String CLEANER_WORKSTATUS_WROKING="0";// 工作中
    public static final String CLEANER_WORKSTATUS_LEAVE="1";// 请假

    //微信公众号菜单授权
    public static final String WXMENU_AUTHORIZE_TRUE="0";//默认
    public static final String WXMENU_AUTHORIZE_FALSE="1";//非默认

    //微信回调
    public static final String WXOPERATE_AUTH_NAME="wechatreback";


    //微信回调返回
    public static String  WXPAY_RETURNCODE_SUCCESS = "SUCCESS"; //成功return_code
    public static String WXPAY_RETURNCODE_FAIL = "FAIL";   //失败return_code


    //商品评论
    public static String  GOODS_COMMONET_SHOWFLAG_TRUE = "0"; //显示
    public static String  GOODS_COMMONET_SHOWFLAG_FALSE = "1"; //不显示

    //好评差评
    public static String  GOODS_COMMONET_STATUS_NICE = "0"; //显示
    public static String  GOODS_COMMONET_STATUS_BAD = "1"; //不显示

    //redisCooie
    public static final String REDIS_KEY_WEIXINOPENIDCOOKIE="WEIXINOPENIDCOOKIE";//微信cookie
    public static final String REDIS_KEY_CLEANERCOOKIE="CLEANERCOOKIE";//员工cookie
    public static final String REDIS_KEY_COMPANYSCOOKIE="COMPANYCOOKIE";//员工cookie

    //员工职位
    public static final String CLEANER_POSITION_CLEANER="cleaner";
    public static final String CLEANER_POSITION_PRODUCTMANAGER="product_manager";
    public static final String CLEANER_POSITION_AREAMANAGER="area_manager";
    public static final String CLEANER_POSITION_STEERING="steering";


    //员工类型
    public static final String CLEANER_CLEANER_BUSINESS="business";
    public static final String CLEANER_CLEANER_CUSTOMER="customer";

    //会员等级
    public static final String MEMBER_LEVEL_START="星会员";
    public static final String MEMBER_LEVEL_GOLD="黄金会员";
    public static final String MEMBER_LEVEL_PLATINUM="铂金会员";
    public static final String MEMBER_LEVEL_DIAMONDS="钻石会员";


    public static final String MEMBER_ISADMIN_NORMAL="0";//普通用户
    public static final String MEMBER_ISADMIN_ADMIN="1";//管理员
    public static final String MEMBER_ISADMIN_CLEANER="2";//保洁员


}

