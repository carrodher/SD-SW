import java.rmi.*;

// Interfaz observador
interface Observador extends Remote {
	void temperaturaMaxAlcanzada(int tempAct) throws RemoteException;
}
