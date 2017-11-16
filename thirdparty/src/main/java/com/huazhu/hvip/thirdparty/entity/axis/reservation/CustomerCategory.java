/**
 * CustomerCategory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public abstract class CustomerCategory  implements java.io.Serializable {
    private String categoryStr;

    private String levelId;

    public CustomerCategory() {
    }

    public CustomerCategory(
           String categoryStr,
           String levelId) {
           this.categoryStr = categoryStr;
           this.levelId = levelId;
    }


    /**
     * Gets the categoryStr value for this CustomerCategory.
     *
     * @return categoryStr
     */
    public String getCategoryStr() {
        return categoryStr;
    }


    /**
     * Sets the categoryStr value for this CustomerCategory.
     *
     * @param categoryStr
     */
    public void setCategoryStr(String categoryStr) {
        this.categoryStr = categoryStr;
    }


    /**
     * Gets the levelId value for this CustomerCategory.
     *
     * @return levelId
     */
    public String getLevelId() {
        return levelId;
    }


    /**
     * Sets the levelId value for this CustomerCategory.
     *
     * @param levelId
     */
    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CustomerCategory)) return false;
        CustomerCategory other = (CustomerCategory) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.categoryStr==null && other.getCategoryStr()==null) ||
             (this.categoryStr!=null &&
              this.categoryStr.equals(other.getCategoryStr()))) &&
            ((this.levelId==null && other.getLevelId()==null) ||
             (this.levelId!=null &&
              this.levelId.equals(other.getLevelId())));
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
        if (getCategoryStr() != null) {
            _hashCode += getCategoryStr().hashCode();
        }
        if (getLevelId() != null) {
            _hashCode += getLevelId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerCategory.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "CustomerCategory"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoryStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "CategoryStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("levelId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "LevelId"));
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
