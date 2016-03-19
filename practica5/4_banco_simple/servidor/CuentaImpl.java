import java.rmi.*;
import java.rmi.server.*;

// (4) Desarrollo la implementación de los servicios remotos.
class CuentaImpl extends UnicastRemoteObject implements Cuenta {
    private String nombre;
    private float saldo = 0;

    // Constructor con el nombre como parámetros
    CuentaImpl(String n) throws RemoteException {
        nombre = n;
    }

    // Devuelve el nombre de la cuenta
    public String obtenerNombre() throws RemoteException {
        return nombre;
    }

    // Devuelve el saldo de la cuenta
    public float obtenerSaldo() throws RemoteException {
        return saldo;
    }

    // Suma "valor" al saldo actual y devuelve la nueva cantidad
    public float operacion(float valor) throws RemoteException {
        saldo += valor;
        return saldo;
    }
}
