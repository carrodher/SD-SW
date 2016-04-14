import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

// (2) Desarrollo la implementación de los servicios remotos
class ServicioCentralitaImpl extends UnicastRemoteObject implements ServicioCentralita {

    // Lista de los observadores conectados
    private List<Observador> listaObservadores;

    // Constructor
    ServicioCentralitaImpl() throws RemoteException {
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

    /* Extrae la información destacada del mensaje del cliente y avisa a los servicios
    de emergencia oportunos */
    public String procesaAlerta(String nombre, String tlfn, String address, String mensaje) throws RemoteException {
        /* TODO:
        - Con expresiones regulares sacar palabras claves y determinar el servicio
        - Avisar al servicio en cuestión
        - Devolver el servicio avisado
        */
    }
}
