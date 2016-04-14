import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

/*Cliente Centralita.
Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException.
*/
class ClienteCentralita {
    static public void main (String args[]) {

        if (args.length != 5) {
            System.err.println("Uso: ClienteCentralita hostregistro numPuertoRegistro Nombre Teléfono Dirección");
            return;
        }

        // Almacena los datos recibidos por el cliente
        String nombre = args[2];
        String tlfn = args[3];
        String address = args[4];
        String mensaje;

        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Obtiene referencia remota del servicio de rmiregistry
            ServicioCentralita srv = (ServicioCentralita) Naming.lookup("//" + args[0] + ":" + args[1] + "/Centralita");
            //                                                                  |               |-> Número de puerto escucha
            //                                                                  |-> Host en el que se ejecuta el servicio
            
            // Almacena el texto por parte del cliente
            Scanner input = new Scanner(System.in);
            System.out.print(nombre + "> ");
            mensaje = input.nextLine();
            System.out.print("Gracias por su alerta, estamos procesando su mensaje.");

            // Envía el texto a la centralita para su procesamiento (no se si se puede devolver así)
            String servicio = srv.procesaAlerta(nombre, tlfn, address, mensaje);
            System.out.print("Se ha avisado a los siguientes servicios: " + servicio);
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicación: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepción en ClienteCentralita:");
            e.printStackTrace();
        }
    }
}
