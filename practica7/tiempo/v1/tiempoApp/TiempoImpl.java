package tiempoApp;

import tiempoApp.*;
import java.util.Calendar;

/* El sirviente es un objeto Java que implementa la funcionalidad de los métodos del objeto
CORBA. Este sirviente es llamado por el soporte del servidor cuando un cliente llama a un
método del objeto CORBA implementado por ese sirviente. El código del sirviente implementa
las funciones de la calculadora*/
class TiempoImpl extends TiempoPOA {
    private Calendar ahora;

    // Constructor
    public TiempoImpl() {
        ahora = Calendar.getInstance();
    }

    public int getHora() {
        return ahora.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinutos() {
        return ahora.get(Calendar.MINUTE);
    }

    public int getSegundos() {
        return ahora.get(Calendar.SECOND);
    }
}
