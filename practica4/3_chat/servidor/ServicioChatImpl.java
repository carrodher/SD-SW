import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

// (2) Desarrollo la implementación de los servicios remotos.
class ServicioChatImpl extends UnicastRemoteObject implements ServicioChat {
    // Lista de los clientes conectados
    List<Cliente> listaClientes;
    ServicioChatImpl() throws RemoteException {
        listaClientes = new LinkedList<Cliente>();
    }

    // Añade un cliente a la lista
    public void alta(Cliente c) throws RemoteException {
        listaClientes.add(c);
    }

    // Elimina un cliente de la lista
    public void baja(Cliente c) throws RemoteException {
        listaClientes.remove(listaClientes.indexOf(c));
    }

    // Notifica a todos los clientes excepto escritor (esc)
    public void envio(Cliente esc, String apodo, String m) throws RemoteException {
        for (Cliente c: listaClientes) {
            if (!c.equals(esc)){
                // Llamada al método remoto 'notificacion'
                c.notificacion(apodo, m);
            }
        }
    }
}
