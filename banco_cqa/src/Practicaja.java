import java.util.Date;
import java.util.Scanner;

public class Practicaja extends Cajero implements IOperacionesAvanzadas {

Scanner scan = new Scanner(System.in);


    @Override
    public void consultarsaldo() {
        //se recibe el valor para poder compararlo o buscarlo
        System.out.println("Dame el numero de cuenta");
        String ncuenta = scan.nextLine();

        //bucaremos la cuenta
        if(this.buscarCuenta(ncuenta)!=null)//el this se ocupa en este caso ya que es la forma de poder entrar a la info de buscarCuenta ya que no ve esa info por que es de otra clase
        //Lo que buscamos es que compare que el valor de buscarCuenta y si es diferente de null realizara la accion
        {
            //El ejemplo de abajo this.buscarCuenta es equivalente al aux de cuenta
            System.out.println("Tu saldo es: "+this.buscarCuenta(ncuenta).getSaldo());
        }else {
            System.out.println("La cuenta no Existe ");
        }
    }

    public Ticket retirar (String numCuenta, String nip, double monto )
    //1.-Cantidad sea menor al limite diario
    //2.- Que alcance el saldo
    //El saldo actual - el monto>minimo de la cuenta
    {
        Cuenta cuenta = null;
        Ticket ticket = null;


        cuenta = this.buscarCuenta(numCuenta);// primero debe existir la cuenta
        System.out.println(cuenta);
        if (cuenta!=null)
        //2 _Coincidir el nip
        {
            if (cuenta.getNip().equals(nip))
            {
                if(monto<=this.LIMITE_RETIRO_DIARIO)
                {
                    if (cuenta.getSaldo()>monto)
                    {
                        if(cuenta.getSaldo()-monto> cuenta.getMin())
                        {
                            cuenta.setSaldo(cuenta.getSaldo()-monto);
                            //Recalcular la posicion de la cuenta original
                            int index = this.database.indexOf(cuenta);
                            this.database.set(index, cuenta);// aqui se ocupa .set en lugar de .add ya que se agregara
                            //lo nuevo de database a la lista original reemplazandolo , no solo agregandolo, el metodo set nos
                            // pide los dos valores indez y cuenta ya que se reinserta no el valor sino toda la cuenta
                            ticket = new Ticket(this.folioOperacion=this.folioOperacion+1,this.getDireccion(),new Date(),monto,"RETIRO");
                            //new Date(); es otra forma de instanciarlo recordando que es una libreria
                            //El metodo this.folioOperacion es equivalentye a poner this.folioOperacion++, esto por que cada consulta es equivalente al numero de ticket
                        } else
                        {
                            System.out.println("El retiro no se permite cuando se excede el monto minimo");
                        }
                    }else {
                        System.out.println("Sin fondos suficientes");
                    }
                }else {
                    System.out.println("Monto excede el limite permitido");
                }
            }else
            {
                System.out.println("Nip invalido");
                System.out.println(cuenta.getNip());
                System.out.println(nip);
            }

        }else {
            System.out.println("No es posible el retiro la cuenta no existe ");
        }

        return ticket;
    }


    @Override
    public Ticket depositar(String numCuenta, double monto) {
        Cuenta cuenta = null;
        Ticket ticket = null;


        cuenta = this.buscarCuenta(numCuenta);// primero debe existir la cuenta
        System.out.println(cuenta);
        if (cuenta!=null)
        //1 _Coincidir el nip
        {//2 Validar que el monto sea menor al maximo permitido
                if(monto<this.LIMITE_DEPOSITO)
                {//3Que se pueda depositar en la cuenta
                    if (monto<=cuenta.getMax())
                    {//4 que el saldo actual+ monto < maximo permitido de la cuenta
                        if(cuenta.getSaldo()+monto< cuenta.getMax())
                        {//Entonces se depositara
                            cuenta.setSaldo(cuenta.getSaldo()+monto);
                            //Recalcular la posicion de la cuenta original
                            int index = this.database.indexOf(cuenta);
                            this.database.set(index, cuenta);// aqui se ocupa .set en lugar de .add ya que se agregara
                            //lo nuevo de database a la lista original reemplazandolo , no solo agregandolo, el metodo set nos
                            // pide los dos valores indez y cuenta ya que se reinserta no el valor sino toda la cuenta
                            ticket = new Ticket(this.folioOperacion=this.folioOperacion+1,this.getDireccion(),new Date(),monto,"DEPOSITO");
                            //new Date(); es otra forma de instanciarlo recordando que es una libreria
                            //El metodo this.folioOperacion es equivalentye a poner this.folioOperacion++, esto por que cada consulta es equivalente al numero de ticket
                        } else
                        {
                            System.out.println("El deposito no se permite cuando excede del maximo permitidpo");
                        }
                    }else {
                        System.out.println("Monto excede del maximo permitido");
                    }
                }else {
                    System.out.println("Monto excede limite mensual permitido");
                }

        }else {
            System.out.println("No es posible el deposito la cuenta no existe ");
        }
        return ticket;
    }

    @Override// aqui se puede recomendar crear mapas
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }

    @Override// aqui se puede recomendar crear mapas
    public Ticket pagarTarjeta() {
        return null;
    }
}
