/**
 * EntityResMain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public class EntityResMain  implements java.io.Serializable {
    private String sOrderID;

    private String sCusCategoryID;

    private String sCardNo;

    private String sRefNo;

    private String sContractNo;

    private String sGroupID;

    private String sGroupName;

    private String sCRSNo;

    private String dCRSUserID;

    private String sSrcID;

    private String sBookerID;

    private String sBookerLevel;

    private String sLinkFax;

    private String sLinkEmail;

    private java.util.Calendar dArrDate;

    private java.util.Calendar dDepDate;

    private java.util.Calendar dArrTime;

    private java.util.Calendar dKeepTime;

    private int iDays;

    private boolean bIsWaitHis;

    private int iPrintCnt;

    private boolean bIsWait;

    private String sOrderStatus;

    private String sMemo;

    private String sAssType;

    private String sLinkName;

    private String sLinkMobile;

    private String sLinkPhone;

    private String sRcpType;

    private String sMemName;

    private String sMemPhone;

    private String sMemEmail;

    private String sMemFax;

    private String sCompanyName;

    private String sMemMobile;

    private String sHotelID;

    private java.util.Calendar dCreateDate;

    private java.util.Calendar dModifyDate;

    private String sOperatorID;

    private String sBillID;

    private java.util.Calendar dBizDay;

    private String sShiftID;

    private String sActivityCode;

    private boolean bIsGiveBreakfast;

    private boolean isDelete;

    private com.huazhu.hvip.thirdparty.entity.axis.reservation.SheetGuest linkmanInfo;

    private com.huazhu.hvip.thirdparty.entity.axis.reservation.CustomerCategory categoryInfo;

    private String orderSeqNo;

    private com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetail[] listDetail;

    public EntityResMain() {
    }

    public EntityResMain(
           String sOrderID,
           String sCusCategoryID,
           String sCardNo,
           String sRefNo,
           String sContractNo,
           String sGroupID,
           String sGroupName,
           String sCRSNo,
           String dCRSUserID,
           String sSrcID,
           String sBookerID,
           String sBookerLevel,
           String sLinkFax,
           String sLinkEmail,
           java.util.Calendar dArrDate,
           java.util.Calendar dDepDate,
           java.util.Calendar dArrTime,
           java.util.Calendar dKeepTime,
           int iDays,
           boolean bIsWaitHis,
           int iPrintCnt,
           boolean bIsWait,
           String sOrderStatus,
           String sMemo,
           String sAssType,
           String sLinkName,
           String sLinkMobile,
           String sLinkPhone,
           String sRcpType,
           String sMemName,
           String sMemPhone,
           String sMemEmail,
           String sMemFax,
           String sCompanyName,
           String sMemMobile,
           String sHotelID,
           java.util.Calendar dCreateDate,
           java.util.Calendar dModifyDate,
           String sOperatorID,
           String sBillID,
           java.util.Calendar dBizDay,
           String sShiftID,
           String sActivityCode,
           boolean bIsGiveBreakfast,
           boolean isDelete,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.SheetGuest linkmanInfo,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.CustomerCategory categoryInfo,
           String orderSeqNo,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetail[] listDetail) {
           this.sOrderID = sOrderID;
           this.sCusCategoryID = sCusCategoryID;
           this.sCardNo = sCardNo;
           this.sRefNo = sRefNo;
           this.sContractNo = sContractNo;
           this.sGroupID = sGroupID;
           this.sGroupName = sGroupName;
           this.sCRSNo = sCRSNo;
           this.dCRSUserID = dCRSUserID;
           this.sSrcID = sSrcID;
           this.sBookerID = sBookerID;
           this.sBookerLevel = sBookerLevel;
           this.sLinkFax = sLinkFax;
           this.sLinkEmail = sLinkEmail;
           this.dArrDate = dArrDate;
           this.dDepDate = dDepDate;
           this.dArrTime = dArrTime;
           this.dKeepTime = dKeepTime;
           this.iDays = iDays;
           this.bIsWaitHis = bIsWaitHis;
           this.iPrintCnt = iPrintCnt;
           this.bIsWait = bIsWait;
           this.sOrderStatus = sOrderStatus;
           this.sMemo = sMemo;
           this.sAssType = sAssType;
           this.sLinkName = sLinkName;
           this.sLinkMobile = sLinkMobile;
           this.sLinkPhone = sLinkPhone;
           this.sRcpType = sRcpType;
           this.sMemName = sMemName;
           this.sMemPhone = sMemPhone;
           this.sMemEmail = sMemEmail;
           this.sMemFax = sMemFax;
           this.sCompanyName = sCompanyName;
           this.sMemMobile = sMemMobile;
           this.sHotelID = sHotelID;
           this.dCreateDate = dCreateDate;
           this.dModifyDate = dModifyDate;
           this.sOperatorID = sOperatorID;
           this.sBillID = sBillID;
           this.dBizDay = dBizDay;
           this.sShiftID = sShiftID;
           this.sActivityCode = sActivityCode;
           this.bIsGiveBreakfast = bIsGiveBreakfast;
           this.isDelete = isDelete;
           this.linkmanInfo = linkmanInfo;
           this.categoryInfo = categoryInfo;
           this.orderSeqNo = orderSeqNo;
           this.listDetail = listDetail;
    }


    /**
     * Gets the sOrderID value for this EntityResMain.
     *
     * @return sOrderID
     */
    public String getSOrderID() {
        return sOrderID;
    }


    /**
     * Sets the sOrderID value for this EntityResMain.
     *
     * @param sOrderID
     */
    public void setSOrderID(String sOrderID) {
        this.sOrderID = sOrderID;
    }


    /**
     * Gets the sCusCategoryID value for this EntityResMain.
     *
     * @return sCusCategoryID
     */
    public String getSCusCategoryID() {
        return sCusCategoryID;
    }


    /**
     * Sets the sCusCategoryID value for this EntityResMain.
     *
     * @param sCusCategoryID
     */
    public void setSCusCategoryID(String sCusCategoryID) {
        this.sCusCategoryID = sCusCategoryID;
    }


    /**
     * Gets the sCardNo value for this EntityResMain.
     *
     * @return sCardNo
     */
    public String getSCardNo() {
        return sCardNo;
    }


    /**
     * Sets the sCardNo value for this EntityResMain.
     *
     * @param sCardNo
     */
    public void setSCardNo(String sCardNo) {
        this.sCardNo = sCardNo;
    }


    /**
     * Gets the sRefNo value for this EntityResMain.
     *
     * @return sRefNo
     */
    public String getSRefNo() {
        return sRefNo;
    }


    /**
     * Sets the sRefNo value for this EntityResMain.
     *
     * @param sRefNo
     */
    public void setSRefNo(String sRefNo) {
        this.sRefNo = sRefNo;
    }


    /**
     * Gets the sContractNo value for this EntityResMain.
     *
     * @return sContractNo
     */
    public String getSContractNo() {
        return sContractNo;
    }


    /**
     * Sets the sContractNo value for this EntityResMain.
     *
     * @param sContractNo
     */
    public void setSContractNo(String sContractNo) {
        this.sContractNo = sContractNo;
    }


    /**
     * Gets the sGroupID value for this EntityResMain.
     *
     * @return sGroupID
     */
    public String getSGroupID() {
        return sGroupID;
    }


    /**
     * Sets the sGroupID value for this EntityResMain.
     *
     * @param sGroupID
     */
    public void setSGroupID(String sGroupID) {
        this.sGroupID = sGroupID;
    }


    /**
     * Gets the sGroupName value for this EntityResMain.
     *
     * @return sGroupName
     */
    public String getSGroupName() {
        return sGroupName;
    }


    /**
     * Sets the sGroupName value for this EntityResMain.
     *
     * @param sGroupName
     */
    public void setSGroupName(String sGroupName) {
        this.sGroupName = sGroupName;
    }


    /**
     * Gets the sCRSNo value for this EntityResMain.
     *
     * @return sCRSNo
     */
    public String getSCRSNo() {
        return sCRSNo;
    }


    /**
     * Sets the sCRSNo value for this EntityResMain.
     *
     * @param sCRSNo
     */
    public void setSCRSNo(String sCRSNo) {
        this.sCRSNo = sCRSNo;
    }


    /**
     * Gets the dCRSUserID value for this EntityResMain.
     *
     * @return dCRSUserID
     */
    public String getDCRSUserID() {
        return dCRSUserID;
    }


    /**
     * Sets the dCRSUserID value for this EntityResMain.
     *
     * @param dCRSUserID
     */
    public void setDCRSUserID(String dCRSUserID) {
        this.dCRSUserID = dCRSUserID;
    }


    /**
     * Gets the sSrcID value for this EntityResMain.
     *
     * @return sSrcID
     */
    public String getSSrcID() {
        return sSrcID;
    }


    /**
     * Sets the sSrcID value for this EntityResMain.
     *
     * @param sSrcID
     */
    public void setSSrcID(String sSrcID) {
        this.sSrcID = sSrcID;
    }


    /**
     * Gets the sBookerID value for this EntityResMain.
     *
     * @return sBookerID
     */
    public String getSBookerID() {
        return sBookerID;
    }


    /**
     * Sets the sBookerID value for this EntityResMain.
     *
     * @param sBookerID
     */
    public void setSBookerID(String sBookerID) {
        this.sBookerID = sBookerID;
    }


    /**
     * Gets the sBookerLevel value for this EntityResMain.
     *
     * @return sBookerLevel
     */
    public String getSBookerLevel() {
        return sBookerLevel;
    }


    /**
     * Sets the sBookerLevel value for this EntityResMain.
     *
     * @param sBookerLevel
     */
    public void setSBookerLevel(String sBookerLevel) {
        this.sBookerLevel = sBookerLevel;
    }


    /**
     * Gets the sLinkFax value for this EntityResMain.
     *
     * @return sLinkFax
     */
    public String getSLinkFax() {
        return sLinkFax;
    }


    /**
     * Sets the sLinkFax value for this EntityResMain.
     *
     * @param sLinkFax
     */
    public void setSLinkFax(String sLinkFax) {
        this.sLinkFax = sLinkFax;
    }


    /**
     * Gets the sLinkEmail value for this EntityResMain.
     *
     * @return sLinkEmail
     */
    public String getSLinkEmail() {
        return sLinkEmail;
    }


    /**
     * Sets the sLinkEmail value for this EntityResMain.
     *
     * @param sLinkEmail
     */
    public void setSLinkEmail(String sLinkEmail) {
        this.sLinkEmail = sLinkEmail;
    }


    /**
     * Gets the dArrDate value for this EntityResMain.
     *
     * @return dArrDate
     */
    public java.util.Calendar getDArrDate() {
        return dArrDate;
    }


    /**
     * Sets the dArrDate value for this EntityResMain.
     *
     * @param dArrDate
     */
    public void setDArrDate(java.util.Calendar dArrDate) {
        this.dArrDate = dArrDate;
    }


    /**
     * Gets the dDepDate value for this EntityResMain.
     *
     * @return dDepDate
     */
    public java.util.Calendar getDDepDate() {
        return dDepDate;
    }


    /**
     * Sets the dDepDate value for this EntityResMain.
     *
     * @param dDepDate
     */
    public void setDDepDate(java.util.Calendar dDepDate) {
        this.dDepDate = dDepDate;
    }


    /**
     * Gets the dArrTime value for this EntityResMain.
     *
     * @return dArrTime
     */
    public java.util.Calendar getDArrTime() {
        return dArrTime;
    }


    /**
     * Sets the dArrTime value for this EntityResMain.
     *
     * @param dArrTime
     */
    public void setDArrTime(java.util.Calendar dArrTime) {
        this.dArrTime = dArrTime;
    }


    /**
     * Gets the dKeepTime value for this EntityResMain.
     *
     * @return dKeepTime
     */
    public java.util.Calendar getDKeepTime() {
        return dKeepTime;
    }


    /**
     * Sets the dKeepTime value for this EntityResMain.
     *
     * @param dKeepTime
     */
    public void setDKeepTime(java.util.Calendar dKeepTime) {
        this.dKeepTime = dKeepTime;
    }


    /**
     * Gets the iDays value for this EntityResMain.
     *
     * @return iDays
     */
    public int getIDays() {
        return iDays;
    }


    /**
     * Sets the iDays value for this EntityResMain.
     *
     * @param iDays
     */
    public void setIDays(int iDays) {
        this.iDays = iDays;
    }


    /**
     * Gets the bIsWaitHis value for this EntityResMain.
     *
     * @return bIsWaitHis
     */
    public boolean isBIsWaitHis() {
        return bIsWaitHis;
    }


    /**
     * Sets the bIsWaitHis value for this EntityResMain.
     *
     * @param bIsWaitHis
     */
    public void setBIsWaitHis(boolean bIsWaitHis) {
        this.bIsWaitHis = bIsWaitHis;
    }


    /**
     * Gets the iPrintCnt value for this EntityResMain.
     *
     * @return iPrintCnt
     */
    public int getIPrintCnt() {
        return iPrintCnt;
    }


    /**
     * Sets the iPrintCnt value for this EntityResMain.
     *
     * @param iPrintCnt
     */
    public void setIPrintCnt(int iPrintCnt) {
        this.iPrintCnt = iPrintCnt;
    }


    /**
     * Gets the bIsWait value for this EntityResMain.
     *
     * @return bIsWait
     */
    public boolean isBIsWait() {
        return bIsWait;
    }


    /**
     * Sets the bIsWait value for this EntityResMain.
     *
     * @param bIsWait
     */
    public void setBIsWait(boolean bIsWait) {
        this.bIsWait = bIsWait;
    }


    /**
     * Gets the sOrderStatus value for this EntityResMain.
     *
     * @return sOrderStatus
     */
    public String getSOrderStatus() {
        return sOrderStatus;
    }


    /**
     * Sets the sOrderStatus value for this EntityResMain.
     *
     * @param sOrderStatus
     */
    public void setSOrderStatus(String sOrderStatus) {
        this.sOrderStatus = sOrderStatus;
    }


    /**
     * Gets the sMemo value for this EntityResMain.
     *
     * @return sMemo
     */
    public String getSMemo() {
        return sMemo;
    }


    /**
     * Sets the sMemo value for this EntityResMain.
     *
     * @param sMemo
     */
    public void setSMemo(String sMemo) {
        this.sMemo = sMemo;
    }


    /**
     * Gets the sAssType value for this EntityResMain.
     *
     * @return sAssType
     */
    public String getSAssType() {
        return sAssType;
    }


    /**
     * Sets the sAssType value for this EntityResMain.
     *
     * @param sAssType
     */
    public void setSAssType(String sAssType) {
        this.sAssType = sAssType;
    }


    /**
     * Gets the sLinkName value for this EntityResMain.
     *
     * @return sLinkName
     */
    public String getSLinkName() {
        return sLinkName;
    }


    /**
     * Sets the sLinkName value for this EntityResMain.
     *
     * @param sLinkName
     */
    public void setSLinkName(String sLinkName) {
        this.sLinkName = sLinkName;
    }


    /**
     * Gets the sLinkMobile value for this EntityResMain.
     *
     * @return sLinkMobile
     */
    public String getSLinkMobile() {
        return sLinkMobile;
    }


    /**
     * Sets the sLinkMobile value for this EntityResMain.
     *
     * @param sLinkMobile
     */
    public void setSLinkMobile(String sLinkMobile) {
        this.sLinkMobile = sLinkMobile;
    }


    /**
     * Gets the sLinkPhone value for this EntityResMain.
     *
     * @return sLinkPhone
     */
    public String getSLinkPhone() {
        return sLinkPhone;
    }


    /**
     * Sets the sLinkPhone value for this EntityResMain.
     *
     * @param sLinkPhone
     */
    public void setSLinkPhone(String sLinkPhone) {
        this.sLinkPhone = sLinkPhone;
    }


    /**
     * Gets the sRcpType value for this EntityResMain.
     *
     * @return sRcpType
     */
    public String getSRcpType() {
        return sRcpType;
    }


    /**
     * Sets the sRcpType value for this EntityResMain.
     *
     * @param sRcpType
     */
    public void setSRcpType(String sRcpType) {
        this.sRcpType = sRcpType;
    }


    /**
     * Gets the sMemName value for this EntityResMain.
     *
     * @return sMemName
     */
    public String getSMemName() {
        return sMemName;
    }


    /**
     * Sets the sMemName value for this EntityResMain.
     *
     * @param sMemName
     */
    public void setSMemName(String sMemName) {
        this.sMemName = sMemName;
    }


    /**
     * Gets the sMemPhone value for this EntityResMain.
     *
     * @return sMemPhone
     */
    public String getSMemPhone() {
        return sMemPhone;
    }


    /**
     * Sets the sMemPhone value for this EntityResMain.
     *
     * @param sMemPhone
     */
    public void setSMemPhone(String sMemPhone) {
        this.sMemPhone = sMemPhone;
    }


    /**
     * Gets the sMemEmail value for this EntityResMain.
     *
     * @return sMemEmail
     */
    public String getSMemEmail() {
        return sMemEmail;
    }


    /**
     * Sets the sMemEmail value for this EntityResMain.
     *
     * @param sMemEmail
     */
    public void setSMemEmail(String sMemEmail) {
        this.sMemEmail = sMemEmail;
    }


    /**
     * Gets the sMemFax value for this EntityResMain.
     *
     * @return sMemFax
     */
    public String getSMemFax() {
        return sMemFax;
    }


    /**
     * Sets the sMemFax value for this EntityResMain.
     *
     * @param sMemFax
     */
    public void setSMemFax(String sMemFax) {
        this.sMemFax = sMemFax;
    }


    /**
     * Gets the sCompanyName value for this EntityResMain.
     *
     * @return sCompanyName
     */
    public String getSCompanyName() {
        return sCompanyName;
    }


    /**
     * Sets the sCompanyName value for this EntityResMain.
     *
     * @param sCompanyName
     */
    public void setSCompanyName(String sCompanyName) {
        this.sCompanyName = sCompanyName;
    }


    /**
     * Gets the sMemMobile value for this EntityResMain.
     *
     * @return sMemMobile
     */
    public String getSMemMobile() {
        return sMemMobile;
    }


    /**
     * Sets the sMemMobile value for this EntityResMain.
     *
     * @param sMemMobile
     */
    public void setSMemMobile(String sMemMobile) {
        this.sMemMobile = sMemMobile;
    }


    /**
     * Gets the sHotelID value for this EntityResMain.
     *
     * @return sHotelID
     */
    public String getSHotelID() {
        return sHotelID;
    }


    /**
     * Sets the sHotelID value for this EntityResMain.
     *
     * @param sHotelID
     */
    public void setSHotelID(String sHotelID) {
        this.sHotelID = sHotelID;
    }


    /**
     * Gets the dCreateDate value for this EntityResMain.
     *
     * @return dCreateDate
     */
    public java.util.Calendar getDCreateDate() {
        return dCreateDate;
    }


    /**
     * Sets the dCreateDate value for this EntityResMain.
     *
     * @param dCreateDate
     */
    public void setDCreateDate(java.util.Calendar dCreateDate) {
        this.dCreateDate = dCreateDate;
    }


    /**
     * Gets the dModifyDate value for this EntityResMain.
     *
     * @return dModifyDate
     */
    public java.util.Calendar getDModifyDate() {
        return dModifyDate;
    }


    /**
     * Sets the dModifyDate value for this EntityResMain.
     *
     * @param dModifyDate
     */
    public void setDModifyDate(java.util.Calendar dModifyDate) {
        this.dModifyDate = dModifyDate;
    }


    /**
     * Gets the sOperatorID value for this EntityResMain.
     *
     * @return sOperatorID
     */
    public String getSOperatorID() {
        return sOperatorID;
    }


    /**
     * Sets the sOperatorID value for this EntityResMain.
     *
     * @param sOperatorID
     */
    public void setSOperatorID(String sOperatorID) {
        this.sOperatorID = sOperatorID;
    }


    /**
     * Gets the sBillID value for this EntityResMain.
     *
     * @return sBillID
     */
    public String getSBillID() {
        return sBillID;
    }


    /**
     * Sets the sBillID value for this EntityResMain.
     *
     * @param sBillID
     */
    public void setSBillID(String sBillID) {
        this.sBillID = sBillID;
    }


    /**
     * Gets the dBizDay value for this EntityResMain.
     *
     * @return dBizDay
     */
    public java.util.Calendar getDBizDay() {
        return dBizDay;
    }


    /**
     * Sets the dBizDay value for this EntityResMain.
     *
     * @param dBizDay
     */
    public void setDBizDay(java.util.Calendar dBizDay) {
        this.dBizDay = dBizDay;
    }


    /**
     * Gets the sShiftID value for this EntityResMain.
     *
     * @return sShiftID
     */
    public String getSShiftID() {
        return sShiftID;
    }


    /**
     * Sets the sShiftID value for this EntityResMain.
     *
     * @param sShiftID
     */
    public void setSShiftID(String sShiftID) {
        this.sShiftID = sShiftID;
    }


    /**
     * Gets the sActivityCode value for this EntityResMain.
     *
     * @return sActivityCode
     */
    public String getSActivityCode() {
        return sActivityCode;
    }


    /**
     * Sets the sActivityCode value for this EntityResMain.
     *
     * @param sActivityCode
     */
    public void setSActivityCode(String sActivityCode) {
        this.sActivityCode = sActivityCode;
    }


    /**
     * Gets the bIsGiveBreakfast value for this EntityResMain.
     *
     * @return bIsGiveBreakfast
     */
    public boolean isBIsGiveBreakfast() {
        return bIsGiveBreakfast;
    }


    /**
     * Sets the bIsGiveBreakfast value for this EntityResMain.
     *
     * @param bIsGiveBreakfast
     */
    public void setBIsGiveBreakfast(boolean bIsGiveBreakfast) {
        this.bIsGiveBreakfast = bIsGiveBreakfast;
    }


    /**
     * Gets the isDelete value for this EntityResMain.
     *
     * @return isDelete
     */
    public boolean isIsDelete() {
        return isDelete;
    }


    /**
     * Sets the isDelete value for this EntityResMain.
     *
     * @param isDelete
     */
    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }


    /**
     * Gets the linkmanInfo value for this EntityResMain.
     *
     * @return linkmanInfo
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.SheetGuest getLinkmanInfo() {
        return linkmanInfo;
    }


    /**
     * Sets the linkmanInfo value for this EntityResMain.
     *
     * @param linkmanInfo
     */
    public void setLinkmanInfo(com.huazhu.hvip.thirdparty.entity.axis.reservation.SheetGuest linkmanInfo) {
        this.linkmanInfo = linkmanInfo;
    }


    /**
     * Gets the categoryInfo value for this EntityResMain.
     *
     * @return categoryInfo
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.CustomerCategory getCategoryInfo() {
        return categoryInfo;
    }


    /**
     * Sets the categoryInfo value for this EntityResMain.
     *
     * @param categoryInfo
     */
    public void setCategoryInfo(com.huazhu.hvip.thirdparty.entity.axis.reservation.CustomerCategory categoryInfo) {
        this.categoryInfo = categoryInfo;
    }


    /**
     * Gets the orderSeqNo value for this EntityResMain.
     *
     * @return orderSeqNo
     */
    public String getOrderSeqNo() {
        return orderSeqNo;
    }


    /**
     * Sets the orderSeqNo value for this EntityResMain.
     *
     * @param orderSeqNo
     */
    public void setOrderSeqNo(String orderSeqNo) {
        this.orderSeqNo = orderSeqNo;
    }


    /**
     * Gets the listDetail value for this EntityResMain.
     *
     * @return listDetail
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetail[] getListDetail() {
        return listDetail;
    }


    /**
     * Sets the listDetail value for this EntityResMain.
     *
     * @param listDetail
     */
    public void setListDetail(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetail[] listDetail) {
        this.listDetail = listDetail;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EntityResMain)) return false;
        EntityResMain other = (EntityResMain) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.sOrderID==null && other.getSOrderID()==null) ||
             (this.sOrderID!=null &&
              this.sOrderID.equals(other.getSOrderID()))) &&
            ((this.sCusCategoryID==null && other.getSCusCategoryID()==null) ||
             (this.sCusCategoryID!=null &&
              this.sCusCategoryID.equals(other.getSCusCategoryID()))) &&
            ((this.sCardNo==null && other.getSCardNo()==null) ||
             (this.sCardNo!=null &&
              this.sCardNo.equals(other.getSCardNo()))) &&
            ((this.sRefNo==null && other.getSRefNo()==null) ||
             (this.sRefNo!=null &&
              this.sRefNo.equals(other.getSRefNo()))) &&
            ((this.sContractNo==null && other.getSContractNo()==null) ||
             (this.sContractNo!=null &&
              this.sContractNo.equals(other.getSContractNo()))) &&
            ((this.sGroupID==null && other.getSGroupID()==null) ||
             (this.sGroupID!=null &&
              this.sGroupID.equals(other.getSGroupID()))) &&
            ((this.sGroupName==null && other.getSGroupName()==null) ||
             (this.sGroupName!=null &&
              this.sGroupName.equals(other.getSGroupName()))) &&
            ((this.sCRSNo==null && other.getSCRSNo()==null) ||
             (this.sCRSNo!=null &&
              this.sCRSNo.equals(other.getSCRSNo()))) &&
            ((this.dCRSUserID==null && other.getDCRSUserID()==null) ||
             (this.dCRSUserID!=null &&
              this.dCRSUserID.equals(other.getDCRSUserID()))) &&
            ((this.sSrcID==null && other.getSSrcID()==null) ||
             (this.sSrcID!=null &&
              this.sSrcID.equals(other.getSSrcID()))) &&
            ((this.sBookerID==null && other.getSBookerID()==null) ||
             (this.sBookerID!=null &&
              this.sBookerID.equals(other.getSBookerID()))) &&
            ((this.sBookerLevel==null && other.getSBookerLevel()==null) ||
             (this.sBookerLevel!=null &&
              this.sBookerLevel.equals(other.getSBookerLevel()))) &&
            ((this.sLinkFax==null && other.getSLinkFax()==null) ||
             (this.sLinkFax!=null &&
              this.sLinkFax.equals(other.getSLinkFax()))) &&
            ((this.sLinkEmail==null && other.getSLinkEmail()==null) ||
             (this.sLinkEmail!=null &&
              this.sLinkEmail.equals(other.getSLinkEmail()))) &&
            ((this.dArrDate==null && other.getDArrDate()==null) ||
             (this.dArrDate!=null &&
              this.dArrDate.equals(other.getDArrDate()))) &&
            ((this.dDepDate==null && other.getDDepDate()==null) ||
             (this.dDepDate!=null &&
              this.dDepDate.equals(other.getDDepDate()))) &&
            ((this.dArrTime==null && other.getDArrTime()==null) ||
             (this.dArrTime!=null &&
              this.dArrTime.equals(other.getDArrTime()))) &&
            ((this.dKeepTime==null && other.getDKeepTime()==null) ||
             (this.dKeepTime!=null &&
              this.dKeepTime.equals(other.getDKeepTime()))) &&
            this.iDays == other.getIDays() &&
            this.bIsWaitHis == other.isBIsWaitHis() &&
            this.iPrintCnt == other.getIPrintCnt() &&
            this.bIsWait == other.isBIsWait() &&
            ((this.sOrderStatus==null && other.getSOrderStatus()==null) ||
             (this.sOrderStatus!=null &&
              this.sOrderStatus.equals(other.getSOrderStatus()))) &&
            ((this.sMemo==null && other.getSMemo()==null) ||
             (this.sMemo!=null &&
              this.sMemo.equals(other.getSMemo()))) &&
            ((this.sAssType==null && other.getSAssType()==null) ||
             (this.sAssType!=null &&
              this.sAssType.equals(other.getSAssType()))) &&
            ((this.sLinkName==null && other.getSLinkName()==null) ||
             (this.sLinkName!=null &&
              this.sLinkName.equals(other.getSLinkName()))) &&
            ((this.sLinkMobile==null && other.getSLinkMobile()==null) ||
             (this.sLinkMobile!=null &&
              this.sLinkMobile.equals(other.getSLinkMobile()))) &&
            ((this.sLinkPhone==null && other.getSLinkPhone()==null) ||
             (this.sLinkPhone!=null &&
              this.sLinkPhone.equals(other.getSLinkPhone()))) &&
            ((this.sRcpType==null && other.getSRcpType()==null) ||
             (this.sRcpType!=null &&
              this.sRcpType.equals(other.getSRcpType()))) &&
            ((this.sMemName==null && other.getSMemName()==null) ||
             (this.sMemName!=null &&
              this.sMemName.equals(other.getSMemName()))) &&
            ((this.sMemPhone==null && other.getSMemPhone()==null) ||
             (this.sMemPhone!=null &&
              this.sMemPhone.equals(other.getSMemPhone()))) &&
            ((this.sMemEmail==null && other.getSMemEmail()==null) ||
             (this.sMemEmail!=null &&
              this.sMemEmail.equals(other.getSMemEmail()))) &&
            ((this.sMemFax==null && other.getSMemFax()==null) ||
             (this.sMemFax!=null &&
              this.sMemFax.equals(other.getSMemFax()))) &&
            ((this.sCompanyName==null && other.getSCompanyName()==null) ||
             (this.sCompanyName!=null &&
              this.sCompanyName.equals(other.getSCompanyName()))) &&
            ((this.sMemMobile==null && other.getSMemMobile()==null) ||
             (this.sMemMobile!=null &&
              this.sMemMobile.equals(other.getSMemMobile()))) &&
            ((this.sHotelID==null && other.getSHotelID()==null) ||
             (this.sHotelID!=null &&
              this.sHotelID.equals(other.getSHotelID()))) &&
            ((this.dCreateDate==null && other.getDCreateDate()==null) ||
             (this.dCreateDate!=null &&
              this.dCreateDate.equals(other.getDCreateDate()))) &&
            ((this.dModifyDate==null && other.getDModifyDate()==null) ||
             (this.dModifyDate!=null &&
              this.dModifyDate.equals(other.getDModifyDate()))) &&
            ((this.sOperatorID==null && other.getSOperatorID()==null) ||
             (this.sOperatorID!=null &&
              this.sOperatorID.equals(other.getSOperatorID()))) &&
            ((this.sBillID==null && other.getSBillID()==null) ||
             (this.sBillID!=null &&
              this.sBillID.equals(other.getSBillID()))) &&
            ((this.dBizDay==null && other.getDBizDay()==null) ||
             (this.dBizDay!=null &&
              this.dBizDay.equals(other.getDBizDay()))) &&
            ((this.sShiftID==null && other.getSShiftID()==null) ||
             (this.sShiftID!=null &&
              this.sShiftID.equals(other.getSShiftID()))) &&
            ((this.sActivityCode==null && other.getSActivityCode()==null) ||
             (this.sActivityCode!=null &&
              this.sActivityCode.equals(other.getSActivityCode()))) &&
            this.bIsGiveBreakfast == other.isBIsGiveBreakfast() &&
            this.isDelete == other.isIsDelete() &&
            ((this.linkmanInfo==null && other.getLinkmanInfo()==null) ||
             (this.linkmanInfo!=null &&
              this.linkmanInfo.equals(other.getLinkmanInfo()))) &&
            ((this.categoryInfo==null && other.getCategoryInfo()==null) ||
             (this.categoryInfo!=null &&
              this.categoryInfo.equals(other.getCategoryInfo()))) &&
            ((this.orderSeqNo==null && other.getOrderSeqNo()==null) ||
             (this.orderSeqNo!=null &&
              this.orderSeqNo.equals(other.getOrderSeqNo()))) &&
            ((this.listDetail==null && other.getListDetail()==null) ||
             (this.listDetail!=null &&
              java.util.Arrays.equals(this.listDetail, other.getListDetail())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSOrderID() != null) {
            _hashCode += getSOrderID().hashCode();
        }
        if (getSCusCategoryID() != null) {
            _hashCode += getSCusCategoryID().hashCode();
        }
        if (getSCardNo() != null) {
            _hashCode += getSCardNo().hashCode();
        }
        if (getSRefNo() != null) {
            _hashCode += getSRefNo().hashCode();
        }
        if (getSContractNo() != null) {
            _hashCode += getSContractNo().hashCode();
        }
        if (getSGroupID() != null) {
            _hashCode += getSGroupID().hashCode();
        }
        if (getSGroupName() != null) {
            _hashCode += getSGroupName().hashCode();
        }
        if (getSCRSNo() != null) {
            _hashCode += getSCRSNo().hashCode();
        }
        if (getDCRSUserID() != null) {
            _hashCode += getDCRSUserID().hashCode();
        }
        if (getSSrcID() != null) {
            _hashCode += getSSrcID().hashCode();
        }
        if (getSBookerID() != null) {
            _hashCode += getSBookerID().hashCode();
        }
        if (getSBookerLevel() != null) {
            _hashCode += getSBookerLevel().hashCode();
        }
        if (getSLinkFax() != null) {
            _hashCode += getSLinkFax().hashCode();
        }
        if (getSLinkEmail() != null) {
            _hashCode += getSLinkEmail().hashCode();
        }
        if (getDArrDate() != null) {
            _hashCode += getDArrDate().hashCode();
        }
        if (getDDepDate() != null) {
            _hashCode += getDDepDate().hashCode();
        }
        if (getDArrTime() != null) {
            _hashCode += getDArrTime().hashCode();
        }
        if (getDKeepTime() != null) {
            _hashCode += getDKeepTime().hashCode();
        }
        _hashCode += getIDays();
        _hashCode += (isBIsWaitHis() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getIPrintCnt();
        _hashCode += (isBIsWait() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSOrderStatus() != null) {
            _hashCode += getSOrderStatus().hashCode();
        }
        if (getSMemo() != null) {
            _hashCode += getSMemo().hashCode();
        }
        if (getSAssType() != null) {
            _hashCode += getSAssType().hashCode();
        }
        if (getSLinkName() != null) {
            _hashCode += getSLinkName().hashCode();
        }
        if (getSLinkMobile() != null) {
            _hashCode += getSLinkMobile().hashCode();
        }
        if (getSLinkPhone() != null) {
            _hashCode += getSLinkPhone().hashCode();
        }
        if (getSRcpType() != null) {
            _hashCode += getSRcpType().hashCode();
        }
        if (getSMemName() != null) {
            _hashCode += getSMemName().hashCode();
        }
        if (getSMemPhone() != null) {
            _hashCode += getSMemPhone().hashCode();
        }
        if (getSMemEmail() != null) {
            _hashCode += getSMemEmail().hashCode();
        }
        if (getSMemFax() != null) {
            _hashCode += getSMemFax().hashCode();
        }
        if (getSCompanyName() != null) {
            _hashCode += getSCompanyName().hashCode();
        }
        if (getSMemMobile() != null) {
            _hashCode += getSMemMobile().hashCode();
        }
        if (getSHotelID() != null) {
            _hashCode += getSHotelID().hashCode();
        }
        if (getDCreateDate() != null) {
            _hashCode += getDCreateDate().hashCode();
        }
        if (getDModifyDate() != null) {
            _hashCode += getDModifyDate().hashCode();
        }
        if (getSOperatorID() != null) {
            _hashCode += getSOperatorID().hashCode();
        }
        if (getSBillID() != null) {
            _hashCode += getSBillID().hashCode();
        }
        if (getDBizDay() != null) {
            _hashCode += getDBizDay().hashCode();
        }
        if (getSShiftID() != null) {
            _hashCode += getSShiftID().hashCode();
        }
        if (getSActivityCode() != null) {
            _hashCode += getSActivityCode().hashCode();
        }
        _hashCode += (isBIsGiveBreakfast() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLinkmanInfo() != null) {
            _hashCode += getLinkmanInfo().hashCode();
        }
        if (getCategoryInfo() != null) {
            _hashCode += getCategoryInfo().hashCode();
        }
        if (getOrderSeqNo() != null) {
            _hashCode += getOrderSeqNo().hashCode();
        }
        if (getListDetail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListDetail());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getListDetail(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntityResMain.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOrderID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sOrderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCusCategoryID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCusCategoryID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCardNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCardNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRefNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRefNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SContractNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sContractNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SGroupID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sGroupID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SGroupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sGroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCRSNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCRSNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DCRSUserID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dCRSUserID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSrcID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sSrcID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SBookerID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sBookerID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SBookerLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sBookerLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLinkFax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sLinkFax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLinkEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sLinkEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DArrDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dArrDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DDepDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dDepDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DArrTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dArrTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DKeepTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dKeepTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIsWaitHis");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsWaitHis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IPrintCnt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iPrintCnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIsWait");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsWait"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOrderStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sOrderStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMemo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMemo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SAssType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sAssType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLinkName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sLinkName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLinkMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sLinkMobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLinkPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sLinkPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRcpType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRcpType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMemName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMemName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMemPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMemPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMemEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMemEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMemFax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMemFax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCompanyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCompanyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMemMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMemMobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SHotelID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sHotelID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DCreateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dCreateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DModifyDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dModifyDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOperatorID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sOperatorID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SBillID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sBillID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DBizDay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dBizDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SShiftID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sShiftID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SActivityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sActivityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIsGiveBreakfast");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsGiveBreakfast"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isDelete");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "IsDelete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkmanInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "LinkmanInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "SheetGuest"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoryInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "CategoryInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "CustomerCategory"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderSeqNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "OrderSeqNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "listDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetail"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
