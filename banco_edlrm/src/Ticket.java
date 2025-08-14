import java.util.Date;

public class Ticket {

    private int folioOperacion;
    private String ubicacion;
    private Date fechaHora;
    private double monto;
    private String tipoOperacion;

    public Ticket (){}

    public Ticket(int folioOperacion, String ubicacion, Date fechaHora, double monto, String tipoOperacion) {
        this.folioOperacion = folioOperacion;
        this.ubicacion = ubicacion;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.tipoOperacion = tipoOperacion;
    }


    public int getFolioOperacion() {
        return folioOperacion;
    }

    public void setFolioOperacion(int folioOperacion) {
        this.folioOperacion = folioOperacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "folioOperacion=" + folioOperacion +
                ", ubicacion='" + ubicacion + '\'' +
                ", fechaHora=" + fechaHora +
                ", monto=" + monto +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                '}';
    }
}
