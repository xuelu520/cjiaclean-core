package com.huazhu.hvip.operation.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cmy on 2016/6/19.
 */
public class HotelDataVO  implements Serializable {
    private List<HotelOperateVO> hotelOperateVOList;

    public List<HotelOperateVO> getHotelOperateVOList() {
        return hotelOperateVOList;
    }

    public void setHotelOperateVOList(List<HotelOperateVO> hotelOperateVOList) {
        this.hotelOperateVOList = hotelOperateVOList;
    }
}
