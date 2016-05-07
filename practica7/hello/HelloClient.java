import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

/* Por último queda implementar el cliente que use la referencia del objeto remoto para pedir sus
servicios. En este caso, el cliente obtiene la referencia al objeto servidor usando el método resolve_str del servicio de
nombrado */
public class HelloClient {
    static Hello helloImpl;

    public static void main(String args[]) {
        try {
            // Iniciar el ORB (igual que el servidor)
            ORB orb = ORB.init(args, null);

            // Obtiene la raíz del contexto naming
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            // Usa NamingContextExt que es parte de Interoperable Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resuelve la referencia a objeto en Naming
            String name = "Hello";
            helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtenido el manejador del objeto servidor: " + helloImpl);
            System.out.println(helloImpl.sayHello());

        }
        catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    }
}
