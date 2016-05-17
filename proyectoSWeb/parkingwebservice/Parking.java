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
			int flag = 0;   			// flag = 0 => No encontrada
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
						c.setAparcado(true);
						flag = 1;			// flag = 1 => Encontrada
						//Obtiene la fecha de llegada al aparcamiento
						c.setLlegada(new Date());
					}
				}
			}
			if (flag == 0) {
				throw new Exception("Intentando acceder coche no registrado");
			}
		}
		else {
			throw new Exception("Matrícula inválida");
		}
	}

    // Indica que el coche se va a salir del parking
    public void salir(String matricula) throws Exception {
        if (matricula != null){
            int flag = 0;   // flag = 1 => Encontrada

            // Recorre todo el vector de coches
            for (int i=0; i < coches.size(); i++) {
                // Cuenta de la iteracción i
                Coche c = coches.get(i);

                // Si el cooche c tiene la matricula que buscamos...
                if (c.getMatricula().equals(matricula)) {

                    // ... El coche no está aparcado
                    if(!c.getAparcado()){
                      throw new Exception("¡El coche no está aparcado!");
                    } else {
                      c.setAparcado(false);
                      flag = 1;
                      //Obtiene la fecha de llegada al aparcamiento
                      c.setSalida(new Date());
                      if(!c.getPropietario().getPlaza()){
                        tarificar(matricula);
                      }
                    }
                }
            }

            if (flag == 0) {
                throw new Exception("¡El coche no existe!");
            }
        } else {
            throw new Exception("Coche inválido");
        }
    }

    // Retira una cantidad de la cuenta indicada
    public void tarificar(String matricula) throws Exception {
        if (matricula != null){
            int flag = 0;   // flag = 1 => Encontrada

            // Recorre todo el vector de coches
            for (int i=0; i < coches.size(); i++) {
                // Coche de la iteracción i
                Coche c = coches.get(i);

                // Si el coche c tiene la matricula que buscamos...
                if (c.getMatricula().equals(matricula)) {
                    // ... obtiene las fechas de llegada y salida y calcula la tarificacion si el propietario no tiene plaza alquilada
                    if(!c.getPropietario().getPlaza()){
                      Date fechaLlegada = c.getLlegada();
                      Date fechaSalida = c.getSalida();
                      int tiempo = calculaTiempo(fechaLlegada, fechaSalida);
                      double precio = calculaPrecio(tiempo);
                      c.setTarificacion(precio);
                    }
                    flag = 1;
                }
            }

            if (flag == 0) {
                throw new Exception("¡El coche no existe!");
            }
        }
        else {
            throw new Exception("Cuenta inválida");
        }
    }

    //Devuelve el tiempo en minutos desde que el coche entra hasta que sale
    public int calculaTiempo (Date fechaLlegada, Date fechaSalida){
      long diferenciaEn_ms = fechaSalida.getTime() - fechaLlegada.getTime();
      long minutos = diferenciaEn_ms / (1000 * 60 );
      return (int) minutos;
    }

    //Devuelve el precio a pagar por el tiempo que se ha permanecido en el parking
    public double calculaPrecio (int tiempo){
      double precio = (tiempo * 0.06);
      return precio;
    }

    // Devuelve un array con todos los coches asociados al titular del DNI
    public Coche[] cochesDelPropietario(String dni) throws Exception {
        if (dni != null){
            int flag = 0;   // flag = 1 => Encontrada

            Vector<Coche> v = new Vector<Coche>();    // Vector temporal

            // Recorre todo el vector de coches
            for (int i=0; i < coches.size(); i++) {
                // Coche de la iteracción i
                Coche c = coches.get(i);

                // Si el coche c tiene el DNI que buscamos...
                if (c.getPropietario().getDni().equals(dni)) {
                    // ... Añade este coche al vector
                    v.add(c);
                    flag = 1;
                }
            }

            if (v.size() > 0) {
                Coche vc[] = new Coche[v.size()];     // Array de cuentas

                for (int k = 0; k < v.size(); k++) {
                    vc[k] = v.get(k);
                }
                return vc;
            } else {
                throw new Exception("¡El DNI no existe!");
            }
        } else {
            throw new Exception("DNI inválido");
        }
    }

    // Devuelve el propietario de la matricula indicada
    public Propietario propietarioDeCoche(String matricula) throws Exception {
        Propietario prop = new Propietario();

        if (matricula != null){
            int flag = 0;   // flag = 1 => Encontrada

            // Recorre todo el vector de coches
            for (int i=0; i < coches.size(); i++) {
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
                throw new Exception("¡El coche no existe!");
            }
            return prop;
        } else {
            throw new Exception("Coche inválido.");
        }
    }
}
