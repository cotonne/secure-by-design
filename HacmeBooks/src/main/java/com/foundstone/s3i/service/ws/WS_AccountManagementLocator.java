/**
 * WS_AccountManagementLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.foundstone.s3i.service.ws;

public class WS_AccountManagementLocator extends org.apache.axis.client.Service implements com.foundstone.s3i.service.ws.WS_AccountManagement {

    public WS_AccountManagementLocator() {
    }


    public WS_AccountManagementLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WS_AccountManagementLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WS_AccountManagementSoap12
    private java.lang.String WS_AccountManagementSoap12_address = "http://localhost:15583/HacmeBank_v2_WS/WebServices/AccountManagement.asmx";

    public java.lang.String getWS_AccountManagementSoap12Address() {
        return WS_AccountManagementSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_AccountManagementSoap12WSDDServiceName = "WS_AccountManagementSoap12";

    public java.lang.String getWS_AccountManagementSoap12WSDDServiceName() {
        return WS_AccountManagementSoap12WSDDServiceName;
    }

    public void setWS_AccountManagementSoap12WSDDServiceName(java.lang.String name) {
        WS_AccountManagementSoap12WSDDServiceName = name;
    }

    public com.foundstone.s3i.service.ws.WS_AccountManagementSoap getWS_AccountManagementSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_AccountManagementSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_AccountManagementSoap12(endpoint);
    }

    public com.foundstone.s3i.service.ws.WS_AccountManagementSoap getWS_AccountManagementSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.foundstone.s3i.service.ws.WS_AccountManagementSoap12Stub _stub = new com.foundstone.s3i.service.ws.WS_AccountManagementSoap12Stub(portAddress, this);
            _stub.setPortName(getWS_AccountManagementSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_AccountManagementSoap12EndpointAddress(java.lang.String address) {
        WS_AccountManagementSoap12_address = address;
    }


    // Use to get a proxy class for WS_AccountManagementSoap
    private java.lang.String WS_AccountManagementSoap_address = "http://localhost:15583/HacmeBank_v2_WS/WebServices/AccountManagement.asmx";

    public java.lang.String getWS_AccountManagementSoapAddress() {
        return WS_AccountManagementSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_AccountManagementSoapWSDDServiceName = "WS_AccountManagementSoap";

    public java.lang.String getWS_AccountManagementSoapWSDDServiceName() {
        return WS_AccountManagementSoapWSDDServiceName;
    }

    public void setWS_AccountManagementSoapWSDDServiceName(java.lang.String name) {
        WS_AccountManagementSoapWSDDServiceName = name;
    }

    public com.foundstone.s3i.service.ws.WS_AccountManagementSoap getWS_AccountManagementSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_AccountManagementSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_AccountManagementSoap(endpoint);
    }

    public com.foundstone.s3i.service.ws.WS_AccountManagementSoap getWS_AccountManagementSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.foundstone.s3i.service.ws.WS_AccountManagementSoapStub _stub = new com.foundstone.s3i.service.ws.WS_AccountManagementSoapStub(portAddress, this);
            _stub.setPortName(getWS_AccountManagementSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_AccountManagementSoapEndpointAddress(java.lang.String address) {
        WS_AccountManagementSoap_address = address;
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
            if (com.foundstone.s3i.service.ws.WS_AccountManagementSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.foundstone.s3i.service.ws.WS_AccountManagementSoap12Stub _stub = new com.foundstone.s3i.service.ws.WS_AccountManagementSoap12Stub(new java.net.URL(WS_AccountManagementSoap12_address), this);
                _stub.setPortName(getWS_AccountManagementSoap12WSDDServiceName());
                return _stub;
            }
            if (com.foundstone.s3i.service.ws.WS_AccountManagementSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.foundstone.s3i.service.ws.WS_AccountManagementSoapStub _stub = new com.foundstone.s3i.service.ws.WS_AccountManagementSoapStub(new java.net.URL(WS_AccountManagementSoap_address), this);
                _stub.setPortName(getWS_AccountManagementSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
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
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WS_AccountManagementSoap12".equals(inputPortName)) {
            return getWS_AccountManagementSoap12();
        }
        else if ("WS_AccountManagementSoap".equals(inputPortName)) {
            return getWS_AccountManagementSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WS_AccountManagement");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_AccountManagementSoap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_AccountManagementSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WS_AccountManagementSoap12".equals(portName)) {
            setWS_AccountManagementSoap12EndpointAddress(address);
        }
        else 
if ("WS_AccountManagementSoap".equals(portName)) {
            setWS_AccountManagementSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
