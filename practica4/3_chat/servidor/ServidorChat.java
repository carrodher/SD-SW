/*
 (3)
 Servidor. 
 Inicia el servicio remoto y lo hace accesible de manera pública usando RMI.
*/

import java.rmi.*;
import java.rmi.server.*;

class ServidorChat  {
    static public void main (String args[]) {
        if (args.length != 1) {
            System.err.println("Uso: ServidorChat numPuertoRegistro");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            // Crea objeto de la clase que implementa el servicio remoto
            ServicioChatImpl srv = new ServicioChatImpl();
            // Da de alta en rmi mediante rebind 
            Naming.rebind("rmi://localhost:" + args[0] + "/Chat", srv);
                                                // |-> Número de puerto escucha
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicación: " + e.toString());
            System.exit(1);
        }
        // Excepción servidor
        catch (Exception e) {
            System.err.println("Excepción en ServidorChat:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}