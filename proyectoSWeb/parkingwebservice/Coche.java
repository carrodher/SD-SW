package parkingwebservice;

import java.util.Date;

public class Coche implements java.io.Serializable {
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private Propietario propietario;
    private boolean aparcado;
    private Date llegada;
    private Date salida;
    private double tarificacion = 0;

    // Establece la matricula
    public void setMatricula(String m) {
        this.matricula = m;
    }

    // Establece la marca
    public void setMarca(String ma) {
        this.marca = ma;
    }

    // Establece el modelo
    public void setModelo(String mo) {
        this.modelo = mo;
    }

    // Establece el color
    public void setColor(String c) {
        this.color = c;
    }

    // Establece el propietario
    public void setPropietario(Propietario p) {
        this.propietario = p;
    }

    // Establece si esta en el parking o no
    public void setAparcado(boolean b) {
        this.aparcado = b;
    }

    // Establece la fecha de llegada al parking
    public void setLlegada(Date dl) {
        this.llegada = dl;
    }

    // Establece la fecha de salida
    public void setSalida(Date ds) {
        this.salida = ds;
    }

    // Establece el precio a pagar
    public void setTarificacion(double t) {
        this.tarificacion = t;
    }

    // Obtiene la matricula
    public String getMatricula() {
        return this.matricula;
    }

    // Obtiene la marca
    public String getMarca() {
        return this.marca;
    }

    // Obtiene el modelo
    public String getModelo() {
        return this.modelo;
    }

    // Obtiene el color
    public String getColor() {
        return this.color;
    }

    // Obtiene el propietario
    public Propietario getPropietario() {
        return this.propietario;
    }

    // Obtiene si esta en el parking o no
    public boolean getAparcado() {
        return this.aparcado;
    }

    // Obtiene la fecha de llegada al parking
    public Date getLlegada() {
        return this.llegada;
    }

    // Obtiene la fecha de salida del parking
    public Date getSalida() {
        return this.salida;
    }

    // Obtiene el precio a pagar
    public double getTarificacion() {
        return this.tarificacion;
    }

}
