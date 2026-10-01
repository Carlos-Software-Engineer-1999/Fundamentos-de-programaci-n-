import java.util.Scanner;

public class SeguroAuto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- COTIZACIÓN DE SEGURO DE AUTOMÓVIL ---");

        System.out.print("Ingrese el valor del vehículo: $");
        double valorVehiculo = sc.nextDouble();

        System.out.print("Ingrese la edad del conductor: ");
        int edad = sc.nextInt();

        System.out.print("Ingrese la cantidad de accidentes reportados: ");
        int accidentes = sc.nextInt();

        System.out.print("¿Cuenta con sistema de seguridad adicional? (true/false): ");
        boolean tieneSeguridad = sc.nextBoolean();

        // Validaciones
        if (valorVehiculo <= 0 || edad < 18 || edad > 100 || accidentes < 0) {
            System.out.println("Error: Datos inválidos. Verifique el valor del vehículo, la edad (18-100) y los accidentes (>=0).");
            sc.close();
            return;
        }

        // Cálculos
        double tarifaBase = calcularTarifaBase(valorVehiculo);
        double recargoEdad = calcularRecargoPorEdad(tarifaBase, edad);
        double recargoAccidentes = calcularRecargoPorAccidentes(tarifaBase, accidentes);
        double subtotal = tarifaBase + recargoEdad + recargoAccidentes;
        double descuento = calcularDescuentoSeguridad(subtotal, tieneSeguridad);
        double costoFinal = calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento);

        // Salida
        System.out.println("\n--- RESUMEN DE COTIZACIÓN ---");
        System.out.println("Tarifa Base (4%): $" + tarifaBase);
        System.out.println("Recargo por Edad: $" + recargoEdad);
        System.out.println("Recargo por Accidentes: $" + recargoAccidentes);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento por Seguridad: -$" + descuento);
        System.out.println("Costo Final Anual: $" + costoFinal);

        sc.close();
    }

    static double calcularTarifaBase(double valorVehiculo) {
        return valorVehiculo * 0.04;
    }

    static double calcularRecargoPorEdad(double tarifaBase, int edad) {
        if (edad < 25) {
            return tarifaBase * 0.20;
        } else if (edad > 60) {
            return tarifaBase * 0.10;
        }
        return 0.0;
    }

    static double calcularRecargoPorAccidentes(double tarifaBase, int accidentes) {
        return tarifaBase * 0.08 * accidentes;
    }

    static double calcularDescuentoSeguridad(double subtotal, boolean tieneSeguridad) {
        if (tieneSeguridad) {
            return subtotal * 0.05;
        }
        return 0.0;
    }

    static double calcularCostoFinal(double tarifaBase, double recargoEdad,
                                     double recargoAccidentes, double descuento) {
        return tarifaBase + recargoEdad + recargoAccidentes - descuento;
    }
}