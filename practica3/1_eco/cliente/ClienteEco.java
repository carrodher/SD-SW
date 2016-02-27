/*
 Cliente.
 Obtiene la referencia remota asociada al servicio (a traves de rmiregistry). Invoca los métodos de forma normal, 
 lo único diferente es que pueden generar la excepción RemoteException.
*/

import java.rmi.*;
import java.rmi.server.*;

class ClienteEco {
    static public void main (String args[]) {
        if (args.length < 2) {
            System.err.println("Uso: ClienteEco hostRegistro numPuertoRegistro [stringsToConvert]");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Obtiene referencia remota del servicio de rmiregistry
            ServicioEco srv = (ServicioEco) Naming.lookup("//" + args[0] + ":" + args[1] + "/Eco"); 
                                                            /*      |               |-> Número de puerto escucha rmiregistry
                                                                    |-> Host en el que se ejecuta rmiregistry */
            for (int i=2; i<args.length; i++)
                // Llamada al método remoto
                System.out.println(srv.eco(args[i]));       
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepcion en ClienteEco:");
            e.printStackTrace();
        }
    }
}