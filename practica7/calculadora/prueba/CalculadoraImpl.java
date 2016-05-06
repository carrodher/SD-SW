package prueba;

import prueba.*;

class CalculadoraImpl extends CalculadoraPOA
{
  private double memoria_;
  public CalculadoraImpl()
  {
    memoria_ = 0;
  }
  public double add(double x, double y)
  {
    return x + y;
  }

  public double substract(double x, double y)
  {
    return x - y;
  }
  public double multiply(double x, double y)
  {
    return x * y;
  }

  public double divide(double x, double y)
  {
    double result = 0;

    try
    {
      result = x / y;
    } catch(Exception e)
    {
    }

    return result;
  }
  public void storeMemory(double x)
  {
    memoria_ = x;
  }

  public double readMemory()
  {
    return memoria_;
  }
}

