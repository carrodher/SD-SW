/*
Titular.
Clase titular en la que se encuentra su constructor y los tres métodos de los  que consta
*/

import java.io.*;

class Titular implements Serializable {
    private String nombre;
    private String iD;

    // Constructor de titular. Acepta como parámetros el nombre y el ID
    Titular(String n, String i) {
        nombre = n;
        iD = i;
    }

    // Devuelve el nombre del titular
    public String obtenerNombre() {
        return nombre;
    }

    // Devuelve el ID del titular
    public String obtenerID() {
        return iD;
    }

    // Devuelve el nombre y el ID como una única cadena
    public String toString() {
        return nombre + " | " + iD;
    }
}
