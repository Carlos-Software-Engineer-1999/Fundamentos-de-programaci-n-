import java.util.Scanner;

public class MenuAreas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("=== CÁLCULO DE ÁREAS ===");
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectángulo");
        System.out.println("3. Triángulo");
        System.out.println("4. Círculo");
        System.out.print("Seleccione una opción (1-4): ");
        opcion = sc.nextInt();

        double area = 0;

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el lado del cuadrado: ");
                double lado = sc.nextDouble();
                area = lado * lado;
                break;
            case 2:
                System.out.print("Ingrese la base: ");
                double base = sc.nextDouble();
                System.out.print("Ingrese la altura: ");
                double altura = sc.nextDouble();
                area = base * altura;
                break;
            case 3:
                System.out.print("Ingrese la base: ");
                double baseT = sc.nextDouble();
                System.out.print("Ingrese la altura: ");
                double alturaT = sc.nextDouble();
                area = (baseT * alturaT) / 2;
                break;
            case 4:
                System.out.print("Ingrese el radio: ");
                double radio = sc.nextDouble();
                area = Math.PI * radio * radio;
                break;
            default:
                System.out.println("Opción no válida.");
                sc.close();
                return;
        }

        System.out.printf("El área calculada es: %.2f%n", area);
        sc.close();
    }
}