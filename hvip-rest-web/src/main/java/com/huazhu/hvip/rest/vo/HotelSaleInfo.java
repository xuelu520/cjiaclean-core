/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelSaleInfo.java
 * Author:   HUQIANBO001
 * Date:     2016-07-27 11:48:35
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-07-27 11:48:35><version><desc>
 */

package com.huazhu.hvip.rest.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HotelSaleInfo implements Serializable {

    private String hotelId; //酒店编号

    private String hotelNcCode; //酒店ncCode

    private String hotelName; //酒店名称

    private Integer year; //年

    private Integer month; //月

    private BigDecimal totalSales; //销售总额

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelNcCode() {
        return hotelNcCode;
    }

    public void setHotelNcCode(String hotelNcCode) {
        this.hotelNcCode = hotelNcCode;
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

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }
}
