import java.util.Date;
import java.util.Scanner;

public class Practicaja extends Cajero implements OperacionesAvanzadas{
    Scanner scan = new Scanner(System.in);

    @Override
    public void consultarSaldo() {
        System.out.println("Ingresa el numero de cuenta");
        String ncuenta = scan.nextLine();
        //buscar la cuenta
        if(this.buscarCuenta(ncuenta)!=null){
            System.out.println("Tu saldo es: "+this.buscarCuenta(ncuenta).getSaldo());
        }else{
            System.out.println("La cuenta indicada no existe!");
        }
    }


    public Ticket retirar(String numCuenta, String nip, double monto){
        Cuenta cuenta = null;
        Ticket ticket = null;
        cuenta = this.buscarCuenta(numCuenta);
        //1debe exitir la cuenta
        if(cuenta!=null){
            //2coincidir el nip
            if(cuenta.getNip().equals(nip)){
                //3 que el monto sea menor o igual al limite diario
                if(monto <= this.LIMITE_RETIRO_DIARIO){
                    //4 que me alcance
                    if(cuenta.getSaldo() > monto){
                        //5 el saldo actual - monto > minimo permitido de la cuenta
                        if(cuenta.getSaldo() - monto > cuenta.getMin()){
                            // ahora si, retirar
                            cuenta.setSaldo(  cuenta.getSaldo() - monto );
                            //Recalcular la posicion de la cuenta original
                            int i = this.database.indexOf(cuenta);
                            this.database.set(i, cuenta); //reinsertando la cuenta donde estaba
                            ticket = new Ticket(this.folioOperacion = this.folioOperacion +  1,this.getDireccion(),
                                    new Date(), monto, "RETIRO");
                        }else{
                            System.out.println("El retiro no se permite cuando se excede el minimo de la cuenta");
                        }
                    }else{
                        System.out.println("Sin fondos suficientes");
                    }
                }else{
                    System.out.println("Monto excede el limite diario permmitido");
                }
            }else{
                System.out.println("Nip invalido");
            }
        }else{
            System.out.println("No fue posible el retiro. La cuenta no existe!");
        }
        return ticket;
    }


    @Override
    public Ticket depositar(String numCuenta, double monto) {
        Cuenta cuenta = null;
        Ticket ticket = null;
        cuenta = this.buscarCuenta(numCuenta);
        //1debe exitir la cuenta
        if(cuenta!=null){
                //2 que el monto sea menor al maximo permitido
                if(monto < this.LIMITE_DEPOSITO){ //todas las cuentas
                    //3 que quepa en la cuenta
                    if( monto <= cuenta.getMax()){
                        //4 el saldo actual + monto < maximo permitido de la cuenta
                        if(cuenta.getSaldo() + monto <= cuenta.getMax()){
                            // ahora si, depositar
                            cuenta.setSaldo(  cuenta.getSaldo() + monto );
                            //Recalcular la posicion de la cuenta original
                            int i = this.database.indexOf(cuenta);
                            this.database.set(i, cuenta); //reinsertando la cuenta donde estaba
                            ticket = new Ticket(this.folioOperacion = this.folioOperacion +  1,this.getDireccion(),
                                    new Date(), monto, "DEPOSITO");
                        }else{
                            System.out.println("El deposito no se permite cuando se excede el maximo de la cuenta");
                        }
                    }else{
                        System.out.println("Monto excede el maximo permitido");
                    }
                }else{
                    System.out.println("Monto excede el limite mensual permmitido");
                }

        }else{
            System.out.println("No fue posible el deposito. La cuenta no existe!");
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
