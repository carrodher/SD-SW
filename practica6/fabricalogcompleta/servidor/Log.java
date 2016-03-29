import java.io.*;
import java.util.*;
@SuppressWarnings("serial")

/* (2) 
Clase Log. Alamcena la información (nombre del fichero e ID de la aplicación)
de los objetos del Servicio de Log */
class Log implements Serializable {
    private String nombreFichero;
    private String idApp;

    // Constructor de la clase log. Recibe el nombre del fichero y un ID de app
    Log(String nomFich, String id) {
        nombreFichero = nomFich;
        idApp = id;
    }

    /* Métodos */
    // Devuelve el nombre del fichero
    public String obtenerNombreFichero() {
        return nombreFichero;
    }

    // Devuelve el ID de la aplicación
    public String obtenerIdApp() {
        return idApp;
    }

    // Devuelve el nombre y el ID como una única cadena
    public String toString() {
        return nombreFichero + " | " + idApp;
    }
}
