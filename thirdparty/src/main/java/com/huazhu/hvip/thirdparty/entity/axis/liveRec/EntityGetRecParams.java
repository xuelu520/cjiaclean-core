/**
 * EntityGetRecParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.liveRec;

public class EntityGetRecParams  implements java.io.Serializable {
    private String sHotelID;

    private String sMemMobile;

    private String sIDCard;

    private String sBookerID;

    private String sRoomNo;

    private String sReceiveID;

    private String[] lSrcID;

    private String[] lRecStatusID;

    private String[] lRcpType;

    private Boolean bIsOneself;

    public EntityGetRecParams() {
    }

    public EntityGetRecParams(
           String sHotelID,
           String sMemMobile,
           String sIDCard,
           String sBookerID,
           String sRoomNo,
           String sReceiveID,
           String[] lSrcID,
           String[] lRecStatusID,
           String[] lRcpType,
           Boolean bIsOneself) {
           this.sHotelID = sHotelID;
           this.sMemMobile = sMemMobile;
           this.sIDCard = sIDCard;
           this.sBookerID = sBookerID;
           this.sRoomNo = sRoomNo;
           this.sReceiveID = sReceiveID;
           this.lSrcID = lSrcID;
           this.lRecStatusID = lRecStatusID;
           this.lRcpType = lRcpType;
           this.bIsOneself = bIsOneself;
    }


    /**
     * Gets the sHotelID value for this EntityGetRecParams.
     * 
     * @return sHotelID
     */
    public String getSHotelID() {
        return sHotelID;
    }


    /**
     * Sets the sHotelID value for this EntityGetRecParams.
     * 
     * @param sHotelID
     */
    public void setSHotelID(String sHotelID) {
        this.sHotelID = sHotelID;
    }


    /**
     * Gets the sMemMobile value for this EntityGetRecParams.
     * 
     * @return sMemMobile
     */
    public String getSMemMobile() {
        return sMemMobile;
    }


    /**
     * Sets the sMemMobile value for this EntityGetRecParams.
     * 
     * @param sMemMobile
     */
    public void setSMemMobile(String sMemMobile) {
        this.sMemMobile = sMemMobile;
    }


    /**
     * Gets the sIDCard value for this EntityGetRecParams.
     * 
     * @return sIDCard
     */
    public String getSIDCard() {
        return sIDCard;
    }


    /**
     * Sets the sIDCard value for this EntityGetRecParams.
     * 
     * @param sIDCard
     */
    public void setSIDCard(String sIDCard) {
        this.sIDCard = sIDCard;
    }


    /**
     * Gets the sBookerID value for this EntityGetRecParams.
     * 
     * @return sBookerID
     */
    public String getSBookerID() {
        return sBookerID;
    }


    /**
     * Sets the sBookerID value for this EntityGetRecParams.
     * 
     * @param sBookerID
     */
    public void setSBookerID(String sBookerID) {
        this.sBookerID = sBookerID;
    }


    /**
     * Gets the sRoomNo value for this EntityGetRecParams.
     * 
     * @return sRoomNo
     */
    public String getSRoomNo() {
        return sRoomNo;
    }


    /**
     * Sets the sRoomNo value for this EntityGetRecParams.
     * 
     * @param sRoomNo
     */
    public void setSRoomNo(String sRoomNo) {
        this.sRoomNo = sRoomNo;
    }


    /**
     * Gets the sReceiveID value for this EntityGetRecParams.
     * 
     * @return sReceiveID
     */
    public String getSReceiveID() {
        return sReceiveID;
    }


    /**
     * Sets the sReceiveID value for this EntityGetRecParams.
     * 
     * @param sReceiveID
     */
    public void setSReceiveID(String sReceiveID) {
        this.sReceiveID = sReceiveID;
    }


    /**
     * Gets the lSrcID value for this EntityGetRecParams.
     * 
     * @return lSrcID
     */
    public String[] getLSrcID() {
        return lSrcID;
    }


    /**
     * Sets the lSrcID value for this EntityGetRecParams.
     * 
     * @param lSrcID
     */
    public void setLSrcID(String[] lSrcID) {
        this.lSrcID = lSrcID;
    }


    /**
     * Gets the lRecStatusID value for this EntityGetRecParams.
     * 
     * @return lRecStatusID
     */
    public String[] getLRecStatusID() {
        return lRecStatusID;
    }


    /**
     * Sets the lRecStatusID value for this EntityGetRecParams.
     * 
     * @param lRecStatusID
     */
    public void setLRecStatusID(String[] lRecStatusID) {
        this.lRecStatusID = lRecStatusID;
    }


    /**
     * Gets the lRcpType value for this EntityGetRecParams.
     * 
     * @return lRcpType
     */
    public String[] getLRcpType() {
        return lRcpType;
    }


    /**
     * Sets the lRcpType value for this EntityGetRecParams.
     * 
     * @param lRcpType
     */
    public void setLRcpType(String[] lRcpType) {
        this.lRcpType = lRcpType;
    }


    /**
     * Gets the bIsOneself value for this EntityGetRecParams.
     * 
     * @return bIsOneself
     */
    public Boolean getBIsOneself() {
        return bIsOneself;
    }


    /**
     * Sets the bIsOneself value for this EntityGetRecParams.
     * 
     * @param bIsOneself
     */
    public void setBIsOneself(Boolean bIsOneself) {
        this.bIsOneself = bIsOneself;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EntityGetRecParams)) return false;
        EntityGetRecParams other = (EntityGetRecParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sHotelID==null && other.getSHotelID()==null) || 
             (this.sHotelID!=null &&
              this.sHotelID.equals(other.getSHotelID()))) &&
            ((this.sMemMobile==null && other.getSMemMobile()==null) || 
             (this.sMemMobile!=null &&
              this.sMemMobile.equals(other.getSMemMobile()))) &&
            ((this.sIDCard==null && other.getSIDCard()==null) || 
             (this.sIDCard!=null &&
              this.sIDCard.equals(other.getSIDCard()))) &&
            ((this.sBookerID==null && other.getSBookerID()==null) || 
             (this.sBookerID!=null &&
              this.sBookerID.equals(other.getSBookerID()))) &&
            ((this.sRoomNo==null && other.getSRoomNo()==null) || 
             (this.sRoomNo!=null &&
              this.sRoomNo.equals(other.getSRoomNo()))) &&
            ((this.sReceiveID==null && other.getSReceiveID()==null) || 
             (this.sReceiveID!=null &&
              this.sReceiveID.equals(other.getSReceiveID()))) &&
            ((this.lSrcID==null && other.getLSrcID()==null) || 
             (this.lSrcID!=null &&
              java.util.Arrays.equals(this.lSrcID, other.getLSrcID()))) &&
            ((this.lRecStatusID==null && other.getLRecStatusID()==null) || 
             (this.lRecStatusID!=null &&
              java.util.Arrays.equals(this.lRecStatusID, other.getLRecStatusID()))) &&
            ((this.lRcpType==null && other.getLRcpType()==null) || 
             (this.lRcpType!=null &&
              java.util.Arrays.equals(this.lRcpType, other.getLRcpType()))) &&
            ((this.bIsOneself==null && other.getBIsOneself()==null) || 
             (this.bIsOneself!=null &&
              this.bIsOneself.equals(other.getBIsOneself())));
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
        if (getSHotelID() != null) {
            _hashCode += getSHotelID().hashCode();
        }
        if (getSMemMobile() != null) {
            _hashCode += getSMemMobile().hashCode();
        }
        if (getSIDCard() != null) {
            _hashCode += getSIDCard().hashCode();
        }
        if (getSBookerID() != null) {
            _hashCode += getSBookerID().hashCode();
        }
        if (getSRoomNo() != null) {
            _hashCode += getSRoomNo().hashCode();
        }
        if (getSReceiveID() != null) {
            _hashCode += getSReceiveID().hashCode();
        }
        if (getLSrcID() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLSrcID());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getLSrcID(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLRecStatusID() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLRecStatusID());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getLRecStatusID(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLRcpType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLRcpType());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getLRcpType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBIsOneself() != null) {
            _hashCode += getBIsOneself().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntityGetRecParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityGetRecParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SHotelID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sHotelID"));
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
        elemField.setFieldName("SIDCard");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sIDCard"));
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
        elemField.setFieldName("SRoomNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sRoomNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("LSrcID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "lSrcID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LRecStatusID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "lRecStatusID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LRcpType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "lRcpType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIsOneself");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "bIsOneself"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
