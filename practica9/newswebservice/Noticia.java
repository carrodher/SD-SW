package newswebservice;

public class Noticia implements java.io.Serializable {

    private String titular;
    private String descripcion;
    private String url;

    public void setTitular(String titular) {
	this.titular = titular;
    }
    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }
    public void setUrl(String url) {
	this.url = url;
    }

    public String getTitular() {
	return this.titular;
    }
    public String getDescripcion() {
	return this.descripcion;
    }
    public String getUrl() {
	return this.url;
    }

}
