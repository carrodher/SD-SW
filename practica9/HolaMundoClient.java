import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;

import javax.xml.rpc.ParameterMode;

public class HolaMundoClient
{
    public static void main(String[]args) throws Exception
    {
        // Captura los parámetros de entrada al cliente
        Options options = new Options(args);

        String endpoint = "http://localhost:" + options.getPort() +
        "/axis/HolaMundo.jws";

        /* Construye un objeto Service y un objeto Call que representan el servicio a invocar
        y una llamada o invocación a ese servicio */
        Service service = new Service();
        Call call = (Call) service.createCall();

        // Con el método setTargetEndpointAddress se establece el servidor a llamar
        call.setTargetEndpointAddress(new java.net.URL(endpoint));

        // Con el método setOperationName se indica el método a invocar
        call.setOperationName("hola");

        /* Con el método addParameter se establece un parámetro a pasar al servidor,
        indicando su nombre, su tipo (utilizando los tipos de la especificación XML
        Schema) y el modo de parámetro, en este caso se trata de un parámetro de entrada */
        call.addParameter("nombre", XMLType.XSD_STRING, ParameterMode.IN);

        // Con el método setReturnType se indica el tipo esperado como resultado
        call.setReturnType(XMLType.XSD_STRING);

        // Con el método invoke se lleva a cabo la invocación remota
        String ret = (String) call.invoke(new Object[]{ "Axis" });

        System.out.println(ret);
    }
}