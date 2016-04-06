package newswebservice;

import java.util.Vector;

// Clase que implementa el servidor
public class Periodico {
    private Vector noticias = null;

    public Periodico() {
        noticias = new Vector();
    }

    // Inserta nuevas noticias en la BBDD
    public void insert(Noticia n) throws Exception {
        if (n != null){
            noticias.add(n);
        }
        else {
            throw new Exception("Noticia invalida!");
        }
    }

    // Consulta la BBDD para obtener noticias cuyo titular mencione un determinado texto
    public Noticia[] query(String texto) throws Exception {
        Vector v = new Vector();

        for (int i=0; i < noticias.size(); i++) {
            Noticia n = (Noticia) noticias.get(i);

            if (n.getTitular().indexOf(texto) != -1) {
                v.add(n);
            }
        }

        if (v.size() > 0) {
            Noticia vn[] = new Noticia[v.size()];

            for (int k=0; k < v.size(); k++) {
                vn[k] = (Noticia)v.get(k);
            }

            return vn;
        }
        else {
            throw new Exception(texto + " no encontrado.");
        }
    }
}
