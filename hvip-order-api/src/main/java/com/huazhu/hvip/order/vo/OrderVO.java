package com.huazhu.hvip.order.vo;


import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.constants.DicMap;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
@Entity
public class OrderVO implements Serializable {

    private Long orderId; //订单id
    private String orderNo; //订单号
    private String orderSn; //订单唯一号
    private String source;//订单来源
    private Long storeId; //店铺id
    private Long hotelId; //酒店id
    private String hotelName; //酒店名称
    private String hotelAddress; //酒店地址
    private String hotelUniqueNo; //酒店统一编号
    private String hotelNo; //酒店编号
    private String hotelOrderSn; //酒店订单编号
    private String hotelRecOrderSn; //酒店接待单号
    private String hotelTelNo; //酒店电话
    private String hotelRoomNo; //酒店房间号
    private String hoBillId; //华住订单billId
    private Long parentId; //付订单id
    private String status; //状态
    private String payStatus; //支付状态
    private String shipStatus; //货运状态
    private BigDecimal goodsAmount; //商品总额
    private BigDecimal shippingAmount; //配送费用
    private BigDecimal discount; //优惠费用
    private BigDecimal orderAmount; //订单总额
    private BigDecimal refundAmount; //退款金额
    private Long memberId; //预订人会员id
    private String memberMobile; //预订人手机
    private String memberTelNo; //预订人电话
    private String memberName; //预订人姓名
    private String memberAddress; //预订人地址
    private String memberIdType; //预订人证件类型
    private String memberIdNo; //预订人证件号
    private String shipName; //收货人姓名
    private String shipAddr; //收货人地址
    private String shipZip; //收货人邮编
    private String shipEmail; //收货人邮箱
    private String shipMobile; //收货人手机
    private String shipTel; //收回的电话
    private String shipDay; //收获日期
    private String shipTime; //收获时间
    private String cancelReason; //取消原因
    private Date signingTime; //签收时间
    private String theSign; //签收人
    private String remark; //备注
    private Date completeTime; //完成时间
    private Date payTime; //支付时间
    private Date allocationTime; //配货时间
    private Date createTime; //创建时间
    private String createUser; //创建人
    private Date updateTime; //修改时间
    private String updateUser; //修改人
    private String goodsShow;//商品展示
    private String serviceTime; //服务时间
    private String billType;//账单类型 0 未入账 1 已入账 2 已调账
    private Integer splitProportion; //分成比例(以整数方式存储，例如40%对应就是40)
    private String bizScope;//订单商品类型 根据商品类型来确定
    private String orgTypeName;
    private String orgValue;//关联外部订单号
    private String payType;
    private String payTypeName;
    private Integer pageCount; // 分页的总数
    private Date shipmentTime; //发货时间
    private String goodsName; //商品名称
    private String cityAreaName;//区域名称
    private String city; //城市名称
    private String mgrModel; //运营方式
    private String statusName;
    private String openid;
    private String deleteFlag;
    private Long addressId;
    private List<ServiceVO> serviceVOList;
    private List<OrderItemsVO> orderItemsVOList; //订单货物项
    private BigDecimal point;
    private String storePayFlag; //是否支持门店支付：0否 1是
    private String paidCancelFlag; //付款后能否取消：0否 1是
    private Integer payCountdown; //付款倒计时(以分钟存储)1
    private String canReservationTime; //入住当日几点前可预订
    private String rulePromptMsg; //规则提示信息，json字串
    private String orderRuleDescription; //描述
    private String reservationFlag; //是否要预约详细：0.否 1.是 9，不可预约
    private String accountingFlag; //是否需要入账 0否 1是
    private String crmPayFlag; //是否支持储值卡支付:  0.否 1.是


    private String cancelType; //取消类型：0 取消全额退款 1 取消按照固定金额退款 2 取消按照百分比退款 9 取消不退款
    private Integer lastCancelHours; //最晚取消时间（精确到小时）：     判断时间 - 当前日期 >= hours
    private String lastCancelTime; //最后可取消时间  例：19:00 计算日期当天 19:00
    private BigDecimal cancelCalcFee; //取消后扣款金额
    private String returnsFlag;//发货后是否可以退货：0否  1是
    private Integer returnsMinutes;//多少时间(分钟)内前台有退货权限
    private RulesVO rulesVO;//订单规则对象

    private PaymentVO paymentVO; //支付单
    private String serviceStatus;
    private String cycle;

