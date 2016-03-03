/*
 Cliente.
 Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal, 
 lo único diferente es que pueden generar la excepción RemoteException.
*/

import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class ClienteAlarma {
    static public void main (String args[]) {
        if (args.length != 2) {
            System.err.println("Uso: ClienteAlarma hostregistro numPuertoRegistro");
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
            // Crea nuevo observador y lo registra en la lista
            ObservadorImpl o = new ObservadorImpl();
            srv.addObservador(o);								// Llamada al método remoto 'addObservador' del servicio
            
            for (int i = 35; i <= 50; i++) {
                srv.setTemperatura(i);	// Incrementa la temperatura llamando al método remoto 'setTemperatura'
                System.out.print("Temperatura actual: " + srv.getTemperatura());    // Obtiene la temperatura llamando al método remoto 'getTemperatura'
                try {
                    Thread.sleep(1000);                 // 1000 milliseconds is 1 second
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            // Elimina de la lista al observador
            srv.delObservador(o);								// Llamada al método remoto 'delObservador' del servicio
            System.exit(0);
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicación: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepción en ClienteAlarma:");
            e.printStackTrace();
        }
    }
}