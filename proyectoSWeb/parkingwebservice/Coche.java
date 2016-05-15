package parkingwebservice;

import java.util.Date;

public class Coche implements java.io.Serializable {
    private String matricula;
    private Propietario propietario;
    private boolean aparcado;
    private Date llegada;
    private Date salida;
    private double tarificacion = 0;

    // Establece la matricula
    public void setMatricula(String m) {
        this.matricula = m;
    }

    // Establece el titular
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
