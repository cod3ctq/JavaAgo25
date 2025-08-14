import java.util.Date;
import java.util.Scanner;

public class Practicaja extends Cajero implements OperacionesAvanzadas {
    Scanner scan = new Scanner(System.in);

    @Override
    public void consultarSaldo() {
        System.out.println("Ingresa el numero de cuenta");
        String ncuenta = scan.nextLine();
        //buscar cuenta
        if (this.buscarCuenta(ncuenta) != null) {
            System.out.println("Tu saldo es: " + this.buscarCuenta(ncuenta).getSaldo());
        } else {
            System.out.println("¡La cuenta indicada no existe!");
        }
    }

    public Ticket retirar(String numCuenta, String nip, double monto) {

        Cuenta cuenta = null;
        Ticket ticket = null;
        cuenta = this.buscarCuenta(numCuenta);
        //1 Debe existir la cuenta
        if (cuenta != null) {

            //2 Que el nip coincida
            if (cuenta.getNip().equals(nip)) {
                //3 Que la cantidad sea menor o igual al limite diario
                if (monto <= this.limiteRetiroDiario) {
                    //4 Que me alcance
                    if (cuenta.getSaldo() > monto) {

                        if (cuenta.getSaldo() - monto > cuenta.getMin()) {
                            //ahora si, retiro
                            cuenta.setSaldo(cuenta.getSaldo() - monto);

                            //Recalcular la posicion de la cuenta original
                            int index = this.database.indexOf(cuenta);
                            this.database.set(index, cuenta); //

                            ticket = new Ticket(this.folioOperacion = this.folioOperacion + 1, this.getDireccion(), new Date(), monto, "RETIRO");

                        } else {
                            System.out.println("El monto solicitado excede el minimo de la cuenta");
                        }
                    } else {
                        System.out.println("Saldo insuficiente");
                    }
                }
            } else {
                System.out.println("Nip invalido");
            }

        } else {
            System.out.println("No fue posible el retiro. La cuenta no existe");
        }

        //5 Que el saldo actual > minimo al permitido

        return ticket;
    }

    @Override
    public Ticket depositar(String numCuenta, double monto) {
        Cuenta cuenta = null;
        Ticket ticket = null;
        cuenta = this.buscarCuenta(numCuenta);
        //1 Debe existir la cuenta
        if (cuenta != null) {

            //2 Que el monto sea menor al maximo permitido
            if (monto < this.limite_Deposito) {  //Limite de deposito de este ejemplo
                //3 Que quepa en la cuenta
                if (monto <= cuenta.getMax()) {
                    //4 el saldo actual + monto < maximo permitido de la cuenta
                    if (cuenta.getSaldo() + monto <= cuenta.getMax()) {
                        //5 ahora si a depositar
                        cuenta.setSaldo(cuenta.getSaldo() + monto);
                        //Recalcular la posicion de la cuenta original
                        int index = this.database.indexOf(cuenta);
                        this.database.set(index, cuenta); //
                        ticket = new Ticket(this.folioOperacion = this.folioOperacion + 1, this.getDireccion(), new Date(), monto, "DEPOSITO");
                    } else {
                        System.out.println("El deposito no se permite cuando excede el monto maximo de la cuenta");
                    }
                } else {
                    System.out.println("Monto excede el maximo permitido");
                }
            } else {
                System.out.println("El monto excede el maximo permitido de deposito");
            }
        }

        //5 Que el saldo actual > minimo al permitido

        return ticket;
    }

    @Override
    public Ticket pagarServicios(String convenio, String referencia) {
        return null;
    }

    @Override
    public Ticket pagarTarjeta() {
        return null;
    }
}



