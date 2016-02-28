/*
 (2)
 Desarrollo la implementación de los servicios remotos.
*/

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

class ServicioLogImpl extends UnicastRemoteObject implements ServicioLog {
    PrintWriter fd;
    ServicioLogImpl(String f) throws RemoteException {
        try {
            fd = new PrintWriter(f);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
    // Añadir synchronized antes de void para garantizar exclusión mútua entre los hilos al acceder al ḿétodo
    public void log(String m) throws RemoteException {
        /* 1º Escribe en la salida estándar */
        System.out.println(m);
        // Sleep para aumentar la diferencia entre salida estándar y fichero
        try {
           Thread.sleep(1);
        }
        catch(InterruptedException e)
        {
        }
        /* 2º Escribe en el fichero */
        // Se escribe en un fichero mediante la función println de PrintWriter
        fd.println(m);
        // Envía la información directamente al disco, para evitar que quede en buffer
        fd.flush();
    }
}
