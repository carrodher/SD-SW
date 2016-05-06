package prueba;

import prueba.*;
import org.omg.CORBA.*;
import java.io.*;

public class Cliente
{
  public static void main(String args[])
  {
    try
    {
      // Iniciar el ORB
      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

      // Leer el IOR del fichero
      File IORFile = new File("IOR");
      FileReader reader = new FileReader(IORFile);
      BufferedReader buf = new BufferedReader(reader);
      String IOR = buf.readLine();

      // Convertir el IOR en un objeto
      org.omg.CORBA.Object o = orb.string_to_object(IOR);
      Calculadora calc = CalculadoraHelper.narrow(o);

      // Usar la calculadora
      System.out.println(calc.add(2.0, 3.0));
    } catch(Exception e)
    {
        e.printStackTrace();
    }
  }
}

