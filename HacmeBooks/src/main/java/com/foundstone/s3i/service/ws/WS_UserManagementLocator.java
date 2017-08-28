/**
 * WS_UserManagementLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.foundstone.s3i.service.ws;

public class WS_UserManagementLocator extends org.apache.axis.client.Service implements com.foundstone.s3i.service.ws.WS_UserManagement {

    public WS_UserManagementLocator() {
    }


    public WS_UserManagementLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WS_UserManagementLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WS_UserManagementSoap
    private java.lang.String WS_UserManagementSoap_address = "http://localhost:15583/HacmeBank_v2_WS/WebServices/UserManagement.asmx";

    public java.lang.String getWS_UserManagementSoapAddress() {
        return WS_UserManagementSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_UserManagementSoapWSDDServiceName = "WS_UserManagementSoap";

    public java.lang.String getWS_UserManagementSoapWSDDServiceName() {
        return WS_UserManagementSoapWSDDServiceName;
    }

    public void setWS_UserManagementSoapWSDDServiceName(java.lang.String name) {
        WS_UserManagementSoapWSDDServiceName = name;
    }

    public com.foundstone.s3i.service.ws.WS_UserManagementSoap getWS_UserManagementSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_UserManagementSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_UserManagementSoap(endpoint);
    }

    public com.foundstone.s3i.service.ws.WS_UserManagementSoap getWS_UserManagementSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.foundstone.s3i.service.ws.WS_UserManagementSoapStub _stub = new com.foundstone.s3i.service.ws.WS_UserManagementSoapStub(portAddress, this);
            _stub.setPortName(getWS_UserManagementSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_UserManagementSoapEndpointAddress(java.lang.String address) {
        WS_UserManagementSoap_address = address;
    }


    // Use to get a proxy class for WS_UserManagementSoap12
    private java.lang.String WS_UserManagementSoap12_address = "http://localhost:15583/HacmeBank_v2_WS/WebServices/UserManagement.asmx";

    public java.lang.String getWS_UserManagementSoap12Address() {
        return WS_UserManagementSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_UserManagementSoap12WSDDServiceName = "WS_UserManagementSoap12";

    public java.lang.String getWS_UserManagementSoap12WSDDServiceName() {
        return WS_UserManagementSoap12WSDDServiceName;
    }

    public void setWS_UserManagementSoap12WSDDServiceName(java.lang.String name) {
        WS_UserManagementSoap12WSDDServiceName = name;
    }

    public com.foundstone.s3i.service.ws.WS_UserManagementSoap getWS_UserManagementSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_UserManagementSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_UserManagementSoap12(endpoint);
    }

    public com.foundstone.s3i.service.ws.WS_UserManagementSoap getWS_UserManagementSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.foundstone.s3i.service.ws.WS_UserManagementSoap12Stub _stub = new com.foundstone.s3i.service.ws.WS_UserManagementSoap12Stub(portAddress, this);
            _stub.setPortName(getWS_UserManagementSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_UserManagementSoap12EndpointAddress(java.lang.String address) {
        WS_UserManagementSoap12_address = address;
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
            if (com.foundstone.s3i.service.ws.WS_UserManagementSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.foundstone.s3i.service.ws.WS_UserManagementSoapStub _stub = new com.foundstone.s3i.service.ws.WS_UserManagementSoapStub(new java.net.URL(WS_UserManagementSoap_address), this);
                _stub.setPortName(getWS_UserManagementSoapWSDDServiceName());
                return _stub;
            }
            if (com.foundstone.s3i.service.ws.WS_UserManagementSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.foundstone.s3i.service.ws.WS_UserManagementSoap12Stub _stub = new com.foundstone.s3i.service.ws.WS_UserManagementSoap12Stub(new java.net.URL(WS_UserManagementSoap12_address), this);
                _stub.setPortName(getWS_UserManagementSoap12WSDDServiceName());
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
        if ("WS_UserManagementSoap".equals(inputPortName)) {
            return getWS_UserManagementSoap();
        }
        else if ("WS_UserManagementSoap12".equals(inputPortName)) {
            return getWS_UserManagementSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WS_UserManagement");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_UserManagementSoap"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_UserManagementSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WS_UserManagementSoap".equals(portName)) {
            setWS_UserManagementSoapEndpointAddress(address);
        }
        else 
if ("WS_UserManagementSoap12".equals(portName)) {
            setWS_UserManagementSoap12EndpointAddress(address);
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
