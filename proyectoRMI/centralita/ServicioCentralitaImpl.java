import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

        // Comrpeuba el nombre del servicio para imprimir código de color
        if (nombre.equals("Bomberos")){
            System.out.println("\u001B[31mAñadido Observador " + nombre + "\u001B[0m");
        }
        else if (nombre.equals("Sanitarios")){
            System.out.println("\u001B[35mAñadido observador " + nombre + "\u001B[0m");
        }
        else if (nombre.equals("Policia")){
            System.out.println("\u001B[34mAñadido observador " + nombre + "\u001B[0m");
        }
        else if (nombre.equals("Guardia Civil")){
            System.out.println("\u001B[32mAñadido observador " + nombre + "\u001B[0m");
        }
    }

    // Elimina un observador de la lista
    public void delObservador(Observador o, String nombre) throws RemoteException {
        listaObservadores.remove(listaObservadores.indexOf(o));
        System.out.println("Eliminado observador " + nombre);

        // Comrpeuba el nombre del servicio para imprimir código de color
        if (nombre.equals("Bomberos")){
            System.out.println("\u001B[31mEliminado Observador " + nombre + "\u001B[0m");
        }
        else if (nombre.equals("Sanitarios")){
            System.out.println("\u001B[35mEliminado observador " + nombre + "\u001B[0m");
        }
        else if (nombre.equals("Policia")){
            System.out.println("\u001B[34mEliminado observador " + nombre + "\u001B[0m");
        }
        else if (nombre.equals("Guardia Civil")){
            System.out.println("\u001B[32mEliminado observador " + nombre + "\u001B[0m");
        }
    }

    /* Extrae la información destacada del mensaje del cliente y avisa a los servicios
    de emergencia oportunos */
    public String[] procesaAlerta(String nombre, String tlfn, String address, String mensaje) throws RemoteException {

        // Almacena los servicios determinados por las expresiones regulares
        String[] servicios = new String[4];

        // Patrón de palabras para cada servicio
        Pattern patronBomb = Pattern.compile("^.*(bomberos|fuegos?|incendios?|humos?|derrumbes?|llamas?|atrapad[o|a]s?).*$",Pattern.CASE_INSENSITIVE);
        Pattern patronPol = Pattern.compile("^.*(polic[í|a]s?|robos?|armas?|ladr[ó|o]n[es]?|pistolas?|accidentes?|ciudad).*$",Pattern.CASE_INSENSITIVE);
        Pattern patronGC = Pattern.compile("^.*(guardias?|auto[pista|v[í|i]a]|tr[á|a]fico|accidentes?|carretera|colisi[ó|o]n).*$",Pattern.CASE_INSENSITIVE);
        Pattern patronSani = Pattern.compile("^.*(m[é|e]dic[a|o]s?|herid[a|o]s?|sangre|ambulancias?|accidentes?).*$",Pattern.CASE_INSENSITIVE);

        // Pasa el mensaje por todos los patrones
        Matcher matchBomb = patronBomb.matcher(mensaje);
        Matcher matchPol = patronPol.matcher(mensaje);
        Matcher matchGC = patronGC.matcher(mensaje);
        Matcher matchSani = patronSani.matcher(mensaje);

        // Comprueba cuáles han coincidido
        if (matchBomb.matches()){
            servicios[0] = "Bomberos";
            System.out.println("\u001B[31m Match con " + servicios[0] + "\u001B[0m");
        }
        if (matchSani.matches()){
            servicios[1] = "Sanitarios";
            System.out.println("\u001B[35m Match con " + servicios[1] + "\u001B[0m");
        }
        if (matchPol.matches()){
            servicios[2] = "Policia";
            System.out.println("\u001B[34m Match con " + servicios[2] + "\u001B[0m");
        }
        if (matchGC.matches()){
            servicios[3] = "Guardia Civil";
            System.out.println("\u001B[32m Match con " + servicios[3] + "\u001B[0m");
        }

        // Busca en la lista los servicios elegidos
        for (int i = 0; i < servicios.length; i++) {
            if (servicios[i] != null) {
                // Recorre la lista de todos los observadores registrados
                for (Observador o: listaObservadores) {
                    if(o.getNombre().equals(servicios[i])) {
                        o.servicioSolicitado(nombre, tlfn, address, mensaje);
                    }
                }
            }
        }

        return servicios;
    }
}
