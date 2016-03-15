/*
 (2)
 Desarrollo la implementación de los servicios remotos.
*/

import java.rmi.*;
import java.rmi.server.*;

class FabricaLogImpl extends UnicastRemoteObject implements FabricaLog {
	FabricaLogImpl() throws RemoteException {
    }
    // Crea un nuevo objeto que implementa la interfaz remota
    public ServicioLog crearLog(String nombre) throws RemoteException {
        return new ServicioLogImpl(nombre);
    }
}