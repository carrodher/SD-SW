import java.rmi.*;

// Interfaz observador
interface Observador extends Remote {
	void servicioSolicitado(String nombre, String tlfn, String address, String mensaje) throws RemoteException;
	void setNombre(String n) throws RemoteException;
	String getNombre() throws RemoteException;
}
