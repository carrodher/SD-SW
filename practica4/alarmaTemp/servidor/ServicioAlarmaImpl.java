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
    public void addObservador(Observador o, String nombre) throws RemoteException {
        listaObservadores.add(o);
        System.out.println("Añadido observador " + nombre);
    }

    // Elimina un observador de la lista
    public void delObservador(Observador o, String nombre) throws RemoteException {
        listaObservadores.remove(listaObservadores.indexOf(o));
        System.out.println("Eliminado observador " + nombre);
    }

    // Modifica el valor de la temperatura actual y avisa a los observadores
    public void setTemperatura(int temp) throws RemoteException {
        temperaturaActual = temp;

        for (Observador o: listaObservadores) {
            o.temperaturaMaxAlcanzada(temperaturaActual);   // Llamada al método remoto 'notificacion'
        }
    }

    // Obtiene el valor de la temperatura actual
    public int getTemperatura() throws RemoteException {
        return temperaturaActual;
    }
}