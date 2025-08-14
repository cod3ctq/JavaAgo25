import java.util.ArrayList;
import java.util.List;

public abstract class Cajero {
    private String direccion;
    private int idCajero;


    public int folioOperacion = 0;
    public static final double LIMITE_RETIRO_DIARIO = 12000.00;
    public static final double LIMITE_DEPOSITO = 100000.00;

    //simula la base de datos


    //Lista de objetos de la clase cuenta
    List<Cuenta> database = new ArrayList<Cuenta>();

    public Cajero (){}

    public Cajero(String direccion, int idCajero, int folioOperacion) {
        this.direccion = direccion;
        this.idCajero = idCajero;
    }

    public List<Cuenta> getDatabase() {
        return database;
    }

    public void setDatabase(List<Cuenta> database) {
        this.database = database;
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

    public int getFolioOperacion() {
        return folioOperacion;
    }

    public void setFolioOperacion(int folioOperacion) {
        this.folioOperacion = folioOperacion;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "direccion='" + direccion + '\'' +
                ", idCajero=" + idCajero +
                ", folioOperacion=" + folioOperacion +
                '}';
    }

    //metodo no abstracto

    public Cuenta buscarCuenta(String numCuenta){
        Cuenta aux = null;
        //Itera para buscar la cuenta
        for (Cuenta temp: database){
            if (temp.getNumCuenta().equals(numCuenta)){
                aux = temp;
                break;
            }
        }

        return aux;
    }
    //metodo abstracto
    public abstract void consultarSaldo ();


}
