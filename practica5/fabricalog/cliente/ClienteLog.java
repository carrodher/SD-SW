/*
 Cliente.
 Obtiene la referencia remota asociada al servicio (a traves de rmiregistry). Invoca los métodos de forma normal, 
 lo único diferente es que pueden generar la excepción RemoteException.
*/

import java.rmi.*;
import java.rmi.server.*;

class ClienteLog {
    static public void main (String args[]) {
        if (args.length != 4) {
            System.err.println("Uso: ClienteLog hostregistro numPuertoRegistro nombreLog mensajeLog");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        try {
            // Obtiene referencia remota del servicio de rmiregistry
            FabricaLog srv = (FabricaLog) Naming.lookup("//" + args[0] + ":" + args[1] + "/FabricaLog");
                                                            /*      |               |-> Número de puerto escucha rmiregistry
                                                                    |-> Host en el que se ejecuta rmiregistry */   
            ServicioLog servLog = srv.crearLog(args[2]);
            for (int i=0; i<10000; i++)
                servLog.log(args[3] + " " + i);
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
