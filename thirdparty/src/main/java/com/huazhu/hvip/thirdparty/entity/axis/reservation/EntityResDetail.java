/**
 * EntityResDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public class EntityResDetail  implements java.io.Serializable {
    private String sOrderID;

    private String sHotelID;

    private String sRoomTypeID;

    private int iRoomCnt;

    private java.util.Calendar dArrDate;

    private int iDays;

    private java.util.Calendar dDepDate;

    private java.util.Calendar dArrTime;

    private java.util.Calendar dKeepTime;

    private String sRateCode;

    private int iAssignCnt;

    private int iCheckin;

    private String sStatusID;

    private java.math.BigDecimal cFirPrice;

    private java.math.BigDecimal cAvgPrice;

    private String sOperatorId;

    private java.util.Calendar dModifyDate;

    private String sActivityCode;

    private com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetailPrice[] perDayPrices;

    private com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResAssign[] assignRooms;

    public EntityResDetail() {
    }

    public EntityResDetail(
           String sOrderID,
           String sHotelID,
           String sRoomTypeID,
           int iRoomCnt,
           java.util.Calendar dArrDate,
           int iDays,
           java.util.Calendar dDepDate,
           java.util.Calendar dArrTime,
           java.util.Calendar dKeepTime,
           String sRateCode,
           int iAssignCnt,
           int iCheckin,
           String sStatusID,
           java.math.BigDecimal cFirPrice,
           java.math.BigDecimal cAvgPrice,
           String sOperatorId,
           java.util.Calendar dModifyDate,
           String sActivityCode,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetailPrice[] perDayPrices,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResAssign[] assignRooms) {
           this.sOrderID = sOrderID;
           this.sHotelID = sHotelID;
           this.sRoomTypeID = sRoomTypeID;
           this.iRoomCnt = iRoomCnt;
           this.dArrDate = dArrDate;
           this.iDays = iDays;
           this.dDepDate = dDepDate;
           this.dArrTime = dArrTime;
           this.dKeepTime = dKeepTime;
           this.sRateCode = sRateCode;
           this.iAssignCnt = iAssignCnt;
           this.iCheckin = iCheckin;
           this.sStatusID = sStatusID;
           this.cFirPrice = cFirPrice;
           this.cAvgPrice = cAvgPrice;
           this.sOperatorId = sOperatorId;
           this.dModifyDate = dModifyDate;
           this.sActivityCode = sActivityCode;
           this.perDayPrices = perDayPrices;
           this.assignRooms = assignRooms;
    }


    /**
     * Gets the sOrderID value for this EntityResDetail.
     *
     * @return sOrderID
     */
    public String getSOrderID() {
        return sOrderID;
    }


    /**
     * Sets the sOrderID value for this EntityResDetail.
     *
     * @param sOrderID
     */
    public void setSOrderID(String sOrderID) {
        this.sOrderID = sOrderID;
    }


    /**
     * Gets the sHotelID value for this EntityResDetail.
     *
     * @return sHotelID
     */
    public String getSHotelID() {
        return sHotelID;
    }


    /**
     * Sets the sHotelID value for this EntityResDetail.
     *
     * @param sHotelID
     */
    public void setSHotelID(String sHotelID) {
        this.sHotelID = sHotelID;
    }


    /**
     * Gets the sRoomTypeID value for this EntityResDetail.
     *
     * @return sRoomTypeID
     */
    public String getSRoomTypeID() {
        return sRoomTypeID;
    }


    /**
     * Sets the sRoomTypeID value for this EntityResDetail.
     *
     * @param sRoomTypeID
     */
    public void setSRoomTypeID(String sRoomTypeID) {
        this.sRoomTypeID = sRoomTypeID;
    }


    /**
     * Gets the iRoomCnt value for this EntityResDetail.
     *
     * @return iRoomCnt
     */
    public int getIRoomCnt() {
        return iRoomCnt;
    }


    /**
     * Sets the iRoomCnt value for this EntityResDetail.
     *
     * @param iRoomCnt
     */
    public void setIRoomCnt(int iRoomCnt) {
        this.iRoomCnt = iRoomCnt;
    }


    /**
     * Gets the dArrDate value for this EntityResDetail.
     *
     * @return dArrDate
     */
    public java.util.Calendar getDArrDate() {
        return dArrDate;
    }


    /**
     * Sets the dArrDate value for this EntityResDetail.
     *
     * @param dArrDate
     */
    public void setDArrDate(java.util.Calendar dArrDate) {
        this.dArrDate = dArrDate;
    }


    /**
     * Gets the iDays value for this EntityResDetail.
     *
     * @return iDays
     */
    public int getIDays() {
        return iDays;
    }


    /**
     * Sets the iDays value for this EntityResDetail.
     *
     * @param iDays
     */
    public void setIDays(int iDays) {
        this.iDays = iDays;
    }


    /**
     * Gets the dDepDate value for this EntityResDetail.
     *
     * @return dDepDate
     */
    public java.util.Calendar getDDepDate() {
        return dDepDate;
    }


    /**
     * Sets the dDepDate value for this EntityResDetail.
     *
     * @param dDepDate
     */
    public void setDDepDate(java.util.Calendar dDepDate) {
        this.dDepDate = dDepDate;
    }


    /**
     * Gets the dArrTime value for this EntityResDetail.
     *
     * @return dArrTime
     */
    public java.util.Calendar getDArrTime() {
        return dArrTime;
    }


    /**
     * Sets the dArrTime value for this EntityResDetail.
     *
     * @param dArrTime
     */
    public void setDArrTime(java.util.Calendar dArrTime) {
        this.dArrTime = dArrTime;
    }


    /**
     * Gets the dKeepTime value for this EntityResDetail.
     *
     * @return dKeepTime
     */
    public java.util.Calendar getDKeepTime() {
        return dKeepTime;
    }


    /**
     * Sets the dKeepTime value for this EntityResDetail.
     *
     * @param dKeepTime
     */
    public void setDKeepTime(java.util.Calendar dKeepTime) {
        this.dKeepTime = dKeepTime;
    }


    /**
     * Gets the sRateCode value for this EntityResDetail.
     *
     * @return sRateCode
     */
    public String getSRateCode() {
        return sRateCode;
    }


    /**
     * Sets the sRateCode value for this EntityResDetail.
     *
     * @param sRateCode
     */
    public void setSRateCode(String sRateCode) {
        this.sRateCode = sRateCode;
    }


    /**
     * Gets the iAssignCnt value for this EntityResDetail.
     *
     * @return iAssignCnt
     */
    public int getIAssignCnt() {
        return iAssignCnt;
    }


    /**
     * Sets the iAssignCnt value for this EntityResDetail.
     *
     * @param iAssignCnt
     */
    public void setIAssignCnt(int iAssignCnt) {
        this.iAssignCnt = iAssignCnt;
    }


    /**
     * Gets the iCheckin value for this EntityResDetail.
     *
     * @return iCheckin
     */
    public int getICheckin() {
        return iCheckin;
    }


    /**
     * Sets the iCheckin value for this EntityResDetail.
     *
     * @param iCheckin
     */
    public void setICheckin(int iCheckin) {
        this.iCheckin = iCheckin;
    }


    /**
     * Gets the sStatusID value for this EntityResDetail.
     *
     * @return sStatusID
     */
    public String getSStatusID() {
        return sStatusID;
    }


    /**
     * Sets the sStatusID value for this EntityResDetail.
     *
     * @param sStatusID
     */
    public void setSStatusID(String sStatusID) {
        this.sStatusID = sStatusID;
    }


    /**
     * Gets the cFirPrice value for this EntityResDetail.
     *
     * @return cFirPrice
     */
    public java.math.BigDecimal getCFirPrice() {
        return cFirPrice;
    }


    /**
     * Sets the cFirPrice value for this EntityResDetail.
     *
     * @param cFirPrice
     */
    public void setCFirPrice(java.math.BigDecimal cFirPrice) {
        this.cFirPrice = cFirPrice;
    }


    /**
     * Gets the cAvgPrice value for this EntityResDetail.
     *
     * @return cAvgPrice
     */
    public java.math.BigDecimal getCAvgPrice() {
        return cAvgPrice;
    }


    /**
     * Sets the cAvgPrice value for this EntityResDetail.
     *
     * @param cAvgPrice
     */
    public void setCAvgPrice(java.math.BigDecimal cAvgPrice) {
        this.cAvgPrice = cAvgPrice;
    }


    /**
     * Gets the sOperatorId value for this EntityResDetail.
     *
     * @return sOperatorId
     */
    public String getSOperatorId() {
        return sOperatorId;
    }


    /**
     * Sets the sOperatorId value for this EntityResDetail.
     *
     * @param sOperatorId
     */
    public void setSOperatorId(String sOperatorId) {
        this.sOperatorId = sOperatorId;
    }


    /**
     * Gets the dModifyDate value for this EntityResDetail.
     *
     * @return dModifyDate
     */
    public java.util.Calendar getDModifyDate() {
        return dModifyDate;
    }


    /**
     * Sets the dModifyDate value for this EntityResDetail.
     *
     * @param dModifyDate
     */
    public void setDModifyDate(java.util.Calendar dModifyDate) {
        this.dModifyDate = dModifyDate;
    }


    /**
     * Gets the sActivityCode value for this EntityResDetail.
     *
     * @return sActivityCode
     */
    public String getSActivityCode() {
        return sActivityCode;
    }


    /**
     * Sets the sActivityCode value for this EntityResDetail.
     *
     * @param sActivityCode
     */
    public void setSActivityCode(String sActivityCode) {
        this.sActivityCode = sActivityCode;
    }


    /**
     * Gets the perDayPrices value for this EntityResDetail.
     *
     * @return perDayPrices
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetailPrice[] getPerDayPrices() {
        return perDayPrices;
    }


    /**
     * Sets the perDayPrices value for this EntityResDetail.
     *
     * @param perDayPrices
     */
    public void setPerDayPrices(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetailPrice[] perDayPrices) {
        this.perDayPrices = perDayPrices;
    }


    /**
     * Gets the assignRooms value for this EntityResDetail.
     *
     * @return assignRooms
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResAssign[] getAssignRooms() {
        return assignRooms;
    }


    /**
     * Sets the assignRooms value for this EntityResDetail.
     *
     * @param assignRooms
     */
    public void setAssignRooms(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResAssign[] assignRooms) {
        this.assignRooms = assignRooms;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EntityResDetail)) return false;
        EntityResDetail other = (EntityResDetail) obj;
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
            ((this.sHotelID==null && other.getSHotelID()==null) ||
             (this.sHotelID!=null &&
              this.sHotelID.equals(other.getSHotelID()))) &&
            ((this.sRoomTypeID==null && other.getSRoomTypeID()==null) ||
             (this.sRoomTypeID!=null &&
              this.sRoomTypeID.equals(other.getSRoomTypeID()))) &&
            this.iRoomCnt == other.getIRoomCnt() &&
            ((this.dArrDate==null && other.getDArrDate()==null) ||
             (this.dArrDate!=null &&
              this.dArrDate.equals(other.getDArrDate()))) &&
            this.iDays == other.getIDays() &&
            ((this.dDepDate==null && other.getDDepDate()==null) ||
             (this.dDepDate!=null &&
              this.dDepDate.equals(other.getDDepDate()))) &&
            ((this.dArrTime==null && other.getDArrTime()==null) ||
             (this.dArrTime!=null &&
              this.dArrTime.equals(other.getDArrTime()))) &&
            ((this.dKeepTime==null && other.getDKeepTime()==null) ||
             (this.dKeepTime!=null &&
              this.dKeepTime.equals(other.getDKeepTime()))) &&
            ((this.sRateCode==null && other.getSRateCode()==null) ||
             (this.sRateCode!=null &&
              this.sRateCode.equals(other.getSRateCode()))) &&
            this.iAssignCnt == other.getIAssignCnt() &&
            this.iCheckin == other.getICheckin() &&
            ((this.sStatusID==null && other.getSStatusID()==null) ||
             (this.sStatusID!=null &&
              this.sStatusID.equals(other.getSStatusID()))) &&
            ((this.cFirPrice==null && other.getCFirPrice()==null) ||
             (this.cFirPrice!=null &&
              this.cFirPrice.equals(other.getCFirPrice()))) &&
            ((this.cAvgPrice==null && other.getCAvgPrice()==null) ||
             (this.cAvgPrice!=null &&
              this.cAvgPrice.equals(other.getCAvgPrice()))) &&
            ((this.sOperatorId==null && other.getSOperatorId()==null) ||
             (this.sOperatorId!=null &&
              this.sOperatorId.equals(other.getSOperatorId()))) &&
            ((this.dModifyDate==null && other.getDModifyDate()==null) ||
             (this.dModifyDate!=null &&
              this.dModifyDate.equals(other.getDModifyDate()))) &&
            ((this.sActivityCode==null && other.getSActivityCode()==null) ||
             (this.sActivityCode!=null &&
              this.sActivityCode.equals(other.getSActivityCode()))) &&
            ((this.perDayPrices==null && other.getPerDayPrices()==null) ||
             (this.perDayPrices!=null &&
              java.util.Arrays.equals(this.perDayPrices, other.getPerDayPrices()))) &&
            ((this.assignRooms==null && other.getAssignRooms()==null) ||
             (this.assignRooms!=null &&
              java.util.Arrays.equals(this.assignRooms, other.getAssignRooms())));
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
        if (getSHotelID() != null) {
            _hashCode += getSHotelID().hashCode();
        }
        if (getSRoomTypeID() != null) {
            _hashCode += getSRoomTypeID().hashCode();
        }
        _hashCode += getIRoomCnt();
        if (getDArrDate() != null) {
            _hashCode += getDArrDate().hashCode();
        }
        _hashCode += getIDays();
        if (getDDepDate() != null) {
            _hashCode += getDDepDate().hashCode();
        }
        if (getDArrTime() != null) {
            _hashCode += getDArrTime().hashCode();
        }
        if (getDKeepTime() != null) {
            _hashCode += getDKeepTime().hashCode();
        }
        if (getSRateCode() != null) {
            _hashCode += getSRateCode().hashCode();
        }
        _hashCode += getIAssignCnt();
        _hashCode += getICheckin();
        if (getSStatusID() != null) {
            _hashCode += getSStatusID().hashCode();
        }
        if (getCFirPrice() != null) {
            _hashCode += getCFirPrice().hashCode();
        }
        if (getCAvgPrice() != null) {
            _hashCode += getCAvgPrice().hashCode();
        }
        if (getSOperatorId() != null) {
            _hashCode += getSOperatorId().hashCode();
        }
        if (getDModifyDate() != null) {
            _hashCode += getDModifyDate().hashCode();
        }
        if (getSActivityCode() != null) {
            _hashCode += getSActivityCode().hashCode();
        }
        if (getPerDayPrices() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPerDayPrices());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getPerDayPrices(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAssignRooms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAssignRooms());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getAssignRooms(), i);
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
        new org.apache.axis.description.TypeDesc(EntityResDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOrderID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sOrderID"));
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
        elemField.setFieldName("SRoomTypeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRoomTypeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IRoomCnt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iRoomCnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DArrDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dArrDate"));
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
        elemField.setFieldName("SRateCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRateCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IAssignCnt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iAssignCnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ICheckin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "iCheckin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SStatusID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sStatusID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CFirPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "cFirPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAvgPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "cAvgPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOperatorId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sOperatorId"));
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
        elemField.setFieldName("SActivityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sActivityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perDayPrices");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "PerDayPrices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetailPrice"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetailPrice"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assignRooms");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "AssignRooms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResAssign"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResAssign"));
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
