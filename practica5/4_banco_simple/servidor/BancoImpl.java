import java.rmi.*;
import java.rmi.server.*;

// (2) Desarrollo la implementación de los servicios remotos.
class BancoImpl extends UnicastRemoteObject implements Banco {
	BancoImpl() throws RemoteException {
    }
    // Crea un nuevo objeto que implementa la interfaz remota
    public Cuenta crearCuenta(String nombre) throws RemoteException {
        return new CuentaImpl(nombre);
    }
}
