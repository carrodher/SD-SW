import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

// (3.1) Desarrollo la implementación de los servicios remotos
class ServicioLogImpl extends UnicastRemoteObject implements ServicioLog {
    private PrintWriter fd;
    private FileWriter fw;
    private Log log;
    private Date date;

    // Constructor. Registra la fecha de creación
    ServicioLogImpl(Log l) throws RemoteException {
        log = l;
        date = new Date();
        try {
            fw = new FileWriter(l.obtenerNombreFichero(),true);
            fd = new PrintWriter(fw);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    /* Métodos */
    // Añadir synchronized antes de void para garantizar exclusión mútua entre los hilos al acceder al ḿétodo
    public synchronized void log(String m) throws RemoteException {
        /* 1º Escribe en la salida estándar */
        System.out.println("[" + new Date() + "] " + m);
        // Sleep para aumentar la diferencia entre salida estándar y fichero
        try {
            Thread.sleep(1);
        }
        catch(InterruptedException e) {
            System.err.println(e);
            System.exit(1);
        }
        /* 2º Escribe en el fichero */
        // Se escribe en un fichero mediante la función println de PrintWriter
        fd.println("[" + new Date() + "] " + m);
        // Envía la información directamente al disco, para evitar que quede en buffer
        fd.flush();
    }

    // Devuelve el objeto Log
    public Log obtenerLog() throws RemoteException {
        return log;
    }

    // Devuelve la fecha de creación del servicio
    public Date obtenerFecha() throws RemoteException{
        return date;
    }
}
