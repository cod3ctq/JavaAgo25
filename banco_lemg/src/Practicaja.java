import java.util.Date;
import java.util.Scanner;

public class Practicaja extends Cajero implements OperacionesAvanzadas {
    Scanner scan = new Scanner(System.in);

    @Override
    public void consultarSaldo() {

        System.out.println("Ingresa el numero de cuenta");
        String ncuenta = scan.nextLine();

        //vamosa buscar la cuenta
        if (this.buscarCuenta(ncuenta) != null) {

            System.out.println("Tu saldo es :" + this.buscarCuenta(ncuenta).getSaldo());

        } else {
            System.out.println("la cuenta indicada no existe");
        }

    }

    public Ticket retirar(String numCuenta, String nip, double monto) {

        Cuenta cuenta = null;
        Ticket ticket = null;

        cuenta = this.buscarCuenta(numCuenta);
        //1 debe existir la cuenta
        if (cuenta != null) {
            //2 coincidir el nip
            if (cuenta.getNip().equals(nip)) {
                //3que la cantidad sea menor al limite diario
                if (monto <= this.LIMITE_RETIRO_DIARIO) {
                    //4que me alcance
                    if (cuenta.getSaldo() > monto) {
                        //5que el saldo acutal menos el monto sea mayor que el minimo permitido de la cuenta


                        if (cuenta.getSaldo() - monto > cuenta.getMin()) {


                        } else {
                            System.out.println("eL RETIRO NO SE PERMITE CUANDO SE EXCEDE el minimo de la cuenta");
                        }
                        //6ahora si, retirar


                        cuenta.setSaldo(cuenta.getSaldo() - monto);
                        //Recalcular la posicion de la cuenta original
                        int index = this.database.indexOf(cuenta);
                        this.database.set(index, cuenta);   //reinsertando la cuenta donde estaba


                        ticket = new Ticket(this.folioOperacion = this.folioOperacion + 1, this.getDireccion(), new Date(), monto, "RETIRO");


                    } else {
                        System.out.println("Sin fondos suficientes");
                    }

                } else {
                    System.out.println("Monto excede el limite diario permitido");
                }


            } else {

                System.out.println("Nip invalido");
            }
        } else {

            System.out.println("No fue posible el retiro. La cuenta no existe");
        }


        return ticket;


    }


    @Override
    public Ticket depositar(String numCuenta, double monto) {


        Cuenta cuenta = null;
        Ticket ticket = null;

        cuenta = this.buscarCuenta(numCuenta);
        //1 debe existir la cuenta
        if (cuenta != null) {
            //

            //2que la cantidad sea menor al limite diario   //QUE EL MONTO sea menor al maximo permitido
            if (monto < this.LIMITE_DEPOSITO) {  //PAREJO PARA TODAS LAS CUENTAS
                //3 que quepa en la cuenta
                if (monto <= cuenta.getMax()) {
                    //4el saldo actual+ monto < maximo permitidi de la cuenta


                    if (cuenta.getSaldo() + monto <= cuenta.getMax()) {

                        //5ahora si, retirar


                        cuenta.setSaldo(cuenta.getSaldo() + monto);
                        //Recalcular la posicion de la cuenta original
                        int index = this.database.indexOf(cuenta);
                        this.database.set(index, cuenta);   //reinsertando la cuenta donde estaba


                        ticket = new Ticket(this.folioOperacion = this.folioOperacion + 1, this.getDireccion(), new Date(), monto, "Deposito");


                    } else {
                        System.out.println("eL deposito NO SE PERMITE CUANDO SE EXCEDE el maximo de la cuenta");
                    }


                } else {
                    System.out.println("Monto excede el maximo permitido");
                }

            } else {
                System.out.println("Monto excede el limite diario permitido");
            }


        } else {

            System.out.println("No fue posible el deposito. La cuenta no existe");
        }


        return ticket;


    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }

    @Override
    public Ticket pagarTarjeta() {
        return null;
    }
}
