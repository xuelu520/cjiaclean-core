/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DeductGoodsStoreVO.java
 * Author:   HUQIANBO001
 * Date:     2016-04-06 13:47:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-06 13:47:42><version><desc>
 */

package com.huazhu.hvip.product.vo;

import com.huazhu.hvip.base.model.OperatorInfo;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ChangeGoodsStoreVO implements Serializable {

    private Long hotelId; //酒店id

    private List<ChangeStoreInfoVO> changeStoreInfoVOList;

    private OperatorInfo operatorInfo; //操作人信息



    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public List<ChangeStoreInfoVO> getChangeStoreInfoVOList() {
        return changeStoreInfoVOList;
    }

    public void setChangeStoreInfoVOList(List<ChangeStoreInfoVO> changeStoreInfoVOList) {
        this.changeStoreInfoVOList = changeStoreInfoVOList;
    }

    public OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }

    public void setOperatorInfo(OperatorInfo operatorInfo) {
        this.operatorInfo = operatorInfo;
    }
}
