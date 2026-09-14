import java.util.Scanner;

public class CalculadoraBasica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        char operador;

        System.out.print("Ingrese el primer número entero: ");
        num1 = sc.nextInt();
        System.out.print("Ingrese el segundo número entero: ");
        num2 = sc.nextInt();
        System.out.print("Ingrese el operador (+, -, *, /): ");
        operador = sc.next().charAt(0);

        double resultado = 0;
        boolean valido = true;

        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: división por cero no permitida.");
                    valido = false;
                } else {
                    resultado = (double) num1 / num2;
                }
                break;
            default:
                System.out.println("Error: operador no válido.");
                valido = false;
        }

        if (valido) {
            System.out.printf("Resultado: %.2f%n", resultado);
        }
        sc.close();
    }
}