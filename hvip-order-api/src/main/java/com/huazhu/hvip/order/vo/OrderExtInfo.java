/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrderExtInfo.java
 * Author:   HUQIANBO001
 * Date:     2016-04-07 16:52:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-07 16:52:48><version><desc>
 */

package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderExtInfo implements Serializable {

    private Date realShipTime; //实际到货时间

    private String realExtJson; //实际到货扩展json字串

    public Date getRealShipTime() {
        return realShipTime;
    }

    public void setRealShipTime(Date realShipTime) {
        this.realShipTime = realShipTime;
    }

    public String getRealExtJson() {
        return realExtJson;
    }

    public void setRealExtJson(String realExtJson) {
        this.realExtJson = realExtJson;
    }
}
