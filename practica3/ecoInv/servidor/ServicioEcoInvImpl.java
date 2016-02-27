/*
 (2)
 Desarrollo la implementación de los servicios remotos.
*/

import java.rmi.*;
import java.rmi.server.*;

class ServicioEcoInvImpl extends UnicastRemoteObject implements ServicioEcoInv {
    ServicioEcoInvImpl() throws RemoteException {
    }
    public String ecoInv(String s) throws RemoteException {
    	StringBuffer buffer = new StringBuffer(s);
       	return buffer.reverse().toString();
    }
}