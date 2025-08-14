import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       // Recordemos crear el objeto c# de la clase Cuentas para agregarlos a la lista
        Cuenta c1  = new Cuenta("0123456789", "002010012345678901", 15000.50, 500.00, 20000.00, "1234");
        Cuenta c2  = new Cuenta("9876543210", "002010098765432109", 8500.75, 300.00, 15000.00, "4321");
        Cuenta c3  = new Cuenta("1122334455", "002010112233445566", 2500.00, 100.00, 5000.00, "5678");
        Cuenta c4  = new Cuenta("5566778899", "002010556677889900", 32000.90, 1000.00, 50000.00, "8765");
        Cuenta c5  = new Cuenta("1029384756", "002010102938475612", 12400.25, 200.00, 30000.00, "2468");
        Cuenta c6  = new Cuenta("5647382910", "002010564738291045", 980.60, 100.00, 5000.00, "1357");
        Cuenta c7  = new Cuenta("9081726354", "002010908172635498", 7700.10, 250.00, 15000.00, "9753");
        Cuenta c8  = new Cuenta("3141592653", "002010314159265358", 21050.00, 500.00, 40000.00, "3141");
        Cuenta c9  = new Cuenta("2718281828", "002010271828182845", 4050.75, 150.00, 8000.00, "2718");
        Cuenta c10 = new Cuenta("1928374655", "002010192837465512", 6550.40, 300.00, 12000.00, "5555");
        Cuenta c11 = new Cuenta("5647382919", "002010564738291955", 8800.90, 200.00, 15000.00, "9988");
        Cuenta c12 = new Cuenta("8192736455", "002010819273645578", 14500.35, 400.00, 25000.00, "1122");
        Cuenta c13 = new Cuenta("6372819450", "002010637281945056", 29999.99, 1000.00, 50000.00, "3344");
        Cuenta c14 = new Cuenta("4758693021", "002010475869302134", 5200.10, 200.00, 10000.00, "5566");
        Cuenta c15 = new Cuenta("1827364555", "002010182736455599", 17500.55, 500.00, 30000.00, "6677");
        Cuenta c16 = new Cuenta("7263548190", "002010726354819045", 3890.80, 150.00, 7000.00, "7788");
        Cuenta c17 = new Cuenta("9182736450", "002010918273645045", 8600.60, 300.00, 15000.00, "8899");
        Cuenta c18 = new Cuenta("4567891230", "002010456789123012", 990.90, 50.00, 3000.00, "9900");
        Cuenta c19 = new Cuenta("3456127890", "002010345612789045", 15450.75, 500.00, 25000.00, "1010");
        Cuenta c20 = new Cuenta("7894561230", "002010789456123045", 4780.20, 200.00, 8000.00, "2020");

        List<Cuenta> cuentas = new ArrayList<Cuenta>();
        //Se crea la lista y se agregamn los valores creados
        cuentas.add(c1);
        cuentas.add(c2);
        cuentas.add(c3);
        cuentas.add(c4);
        cuentas.add(c5);
        cuentas.add(c6);
        cuentas.add(c7);
        cuentas.add(c8);
        cuentas.add(c9);
        cuentas.add(c10);
        cuentas.add(c11);
        cuentas.add(c12);
        cuentas.add(c13);
        cuentas.add(c14);
        cuentas.add(c15);
        cuentas.add(c16);
        cuentas.add(c17);
        cuentas.add(c18);
        cuentas.add(c19);
        cuentas.add(c20);

//        Basico bas = new Basico();
//        bas.setDireccion("Avenida Centro");
//        bas.setIdCajero(100);
//        bas.setDatabase(cuentas);
//
//        //Probar metodo retirar
//        bas.consultarsaldo();// con este metodo consultamos saldo  al poner la cuenta correcta
//        Ticket t = bas.retirar("1928374655","5555",2000);//Creamos un objeto de lc clase ticket
//        System.out.println(t);
//        bas.setDatabase(cuentas);

        Practicaja pc = new Practicaja();
        pc.setDireccion("Boulevard");
        pc.setIdCajero(200);
        pc.setDatabase(cuentas);

        Ticket ticket = pc.depositar("1827364555",10000);
        System.out.println(ticket);
    }
}