package parkingwebservice;

import java.util.Vector;
import java.util.Date;

public class Parking {
  private Vector<Coche> coches = null;

  public Parking() {
    coches = new Vector<Coche>();
  }

  // Añade un nuevo coche al vector
  public void addCoche(String matricula, Propietario propietario, String marca, String modelo, String color) throws Exception {
    if (propietario != null && matricula != null && !matricula.isEmpty() && marca != null && !marca.isEmpty() &&
    modelo != null && !modelo.isEmpty() && color != null && !color.isEmpty()){
      Coche c = new Coche();
      c.setMatricula(matricula);
      c.setPropietario(propietario);
      c.setMarca(marca);
      c.setModelo(modelo);
      c.setColor(color);
      coches.add(c);
    }
    else {
      throw new Exception("Datos inválidos");
    }
  }

  // Borra un coche del vector a partir de su matrícula
  public void delCoche(String matricula) throws Exception {
    if (matricula != null && !matricula.isEmpty()) {
      int flag = 0;   			// flag = 0 => No encontrada
      // Recorre todo el vector de coches
      for (int i = 0; i < coches.size(); i++) {
        // Coche de la iteracción i
        Coche c = coches.get(i);
        // Si el coche c (con índice i) tiene la matricula que buscamos...
        if (c.getMatricula().equals(matricula)) {
          // ... Borra este coche
          coches.removeElementAt(i);
          flag = 1;			// flag = 1 => Encontrada
        }
      }
      if (flag == 0){
        throw new Exception("Intentando borrar coche no registrado");
      }
    }
    else {
      throw new Exception("Matrícula inválida");
    }
  }

  // Indica que el coche se va a aparcar en el parking
  public void aparcar(String matricula) throws Exception {
    if (matricula != null && !matricula.isEmpty()){
      int flag = 0;   					// flag = 0 => No encontrada
      // Recorre todo el vector de coches
      for (int i = 0; i < coches.size(); i++) {
        // Coche de la iteracción i
        Coche c = coches.get(i);
        // Si el coche c (con índice i) tiene la matricula que buscamos...
        if (c.getMatricula().equals(matricula)) {
          // ... El coche ya está aparcado
          if(c.getAparcado()){
            throw new Exception("¡El coche ya está aparcado!");
          }
          else {
            c.setAparcado(true);	// Marca el coche como aparcado
            flag = 1;				// flag = 1 => Encontrada
            // Obtiene la fecha de llegada al aparcamiento
            c.setLlegada(new Date());
          }
        }
      }
      if (flag == 0) {
        throw new Exception("Intentando entrar coche no registrado");
      }
    }
    else {
      throw new Exception("Matrícula inválida");
    }
  }

  // Indica que el coche se va a salir del parking
  public double salir(String matricula) throws Exception {
    double tarifa = 0;

    if (matricula != null && !matricula.isEmpty()){
      int flag = 0;   					// flag = 0 => No encontrada
      // Recorre todo el vector de coches
      for (int i = 0; i < coches.size(); i++) {
        // Coche de la iteracción i
        Coche c = coches.get(i);
        // Si el coche c (con índice i) tiene la matricula que buscamos...
        if (c.getMatricula().equals(matricula)) {
          // ... El coche no está aparcado
          if(!c.getAparcado()){
            throw new Exception("¡El coche no está aparcado!");
          }
          else {
            c.setAparcado(false);	// Marca el coche como no aparcado
            flag = 1;				// flag = 1 => Encontrada
            // Obtiene la fecha de salida del aparcamiento
            c.setSalida(new Date());
            // Si es un usuario NO abonado...
            if(!c.getPropietario().getAbono()){
              tarificar(c);
            }
            tarifa = c.getTarificacion();
          }
        }
      }
      if (flag == 0) {
        throw new Exception("Intentando salir coche no registrado");
      }
    }
    else {
      throw new Exception("Matrícula inválida");
    }
    return tarifa;
  }

  // Calcula el coste en caso de ser usuario NO abonado
  private void tarificar(Coche c) throws Exception {
    // ... obtiene las fechas de llegada y salida y calcula la tarificacion
    Date fechaLlegada = c.getLlegada();
    Date fechaSalida = c.getSalida();
    long tiempo = (fechaSalida.getTime()-fechaLlegada.getTime())/(1000*60);
    double precio = tiempo*0.06;
    c.setTarificacion(precio);
  }

  // Devuelve un array con todos los coches asociados al titular del DNI
  public Coche[] getCochesDni(String dni) throws Exception {
    if (dni != null && !dni.isEmpty()){
      int flag = 0;   							// flag = 0 => No encontrada
      Vector<Coche> v = new Vector<Coche>();    	// Vector temporal

      // Recorre todo el vector de coches
      for (int i = 0; i < coches.size(); i++) {
        // Coche de la iteracción i
        Coche c = coches.get(i);

        // Si el propietario del coche c (con índice i) tiene el DNI que buscamos...
        if (c.getPropietario().getDni().equals(dni)) {
          // ... Añade este coche al vector temporal
          v.add(c);
          flag = 1;
        }
      }

      if (v.size() > 0) {
        Coche vc[] = new Coche[v.size()];     	// Array de coches

        for (int k = 0; k < v.size(); k++) {
          vc[k] = v.get(k);
        }

        return vc;
      }
      else {
        throw new Exception("Ningún coche asociado al DNI");
      }
    }
    else {
      throw new Exception("DNI inválido");
    }
  }

  // Devuelve el propietario de la matricula indicada
  public Propietario getPropietarioMatricula(String matricula) throws Exception {
    Propietario prop = new Propietario();

    if (matricula != null && !matricula.isEmpty()) {
      int flag = 0;   						// flag = 0 => No encontrada

      // Recorre todo el vector de coches
      for (int i = 0; i < coches.size(); i++) {
        // Coche de la iteracción i
        Coche c = coches.get(i);

        // Si el coche c tiene la matricula que buscamos...
        if (c.getMatricula().equals(matricula)) {
          // ... devuelve el propietario de este coche
          prop = c.getPropietario();
          flag = 1;
        }
      }
      if (flag == 0) {
        throw new Exception("Intentando buscar coche no registrado");
      }
      return prop;
    }
    else {
      throw new Exception("Matrícula inválida");
    }
  }
}
