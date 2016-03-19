import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

// (2) Desarrollo la implementación de los servicios remotos.

class BancoImpl extends UnicastRemoteObject implements Banco {
    List<Cuenta> l;

    // Constructor del banco
    BancoImpl() throws RemoteException {
        l = new LinkedList<Cuenta>();
    }

    /* Métodos */
    // Añade y devuelve una nueva cuenta creada con su titular como parámetro
    public Cuenta crearCuenta(Titular t) throws RemoteException {
        Cuenta c = new CuentaImpl(t);
        // Añade la cuenta a la lista
        l.add(c);
        return c;
    }

    // Devuelve la lista con las cuentas
    public List<Cuenta> obtenerCuentas() throws RemoteException {
        return l;
    }
}
