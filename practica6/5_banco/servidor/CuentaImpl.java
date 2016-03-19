// (4) Desarrollo la implementación de los servicios remotos.

import java.rmi.*;
import java.rmi.server.*;

class CuentaImpl extends UnicastRemoteObject implements Cuenta {
    private Titular tit;
    private float saldo = 0;

    // Constructor con el titular como parámetro
    CuentaImpl(Titular t) throws RemoteException {
        tit = t;
    }

    /* Métodos */
    // Devuelve el titular de la cuenta
    public Titular obtenerTitular() throws RemoteException {
        return tit;
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
