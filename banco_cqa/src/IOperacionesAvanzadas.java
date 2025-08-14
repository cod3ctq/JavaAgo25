public interface IOperacionesAvanzadas {
    Ticket depositar(String  numCuenta,double monto);
    Ticket pagarServicio(String convenio, String referencia);
    Ticket pagarTarjeta();




}
