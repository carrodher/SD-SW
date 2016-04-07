package agendawebservice;

import java.util.Vector;

// Clase que implementa el servidor
public class Agenda {
    private Vector telefonos = null;

    public Agenda() {
        telefonos = new Vector();
    }

    // Inserta nuevas telefonos en la BBDD
    public void insert(Telefono tlf) throws Exception {
        if (tlf != null){
            telefonos.add(tlf);
        }
        else {
            throw new Exception("Telefono inválido!");
        }
    }

    // Consulta la BBDD para obtener telefonos con un texto concreto
    public Telefono[] query(String texto) throws Exception {
        Vector v = new Vector();

        for (int i=0; i < telefonos.size(); i++) {
            Telefono tlf = (Telefono) telefonos.get(i);

            if (tlf.getNombre().indexOf(texto) != -1) {
                v.add(tlf);
            }
        }

        if (v.size() > 0) {
            Telefono vn[] = new Telefono[v.size()];

            for (int k=0; k < v.size(); k++) {
                vn[k] = (Telefono)v.get(k);
            }

            return vn;
        }
        else {
            throw new Exception(texto + " no encontrado.");
        }
    }
}
