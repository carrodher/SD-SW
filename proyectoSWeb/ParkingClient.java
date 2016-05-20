import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;

import javax.xml.rpc.ParameterMode;
import javax.xml.namespace.QName;

import java.util.*;

import parkingwebservice.*;

// Cliente del servicio web
public class ParkingClient
{
	static String endpoint = "http://localhost:8888/axis/services/Parking";

	public static void main(String [] args) throws Exception {
		// Propietario
		Propietario propietario;

		// Almacena los datos recibidos por el usuario
		Scanner input = new Scanner(System.in);

		// Si parámetro introducido = añadir...
		if (args[0].equals("añadir")) {
			if (args.length == 1) {
				// Nombre
				String nombre = null;
				while (nombre == null || nombre.isEmpty()){
					System.out.print("\nCliente> Bienvenido al servicio de párking ¿Cuál es su nombre? ");
					nombre = input.nextLine();
				}
				// Apellidos
				String apellidos = null;
				while (apellidos == null || apellidos.isEmpty()){
					System.out.print("\nCliente> ¿Apellidos?\n");
					System.out.print(nombre + "> ");
					apellidos = input.nextLine();
				}
				// DNI
				String dni = null;
				while (dni == null || dni.isEmpty()){
					System.out.print("\nCliente> ¿DNI?\n");
					System.out.print(nombre + "> ");
					dni = input.nextLine();
				}
				// Teléfono
				String tlf = null;
				while (tlf == null || tlf.isEmpty()){
					System.out.print("\nCliente> ¿Teléfono?\n");
					System.out.print(nombre + "> ");
					tlf = input.nextLine();
				}
				// Abonado
				String abonado = null;
				while (abonado == null || abonado.isEmpty()){
					System.out.print("\nCliente> ¿Abonado? (Si/No)\n");
					System.out.print(nombre + "> ");
					abonado = input.nextLine();
				}
				// Matrícula
				String matricula = null;
				while (matricula == null || matricula.isEmpty()){
					System.out.print("\nCliente> Muy bien, hablemos sobre el coche. ¿Matrícula?\n");
					System.out.print(nombre + "> ");
					matricula = input.nextLine();
				}
				// Marca
				String marca = null;
				while (marca == null || marca.isEmpty()){
					System.out.print("\nCliente> ¿Marca?\n");
					System.out.print(nombre + "> ");
					marca = input.nextLine();
				}
				// Modelo
				String modelo = null;
				while (modelo == null || modelo.isEmpty()){
					System.out.print("\nCliente> ¿Modelo?\n");
					System.out.print(nombre + "> ");
					modelo = input.nextLine();
				}
				// Color
				String color = null;
				while (color == null || color.isEmpty()){
					System.out.print("\nCliente> ¿Color?\n");
					System.out.print(nombre + "> ");
					color = input.nextLine();
				}

				// Crea el propietario
				propietario = new Propietario();
				propietario.setNombre(nombre);
				propietario.setApellidos(apellidos);
				propietario.setDni(dni);
				propietario.setTelefono(tlf);
				if (abonado.equals("Si"))
				propietario.setAbono(true);
				else
				propietario.setAbono(false);

				try {
					invoca_addCoche(matricula, propietario, marca, modelo, color);
					System.exit(0);
				}
				catch (Exception ex) {
					System.out.println("\n" + ex);
					System.exit(1);
				}
			}
			else {
				System.out.println("\nError al añadir");
				System.exit(1);
			}
		}

		// Si parámetro introducido = eliminar...
		else if (args[0].equals("eliminar")) {
			if (args.length == 1) {
				try {
					// Matrícula
					String matricula = null;
					while (matricula == null || matricula.isEmpty()){
						System.out.print("\nCliente> ¿Cuál es la matricula del coche para eliminar?\n");
						System.out.print("Usuario> ");
						matricula = input.nextLine();
					}
					invoca_delCoche(matricula);
					System.exit(0);
				}
				catch (Exception ex) {
					System.out.println("\n" + ex);
					System.exit(1);
				}
			}
			else {
				System.out.println("\nError al eliminar");
				System.exit(1);
			}
		}

		// Si parámetro introducido = aparcar...
		else if (args[0].equals("aparcar")) {
			if (args.length == 1) {
				try {
					// Matrícula
					String matricula = null;
					while (matricula == null || matricula.isEmpty()){
						System.out.print("\nCliente> ¿Cuál es la matricula del coche que va a entrar?\n");
						System.out.print("Usuario> ");
						matricula = input.nextLine();
					}
					invoca_aparcar(matricula);
					System.exit(0);
				}
				catch (Exception ex) {
					System.out.println("\n" + ex);
					System.exit(1);
				}
			}
			else {
				System.out.println("\nError al aparcar");
				System.exit(1);
			}
		}

		// Si parámetro introducido = salir...
		else if (args[0].equals("salir")) {
			if (args.length == 1) {
				try {
					// Matrícula
					String matricula = null;
					while (matricula == null || matricula.isEmpty()){
						System.out.print("\nCliente> ¿Cuál es la matricula del coche que va a salir?\n");
						System.out.print("Usuario> ");
						matricula = input.nextLine();
					}
					invoca_salir(matricula);
					System.exit(0);
				}
				catch (Exception ex) {
					System.out.println("\n" + ex);
					System.exit(1);
				}
			}
			else {
				System.out.println("\nError al salir");
				System.exit(1);
			}
		}

		// Si parámetro introducido = getCoches...
		else if (args[0].equals("getCoches")) {
			if (args.length == 1) {
				try {
					// Matrícula
					String dni = null;
					while (dni == null || dni.isEmpty()){
						System.out.print("\nCliente> ¿Cuál es el DNI del propietario para buscar?\n");
						System.out.print("Usuario> ");
						dni = input.nextLine();
					}
					invoca_getCochesDni(dni);
					System.exit(0);
				}
				catch (Exception ex) {
					System.out.println("\n" + ex);
					System.exit(1);
				}
			}
			else {
				System.out.println("\nError en getCoches");
				System.exit(1);
			}
		}

		// Si parámetro introducido = getPropietario...
		else if (args[0].equals("getPropietario")) {
			if (args.length == 1) {
				try {
					// Matrícula
					String matricula = null;
					while (matricula == null || matricula.isEmpty()){
						System.out.print("\nCliente> ¿Cuál es la matrícula del coche para buscar?\n");
						System.out.print("Usuario> ");
						matricula = input.nextLine();
					}
					invoca_getPropietarioMatricula(matricula);
					System.exit(0);
				}
				catch (Exception ex) {
					System.out.println("\n" + ex);
					System.exit(1);
				}
			}
			else {
				System.out.println("\nError en getPropietario");
				System.exit(1);
			}
		}

		// Si parámetro introducido = getRegistrados...
		else if (args[0].equals("getRegistrados")) {
			if (args.length == 1) {
				try {
					invoca_getRegistrados();
					System.exit(0);
				}
				catch (Exception ex) {
					System.out.println("\n" + ex);
					System.exit(1);
				}
			}
			else {
				System.out.println("\nError en getRegistrados");
				System.exit(1);
			}
		}

		// Si parámetro introducido = getAparcados...
		else if (args[0].equals("getAparcados")) {
			if (args.length == 1) {
				try {
					invoca_getAparcados();
					System.exit(0);
				}
				catch (Exception ex) {
					System.out.println("\n" + ex);
					System.exit(1);
				}
			}
			else {
				System.out.println("\nError en getAparcados");
				System.exit(1);
			}
		}

		System.exit(1);
	}

