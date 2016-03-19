import java.rmi.*;
import java.rmi.server.*;

// (3) Servidor. Inicia el servicio remoto y lo hace accesible de manera pública usando RMI.
class ServidorAlarma  {
    static public void main (String args[]) {
        if (args.length != 1) {
            System.err.println("Uso: ServidorAlarma numPuertoRegistro");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            // Crea objeto de la clase que implementa el servicio remoto
            ServicioAlarmaImpl srv = new ServicioAlarmaImpl();
            // Da de alta en rmi mediante rebind
            Naming.rebind("rmi://localhost:" + args[0] + "/Alarma", srv);
                                                // |-> Número de puerto escucha
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicación: " + e.toString());
            System.exit(1);
        }
        // Excepción servidor
        catch (Exception e) {
            System.err.println("Excepción en ServidorAlarma:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
