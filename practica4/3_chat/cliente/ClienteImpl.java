import java.rmi.*;
import java.rmi.server.*;

// Implementación del cliente
class ClienteImpl extends UnicastRemoteObject implements Cliente {
	ClienteImpl() throws RemoteException {
	}
	public void notificacion(String apodo, String m) throws RemoteException {
		System.out.println("\n" + apodo + "> " + m);
	}
}
