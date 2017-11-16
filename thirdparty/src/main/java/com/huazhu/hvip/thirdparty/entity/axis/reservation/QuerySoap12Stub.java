/**
 * QuerySoap12Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.reservation;

public class QuerySoap12Stub extends org.apache.axis.client.Stub implements com.huazhu.hvip.thirdparty.entity.axis.reservation.QuerySoap_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("QueryWithHistoryRecordsOptionAndPageOrderOption");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.huazhu.com/", "query"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMainQuery"), com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.huazhu.com/", "ArrayOfEntityResMain"));
        oper.setReturnClass(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryWithHistoryRecordsOptionAndPageOrderOptionResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("QueryWithHistoryRecordsOptionAndPageOption");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.huazhu.com/", "query"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMainQuery"), com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.huazhu.com/", "ArrayOfEntityResMain"));
        oper.setReturnClass(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryWithHistoryRecordsOptionAndPageOptionResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("QuerySingleRecord");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.huazhu.com/", "orderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain"));
        oper.setReturnClass(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QuerySingleRecordResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("QueryResByThirdOrderNo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.huazhu.com/", "thirdOrderNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain"));
        oper.setReturnClass(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryResByThirdOrderNoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("QueryReservationByParam");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.huazhu.com/", "query"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMainQuery"), com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.huazhu.com/", "FindResultOfListOfEntityResMain"));
        oper.setReturnClass(com.huazhu.hvip.thirdparty.entity.axis.reservation.FindResultOfListOfEntityResMain.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryReservationByParamResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

    }

    public QuerySoap12Stub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public QuerySoap12Stub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public QuerySoap12Stub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "ArrayOfEntityResAssign");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResAssign[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResAssign");
            qName2 = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResAssign");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "ArrayOfEntityResDetail");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetail[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetail");
            qName2 = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetail");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "ArrayOfEntityResDetailPrice");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetailPrice[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetailPrice");
            qName2 = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetailPrice");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "ArrayOfEntityResMain");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain");
            qName2 = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://www.huazhu.com/", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "CustomerCategory");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.CustomerCategory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResAssign");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResAssign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetail");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResDetailPrice");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResDetailPrice.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMain");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EntityResMainQuery");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EnumSortField");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortField.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "EnumSortType");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.EnumSortType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "FindResultOfListOfEntityResMain");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.FindResultOfListOfEntityResMain.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryBase");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.QueryBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "Result");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "SheetGuest");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.SheetGuest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.huazhu.com/", "StausCode");
            cachedSerQNames.add(qName);
            cls = com.huazhu.hvip.thirdparty.entity.axis.reservation.StausCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[] queryWithHistoryRecordsOptionAndPageOrderOption(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery query) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.huazhu.com/QueryWithHistoryRecordsOptionAndPageOrderOption");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryWithHistoryRecordsOptionAndPageOrderOption"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {query});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[]) _resp;
            } catch (Exception _exception) {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[] queryWithHistoryRecordsOptionAndPageOption(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery query) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.huazhu.com/QueryWithHistoryRecordsOptionAndPageOption");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryWithHistoryRecordsOptionAndPageOption"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {query});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[]) _resp;
            } catch (Exception _exception) {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain querySingleRecord(String orderId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.huazhu.com/QuerySingleRecord");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QuerySingleRecord"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain) _resp;
            } catch (Exception _exception) {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain) org.apache.axis.utils.JavaUtils.convert(_resp, com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain queryResByThirdOrderNo(String thirdOrderNo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.huazhu.com/QueryResByThirdOrderNo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryResByThirdOrderNo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {thirdOrderNo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain) _resp;
            } catch (Exception _exception) {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain) org.apache.axis.utils.JavaUtils.convert(_resp, com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.huazhu.hvip.thirdparty.entity.axis.reservation.FindResultOfListOfEntityResMain queryReservationByParam(com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMainQuery query) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.huazhu.com/QueryReservationByParam");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.huazhu.com/", "QueryReservationByParam"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {query});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.FindResultOfListOfEntityResMain) _resp;
            } catch (Exception _exception) {
                return (com.huazhu.hvip.thirdparty.entity.axis.reservation.FindResultOfListOfEntityResMain) org.apache.axis.utils.JavaUtils.convert(_resp, com.huazhu.hvip.thirdparty.entity.axis.reservation.FindResultOfListOfEntityResMain.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
