import java.util.Scanner;

public class EntradasCine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personas, diaSemana;
        boolean tieneMembresia;

        System.out.print("Ingrese el número de personas: ");
        personas = sc.nextInt();
        System.out.print("Ingrese el día de la semana (1=Lun, ... 7=Dom): ");
        diaSemana = sc.nextInt();
        System.out.print("¿Cuenta con membresía? (true/false): ");
        tieneMembresia = sc.nextBoolean();

        double total = 0;

        if (diaSemana == 3) {
            // Miércoles: $30 por entrada
            total = personas * 30;
        } else if (diaSemana == 4) {
            // Jueves: parejas a $75
            int parejas = personas / 2;
            int individuales = personas % 2;
            total = (parejas * 75) + (individuales * 50);
        } else {
            // Resto de días: $50 por entrada
            total = personas * 50;
        }

        // Descuento por membresía del 10%
        if (tieneMembresia) {
            total = total * 0.90;
        }

        System.out.printf("Total a pagar: $%.2f%n", total);
        sc.close();
    }
}