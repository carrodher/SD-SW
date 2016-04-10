package bancowebservice;

public class Cuenta implements java.io.Serializable {
    private String numCuenta;
    private Titular titular;
    private int balance = 0;

    // Establece el número de cuenta
    public void setNumCuenta(String nc) {
        this.numCuenta = nc;
    }

    // Establece el titular
    public void setTitular(Titular t) {
        this.titular = t;
    }

    // Establece el balance
    public void setBalance(int b) {
        this.balance = b;
    }

    // Obtiene el número de cuenta
    public String getNumCuenta() {
        return this.numCuenta;
    }

    // Obtiene el titular
    public Titular getTitular() {
        return this.titular;
    }

    // Obtiene el balance
    public int getBalance() {
        return this.balance;
    }

    // Retira una cantidad si es posible
    public void retirar(int cantidad) throws Exception {
        if (cantidad <= balance){
            this.balance -= cantidad;
        }
        else {
            throw new Exception("Balance insuficiente!");
        }
    }

    // Ingresa una cantidad
    public void ingresar(int cantidad) {
        this.balance += cantidad;
    }
}
