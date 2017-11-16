/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeService.java
 * Author:   admin
 * Date:     2016-03-20 17:28:32
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 17:28:32><version><desc>
 */

package com.huazhu.hvip.common.service.impl;


import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.common.manager.SerialNumManager;
import com.huazhu.hvip.common.service.SerialNumService;
import com.huazhu.hvip.common.vo.SerialName;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("serialNumService")
public class SerialNumServiceImpl implements SerialNumService {

    private static Logger logger = LogManager.getLogger(SerialNumServiceImpl.class);

    private SerialNumManager serialNumManager;
    @Autowired
    public void setSerialNumManager(SerialNumManager serialNumManager) {
        this.serialNumManager = serialNumManager;
    }

    /**
     * 生成订单号
     *
     * @return
     */
    @Override
    public String generateOrderNo() {
        logger.info("serialNumService.generateOrderNo() start... ");

        String orderNo = null;
        try {
            orderNo = serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_ORDERNO);

            logger.info("serialNumService.getOrderNo() success! orderNo: "+orderNo);
        } catch (Exception e) {
            logger.error("生成订单号失败",e);
        }

        return orderNo;
    }

    /**
     * 生成订单唯一号
     *
     * @return
     */
    @Override
    public String generateOrderSn() {
        logger.info("serialNumService.generateOrderSn() start... ");

        String orderSn = null;
        try {
            orderSn = serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_ORDERSN);

            logger.info("serialNumService.getOrderSn() success! orderSn: " + orderSn);
        } catch (Exception e) {
            logger.error("生成订单唯一号失败",e);
        }

        return orderSn;
    }

    /**
     * 生成支付单唯一流水号
     *
     * @return
     */
    @Override
    public String generatePaymentSn() {
        logger.info("serialNumService.generatePaymentSn() start... ");

        String paymentSn = null;
        try {
            paymentSn = serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_PAYMENTSN);

            logger.info("serialNumService.generatePaymentSn() success! orderSn: " + paymentSn);
        } catch (Exception e) {
            logger.error("生成付单唯一流水号失败",e);
        }

        return paymentSn;
    }

    /**
     * 生成商品号
     *
     * @return
     */
    @Override
    public String generateGoodsNo() {
        logger.info("serialNumService.generateGoodsNo() start... ");

        String goodsNo = null;
        try {
            goodsNo = serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_GOODSNO);

            logger.info("serialNumService.generateGoodsNo() success! goodsNo: " + goodsNo);
        } catch (Exception e) {
            logger.error("生成商品号失败",e);
        }

        return goodsNo;
    }
    /**
     * 生成商品号
     *
     * @return
     */
    @Override
    public String generateVoucherNo() {
        logger.info("serialNumService.generateVoucherNo() start... ");
        String voucherNo=null;
        try {
            voucherNo=serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_VOUCHERNO);
            logger.info("serialNumService.generateVoucherNo() success! voucherNo: " + voucherNo);
        } catch (Exception e) {
            logger.error("生成商品号失败", e);
        }
        return voucherNo;
    }

    /**
     * 生成商品唯一号
     *
     * @return
     */
    @Override
    public String generateGoodsSn() {
        logger.info("serialNumService.generateGoodsSn() start... ");

        String goodsSn = null;
        try {
            goodsSn = serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_GOODSSN);

            logger.info("serialNumService.generateGoodsSn() success! goodsSn: " + goodsSn);
        } catch (Exception e) {
            logger.error("生成商品唯一号失败",e);
        }

        return goodsSn;
    }
    /**
     * 生成保洁员唯一号
     *
     * @return
     */
    @Override
    public String generateCleanNo() {
        logger.info("serialNumService.generateCleanNo() start... ");

        String employeeNo = null;
        try {
            employeeNo = serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_EMPLOYEENO);
            logger.info("serialNumService.generateCleanNo() success! employeeNo: " + employeeNo);
        } catch (Exception e) {
            logger.error("生成保洁员唯一号失败",e);
        }

        return employeeNo;
    }

    /**
     * 生成商品唯一号
     *
     * @return
     */
    @Override
    public String generateServiceSn() {
        logger.info("serialNumService.generateServiceSn() start... ");

        String  serviceSn= null;
        try {
            serviceSn = serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_SERVICESN);
            logger.info("serialNumService.generateServiceSn() success! serviceSn: " + serviceSn);
        } catch (Exception e) {
            logger.error("生成工单唯一号失败",e);
        }

        return serviceSn;
    }


    /**
     * 生成商品唯一号
     *
     * @return
     */
    @Override
    public String generateRefundSn() {
        logger.info("serialNumService.generateServiceSn() start... ");

        String  refundSn= null;
        try {
            refundSn = serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_REFUNDSN);
            logger.info("serialNumService.generateRefundSn() success! refundSn: " + refundSn);
        } catch (Exception e) {
            logger.error("生退款唯一号失败",e);
        }

        return refundSn;
    }

    @Override
    public String generateHotelSn() {
        logger.info("serialNumService.generateHotelSn() start... ");

        String  hotelSn= null;
        try {
            hotelSn = serialNumManager.createSerialNumber(Constants.SERIALNUM_NAME_HOTELSN);
            logger.info("serialNumService.generateHotelSn() success! RefundSn: " + hotelSn);
        } catch (Exception e) {
            logger.error("生退款唯一号失败",e);
        }

        return hotelSn;
    }

    /**
     * 生成序号
     *
     * @param serialName
     * @return
     */
    @Override
    public String generateSnCommon(SerialName serialName) {
        logger.info("serialNumService.generateSnCommon() start... serialName: {"+ serialName+"}");

        String serialNum = null;
        try {
            serialNum = serialNumManager.createSerialNumber(serialName.getCode());

            logger.info("serialNumService.generateSnCommon() success! serialNum: " + serialNum);
        } catch (Exception e) {
            logger.error("生成商品唯一号失败",e);
        }

        return serialNum;
    }


}
