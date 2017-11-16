/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelCate.java
 * Author:   chenli
 * Date:     2016-03-23 17:52:05
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:52:05> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.vo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class HotelCateVO implements Serializable{

    private Long hotelCateId;
    private Long hotelId; //酒店id
    private Long cateId; //分类id
    private String cateName; //分类名称
    private Date beginTime; //开通时间
    private Date endTime; //结束时间
    private String deleteFlag; //是否删除：0否 1是
    private String createUser; //创建人

    public Long getHotelCateId() {
        return hotelCateId;
    }

    public void setHotelCateId(Long hotelCateId) {
        this.hotelCateId = hotelCateId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
