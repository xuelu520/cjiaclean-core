/**
 * QueryLocator.java
 * <p/>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.liveRec;

public class QueryLocator extends org.apache.axis.client.Service implements Query {

    public QueryLocator() {
    }


    public QueryLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public QueryLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for querySoap
    private String querySoap_address;;

    public String getquerySoapAddress() {
        return querySoap_address;
    }

    public String setquerySoapAddress(String querySoapAddress) {
        return querySoap_address = querySoapAddress + "reception/query.asmx";
    }

    // The WSDD service name defaults to the port name.
    private String querySoapWSDDServiceName = "querySoap";

    public String getquerySoapWSDDServiceName() {
        return querySoapWSDDServiceName;
    }

    public void setquerySoapWSDDServiceName(String name) {
        querySoapWSDDServiceName = name;
    }

    public QuerySoap_PortType getquerySoap() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(querySoap_address);
        } catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getquerySoap(endpoint);
    }

    public QuerySoap_PortType getquerySoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            QuerySoap_BindingStub _stub = new QuerySoap_BindingStub(portAddress, this);
            _stub.setPortName(getquerySoapWSDDServiceName());
            return _stub;
        } catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setquerySoapEndpointAddress(String address) {
        querySoap_address = address;
    }


    // Use to get a proxy class for querySoap12
    private String querySoap12_address = "http://10.1.249.75:9097/reception/query.asmx";

    public String getquerySoap12Address() {
        return querySoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private String querySoap12WSDDServiceName = "querySoap12";

    public String getquerySoap12WSDDServiceName() {
        return querySoap12WSDDServiceName;
    }

    public void setquerySoap12WSDDServiceName(String name) {
        querySoap12WSDDServiceName = name;
    }

    public QuerySoap_PortType getquerySoap12() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(querySoap12_address);
        } catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getquerySoap12(endpoint);
    }

    public QuerySoap_PortType getquerySoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            QuerySoap12Stub _stub = new QuerySoap12Stub(portAddress, this);
            _stub.setPortName(getquerySoap12WSDDServiceName());
            return _stub;
        } catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setquerySoap12EndpointAddress(String address) {
        querySoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (QuerySoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                QuerySoap_BindingStub _stub = new QuerySoap_BindingStub(new java.net.URL(querySoap_address), this);
                _stub.setPortName(getquerySoapWSDDServiceName());
                return _stub;
            }
            if (QuerySoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                QuerySoap12Stub _stub = new QuerySoap12Stub(new java.net.URL(querySoap12_address), this);
                _stub.setPortName(getquerySoap12WSDDServiceName());
                return _stub;
            }
        } catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("querySoap".equals(inputPortName)) {
            return getquerySoap();
        } else if ("querySoap12".equals(inputPortName)) {
            return getquerySoap12();
        } else {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.huazhu.com/", "query");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.huazhu.com/", "querySoap"));
            ports.add(new javax.xml.namespace.QName("http://www.huazhu.com/", "querySoap12"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

        if ("querySoap".equals(portName)) {
            setquerySoapEndpointAddress(address);
        } else if ("querySoap12".equals(portName)) {
            setquerySoap12EndpointAddress(address);
        } else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
