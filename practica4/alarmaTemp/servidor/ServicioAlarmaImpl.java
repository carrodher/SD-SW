import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

// (2) Desarrollo la implementación de los servicios remotos
class ServicioAlarmaImpl extends UnicastRemoteObject implements ServicioAlarma {
    private int WRN = 40;
    private int temperaturaActual = 0;

    // Lista de los observadores conectados
    private List<Observador> listaObservadores;

    // Constructor
    ServicioAlarmaImpl() throws RemoteException {
        listaObservadores = new LinkedList<Observador>();
    }

    /* Métodos */
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

        if (temperaturaActual >= WRN){
            for (Observador o: listaObservadores) {
                // Llamada al método remoto de 'alarma'
                o.temperaturaMaxAlcanzada(temperaturaActual);
            }
        }
    }

    // Obtiene el valor de la temperatura actual
    public int getTemperatura() throws RemoteException {
        return temperaturaActual;
    }
}
