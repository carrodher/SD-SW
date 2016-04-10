package bancowebservice;

public class Titular implements java.io.Serializable {
    private String nombre;
    private String dni;

    // Establece el dni
    public void setDni(String d) {
        this.dni = d;
    }

    // Establece el nombre
    public void setNombre(String n) {
        this.nombre = n;
    }

    // Obtiene el dni
    public String getDni() {
        return this.dni;
    }

    // Obtiene el nombre
    public String getNombre() {
        return this.nombre;
    }

    // Devuelve el nombre y el DNI como una única cadena
    public String toString() {
        return this.nombre + " | " + this.dni;
    }
}
