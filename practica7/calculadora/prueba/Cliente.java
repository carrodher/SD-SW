package prueba;

import prueba.*;
import org.omg.CORBA.*;
import java.io.*;

/* Por último queda implementar el cliente que use la referencia del objeto remoto para pedir sus
servicios. En este caso, el cliente obtiene la referencia del objeto remoto usando el fichero que ha
escrito el servidor con su referencia */
public class Cliente {
    public static void main(String args[]) {
        try {
            // Iniciar el ORB (igual que el servidor)
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Leer el IOR del fichero
            File IORFile = new File("IOR");
            FileReader reader = new FileReader(IORFile);
            BufferedReader buf = new BufferedReader(reader);
            String IOR = buf.readLine();

            /* Convertir el IOR en un objeto: A partir del string que se ha leído del fichero, se obtiene la
            referencia al objeto usando el método string_to_object del orb */
            org.omg.CORBA.Object o = orb.string_to_object(IOR);
            Calculadora calc = CalculadoraHelper.narrow(o);

            // Usar la calculadora
            System.out.println(calc.add(2.0, 3.0));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
