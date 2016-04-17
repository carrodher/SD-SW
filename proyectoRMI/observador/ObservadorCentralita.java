import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

/* Observador centralita.
Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException.
Crea un objeto ObservadorImpl y lo añade a los observadores de la centralita.*/
class ObservadorCentralita {
    static public void main (String args[]) {
        if (args.length != 2) {
            System.err.println("Uso: ObservadorCentralita hostregistro numPuertoRegistro");
            return;
        }

        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Obtiene referencia remota del servicio de rmiregistry
            ServicioCentralita srv = (ServicioCentralita) Naming.lookup("//" + args[0] + ":" + args[1] + "/Centralita");
            //                                                            |               |-> Número de puerto escucha
            //                                                            |-> Host en el que se ejecuta el servicio

            String nombreServicio = "default";

            while (nombreServicio == "default") {
                // Captura el nombre del servicio
                System.out.println("Elija el servicio:\n\t[1] Bomberos\n\t[2] Sanitarios\n\t[3] Policía\n\t[4] Guardia Civil");
                Scanner input = new Scanner(System.in);
                String tipoServicio = input.nextLine();

                switch (tipoServicio) {
                    case "1":
                        nombreServicio = "Bomberos";
                        break;
                    case "2":
                        nombreServicio = "Sanitarios";
                        break;
                    case "3":
                        nombreServicio = "Policia";
                        break;
                    case "4":
                        nombreServicio = "Guardia Civil";
                        break;
                    default:
                        nombreServicio = "default";
                        break;
                }
            }

            // Crea nuevo observador y lo registra en la lista
            ObservadorImpl o = new ObservadorImpl(nombreServicio);

            // Llamada al método remoto 'addObservador' del servicio
            srv.addObservador(o,nombreServicio);

            // Comrpeuba el nombre del servicio para imprimir código de color
            if (nombreServicio.equals("Bomberos")){
                System.out.println("\u001B[31mObservador " + nombreServicio + " registrado en la centralita\u001B[0m\n");
            }
            else if (nombreServicio.equals("Sanitarios")){
                System.out.println("\u001B[35mObservador " + nombreServicio + " registrado en la centralita\u001B[0m\n");
            }
            else if (nombreServicio.equals("Policia")){
                System.out.println("\u001B[34mObservador " + nombreServicio + " registrado en la centralita\u001B[0m\n");
            }
            else if (nombreServicio.equals("Guardia Civil")){
                System.out.println("\u001B[32mObservador " + nombreServicio + " registrado en la centralita\u001B[0m\n");
            }

            // Se mantiene esperando hasta que se para con Ctrl+D
            System.out.println("Para salir, pulsar Ctrl+D\n");
            Scanner sleep = new Scanner(System.in);
            while (sleep.hasNextInt()) {

            }

            // Elimina de la lista al observador. Llamada al método remoto 'delObservador' del servicio
            srv.delObservador(o,nombreServicio);
            System.exit(0);
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicación: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepción en ObservadorCentralita: ");
            e.printStackTrace();
        }
    }
}
