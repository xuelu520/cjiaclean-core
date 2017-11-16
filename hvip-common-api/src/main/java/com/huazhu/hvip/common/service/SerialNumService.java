/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeService.java
 * Author:   admin
 * Date:     2016-03-20 17:28:32
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 17:28:32><version><desc>
 */

package com.huazhu.hvip.common.service;


import com.huazhu.hvip.common.vo.SerialName;

/**
 * 自增长序列
 *
 * @author cqm
 */
public interface SerialNumService {

    /**
     * 生成订单号
     *
     * @return
     */
    String generateOrderNo();

    /**
     * 生成订单唯一号
     *
     * @return
     */
    String generateOrderSn();

    /**
     * 生成支付单唯一流水号
     *
     * @return
     */
    String generatePaymentSn();

    /**
     * 生成商品号
     *
     * @return
     */
    String generateGoodsNo();

    /**
     * 生成商品唯一号
     *
     * @return
     */
    String generateVoucherNo();

    /**
     * 生成序号
     *
     * @param serialName
     * @return
     */
    String generateSnCommon(SerialName serialName);

    /**
     * 生成商品唯一号
     *
     * @return
     */
    String generateGoodsSn();


    /**
     * 生成商品唯一号
     *
     * @return
     */
    String generateCleanNo();

    /**
     * 生成商品唯一号
     *
     * @return
     */
    String generateServiceSn();

    /**
     * 退款单流水号
     * @return
     */
    String generateRefundSn();


    /**
     * 退款单流水号
     * @return
     */
    String generateHotelSn();
}
