package bancowebservice;

import java.util.Vector;

public class Banco {
    private Vector<Cuenta> cuentas = null;

    public Banco() {
        cuentas = new Vector<Cuenta>();
    }

    // Crea una nueva cuenta a partir de un número de cuenta y su titular y la añade al vector
    public void crearCuenta(String numCuenta, Titular titular) throws Exception {
        if (titular != null){
            Cuenta c = new Cuenta();
            c.setNumCuenta(numCuenta);
            c.setTitular(titular);
            cuentas.add(c);
        }
        else {
            throw new Exception("Titular inválido!");
        }
    }

    // Cierra una cuenta a partir de su número de cuenta
    public void cerrarCuenta(String numCuenta) throws Exception {
        if (numCuenta != null){
            int flag = 0;   // flag = 1 => Encontrada

            // Recorre todo el vector de cuentas
            for (int i=0; i < cuentas.size(); i++) {
                // Cuenta de la iteracción i
                Cuenta c = cuentas.get(i);

                // Si la cuenta c (con índice i) tiene el número de cuenta que buscamos...
                if (c.getNumCuenta().equals(numCuenta)) {
                    // ... Elimina esta cuenta
                    cuentas.removeElementAt(i);
                    flag = 1;
                }
            }

            if (flag == 0){
                throw new Exception("La cuenta no existe!");
            }
        }
        else {
            throw new Exception("Cuenta inválida.");
        }
    }

    // Ingresa una cantidad en la cuenta indicada
    public void ingresar(String numCuenta, int cantidad) throws Exception {
        if (numCuenta != null){
            int flag = 0;   // flag = 1 => Encontrada

            // Recorre todo el vector de cuentas
            for (int i=0; i < cuentas.size(); i++) {
                // Cuenta de la iteracción i
                Cuenta c = cuentas.get(i);

                // Si la cuenta c tiene el número de cuenta que buscamos...
                if (c.getNumCuenta().equals(numCuenta)) {
                    // ... Ingresa cantidad en esta cuenta
                    c.ingresar(cantidad);
                    flag = 1;
                }
            }

            if (flag == 0) {
                throw new Exception("La cuenta no existe!");
            }
        }
        else {
            throw new Exception("Cuenta inválida");
        }
    }

    // Retira una cantidad de la cuenta indicada
    public void retirar(String numCuenta, int cantidad) throws Exception {
        if (numCuenta != null){
            int flag = 0;   // flag = 1 => Encontrada

            // Recorre todo el vector de cuentas
            for (int i=0; i < cuentas.size(); i++) {
                // Cuenta de la iteracción i
                Cuenta c = cuentas.get(i);

                // Si la cuenta c tiene el número de cuenta que buscamos...
                if (c.getNumCuenta().equals(numCuenta)) {
                    // ... retira cantidad en esta cuenta
                    c.retirar(cantidad);
                    flag = 1;
                }
            }

            if (flag == 0) {
                throw new Exception("La cuenta no existe!");
            }
        }
        else {
            throw new Exception("Cuenta inválida");
        }
    }

    // Devuelve un array con todas las cuentas asociadas al titular del DNI pasado
    public Cuenta[] cuentasDelTitular(String dni) throws Exception {
        if (dni != null){
            int flag = 0;   // flag = 1 => Encontrada

            Vector<Cuenta> v = new Vector<Cuenta>();    // Vector temporal

            // Recorre todo el vector de cuentas
            for (int i=0; i < cuentas.size(); i++) {
                // Cuenta de la iteracción i
                Cuenta c = cuentas.get(i);

                // Si la cuenta c tiene el DNIque buscamos...
                if (c.getTitular().getDni().equals(dni)) {
                    // ... Añade esta cuenta al vector
                    v.add(c);
                    flag = 1;
                }
            }

            if (v.size() > 0) {
                Cuenta vc[] = new Cuenta[v.size()];     // Array de cuentas

                for (int k=0; k < v.size(); k++) {
                    vc[k] = v.get(k);
                }

                return vc;
            }
            else {
                throw new Exception("El DNI no existe!");
            }
        }
        else {
            throw new Exception("DNI inválido");
        }
    }

    // Devuelve el titular de la cuenta indicada
    public Titular titularDeCuenta(String numCuenta) throws Exception {
        Titular tit = new Titular();

        if (numCuenta != null){
            int flag = 0;   // flag = 1 => Encontrada

            // Recorre todo el vector de cuentas
            for (int i=0; i < cuentas.size(); i++) {
                // Cuenta de la iteracción i
                Cuenta c = cuentas.get(i);

                // Si la cuenta c tiene el número de cuenta que buscamos...
                if (c.getNumCuenta().equals(numCuenta)) {
                    // ... retira cantidad en esta cuenta
                    tit = c.getTitular();
                    flag = 1;
                }
            }
            if (flag == 0) {
                throw new Exception("La cuenta no existe!");
            }

            return tit;
        }
        else {
            throw new Exception("Cuenta inválida");
        }
    }
}
