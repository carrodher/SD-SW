package parkingwebservice;

public class Propietario implements java.io.Serializable {
    private String nombre;
    private String dni;
    private boolean conPlaza = false;

    // Establece el dni
    public void setDni(String d) {
        this.dni = d;
    }

    // Establece el nombre
    public void setNombre(String n) {
        this.nombre = n;
    }

    // Establece si tiene plaza
    public void setPlaza(boolean b) {
        this.conPlaza = b;
    }

    // Obtiene el dni
    public String getDni() {
        return this.dni;
    }

    // Obtiene el nombre
    public String getNombre() {
        return this.nombre;
    }

    // Obtiene si tiene plaza
    public boolean getPlaza() {
        return this.conPlaza;
    }

    // Devuelve el nombre y el DNI como una única cadena
    public String toString() {
        return this.nombre + " | " + this.dni;
    }
}
