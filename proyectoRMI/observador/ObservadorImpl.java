import java.rmi.*;
import java.rmi.server.*;

// Implementación de la clase observador
class ObservadorImpl extends UnicastRemoteObject implements Observador {
	String nombre = "Bomberos";

	ObservadorImpl() throws RemoteException {
	}

	// Recibe e imprime la información de la alerta por parte de la centralita
	public void servicioSolicitado(String nombre, String tlfn, String address, String mensaje) throws RemoteException {
		System.out.println("Nombre: " + nombre);
		System.out.println("Teléfono: " + tlfn);
		System.out.println("Dirección: " + address);
		System.out.println("Mensaje: " + mensaje);
	}

	// Establece el nombre del servicio para este objeto
	public void setNombre(String n) throws RemoteException {
		this.nombre = n;
	}

	// Devuelve el nombre del servicio para este objeto
	public String getNombre() throws RemoteException {
		return this.nombre;
	}
}
