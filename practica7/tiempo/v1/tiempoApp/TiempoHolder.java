package tiempoApp;

/**
* tiempoApp/TiempoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from tiempo.idl
* sábado 7 de mayo de 2016 19H06' CEST
*/

public final class TiempoHolder implements org.omg.CORBA.portable.Streamable
{
  public tiempoApp.Tiempo value = null;

  public TiempoHolder ()
  {
  }

  public TiempoHolder (tiempoApp.Tiempo initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = tiempoApp.TiempoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    tiempoApp.TiempoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return tiempoApp.TiempoHelper.type ();
  }

}
