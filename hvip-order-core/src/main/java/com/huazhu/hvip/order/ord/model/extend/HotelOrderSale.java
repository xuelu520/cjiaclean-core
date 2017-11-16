/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelOrderSale.java
 * Author:   HUQIANBO001
 * Date:     2016-07-29 17:50:05
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-07-29 17:50:05><version><desc>
 */

package com.huazhu.hvip.order.ord.model.extend;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
public class HotelOrderSale extends DynamicField {

    private Long hotelId; //酒店id

    private String hotelNo; //酒店编号

    private String hotelName; //酒店名称

    private Integer year; //年

    private Integer month; //月

    private BigDecimal sale; //销售额

    @Id
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }
}
