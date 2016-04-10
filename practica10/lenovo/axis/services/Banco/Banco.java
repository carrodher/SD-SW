/**
 * Banco.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package lenovo.axis.services.Banco;

public interface Banco extends java.rmi.Remote {
    public void ingresar(java.lang.String in0, int in1) throws java.rmi.RemoteException;
    public void retirar(java.lang.String in0, int in1) throws java.rmi.RemoteException;
    public void crearCuenta(java.lang.String in0, es.uc3m.www.WS.Banco.Titular in1) throws java.rmi.RemoteException;
    public void cerrarCuenta(java.lang.String in0) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.Banco.Cuenta[] cuentasDelTitular(java.lang.String in0) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.Banco.Titular titularDeCuenta(java.lang.String in0) throws java.rmi.RemoteException;
}
