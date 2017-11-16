/**
 * EntityResDetailPrice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public class EntityResDetailPrice  implements java.io.Serializable {
    private String sOrderID;

    private String sRoomTypeID;

    private java.util.Calendar dArrDate;

    private java.util.Calendar dDepDate;

    private java.util.Calendar dBizDay;

    private java.math.BigDecimal cPrice;

    private java.math.BigDecimal cMarketPrice;

    private String sRateCode;

    private String sOperatorID;

    private java.util.Calendar dCreateDate;

    private java.util.Calendar dModifyDate;

    private String sActivityCode;

    public EntityResDetailPrice() {
    }

    public EntityResDetailPrice(
           String sOrderID,
           String sRoomTypeID,
           java.util.Calendar dArrDate,
           java.util.Calendar dDepDate,
           java.util.Calendar dBizDay,
           java.math.BigDecimal cPrice,
           java.math.BigDecimal cMarketPrice,
           String sRateCode,
           String sOperatorID,
           java.util.Calendar dCreateDate,
           java.util.Calendar dModifyDate,
           String sActivityCode) {
           this.sOrderID = sOrderID;
           this.sRoomTypeID = sRoomTypeID;
           this.dArrDate = dArrDate;
           this.dDepDate = dDepDate;
           this.dBizDay = dBizDay;
           this.cPrice = cPrice;
           this.cMarketPrice = cMarketPrice;
           this.sRateCode = sRateCode;
           this.sOperatorID = sOperatorID;
           this.dCreateDate = dCreateDate;
           this.dModifyDate = dModifyDate;
           this.sActivityCode = sActivityCode;
    }


    /**
     * Gets the sOrderID value for this EntityResDetailPrice.
     *
     * @return sOrderID
     */
    public String getSOrderID() {
        return sOrderID;
    }


    /**
     * Sets the sOrderID value for this EntityResDetailPrice.
     *
     * @param sOrderID
     */
    public void setSOrderID(String sOrderID) {
        this.sOrderID = sOrderID;
    }


    /**
     * Gets the sRoomTypeID value for this EntityResDetailPrice.
     *
     * @return sRoomTypeID
     */
    public String getSRoomTypeID() {
        return sRoomTypeID;
    }


    /**
     * Sets the sRoomTypeID value for this EntityResDetailPrice.
     *
     * @param sRoomTypeID
     */
    public void setSRoomTypeID(String sRoomTypeID) {
        this.sRoomTypeID = sRoomTypeID;
    }


    /**
     * Gets the dArrDate value for this EntityResDetailPrice.
     *
     * @return dArrDate
     */
    public java.util.Calendar getDArrDate() {
        return dArrDate;
    }


    /**
     * Sets the dArrDate value for this EntityResDetailPrice.
     *
     * @param dArrDate
     */
    public void setDArrDate(java.util.Calendar dArrDate) {
        this.dArrDate = dArrDate;
    }


    /**
     * Gets the dDepDate value for this EntityResDetailPrice.
     *
     * @return dDepDate
     */
    public java.util.Calendar getDDepDate() {
        return dDepDate;
    }


    /**
     * Sets the dDepDate value for this EntityResDetailPrice.
     *
     * @param dDepDate
     */
    public void setDDepDate(java.util.Calendar dDepDate) {
        this.dDepDate = dDepDate;
    }


    /**
     * Gets the dBizDay value for this EntityResDetailPrice.
     *
     * @return dBizDay
     */
    public java.util.Calendar getDBizDay() {
        return dBizDay;
    }


    /**
     * Sets the dBizDay value for this EntityResDetailPrice.
     *
     * @param dBizDay
     */
    public void setDBizDay(java.util.Calendar dBizDay) {
        this.dBizDay = dBizDay;
    }


    /**
     * Gets the cPrice value for this EntityResDetailPrice.
     *
     * @return cPrice
     */
    public java.math.BigDecimal getCPrice() {
        return cPrice;
    }


    /**
     * Sets the cPrice value for this EntityResDetailPrice.
     *
     * @param cPrice
     */
    public void setCPrice(java.math.BigDecimal cPrice) {
        this.cPrice = cPrice;
    }


    /**
     * Gets the cMarketPrice value for this EntityResDetailPrice.
     *
     * @return cMarketPrice
     */
    public java.math.BigDecimal getCMarketPrice() {
        return cMarketPrice;
    }


    /**
     * Sets the cMarketPrice value for this EntityResDetailPrice.
     *
     * @param cMarketPrice
     */
    public void setCMarketPrice(java.math.BigDecimal cMarketPrice) {
        this.cMarketPrice = cMarketPrice;
    }


    /**
     * Gets the sRateCode value for this EntityResDetailPrice.
     *
     * @return sRateCode
     */
    public String getSRateCode() {
        return sRateCode;
    }


    /**
     * Sets the sRateCode value for this EntityResDetailPrice.
     *
     * @param sRateCode
     */
    public void setSRateCode(String sRateCode) {
        this.sRateCode = sRateCode;
    }


    /**
     * Gets the sOperatorID value for this EntityResDetailPrice.
     *
     * @return sOperatorID
     */
    public String getSOperatorID() {
        return sOperatorID;
    }


    /**
     * Sets the sOperatorID value for this EntityResDetailPrice.
     *
     * @param sOperatorID
     */
    public void setSOperatorID(String sOperatorID) {
        this.sOperatorID = sOperatorID;
    }


    /**
     * Gets the dCreateDate value for this EntityResDetailPrice.
     *
     * @return dCreateDate
     */
    public java.util.Calendar getDCreateDate() {
        return dCreateDate;
    }


    /**
     * Sets the dCreateDate value for this EntityResDetailPrice.
     *
     * @param dCreateDate
     */
    public void setDCreateDate(java.util.Calendar dCreateDate) {
        this.dCreateDate = dCreateDate;
    }


    /**
     * Gets the dModifyDate value for this EntityResDetailPrice.
     *
     * @return dModifyDate
     */
    public java.util.Calendar getDModifyDate() {
        return dModifyDate;
    }


    /**
     * Sets the dModifyDate value for this EntityResDetailPrice.
     *
     * @param dModifyDate
     */
    public void setDModifyDate(java.util.Calendar dModifyDate) {
        this.dModifyDate = dModifyDate;
    }


    /**
     * Gets the sActivityCode value for this EntityResDetailPrice.
     *
     * @return sActivityCode
     */
    public String getSActivityCode() {
        return sActivityCode;
    }


    /**
     * Sets the sActivityCode value for this EntityResDetailPrice.
     *
     * @param sActivityCode
     */
    public void setSActivityCode(String sActivityCode) {
        this.sActivityCode = sActivityCode;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EntityResDetailPrice)) return false;
        EntityResDetailPrice other = (EntityResDetailPrice) obj;
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
            ((this.sRoomTypeID==null && other.getSRoomTypeID()==null) ||
             (this.sRoomTypeID!=null &&
              this.sRoomTypeID.equals(other.getSRoomTypeID()))) &&
            ((this.dArrDate==null && other.getDArrDate()==null) ||
             (this.dArrDate!=null &&
              this.dArrDate.equals(other.getDArrDate()))) &&
            ((this.dDepDate==null && other.getDDepDate()==null) ||
             (this.dDepDate!=null &&
              this.dDepDate.equals(other.getDDepDate()))) &&
            ((this.dBizDay==null && other.getDBizDay()==null) ||
             (this.dBizDay!=null &&
              this.dBizDay.equals(other.getDBizDay()))) &&
            ((this.cPrice==null && other.getCPrice()==null) ||
             (this.cPrice!=null &&
              this.cPrice.equals(other.getCPrice()))) &&
            ((this.cMarketPrice==null && other.getCMarketPrice()==null) ||
             (this.cMarketPrice!=null &&
              this.cMarketPrice.equals(other.getCMarketPrice()))) &&
            ((this.sRateCode==null && other.getSRateCode()==null) ||
             (this.sRateCode!=null &&
              this.sRateCode.equals(other.getSRateCode()))) &&
            ((this.sOperatorID==null && other.getSOperatorID()==null) ||
             (this.sOperatorID!=null &&
              this.sOperatorID.equals(other.getSOperatorID()))) &&
            ((this.dCreateDate==null && other.getDCreateDate()==null) ||
             (this.dCreateDate!=null &&
              this.dCreateDate.equals(other.getDCreateDate()))) &&
            ((this.dModifyDate==null && other.getDModifyDate()==null) ||
             (this.dModifyDate!=null &&
              this.dModifyDate.equals(other.getDModifyDate()))) &&
            ((this.sActivityCode==null && other.getSActivityCode()==null) ||
             (this.sActivityCode!=null &&
              this.sActivityCode.equals(other.getSActivityCode())));
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
        if (getSRoomTypeID() != null) {
            _hashCode += getSRoomTypeID().hashCode();
        }
        if (getDArrDate() != null) {
            _hashCode += getDArrDate().hashCode();
        }
        if (getDDepDate() != null) {
            _hashCode += getDDepDate().hashCode();
        }
        if (getDBizDay() != null) {
            _hashCode += getDBizDay().hashCode();
        }
        if (getCPrice() != null) {
            _hashCode += getCPrice().hashCode();
        }
        if (getCMarketPrice() != null) {
            _hashCode += getCMarketPrice().hashCode();
        }
        if (getSRateCode() != null) {
            _hashCode += getSRateCode().hashCode();
        }
        if (getSOperatorID() != null) {
            _hashCode += getSOperatorID().hashCode();
        }
        if (getDCreateDate() != null) {
            _hashCode += getDCreateDate().hashCode();
        }
        if (getDModifyDate() != null) {
            _hashCode += getDModifyDate().hashCode();
        }
        if (getSActivityCode() != null) {
            _hashCode += getSActivityCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntityResDetailPrice.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetailPrice"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOrderID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sOrderID"));
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
        elemField.setFieldName("DBizDay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dBizDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "cPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMarketPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "cMarketPrice"));
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
        elemField.setFieldName("SOperatorID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sOperatorID"));
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
        elemField.setFieldName("SActivityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sActivityCode"));
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
