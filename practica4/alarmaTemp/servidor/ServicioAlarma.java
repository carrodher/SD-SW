import java.rmi.*;

/* (1)
Define una interfaz que derive de la interfaz Remote y contiene los métodos requeridos
por el servicio, permitiendo usar la expcepción RemoteException que permite a RMI notificar
sobre errores relacionados con la comunicación. */
interface ServicioAlarma extends Remote {
    void addObserver(Observer o, String nombre) throws RemoteException;
    void delObserver(Observer o, String nombre) throws RemoteException;
    void setTemperatura(int temp) throws RemoteException;
    int getTemperatura() throws RemoteException;
}
