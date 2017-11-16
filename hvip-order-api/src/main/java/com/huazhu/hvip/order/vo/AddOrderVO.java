package com.huazhu.hvip.order.vo;

import com.huazhu.hvip.base.model.OperatorInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
public class AddOrderVO implements Serializable {

    private MemberInfoVO memberInfoVO; //会员信息

    private String shipName; //收货人

    private HotelInfoVO hotelInfoVO;

    private String remark; //备注

    private List<AddOrderItemVO> addOrderItemVOList; //订单货物

    private String channelCode; //渠道

    private String source; //订单来源，例如app,h5,hms

    private OperatorInfo operatorInfo; //操作人信息

    private String type;  //订单的类型

    public MemberInfoVO getMemberInfoVO() {
        return memberInfoVO;
    }

    public void setMemberInfoVO(MemberInfoVO memberInfoVO) {
        this.memberInfoVO = memberInfoVO;
    }

    public HotelInfoVO getHotelInfoVO() {
        return hotelInfoVO;
    }

    public void setHotelInfoVO(HotelInfoVO hotelInfoVO) {
        this.hotelInfoVO = hotelInfoVO;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<AddOrderItemVO> getAddOrderItemVOList() {
        return addOrderItemVOList;
    }

    public void setAddOrderItemVOList(List<AddOrderItemVO> addOrderItemVOList) {
        this.addOrderItemVOList = addOrderItemVOList;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }

    public void setOperatorInfo(OperatorInfo operatorInfo) {
        this.operatorInfo = operatorInfo;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
