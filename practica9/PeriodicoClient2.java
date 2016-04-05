// Este fichero usa las clases generadas por axis a partir del WSDL

import es.uc3m.www.WS.Periodico.*;
    import ubuntu.axis.services.Periodico.*;

    public class PeriodicoClient2 {

      public static void main(String [] args) throws Exception {

        // Crear un servicio periodico
        PeriodicoService service = new PeriodicoServiceLocator();

        // Obtener un stub que utilizaremos para invocar los métodos remotos
        Periodico port = service.getPeriodico();

        // Invocar los métodos
        Noticia n = new Noticia("Descripcion1","Titular1","URL1");
        port.insert(n);

        Noticia vn[] = port.query("Titular");

        System.out.println(vn[0].getTitular());
      }
    }

