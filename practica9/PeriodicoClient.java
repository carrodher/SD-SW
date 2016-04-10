import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;

import javax.xml.rpc.ParameterMode;
import javax.xml.namespace.QName;

import newswebservice.*;

// Cliente del servicio web
public class PeriodicoClient
{
    static String endpoint = "http://localhost:8888/axis/services/Periodico";

    public static void main(String [] args) throws Exception {
        String titular;
        String descripcion;
        String url;
        Noticia n;

        // Si parámetro introducido = insert...
        if (args[0].equals("insert")) {
            // Debe haber 4 parámetros (insert + tit + desc + url)
            if (args.length == 4) {
                // Recoge la entrada
                titular = args[1];
                descripcion = args[2];
                url = args[3];

                // Crea la noticia con la entrada
                n = new Noticia();
                n.setTitular(titular);
                n.setDescripcion(descripcion);
                n.setUrl(url);

                try {
                    invoca_insert(n);
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

    private static void invoca_insert(Noticia n) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qn = new QName("http://www.uc3m.es/WS/Periodico", "Noticia");

            call.registerTypeMapping(newswebservice.Noticia.class, qn,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(newswebservice.Noticia.class, qn),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(newswebservice.Noticia.class, qn));

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("insert");
            call.addParameter("n", qn, ParameterMode.IN);
            call.setReturnType(XMLType.AXIS_VOID);
            call.invoke(new Object [] { n });
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void invoca_query(String texto) {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qn = new QName("http://www.uc3m.es/WS/Periodico", "Noticia");
            QName qna = new QName("http://www.uc3m.es/WS/Periodico", "ArrayOfNoticia");

            call.registerTypeMapping(newswebservice.Noticia.class, qn,
            new org.apache.axis.encoding.ser.BeanSerializerFactory(newswebservice.Noticia.class, qn),
            new org.apache.axis.encoding.ser.BeanDeserializerFactory(newswebservice.Noticia.class, qn));

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("query");
            call.addParameter("texto", XMLType.XSD_STRING, ParameterMode.IN );
            call.setReturnType(qna);

            Noticia obj[] = (Noticia [])call.invoke(new Object [] { texto });

            for (int k=0; k < obj.length; k++) {
                Noticia n = obj[k];

                System.out.println("Titular: " + n.getTitular());
                System.out.println("Descripcion: " + n.getDescripcion());
                System.out.println("URL: " + n.getUrl());
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
