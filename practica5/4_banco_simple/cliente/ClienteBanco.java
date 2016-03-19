import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

/* Cliente.
Obtiene la referencia remota asociada al servicio. Invoca los métodos de forma normal,
lo único diferente es que pueden generar la excepción RemoteException */
class ClienteBanco {
	static public void main (String args[]) {
		if (args.length != 3) {
			System.err.println("Uso: ClienteBanco hostregistro numPuertoRegistro nombreTitular");
			return;
		}
		// Instancia gestor de seguridad
		if (System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}
		try {
			// Obtiene referencia remota del servicio de rmiregistry
			Banco srv = (Banco) Naming.lookup("//" + args[0] + ":" + args[1] + "/Banco");
											/*      |               |-> Número de puerto escucha
													|-> Host en el que se ejecuta el servicio */
			// Crea nueva cuenta
			Cuenta c = srv.crearCuenta(args[2]);

			// Operación de suma e imprime resultado
			c.operacion(30);
			System.out.println(c.obtenerNombre() + ": " + c.obtenerSaldo());

			// Operación de resta e imprime resultado
			c.operacion(-5);
			System.out.println(c.obtenerNombre() + ": " + c.obtenerSaldo());
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
