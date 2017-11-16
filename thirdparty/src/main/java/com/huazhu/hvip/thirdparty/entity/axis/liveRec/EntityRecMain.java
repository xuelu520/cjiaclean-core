/**
 * EntityRecMain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.liveRec;

public class EntityRecMain  implements java.io.Serializable {
    private String sReceiveID;

    private String sCusAccID;

    private String sCusName;

    private String sGroupID;

    private String sGroupName;

    private String sSrcID;

    private String sCurCategoryID;

    private String sResCurCategoryID;

    private String sRcpType;

    private String sBookerLevel;

    private String sBookerID;

    private String sCardNo;

    private String sCRSNo;

    private String sContractNo;

    private String sRefNo;

    private String sCompanyName;

    private String sMemName;

    private String sMemMobile;

    private String sMemPhone;

    private String sMemFax;

    private String sMemEmail;

    private java.util.Calendar dCheckinDate;

    private java.util.Calendar dCheckinBizday;

    private java.util.Calendar dBizDay;

    private java.util.Calendar dEstDepDate;

    private java.util.Calendar dDepDate;

    private String sBillID;

    private String sHotelID;

    private String sHall;

    private String sFloor;

    private String sRoomTypeID;

    private String sUpRoomTypeID;

    private String sRoomNo;

    private java.math.BigDecimal cPrice;

    private String sRateCode;

    private Integer iPersonCnt;

    private Integer iMaxSoupticket;

    private Integer iSoupticket;

    private String sRecStatusID;

    private boolean bIsRenew;

    private String sReceivePropertyID;

    private String sCauseID;

    private String sCheckinType;

    private String sRefGroupRecID;

    private String sInmateRecID;

    private boolean bIsMainOrder;

    private Integer iInmateCount;

    private java.math.BigDecimal cInmateRate;

    private String sRefRecTypeID;

    private String sRefRecID;

    private Integer iKeyCnt;

    private Integer iPrintCnt;

    private boolean bIsDisturb;

    private boolean bIsInquiry;

    private String sCloseClassID;

    private String sReceiveClassID;

    private boolean bIsOneself;

    private java.util.Calendar dCreateDate;

    private String sOperatorID;

    private java.util.Calendar dModifyDate;

    private String sMemo;

    private String sShiftID;

    private String sMessage;

    private String sActivityCode;

    private boolean bIsSelfCheckin;

    private String sCheckinSrc;

    private boolean isZeroSecondOrder;

    private java.math.BigDecimal expenses;

    private String activityName;

    private String dayPrice;

    private java.math.BigDecimal havePay;

    private java.math.BigDecimal creSum;

    private java.math.BigDecimal cAUTHSum;

    private java.math.BigDecimal cDebSum;

    private String sOrderID;

    private String message;

    private boolean xuzhu;

    private String IDNo;

    private boolean noPay;

    private boolean isContinue;

    private boolean isCheckOut;

    private String hotelName;

    private String roomTypeName;

    private String sResBookVNo;

    private String sIDNo;

    private String sIDTypeID;

    private String sIDTypeName;

    public EntityRecMain() {
    }

    public EntityRecMain(
           String sReceiveID,
           String sCusAccID,
           String sCusName,
           String sGroupID,
           String sGroupName,
           String sSrcID,
           String sCurCategoryID,
           String sResCurCategoryID,
           String sRcpType,
           String sBookerLevel,
           String sBookerID,
           String sCardNo,
           String sCRSNo,
           String sContractNo,
           String sRefNo,
           String sCompanyName,
           String sMemName,
           String sMemMobile,
           String sMemPhone,
           String sMemFax,
           String sMemEmail,
           java.util.Calendar dCheckinDate,
           java.util.Calendar dCheckinBizday,
           java.util.Calendar dBizDay,
           java.util.Calendar dEstDepDate,
           java.util.Calendar dDepDate,
           String sBillID,
           String sHotelID,
           String sHall,
           String sFloor,
           String sRoomTypeID,
           String sUpRoomTypeID,
           String sRoomNo,
           java.math.BigDecimal cPrice,
           String sRateCode,
           Integer iPersonCnt,
           Integer iMaxSoupticket,
           Integer iSoupticket,
           String sRecStatusID,
           boolean bIsRenew,
           String sReceivePropertyID,
           String sCauseID,
           String sCheckinType,
           String sRefGroupRecID,
           String sInmateRecID,
           boolean bIsMainOrder,
           Integer iInmateCount,
           java.math.BigDecimal cInmateRate,
           String sRefRecTypeID,
           String sRefRecID,
           Integer iKeyCnt,
           Integer iPrintCnt,
           boolean bIsDisturb,
           boolean bIsInquiry,
           String sCloseClassID,
           String sReceiveClassID,
           boolean bIsOneself,
           java.util.Calendar dCreateDate,
           String sOperatorID,
           java.util.Calendar dModifyDate,
           String sMemo,
           String sShiftID,
           String sMessage,
           String sActivityCode,
           boolean bIsSelfCheckin,
           String sCheckinSrc,
           boolean isZeroSecondOrder,
           java.math.BigDecimal expenses,
           String activityName,
           String dayPrice,
           java.math.BigDecimal havePay,
           java.math.BigDecimal creSum,
           java.math.BigDecimal cAUTHSum,
           java.math.BigDecimal cDebSum,
           String sOrderID,
           String message,
           boolean xuzhu,
           String IDNo,
           boolean noPay,
           boolean isContinue,
           boolean isCheckOut,
           String hotelName,
           String roomTypeName,
           String sResBookVNo,
           String sIDNo,
           String sIDTypeID,
           String sIDTypeName) {
           this.sReceiveID = sReceiveID;
           this.sCusAccID = sCusAccID;
           this.sCusName = sCusName;
           this.sGroupID = sGroupID;
           this.sGroupName = sGroupName;
           this.sSrcID = sSrcID;
           this.sCurCategoryID = sCurCategoryID;
           this.sResCurCategoryID = sResCurCategoryID;
           this.sRcpType = sRcpType;
           this.sBookerLevel = sBookerLevel;
           this.sBookerID = sBookerID;
           this.sCardNo = sCardNo;
           this.sCRSNo = sCRSNo;
           this.sContractNo = sContractNo;
           this.sRefNo = sRefNo;
           this.sCompanyName = sCompanyName;
           this.sMemName = sMemName;
           this.sMemMobile = sMemMobile;
           this.sMemPhone = sMemPhone;
           this.sMemFax = sMemFax;
           this.sMemEmail = sMemEmail;
           this.dCheckinDate = dCheckinDate;
           this.dCheckinBizday = dCheckinBizday;
           this.dBizDay = dBizDay;
           this.dEstDepDate = dEstDepDate;
           this.dDepDate = dDepDate;
           this.sBillID = sBillID;
           this.sHotelID = sHotelID;
           this.sHall = sHall;
           this.sFloor = sFloor;
           this.sRoomTypeID = sRoomTypeID;
           this.sUpRoomTypeID = sUpRoomTypeID;
           this.sRoomNo = sRoomNo;
           this.cPrice = cPrice;
           this.sRateCode = sRateCode;
           this.iPersonCnt = iPersonCnt;
           this.iMaxSoupticket = iMaxSoupticket;
           this.iSoupticket = iSoupticket;
           this.sRecStatusID = sRecStatusID;
           this.bIsRenew = bIsRenew;
           this.sReceivePropertyID = sReceivePropertyID;
           this.sCauseID = sCauseID;
           this.sCheckinType = sCheckinType;
           this.sRefGroupRecID = sRefGroupRecID;
           this.sInmateRecID = sInmateRecID;
           this.bIsMainOrder = bIsMainOrder;
           this.iInmateCount = iInmateCount;
           this.cInmateRate = cInmateRate;
           this.sRefRecTypeID = sRefRecTypeID;
           this.sRefRecID = sRefRecID;
           this.iKeyCnt = iKeyCnt;
           this.iPrintCnt = iPrintCnt;
           this.bIsDisturb = bIsDisturb;
           this.bIsInquiry = bIsInquiry;
           this.sCloseClassID = sCloseClassID;
           this.sReceiveClassID = sReceiveClassID;
           this.bIsOneself = bIsOneself;
           this.dCreateDate = dCreateDate;
           this.sOperatorID = sOperatorID;
           this.dModifyDate = dModifyDate;
           this.sMemo = sMemo;
           this.sShiftID = sShiftID;
           this.sMessage = sMessage;
           this.sActivityCode = sActivityCode;
           this.bIsSelfCheckin = bIsSelfCheckin;
           this.sCheckinSrc = sCheckinSrc;
           this.isZeroSecondOrder = isZeroSecondOrder;
           this.expenses = expenses;
           this.activityName = activityName;
           this.dayPrice = dayPrice;
           this.havePay = havePay;
           this.creSum = creSum;
           this.cAUTHSum = cAUTHSum;
           this.cDebSum = cDebSum;
           this.sOrderID = sOrderID;
           this.message = message;
           this.xuzhu = xuzhu;
           this.IDNo = IDNo;
           this.noPay = noPay;
           this.isContinue = isContinue;
           this.isCheckOut = isCheckOut;
           this.hotelName = hotelName;
           this.roomTypeName = roomTypeName;
           this.sResBookVNo = sResBookVNo;
           this.sIDNo = sIDNo;
           this.sIDTypeID = sIDTypeID;
           this.sIDTypeName = sIDTypeName;
    }


    /**
     * Gets the sReceiveID value for this EntityRecMain.
     * 
     * @return sReceiveID
     */
    public String getSReceiveID() {
        return sReceiveID;
    }


    /**
     * Sets the sReceiveID value for this EntityRecMain.
     * 
     * @param sReceiveID
     */
    public void setSReceiveID(String sReceiveID) {
        this.sReceiveID = sReceiveID;
    }


    /**
     * Gets the sCusAccID value for this EntityRecMain.
     * 
     * @return sCusAccID
     */
    public String getSCusAccID() {
        return sCusAccID;
    }


    /**
     * Sets the sCusAccID value for this EntityRecMain.
     * 
     * @param sCusAccID
     */
    public void setSCusAccID(String sCusAccID) {
        this.sCusAccID = sCusAccID;
    }


    /**
     * Gets the sCusName value for this EntityRecMain.
     * 
     * @return sCusName
     */
    public String getSCusName() {
        return sCusName;
    }


    /**
     * Sets the sCusName value for this EntityRecMain.
     * 
     * @param sCusName
     */
    public void setSCusName(String sCusName) {
        this.sCusName = sCusName;
    }


    /**
     * Gets the sGroupID value for this EntityRecMain.
     * 
     * @return sGroupID
     */
    public String getSGroupID() {
        return sGroupID;
    }


    /**
     * Sets the sGroupID value for this EntityRecMain.
     * 
     * @param sGroupID
     */
    public void setSGroupID(String sGroupID) {
        this.sGroupID = sGroupID;
    }


    /**
     * Gets the sGroupName value for this EntityRecMain.
     * 
     * @return sGroupName
     */
    public String getSGroupName() {
        return sGroupName;
    }


    /**
     * Sets the sGroupName value for this EntityRecMain.
     * 
     * @param sGroupName
     */
    public void setSGroupName(String sGroupName) {
        this.sGroupName = sGroupName;
    }


    /**
     * Gets the sSrcID value for this EntityRecMain.
     * 
     * @return sSrcID
     */
    public String getSSrcID() {
        return sSrcID;
    }


    /**
     * Sets the sSrcID value for this EntityRecMain.
     * 
     * @param sSrcID
     */
    public void setSSrcID(String sSrcID) {
        this.sSrcID = sSrcID;
    }


    /**
     * Gets the sCurCategoryID value for this EntityRecMain.
     * 
     * @return sCurCategoryID
     */
    public String getSCurCategoryID() {
        return sCurCategoryID;
    }


    /**
     * Sets the sCurCategoryID value for this EntityRecMain.
     * 
     * @param sCurCategoryID
     */
    public void setSCurCategoryID(String sCurCategoryID) {
        this.sCurCategoryID = sCurCategoryID;
    }


    /**
     * Gets the sResCurCategoryID value for this EntityRecMain.
     * 
     * @return sResCurCategoryID
     */
    public String getSResCurCategoryID() {
        return sResCurCategoryID;
    }


    /**
     * Sets the sResCurCategoryID value for this EntityRecMain.
     * 
     * @param sResCurCategoryID
     */
    public void setSResCurCategoryID(String sResCurCategoryID) {
        this.sResCurCategoryID = sResCurCategoryID;
    }


    /**
     * Gets the sRcpType value for this EntityRecMain.
     * 
     * @return sRcpType
     */
    public String getSRcpType() {
        return sRcpType;
    }


    /**
     * Sets the sRcpType value for this EntityRecMain.
     * 
     * @param sRcpType
     */
    public void setSRcpType(String sRcpType) {
        this.sRcpType = sRcpType;
    }


    /**
     * Gets the sBookerLevel value for this EntityRecMain.
     * 
     * @return sBookerLevel
     */
    public String getSBookerLevel() {
        return sBookerLevel;
    }


    /**
     * Sets the sBookerLevel value for this EntityRecMain.
     * 
     * @param sBookerLevel
     */
    public void setSBookerLevel(String sBookerLevel) {
        this.sBookerLevel = sBookerLevel;
    }


    /**
     * Gets the sBookerID value for this EntityRecMain.
     * 
     * @return sBookerID
     */
    public String getSBookerID() {
        return sBookerID;
    }


    /**
     * Sets the sBookerID value for this EntityRecMain.
     * 
     * @param sBookerID
     */
    public void setSBookerID(String sBookerID) {
        this.sBookerID = sBookerID;
    }


    /**
     * Gets the sCardNo value for this EntityRecMain.
     * 
     * @return sCardNo
     */
    public String getSCardNo() {
        return sCardNo;
    }


    /**
     * Sets the sCardNo value for this EntityRecMain.
     * 
     * @param sCardNo
     */
    public void setSCardNo(String sCardNo) {
        this.sCardNo = sCardNo;
    }


    /**
     * Gets the sCRSNo value for this EntityRecMain.
     * 
     * @return sCRSNo
     */
    public String getSCRSNo() {
        return sCRSNo;
    }


    /**
     * Sets the sCRSNo value for this EntityRecMain.
     * 
     * @param sCRSNo
     */
    public void setSCRSNo(String sCRSNo) {
        this.sCRSNo = sCRSNo;
    }


    /**
     * Gets the sContractNo value for this EntityRecMain.
     * 
     * @return sContractNo
     */
    public String getSContractNo() {
        return sContractNo;
    }


    /**
     * Sets the sContractNo value for this EntityRecMain.
     * 
     * @param sContractNo
     */
    public void setSContractNo(String sContractNo) {
        this.sContractNo = sContractNo;
    }


    /**
     * Gets the sRefNo value for this EntityRecMain.
     * 
     * @return sRefNo
     */
    public String getSRefNo() {
        return sRefNo;
    }


    /**
     * Sets the sRefNo value for this EntityRecMain.
     * 
     * @param sRefNo
     */
    public void setSRefNo(String sRefNo) {
        this.sRefNo = sRefNo;
    }


    /**
     * Gets the sCompanyName value for this EntityRecMain.
     * 
     * @return sCompanyName
     */
    public String getSCompanyName() {
        return sCompanyName;
    }


    /**
     * Sets the sCompanyName value for this EntityRecMain.
     * 
     * @param sCompanyName
     */
    public void setSCompanyName(String sCompanyName) {
        this.sCompanyName = sCompanyName;
    }


    /**
     * Gets the sMemName value for this EntityRecMain.
     * 
     * @return sMemName
     */
    public String getSMemName() {
        return sMemName;
    }


    /**
     * Sets the sMemName value for this EntityRecMain.
     * 
     * @param sMemName
     */
    public void setSMemName(String sMemName) {
        this.sMemName = sMemName;
    }


    /**
     * Gets the sMemMobile value for this EntityRecMain.
     * 
     * @return sMemMobile
     */
    public String getSMemMobile() {
        return sMemMobile;
    }


    /**
     * Sets the sMemMobile value for this EntityRecMain.
     * 
     * @param sMemMobile
     */
    public void setSMemMobile(String sMemMobile) {
        this.sMemMobile = sMemMobile;
    }


    /**
     * Gets the sMemPhone value for this EntityRecMain.
     * 
     * @return sMemPhone
     */
    public String getSMemPhone() {
        return sMemPhone;
    }


    /**
     * Sets the sMemPhone value for this EntityRecMain.
     * 
     * @param sMemPhone
     */
    public void setSMemPhone(String sMemPhone) {
        this.sMemPhone = sMemPhone;
    }


    /**
     * Gets the sMemFax value for this EntityRecMain.
     * 
     * @return sMemFax
     */
    public String getSMemFax() {
        return sMemFax;
    }


    /**
     * Sets the sMemFax value for this EntityRecMain.
     * 
     * @param sMemFax
     */
    public void setSMemFax(String sMemFax) {
        this.sMemFax = sMemFax;
    }


    /**
     * Gets the sMemEmail value for this EntityRecMain.
     * 
     * @return sMemEmail
     */
    public String getSMemEmail() {
        return sMemEmail;
    }


    /**
     * Sets the sMemEmail value for this EntityRecMain.
     * 
     * @param sMemEmail
     */
    public void setSMemEmail(String sMemEmail) {
        this.sMemEmail = sMemEmail;
    }


    /**
     * Gets the dCheckinDate value for this EntityRecMain.
     * 
     * @return dCheckinDate
     */
    public java.util.Calendar getDCheckinDate() {
        return dCheckinDate;
    }


    /**
     * Sets the dCheckinDate value for this EntityRecMain.
     * 
     * @param dCheckinDate
     */
    public void setDCheckinDate(java.util.Calendar dCheckinDate) {
        this.dCheckinDate = dCheckinDate;
    }


    /**
     * Gets the dCheckinBizday value for this EntityRecMain.
     * 
     * @return dCheckinBizday
     */
    public java.util.Calendar getDCheckinBizday() {
        return dCheckinBizday;
    }


    /**
     * Sets the dCheckinBizday value for this EntityRecMain.
     * 
     * @param dCheckinBizday
     */
    public void setDCheckinBizday(java.util.Calendar dCheckinBizday) {
        this.dCheckinBizday = dCheckinBizday;
    }


    /**
     * Gets the dBizDay value for this EntityRecMain.
     * 
     * @return dBizDay
     */
    public java.util.Calendar getDBizDay() {
        return dBizDay;
    }


    /**
     * Sets the dBizDay value for this EntityRecMain.
     * 
     * @param dBizDay
     */
    public void setDBizDay(java.util.Calendar dBizDay) {
        this.dBizDay = dBizDay;
    }


    /**
     * Gets the dEstDepDate value for this EntityRecMain.
     * 
     * @return dEstDepDate
     */
    public java.util.Calendar getDEstDepDate() {
        return dEstDepDate;
    }


    /**
     * Sets the dEstDepDate value for this EntityRecMain.
     * 
     * @param dEstDepDate
     */
    public void setDEstDepDate(java.util.Calendar dEstDepDate) {
        this.dEstDepDate = dEstDepDate;
    }


    /**
     * Gets the dDepDate value for this EntityRecMain.
     * 
     * @return dDepDate
     */
    public java.util.Calendar getDDepDate() {
        return dDepDate;
    }


    /**
     * Sets the dDepDate value for this EntityRecMain.
     * 
     * @param dDepDate
     */
    public void setDDepDate(java.util.Calendar dDepDate) {
        this.dDepDate = dDepDate;
    }


    /**
     * Gets the sBillID value for this EntityRecMain.
     * 
     * @return sBillID
     */
    public String getSBillID() {
        return sBillID;
    }


    /**
     * Sets the sBillID value for this EntityRecMain.
     * 
     * @param sBillID
     */
    public void setSBillID(String sBillID) {
        this.sBillID = sBillID;
    }


    /**
     * Gets the sHotelID value for this EntityRecMain.
     * 
     * @return sHotelID
     */
    public String getSHotelID() {
        return sHotelID;
    }


    /**
     * Sets the sHotelID value for this EntityRecMain.
     * 
     * @param sHotelID
     */
    public void setSHotelID(String sHotelID) {
        this.sHotelID = sHotelID;
    }


    /**
     * Gets the sHall value for this EntityRecMain.
     * 
     * @return sHall
     */
    public String getSHall() {
        return sHall;
    }


    /**
     * Sets the sHall value for this EntityRecMain.
     * 
     * @param sHall
     */
    public void setSHall(String sHall) {
        this.sHall = sHall;
    }


    /**
     * Gets the sFloor value for this EntityRecMain.
     * 
     * @return sFloor
     */
    public String getSFloor() {
        return sFloor;
    }


    /**
     * Sets the sFloor value for this EntityRecMain.
     * 
     * @param sFloor
     */
    public void setSFloor(String sFloor) {
        this.sFloor = sFloor;
    }


    /**
     * Gets the sRoomTypeID value for this EntityRecMain.
     * 
     * @return sRoomTypeID
     */
    public String getSRoomTypeID() {
        return sRoomTypeID;
    }


    /**
     * Sets the sRoomTypeID value for this EntityRecMain.
     * 
     * @param sRoomTypeID
     */
    public void setSRoomTypeID(String sRoomTypeID) {
        this.sRoomTypeID = sRoomTypeID;
    }


    /**
     * Gets the sUpRoomTypeID value for this EntityRecMain.
     * 
     * @return sUpRoomTypeID
     */
    public String getSUpRoomTypeID() {
        return sUpRoomTypeID;
    }


    /**
     * Sets the sUpRoomTypeID value for this EntityRecMain.
     * 
     * @param sUpRoomTypeID
     */
    public void setSUpRoomTypeID(String sUpRoomTypeID) {
        this.sUpRoomTypeID = sUpRoomTypeID;
    }


    /**
     * Gets the sRoomNo value for this EntityRecMain.
     * 
     * @return sRoomNo
     */
    public String getSRoomNo() {
        return sRoomNo;
    }


    /**
     * Sets the sRoomNo value for this EntityRecMain.
     * 
     * @param sRoomNo
     */
    public void setSRoomNo(String sRoomNo) {
        this.sRoomNo = sRoomNo;
    }


    /**
     * Gets the cPrice value for this EntityRecMain.
     * 
     * @return cPrice
     */
    public java.math.BigDecimal getCPrice() {
        return cPrice;
    }


    /**
     * Sets the cPrice value for this EntityRecMain.
     * 
     * @param cPrice
     */
    public void setCPrice(java.math.BigDecimal cPrice) {
        this.cPrice = cPrice;
    }


    /**
     * Gets the sRateCode value for this EntityRecMain.
     * 
     * @return sRateCode
     */
    public String getSRateCode() {
        return sRateCode;
    }


    /**
     * Sets the sRateCode value for this EntityRecMain.
     * 
     * @param sRateCode
     */
    public void setSRateCode(String sRateCode) {
        this.sRateCode = sRateCode;
    }


    /**
     * Gets the iPersonCnt value for this EntityRecMain.
     * 
     * @return iPersonCnt
     */
    public Integer getIPersonCnt() {
        return iPersonCnt;
    }


    /**
     * Sets the iPersonCnt value for this EntityRecMain.
     * 
     * @param iPersonCnt
     */
    public void setIPersonCnt(Integer iPersonCnt) {
        this.iPersonCnt = iPersonCnt;
    }


    /**
     * Gets the iMaxSoupticket value for this EntityRecMain.
     * 
     * @return iMaxSoupticket
     */
    public Integer getIMaxSoupticket() {
        return iMaxSoupticket;
    }


    /**
     * Sets the iMaxSoupticket value for this EntityRecMain.
     * 
     * @param iMaxSoupticket
     */
    public void setIMaxSoupticket(Integer iMaxSoupticket) {
        this.iMaxSoupticket = iMaxSoupticket;
    }


    /**
     * Gets the iSoupticket value for this EntityRecMain.
     * 
     * @return iSoupticket
     */
    public Integer getISoupticket() {
        return iSoupticket;
    }


    /**
     * Sets the iSoupticket value for this EntityRecMain.
     * 
     * @param iSoupticket
     */
    public void setISoupticket(Integer iSoupticket) {
        this.iSoupticket = iSoupticket;
    }


    /**
     * Gets the sRecStatusID value for this EntityRecMain.
     * 
     * @return sRecStatusID
     */
    public String getSRecStatusID() {
        return sRecStatusID;
    }


    /**
     * Sets the sRecStatusID value for this EntityRecMain.
     * 
     * @param sRecStatusID
     */
    public void setSRecStatusID(String sRecStatusID) {
        this.sRecStatusID = sRecStatusID;
    }


    /**
     * Gets the bIsRenew value for this EntityRecMain.
     * 
     * @return bIsRenew
     */
    public boolean isBIsRenew() {
        return bIsRenew;
    }


    /**
     * Sets the bIsRenew value for this EntityRecMain.
     * 
     * @param bIsRenew
     */
    public void setBIsRenew(boolean bIsRenew) {
        this.bIsRenew = bIsRenew;
    }


    /**
     * Gets the sReceivePropertyID value for this EntityRecMain.
     * 
     * @return sReceivePropertyID
     */
    public String getSReceivePropertyID() {
        return sReceivePropertyID;
    }


    /**
     * Sets the sReceivePropertyID value for this EntityRecMain.
     * 
     * @param sReceivePropertyID
     */
    public void setSReceivePropertyID(String sReceivePropertyID) {
        this.sReceivePropertyID = sReceivePropertyID;
    }


    /**
     * Gets the sCauseID value for this EntityRecMain.
     * 
     * @return sCauseID
     */
    public String getSCauseID() {
        return sCauseID;
    }


    /**
     * Sets the sCauseID value for this EntityRecMain.
     * 
     * @param sCauseID
     */
    public void setSCauseID(String sCauseID) {
        this.sCauseID = sCauseID;
    }


    /**
     * Gets the sCheckinType value for this EntityRecMain.
     * 
     * @return sCheckinType
     */
    public String getSCheckinType() {
        return sCheckinType;
    }


    /**
     * Sets the sCheckinType value for this EntityRecMain.
     * 
     * @param sCheckinType
     */
    public void setSCheckinType(String sCheckinType) {
        this.sCheckinType = sCheckinType;
    }


    /**
     * Gets the sRefGroupRecID value for this EntityRecMain.
     * 
     * @return sRefGroupRecID
     */
    public String getSRefGroupRecID() {
        return sRefGroupRecID;
    }


    /**
     * Sets the sRefGroupRecID value for this EntityRecMain.
     * 
     * @param sRefGroupRecID
     */
    public void setSRefGroupRecID(String sRefGroupRecID) {
        this.sRefGroupRecID = sRefGroupRecID;
    }


    /**
     * Gets the sInmateRecID value for this EntityRecMain.
     * 
     * @return sInmateRecID
     */
    public String getSInmateRecID() {
        return sInmateRecID;
    }


    /**
     * Sets the sInmateRecID value for this EntityRecMain.
     * 
     * @param sInmateRecID
     */
    public void setSInmateRecID(String sInmateRecID) {
        this.sInmateRecID = sInmateRecID;
    }


    /**
     * Gets the bIsMainOrder value for this EntityRecMain.
     * 
     * @return bIsMainOrder
     */
    public boolean isBIsMainOrder() {
        return bIsMainOrder;
    }


    /**
     * Sets the bIsMainOrder value for this EntityRecMain.
     * 
     * @param bIsMainOrder
     */
    public void setBIsMainOrder(boolean bIsMainOrder) {
        this.bIsMainOrder = bIsMainOrder;
    }


    /**
     * Gets the iInmateCount value for this EntityRecMain.
     * 
     * @return iInmateCount
     */
    public Integer getIInmateCount() {
        return iInmateCount;
    }


    /**
     * Sets the iInmateCount value for this EntityRecMain.
     * 
     * @param iInmateCount
     */
    public void setIInmateCount(Integer iInmateCount) {
        this.iInmateCount = iInmateCount;
    }


    /**
     * Gets the cInmateRate value for this EntityRecMain.
     * 
     * @return cInmateRate
     */
    public java.math.BigDecimal getCInmateRate() {
        return cInmateRate;
    }


    /**
     * Sets the cInmateRate value for this EntityRecMain.
     * 
     * @param cInmateRate
     */
    public void setCInmateRate(java.math.BigDecimal cInmateRate) {
        this.cInmateRate = cInmateRate;
    }


    /**
     * Gets the sRefRecTypeID value for this EntityRecMain.
     * 
     * @return sRefRecTypeID
     */
    public String getSRefRecTypeID() {
        return sRefRecTypeID;
    }


    /**
     * Sets the sRefRecTypeID value for this EntityRecMain.
     * 
     * @param sRefRecTypeID
     */
    public void setSRefRecTypeID(String sRefRecTypeID) {
        this.sRefRecTypeID = sRefRecTypeID;
    }


    /**
     * Gets the sRefRecID value for this EntityRecMain.
     * 
     * @return sRefRecID
     */
    public String getSRefRecID() {
        return sRefRecID;
    }


    /**
     * Sets the sRefRecID value for this EntityRecMain.
     * 
     * @param sRefRecID
     */
    public void setSRefRecID(String sRefRecID) {
        this.sRefRecID = sRefRecID;
    }


    /**
     * Gets the iKeyCnt value for this EntityRecMain.
     * 
     * @return iKeyCnt
     */
    public Integer getIKeyCnt() {
        return iKeyCnt;
    }


    /**
     * Sets the iKeyCnt value for this EntityRecMain.
     * 
     * @param iKeyCnt
     */
    public void setIKeyCnt(Integer iKeyCnt) {
        this.iKeyCnt = iKeyCnt;
    }


    /**
     * Gets the iPrintCnt value for this EntityRecMain.
     * 
     * @return iPrintCnt
     */
    public Integer getIPrintCnt() {
        return iPrintCnt;
    }


    /**
     * Sets the iPrintCnt value for this EntityRecMain.
     * 
     * @param iPrintCnt
     */
    public void setIPrintCnt(Integer iPrintCnt) {
        this.iPrintCnt = iPrintCnt;
    }


    /**
     * Gets the bIsDisturb value for this EntityRecMain.
     * 
     * @return bIsDisturb
     */
    public boolean isBIsDisturb() {
        return bIsDisturb;
    }


    /**
     * Sets the bIsDisturb value for this EntityRecMain.
     * 
     * @param bIsDisturb
     */
    public void setBIsDisturb(boolean bIsDisturb) {
        this.bIsDisturb = bIsDisturb;
    }


    /**
     * Gets the bIsInquiry value for this EntityRecMain.
     * 
     * @return bIsInquiry
     */
    public boolean isBIsInquiry() {
        return bIsInquiry;
    }


    /**
     * Sets the bIsInquiry value for this EntityRecMain.
     * 
     * @param bIsInquiry
     */
    public void setBIsInquiry(boolean bIsInquiry) {
        this.bIsInquiry = bIsInquiry;
    }


    /**
     * Gets the sCloseClassID value for this EntityRecMain.
     * 
     * @return sCloseClassID
     */
    public String getSCloseClassID() {
        return sCloseClassID;
    }


    /**
     * Sets the sCloseClassID value for this EntityRecMain.
     * 
     * @param sCloseClassID
     */
    public void setSCloseClassID(String sCloseClassID) {
        this.sCloseClassID = sCloseClassID;
    }


    /**
     * Gets the sReceiveClassID value for this EntityRecMain.
     * 
     * @return sReceiveClassID
     */
    public String getSReceiveClassID() {
        return sReceiveClassID;
    }


    /**
     * Sets the sReceiveClassID value for this EntityRecMain.
     * 
     * @param sReceiveClassID
     */
    public void setSReceiveClassID(String sReceiveClassID) {
        this.sReceiveClassID = sReceiveClassID;
    }


    /**
     * Gets the bIsOneself value for this EntityRecMain.
     * 
     * @return bIsOneself
     */
    public boolean isBIsOneself() {
        return bIsOneself;
    }


    /**
     * Sets the bIsOneself value for this EntityRecMain.
     * 
     * @param bIsOneself
     */
    public void setBIsOneself(boolean bIsOneself) {
        this.bIsOneself = bIsOneself;
    }


    /**
     * Gets the dCreateDate value for this EntityRecMain.
     * 
     * @return dCreateDate
     */
    public java.util.Calendar getDCreateDate() {
        return dCreateDate;
    }


    /**
     * Sets the dCreateDate value for this EntityRecMain.
     * 
     * @param dCreateDate
     */
    public void setDCreateDate(java.util.Calendar dCreateDate) {
        this.dCreateDate = dCreateDate;
    }


    /**
     * Gets the sOperatorID value for this EntityRecMain.
     * 
     * @return sOperatorID
     */
    public String getSOperatorID() {
        return sOperatorID;
    }


    /**
     * Sets the sOperatorID value for this EntityRecMain.
     * 
     * @param sOperatorID
     */
    public void setSOperatorID(String sOperatorID) {
        this.sOperatorID = sOperatorID;
    }


    /**
     * Gets the dModifyDate value for this EntityRecMain.
     * 
     * @return dModifyDate
     */
    public java.util.Calendar getDModifyDate() {
        return dModifyDate;
    }


    /**
     * Sets the dModifyDate value for this EntityRecMain.
     * 
     * @param dModifyDate
     */
    public void setDModifyDate(java.util.Calendar dModifyDate) {
        this.dModifyDate = dModifyDate;
    }


    /**
     * Gets the sMemo value for this EntityRecMain.
     * 
     * @return sMemo
     */
    public String getSMemo() {
        return sMemo;
    }


    /**
     * Sets the sMemo value for this EntityRecMain.
     * 
     * @param sMemo
     */
    public void setSMemo(String sMemo) {
        this.sMemo = sMemo;
    }


    /**
     * Gets the sShiftID value for this EntityRecMain.
     * 
     * @return sShiftID
     */
    public String getSShiftID() {
        return sShiftID;
    }


    /**
     * Sets the sShiftID value for this EntityRecMain.
     * 
     * @param sShiftID
     */
    public void setSShiftID(String sShiftID) {
        this.sShiftID = sShiftID;
    }


    /**
     * Gets the sMessage value for this EntityRecMain.
     * 
     * @return sMessage
     */
    public String getSMessage() {
        return sMessage;
    }


    /**
     * Sets the sMessage value for this EntityRecMain.
     * 
     * @param sMessage
     */
    public void setSMessage(String sMessage) {
        this.sMessage = sMessage;
    }


    /**
     * Gets the sActivityCode value for this EntityRecMain.
     * 
     * @return sActivityCode
     */
    public String getSActivityCode() {
        return sActivityCode;
    }


    /**
     * Sets the sActivityCode value for this EntityRecMain.
     * 
     * @param sActivityCode
     */
    public void setSActivityCode(String sActivityCode) {
        this.sActivityCode = sActivityCode;
    }


    /**
     * Gets the bIsSelfCheckin value for this EntityRecMain.
     * 
     * @return bIsSelfCheckin
     */
    public boolean isBIsSelfCheckin() {
        return bIsSelfCheckin;
    }


    /**
     * Sets the bIsSelfCheckin value for this EntityRecMain.
     * 
     * @param bIsSelfCheckin
     */
    public void setBIsSelfCheckin(boolean bIsSelfCheckin) {
        this.bIsSelfCheckin = bIsSelfCheckin;
    }


    /**
     * Gets the sCheckinSrc value for this EntityRecMain.
     * 
     * @return sCheckinSrc
     */
    public String getSCheckinSrc() {
        return sCheckinSrc;
    }


    /**
     * Sets the sCheckinSrc value for this EntityRecMain.
     * 
     * @param sCheckinSrc
     */
    public void setSCheckinSrc(String sCheckinSrc) {
        this.sCheckinSrc = sCheckinSrc;
    }


    /**
     * Gets the isZeroSecondOrder value for this EntityRecMain.
     * 
     * @return isZeroSecondOrder
     */
    public boolean isIsZeroSecondOrder() {
        return isZeroSecondOrder;
    }


    /**
     * Sets the isZeroSecondOrder value for this EntityRecMain.
     * 
     * @param isZeroSecondOrder
     */
    public void setIsZeroSecondOrder(boolean isZeroSecondOrder) {
        this.isZeroSecondOrder = isZeroSecondOrder;
    }


    /**
     * Gets the expenses value for this EntityRecMain.
     * 
     * @return expenses
     */
    public java.math.BigDecimal getExpenses() {
        return expenses;
    }


    /**
     * Sets the expenses value for this EntityRecMain.
     * 
     * @param expenses
     */
    public void setExpenses(java.math.BigDecimal expenses) {
        this.expenses = expenses;
    }


    /**
     * Gets the activityName value for this EntityRecMain.
     * 
     * @return activityName
     */
    public String getActivityName() {
        return activityName;
    }


    /**
     * Sets the activityName value for this EntityRecMain.
     * 
     * @param activityName
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }


    /**
     * Gets the dayPrice value for this EntityRecMain.
     * 
     * @return dayPrice
     */
    public String getDayPrice() {
        return dayPrice;
    }


    /**
     * Sets the dayPrice value for this EntityRecMain.
     * 
     * @param dayPrice
     */
    public void setDayPrice(String dayPrice) {
        this.dayPrice = dayPrice;
    }


    /**
     * Gets the havePay value for this EntityRecMain.
     * 
     * @return havePay
     */
    public java.math.BigDecimal getHavePay() {
        return havePay;
    }


    /**
     * Sets the havePay value for this EntityRecMain.
     * 
     * @param havePay
     */
    public void setHavePay(java.math.BigDecimal havePay) {
        this.havePay = havePay;
    }


    /**
     * Gets the creSum value for this EntityRecMain.
     * 
     * @return creSum
     */
    public java.math.BigDecimal getCreSum() {
        return creSum;
    }


    /**
     * Sets the creSum value for this EntityRecMain.
     * 
     * @param creSum
     */
    public void setCreSum(java.math.BigDecimal creSum) {
        this.creSum = creSum;
    }


    /**
     * Gets the cAUTHSum value for this EntityRecMain.
     * 
     * @return cAUTHSum
     */
    public java.math.BigDecimal getCAUTHSum() {
        return cAUTHSum;
    }


    /**
     * Sets the cAUTHSum value for this EntityRecMain.
     * 
     * @param cAUTHSum
     */
    public void setCAUTHSum(java.math.BigDecimal cAUTHSum) {
        this.cAUTHSum = cAUTHSum;
    }


    /**
     * Gets the cDebSum value for this EntityRecMain.
     * 
     * @return cDebSum
     */
    public java.math.BigDecimal getCDebSum() {
        return cDebSum;
    }


    /**
     * Sets the cDebSum value for this EntityRecMain.
     * 
     * @param cDebSum
     */
    public void setCDebSum(java.math.BigDecimal cDebSum) {
        this.cDebSum = cDebSum;
    }


    /**
     * Gets the sOrderID value for this EntityRecMain.
     * 
     * @return sOrderID
     */
    public String getSOrderID() {
        return sOrderID;
    }


    /**
     * Sets the sOrderID value for this EntityRecMain.
     * 
     * @param sOrderID
     */
    public void setSOrderID(String sOrderID) {
        this.sOrderID = sOrderID;
    }


    /**
     * Gets the message value for this EntityRecMain.
     * 
     * @return message
     */
    public String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this EntityRecMain.
     * 
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * Gets the xuzhu value for this EntityRecMain.
     * 
     * @return xuzhu
     */
    public boolean isXuzhu() {
        return xuzhu;
    }


    /**
     * Sets the xuzhu value for this EntityRecMain.
     * 
     * @param xuzhu
     */
    public void setXuzhu(boolean xuzhu) {
        this.xuzhu = xuzhu;
    }


    /**
     * Gets the IDNo value for this EntityRecMain.
     * 
     * @return IDNo
     */
    public String getIDNo() {
        return IDNo;
    }


    /**
     * Sets the IDNo value for this EntityRecMain.
     * 
     * @param IDNo
     */
    public void setIDNo(String IDNo) {
        this.IDNo = IDNo;
    }


    /**
     * Gets the noPay value for this EntityRecMain.
     * 
     * @return noPay
     */
    public boolean isNoPay() {
        return noPay;
    }


    /**
     * Sets the noPay value for this EntityRecMain.
     * 
     * @param noPay
     */
    public void setNoPay(boolean noPay) {
        this.noPay = noPay;
    }


    /**
     * Gets the isContinue value for this EntityRecMain.
     * 
     * @return isContinue
     */
    public boolean isIsContinue() {
        return isContinue;
    }


    /**
     * Sets the isContinue value for this EntityRecMain.
     * 
     * @param isContinue
     */
    public void setIsContinue(boolean isContinue) {
        this.isContinue = isContinue;
    }


    /**
     * Gets the isCheckOut value for this EntityRecMain.
     * 
     * @return isCheckOut
     */
    public boolean isIsCheckOut() {
        return isCheckOut;
    }


    /**
     * Sets the isCheckOut value for this EntityRecMain.
     * 
     * @param isCheckOut
     */
    public void setIsCheckOut(boolean isCheckOut) {
        this.isCheckOut = isCheckOut;
    }


    /**
     * Gets the hotelName value for this EntityRecMain.
     * 
     * @return hotelName
     */
    public String getHotelName() {
        return hotelName;
    }


    /**
     * Sets the hotelName value for this EntityRecMain.
     * 
     * @param hotelName
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    /**
     * Gets the roomTypeName value for this EntityRecMain.
     * 
     * @return roomTypeName
     */
    public String getRoomTypeName() {
        return roomTypeName;
    }


    /**
     * Sets the roomTypeName value for this EntityRecMain.
     * 
     * @param roomTypeName
     */
    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }


    /**
     * Gets the sResBookVNo value for this EntityRecMain.
     * 
     * @return sResBookVNo
     */
    public String getSResBookVNo() {
        return sResBookVNo;
    }


    /**
     * Sets the sResBookVNo value for this EntityRecMain.
     * 
     * @param sResBookVNo
     */
    public void setSResBookVNo(String sResBookVNo) {
        this.sResBookVNo = sResBookVNo;
    }


    /**
     * Gets the sIDNo value for this EntityRecMain.
     * 
     * @return sIDNo
     */
    public String getSIDNo() {
        return sIDNo;
    }


    /**
     * Sets the sIDNo value for this EntityRecMain.
     * 
     * @param sIDNo
     */
    public void setSIDNo(String sIDNo) {
        this.sIDNo = sIDNo;
    }


    /**
     * Gets the sIDTypeID value for this EntityRecMain.
     * 
     * @return sIDTypeID
     */
    public String getSIDTypeID() {
        return sIDTypeID;
    }


    /**
     * Sets the sIDTypeID value for this EntityRecMain.
     * 
     * @param sIDTypeID
     */
    public void setSIDTypeID(String sIDTypeID) {
        this.sIDTypeID = sIDTypeID;
    }


    /**
     * Gets the sIDTypeName value for this EntityRecMain.
     * 
     * @return sIDTypeName
     */
    public String getSIDTypeName() {
        return sIDTypeName;
    }


    /**
     * Sets the sIDTypeName value for this EntityRecMain.
     * 
     * @param sIDTypeName
     */
    public void setSIDTypeName(String sIDTypeName) {
        this.sIDTypeName = sIDTypeName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EntityRecMain)) return false;
        EntityRecMain other = (EntityRecMain) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sReceiveID==null && other.getSReceiveID()==null) || 
             (this.sReceiveID!=null &&
              this.sReceiveID.equals(other.getSReceiveID()))) &&
            ((this.sCusAccID==null && other.getSCusAccID()==null) || 
             (this.sCusAccID!=null &&
              this.sCusAccID.equals(other.getSCusAccID()))) &&
            ((this.sCusName==null && other.getSCusName()==null) || 
             (this.sCusName!=null &&
              this.sCusName.equals(other.getSCusName()))) &&
            ((this.sGroupID==null && other.getSGroupID()==null) || 
             (this.sGroupID!=null &&
              this.sGroupID.equals(other.getSGroupID()))) &&
            ((this.sGroupName==null && other.getSGroupName()==null) || 
             (this.sGroupName!=null &&
              this.sGroupName.equals(other.getSGroupName()))) &&
            ((this.sSrcID==null && other.getSSrcID()==null) || 
             (this.sSrcID!=null &&
              this.sSrcID.equals(other.getSSrcID()))) &&
            ((this.sCurCategoryID==null && other.getSCurCategoryID()==null) || 
             (this.sCurCategoryID!=null &&
              this.sCurCategoryID.equals(other.getSCurCategoryID()))) &&
            ((this.sResCurCategoryID==null && other.getSResCurCategoryID()==null) || 
             (this.sResCurCategoryID!=null &&
              this.sResCurCategoryID.equals(other.getSResCurCategoryID()))) &&
            ((this.sRcpType==null && other.getSRcpType()==null) || 
             (this.sRcpType!=null &&
              this.sRcpType.equals(other.getSRcpType()))) &&
            ((this.sBookerLevel==null && other.getSBookerLevel()==null) || 
             (this.sBookerLevel!=null &&
              this.sBookerLevel.equals(other.getSBookerLevel()))) &&
            ((this.sBookerID==null && other.getSBookerID()==null) || 
             (this.sBookerID!=null &&
              this.sBookerID.equals(other.getSBookerID()))) &&
            ((this.sCardNo==null && other.getSCardNo()==null) || 
             (this.sCardNo!=null &&
              this.sCardNo.equals(other.getSCardNo()))) &&
            ((this.sCRSNo==null && other.getSCRSNo()==null) || 
             (this.sCRSNo!=null &&
              this.sCRSNo.equals(other.getSCRSNo()))) &&
            ((this.sContractNo==null && other.getSContractNo()==null) || 
             (this.sContractNo!=null &&
              this.sContractNo.equals(other.getSContractNo()))) &&
            ((this.sRefNo==null && other.getSRefNo()==null) || 
             (this.sRefNo!=null &&
              this.sRefNo.equals(other.getSRefNo()))) &&
            ((this.sCompanyName==null && other.getSCompanyName()==null) || 
             (this.sCompanyName!=null &&
              this.sCompanyName.equals(other.getSCompanyName()))) &&
            ((this.sMemName==null && other.getSMemName()==null) || 
             (this.sMemName!=null &&
              this.sMemName.equals(other.getSMemName()))) &&
            ((this.sMemMobile==null && other.getSMemMobile()==null) || 
             (this.sMemMobile!=null &&
              this.sMemMobile.equals(other.getSMemMobile()))) &&
            ((this.sMemPhone==null && other.getSMemPhone()==null) || 
             (this.sMemPhone!=null &&
              this.sMemPhone.equals(other.getSMemPhone()))) &&
            ((this.sMemFax==null && other.getSMemFax()==null) || 
             (this.sMemFax!=null &&
              this.sMemFax.equals(other.getSMemFax()))) &&
            ((this.sMemEmail==null && other.getSMemEmail()==null) || 
             (this.sMemEmail!=null &&
              this.sMemEmail.equals(other.getSMemEmail()))) &&
            ((this.dCheckinDate==null && other.getDCheckinDate()==null) || 
             (this.dCheckinDate!=null &&
              this.dCheckinDate.equals(other.getDCheckinDate()))) &&
            ((this.dCheckinBizday==null && other.getDCheckinBizday()==null) || 
             (this.dCheckinBizday!=null &&
              this.dCheckinBizday.equals(other.getDCheckinBizday()))) &&
            ((this.dBizDay==null && other.getDBizDay()==null) || 
             (this.dBizDay!=null &&
              this.dBizDay.equals(other.getDBizDay()))) &&
            ((this.dEstDepDate==null && other.getDEstDepDate()==null) || 
             (this.dEstDepDate!=null &&
              this.dEstDepDate.equals(other.getDEstDepDate()))) &&
            ((this.dDepDate==null && other.getDDepDate()==null) || 
             (this.dDepDate!=null &&
              this.dDepDate.equals(other.getDDepDate()))) &&
            ((this.sBillID==null && other.getSBillID()==null) || 
             (this.sBillID!=null &&
              this.sBillID.equals(other.getSBillID()))) &&
            ((this.sHotelID==null && other.getSHotelID()==null) || 
             (this.sHotelID!=null &&
              this.sHotelID.equals(other.getSHotelID()))) &&
            ((this.sHall==null && other.getSHall()==null) || 
             (this.sHall!=null &&
              this.sHall.equals(other.getSHall()))) &&
            ((this.sFloor==null && other.getSFloor()==null) || 
             (this.sFloor!=null &&
              this.sFloor.equals(other.getSFloor()))) &&
            ((this.sRoomTypeID==null && other.getSRoomTypeID()==null) || 
             (this.sRoomTypeID!=null &&
              this.sRoomTypeID.equals(other.getSRoomTypeID()))) &&
            ((this.sUpRoomTypeID==null && other.getSUpRoomTypeID()==null) || 
             (this.sUpRoomTypeID!=null &&
              this.sUpRoomTypeID.equals(other.getSUpRoomTypeID()))) &&
            ((this.sRoomNo==null && other.getSRoomNo()==null) || 
             (this.sRoomNo!=null &&
              this.sRoomNo.equals(other.getSRoomNo()))) &&
            ((this.cPrice==null && other.getCPrice()==null) || 
             (this.cPrice!=null &&
              this.cPrice.equals(other.getCPrice()))) &&
            ((this.sRateCode==null && other.getSRateCode()==null) || 
             (this.sRateCode!=null &&
              this.sRateCode.equals(other.getSRateCode()))) &&
            ((this.iPersonCnt==null && other.getIPersonCnt()==null) || 
             (this.iPersonCnt!=null &&
              this.iPersonCnt.equals(other.getIPersonCnt()))) &&
            ((this.iMaxSoupticket==null && other.getIMaxSoupticket()==null) || 
             (this.iMaxSoupticket!=null &&
              this.iMaxSoupticket.equals(other.getIMaxSoupticket()))) &&
            ((this.iSoupticket==null && other.getISoupticket()==null) || 
             (this.iSoupticket!=null &&
              this.iSoupticket.equals(other.getISoupticket()))) &&
            ((this.sRecStatusID==null && other.getSRecStatusID()==null) || 
             (this.sRecStatusID!=null &&
              this.sRecStatusID.equals(other.getSRecStatusID()))) &&
            this.bIsRenew == other.isBIsRenew() &&
            ((this.sReceivePropertyID==null && other.getSReceivePropertyID()==null) || 
             (this.sReceivePropertyID!=null &&
              this.sReceivePropertyID.equals(other.getSReceivePropertyID()))) &&
            ((this.sCauseID==null && other.getSCauseID()==null) || 
             (this.sCauseID!=null &&
              this.sCauseID.equals(other.getSCauseID()))) &&
            ((this.sCheckinType==null && other.getSCheckinType()==null) || 
             (this.sCheckinType!=null &&
              this.sCheckinType.equals(other.getSCheckinType()))) &&
            ((this.sRefGroupRecID==null && other.getSRefGroupRecID()==null) || 
             (this.sRefGroupRecID!=null &&
              this.sRefGroupRecID.equals(other.getSRefGroupRecID()))) &&
            ((this.sInmateRecID==null && other.getSInmateRecID()==null) || 
             (this.sInmateRecID!=null &&
              this.sInmateRecID.equals(other.getSInmateRecID()))) &&
            this.bIsMainOrder == other.isBIsMainOrder() &&
            ((this.iInmateCount==null && other.getIInmateCount()==null) || 
             (this.iInmateCount!=null &&
              this.iInmateCount.equals(other.getIInmateCount()))) &&
            ((this.cInmateRate==null && other.getCInmateRate()==null) || 
             (this.cInmateRate!=null &&
              this.cInmateRate.equals(other.getCInmateRate()))) &&
            ((this.sRefRecTypeID==null && other.getSRefRecTypeID()==null) || 
             (this.sRefRecTypeID!=null &&
              this.sRefRecTypeID.equals(other.getSRefRecTypeID()))) &&
            ((this.sRefRecID==null && other.getSRefRecID()==null) || 
             (this.sRefRecID!=null &&
              this.sRefRecID.equals(other.getSRefRecID()))) &&
            ((this.iKeyCnt==null && other.getIKeyCnt()==null) || 
             (this.iKeyCnt!=null &&
              this.iKeyCnt.equals(other.getIKeyCnt()))) &&
            ((this.iPrintCnt==null && other.getIPrintCnt()==null) || 
             (this.iPrintCnt!=null &&
              this.iPrintCnt.equals(other.getIPrintCnt()))) &&
            this.bIsDisturb == other.isBIsDisturb() &&
            this.bIsInquiry == other.isBIsInquiry() &&
            ((this.sCloseClassID==null && other.getSCloseClassID()==null) || 
             (this.sCloseClassID!=null &&
              this.sCloseClassID.equals(other.getSCloseClassID()))) &&
            ((this.sReceiveClassID==null && other.getSReceiveClassID()==null) || 
             (this.sReceiveClassID!=null &&
              this.sReceiveClassID.equals(other.getSReceiveClassID()))) &&
            this.bIsOneself == other.isBIsOneself() &&
            ((this.dCreateDate==null && other.getDCreateDate()==null) || 
             (this.dCreateDate!=null &&
              this.dCreateDate.equals(other.getDCreateDate()))) &&
            ((this.sOperatorID==null && other.getSOperatorID()==null) || 
             (this.sOperatorID!=null &&
              this.sOperatorID.equals(other.getSOperatorID()))) &&
            ((this.dModifyDate==null && other.getDModifyDate()==null) || 
             (this.dModifyDate!=null &&
              this.dModifyDate.equals(other.getDModifyDate()))) &&
            ((this.sMemo==null && other.getSMemo()==null) || 
             (this.sMemo!=null &&
              this.sMemo.equals(other.getSMemo()))) &&
            ((this.sShiftID==null && other.getSShiftID()==null) || 
             (this.sShiftID!=null &&
              this.sShiftID.equals(other.getSShiftID()))) &&
            ((this.sMessage==null && other.getSMessage()==null) || 
             (this.sMessage!=null &&
              this.sMessage.equals(other.getSMessage()))) &&
            ((this.sActivityCode==null && other.getSActivityCode()==null) || 
             (this.sActivityCode!=null &&
              this.sActivityCode.equals(other.getSActivityCode()))) &&
            this.bIsSelfCheckin == other.isBIsSelfCheckin() &&
            ((this.sCheckinSrc==null && other.getSCheckinSrc()==null) || 
             (this.sCheckinSrc!=null &&
              this.sCheckinSrc.equals(other.getSCheckinSrc()))) &&
            this.isZeroSecondOrder == other.isIsZeroSecondOrder() &&
            ((this.expenses==null && other.getExpenses()==null) || 
             (this.expenses!=null &&
              this.expenses.equals(other.getExpenses()))) &&
            ((this.activityName==null && other.getActivityName()==null) || 
             (this.activityName!=null &&
              this.activityName.equals(other.getActivityName()))) &&
            ((this.dayPrice==null && other.getDayPrice()==null) || 
             (this.dayPrice!=null &&
              this.dayPrice.equals(other.getDayPrice()))) &&
            ((this.havePay==null && other.getHavePay()==null) || 
             (this.havePay!=null &&
              this.havePay.equals(other.getHavePay()))) &&
            ((this.creSum==null && other.getCreSum()==null) || 
             (this.creSum!=null &&
              this.creSum.equals(other.getCreSum()))) &&
            ((this.cAUTHSum==null && other.getCAUTHSum()==null) || 
             (this.cAUTHSum!=null &&
              this.cAUTHSum.equals(other.getCAUTHSum()))) &&
            ((this.cDebSum==null && other.getCDebSum()==null) || 
             (this.cDebSum!=null &&
              this.cDebSum.equals(other.getCDebSum()))) &&
            ((this.sOrderID==null && other.getSOrderID()==null) || 
             (this.sOrderID!=null &&
              this.sOrderID.equals(other.getSOrderID()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            this.xuzhu == other.isXuzhu() &&
            ((this.IDNo==null && other.getIDNo()==null) || 
             (this.IDNo!=null &&
              this.IDNo.equals(other.getIDNo()))) &&
            this.noPay == other.isNoPay() &&
            this.isContinue == other.isIsContinue() &&
            this.isCheckOut == other.isIsCheckOut() &&
            ((this.hotelName==null && other.getHotelName()==null) || 
             (this.hotelName!=null &&
              this.hotelName.equals(other.getHotelName()))) &&
            ((this.roomTypeName==null && other.getRoomTypeName()==null) || 
             (this.roomTypeName!=null &&
              this.roomTypeName.equals(other.getRoomTypeName()))) &&
            ((this.sResBookVNo==null && other.getSResBookVNo()==null) || 
             (this.sResBookVNo!=null &&
              this.sResBookVNo.equals(other.getSResBookVNo()))) &&
            ((this.sIDNo==null && other.getSIDNo()==null) || 
             (this.sIDNo!=null &&
              this.sIDNo.equals(other.getSIDNo()))) &&
            ((this.sIDTypeID==null && other.getSIDTypeID()==null) || 
             (this.sIDTypeID!=null &&
              this.sIDTypeID.equals(other.getSIDTypeID()))) &&
            ((this.sIDTypeName==null && other.getSIDTypeName()==null) || 
             (this.sIDTypeName!=null &&
              this.sIDTypeName.equals(other.getSIDTypeName())));
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
        if (getSReceiveID() != null) {
            _hashCode += getSReceiveID().hashCode();
        }
        if (getSCusAccID() != null) {
            _hashCode += getSCusAccID().hashCode();
        }
        if (getSCusName() != null) {
            _hashCode += getSCusName().hashCode();
        }
        if (getSGroupID() != null) {
            _hashCode += getSGroupID().hashCode();
        }
        if (getSGroupName() != null) {
            _hashCode += getSGroupName().hashCode();
        }
        if (getSSrcID() != null) {
            _hashCode += getSSrcID().hashCode();
        }
        if (getSCurCategoryID() != null) {
            _hashCode += getSCurCategoryID().hashCode();
        }
        if (getSResCurCategoryID() != null) {
            _hashCode += getSResCurCategoryID().hashCode();
        }
        if (getSRcpType() != null) {
            _hashCode += getSRcpType().hashCode();
        }
        if (getSBookerLevel() != null) {
            _hashCode += getSBookerLevel().hashCode();
        }
        if (getSBookerID() != null) {
            _hashCode += getSBookerID().hashCode();
        }
        if (getSCardNo() != null) {
            _hashCode += getSCardNo().hashCode();
        }
        if (getSCRSNo() != null) {
            _hashCode += getSCRSNo().hashCode();
        }
        if (getSContractNo() != null) {
            _hashCode += getSContractNo().hashCode();
        }
        if (getSRefNo() != null) {
            _hashCode += getSRefNo().hashCode();
        }
        if (getSCompanyName() != null) {
            _hashCode += getSCompanyName().hashCode();
        }
        if (getSMemName() != null) {
            _hashCode += getSMemName().hashCode();
        }
        if (getSMemMobile() != null) {
            _hashCode += getSMemMobile().hashCode();
        }
        if (getSMemPhone() != null) {
            _hashCode += getSMemPhone().hashCode();
        }
        if (getSMemFax() != null) {
            _hashCode += getSMemFax().hashCode();
        }
        if (getSMemEmail() != null) {
            _hashCode += getSMemEmail().hashCode();
        }
        if (getDCheckinDate() != null) {
            _hashCode += getDCheckinDate().hashCode();
        }
        if (getDCheckinBizday() != null) {
            _hashCode += getDCheckinBizday().hashCode();
        }
        if (getDBizDay() != null) {
            _hashCode += getDBizDay().hashCode();
        }
        if (getDEstDepDate() != null) {
            _hashCode += getDEstDepDate().hashCode();
        }
        if (getDDepDate() != null) {
            _hashCode += getDDepDate().hashCode();
        }
        if (getSBillID() != null) {
            _hashCode += getSBillID().hashCode();
        }
        if (getSHotelID() != null) {
            _hashCode += getSHotelID().hashCode();
        }
        if (getSHall() != null) {
            _hashCode += getSHall().hashCode();
        }
        if (getSFloor() != null) {
            _hashCode += getSFloor().hashCode();
        }
        if (getSRoomTypeID() != null) {
            _hashCode += getSRoomTypeID().hashCode();
        }
        if (getSUpRoomTypeID() != null) {
            _hashCode += getSUpRoomTypeID().hashCode();
        }
        if (getSRoomNo() != null) {
            _hashCode += getSRoomNo().hashCode();
        }
        if (getCPrice() != null) {
            _hashCode += getCPrice().hashCode();
        }
        if (getSRateCode() != null) {
            _hashCode += getSRateCode().hashCode();
        }
        if (getIPersonCnt() != null) {
            _hashCode += getIPersonCnt().hashCode();
        }
        if (getIMaxSoupticket() != null) {
            _hashCode += getIMaxSoupticket().hashCode();
        }
        if (getISoupticket() != null) {
            _hashCode += getISoupticket().hashCode();
        }
        if (getSRecStatusID() != null) {
            _hashCode += getSRecStatusID().hashCode();
        }
        _hashCode += (isBIsRenew() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSReceivePropertyID() != null) {
            _hashCode += getSReceivePropertyID().hashCode();
        }
        if (getSCauseID() != null) {
            _hashCode += getSCauseID().hashCode();
        }
        if (getSCheckinType() != null) {
            _hashCode += getSCheckinType().hashCode();
        }
        if (getSRefGroupRecID() != null) {
            _hashCode += getSRefGroupRecID().hashCode();
        }
        if (getSInmateRecID() != null) {
            _hashCode += getSInmateRecID().hashCode();
        }
        _hashCode += (isBIsMainOrder() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIInmateCount() != null) {
            _hashCode += getIInmateCount().hashCode();
        }
        if (getCInmateRate() != null) {
            _hashCode += getCInmateRate().hashCode();
        }
        if (getSRefRecTypeID() != null) {
            _hashCode += getSRefRecTypeID().hashCode();
        }
        if (getSRefRecID() != null) {
            _hashCode += getSRefRecID().hashCode();
        }
        if (getIKeyCnt() != null) {
            _hashCode += getIKeyCnt().hashCode();
        }
        if (getIPrintCnt() != null) {
            _hashCode += getIPrintCnt().hashCode();
        }
        _hashCode += (isBIsDisturb() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isBIsInquiry() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSCloseClassID() != null) {
            _hashCode += getSCloseClassID().hashCode();
        }
        if (getSReceiveClassID() != null) {
            _hashCode += getSReceiveClassID().hashCode();
        }
        _hashCode += (isBIsOneself() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDCreateDate() != null) {
            _hashCode += getDCreateDate().hashCode();
        }
        if (getSOperatorID() != null) {
            _hashCode += getSOperatorID().hashCode();
        }
        if (getDModifyDate() != null) {
            _hashCode += getDModifyDate().hashCode();
        }
        if (getSMemo() != null) {
            _hashCode += getSMemo().hashCode();
        }
        if (getSShiftID() != null) {
            _hashCode += getSShiftID().hashCode();
        }
        if (getSMessage() != null) {
            _hashCode += getSMessage().hashCode();
        }
        if (getSActivityCode() != null) {
            _hashCode += getSActivityCode().hashCode();
        }
        _hashCode += (isBIsSelfCheckin() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSCheckinSrc() != null) {
            _hashCode += getSCheckinSrc().hashCode();
        }
        _hashCode += (isIsZeroSecondOrder() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getExpenses() != null) {
            _hashCode += getExpenses().hashCode();
        }
        if (getActivityName() != null) {
            _hashCode += getActivityName().hashCode();
        }
        if (getDayPrice() != null) {
            _hashCode += getDayPrice().hashCode();
        }
        if (getHavePay() != null) {
            _hashCode += getHavePay().hashCode();
        }
        if (getCreSum() != null) {
            _hashCode += getCreSum().hashCode();
        }
        if (getCAUTHSum() != null) {
            _hashCode += getCAUTHSum().hashCode();
        }
        if (getCDebSum() != null) {
            _hashCode += getCDebSum().hashCode();
        }
        if (getSOrderID() != null) {
            _hashCode += getSOrderID().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        _hashCode += (isXuzhu() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIDNo() != null) {
            _hashCode += getIDNo().hashCode();
        }
        _hashCode += (isNoPay() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsContinue() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsCheckOut() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getHotelName() != null) {
            _hashCode += getHotelName().hashCode();
        }
        if (getRoomTypeName() != null) {
            _hashCode += getRoomTypeName().hashCode();
        }
        if (getSResBookVNo() != null) {
            _hashCode += getSResBookVNo().hashCode();
        }
        if (getSIDNo() != null) {
            _hashCode += getSIDNo().hashCode();
        }
        if (getSIDTypeID() != null) {
            _hashCode += getSIDTypeID().hashCode();
        }
        if (getSIDTypeName() != null) {
            _hashCode += getSIDTypeName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntityRecMain.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityRecMain"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SReceiveID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sReceiveID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCusAccID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCusAccID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCusName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCusName"));
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
        elemField.setFieldName("SSrcID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sSrcID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCurCategoryID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCurCategoryID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SResCurCategoryID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sResCurCategoryID"));
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
        elemField.setFieldName("SBookerLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sBookerLevel"));
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
        elemField.setFieldName("SCardNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCardNo"));
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
        elemField.setFieldName("SContractNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sContractNo"));
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
        elemField.setFieldName("SCompanyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCompanyName"));
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
        elemField.setFieldName("SMemMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMemMobile"));
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
        elemField.setFieldName("SMemFax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMemFax"));
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
        elemField.setFieldName("DCheckinDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dCheckinDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DCheckinBizday");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dCheckinBizday"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DBizDay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dBizDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DEstDepDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dEstDepDate"));
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
        elemField.setFieldName("SBillID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sBillID"));
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
        elemField.setFieldName("SHall");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sHall"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SFloor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sFloor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRoomTypeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRoomTypeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUpRoomTypeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sUpRoomTypeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRoomNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRoomNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "cPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRateCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRateCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IPersonCnt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iPersonCnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMaxSoupticket");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iMaxSoupticket"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ISoupticket");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iSoupticket"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRecStatusID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRecStatusID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIsRenew");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsRenew"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SReceivePropertyID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sReceivePropertyID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCauseID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCauseID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCheckinType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCheckinType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRefGroupRecID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRefGroupRecID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SInmateRecID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sInmateRecID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIsMainOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsMainOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IInmateCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iInmateCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CInmateRate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "cInmateRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRefRecTypeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRefRecTypeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRefRecID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRefRecID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IKeyCnt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iKeyCnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IPrintCnt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iPrintCnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIsDisturb");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsDisturb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIsInquiry");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsInquiry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCloseClassID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCloseClassID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SReceiveClassID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sReceiveClassID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIsOneself");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsOneself"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DCreateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dCreateDate"));
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
        elemField.setFieldName("DModifyDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dModifyDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMemo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMemo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SShiftID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sShiftID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMessage"));
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
        elemField.setFieldName("BIsSelfCheckin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsSelfCheckin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCheckinSrc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sCheckinSrc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isZeroSecondOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "isZeroSecondOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expenses");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "expenses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activityName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "ActivityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dayPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dayPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("havePay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "havePay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creSum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "creSum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAUTHSum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "cAUTHSum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CDebSum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "cDebSum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOrderID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sOrderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xuzhu");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "Xuzhu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "IDNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noPay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "noPay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isContinue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "isContinue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCheckOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "isCheckOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hotelName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "HotelName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "RoomTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SResBookVNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sResBookVNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIDNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sIDNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIDTypeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sIDTypeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIDTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sIDTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
