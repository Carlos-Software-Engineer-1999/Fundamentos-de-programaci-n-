import java.util.Scanner;

public class TiendaEnLinea {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- SISTEMA DE COBRO TIENDA EN LÍNEA ---");

        System.out.print("Ingrese el precio del producto 1: $");
        double precio1 = sc.nextDouble();
        System.out.print("Ingrese la cantidad del producto 1: ");
        int cant1 = sc.nextInt();

        System.out.print("Ingrese el precio del producto 2: $");
        double precio2 = sc.nextDouble();
        System.out.print("Ingrese la cantidad del producto 2: ");
        int cant2 = sc.nextInt();

        System.out.print("Ingrese el precio del producto 3: $");
        double precio3 = sc.nextDouble();
        System.out.print("Ingrese la cantidad del producto 3: ");
        int cant3 = sc.nextInt();

        System.out.print("Ingrese el tipo de cliente (1 = Regular, 2 = Frecuente): ");
        int tipoCliente = sc.nextInt();

        System.out.print("Ingrese el código postal (5 dígitos): ");
        String codigoPostal = sc.next();

        // Validaciones
        if (precio1 <= 0 || precio2 <= 0 || precio3 <= 0 ||
                cant1 <= 0 || cant2 <= 0 || cant3 <= 0 ||
                (tipoCliente != 1 && tipoCliente != 2) ||
                codigoPostal.length() != 5) {
            System.out.println("Error: Datos inválidos. Verifique precios, cantidades, tipo de cliente o código postal.");
            sc.close();
            return;
        }

        // Cálculos
        double sub1 = calcularSubtotalProducto(precio1, cant1);
        double sub2 = calcularSubtotalProducto(precio2, cant2);
        double sub3 = calcularSubtotalProducto(precio3, cant3);
        double subtotalGeneral = calcularSubtotalGeneral(sub1, sub2, sub3);

        double descuento = calcularDescuento(subtotalGeneral, tipoCliente);
        double envio = calcularEnvio(subtotalGeneral, codigoPostal);
        double subtotalConDescuento = subtotalGeneral - descuento;
        double impuesto = calcularImpuesto(subtotalConDescuento);

        double total = calcularTotal(subtotalGeneral, descuento, impuesto, envio);

        // Salida
        System.out.println("\n--- RESUMEN DE COMPRA ---");
        System.out.println("Subtotal General: $" + subtotalGeneral);
        System.out.println("Descuento: -$" + descuento);
        System.out.println("Envío: $" + envio);
        System.out.println("Impuesto (16%): $" + impuesto);
        System.out.println("Total a Pagar: $" + total);

        sc.close();
    }

    static double calcularSubtotalProducto(double precio, int cantidad) {
        return precio * cantidad;
    }

    static double calcularSubtotalGeneral(double subtotal1, double subtotal2, double subtotal3) {
        return subtotal1 + subtotal2 + subtotal3;
    }

    static double calcularDescuento(double subtotal, int tipoCliente) {
        if (tipoCliente == 2) {
            return subtotal * 0.10;
        }
        return 0.0;
    }

    static double calcularEnvio(double subtotal, String codigoPostal) {
        if (subtotal < 1000) {
            return 150.0;
        } else if (subtotal < 3000) {
            return 80.0;
        } else {
            return 0.0;
        }
    }

    static double calcularImpuesto(double subtotalConDescuento) {
        return subtotalConDescuento * 0.16;
    }

    static double calcularTotal(double subtotal, double descuento, double impuesto, double envio) {
        return subtotal - descuento + impuesto + envio;
    }
}