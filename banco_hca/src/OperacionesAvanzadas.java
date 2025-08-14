public interface OperacionesAvanzadas {

    Ticket depositar (String numCuenta, double monto);
    Ticket pagarServicios (String convenio, String referencia);
    Ticket pagarTarjeta();




}
