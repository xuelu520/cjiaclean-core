/**
 * QuerySoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.liveRec;

public interface QuerySoap_PortType extends java.rmi.Remote {

    /**
     * 通过手机号查询获得在住接待单列表
     */
    public EntityRecMain[] getLiveReceptionListByMemMobile(String sHotelID, String sMemMobile) throws java.rmi.RemoteException;

    /**
     * 通过身份证查询获得在住接待单列表
     */
    public EntityRecMain[] getLiveReceptionListByIDCard(String sHotelID, String sIDCard) throws java.rmi.RemoteException;

    /**
     * 通过会员卡查询获得在住接待单列表
     */
    public EntityRecMain[] getLiveReceptionListByVCard(String sBookerID) throws java.rmi.RemoteException;

    /**
     * 通过酒店ID房卡查询获得在住接待单列表
     */
    public EntityRecMain[] getLiveReceptionListByRoomCard(String sHotelID, String sRoomNo) throws java.rmi.RemoteException;

    /**
     * 通过会员卡查询获得在住接待单列表
     */
    public EntityRecMain[] getLiveReceptionListByVCardIDCard(String sBookerID, String sIDCard) throws java.rmi.RemoteException;

    /**
     * 根据接待单号查询获得在住接待单列表
     */
    public EntityRecMain[] getLiveReceptionListByReceiveID(String sReceiveID) throws java.rmi.RemoteException;

    /**
     * 根据动态参数查询对应的接待单列表
     */
    public EntityRecMain[] getLiveReceptionListByParams(EntityGetRecParams recParams) throws java.rmi.RemoteException;

    /**
     * 根据酒店ID、房间号、V卡号、手机号查询分页在住接待单列表
     * @param sHotelID 酒店Id
     * @param lRoomNo 房间号
     * @param lMobile 手机号
     * @param lBookerID 预订人Id
     * @param iPageIndex 开始页码
     * @param iPageSize 每页长度
     * @return
     * @throws java.rmi.RemoteException
     */
    public LiveRecInfoPageList getLiveReceptionPageListByHotelID(String sHotelID, String[] lRoomNo, String[] lMobile, String[] lBookerID, int iPageIndex, int iPageSize) throws java.rmi.RemoteException;
}
