import java.util.ArrayList;
import java.util.List;

public abstract class Cajero {

    private String direccion;
    private int idCajero;

    public static int folioOperacion=0;
    public static final double LIMITE_RETIRO_DIARIO = 12000.00;
    public static final double LIMITE_DEPOSITO = 100000.00;


    //Simulamos una base de datos con lustas
    //num_cuenta, clabe. saldo , min, max

    List<Cuenta> database = new ArrayList<Cuenta>();//Creamos una lista donde se va a almacenar los valores


    public Cajero()
    {}

    public Cajero(String direccion, int idCajero) {
        this.direccion = direccion;
        this.idCajero = idCajero;
    }

    public List<Cuenta>getDatabase()
    {
        return database;
    }

    public void setDatabase(List<Cuenta>database)
    {
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

    public static int getFolioOperacion() {
        return folioOperacion;
    }

    public static void setFolioOperacion(int folioOperacion) {
        Cajero.folioOperacion = folioOperacion;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "direccion='" + getDireccion() + '\'' +
                ", idCajero=" + getIdCajero() +
                '}';
    }

    //metodo no abstracto

    public Cuenta buscarCuenta (String numCuenta)// se cambia  el public void a public Cuenta
    // ya que no esperamos no regrese vacio sino la info de la cuenta
    {//Iterar para buscar cuenta
        Cuenta aux = null;//Esto se pone para que  en caso de no encontrar un dato en aux aun asi regrese null y no se quede vacio

        for (Cuenta temp : database) {//Buscara de tu variable temp, comparando la info de lo obtenido con la variable numCuenta
            if (temp.getNumCuenta().equals(numCuenta)) {
                aux = temp;
                break;// se habilita un break; para que pare el forech al encontrar el valor
            }
        }
        return aux;
    }

    public abstract void consultarsaldo();




}
