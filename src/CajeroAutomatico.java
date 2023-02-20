import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<String> transacciones = new ArrayList<String>();
            
            double saldo = 1000; // saldo inicial

            System.out.println("\nBienvenido al cajero automático\n");

            while (true) {
                System.out.println("\nSelecciona una opción:");
                System.out.println("1. Depósito");
                System.out.println("2. Retiro");
                System.out.println("3. Mi cuenta");
                System.out.println("4. Consultar saldo");
                System.out.println("5. Salir\n");
                
                //validamos que se ingrese una opcion valida
                //con un ciclo while y el metodo hasNextInt()
                int opcion;
                while (!sc.hasNextInt()) {
                    System.out.println("\nSelecciona una opción:");
                    sc.next();
                }
                opcion = sc.nextInt();

                switch (opcion) {

                    case 1:
                    try {
                        System.out.print("\nIngresa la cantidad a depositar: $");
                        
                        double deposito = sc.nextDouble();
                            saldo += deposito;
                            //agregamos la transaccion al registro
                            transacciones.add("Depósito:\t" + deposito + "\t||\t" + new Date() + "\tSaldo:\t" + saldo);
                            System.out.println("Depósito realizado con éxito\n");
                    
                    } catch (InputMismatchException e) {
                        System.out.println("Se ha producido una excepción: " + e.getMessage());
                    } break;
                   
                    case 2:
                    try{
                        System.out.print("\nIngresa la cantidad a retirar: $");
                        double retiro = sc.nextDouble();
                        if (retiro > saldo) {
                            System.out.println("Saldo insuficiente\n");
                        } else {
                            saldo -= retiro;
                             //agregamos la transaccion al registro
                            transacciones.add("Retiro:\t" + retiro + "\t||\t" + new Date() + "\tSaldo\t: " + saldo);
                            System.out.println("Retiro realizado con éxito\n");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Se ha producido una excepción: " + e.getMessage());
                    } break;

                    case 3:
                    System.out.println("\n## MY ACCOUNT ##");
                    if (transacciones.isEmpty()) {
                        System.out.println("\nAún no hay transacciones registradas\n");
                    } else {
                            
                        System.out.println("\nREGISTRO DE TRANSACCIONES\n");
                        for (String transaccion : transacciones) {
                            System.out.println(transaccion);
                        }
                    }
                        break;
                    
                    case 4:
                        System.out.println("\nTu saldo actual es de: $" + saldo);
                        break;

                    case 5:
                        System.out.println("Gracias por utilizar nuestro cajero automático\n");
                        System.exit(0);

                    default:
                        System.out.println("Opción inválida\n");
                }
            }
        }
    }
}
