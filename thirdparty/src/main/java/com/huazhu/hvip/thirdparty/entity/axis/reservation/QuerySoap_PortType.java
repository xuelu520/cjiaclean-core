/**
 * QuerySoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public interface QuerySoap_PortType extends java.rmi.Remote {

    /**
     * 通过指定条件获得指定排序预定单列表
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[] queryWithHistoryRecordsOptionAndPageOrderOption(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery query) throws java.rmi.RemoteException;

    /**
     * 通过指定条件获得预定单列表
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[] queryWithHistoryRecordsOptionAndPageOption(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery query) throws java.rmi.RemoteException;

    /**
     * 通过订单号获得预定单信息
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain querySingleRecord(String orderId) throws java.rmi.RemoteException;

    /**
     * 通过第三方订单号获得预定单信息
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain queryResByThirdOrderNo(String thirdOrderNo) throws java.rmi.RemoteException;

    /**
     * 预定单信息
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.FindResultOfListOfEntityResMain queryReservationByParam(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery query) throws java.rmi.RemoteException;
}
