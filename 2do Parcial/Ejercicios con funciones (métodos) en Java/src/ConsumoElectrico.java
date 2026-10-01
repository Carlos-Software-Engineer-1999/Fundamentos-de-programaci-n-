import java.util.Scanner;

public class ConsumoElectrico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- CONTROL DE CONSUMO ELÉCTRICO ---");

        System.out.print("Ingrese la lectura anterior (kWh): ");
        double lecturaAnterior = sc.nextDouble();

        System.out.print("Ingrese la lectura actual (kWh): ");
        double lecturaActual = sc.nextDouble();

        System.out.print("¿La vivienda pertenece al programa de apoyo? (true/false): ");
        boolean tieneApoyo = sc.nextBoolean();

        // Validaciones
        double consumo = lecturaActual - lecturaAnterior;
        if (lecturaAnterior < 0 || lecturaActual < lecturaAnterior || consumo > 10000) {
            System.out.println("Error: Lecturas inválidas. La lectura actual debe ser mayor o igual a la anterior y el consumo máximo es 10,000 kWh.");
            sc.close();
            return;
        }

        // Cálculos
        double costoConsumo = calcularCostoConsumo(consumo);
        double cargoFijo = 95.0;
        double baseImponible = costoConsumo + cargoFijo;

        double descuento = calcularDescuentoApoyo(consumo, baseImponible, tieneApoyo);
        double impuesto = calcularImpuesto(baseImponible);
        double total = calcularTotal(costoConsumo, cargoFijo, descuento, impuesto);

        // Salida
        mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total);

        sc.close();
    }

    static double calcularConsumo(double lecturaAnterior, double lecturaActual) {
        return lecturaActual - lecturaAnterior;
    }

    static double calcularCostoConsumo(double consumo) {
        double costo = 0;
        if (consumo <= 150) {
            costo = consumo * 1.20;
        } else if (consumo <= 400) {
            costo = (150 * 1.20) + ((consumo - 150) * 1.80);
        } else {
            costo = (150 * 1.20) + (250 * 1.80) + ((consumo - 400) * 2.75);
        }
        return costo;
    }

    static double calcularDescuentoApoyo(double consumo, double costoAntesImpuesto, boolean tieneApoyo) {
        if (tieneApoyo && consumo <= 250) {
            return costoAntesImpuesto * 0.30;
        }
        return 0.0;
    }

    static double calcularImpuesto(double baseImponible) {
        return baseImponible * 0.16;
    }

    static double calcularTotal(double costoConsumo, double cargoFijo, double descuento, double impuesto) {
        return (costoConsumo + cargoFijo) - descuento + impuesto;
    }

    static void mostrarRecibo(double consumo, double costoConsumo, double descuento, double impuesto, double total) {
        System.out.println("\n--- RECIBO DE LUZ ---");
        System.out.println("Consumo Total: " + consumo + " kWh");
        System.out.println("Costo por Consumo: $" + costoConsumo);
        System.out.println("Cargo Fijo: $95.0");
        System.out.println("Descuento Apoyo: -$" + descuento);
        System.out.println("Impuesto (16%): $" + impuesto);
        System.out.println("TOTAL A PAGAR: $" + total);
    }
}