package tiempoApp;

import tiempoApp.*;
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
            Tiempo time = TiempoHelper.narrow(o);

            // Usar el servicio
            System.out.println("\n\tHora:     " + time.getHora());
            System.out.println("\tMinutos:  " + time.getMinutos());
            System.out.println("\tSegundos: " + time.getSegundos() + "\n");
            System.out.println("\t" + time.getHora() + ":" + time.getMinutos() + ":" + time.getSegundos());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
