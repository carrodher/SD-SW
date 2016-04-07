import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;

import javax.xml.rpc.ParameterMode;
import javax.xml.namespace.QName;

import agendaPackage.*;

// Cliente del servicio web
public class AgendaClient
{
    static String endpoint = "http://localhost:8888/axis/services/Agenda";

    public static void main(String [] args) throws Exception {
        String nombre;
        String tipo;
        String numero;
        Telefono tlf;

        // Si parámetro introducido = insert...
        if (args[0].equals("insert")) {
            // Debe haber 4 parámetros (insert + nombre + tipo + numero)
            if (args.length == 4) {
                // Recoge la entrada
                nombre = args[1];
                tipo = args[2];
                numero = args[3];

                // Crea el teléfono a partir de la entrada
                tlf = new Telefono();
                tlf.setNombre(nombre);
                tlf.setTipo(tipo);
                tlf.setNumero(numero);

                try {
                    invoca_insert(tlf);
                    System.exit(0);
                }
                catch (Exception ex) {
                    System.out.println(ex);
                    System.exit(1);
                }
            }
            else {
                System.out.println("Error en el paso de parametros");
                System.exit(1);
            }
        }
        // Si parámetro introducido = query...
        else if (args[0].equals("query")) {
            // Debe haber 2 parámetros (query + texto)
            if (args.length == 2) {
                try {
                    invoca_query(args[1]);
                    System.exit(0);
                }
                catch (Exception ex) {
                    System.out.println(ex);
                    System.exit(1);
                }
            }
            else {
                System.out.println("Error en el paso de parametros");
                System.exit(1);
            }
        }
        System.out.println("Error en el paso de parametros");
        System.exit(1);
    }

    private static void invoca_insert(Telefono tlf) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qn = new QName("http://www.uc3m.es/WS/Agenda", "Telefono");

            call.registerTypeMapping(agendaPackage.Telefono.class, qn,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(agendaPackage.Telefono.class, qn),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(agendaPackage.Telefono.class, qn));

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("insert");
            call.addParameter("tlf", qn, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { tlf });
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void invoca_query(String texto) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qn = new QName("http://www.uc3m.es/WS/Agenda", "Telefono");
            QName qna = new QName("http://www.uc3m.es/WS/Agenda", "ArrayOfTelefono");

            call.registerTypeMapping(agendaPackage.Telefono.class, qn,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(agendaPackage.Telefono.class, qn),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(agendaPackage.Telefono.class, qn));

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("query");
            call.addParameter("texto", XMLType.XSD_STRING, ParameterMode.IN );
            call.setReturnType(qna);

            Telefono obj[] = (Telefono [])call.invoke(new Object [] { texto });

            for (int k=0; k < obj.length; k++) {
                Telefono tlf = obj[k];

                System.out.println("Nombre: " + tlf.getNombre());
                System.out.println("Tipo: " + tlf.getTipo());
                System.out.println("Número: " + tlf.getNumero());
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
