import java.rmi.*;

interface Observador extends Remote {
	void temperaturaMaxAlcanzada(int tempAct) throws RemoteException;
}