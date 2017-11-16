/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: RefundLogsService.java
 * Author:   HUQIANBO001
 * Date:     2016-04-07 18:35:05
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-07 18:35:05><version><desc>
 */

package com.huazhu.hvip.order.service;

import com.huazhu.hvip.base.model.ReturnObject;

/**
 * 退款相关接口
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface RefundLogsService {

    ReturnObject getRefundLogsByOrderId(Long orderId);

}
