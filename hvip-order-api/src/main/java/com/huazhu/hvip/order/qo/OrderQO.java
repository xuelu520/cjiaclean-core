package com.huazhu.hvip.order.qo;

import com.huazhu.hvip.util.ParamsFilterUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created by XUEYONGPING001 on 2016/4/6.
 */
public class OrderQO implements Serializable {

    private String hotelUniqueNo; //酒店统一编号
    private String query;          //名称，身份证等模糊查询
    private Integer index;       //日期(暂不使用)
    private String beginTime;         //起始日期
    private String endTime;            //结束日期
    private Long hotelId;           //酒店编号
    private String hotelOrderSn;  //酒店预订单号
    private String hotelRecOrderSn; //酒店接待单
    private String hotelRoomNo;  //酒店房间号
    private List<String> statusList;//状态
    private String keyword;//模糊查询关键字
    private String sOrderID;//预订单号
    private List<Long> goodsIdList;//商品编号结合
    private List<Long> itemsIdList;//货物编号集合
    private Long goodsId;
    private String goodsName; //商品名称
    private String status;//状态
    private String billType;//是否入账
    private String source;//订单来源
    private String orgType;
    private Integer pageNo;
    private Integer pageSize;
    private Integer queryType; //查询类型 1是首页  2 是接待单
    private Integer flag; // 0是正常查询 1 是反转查询 用于查询来源不是Hotel的金额
    private String createUser; //创建人
    private String pageflag; //判断接待单 预定单
    private Integer year; //年
    private Integer month; //月
    private String orderIDFlag; //判断是否为主单，是否查询预定单
    private List<String> orderSnList;
    private String payType; //支付方式
    private String memberId; //会员ID
    private String loginFlag; //app酒店百宝箱登录和行程助手进来标识
    private String payMethod; //支付方式
    private String dabitStartTime; //查询入账开始时间
    private String dabitEndTime; //查询入账结束时间
    private String cycle;
    private String goodsKeyWord;
    private String memberKeyWord;
    private String goodsSn;
    private String orderSn;
    private String serviceStatus;
    private Long orderId;
    private String bizType;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getGoodsKeyWord() {
        return goodsKeyWord;
    }

    public void setGoodsKeyWord(String goodsKeyWord) {
        this.goodsKeyWord = goodsKeyWord;
    }

    public String getMemberKeyWord() {
        return memberKeyWord;
    }

    public void setMemberKeyWord(String memberKeyWord) {
        this.memberKeyWord = memberKeyWord;
    }

    public String getCreateUser() {

        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getsOrderID() {
        return sOrderID;
    }

    public void setsOrderID(String sOrderID) {
        this.sOrderID = sOrderID;
    }

    public List<Long> getItemsIdList() {
        return itemsIdList;
    }

    public void setItemsIdList(List<Long> itemsIdList) {
        this.itemsIdList = itemsIdList;
    }

    public List<Long> getGoodsIdList() {
        return goodsIdList;
    }

    public void setGoodsIdList(List<Long> goodsIdList) {
        this.goodsIdList = goodsIdList;
    }

    public String getHotelRecOrderSn() {
        return hotelRecOrderSn;
    }

    public void setHotelRecOrderSn(String hotelRecOrderSn) {
        this.hotelRecOrderSn = hotelRecOrderSn;
    }

    public String getHotelRoomNo() {
        return hotelRoomNo;
    }

    public void setHotelRoomNo(String hotelRoomNo) {
        this.hotelRoomNo = hotelRoomNo;
    }

    public String getHotelOrderSn() {
        return ParamsFilterUtil.cleanXSS(hotelOrderSn);
    }

    public void setHotelOrderSn(String hotelOrderSn) {
        this.hotelOrderSn = hotelOrderSn;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getHotelUniqueNo() {
        return hotelUniqueNo;
    }

    public void setHotelUniqueNo(String hotelUniqueNo) {
        this.hotelUniqueNo = hotelUniqueNo;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public String getKeyword() {
        return keyword;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getPageflag() {
        return pageflag;
    }

    public void setPageflag(String pageflag) {
        this.pageflag = pageflag;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getOrderIDFlag() {
        return orderIDFlag;
    }

    public void setOrderIDFlag(String orderIDFlag) {
        this.orderIDFlag = orderIDFlag;
    }

    public List<String> getOrderSnList() {
        return orderSnList;
    }

    public void setOrderSnList(List<String> orderSnList) {
        this.orderSnList = orderSnList;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getDabitStartTime() {
        return dabitStartTime;
    }

    public void setDabitStartTime(String dabitStartTime) {
        this.dabitStartTime = dabitStartTime;
    }

    public String getDabitEndTime() {
        return dabitEndTime;
    }

    public void setDabitEndTime(String dabitEndTime) {
        this.dabitEndTime = dabitEndTime;
    }
}
