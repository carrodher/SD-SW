package parkingwebservice;

public class Propietario implements java.io.Serializable {
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private boolean abonado = false;		// Abonado => No tarifica

	/* Métodos set */
    // Establece el dni
    public void setDni(String d) {
        this.dni = d;
    }

    // Establece el nombre
    public void setNombre(String n) {
        this.nombre = n;
    }

    // Establece los apellidos
    public void setApellidos(String a) {
        this.apellidos = a;
    }

    // Establece el telefono
    public void setTelefono(String t) {
        this.telefono = t;
    }

    // Establece si tiene plaza
    public void setAbono(boolean b) {
        this.abonado = b;
    }

	/* Métodos get */
    // Obtiene el dni
    public String getDni() {
        return this.dni;
    }

    // Obtiene el nombre
    public String getNombre() {
        return this.nombre;
    }

    // Obtiene los apellidos
    public String getApellidos() {
        return this.apellidos;
    }

    // Obtiene el telefono
    public String getTelefono() {
        return this.telefono;
    }

    // Obtiene si tiene plaza
    public boolean getAbono() {
        return this.abonado;
    }

    // Devuelve el nombre y el DNI como una única cadena
    public String toString() {
        return this.nombre + " | " + this.dni;
    }
}
