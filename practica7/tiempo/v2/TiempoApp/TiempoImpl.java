package tiempoApp;

import TiempoApp.*;
import java.util.Calendar;

/* El sirviente es un objeto Java que implementa la funcionalidad de los métodos del objeto
CORBA. Este sirviente es llamado por el soporte del servidor cuando un cliente llama a un
método del objeto CORBA implementado por ese sirviente. El código del sirviente implementa
las funciones del servicio Time*/
class TiempoImpl extends TiempoPOA {
    private Calendar ahora;
    private tiempo time;

    // Constructor
    public TiempoImpl() {
        ahora = Calendar.getInstance();
        time = new tiempo(ahora.get(Calendar.HOUR_OF_DAY), ahora.get(Calendar.MINUTE), ahora.get(Calendar.SECOND));
    }

    public int getHora() {
        return time.hora;
    }

    public int getMinutos() {
        return time.minutos;
    }

    public int getSegundos() {
        return time.segundos;
    }

    public tiempo getTiempo() {
        return time;
    }
}
