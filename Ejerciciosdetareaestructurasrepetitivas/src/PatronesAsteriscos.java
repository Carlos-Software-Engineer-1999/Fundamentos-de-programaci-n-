import java.util.Scanner;

public class PatronesAsteriscos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño n (impar): ");
        int n = sc.nextInt();

        // FIGURA 1: CUADRADO
        System.out.println("\nFigura 1: Cuadrado");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // FIGURA 2: PIRÁMIDE INVERTIDA
        System.out.println("\nFigura 2: Pirámide Invertida");
        for (int i = n; i >= 1; i -= 2) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // FIGURA 3: ROMBO
        System.out.println("\nFigura 3: Rombo");
        // Parte superior
        for (int i = 1; i <= n; i += 2) {
            for (int esp = 1; esp <= (n - i) / 2; esp++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Parte inferior
        for (int i = n - 2; i >= 1; i -= 2) {
            for (int esp = 1; esp <= (n - i) / 2; esp++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}