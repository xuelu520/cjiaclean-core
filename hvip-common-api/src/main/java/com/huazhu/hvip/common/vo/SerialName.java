/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SerialName.java
 * Author:   HUQIANBO001
 * Date:     2016-04-08 13:44:28
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-08 13:44:28><version><desc>
 */

package com.huazhu.hvip.common.vo;

import com.huazhu.hvip.base.constants.Constants;

/**
 *
 * Created by HUQIANBO001 on 2016/3/31.
 */
public enum SerialName {

    ORDER_SN(Constants.SERIALNUM_NAME_ORDERSN), //订单唯一号
    GOODS_SN(Constants.SERIALNUM_NAME_GOODSSN), //商品唯一号
    PAYMENT_SN(Constants.SERIALNUM_NAME_PAYMENTSN), //支付单唯一号
    REFUND_SN(Constants.SERIALNUM_NAME_REFUNDSN), //退货单唯一号

    ORDER_NO(Constants.SERIALNUM_NAME_ORDERNO), //订单号
    GOODS_NO(Constants.SERIALNUM_NAME_GOODSNO), //商品号
    DEBITPAY_NO(Constants.SERIALNUM_NAME_DEBITPAYNO);

    private String code;

    public String getCode() {
        return this.code;
    }

    private SerialName(String code) {
        this.code = code;
    }

    public String toString() {
        return this.name();
    }

}
