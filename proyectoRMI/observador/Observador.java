import java.rmi.*;

/* (1)
Define una interfaz que derive de la interfaz Remote y contiene los métodos requeridos
por el servicio, permitiendo usar la expcepción RemoteException que permite a RMI notificar
sobre errores relacionados con la comunicación.

Métodos relativos a las funcionalidades de los observadores */
interface Observador extends Remote {
	void servicioSolicitado(String nombre, String tlfn, String address, String mensaje) throws RemoteException;
	String getNombre() throws RemoteException;
}
