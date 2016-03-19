import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;

/* Observador Alarma.
Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException.
Crea un objeto ObservadorImpl y lo añade a los observadores del servicio de alarma.*/
class ObservadorAlarma {
    static public void main (String args[]) {
        if (args.length != 3) {
            System.err.println("Uso: ObservadorAlarma hostregistro numPuertoRegistro nombreObs");
            return;
        }

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
            // Crea nuevo observador y lo registra en la lista
            ObservadorImpl o = new ObservadorImpl();
            // Llamada al método remoto 'addObservador' del servicio
            srv.addObservador(o,args[2]);
            System.out.println("Observador: " + args[2]);
            System.out.println("Parar con Ctrl+D");
            //Creación de un objeto Scanner
            Scanner ent = new Scanner (System.in);
            while (ent.hasNextLine()) {}

                // Elimina de la lista al observador. Llamada al método remoto 'delObservador' del servicio
                srv.delObservador(o,args[2]);
                System.exit(0);
            }
            // Excepción RMI
            catch (RemoteException e) {
                System.err.println("Error de comunicación: " + e.toString());
            }
            // Excepción cliente
            catch (Exception e) {
                System.err.println("Excepción en ObservadorAlarma:");
                e.printStackTrace();
            }
        }
    }
