import java.util.ArrayList;
import java.util.List;

public abstract class Cajero {

    private String direccion;
    private int idCajero;


    public int folioOperacion = 0;
    public static final double LIMITE_RETIRO_DIARIO = 12000.00;
    public static final double LIMITE_DEPOSITO = 100000.00;

    //simula base de datos
    //num cuenta, clabe, saldo min y max


    List<Cuenta> database = new ArrayList<Cuenta>();

    public Cajero (){}

    public List<Cuenta> getDatabase() {
        return database;
    }

    public void setDatabase(List<Cuenta> database) {
        this.database = database;
    }


    public Cajero(String direccion, int idCajero, int folioOperacion) {
        this.direccion = direccion;
        this.idCajero = idCajero;
        this.folioOperacion = folioOperacion;
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


        Cuenta aux=null;

        //itera para buscar la cuenta
        for(Cuenta temp:database){

            if (temp.getNumCuenta().equals(numCuenta)){
                aux = temp;
                break;




            }

        }

        return aux;




    }


    //Metodo abstracto
    public abstract void consultarSaldo();



}
