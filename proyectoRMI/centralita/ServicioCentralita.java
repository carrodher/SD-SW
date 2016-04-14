import java.rmi.*;

/* (1)
Define una interfaz que derive de la interfaz Remote y contiene los métodos requeridos
por el servicio, permitiendo usar la expcepción RemoteException que permite a RMI notificar
sobre errores relacionados con la comunicación. */
interface ServicioCentralita extends Remote {
    void addObservador(Observador o, String nombre) throws RemoteException;
    void delObservador(Observador o, String nombre) throws RemoteException;
    String procesaAlerta(String nombre, String tlfn, String address, String mensaje) throws RemoteException;
}
