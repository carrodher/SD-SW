import java.rmi.*;
import java.rmi.server.*;

// (2) Desarrollo la implementación de los servicios remotos.
class ServicioEcoInvImpl extends UnicastRemoteObject implements ServicioEcoInv {
    ServicioEcoInvImpl() throws RemoteException {
    }
    public String ecoInv(String s) throws RemoteException {
        StringBuffer buffer = new StringBuffer(s);
        return buffer.reverse().toString();
    }
}
