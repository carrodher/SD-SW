import java.rmi.*;

// Cliente 
interface Cliente extends Remote {
	void notificacion(String apodo, String m) throws RemoteException;
}
