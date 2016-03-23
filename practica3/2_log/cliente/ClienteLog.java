import java.rmi.*;
import java.rmi.server.*;

/*  Cliente.
Obtiene la referencia remota asociada al servicio (a traves de rmiregistry). Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException.*/
class ClienteLog {
    static public void main (String args[]) {
        if (args.length != 3) {
            System.err.println("Uso: ClienteLog hostregistro numPuertoRegistro mensajeLog");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null)
        System.setSecurityManager(new SecurityManager());

        try {
            // Obtiene referencia remota del servicio de rmiregistry
            ServicioLog srv = (ServicioLog) Naming.lookup("//" + args[0] + ":" + args[1] + "/Log");
            //                                                   |               |-> Número de puerto escucha rmiregistry
            //                                                   |-> Host en el que se ejecuta rmiregistry
            for (int i=0; i<10000; i++)
            srv.log(args[2] + " " + i);
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepcion en ClienteLog:");
            e.printStackTrace();
        }
    }
}
