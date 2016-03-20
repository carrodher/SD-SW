import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

/*Cliente Alarma.
Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException.
Actualiza la temperatura desde 35º a 50º (por defecto) dejando transcurrir 1" entre actualizaciones.*/
class ClienteAlarma {
    static public void main (String args[]) {
        // Mínimo valor de temperatura
        int MIN = 35;
        // Máximo valor de temperatura
        int MAX = 50;

        if (args.length != 2 && args.length != 4) {
            System.err.println("Uso: ClienteAlarma hostregistro numPuertoRegistro [minTemp] [maxTemp]");
            return;
        }
        else if (args.length == 4) {
            // Mínimo valor de temperatura
            MIN = Integer.parseInt(args[2]);
            // Máximo valor de temperatura
            MAX = Integer.parseInt(args[3]);
        }

        // Temperatura actual
        int temperatura = 0;

        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Obtiene referencia remota del servicio de rmiregistry
            ServicioAlarma srv = (ServicioAlarma) Naming.lookup("//" + args[0] + ":" + args[1] + "/Alarma");
                                                                /*      |               |-> Número de puerto escucha
                                                                        |-> Host en el que se ejecuta el servicio*/
            for (int i = MIN; i <= MAX; i++) {
                // Incrementa la temperatura llamando al método remoto 'setTemperatura'
                srv.setTemperatura(i);
                // Obtiene la temperatura llamando al método remoto 'getTemperatura'
                temperatura = srv.getTemperatura();

                System.out.println("Temperatura: " + temperatura);

                try {
                    // 1000 milliseconds is 1 second
                    Thread.sleep(1000);
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
