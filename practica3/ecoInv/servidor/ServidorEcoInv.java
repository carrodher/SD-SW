import java.rmi.*;
import java.rmi.server.*;

/* (3) Servidor.
Inicia el servicio remoto y lo hace accesible de manera pública usando el registro de RMI rmiregistry.*/
class ServidorEcoInv  {
    static public void main (String args[]) {
        if (args.length != 1) {
            System.err.println("Uso: ServidorEcoInv numPuertoRegistro");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            // Crea objeto de la clase que implementa el servicio remoto
            ServicioEcoInvImpl srv = new ServicioEcoInvImpl();
            // Da de alta en rmiregistry mediante rebind
            Naming.rebind("rmi://localhost:" + args[0] + "/EcoInv", srv);
            //                                   |-> Número de puerto escucha rmiregistry
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        }
        // Excepción servidor
        catch (Exception e) {
            System.err.println("Excepcion en ServidorEcoInv:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
