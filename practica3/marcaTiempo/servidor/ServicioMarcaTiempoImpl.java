import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

//  (2) Desarrollo la implementación de los servicios remotos.
class ServicioMarcaTiempoImpl extends UnicastRemoteObject implements ServicioMarcaTiempo {
    ServicioMarcaTiempoImpl() throws RemoteException {
    }

    // Añadir synchronized para garantizar exclusión mútua entre los hilos al acceder al ḿétodo
    public synchronized Date marcaTiempo() throws RemoteException {
        // Obtenemos fecha y hora actual
        Date date = new Date();

        return date;
    }
}
