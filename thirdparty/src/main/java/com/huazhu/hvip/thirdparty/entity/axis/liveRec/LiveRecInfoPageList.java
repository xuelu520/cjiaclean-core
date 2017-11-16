/**
 * LiveRecInfoPageList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.liveRec;

public class LiveRecInfoPageList  extends Total  implements java.io.Serializable {
    private LiveRecInfo[] lLiveRecInfo;

    public LiveRecInfoPageList() {
    }

    public LiveRecInfoPageList(
           int total,
           LiveRecInfo[] lLiveRecInfo) {
        super(
            total);
        this.lLiveRecInfo = lLiveRecInfo;
    }


    /**
     * Gets the lLiveRecInfo value for this LiveRecInfoPageList.
     * 
     * @return lLiveRecInfo
     */
    public LiveRecInfo[] getLLiveRecInfo() {
        return lLiveRecInfo;
    }


    /**
     * Sets the lLiveRecInfo value for this LiveRecInfoPageList.
     * 
     * @param lLiveRecInfo
     */
    public void setLLiveRecInfo(LiveRecInfo[] lLiveRecInfo) {
        this.lLiveRecInfo = lLiveRecInfo;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof LiveRecInfoPageList)) return false;
        LiveRecInfoPageList other = (LiveRecInfoPageList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.lLiveRecInfo==null && other.getLLiveRecInfo()==null) || 
             (this.lLiveRecInfo!=null &&
              java.util.Arrays.equals(this.lLiveRecInfo, other.getLLiveRecInfo())));
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
        if (getLLiveRecInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLLiveRecInfo());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getLLiveRecInfo(), i);
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
        new org.apache.axis.description.TypeDesc(LiveRecInfoPageList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "LiveRecInfoPageList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LLiveRecInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "lLiveRecInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "LiveRecInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "LiveRecInfo"));
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
