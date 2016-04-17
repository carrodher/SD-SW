import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;

/* Observer Alarma.
Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException.
Crea un objeto ObserverImpl y lo añade a los Observer del servicio de alarma.*/
class ObserverAlarma {
    static public void main (String args[]) {
        if (args.length != 3) {
            System.err.println("Uso: ObserverAlarma hostregistro numPuertoRegistro nombreObs");
            return;
        }

        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Obtiene referencia remota del servicio de rmiregistry
            ServicioAlarma srv = (ServicioAlarma) Naming.lookup("//" + args[0] + ":" + args[1] + "/Alarma");
            //                                                            |               |-> Número de puerto escucha
            //                                                            |-> Host en el que se ejecuta el servicio
            // Crea nuevo Observer y lo registra en la lista
            ObserverImpl o = new ObserverImpl();
            // Llamada al método remoto 'addObserver' del servicio
            srv.addObserver(o,args[2]);
            System.out.println("Observer: " + args[2]);
            System.out.println("Parar con Ctrl+D");
            //Creación de un objeto Scanner
            Scanner ent = new Scanner (System.in);
            while (ent.hasNextLine()) {

            }

            // Elimina de la lista al Observer. Llamada al método remoto 'delObserver' del servicio
            srv.delObserver(o,args[2]);
            System.exit(0);
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicación: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepción en ObserverAlarma:");
            e.printStackTrace();
        }
    }
}
