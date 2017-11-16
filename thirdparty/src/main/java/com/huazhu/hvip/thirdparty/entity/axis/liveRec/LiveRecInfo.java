/**
 * LiveRecInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.liveRec;

public class LiveRecInfo  implements java.io.Serializable {
    private String sReceiveID;

    private String sHotelID;

    private String sHotelName;

    private String sRoomNo;

    private String sBillID;

    private String sCusName;

    private String sMobile;

    private String sBookerID;

    private java.util.Calendar dCheckinDate;

    private java.util.Calendar dEstDepDate;

    public LiveRecInfo() {
    }

    public LiveRecInfo(
           String sReceiveID,
           String sHotelID,
           String sHotelName,
           String sRoomNo,
           String sBillID,
           String sCusName,
           String sMobile,
           String sBookerID,
           java.util.Calendar dCheckinDate,
           java.util.Calendar dEstDepDate) {
           this.sReceiveID = sReceiveID;
           this.sHotelID = sHotelID;
           this.sHotelName = sHotelName;
           this.sRoomNo = sRoomNo;
           this.sBillID = sBillID;
           this.sCusName = sCusName;
           this.sMobile = sMobile;
           this.sBookerID = sBookerID;
           this.dCheckinDate = dCheckinDate;
           this.dEstDepDate = dEstDepDate;
    }


    /**
     * Gets the sReceiveID value for this LiveRecInfo.
     * 
     * @return sReceiveID
     */
    public String getSReceiveID() {
        return sReceiveID;
    }


    /**
     * Sets the sReceiveID value for this LiveRecInfo.
     * 
     * @param sReceiveID
     */
    public void setSReceiveID(String sReceiveID) {
        this.sReceiveID = sReceiveID;
    }


    /**
     * Gets the sHotelID value for this LiveRecInfo.
     * 
     * @return sHotelID
     */
    public String getSHotelID() {
        return sHotelID;
    }


    /**
     * Sets the sHotelID value for this LiveRecInfo.
     * 
     * @param sHotelID
     */
    public void setSHotelID(String sHotelID) {
        this.sHotelID = sHotelID;
    }


    /**
     * Gets the sHotelName value for this LiveRecInfo.
     * 
     * @return sHotelName
     */
    public String getSHotelName() {
        return sHotelName;
    }


    /**
     * Sets the sHotelName value for this LiveRecInfo.
     * 
     * @param sHotelName
     */
    public void setSHotelName(String sHotelName) {
        this.sHotelName = sHotelName;
    }


    /**
     * Gets the sRoomNo value for this LiveRecInfo.
     * 
     * @return sRoomNo
     */
    public String getSRoomNo() {
        return sRoomNo;
    }


    /**
     * Sets the sRoomNo value for this LiveRecInfo.
     * 
     * @param sRoomNo
     */
    public void setSRoomNo(String sRoomNo) {
        this.sRoomNo = sRoomNo;
    }


    /**
     * Gets the sBillID value for this LiveRecInfo.
     * 
     * @return sBillID
     */
    public String getSBillID() {
        return sBillID;
    }


    /**
     * Sets the sBillID value for this LiveRecInfo.
     * 
     * @param sBillID
     */
    public void setSBillID(String sBillID) {
        this.sBillID = sBillID;
    }


    /**
     * Gets the sCusName value for this LiveRecInfo.
     * 
     * @return sCusName
     */
    public String getSCusName() {
        return sCusName;
    }


    /**
     * Sets the sCusName value for this LiveRecInfo.
     * 
     * @param sCusName
     */
    public void setSCusName(String sCusName) {
        this.sCusName = sCusName;
    }


    /**
     * Gets the sMobile value for this LiveRecInfo.
     * 
     * @return sMobile
     */
    public String getSMobile() {
        return sMobile;
    }


    /**
     * Sets the sMobile value for this LiveRecInfo.
     * 
     * @param sMobile
     */
    public void setSMobile(String sMobile) {
        this.sMobile = sMobile;
    }


    /**
     * Gets the sBookerID value for this LiveRecInfo.
     * 
     * @return sBookerID
     */
    public String getSBookerID() {
        return sBookerID;
    }


    /**
     * Sets the sBookerID value for this LiveRecInfo.
     * 
     * @param sBookerID
     */
    public void setSBookerID(String sBookerID) {
        this.sBookerID = sBookerID;
    }


    /**
     * Gets the dCheckinDate value for this LiveRecInfo.
     * 
     * @return dCheckinDate
     */
    public java.util.Calendar getDCheckinDate() {
        return dCheckinDate;
    }


    /**
     * Sets the dCheckinDate value for this LiveRecInfo.
     * 
     * @param dCheckinDate
     */
    public void setDCheckinDate(java.util.Calendar dCheckinDate) {
        this.dCheckinDate = dCheckinDate;
    }


    /**
     * Gets the dEstDepDate value for this LiveRecInfo.
     * 
     * @return dEstDepDate
     */
    public java.util.Calendar getDEstDepDate() {
        return dEstDepDate;
    }


    /**
     * Sets the dEstDepDate value for this LiveRecInfo.
     * 
     * @param dEstDepDate
     */
    public void setDEstDepDate(java.util.Calendar dEstDepDate) {
        this.dEstDepDate = dEstDepDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof LiveRecInfo)) return false;
        LiveRecInfo other = (LiveRecInfo) obj;
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
            ((this.sHotelID==null && other.getSHotelID()==null) || 
             (this.sHotelID!=null &&
              this.sHotelID.equals(other.getSHotelID()))) &&
            ((this.sHotelName==null && other.getSHotelName()==null) || 
             (this.sHotelName!=null &&
              this.sHotelName.equals(other.getSHotelName()))) &&
            ((this.sRoomNo==null && other.getSRoomNo()==null) || 
             (this.sRoomNo!=null &&
              this.sRoomNo.equals(other.getSRoomNo()))) &&
            ((this.sBillID==null && other.getSBillID()==null) || 
             (this.sBillID!=null &&
              this.sBillID.equals(other.getSBillID()))) &&
            ((this.sCusName==null && other.getSCusName()==null) || 
             (this.sCusName!=null &&
              this.sCusName.equals(other.getSCusName()))) &&
            ((this.sMobile==null && other.getSMobile()==null) || 
             (this.sMobile!=null &&
              this.sMobile.equals(other.getSMobile()))) &&
            ((this.sBookerID==null && other.getSBookerID()==null) || 
             (this.sBookerID!=null &&
              this.sBookerID.equals(other.getSBookerID()))) &&
            ((this.dCheckinDate==null && other.getDCheckinDate()==null) || 
             (this.dCheckinDate!=null &&
              this.dCheckinDate.equals(other.getDCheckinDate()))) &&
            ((this.dEstDepDate==null && other.getDEstDepDate()==null) || 
             (this.dEstDepDate!=null &&
              this.dEstDepDate.equals(other.getDEstDepDate())));
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
        if (getSHotelID() != null) {
            _hashCode += getSHotelID().hashCode();
        }
        if (getSHotelName() != null) {
            _hashCode += getSHotelName().hashCode();
        }
        if (getSRoomNo() != null) {
            _hashCode += getSRoomNo().hashCode();
        }
        if (getSBillID() != null) {
            _hashCode += getSBillID().hashCode();
        }
        if (getSCusName() != null) {
            _hashCode += getSCusName().hashCode();
        }
        if (getSMobile() != null) {
            _hashCode += getSMobile().hashCode();
        }
        if (getSBookerID() != null) {
            _hashCode += getSBookerID().hashCode();
        }
        if (getDCheckinDate() != null) {
            _hashCode += getDCheckinDate().hashCode();
        }
        if (getDEstDepDate() != null) {
            _hashCode += getDEstDepDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LiveRecInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "LiveRecInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SReceiveID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sReceiveID"));
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
        elemField.setFieldName("SHotelName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sHotelName"));
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
        elemField.setFieldName("SBillID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sBillID"));
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
        elemField.setFieldName("SMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "sMobile"));
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
        elemField.setFieldName("DCheckinDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dCheckinDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DEstDepDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "dEstDepDate"));
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
