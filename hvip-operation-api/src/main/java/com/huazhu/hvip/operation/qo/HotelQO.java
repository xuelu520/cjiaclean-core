/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelQO.java
 * Author:   HUQIANBO001
 * Date:     2016-04-14 09:58:22
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-14 09:58:22><version><desc>
 */

package com.huazhu.hvip.operation.qo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HotelQO implements Serializable {

    private String hotelUniqueNo; //酒店统一编号

    private String hotelNo; //酒店编号

    private String openVipFlag; //酒店是否开通
    private String hotelId; //酒店Id
    private String createUser; //申请人
    private Map<Long,String> paramMap; //装参数的MAP
    private boolean flag; //更新酒店类型用到的flag
    private List<String> goodsIdList; //商品ID


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

    public String getOpenVipFlag() {
        return openVipFlag;
    }

    public void setOpenVipFlag(String openVipFlag) {
        this.openVipFlag = openVipFlag;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Map<Long,String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<Long,String> paramMap) {
        this.paramMap = paramMap;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<String> getGoodsIdList() {
        return goodsIdList;
    }

    public void setGoodsIdList(List<String> goodsIdList) {
        this.goodsIdList = goodsIdList;
    }
}
