import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
@SuppressWarnings("serial")

// (2) Desarrollo la implementación de los servicios remotos
class FabricaLogImpl extends UnicastRemoteObject implements FabricaLog {
    private List<ServicioLog> l;

    // Constructor de la fábrica
    FabricaLogImpl() throws RemoteException {
        l = new LinkedList<ServicioLog>();
    }

    /* Métodos */
    // Añade y devuelve una nueva cuenta creada con su titular como parámetro
    public ServicioLog crearLog(Log log) throws RemoteException {
        ServicioLog sl = new ServicioLogImpl(log);
        // Añade la cuenta a la lista
        l.add(sl);
        return sl;
    }

    // Devuelve la lista con los diferentes servicioLogs
    public List<ServicioLog> obtenerLogs() throws RemoteException {
        return l;
    }
}
