/*
(1)
Define una interfaz que derive de la interfaz Remote y contiene los métodos requeridos
por el servicio, permitiendo usar la expcepción RemoteException que permite a RMI notificar
sobre errores relacionados con la comunicación.
*/

import java.rmi.*;

interface Banco extends Remote {
	Cuenta crearCuenta(String nombre) throws RemoteException;
}
