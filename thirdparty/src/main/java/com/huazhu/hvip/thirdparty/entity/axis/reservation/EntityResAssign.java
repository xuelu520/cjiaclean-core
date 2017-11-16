/**
 * EntityResAssign.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public class EntityResAssign  implements java.io.Serializable {
    private String sOrderID;

    private String sRoomTypeID;

    private java.util.Calendar dArrDate;

    private java.util.Calendar dDepDate;

    private String sHotelID;

    private String sRoomNo;

    private boolean bIsCheckIn;

    private String sReceiveID;

    private String sOperatorID;

    private java.util.Calendar dCreateDate;

    private java.util.Calendar dModifyDate;

    public EntityResAssign() {
    }

    public EntityResAssign(
           String sOrderID,
           String sRoomTypeID,
           java.util.Calendar dArrDate,
           java.util.Calendar dDepDate,
           String sHotelID,
           String sRoomNo,
           boolean bIsCheckIn,
           String sReceiveID,
           String sOperatorID,
           java.util.Calendar dCreateDate,
           java.util.Calendar dModifyDate) {
           this.sOrderID = sOrderID;
           this.sRoomTypeID = sRoomTypeID;
           this.dArrDate = dArrDate;
           this.dDepDate = dDepDate;
           this.sHotelID = sHotelID;
           this.sRoomNo = sRoomNo;
           this.bIsCheckIn = bIsCheckIn;
           this.sReceiveID = sReceiveID;
           this.sOperatorID = sOperatorID;
           this.dCreateDate = dCreateDate;
           this.dModifyDate = dModifyDate;
    }


    /**
     * Gets the sOrderID value for this EntityResAssign.
     *
     * @return sOrderID
     */
    public String getSOrderID() {
        return sOrderID;
    }


    /**
     * Sets the sOrderID value for this EntityResAssign.
     *
     * @param sOrderID
     */
    public void setSOrderID(String sOrderID) {
        this.sOrderID = sOrderID;
    }


    /**
     * Gets the sRoomTypeID value for this EntityResAssign.
     *
     * @return sRoomTypeID
     */
    public String getSRoomTypeID() {
        return sRoomTypeID;
    }


    /**
     * Sets the sRoomTypeID value for this EntityResAssign.
     *
     * @param sRoomTypeID
     */
    public void setSRoomTypeID(String sRoomTypeID) {
        this.sRoomTypeID = sRoomTypeID;
    }


    /**
     * Gets the dArrDate value for this EntityResAssign.
     *
     * @return dArrDate
     */
    public java.util.Calendar getDArrDate() {
        return dArrDate;
    }


    /**
     * Sets the dArrDate value for this EntityResAssign.
     *
     * @param dArrDate
     */
    public void setDArrDate(java.util.Calendar dArrDate) {
        this.dArrDate = dArrDate;
    }


    /**
     * Gets the dDepDate value for this EntityResAssign.
     *
     * @return dDepDate
     */
    public java.util.Calendar getDDepDate() {
        return dDepDate;
    }


    /**
     * Sets the dDepDate value for this EntityResAssign.
     *
     * @param dDepDate
     */
    public void setDDepDate(java.util.Calendar dDepDate) {
        this.dDepDate = dDepDate;
    }


    /**
     * Gets the sHotelID value for this EntityResAssign.
     *
     * @return sHotelID
     */
    public String getSHotelID() {
        return sHotelID;
    }


    /**
     * Sets the sHotelID value for this EntityResAssign.
     *
     * @param sHotelID
     */
    public void setSHotelID(String sHotelID) {
        this.sHotelID = sHotelID;
    }


    /**
     * Gets the sRoomNo value for this EntityResAssign.
     *
     * @return sRoomNo
     */
    public String getSRoomNo() {
        return sRoomNo;
    }


    /**
     * Sets the sRoomNo value for this EntityResAssign.
     *
     * @param sRoomNo
     */
    public void setSRoomNo(String sRoomNo) {
        this.sRoomNo = sRoomNo;
    }


    /**
     * Gets the bIsCheckIn value for this EntityResAssign.
     *
     * @return bIsCheckIn
     */
    public boolean isBIsCheckIn() {
        return bIsCheckIn;
    }


    /**
     * Sets the bIsCheckIn value for this EntityResAssign.
     *
     * @param bIsCheckIn
     */
    public void setBIsCheckIn(boolean bIsCheckIn) {
        this.bIsCheckIn = bIsCheckIn;
    }


    /**
     * Gets the sReceiveID value for this EntityResAssign.
     *
     * @return sReceiveID
     */
    public String getSReceiveID() {
        return sReceiveID;
    }


    /**
     * Sets the sReceiveID value for this EntityResAssign.
     *
     * @param sReceiveID
     */
    public void setSReceiveID(String sReceiveID) {
        this.sReceiveID = sReceiveID;
    }


    /**
     * Gets the sOperatorID value for this EntityResAssign.
     *
     * @return sOperatorID
     */
    public String getSOperatorID() {
        return sOperatorID;
    }


    /**
     * Sets the sOperatorID value for this EntityResAssign.
     *
     * @param sOperatorID
     */
    public void setSOperatorID(String sOperatorID) {
        this.sOperatorID = sOperatorID;
    }


    /**
     * Gets the dCreateDate value for this EntityResAssign.
     *
     * @return dCreateDate
     */
    public java.util.Calendar getDCreateDate() {
        return dCreateDate;
    }


    /**
     * Sets the dCreateDate value for this EntityResAssign.
     *
     * @param dCreateDate
     */
    public void setDCreateDate(java.util.Calendar dCreateDate) {
        this.dCreateDate = dCreateDate;
    }


    /**
     * Gets the dModifyDate value for this EntityResAssign.
     *
     * @return dModifyDate
     */
    public java.util.Calendar getDModifyDate() {
        return dModifyDate;
    }


    /**
     * Sets the dModifyDate value for this EntityResAssign.
     *
     * @param dModifyDate
     */
    public void setDModifyDate(java.util.Calendar dModifyDate) {
        this.dModifyDate = dModifyDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EntityResAssign)) return false;
        EntityResAssign other = (EntityResAssign) obj;
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
            ((this.sHotelID==null && other.getSHotelID()==null) ||
             (this.sHotelID!=null &&
              this.sHotelID.equals(other.getSHotelID()))) &&
            ((this.sRoomNo==null && other.getSRoomNo()==null) ||
             (this.sRoomNo!=null &&
              this.sRoomNo.equals(other.getSRoomNo()))) &&
            this.bIsCheckIn == other.isBIsCheckIn() &&
            ((this.sReceiveID==null && other.getSReceiveID()==null) ||
             (this.sReceiveID!=null &&
              this.sReceiveID.equals(other.getSReceiveID()))) &&
            ((this.sOperatorID==null && other.getSOperatorID()==null) ||
             (this.sOperatorID!=null &&
              this.sOperatorID.equals(other.getSOperatorID()))) &&
            ((this.dCreateDate==null && other.getDCreateDate()==null) ||
             (this.dCreateDate!=null &&
              this.dCreateDate.equals(other.getDCreateDate()))) &&
            ((this.dModifyDate==null && other.getDModifyDate()==null) ||
             (this.dModifyDate!=null &&
              this.dModifyDate.equals(other.getDModifyDate())));
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
        if (getSHotelID() != null) {
            _hashCode += getSHotelID().hashCode();
        }
        if (getSRoomNo() != null) {
            _hashCode += getSRoomNo().hashCode();
        }
        _hashCode += (isBIsCheckIn() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSReceiveID() != null) {
            _hashCode += getSReceiveID().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntityResAssign.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResAssign"));
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
        elemField.setFieldName("SHotelID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sHotelID"));
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
        elemField.setFieldName("BIsCheckIn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsCheckIn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SReceiveID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sReceiveID"));
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
