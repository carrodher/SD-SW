import java.rmi.*;
import java.rmi.server.*;

// Implementación de la clase observador
class ObservadorImpl extends UnicastRemoteObject implements Observador {
	ObservadorImpl() throws RemoteException {
	}

	public void temperaturaMaxAlcanzada(int tempAct) throws RemoteException {

		int DNG = 45;

		if (tempAct < DNG) {
			System.out.println("\033[33m WARNING!! Temperatura actual: " + tempAct);
		}
		else {
			System.out.println("\033[31m DANGER!! Temperatura actual: " + tempAct);
		}
	}
}
