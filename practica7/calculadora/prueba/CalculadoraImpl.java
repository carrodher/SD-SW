package prueba;

import prueba.*;

/* El sirviente es un objeto Java que implementa la funcionalidad de los métodos del objeto
CORBA. Este sirviente es llamado por el soporte del servidor cuando un cliente llama a un
método del objeto CORBA implementado por ese sirviente. El código del sirviente implementa
las funciones de la calculadora*/
class CalculadoraImpl extends CalculadoraPOA {
    private double memoria_;

    // Constructor
    public CalculadoraImpl() {
        memoria_ = 0;
    }

    // Suma
    public double add(double x, double y) {
        return x+y;
    }

    // Resta
    public double substract(double x, double y) {
        return x-y;
    }

    // Multiplica
    public double multiply(double x, double y) {
        return x*y;
    }

    // Divide
    public double divide(double x, double y) {
        double result = 0;

        try {
            result = x/y;
        }
        catch(Exception e) {
        }

        return result;
    }

    // Escribe en la memoria
    public void storeMemory(double x) {
        memoria_ = x;
    }

    // Lee de la memoria
    public double readMemory() {
        return memoria_;
    }
}
