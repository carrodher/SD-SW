import java.rmi.*;

// Interfaz Observer
interface Observer extends Remote {
	void temperaturaMaxAlcanzada(int tempAct) throws RemoteException;
}
