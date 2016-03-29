import java.rmi.*;
import java.rmi.server.*;

/* (4) Servidor.
Inicia el servicio remoto y lo hace accesible de manera pública usando RMI. */
class ServidorBanco  {
    static public void main (String args[]) {
        if (args.length != 1) {
            System.err.println("Uso: ServidorBanco numPuertoRegistro");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            // Crea objeto de la clase que implementa el servicio remoto
            BancoImpl srv = new BancoImpl();
            // Da de alta en rmi mediante rebind
            Naming.rebind("rmi://localhost:" + args[0] + "/Banco", srv);
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        }
        // Excepción servidor
        catch (Exception e) {
            System.err.println("Excepcion en ServidorBanco:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
