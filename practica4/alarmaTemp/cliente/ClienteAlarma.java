/*
 Cliente Alarma.
 Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal,
 lo único diferente es que pueden generar la excepción RemoteException.

 Actualiza la temperatura desde 35º a 50º (por defecto) dejando transcurrir 1" entre actualizaciones.

 Dependecias: Observador.class ServicioAlarma.class
*/

import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class ClienteAlarma {
    static public void main (String args[]) {
    	int MIN_TEMP = 35;		// Mínimo valor de temperatura
    	int MAX_TEMP = 50;		// Máximo valor de temperatura

        if (args.length != 2 && args.length != 4) {
            System.err.println("Uso: ClienteAlarma hostregistro numPuertoRegistro [minTemp] [maxTemp]");
            return;
        }
        else if (args.length == 4) {
        	MIN_TEMP = Integer.parseInt(args[2]);		// Mínimo valor de temperatura
    		MAX_TEMP = Integer.parseInt(args[3]);		// Máximo valor de temperatura
		}

    	int temperatura = 0;		// Temperatura actual

        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
        	// Obtiene referencia remota del servicio de rmiregistry
            ServicioAlarma srv = (ServicioAlarma) Naming.lookup("//" + args[0] + ":" + args[1] + "/Alarma");
                                                          	  /*      |               |-> Número de puerto escucha
                                                                          |-> Host en el que se ejecuta el servicio*/
            for (int i = MIN_TEMP; i <= MAX_TEMP; i++) {
                srv.setTemperatura(i);					// Incrementa la temperatura llamando al método remoto 'setTemperatura'
                temperatura = srv.getTemperatura();		// Obtiene la temperatura llamando al método remoto 'getTemperatura'

             	System.out.println("Temperatura: " + temperatura);

                try {
                    Thread.sleep(1000);                 // 1000 milliseconds is 1 second
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
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
