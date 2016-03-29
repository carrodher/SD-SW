import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

/* Cliente.
Obtiene la referencia remota asociada al servicio (a traves de rmiregistry).
Invoca los métodos de forma normal, lo único diferente es que pueden generar
la excepción RemoteException. */
class ClienteLog {
    static public void main (String args[]) {
        int tamLista = 0;

        if (args.length != 4) {
            //                                     args[0]         args[1]      args[2]  args[3]
            System.err.println("Uso: ClienteLog hostregistro numPuertoRegistro nombreLog IDapp");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Obtiene referencia remota del servicio de rmiregistry
            FabricaLog fabrica = (FabricaLog) Naming.lookup("//" + args[0] + ":" + args[1] + "/FabricaLog");
            //                                                   |               |-> Número de puerto escucha rmiregistry
            //                                                   |-> Host en el que se ejecuta rmiregistry

            // Crea nuevo objeto log. Párametros: nombreLog e IDapp
            Log logCliente = new Log(args[2], args[3]);
            // Crea el servicio de Log asociado al Log creado anteriormente
            ServicioLog servLog = fabrica.crearLog(logCliente);
            System.out.println("Fichero | IDapp          Fecha Creación \n");
            while (true) {
                // Cada 3" registra el log
                try {
                    Thread.sleep(3000);
                }
                catch(InterruptedException e) {
                    System.err.println(e);
                    System.exit(1);
                }
                // Realiza el registro periódico
                servLog.log(logCliente.toString());

                // Obtiene la nueva lista de todos los Servicios de Log que hay en el momento
                List <ServicioLog> lista = fabrica.obtenerLogs();
                // Si ha habido cambios en la lista...
                if (tamLista != lista.size()){
                    // Recorre toda la lista de logs
                    for (ServicioLog i: lista){
                        //logCliente = i.obtenerLog();
                        System.out.println(i.obtenerLog() + " => " + i.obtenerFecha());
                    }
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                }
                // Tamaño de la lista antes de actualziar
                tamLista = lista.size();
            }
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepcion en ClienteLog:");
            e.printStackTrace();
        }
    }
}
