// Este fichero usa las clases generadas por axis a partir del WSDL
// Cambiado ubuntu por lenevo en el import
import es.uc3m.www.WS.Parking.*;
import carlos.axis.services.Parking.*;

public class ParkingClient2 {
	public static void main(String [] args) throws Exception {
		// Crear un servicio Parking
		ParkingService service = new ParkingServiceLocator();

		// Obtener un stub que utilizaremos para invocar los métodos remotos
		Parking port = service.getParking();

		/* Invocar los métodos */
		// Creamos 2 titulares
		Propietario p1 = new Propietario();
		p1.setNombre("Carlos");
		p1.setApellidos("Rodríguez Hernández");
		p1.setDni("08889880N");
		p1.setTelefono("609477932");
		p1.setAbono(true);

		Propietario p2 = new Propietario();
		p2.setNombre("Antonio");
		p2.setApellidos("Martinez Hernández");
		p2.setDni("9451635S");
		p2.setTelefono("65456932");
		p2.setAbono(false);

		// Añadimos 3 coches
		port.addCoche("7328FVT", p1, "Renault", "Megane", "Blanco");	// <-- Abonado
		port.addCoche("5437CRM", p2, "BMW", "530d", "Azul");			// <-- No abonado
		port.addCoche("9874MNJ", p2, "Audi", "A5", "Gris");				// <-- Eliminado

		// Eliminamos uno
		port.delCoche("9874MNJ");

		// Entran y salen coches
		port.aparcar("7328FVT");	// Aparca coche1
		port.aparcar("5437CRM");	// Aparca coche2
		port.salir("7328FVT");		// Sale coche1
		port.salir("5437CRM");		// Sale coche2

		// Añade nuevamente el coche borrado antes
		port.addCoche("9874MNJ", p2, "Audi", "A5", "Gris");

		// Obtiene todas los coches de un propietario en base a su DNI
		Coche array[] = port.getCochesDni("9451635S");

		for (int k = 0; k < array.length; k++) {
			Coche c = array[k];

			if (k == 0)
			System.out.println("\nPropietario nombre: " + c.getPropietario().getNombre() + " | DNI: " + c.getPropietario().getDni());

			System.out.println("\tMatrícula del coche: " + c.getMatricula());
			System.out.println("\tMarca: " + c.getMarca() + "\n");
		}

		// Obtiene el propietario de un coche
		Propietario prop = port.getPropietarioMatricula("7328FVT");
		System.out.println("Propietario nombre: " + prop.getNombre() + " | DNI: " + prop.getDni());

		// Elimina todos los coches
		port.delCoche("9874MNJ");
		port.delCoche("5437CRM");
		port.delCoche("7328FVT");
	}
}
