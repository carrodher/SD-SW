import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

// Implementa el método sayHello()
class HelloImpl extends HelloPOA {
    public String sayHello() {
        return "\nHello world!!\n";
    }
}

/* El servidor es el proceso que se queda esperando peticiones de los clientes sobre los objetos
CORBA implementados en el sirviente. El servidor es un programa Java que deja activado un
sirviente para el objeto CORBA */
public class HelloServer {
    public static void main(String args[]) {
        try {
            /* Iniciar el ORB. Normalmente el ORB se implementa como una función de librería. Esta
            llamada a init realiza todas las funciones de inicialización para el ORB */
            ORB orb = ORB.init(args, null);

            /* Encontrar y activar el POA raíz. Una vez iniciado el ORB, se usa éste para obtener la
            referencia del POA raíz mediante el método resolve_initial_references. En CORBA, los
            adaptadores de objetos se pueden configurar como una jerarquía, comenzando en el raíz.
            Una vez obtenido el POA raíz, se obtiene el POA manager que se encarga de controlar a
            un conjunto de adaptadores de objetos y se activa mediante el método activate. El método
            narrow se usa para convertir el objeto devuelto por el orb al tipo del POA raíz. Esto se
            puede ver como un cast de C */
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            HelloImpl helloImpl = new HelloImpl();

            /* Registrarlo en el POA: Mediante el método servant_to_reference se obtiene una
            referencia de objeto remoto a partir del sirviente y se registra en el POA raíz */
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);

            /* Mediante el método narrow del helper se convierte la referencia del tipo
            Org.omg.CORBA.Object a una referencia a Hello. Esto se puede ver de
            forma similar a un cast de C, pero algo más complejo. Este paso no es realmente
            necesario pero se muestra por completitud */
            Hello href = HelloHelper.narrow(ref);


            /* Una vez obtenida la referencia al objeto se enlaza en el servicio
            de nombrado (clase NamingContextExt) mediante el método rebind. La referencia al servicio de
            nombrado se obtiene mediante el método resolve_initial_reference del ORB */

            // Obitnene el contexto raíz. NameService invoca al nombre del servicio
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            // Usa NamingContextExt que es parte de Interoperable Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Hello";
            NameComponent path[] = ncRef.to_name( name );
            ncRef.rebind(path, href);

            System.out.println("HelloServer listo y esperando...");

            /* Esperar llamadas: Por último mediante el método run del orb el servidor se pone a
            esperar peticiones de los clientes */
            orb.run();
        }
        catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
