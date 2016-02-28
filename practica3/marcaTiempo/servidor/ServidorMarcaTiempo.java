/*
 (3)
 Servidor. 
 Inicia el servicio remoto y lo hace accesible de manera pública usando el registro de RMI rmiregistry.
*/

import java.rmi.*;
import java.rmi.server.*;

class ServidorMarcaTiempo  {
    static public void main (String args[]) {
       if (args.length != 2) {
            System.err.println("Uso: ServidorMarcaTiempo numPuertoRegistro");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            // Crea objeto de la clase que implementa el servicio remoto
            ServicioMarcaTiempoImpl srv = new ServicioMarcaTiempoImpl();
            // Da de alta en rmiregistry mediante rebind
            Naming.rebind("rmi://localhost:" + args[0] + "/MarcaTiempo", srv);
                                              // |-> Número de puerto escucha rmiregistry
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicación: " + e.toString());
            System.exit(1);
        }
        // Excepción servidor
        catch (Exception e) {
            System.err.println("Excepción en ServidorMarcaTiempo:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
