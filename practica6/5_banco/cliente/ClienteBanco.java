/*
Cliente.
Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException.
*/

import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class ClienteBanco {
    static public void main (String args[]) {
        if (args.length != 4) {
            System.err.println("Uso: ClienteBanco hostregistro numPuertoRegistro nombreTitular IDTitular");
            return;
        }
        // Instancia gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Obtiene referencia remota del servicio de rmiregistry
            Banco srv = (Banco) Naming.lookup("//" + args[0] + ":" + args[1] + "/Banco");
                                                /*      |               |-> Número de puerto escucha
                                                        |-> Host en el que se ejecuta el servicio */
            // Crea titular con su nombre e identificador
            Titular tit = new Titular(args[2], args[3]);
            // Crea nueva cuenta pasándole el Titular
            Cuenta c = srv.crearCuenta(tit);
            // Lista con las diferentes cuentas
            List <Cuenta> l;

            c.operacion(30);  // Operación de suma
            l = srv.obtenerCuentas();
            for (Cuenta i: l) {
                System.out.println(i.obtenerTitular() + ": " +i.obtenerSaldo());    // Imprime titular y saldo
            }

            c.operacion(-5);    // Operación de resta
            l = srv.obtenerCuentas();
            for (Cuenta i: l) {
                System.out.println(i.obtenerTitular() + ": " +i.obtenerSaldo());    // Imprime titular y saldo
            }
        }
        // Excepción RMI
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        // Excepción cliente
        catch (Exception e) {
            System.err.println("Excepcion en ClienteBanco:");
            e.printStackTrace();
        }
    }
}
