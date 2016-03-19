import java.rmi.*;

/* (1)
 Define una interfaz que derive de la interfaz Remote y contiene los métodos requeridos
 por el servicio, permitiendo usar la expcepción RemoteException que permite a RMI notificar
 sobre errores relacionados con la comunicación.*/
interface ServicioChat extends Remote {
	void alta(Cliente c) throws RemoteException;
	void baja(Cliente c) throws RemoteException;
	void envio(Cliente e, String apodo, String m) throws RemoteException;
}
