import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;

import javax.xml.rpc.ParameterMode;
import javax.xml.namespace.QName;

import parkingwebservice.*;

// Cliente del servicio web
public class ParkingClient
{
    static String endpoint = "http://localhost:8888/axis/services/Parking";

    public static void main(String [] args) throws Exception {
        // Propietario
        Propietario propietario;

        // Si parámetro introducido = crear...
        if (args[0].equals("anadir")) {
            // Debe haber 4 parámetros (crear + matricula + nombre + dni )
            if (args.length == 4) {
                // Crea el titular
                propietario = new Propietario();
                propietario.setNombre(args[2]);
                propietario.setDni(args[3]);
                try {
                    invoca_anadirCoche(args[1], propietario);
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
        // Si parámetro introducido = eliminar...
        else if (args[0].equals("eliminar")) {
            // Debe haber 2 parámetros (eliminar + matricula)
            if (args.length == 2) {
                try {
                    invoca_eliminarCoche(args[1]);
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

        // Si parámetro introducido = retirar...
        /*else if (args[0].equals("retirar")) {
            // Debe haber 3 parámetros (retirar + numCuenta + cantidad)
            if (args.length == 3) {
                try {
                    invoca_retirar(args[1], Integer.parseInt(args[2]));
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
        }*/

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

    private static void invoca_anadirCoche(String matricula, Propietario propietario) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qn = new QName("http://www.uc3m.es/WS/Parking", "Propietario");

            call.registerTypeMapping(parkingwebservice.Propietario.class, qn,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(parkingwebservice.Propietario.class, qn),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(parkingwebservice.Propietario.class, qn));

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("anadirCoche");
            call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("propietario", qn, ParameterMode.IN);
            call.addParameter("plaza", XMLType.XSD_BOOLEAN, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { matricula, propietario, plaza });

            System.out.println("\nCoche añadido.");
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }

    private static void invoca_eliminarCoche(String matricula) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("eliminarCoche");
            call.addParameter("matricula", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { matricula });

            System.out.println("\nCoche eliminado.");
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

                System.out.println("\nMatricula del coche: " + c.getNumCuenta());
                System.out.println("Propietario: " + c.getTitular().toString());
                //System.out.println("Balance: " + c.getBalance());
            }
        }
        catch (Exception e) {
            System.out.println("\n" + e);
        }
    }

    private static void invoca_propietarioDeCoche(String numCuenta) {
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
