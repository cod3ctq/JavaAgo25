public class Cuenta {

    private String numCuenta ;
    private String clave ;
    private double saldo;
    private double min;
    private double max;
    private String nip;

    public Cuenta(){

    }

    public Cuenta(String numCuenta, String clave, double saldo, double min, double max, String nip) {
        this.numCuenta = numCuenta;
        this.clave = clave;
        this.saldo = saldo;
        this.min = min;
        this.max = max;
        this.nip = nip;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numCuenta='" + numCuenta + '\'' +
                ", clave='" + clave + '\'' +
                ", saldo=" + saldo +
                ", min=" + min +
                ", max=" + max +
                ", nip='" + nip + '\'' +
                '}';
    }
}

