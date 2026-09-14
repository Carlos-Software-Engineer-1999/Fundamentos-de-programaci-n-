import java.util.Scanner;

public class PresupuestoTartas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionSabor, opcionChocolate, cantidadSnack;
        String nombreCliente;
        boolean personalizar;

        double precioTarta = 0;

        System.out.println("=== PRESUPUESTO DE TARTAS ===");
        System.out.println("1. Manzana ($200)");
        System.out.println("2. Fresa ($250)");
        System.out.println("3. Chocolate");
        System.out.print("Seleccione el sabor (1-3): ");
        opcionSabor = sc.nextInt();

        switch (opcionSabor) {
            case 1:
                precioTarta = 200;
                break;
            case 2:
                precioTarta = 250;
                break;
            case 3:
                System.out.println("Tipo de chocolate:");
                System.out.println("1. Negro ($280)");
                System.out.println("2. Blanco ($300)");
                System.out.print("Seleccione (1-2): ");
                opcionChocolate = sc.nextInt();
                if (opcionChocolate == 1) precioTarta = 280;
                else if (opcionChocolate == 2) precioTarta = 300;
                else {
                    System.out.println("Opción no válida.");
                    sc.close();
                    return;
                }
                break;
            default:
                System.out.println("Opción no válida.");
                sc.close();
                return;
        }

        // Preguntar por snacks
        System.out.print("¿Cuántos snacks desea añadir? ($25 c/u): ");
        cantidadSnack = sc.nextInt();

        // Preguntar por personalización
        System.out.print("¿Desea personalizar con un nombre? (true/false): ");
        personalizar = sc.nextBoolean();

        double total = precioTarta;
        total += (cantidadSnack * 25);

        if (personalizar) {
            System.out.print("Ingrese el nombre para la tarta: ");
            nombreCliente = sc.next();
            total += 30;
            System.out.println("Se personalizará con el nombre: " + nombreCliente);
        }

        System.out.printf("PRESUPUESTO TOTAL: $%.2f%n", total);
        sc.close();
    }
}