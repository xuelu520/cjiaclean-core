/**
 * Query.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huazhu.hvip.thirdparty.entity.axis.liveRec;

public interface Query extends javax.xml.rpc.Service {
    public String getquerySoapAddress();

    public QuerySoap_PortType getquerySoap() throws javax.xml.rpc.ServiceException;

    public QuerySoap_PortType getquerySoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public String getquerySoap12Address();

    public QuerySoap_PortType getquerySoap12() throws javax.xml.rpc.ServiceException;

    public QuerySoap_PortType getquerySoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
