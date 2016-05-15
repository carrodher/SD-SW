// Este fichero usa las clases generadas por axis a partir del WSDL
// Cambiado ubuntu por lenevo en el import
import es.uc3m.www.WS.Parking.*;
import lenovo.axis.services.Parking.*;

public class ParkingClient2 {
    public static void main(String [] args) throws Exception {
        // Crear un servicio Parking
        ParkingService service = new ParkingServiceLocator();

        // Obtener un stub que utilizaremos para invocar los métodos remotos
        Parking port = service.getParking();

        /* Invocar los métodos */
        // Creamos 2 titulares
        PRopietario t1 = new Propietario();
        t1.setNombre("Carlos");
        t1.setDni("05663221K");

        Propietario t2 = new Propietario();
        t2.setNombre("Antonio");
        t2.setDni("96854750L");

        // Cramos 4 cuentas
        port.anadeCoche("1234BDS",t1);
        port.anadeCoche("8520RTY",t1);
        port.anadeCoche("7413JKL",t1);
        port.anadeCoche("9510DCV",t2);

        // Eliminamos una de las cuentas
        port.borraCoche("7413JKL");

        // Ingresamos y retiramos dinero
        port.ingresar("635478965",100);
        port.retirar("635478965",10);
        port.ingresar("480000221",200);
        port.ingresar("006998525",30);

        // Obtiene todas las cuentas de un titular en base a su DNI
        Cuenta array[] = port.cuentasDelTitular("05663221K");

        for (int k=0; k < array.length; k++) {
            Cuenta c = array[k];

            System.out.println("\nNúmero de Cuenta: " + c.getNumCuenta());
            System.out.println("Titular nombre: " + c.getTitular().getNombre() + " | DNI: " + c.getTitular().getDni());
            System.out.println("Balance: " + c.getBalance());
        }

        // Obtiene el titular de una cuenta
        Titular tit = port.titularDeCuenta("635478965");

        System.out.println("\nTitular nombre: " + tit.getNombre() + " | DNI: " + tit.getDni());
    }
}
