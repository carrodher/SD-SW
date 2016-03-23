import java.rmi.*;
import java.rmi.server.*;

/* Cliente.
Obtiene la referencia remota asociada al servicio (a traves de rmiregistry). Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException.*/
class ClienteMarcaTiempo {
    static public void main (String args[]) {
        if (args.length != 2) {
            System.err.println("Uso: ClienteMarcaTiempo hostregistro numPuertoRegistro");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Obtiene referencia remota del servicio de rmiregistry
            ServicioMarcaTiempo srv = (ServicioMarcaTiempo) Naming.lookup("//" + args[0] + ":" + args[1] + "/MarcaTiempo");
            //                                                                      |               |-> Número de puerto escucha rmiregistry
            //                                                                      |-> Host en el que se ejecuta rmiregistry
            while(true) {
                System.out.println(srv.marcaTiempo());
                try {
                    // 5000 milliseconds is 5 seconds
                    Thread.sleep(5000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepcion en ClienteMarcaTiempo:");
            e.printStackTrace();
        }
    }
}
