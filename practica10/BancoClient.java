import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;

import javax.xml.rpc.ParameterMode;
import javax.xml.namespace.QName;

import bancowebservice.*;

// Cliente del servicio web
public class BancoClient
{
    static String endpoint = "http://localhost:8888/axis/services/Banco";

    public static void main(String [] args) throws Exception {
        // Titular
        Titular titular;

        // Si parámetro introducido = crear...
        if (args[0].equals("crear")) {
            // Debe haber 4 parámetros (crear + numCuenta + nombre + dni)
            if (args.length == 4) {
                // Crea el titular
                titular = new Titular();
                titular.setNombre(args[2]);
                titular.setDni(args[3]);

                try {
                    invoca_crearCuenta(args[1], titular);
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
        // Si parámetro introducido = cerrar...
        else if (args[0].equals("cerrar")) {
            // Debe haber 2 parámetros (cerrar + numCuenta)
            if (args.length == 2) {
                try {
                    invoca_cerrarCuenta(args[1]);
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
        // Si parámetro introducido = ingresar...
        else if (args[0].equals("ingresar")) {
            // Debe haber 3 parámetros (ingresar + numCuenta + cantidad)
            if (args.length == 3) {
                try {
                    invoca_ingresar(args[1], Integer.parseInt(args[2]));
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
        // Si parámetro introducido = retirar...
        else if (args[0].equals("retirar")) {
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
        }
        // Si parámetro introducido = cuentas...
        else if (args[0].equals("cuentas")) {
            // Debe haber 2 parámetros (cuentas + DNI)
            if (args.length == 2) {
                try {
                    invoca_cuentasDelTitular(args[1]);
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
        // Si parámetro introducido = titular...
        else if (args[0].equals("titular")) {
            // Debe haber 2 parámetros (titular + numCuenta)
            if (args.length == 2) {
                try {
                    invoca_titularDeCuenta(args[1]);
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
        System.out.println("\nError en el paso de parámetros");

        System.exit(1);
    }

    private static void invoca_crearCuenta(String numCuenta, Titular titular) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qn = new QName("http://www.uc3m.es/WS/Banco", "Titular");

            call.registerTypeMapping(bancowebservice.Titular.class, qn,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(bancowebservice.Titular.class, qn),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(bancowebservice.Titular.class, qn));

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("crearCuenta");
            call.addParameter("numCuenta", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("titular", qn, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { numCuenta, titular });

            System.out.println("\nCuenta creada.");
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }

    private static void invoca_cerrarCuenta(String numCuenta) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("cerrarCuenta");
            call.addParameter("numCuenta", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { numCuenta });

            System.out.println("\nCuenta cerrada.");
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }


    private static void invoca_ingresar(String numCuenta, int cantidad) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("ingresar");
            call.addParameter("numCuenta", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("cantidad", XMLType.XSD_INTEGER, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { numCuenta, cantidad });
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }

    private static void invoca_retirar(String numCuenta, int cantidad) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("retirar");
            call.addParameter("numCuenta", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("cantidad", XMLType.XSD_INTEGER, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { numCuenta, cantidad });
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }

    private static void invoca_cuentasDelTitular(String dni) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qn = new QName("http://www.uc3m.es/WS/Banco", "Cuenta");
            QName qna = new QName("http://www.uc3m.es/WS/Banco", "ArrayOfCuenta");
            QName qnt = new QName("http://www.uc3m.es/WS/Banco", "Titular");

            call.registerTypeMapping(bancowebservice.Cuenta.class, qn,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(bancowebservice.Cuenta.class, qn),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(bancowebservice.Cuenta.class, qn));

            call.registerTypeMapping(bancowebservice.Titular.class, qnt,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(bancowebservice.Titular.class, qnt),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(bancowebservice.Titular.class, qnt));

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("cuentasDelTitular");
            call.addParameter("dni", XMLType.XSD_STRING, ParameterMode.IN );
            call.setReturnType(qna);

            Cuenta obj[] = (Cuenta [])call.invoke(new Object [] { dni });

            for (int k=0; k < obj.length; k++) {
                Cuenta c = obj[k];

                System.out.println("\nNúmero de Cuenta: " + c.getNumCuenta());
                System.out.println("Titular: " + c.getTitular().toString());
                System.out.println("Balance: " + c.getBalance());
            }
        }
        catch (Exception e) {
            System.out.println("\n" + e);
        }
    }

    private static void invoca_titularDeCuenta(String numCuenta) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qnt = new QName("http://www.uc3m.es/WS/Banco", "Titular");

            call.registerTypeMapping(bancowebservice.Titular.class, qnt,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(bancowebservice.Titular.class, qnt),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(bancowebservice.Titular.class, qnt));

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("titularDeCuenta");
            call.addParameter("numCuenta", XMLType.XSD_STRING, ParameterMode.IN );
            call.setReturnType(qnt);

            Titular obj = (Titular) call.invoke(new Object [] { numCuenta });

            System.out.println("\nTitular: " + obj.toString());
        }
        catch (Exception ex) {
            System.out.println("\n" + ex);
        }
    }
}
