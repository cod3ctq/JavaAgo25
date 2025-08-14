import java.util.ArrayList;
import java.util.List;

public abstract class Cajero {

    private String direccion;
    private int idCajero;

    public static int folioOperacion = 0;
    public static final double limiteRetiroDiario = 12000.00;
    public static final double limite_Deposito = 100000.00;

    //simula la base de datos
    //numero de cuenta, saldo, tipo de id, cliente

    List<Cuenta> database = new ArrayList<Cuenta>();

    public List<Cuenta> getDatabase() {
        return database;
    }

    public void setDatabase(List<Cuenta> database) {
        this.database = database;
    }

    public Cajero() {

    }
    public Cajero(String direccion, int idCajero) {
        this.direccion = direccion;
        this.idCajero = idCajero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public static int getFolioOperacion() {
        return folioOperacion;
    }

    public static void setFolioOperacion(int folioOperacion) {
        Cajero.folioOperacion = folioOperacion;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "direccion='" + direccion + '\'' +
                ", idCajero=" + idCajero +
                '}';
    }

    //metodo no abstracto
    public Cuenta buscarCuenta(String numCuenta) {
        Cuenta aux = null;

        //Itera para buscar la cuenta
        for (Cuenta temp : database) {
            if (temp.getNumCuenta().equals(numCuenta)) {
                aux = temp;
                break;
            }
        }
        return aux;
    }

    //Metodo abstracto
    public abstract void consultarSaldo();

}