	// Se da de alta un propietario
	private static void invoca_addCoche(String matricula, Propietario propietario, String marca, String modelo, String color) {
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			QName qn = new QName("http://www.uc3m.es/WS/Parking", "Propietario");

			call.registerTypeMapping(parkingwebservice.Propietario.class, qn,
			new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Propietario.class, qn),
			new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Propietario.class, qn));

			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("addCoche");
			call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("propietario", qn, ParameterMode.IN);
			call.addParameter("marca", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("modelo", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("color", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.AXIS_VOID);
			call.invoke(new Object [] { matricula, propietario, marca, modelo, color });

			System.out.println("\nPropietario " + propietario.nombreComToString() + " añadido");
			System.out.println("Coche " + marca + " " + modelo + " con matrícula " + matricula + " añadido");
		}
		catch (Exception ex) {
			System.out.println("\n" + ex);
		}
	}

	// Se da de baja un coche (y su propietario)
	private static void invoca_delCoche(String matricula) {
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("delCoche");
			call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.AXIS_VOID);
			call.invoke(new Object [] { matricula });

			System.out.println("\nCoche con matrícula " + matricula + " eliminado");
		}
		catch (Exception ex) {
			System.out.println("\n" + ex);
		}
	}

	// Entra un coche en el párking
	private static void invoca_aparcar(String matricula) {
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("aparcar");
			call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.AXIS_VOID);
			call.invoke(new Object [] { matricula });

			System.out.println("\nCoche con matrícula " + matricula + " aparcado");
		}
		catch (Exception ex) {
			System.out.println("\n" + ex);
		}
	}

	// Sale un coche del párking y se calcula su coste si no es abonado
	private static void invoca_salir(String matricula) {
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("salir");
			call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.XSD_DOUBLE);

			double tarifa = (double) call.invoke(new Object [] { matricula });

			if (tarifa > 0) {
				System.out.println("\nUsuario NO abonado. A pagar: " + tarifa + "€");
				System.out.println("Coche con matrícula " + matricula + " fuera");
			}
			else {
				System.out.println("Usuario abonado. Coche con matrícula " + matricula + " fuera");
			}
		}
		catch (Exception ex) {
			System.out.println("\n" + ex);
		}
	}

	// Obtiene los datos de un coche a partir del DNI de su propietario
	private static void invoca_getCochesDni(String dni) {
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			QName qn = new QName("http://www.uc3m.es/WS/Parking", "Coche");
			QName qna = new QName("http://www.uc3m.es/WS/Parking", "ArrayOfCoche");
			QName qnt = new QName("http://www.uc3m.es/WS/Parking", "Propietario");

			call.registerTypeMapping(parkingwebservice.Coche.class, qn,
			new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Coche.class, qn),
			new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Coche.class, qn));

			call.registerTypeMapping(parkingwebservice.Propietario.class, qnt,
			new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Propietario.class, qnt),
			new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Propietario.class, qnt));

			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("getCochesDni");
			call.addParameter("dni", XMLType.XSD_STRING, ParameterMode.IN );
			call.setReturnType(qna);

			Coche obj[] = (Coche [])call.invoke(new Object [] { dni });

			for (int k = 0; k < obj.length; k++) {
				Coche c = obj[k];
				// Imprime los datos del propietario la 1ª vez
				if (k == 0) {
					System.out.println("Propietario: " + c.getPropietario().nombreComToString());
				}
				// Imprime los datos del coche
				System.out.println("Matricula del coche: " + c.getMatricula());
				System.out.println("\tMarca: " + c.getMarca());
				System.out.println("\tModelo: " + c.getModelo());
				System.out.println("\tColor: " + c.getColor());
			}

		}
		catch (Exception e) {
			System.out.println("\n" + e);
		}
	}

	// Obtiene los datos de un propietario a partir de la matrícula de su coche
	private static void invoca_getPropietarioMatricula(String matricula) {
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			QName qnt = new QName("http://www.uc3m.es/WS/Parking", "Propietario");

			call.registerTypeMapping(parkingwebservice.Propietario.class, qnt,
			new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Propietario.class, qnt),
			new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Propietario.class, qnt));

			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("getPropietarioMatricula");
			call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN );
			call.setReturnType(qnt);

			Propietario obj = (Propietario) call.invoke(new Object [] { matricula });

			System.out.println("\nPropietario: " + obj.nombreComToString());
		}
		catch (Exception ex) {
			System.out.println("\n" + ex);
		}
	}

	// Devuelve un array con todos los coches registrados
	private static void invoca_getRegistrados() {
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			QName qn = new QName("http://www.uc3m.es/WS/Parking", "Coche");
			QName qna = new QName("http://www.uc3m.es/WS/Parking", "ArrayOfCoche");
			QName qnt = new QName("http://www.uc3m.es/WS/Parking", "Propietario");

			call.registerTypeMapping(parkingwebservice.Coche.class, qn,
			new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Coche.class, qn),
			new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Coche.class, qn));

			call.registerTypeMapping(parkingwebservice.Propietario.class, qnt,
			new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Propietario.class, qnt),
			new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Propietario.class, qnt));

			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("getRegistrados");
			//call.addParameter("dni", XMLType.XSD_STRING, ParameterMode.IN );
			call.setReturnType(qna);

			Coche obj[] = (Coche [])call.invoke(new Object [] {  });

			for (int k = 0; k < obj.length; k++) {
				Coche c = obj[k];
				System.out.println("\nPropietario: " + c.getPropietario().nombreComToString());
				// Imprime los datos del coche
				System.out.println("Matricula del coche: " + c.getMatricula());
				System.out.println("\tMarca: " + c.getMarca());
				System.out.println("\tModelo: " + c.getModelo());
				System.out.println("\tColor: " + c.getColor());
			}

		}
		catch (Exception e) {
			System.out.println("\n" + e);
		}
	}

	// Devuelve un array con todos los coches aparcados
	private static void invoca_getAparcados() {
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			QName qn = new QName("http://www.uc3m.es/WS/Parking", "Coche");
			QName qna = new QName("http://www.uc3m.es/WS/Parking", "ArrayOfCoche");
			QName qnt = new QName("http://www.uc3m.es/WS/Parking", "Propietario");

			call.registerTypeMapping(parkingwebservice.Coche.class, qn,
			new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Coche.class, qn),
			new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Coche.class, qn));

			call.registerTypeMapping(parkingwebservice.Propietario.class, qnt,
			new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Propietario.class, qnt),
			new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Propietario.class, qnt));

			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("getAparcados");
			//call.addParameter(XMLType.AXIS_VOID, ParameterMode.IN );
			call.setReturnType(qna);

			Coche obj[] = (Coche [])call.invoke(new Object [] {  });

			for (int k = 0; k < obj.length; k++) {
				Coche c = obj[k];
				System.out.println("\nPropietario: " + c.getPropietario().nombreComToString());
				// Imprime los datos del coche
				System.out.println("Matricula del coche: " + c.getMatricula());
				System.out.println("\tMarca: " + c.getMarca());
				System.out.println("\tModelo: " + c.getModelo());
				System.out.println("\tColor: " + c.getColor());
			}

		}
		catch (Exception e) {
			System.out.println("\n" + e);
		}
	}
}
