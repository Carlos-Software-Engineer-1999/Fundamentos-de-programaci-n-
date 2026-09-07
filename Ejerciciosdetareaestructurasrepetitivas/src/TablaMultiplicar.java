import java.util.Scanner;

public class TablaMultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        do {
            System.out.print("Ingrese un numero (0 para terminar): ");
            num = sc.nextInt();

            if (num != 0) {
                System.out.println("Tabla del " + num + ":");
                for (int i = 1; i <= 10; i++) {
                    System.out.println(num + " x " + i + " = " + (num * i));
                }
                System.out.println(); // Línea en blanco estética
            }
        } while (num != 0);

        sc.close();
    }
}