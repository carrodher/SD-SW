import java.rmi.*;

/* (1)
Define una interfaz que derive de la interfaz Remote y contiene los métodos requeridos
por el servicio, permitiendo usar la expcepción RemoteException que permite a RMI notificar
sobre errores relacionados con la comunicación.

Métodos relativos a las funciones que realiza la centralita. */
interface ServicioCentralita extends Remote {
    void crearLog(String msg) throws RemoteException;
    void addObservador(Observador o, String nombre) throws RemoteException;
    void delObservador(Observador o, String nombre) throws RemoteException;
    String[] procesaAlerta(String nombre, String tlfn, String address, String mensaje) throws RemoteException;
}
