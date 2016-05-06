package prueba;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;

public class Servidor
{
  public static void main(String[]args)
  {
    try
    {

      // Iniciar el ORB
      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
      // Objeto auxiliar
      org.omg.CORBA.Object o;

      // Encontrar el POA raiz
      POA rootPOA;
      o = orb.resolve_initial_references("RootPOA");
      rootPOA = POAHelper.narrow(o);
      // Activar el POA
      rootPOA.the_POAManager().activate();

      // Crear el objeto implmentacion
      prueba.CalculadoraImpl calcImpl = new prueba.CalculadoraImpl();
      // Registrarlo en el POA
      o = rootPOA.servant_to_reference(calcImpl);

      prueba.Calculadora calc = prueba.CalculadoraHelper.narrow(o);
      
      // Producir la direccion del objeto
      String ior = orb.object_to_string(calc);
      // String ior = orb.object_to_string(o);
      System.out.println(ior);
      
      // Esperar llamadas
      orb.run();

    } catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}

