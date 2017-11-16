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

import java.io.Serializable;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class HotelRateParameterVO implements Serializable{
    private String minRate;
    private String maxRate;
    private String rateMoney;

    public String getMinRate() {
        return minRate;
    }

    public void setMinRate(String minRate) {
        this.minRate = minRate;
    }

    public String getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(String maxRate) {
        this.maxRate = maxRate;
    }

    public String getRateMoney() {
        return rateMoney;
    }

    public void setRateMoney(String rateMoney) {
        this.rateMoney = rateMoney;
    }
}
