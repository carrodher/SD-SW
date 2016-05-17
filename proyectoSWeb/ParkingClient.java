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

		// Si parámetro introducido = añadir...
		if (args[0].equals("anadir")) {
			if (args.length == 1) {
				// Almacena los datos recibidos por el cliente
				Scanner input = new Scanner(System.in);

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
				// Marca
				String marca = null;
				while (marca == null || marca.isEmpty()){
					System.out.print("\nCliente> ¿Marca del coche?\n");
					System.out.print(nombre + "> ");
					marca = input.nextLine();
				}
				// Modelo
				String modelo = null;
				while (modelo == null || modelo.isEmpty()){
					System.out.print("\nCliente> ¿Modelo del coche?\n");
					System.out.print(nombre + "> ");
					modelo = input.nextLine();
				}
				// Color
				String color = null;
				while (color == null || color.isEmpty()){
					System.out.print("\nCliente> ¿Color del coche?\n");
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
					invoca_anadirCoche(matricula, propietario, marca, modelo, color);
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
			// Debe haber 2 parámetros (eliminar + matricula)
			if (args.length == 2) {
				try {
					invoca_delCoche(args[1]);
					System.exit(0);
				}
				catch (Exception ex) {
					System.out.println("\n" + ex);
					System.exit(1);
				}
			}
			else {
				System.out.println("\nError en el paso de parámetros");
				System.exit(1);
			}
		}

        // Si parámetro introducido = entrar...
        else if (args[0].equals("entrar")) {
            // Debe haber 2 parámetros (entrar + matricula)
            if (args.length == 2) {
                try {
                    invoca_entrar(args[1]);
                    System.exit(0);
                }
                catch (Exception ex) {
                    System.out.println("\n" + ex);
                    System.exit(1);
                }
            } else {
                System.out.println("\nError en el paso de parámetros");
                System.exit(1);
            }
        }

        // Si parámetro introducido = salir...
        else if (args[0].equals("salir")) {
            // Debe haber 2 parámetros (salir + matricula)
            if (args.length == 2) {
                try {
                    invoca_salir(args[1]);
                    System.exit(0);
                }
                catch (Exception ex) {
                    System.out.println("\n" + ex);
                    System.exit(1);
                }
            } else {
                System.out.println("\nError en el paso de parámetros");
                System.exit(1);
            }
        }

        // Si parámetro introducido = alquilaPlaza...
        else if (args[0].equals("alquilaPlaza")) {
            // Debe haber 2 parámetros (alquilaPlaza + DNI)
            if (args.length == 2) {
                try {
                    invoca_alquilaPlaza(args[1]);
                    System.exit(0);
                }
                catch (Exception ex) {
                    System.out.println("\n" + ex);
                    System.exit(1);
                }
            }
            else {
                System.out.println("\nError en el paso de parámetros");
                System.exit(1);
            }
        }

        // Si parámetro introducido = coches...
        else if (args[0].equals("coches")) {
            // Debe haber 2 parámetros (coches + DNI)
            if (args.length == 2) {
                try {
                    invoca_cochesDelPropietario(args[1]);
                    System.exit(0);
                }
                catch (Exception ex) {
                    System.out.println("\n" + ex);
                    System.exit(1);
                }
            } else {
                System.out.println("\nError en el paso de parámetros");
                System.exit(1);
            }
        }

        // Si parámetro introducido = propietario...
        else if (args[0].equals("propietario")) {
            // Debe haber 2 parámetros (propietario + matricula)
            if (args.length == 2) {
                try {
                    invoca_propietarioDeCoche(args[1]);
                    System.exit(0);
                }
                catch (Exception ex) {
                    System.out.println("\n" + ex);
                    System.exit(1);
                }
            } else {
                System.out.println("\nError en el paso de parámetros");
                System.exit(1);
            }
        }
        System.out.println("\nError en el paso de parámetros");

        System.exit(1);
    }

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

			System.out.println("\nCoche añadido");
		}
		catch (Exception ex) {
			System.out.println("\n" + ex);
		}
	}

	private static void invoca_delCoche(String matricula) {
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("delCoche");
			call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.AXIS_VOID);
			call.invoke(new Object [] { matricula });

			System.out.println("\nCoche eliminado");
		}
		catch (Exception ex) {
			System.out.println("\n" + ex);
		}
	}


    private static void invoca_entrar(String matricula) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("entrar");
            call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { matricula });
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }

    private static void invoca_salir(String matricula) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("salir");
            call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { matricula });
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }

    private static void invoca_alquilaPlaza(String dni) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("alquilaPlaza");
            call.addParameter("dni", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { dni });
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }

    private static void invoca_cochesDelPropietario(String dni) {
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
            call.setOperationName("cochesDelPropietario");
            call.addParameter("dni", XMLType.XSD_STRING, ParameterMode.IN );
            call.setReturnType(qna);

            Coche obj[] = (Coche [])call.invoke(new Object [] { dni });

            for (int k=0; k < obj.length; k++) {
                Coche c = obj[k];

                System.out.println("\nMatricula del coche: " + c.getMatricula());
                System.out.println("Propietario: " + c.getPropietario().toString());
                //System.out.println("Balance: " + c.getBalance());
            }
        }
        catch (Exception e) {
            System.out.println("\n" + e);
        }
    }

    private static void invoca_propietarioDeCoche(String matricula) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qnt = new QName("http://www.uc3m.es/WS/Parking", "Propietario");

            call.registerTypeMapping(parkingwebservice.Propietario.class, qnt,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Propietario.class, qnt),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Propietario.class, qnt));

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("propietarioDeCoche");
            call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN );
            call.setReturnType(qnt);

            Propietario obj = (Propietario) call.invoke(new Object [] { matricula });

            System.out.println("\nPropietario: " + obj.toString());
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }
}
