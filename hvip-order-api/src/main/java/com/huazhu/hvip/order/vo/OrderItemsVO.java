package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
public class OrderItemsVO implements Serializable {

    private Long itemsId;
    private Long orderId;
    private Long goodsId;
    private String goodsName;
    private String goodsNo;
    private String goodsSn;
    private Long goodsPicId;
    private String specJson;
    private Long productId;
    private String productName;
    private String productNo;
    private String productSn;
    private Integer salesNum;
    private Integer shipNum;
    private String status;
    private String unit;
    private BigDecimal cost;
    private BigDecimal price;
    private Long channelPriceId;
    private String assignPerson;
    private String assignTelNo;
    private Date assignTime;
    private String assignExtJson;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    private OrderVO orderVO;
    private RulesVO rulesVO;
    private String statusName;//状态名
    private String shipStatusName; //发货状态
    private String assignTimeToStr;//服务时间格式化
    private Boolean flag;//操作标志判断
    private String operatorId;//操作人
    private String orderNo;//华住订单号
    private HotelInfoVO hotelInfoVO;
    private String address;
    private Long telNo;
    private Integer pageCount; //分页总页数
    private Date shipmentsCreateTime;
    private Date payTime;
    private String source;
    private String orderSn;
    private String orderCreateUser;
    private String orderUpdateUser;
    private String orderStatus;
    private Date orderCreateTime;
    private String billType;
    private String bizDate; //值班日
    private String payType; //支付方式
    private BigDecimal orderALLAcmount;//订单总金额
    private BigInteger saleUserNumber; //人员销售数量
    private BigDecimal saleUserMoney; //员工销售金额
    private BigDecimal H5Money; //H5渠道的金额
    private BigDecimal APPMoney; //APP渠道
    private OrderGoodsPictureVO defaultGoodsPicture; //默认图片
    private String recordingUser; //入账人
    private Date hoCheckOutDate;//离店时间
    private Date hoCheckInDate; //入住时间
    private String cycle;
    private Integer serviceLength;
    private String bizScope;


    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public Integer getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(Integer serviceLength) {
        this.serviceLength = serviceLength;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAssignTimeToStr() {
        return assignTimeToStr;
    }

    public void setAssignTimeToStr(String assignTimeToStr) {
        this.assignTimeToStr = assignTimeToStr;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public OrderVO getOrderVO() {
        return orderVO;
    }

    public void setOrderVO(OrderVO orderVO) {
        this.orderVO = orderVO;
    }

    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public Long getGoodsPicId() {
        return goodsPicId;
    }

    public void setGoodsPicId(Long goodsPicId) {
        this.goodsPicId = goodsPicId;
    }

    public String getSpecJson() {
        return specJson;
    }

    public void setSpecJson(String specJson) {
        this.specJson = specJson;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    public Integer getShipNum() {
        return shipNum;
    }

    public void setShipNum(Integer shipNum) {
        this.shipNum = shipNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getChannelPriceId() {
        return channelPriceId;
    }

    public void setChannelPriceId(Long channelPriceId) {
        this.channelPriceId = channelPriceId;
    }

    public String getAssignPerson() {
        return assignPerson;
    }

    public void setAssignPerson(String assignPerson) {
        this.assignPerson = assignPerson;
    }

    public String getAssignTelNo() {
        return assignTelNo;
    }

    public void setAssignTelNo(String assignTelNo) {
        this.assignTelNo = assignTelNo;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public String getAssignExtJson() {
        return assignExtJson;
    }

    public void setAssignExtJson(String assignExtJson) {
        this.assignExtJson = assignExtJson;
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

    public OrderGoodsPictureVO getDefaultGoodsPicture() {
        return defaultGoodsPicture;
    }

    public void setDefaultGoodsPicture(OrderGoodsPictureVO defaultGoodsPicture) {
        this.defaultGoodsPicture = defaultGoodsPicture;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public HotelInfoVO getHotelInfoVO() {
        return hotelInfoVO;
    }
    public void setHotelInfoVO(HotelInfoVO hotelInfoVO) {
        this.hotelInfoVO = hotelInfoVO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelNo() {
        return telNo;
    }

    public void setTelNo(Long telNo) {
        this.telNo = telNo;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getShipStatusName() {
        return shipStatusName;
    }

    public void setShipStatusName(String shipStatusName) {
        this.shipStatusName = shipStatusName;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public RulesVO getRulesVO() {
        return rulesVO;
    }

    public void setRulesVO(RulesVO rulesVO) {
        this.rulesVO = rulesVO;
    }

    public Date getShipmentsCreateTime() {
        return shipmentsCreateTime;
    }

    public void setShipmentsCreateTime(Date shipmentsCreateTime) {
        this.shipmentsCreateTime = shipmentsCreateTime;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderUpdateUser() {
        return orderUpdateUser;
    }

    public void setOrderUpdateUser(String orderUpdateUser) {
        this.orderUpdateUser = orderUpdateUser;
    }

    public String getOrderCreateUser() {
        return orderCreateUser;
    }

    public void setOrderCreateUser(String orderCreateUser) {
        this.orderCreateUser = orderCreateUser;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBizDate() {
        return bizDate;
    }
    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public BigDecimal getOrderALLAcmount() {
        return orderALLAcmount;
    }

    public void setOrderALLAcmount(BigDecimal orderALLAcmount) {
        this.orderALLAcmount = orderALLAcmount;
    }

    public BigInteger getSaleUserNumber() {
        return saleUserNumber;
    }

    public void setSaleUserNumber(BigInteger saleUserNumber) {
        this.saleUserNumber = saleUserNumber;
    }

    public BigDecimal getSaleUserMoney() {
        return saleUserMoney;
    }

    public void setSaleUserMoney(BigDecimal saleUserMoney) {
        this.saleUserMoney = saleUserMoney;
    }

    public BigDecimal getH5Money() {
        return H5Money;
    }

    public void setH5Money(BigDecimal h5Money) {
        H5Money = h5Money;
    }

    public BigDecimal getAPPMoney() {
        return APPMoney;
    }

    public void setAPPMoney(BigDecimal APPMoney) {
        this.APPMoney = APPMoney;
    }

    public String getRecordingUser() {
        return recordingUser;
    }

    public void setRecordingUser(String recordingUser) {
        this.recordingUser = recordingUser;
    }

    public Date getHoCheckOutDate() {
        return hoCheckOutDate;
    }

    public void setHoCheckOutDate(Date hoCheckOutDate) {
        this.hoCheckOutDate = hoCheckOutDate;
    }

    public Date getHoCheckInDate() {
        return hoCheckInDate;
    }

    public void setHoCheckInDate(Date hoCheckInDate) {
        this.hoCheckInDate = hoCheckInDate;
    }
}
