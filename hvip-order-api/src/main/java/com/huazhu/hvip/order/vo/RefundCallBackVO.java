/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: RefundCallBackVO.java
 * Author:   HUQIANBO001
 * Date:     2016-04-08 14:22:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-08 14:22:01><version><desc>
 */

package com.huazhu.hvip.order.vo;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RefundCallBackVO implements Serializable {

    private String refundSn; //退款单号
    private Double totalAmount; //退款金额
    private String refundRequest; //支付请求字串
    private String refundResponse; //支付相应字串
    private String remark; //备注

    public String getRefundSn() {
        return refundSn;
    }

    public void setRefundSn(String refundSn) {
        this.refundSn = refundSn;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRefundRequest() {
        return refundRequest;
    }

    public void setRefundRequest(String refundRequest) {
        this.refundRequest = refundRequest;
    }

    public String getRefundResponse() {
        return refundResponse;
    }

    public void setRefundResponse(String refundResponse) {
        this.refundResponse = refundResponse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
