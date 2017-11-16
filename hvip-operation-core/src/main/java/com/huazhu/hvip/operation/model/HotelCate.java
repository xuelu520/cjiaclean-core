/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelCate.java
 * Author:   chenli
 * Date:     2016-03-23 17:11:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:11:41> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
public class HotelCate extends DynamicField {
    private Long hotelCateId;
    private Long hotelId; //酒店id
    private Long cateId; //分类id
    private String cateName; //分类名称
    private Date beginTime; //开通时间
    private Date endTime; //结束时间
    private String deleteFlag; //是否删除：0否 1是
    private String createUser; //创建人

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotelCateId")
    public Long getHotelCateId() {
        return hotelCateId;
    }

    public void setHotelCateId(Long hotelCateId) {
        this.hotelCateId = hotelCateId;
    }

    @Basic
    @Column(name = "hotelId")
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "cateId")
    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "cateName")
    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Basic
    @Column(name = "beginTime")
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "endTime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Basic
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

}
