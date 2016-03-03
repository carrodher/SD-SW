/*
 (2)
 Desarrollo la implementación de los servicios remotos.
*/

import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class ServicioAlarmaImpl extends UnicastRemoteObject implements ServicioAlarma {
    List<Observador> listaObservadores;                    // Lista de los observadores conectados
    ServicioAlarmaImpl() throws RemoteException {
        listaObservadores = new LinkedList<Observador>();
    }

    int temperaturaActual = 0;

    // Añade un observador a la lista
    void addObservador(Observador o) throws RemoteException {
        listaObservadores.add(o);
    }

    // Elimina un observador de la lista
    void delObservador(Observador o) throws RemoteException {
        listaObservadores.remove(listaObservadores.indexOf(o));
    }

    void setTemperatura(int temp) throws RemoteException {
        temperaturaActual = temp;
    }

    int getTemperatura() throws RemoteException {
        return temperaturaActual;
    }
}