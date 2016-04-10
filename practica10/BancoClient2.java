// Este fichero usa las clases generadas por axis a partir del WSDL
// Cambiado ubuntu por lenevo en el import
import es.uc3m.www.WS.Banco.*;
import lenovo.axis.services.Banco.*;

public class BancoClient2 {
    public static void main(String [] args) throws Exception {
        // Crear un servicio Banco
        BancoService service = new BancoServiceLocator();

        // Obtener un stub que utilizaremos para invocar los métodos remotos
        Banco port = service.getBanco();

        /* Invocar los métodos */
        // Creamos 2 titulares
        Titular t1 = new Titular();
        t1.setNombre("Carlos");
        t1.setDni("05663221K");

        Titular t2 = new Titular();
        t2.setNombre("Antonio");
        t2.setDni("96854750L");

        // Cramos 4 cuentas
        port.crearCuenta("635478965",t1);
        port.crearCuenta("366852001",t1);
        port.crearCuenta("480000221",t1);
        port.crearCuenta("006998525",t2);

        // Eliminamos una de las cuentas
        port.cerrarCuenta("366852001");

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
