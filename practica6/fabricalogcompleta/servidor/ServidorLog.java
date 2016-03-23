import java.rmi.*;
import java.rmi.server.*;

/* (5) Servidor.
Inicia el servicio remoto y lo hace accesible de manera pública usando el registro de RMI rmiregistry */
class ServidorLog  {
    static public void main (String args[]) {
        if (args.length != 1) {
            System.err.println("Uso: ServidorLog numPuertoRegistro");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            // Crea objeto de la clase que implementa el servicio remoto
            FabricaLogImpl srv = new FabricaLogImpl();
            // Da de alta en rmiregistry mediante rebind
            Naming.rebind("rmi://localhost:" + args[0] + "/FabricaLog", srv);
            //                                  |-> Número de puerto escucha rmiregistry
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        }
        // Excepción servidor
        catch (Exception e) {
            System.err.println("Excepcion en ServidorLog:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