    //入账用到相关参数
    private boolean adjustFlag; //是否是调账 true 调账
    private String payMethod; //支付方式
    private String operatorName; //操作人姓名
    private String bizDate; //营业日
    private Map<String,Object> countOrderListSize;  //统计不同状态下的订单数量
    private String cateRule; //订单的分类规则 1收费 2收费租赁 3免费 4免费租赁
    private RefundLogsVO refundLogsVO;

    private Integer totalServiceCount;
    private Integer waitServiceCount;
    private Integer finishService;
    private String serviceAddress;
    private String serviceMobile;
    private String serviceName;
    private Integer serviceLength;
    private Date closingDate;//截止日期


    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public Integer getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(Integer serviceLength) {
        this.serviceLength = serviceLength;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getServiceMobile() {
        return serviceMobile;
    }

    public void setServiceMobile(String serviceMobile) {
        this.serviceMobile = serviceMobile;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public RefundLogsVO getRefundLogsVO() {
        return refundLogsVO;
    }

    public void setRefundLogsVO(RefundLogsVO refundLogsVO) {
        this.refundLogsVO = refundLogsVO;
    }

    public Integer getTotalServiceCount() {
        return totalServiceCount;
    }

    public void setTotalServiceCount(Integer totalServiceCount) {
        this.totalServiceCount = totalServiceCount;
    }

    public Integer getWaitServiceCount() {
        return waitServiceCount;
    }

    public void setWaitServiceCount(Integer waitServiceCount) {
        this.waitServiceCount = waitServiceCount;
    }

    public Integer getFinishService() {
        return finishService;
    }

    public void setFinishService(Integer finishService) {
        this.finishService = finishService;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public List<ServiceVO> getServiceVOList() {
        return serviceVOList;
    }

    public void setServiceVOList(List<ServiceVO> serviceVOList) {
        this.serviceVOList = serviceVOList;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelUniqueNo() {
        return hotelUniqueNo;
    }

    public void setHotelUniqueNo(String hotelUniqueNo) {
        this.hotelUniqueNo = hotelUniqueNo;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getHotelOrderSn() {
        return hotelOrderSn;
    }

    public void setHotelOrderSn(String hotelOrderSn) {
        this.hotelOrderSn = hotelOrderSn;
    }

    public String getHotelRecOrderSn() {
        return hotelRecOrderSn;
    }

    public void setHotelRecOrderSn(String hotelRecOrderSn) {
        this.hotelRecOrderSn = hotelRecOrderSn;
    }

    public String getHotelTelNo() {
        return hotelTelNo;
    }

    public void setHotelTelNo(String hotelTelNo) {
        this.hotelTelNo = hotelTelNo;
    }

    public String getHotelRoomNo() {
        return hotelRoomNo;
    }

    public void setHotelRoomNo(String hotelRoomNo) {
        this.hotelRoomNo = hotelRoomNo;
    }

    public String getHoBillId() {
        return hoBillId;
    }

    public void setHoBillId(String hoBillId) {
        this.hoBillId = hoBillId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getShipmentTime() {
        return shipmentTime;
    }

    public void setShipmentTime(Date shipmentTime) {
        this.shipmentTime = shipmentTime;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getMemberTelNo() {
        return memberTelNo;
    }

    public void setMemberTelNo(String memberTelNo) {
        this.memberTelNo = memberTelNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberIdType() {
        return memberIdType;
    }

    public void setMemberIdType(String memberIdType) {
        this.memberIdType = memberIdType;
    }

    public String getMemberIdNo() {
        return memberIdNo;
    }

    public void setMemberIdNo(String memberIdNo) {
        this.memberIdNo = memberIdNo;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddr() {
        return shipAddr;
    }

    public void setShipAddr(String shipAddr) {
        this.shipAddr = shipAddr;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail;
    }

    public String getShipMobile() {
        return shipMobile;
    }

    public void setShipMobile(String shipMobile) {
        this.shipMobile = shipMobile;
    }

    public String getShipTel() {
        return shipTel;
    }

    public void setShipTel(String shipTel) {
        this.shipTel = shipTel;
    }

    public String getShipDay() {
        return shipDay;
    }

    public void setShipDay(String shipDay) {
        this.shipDay = shipDay;
    }

    public String getShipTime() {
        return shipTime;
    }

    public void setShipTime(String shipTime) {
        this.shipTime = shipTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    public String getTheSign() {
        return theSign;
    }

    public void setTheSign(String theSign) {
        this.theSign = theSign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getAllocationTime() {
        return allocationTime;
    }

    public void setAllocationTime(Date allocationTime) {
        this.allocationTime = allocationTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public List<OrderItemsVO> getOrderItemsVOList() {
        return orderItemsVOList;
    }

    public void setOrderItemsVOList(List<OrderItemsVO> orderItemsVOList) {
        this.orderItemsVOList = orderItemsVOList;
    }

    public String getStorePayFlag() {
        return storePayFlag;
    }

    public void setStorePayFlag(String storePayFlag) {
        this.storePayFlag = storePayFlag;
    }

    public String getPaidCancelFlag() {
        return paidCancelFlag;
    }

    public void setPaidCancelFlag(String paidCancelFlag) {
        this.paidCancelFlag = paidCancelFlag;
    }

    public Integer getPayCountdown() {
        return payCountdown;
    }

    public void setPayCountdown(Integer payCountdown) {
        this.payCountdown = payCountdown;
    }

    public String getGoodsShow() {
        return goodsShow;
    }

    public void setGoodsShow(String goodsShow) {
        this.goodsShow = goodsShow;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public Integer getLastCancelHours() {
        return lastCancelHours;
    }

    public void setLastCancelHours(Integer lastCancelHours) {
        this.lastCancelHours = lastCancelHours;
    }

    public String getLastCancelTime() {
        return lastCancelTime;
    }

    public void setLastCancelTime(String lastCancelTime) {
        this.lastCancelTime = lastCancelTime;
    }

    public BigDecimal getCancelCalcFee() {
        return cancelCalcFee;
    }

    public void setCancelCalcFee(BigDecimal cancelCalcFee) {
        this.cancelCalcFee = cancelCalcFee;
    }

    public RulesVO getRulesVO() {
        return rulesVO;
    }

    public void setRulesVO(RulesVO rulesVO) {
        this.rulesVO = rulesVO;
    }

    public String getReturnsFlag() {
        return returnsFlag;
    }

    public void setReturnsFlag(String returnsFlag) {
        this.returnsFlag = returnsFlag;
    }

    public Integer getReturnsMinutes() {
        return returnsMinutes;
    }

    public void setReturnsMinutes(Integer returnsMinutes) {
        this.returnsMinutes = returnsMinutes;
    }

    public PaymentVO getPaymentVO() {
        return paymentVO;
    }

    public void setPaymentVO(PaymentVO paymentVO) {
        this.paymentVO = paymentVO;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getOrgTypeName() {
        return DicMap.getDicValue(Constants.GOODSTYPE_BIZSCOPE_PREFIX+bizScope);
    }


    public String getOrgValue() {
        return orgValue;
    }

    public void setOrgValue(String orgValue) {
        this.orgValue = orgValue;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getCanReservationTime() {
        return canReservationTime;
    }

    public void setCanReservationTime(String canReservationTime) {
        this.canReservationTime = canReservationTime;
    }

    public String getRulePromptMsg() {
        return rulePromptMsg;
    }

    public void setRulePromptMsg(String rulePromptMsg) {
        this.rulePromptMsg = rulePromptMsg;
    }

    public String getOrderRuleDescription() {
        return orderRuleDescription;
    }

    public void setOrderRuleDescription(String orderRuleDescription) {
        this.orderRuleDescription = orderRuleDescription;
    }

    public String getReservationFlag() {
        return reservationFlag;
    }

    public void setReservationFlag(String reservationFlag) {
        this.reservationFlag = reservationFlag;
    }

    public String getAccountingFlag() {
        return accountingFlag;
    }

    public void setAccountingFlag(String accountingFlag) {
        this.accountingFlag = accountingFlag;
    }

    public String getCrmPayFlag() {
        return crmPayFlag;
    }

    public void setCrmPayFlag(String crmPayFlag) {
        this.crmPayFlag = crmPayFlag;
    }

    public Integer getSplitProportion() {
        return splitProportion;
    }

    public void setSplitProportion(Integer splitProportion) {
        this.splitProportion = splitProportion;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCityAreaName() {
        return cityAreaName;
    }

    public void setCityAreaName(String cityAreaName) {
        this.cityAreaName = cityAreaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean getAdjustFlag() {
        return adjustFlag;
    }

    public void setAdjustFlag(boolean adjustFlag) {
        this.adjustFlag = adjustFlag;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public boolean isAdjustFlag() {
        return adjustFlag;
    }

    public String getMgrModel() {
        return mgrModel;
    }

    public void setMgrModel(String mgrModel) {
        this.mgrModel = mgrModel;
    }

    public Map<String, Object> getCountOrderListSize() {
        return countOrderListSize;
    }

    public void setCountOrderListSize(Map<String, Object> countOrderListSize) {
        this.countOrderListSize = countOrderListSize;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }

    public String getCateRule() {
        return cateRule;
    }

    public void setCateRule(String cateRule) {
        this.cateRule = cateRule;
    }


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
