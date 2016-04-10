/**
 * BancoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package lenovo.axis.services.Banco;

public class BancoServiceLocator extends org.apache.axis.client.Service implements lenovo.axis.services.Banco.BancoService {

    public BancoServiceLocator() {
    }


    public BancoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BancoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Banco
    private java.lang.String Banco_address = "http://lenovo:8888/axis/services/Banco";

    public java.lang.String getBancoAddress() {
        return Banco_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BancoWSDDServiceName = "Banco";

    public java.lang.String getBancoWSDDServiceName() {
        return BancoWSDDServiceName;
    }

    public void setBancoWSDDServiceName(java.lang.String name) {
        BancoWSDDServiceName = name;
    }

    public lenovo.axis.services.Banco.Banco getBanco() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Banco_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBanco(endpoint);
    }

    public lenovo.axis.services.Banco.Banco getBanco(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            lenovo.axis.services.Banco.BancoSoapBindingStub _stub = new lenovo.axis.services.Banco.BancoSoapBindingStub(portAddress, this);
            _stub.setPortName(getBancoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBancoEndpointAddress(java.lang.String address) {
        Banco_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (lenovo.axis.services.Banco.Banco.class.isAssignableFrom(serviceEndpointInterface)) {
                lenovo.axis.services.Banco.BancoSoapBindingStub _stub = new lenovo.axis.services.Banco.BancoSoapBindingStub(new java.net.URL(Banco_address), this);
                _stub.setPortName(getBancoWSDDServiceName());
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
        if ("Banco".equals(inputPortName)) {
            return getBanco();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://lenovo:8888/axis/services/Banco", "BancoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://lenovo:8888/axis/services/Banco", "Banco"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Banco".equals(portName)) {
            setBancoEndpointAddress(address);
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
