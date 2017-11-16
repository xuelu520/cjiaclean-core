/**
 * EntityResMainQuery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public class EntityResMainQuery  extends com.huazhu.hvip.thirdparty.entity.axis.reservation.QueryBase  implements java.io.Serializable {
    private boolean isHis;

    private java.util.Calendar beginTime;

    private java.util.Calendar endTime;

    private String[] orderSrc;

    private String[] curCategoryID;

    private String[] rcpType;

    private String[] orderStatus;

    private String bookerId;

    private String orderId;

    private String orderSeqNo;

    private String hotelId;

    private java.util.Calendar checkInDate;

    private java.util.Calendar depDate;

    public EntityResMainQuery() {
    }

    public EntityResMainQuery(
           int pageSize,
           int pageIndex,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortType sortType,
           com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortField sortField,
           String operator,
           boolean isHis,
           java.util.Calendar beginTime,
           java.util.Calendar endTime,
           String[] orderSrc,
           String[] curCategoryID,
           String[] rcpType,
           String[] orderStatus,
           String bookerId,
           String orderId,
           String orderSeqNo,
           String hotelId,
           java.util.Calendar checkInDate,
           java.util.Calendar depDate) {
        super(
            pageSize,
            pageIndex,
            sortType,
            sortField,
            operator);
        this.isHis = isHis;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.orderSrc = orderSrc;
        this.curCategoryID = curCategoryID;
        this.rcpType = rcpType;
        this.orderStatus = orderStatus;
        this.bookerId = bookerId;
        this.orderId = orderId;
        this.orderSeqNo = orderSeqNo;
        this.hotelId = hotelId;
        this.checkInDate = checkInDate;
        this.depDate = depDate;
    }


    /**
     * Gets the isHis value for this EntityResMainQuery.
     *
     * @return isHis
     */
    public boolean isIsHis() {
        return isHis;
    }


    /**
     * Sets the isHis value for this EntityResMainQuery.
     *
     * @param isHis
     */
    public void setIsHis(boolean isHis) {
        this.isHis = isHis;
    }


    /**
     * Gets the beginTime value for this EntityResMainQuery.
     *
     * @return beginTime
     */
    public java.util.Calendar getBeginTime() {
        return beginTime;
    }


    /**
     * Sets the beginTime value for this EntityResMainQuery.
     *
     * @param beginTime
     */
    public void setBeginTime(java.util.Calendar beginTime) {
        this.beginTime = beginTime;
    }


    /**
     * Gets the endTime value for this EntityResMainQuery.
     *
     * @return endTime
     */
    public java.util.Calendar getEndTime() {
        return endTime;
    }


    /**
     * Sets the endTime value for this EntityResMainQuery.
     *
     * @param endTime
     */
    public void setEndTime(java.util.Calendar endTime) {
        this.endTime = endTime;
    }


    /**
     * Gets the orderSrc value for this EntityResMainQuery.
     *
     * @return orderSrc
     */
    public String[] getOrderSrc() {
        return orderSrc;
    }


    /**
     * Sets the orderSrc value for this EntityResMainQuery.
     *
     * @param orderSrc
     */
    public void setOrderSrc(String[] orderSrc) {
        this.orderSrc = orderSrc;
    }


    /**
     * Gets the curCategoryID value for this EntityResMainQuery.
     *
     * @return curCategoryID
     */
    public String[] getCurCategoryID() {
        return curCategoryID;
    }


    /**
     * Sets the curCategoryID value for this EntityResMainQuery.
     *
     * @param curCategoryID
     */
    public void setCurCategoryID(String[] curCategoryID) {
        this.curCategoryID = curCategoryID;
    }


    /**
     * Gets the rcpType value for this EntityResMainQuery.
     *
     * @return rcpType
     */
    public String[] getRcpType() {
        return rcpType;
    }


    /**
     * Sets the rcpType value for this EntityResMainQuery.
     *
     * @param rcpType
     */
    public void setRcpType(String[] rcpType) {
        this.rcpType = rcpType;
    }


    /**
     * Gets the orderStatus value for this EntityResMainQuery.
     *
     * @return orderStatus
     */
    public String[] getOrderStatus() {
        return orderStatus;
    }


    /**
     * Sets the orderStatus value for this EntityResMainQuery.
     *
     * @param orderStatus
     */
    public void setOrderStatus(String[] orderStatus) {
        this.orderStatus = orderStatus;
    }


    /**
     * Gets the bookerId value for this EntityResMainQuery.
     *
     * @return bookerId
     */
    public String getBookerId() {
        return bookerId;
    }


    /**
     * Sets the bookerId value for this EntityResMainQuery.
     *
     * @param bookerId
     */
    public void setBookerId(String bookerId) {
        this.bookerId = bookerId;
    }


    /**
     * Gets the orderId value for this EntityResMainQuery.
     *
     * @return orderId
     */
    public String getOrderId() {
        return orderId;
    }


    /**
     * Sets the orderId value for this EntityResMainQuery.
     *
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    /**
     * Gets the orderSeqNo value for this EntityResMainQuery.
     *
     * @return orderSeqNo
     */
    public String getOrderSeqNo() {
        return orderSeqNo;
    }


    /**
     * Sets the orderSeqNo value for this EntityResMainQuery.
     *
     * @param orderSeqNo
     */
    public void setOrderSeqNo(String orderSeqNo) {
        this.orderSeqNo = orderSeqNo;
    }


    /**
     * Gets the hotelId value for this EntityResMainQuery.
     *
     * @return hotelId
     */
    public String getHotelId() {
        return hotelId;
    }


    /**
     * Sets the hotelId value for this EntityResMainQuery.
     *
     * @param hotelId
     */
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }


    /**
     * Gets the checkInDate value for this EntityResMainQuery.
     *
     * @return checkInDate
     */
    public java.util.Calendar getCheckInDate() {
        return checkInDate;
    }


    /**
     * Sets the checkInDate value for this EntityResMainQuery.
     *
     * @param checkInDate
     */
    public void setCheckInDate(java.util.Calendar checkInDate) {
        this.checkInDate = checkInDate;
    }


    /**
     * Gets the depDate value for this EntityResMainQuery.
     *
     * @return depDate
     */
    public java.util.Calendar getDepDate() {
        return depDate;
    }


    /**
     * Sets the depDate value for this EntityResMainQuery.
     *
     * @param depDate
     */
    public void setDepDate(java.util.Calendar depDate) {
        this.depDate = depDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EntityResMainQuery)) return false;
        EntityResMainQuery other = (EntityResMainQuery) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            this.isHis == other.isIsHis() &&
            ((this.beginTime==null && other.getBeginTime()==null) ||
             (this.beginTime!=null &&
              this.beginTime.equals(other.getBeginTime()))) &&
            ((this.endTime==null && other.getEndTime()==null) ||
             (this.endTime!=null &&
              this.endTime.equals(other.getEndTime()))) &&
            ((this.orderSrc==null && other.getOrderSrc()==null) ||
             (this.orderSrc!=null &&
              java.util.Arrays.equals(this.orderSrc, other.getOrderSrc()))) &&
            ((this.curCategoryID==null && other.getCurCategoryID()==null) ||
             (this.curCategoryID!=null &&
              java.util.Arrays.equals(this.curCategoryID, other.getCurCategoryID()))) &&
            ((this.rcpType==null && other.getRcpType()==null) ||
             (this.rcpType!=null &&
              java.util.Arrays.equals(this.rcpType, other.getRcpType()))) &&
            ((this.orderStatus==null && other.getOrderStatus()==null) ||
             (this.orderStatus!=null &&
              java.util.Arrays.equals(this.orderStatus, other.getOrderStatus()))) &&
            ((this.bookerId==null && other.getBookerId()==null) ||
             (this.bookerId!=null &&
              this.bookerId.equals(other.getBookerId()))) &&
            ((this.orderId==null && other.getOrderId()==null) ||
             (this.orderId!=null &&
              this.orderId.equals(other.getOrderId()))) &&
            ((this.orderSeqNo==null && other.getOrderSeqNo()==null) ||
             (this.orderSeqNo!=null &&
              this.orderSeqNo.equals(other.getOrderSeqNo()))) &&
            ((this.hotelId==null && other.getHotelId()==null) ||
             (this.hotelId!=null &&
              this.hotelId.equals(other.getHotelId()))) &&
            ((this.checkInDate==null && other.getCheckInDate()==null) ||
             (this.checkInDate!=null &&
              this.checkInDate.equals(other.getCheckInDate()))) &&
            ((this.depDate==null && other.getDepDate()==null) ||
             (this.depDate!=null &&
              this.depDate.equals(other.getDepDate())));
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
        _hashCode += (isIsHis() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getBeginTime() != null) {
            _hashCode += getBeginTime().hashCode();
        }
        if (getEndTime() != null) {
            _hashCode += getEndTime().hashCode();
        }
        if (getOrderSrc() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrderSrc());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getOrderSrc(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCurCategoryID() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCurCategoryID());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getCurCategoryID(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRcpType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRcpType());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getRcpType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrderStatus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrderStatus());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getOrderStatus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBookerId() != null) {
            _hashCode += getBookerId().hashCode();
        }
        if (getOrderId() != null) {
            _hashCode += getOrderId().hashCode();
        }
        if (getOrderSeqNo() != null) {
            _hashCode += getOrderSeqNo().hashCode();
        }
        if (getHotelId() != null) {
            _hashCode += getHotelId().hashCode();
        }
        if (getCheckInDate() != null) {
            _hashCode += getCheckInDate().hashCode();
        }
        if (getDepDate() != null) {
            _hashCode += getDepDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntityResMainQuery.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMainQuery"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isHis");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "IsHis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beginTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "BeginTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "EndTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderSrc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "OrderSrc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curCategoryID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "CurCategoryID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rcpType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "RcpType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "OrderStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "BookerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "OrderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderSeqNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "OrderSeqNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hotelId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "HotelId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkInDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "CheckInDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.huazhu.com/", "DepDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
