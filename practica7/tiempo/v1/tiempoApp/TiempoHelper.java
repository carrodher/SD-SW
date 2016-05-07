package tiempoApp;


/**
* tiempoApp/TiempoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from tiempo.idl
* sábado 7 de mayo de 2016 19H06' CEST
*/

abstract public class TiempoHelper
{
  private static String  _id = "IDL:tiempoApp/Tiempo:1.0";

  public static void insert (org.omg.CORBA.Any a, tiempoApp.Tiempo that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static tiempoApp.Tiempo extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (tiempoApp.TiempoHelper.id (), "Tiempo");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static tiempoApp.Tiempo read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_TiempoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, tiempoApp.Tiempo value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static tiempoApp.Tiempo narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof tiempoApp.Tiempo)
      return (tiempoApp.Tiempo)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      tiempoApp._TiempoStub stub = new tiempoApp._TiempoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static tiempoApp.Tiempo unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof tiempoApp.Tiempo)
      return (tiempoApp.Tiempo)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      tiempoApp._TiempoStub stub = new tiempoApp._TiempoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
