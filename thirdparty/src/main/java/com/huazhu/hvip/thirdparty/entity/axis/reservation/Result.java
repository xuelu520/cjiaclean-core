/**
 * Result.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public class Result  implements java.io.Serializable {
    private com.huazhu.hvip.thirdparty.entity.axis.reservation.StausCode stausCode;

    private Integer reason;

    public Result() {
    }

    public Result(
           com.huazhu.hvip.thirdparty.entity.axis.reservation.StausCode stausCode,
           Integer reason) {
           this.stausCode = stausCode;
           this.reason = reason;
    }


    /**
     * Gets the stausCode value for this Result.
     *
     * @return stausCode
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.StausCode getStausCode() {
        return stausCode;
    }


    /**
     * Sets the stausCode value for this Result.
     *
     * @param stausCode
     */
    public void setStausCode(com.huazhu.hvip.thirdparty.entity.axis.reservation.StausCode stausCode) {
        this.stausCode = stausCode;
    }


    /**
     * Gets the reason value for this Result.
     *
     * @return reason
     */
    public Integer getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this Result.
     *
     * @param reason
     */
    public void setReason(Integer reason) {
        this.reason = reason;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Result)) return false;
        Result other = (Result) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.stausCode==null && other.getStausCode()==null) ||
             (this.stausCode!=null &&
              this.stausCode.equals(other.getStausCode()))) &&
            ((this.reason==null && other.getReason()==null) ||
             (this.reason!=null &&
              this.reason.equals(other.getReason())));
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
        if (getStausCode() != null) {
            _hashCode += getStausCode().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Result.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "Result"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stausCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "StausCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "StausCode"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "Reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
