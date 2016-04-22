import java.util.*;
import java.rmi.*;
import java.io.*;
import java.rmi.server.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Calendar;

// (2) Desarrollo la implementación de los servicios remotos
class ServicioCentralitaImpl extends UnicastRemoteObject implements ServicioCentralita {

    //Fichero para log
    private PrintWriter file;

    // Lista de los observadores conectados
    private List<Observador> listaObservadores;

    // Constructor
    ServicioCentralitaImpl(String st) throws RemoteException {
        listaObservadores = new LinkedList<Observador>();
        try {
          file = new PrintWriter(st);
        }
        catch (FileNotFoundException e) {
          System.err.println(e);
          System.exit(1);
        }
    }

    /* Métodos */
    //Añade logs al fichero
    public void crearLog(String msg) throws RemoteException{
       Calendar fechaActual = Calendar.getInstance();
       //Empieza a escribir en el archivo
       file.println((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                 + "/" + String.valueOf(fechaActual.get(Calendar.MONTH)+1)
                 + "/" + String.valueOf(fechaActual.get(Calendar.YEAR))
                 + ";" + String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                 + ":" + String.valueOf(fechaActual.get(Calendar.MINUTE))
                 + ":" + String.valueOf(fechaActual.get(Calendar.SECOND)))
                 + ";" + msg + "\r\n");
       file.flush();
    }

    // Añade un observador a la lista
    public void addObservador(Observador o, String nombre) throws RemoteException {
        listaObservadores.add(o);
        this.crearLog("Añadido Observador" + nombre);
        // Comprueba el nombre del servicio para imprimir código de color
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
        this.crearLog("Eliminado Observador" + nombre);
        // Comprueba el nombre del servicio para imprimir código de color
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

        this.crearLog("ALERTA!! \n Nombre: " + nombre + "\nTelefono: " + tlfn + "\nDireccion: " + address + "\nMensaje: " + mensaje);

        // Patrón de palabras para cada servicio
        Pattern patronBomb = Pattern.compile("^.*(bomberos|gas[e]s?|encerrad[o|a]s?|fuegos?|incendios?|humos?|derrumbes?|llamas?|atrapad[o|a]s?).*$",Pattern.CASE_INSENSITIVE);
        Pattern patronPol = Pattern.compile("^.*(polic[í|a]s?|robos?|pelea?|atentado?|drogas?|borrach[o|a]?|armas?|ladr[ó|o]n[es]?|pistolas?|accidentes?|ciudad).*$",Pattern.CASE_INSENSITIVE);
        Pattern patronGC = Pattern.compile("^.*(guardias?|auto[pista|v[í|i]a]|tr[á|a]fico|conductor[a]?|coche?|accidentes?|carretera?|colisi[ó|o]n?).*$",Pattern.CASE_INSENSITIVE);
        Pattern patronSani = Pattern.compile("^.*(m[é|e]dic[a|o]s?|herid[a|o]s?|sangre|ambulancias?|accidentes?|raja?|colisi[ó|o]n?|hueso?|m[ú|u]sculo?|esguince?|rotura?).*$",Pattern.CASE_INSENSITIVE);

        // Pasa el mensaje por todos los patrones
        Matcher matchBomb = patronBomb.matcher(mensaje);
        Matcher matchPol = patronPol.matcher(mensaje);
        Matcher matchGC = patronGC.matcher(mensaje);
        Matcher matchSani = patronSani.matcher(mensaje);

        // Comprueba cuáles han coincidido
        if (matchBomb.matches()){
            servicios[0] = "Bomberos";
            System.out.println("\u001B[31m Match con " + servicios[0] + "\u001B[0m");
            this.crearLog("Match con" + servicios[0]);
        }
        if (matchSani.matches()){
            servicios[1] = "Sanitarios";
            System.out.println("\u001B[35m Match con " + servicios[1] + "\u001B[0m");
            this.crearLog("Match con" + servicios[1]);
        }
        if (matchPol.matches()){
            servicios[2] = "Policia";
            System.out.println("\u001B[34m Match con " + servicios[2] + "\u001B[0m");
            this.crearLog("Match con" + servicios[2]);
        }
        if (matchGC.matches()){
            servicios[3] = "Guardia Civil";
            System.out.println("\u001B[32m Match con " + servicios[3] + "\u001B[0m");
            this.crearLog("Match con" + servicios[3]);
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
