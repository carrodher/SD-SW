package tiempoApp;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;

/* El servidor es el proceso que se queda esperando peticiones de los clientes sobre los objetos
CORBA implementados en el sirviente. El servidor es un programa Java que deja activado un
sirviente para el objeto CORBA */
public class Servidor {
    public static void main(String[]args) {
        try {
            /* Iniciar el ORB. Normalmente el ORB se implementa como una función de librería. Esta
            llamada a init realiza todas las funciones de inicialización para el ORB */
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Objeto auxiliar
            org.omg.CORBA.Object o;

            /* Encontrar y activar el POA raíz. Una vez iniciado el ORB, se usa éste para obtener la
            referencia del POA raíz mediante el método resolve_initial_references. En CORBA, los
            adaptadores de objetos se pueden configurar como una jerarquía, comenzando en el raíz.
            Una vez obtenido el POA raíz, se obtiene el POA manager que se encarga de controlar a
            un conjunto de adaptadores de objetos y se activa mediante el método activate. El método
            narrow se usa para convertir el objeto devuelto por el orb al tipo del POA raíz. Esto se
            puede ver como un cast de C */
            POA rootPOA;
            o = orb.resolve_initial_references("RootPOA");
            rootPOA = POAHelper.narrow(o);
            // Activar el POA
            rootPOA.the_POAManager().activate();

            // Crear el objeto implementación: Se crea el objeto sirviente del tipo TiempoImpl
            tiempoApp.TiempoImpl calcImpl = new tiempoApp.TiempoImpl();

            /* Registrarlo en el POA: Mediante el método servant_to_reference se obtiene una
            referencia de objeto remoto a partir del sirviente y se registra en el POA raíz */
            o = rootPOA.servant_to_reference(calcImpl);

            /* Mediante el método narrow del helper se convierte la referencia o del tipo
            Org.omg.CORBA.Object a una referencia a tiempoApp.Tiempo. Esto se puede ver de
            forma similar a un cast de C, pero algo más complejo. Este paso no es realmente
            necesario pero se muestra por completitud */
            tiempoApp.Tiempo calc = tiempoApp.TiempoHelper.narrow(o);

            /* Producir la dirección del objeto: Mediante el método object_to_string del orb se obtiene
            la referencia del objeto remoto calculadora en un string */
            String ior = orb.object_to_string(calc);
            // Imprime IOR como string en la salida estándar. String ior = orb.object_to_string(o);
            System.out.println(ior);

            /* Esperar llamadas: Por último mediante el método run del orb el servidor se pone a
            esperar peticiones de los clientes */
            orb.run();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
