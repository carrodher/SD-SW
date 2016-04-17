import java.rmi.*;
import java.rmi.server.*;

// Implementación de la clase observador
class ObservadorImpl extends UnicastRemoteObject implements Observador {
	String nombre;

	ObservadorImpl(String n) throws RemoteException {
		this.nombre = n;
	}

	// Recibe e imprime la información de la alerta por parte de la centralita
	public void servicioSolicitado(String nombre, String tlfn, String address, String mensaje) throws RemoteException {
		System.out.println("\u001B[31m \nALERTA!! \u001B[0m");
		System.out.println("\tNombre: " + nombre);
		System.out.println("\tTeléfono: " + tlfn);
		System.out.println("\tDirección: " + address);
		System.out.println("\tMensaje: " + mensaje);
	}

	// Devuelve el nombre del servicio para este objeto
	public String getNombre() throws RemoteException {
		return this.nombre;
	}
}
