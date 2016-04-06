package newswebservice;

public class Noticia implements java.io.Serializable {
    private String titular;
    private String descripcion;
    private String url;

    // Establece un titular
    public void setTitular(String titular) {
        this.titular = titular;
    }

    // Establece una descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Establece una url
    public void setUrl(String url) {
        this.url = url;
    }

    // Obtiene un titular
    public String getTitular() {
        return this.titular;
    }

    // Obtiene una descripción
    public String getDescripcion() {
        return this.descripcion;
    }

    // Obtiene una url
    public String getUrl() {
        return this.url;
    }
}
