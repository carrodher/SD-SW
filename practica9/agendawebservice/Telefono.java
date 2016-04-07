package agendawebservice;

public class Telefono implements java.io.Serializable {
    private String nombre;
    private String tipo;
    private String numero;

    // Establece un nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Establece una tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Establece una numero
    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Obtiene un nombre
    public String getNombre() {
        return this.nombre;
    }

    // Obtiene una descripción
    public String getTipo() {
        return this.tipo;
    }

    // Obtiene una numero
    public String getNumero() {
        return this.numero;
    }
}
