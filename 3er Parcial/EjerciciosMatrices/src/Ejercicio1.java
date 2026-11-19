
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int n, m;

        do {
            System.out.print("Ingrese la cantidad de vendedores: ");
            n = entrada.nextInt();

            System.out.print("Ingrese la cantidad de zonas: ");
            m = entrada.nextInt();

            if (n <= 0 || m <= 0) {
                System.out.println("Error: las cantidades deben ser mayores que cero.");
            }
        } while (n <= 0 || m <= 0);

        int[][] ventas = new int[n][m];
        int[] totalVendedor = new int[n];
        int[] totalZona = new int[m];

        int totalGeneral = 0;

        System.out.println("\n--- CAPTURA DE VENTAS ---");

        for (int i = 0; i < n; i++) {
            System.out.println("\nVendedor " + (i + 1));

            for (int j = 0; j < m; j++) {
                int cantidad;

                do {
                    System.out.print("Computadoras vendidas en zona " + (j + 1) + ": ");
                    cantidad = entrada.nextInt();

                    if (cantidad < 0) {
                        System.out.println("Error: no se permiten cantidades negativas.");
                    }
                } while (cantidad < 0);

                ventas[i][j] = cantidad;
                totalVendedor[i] += cantidad;
                totalZona[j] += cantidad;
                totalGeneral += cantidad;
            }
        }

        System.out.println("\n--- MATRIZ DE VENTAS ---");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%8d", ventas[i][j]);
            }
            System.out.println();
        }

        int mayorZona = totalZona[0];

        for (int j = 1; j < m; j++) {
            if (totalZona[j] > mayorZona) {
                mayorZona = totalZona[j];
            }
        }

        System.out.println("\n--- ZONA CON MAYORES VENTAS ---");

        for (int j = 0; j < m; j++) {
            if (totalZona[j] == mayorZona) {
                System.out.println("Zona " + (j + 1) + ": " + totalZona[j] + " computadoras");
            }
        }

        int menorVendedor = totalVendedor[0];
        int mayorVendedor = totalVendedor[0];

        for (int i = 1; i < n; i++) {
            if (totalVendedor[i] < menorVendedor) {
                menorVendedor = totalVendedor[i];
            }

            if (totalVendedor[i] > mayorVendedor) {
                mayorVendedor = totalVendedor[i];
            }
        }

        System.out.println("\n--- VENDEDORES CON MENOS VENTAS ---");

        for (int i = 0; i < n; i++) {
            if (totalVendedor[i] == menorVendedor) {
                System.out.println("Vendedor " + (i + 1));
                System.out.println("Computadoras vendidas: " + totalVendedor[i]);
            }
        }

        System.out.println("\n--- VENDEDORES CON MAS VENTAS ---");

        for (int i = 0; i < n; i++) {
            if (totalVendedor[i] == mayorVendedor) {
                System.out.println("Vendedor " + (i + 1));
                System.out.println("Computadoras vendidas: " + totalVendedor[i]);
            }
        }

        System.out.println("\nTotal general de computadoras vendidas: " + totalGeneral);

        entrada.close();
    }
}
