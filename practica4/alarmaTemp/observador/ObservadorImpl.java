import java.rmi.*;
import java.rmi.server.*;

class ObservadorImpl extends UnicastRemoteObject implements Observador {
	ObservadorImpl() throws RemoteException {
	}

	public void temperaturaMaxAlcanzada(int tempAct) throws RemoteException {

		int UMBRAL_WARN = 40;
    	int UMBRAL_DANG = 45;

    	if (tempAct >= UMBRAL_WARN && tempAct < UMBRAL_DANG) {
           	System.out.println("\033[33m WARNING!! Temperatura actual: " + tempAct);
        }
        else if (tempAct >= UMBRAL_DANG) {
          	System.out.println("\033[31m DANGER!! Temperatura actual: " + tempAct);
        }
        else {
        	System.out.println("\033[32m Nueva Temperatura actual: " + tempAct);
        }

		return ;
	}
}