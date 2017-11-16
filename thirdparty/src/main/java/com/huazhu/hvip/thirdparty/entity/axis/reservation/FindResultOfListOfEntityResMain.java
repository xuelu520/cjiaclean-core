/**
 * FindResultOfListOfEntityResMain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public class FindResultOfListOfEntityResMain  extends com.huazhu.hvip.thirdparty.entity.axis.reservation.Result  implements java.io.Serializable {
    private com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[] target;

    private String count;

    public FindResultOfListOfEntityResMain() {
    }

    public FindResultOfListOfEntityResMain(
           com.huazhu.hvip.thirdparty.entity.axis.reservation.StausCode stausCode,
           Integer reason,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[] target,
           String count) {
        super(
            stausCode,
            reason);
        this.target = target;
        this.count = count;
    }


    /**
     * Gets the target value for this FindResultOfListOfEntityResMain.
     *
     * @return target
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[] getTarget() {
        return target;
    }


    /**
     * Sets the target value for this FindResultOfListOfEntityResMain.
     *
     * @param target
     */
    public void setTarget(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[] target) {
        this.target = target;
    }


    /**
     * Gets the count value for this FindResultOfListOfEntityResMain.
     *
     * @return count
     */
    public String getCount() {
        return count;
    }


    /**
     * Sets the count value for this FindResultOfListOfEntityResMain.
     *
     * @param count
     */
    public void setCount(String count) {
        this.count = count;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof FindResultOfListOfEntityResMain)) return false;
        FindResultOfListOfEntityResMain other = (FindResultOfListOfEntityResMain) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.target==null && other.getTarget()==null) ||
             (this.target!=null &&
              java.util.Arrays.equals(this.target, other.getTarget()))) &&
            ((this.count==null && other.getCount()==null) ||
             (this.count!=null &&
              this.count.equals(other.getCount())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getTarget() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTarget());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getTarget(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCount() != null) {
            _hashCode += getCount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FindResultOfListOfEntityResMain.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "FindResultOfListOfEntityResMain"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("target");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "Target"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("count");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "Count"));
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
