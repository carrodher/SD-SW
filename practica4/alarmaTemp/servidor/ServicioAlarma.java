/* 
 (1)
 Define una interfaz que derive de la interfaz Remote y contiene los métodos requeridos
 por el servicio, permitiendo usar la expcepción RemoteException que permite a RMI notificar
 sobre errores relacionados con la comunicación.
*/

 import java.rmi.*;

 interface ServicioAlarma extends Remote {
 	void addObservador(Observador o) throws RemoteException;
 	void delObservador(Observador o) throws RemoteException;
 	void setTemperatura(int temp) throws RemoteException;
 	int getTemperatura() throws RemoteException;
 }