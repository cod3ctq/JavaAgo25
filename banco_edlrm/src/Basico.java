import javax.swing.*;
import java.util.Date;
import java.util.Scanner;

public class Basico extends Cajero{

    Scanner scan = new Scanner(System.in);
    private Object Ticket;

    @Override
    public void consultarSaldo() {
        System.out.println("Ingrese el numero de cuenta");
        String ncuenta = scan.nextLine();

        //buscar la cuenta
        if (this.buscarCuenta(ncuenta)!=null){
            System.out.println("Tu saldo es: "+this.buscarCuenta(ncuenta).getSaldo());
        }else {
            System.out.println("La cuenta indicada no existe!");
        }

    }


    //retirar
    //datos de entrada: num_cuenta, nip, monto
    //datos de salida: folioOperacion, ubicacion, fechaHora, monto, tipoOperacion
    public  Ticket retirar (String numCuenta, String nip, double monto) {

        Cuenta cuenta = null;
        Ticket ticket = null;
        cuenta = this.buscarCuenta(numCuenta);

        //1 debe existir la cuenta
        if (cuenta != null) {

            // 2 coincidir nip
            if (cuenta.getNip().equals(nip)) {

                // 3 que el monto sea menor o igual al limite diari
                if (monto <= this.LIMITE_RETIRO_DIARIO) {

                    // 4 que me alcance
                    if (cuenta.getSaldo() > monto) {

                        // 5 el saldo actual - monto > minimo permitido
                        if (cuenta.getSaldo() - monto > cuenta.getMin()) {

                            //ahora si retirar
                            cuenta.setSaldo(cuenta.getSaldo() - monto);

                            //Recalcular la posicion de la cuenta original
                            int index = this.database.indexOf(cuenta);
                            this.database.set(index, cuenta); //reinsertando la cuenta donde estaba

                            ticket = new Ticket(this.folioOperacion = this.folioOperacion + 1, getDireccion(), new Date(), monto, "RETIRO");


                        } else {
                            System.out.println("El retiro no se permite cuando se excede el minimo de la cuenta");
                        }

                    } else {
                        System.out.println("Sin fondos suficientes");
                    }
                } else {
                    System.out.println("Monto excede el limite diario permitido");
                }
            } else {
                System.out.println("Nip invalido");
            }

        }else{
                System.out.println("No fue posible el retiro, la cuenta no existe");
        }

        return ticket;
        }


    }
