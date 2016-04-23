import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

/*Cliente Centralita.
Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException.
*/
class ClienteCentralita {
    static public void main (String args[]) {

        if (args.length != 2) {
            System.err.println("Uso: ClienteCentralita hostregistro numPuertoRegistro");
            return;
        }

        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Obtiene referencia remota del servicio de rmiregistry
            ServicioCentralita srv = (ServicioCentralita) Naming.lookup("//" + args[0] + ":" + args[1] + "/Centralita");
            //                                                                  |               |-> Número de puerto escucha
            //                                                                  |-> Host en el que se ejecuta el servicio

            // Almacena los datos recibidos por el cliente
            Scanner input = new Scanner(System.in);

            // Nombre
            String nombre = null;
            while (nombre == null || nombre.isEmpty()){
              System.out.print("\n\u001B[33mCentralita>\u001B[0m Bienvenido al servicio de alerta ¿Cuál es su nombre? ");
              nombre = input.nextLine();
            }
            // Teléfono
            String tlfn = null;
            while (tlfn == null || tlfn.isEmpty()){
              System.out.print("\n\u001B[33mCentralita>\u001B[0m ¿Podría indicar un teléfono de contacto?\n");
              System.out.print("\u001B[36m" + nombre + ">\u001B[0m ");
              tlfn = input.nextLine();
            }
            // Dirección
            String address = null;
            while (address == null || address.isEmpty()){
              System.out.print("\n\u001B[33mCentralita>\u001B[0m ¿Cuál es la dirección del suceso?\n");
              System.out.print("\u001B[36m" + nombre + ">\u001B[0m ");
              address = input.nextLine();
            }
            // Mensaje
            String mensaje = null;
            while (mensaje == null || mensaje.isEmpty()){
              System.out.print("\n\u001B[33mCentralita>\u001B[0m Detalle a continuación la situación que requiere nuestra intervención:\n");
              System.out.print("\u001B[36m" + nombre + ">\u001B[0m");
              mensaje = input.nextLine();
            }

            // Envía el texto a la centralita para su procesamiento y espera la respuesta en servicios[]
            String [] servicios = srv.procesaAlerta(nombre, tlfn, address, mensaje);
            System.out.print("\n\u001B[33mCentralita>\u001B[0m Se ha avisado a los siguientes servicios:\n");

            for (int i = 0; i < servicios.length; i++) {
                if (servicios[i] != null) {
                    System.out.print("\t\t[" + (i+1) + "] " + servicios[i] + "\n");
                }
            }
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
