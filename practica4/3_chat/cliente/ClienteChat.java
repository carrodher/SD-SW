/*
 Cliente.
 Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal, 
 lo único diferente es que pueden generar la excepción RemoteException.
*/

import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class ClienteChat {
    static public void main (String args[]) {
        if (args.length != 3) {
            System.err.println("Uso: ClienteChat hostregistro numPuertoRegistro apodo");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
        	// Obtiene referencia remota del servicio de rmiregistry
            ServicioChat srv = (ServicioChat) Naming.lookup("//" + args[0] + ":" + args[1] + "/Chat");
                                                            /*      |               |-> Número de puerto escucha
                                                                    |-> Host en el que se ejecuta el servicio*/
            // Crea nuevo cliente y lo registra en la lista
            ClienteImpl c = new ClienteImpl();
            srv.alta(c);								// Llamada al método remoto 'alta' del servicio
            
            // Escribe y envía
            Scanner ent = new Scanner(System.in);
            String apodo = args[2];
            System.out.print(apodo + "> ");
            while (ent.hasNextLine()) {
                srv.envio(c, apodo, ent.nextLine());	// Llamada al método remoto 'envio' del servicio
                System.out.print(apodo + "> ");
            }
            // Elimina de la lista al cliente
            srv.baja(c);								// Llamada al método remoto 'baja' del servicio
            System.exit(0);
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicación: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepción en ClienteChat:");
            e.printStackTrace();
        }
    }
}