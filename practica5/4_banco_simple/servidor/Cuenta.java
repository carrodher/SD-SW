import java.rmi.*;

/* (3)
Define una interfaz que derive de la interfaz Remote y contiene los métodos requeridos
por el servicio, permitiendo usar la expcepción RemoteException que permite a RMI notificar
sobre errores relacionados con la comunicación.*/
interface Cuenta extends Remote {
    String obtenerNombre() throws RemoteException;
    float obtenerSaldo() throws RemoteException;
    float operacion(float valor) throws RemoteException;
}
