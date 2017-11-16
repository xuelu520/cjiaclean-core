/**
 * QueryBase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public class QueryBase  implements java.io.Serializable {
    private int pageSize;

    private int pageIndex;

    private com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortType sortType;

    private com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortField sortField;

    private String operator;

    public QueryBase() {
    }

    public QueryBase(
           int pageSize,
           int pageIndex,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortType sortType,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortField sortField,
           String operator) {
           this.pageSize = pageSize;
           this.pageIndex = pageIndex;
           this.sortType = sortType;
           this.sortField = sortField;
           this.operator = operator;
    }


    /**
     * Gets the pageSize value for this QueryBase.
     *
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this QueryBase.
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the pageIndex value for this QueryBase.
     *
     * @return pageIndex
     */
    public int getPageIndex() {
        return pageIndex;
    }


    /**
     * Sets the pageIndex value for this QueryBase.
     *
     * @param pageIndex
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }


    /**
     * Gets the sortType value for this QueryBase.
     *
     * @return sortType
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortType getSortType() {
        return sortType;
    }


    /**
     * Sets the sortType value for this QueryBase.
     *
     * @param sortType
     */
    public void setSortType(com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortType sortType) {
        this.sortType = sortType;
    }


    /**
     * Gets the sortField value for this QueryBase.
     *
     * @return sortField
     */
    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortField getSortField() {
        return sortField;
    }


    /**
     * Sets the sortField value for this QueryBase.
     *
     * @param sortField
     */
    public void setSortField(com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortField sortField) {
        this.sortField = sortField;
    }


    /**
     * Gets the operator value for this QueryBase.
     *
     * @return operator
     */
    public String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this QueryBase.
     *
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof QueryBase)) return false;
        QueryBase other = (QueryBase) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.pageSize == other.getPageSize() &&
            this.pageIndex == other.getPageIndex() &&
            ((this.sortType==null && other.getSortType()==null) ||
             (this.sortType!=null &&
              this.sortType.equals(other.getSortType()))) &&
            ((this.sortField==null && other.getSortField()==null) ||
             (this.sortField!=null &&
              this.sortField.equals(other.getSortField()))) &&
            ((this.operator==null && other.getOperator()==null) ||
             (this.operator!=null &&
              this.operator.equals(other.getOperator())));
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
        _hashCode += getPageSize();
        _hashCode += getPageIndex();
        if (getSortType() != null) {
            _hashCode += getSortType().hashCode();
        }
        if (getSortField() != null) {
            _hashCode += getSortField().hashCode();
        }
        if (getOperator() != null) {
            _hashCode += getOperator().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryBase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryBase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "PageSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageIndex");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "PageIndex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "SortType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EnumSortType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortField");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "SortField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EnumSortField"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "Operator"));
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
