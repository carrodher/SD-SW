import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

// (2) Desarrollo la implementación de los servicios remotos
class ServicioAlarmaImpl extends UnicastRemoteObject implements ServicioAlarma {
    private int WRN = 40;
    private int temperaturaActual = 0;

    // Lista de los observadores conectados
    private List<Observer> listaObservers;

    // Constructor
    ServicioAlarmaImpl() throws RemoteException {
        listaObservers = new LinkedList<Observer>();
    }

    /* Métodos */
    // Añade un Observer a la lista
    public void addObserver(Observer o, String nombre) throws RemoteException {
        listaObservers.add(o);
        System.out.println("Añadido Observer " + nombre);
    }

    // Elimina un Observer de la lista
    public void delObserver(Observer o, String nombre) throws RemoteException {
        listaObservers.remove(listaObservers.indexOf(o));
        System.out.println("Eliminado Observer " + nombre);
    }

    // Modifica el valor de la temperatura actual y avisa a los Observeres
    public void setTemperatura(int temp) throws RemoteException {
        temperaturaActual = temp;

        if (temperaturaActual >= WRN){
            for (Observer o: listaObservers) {
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
