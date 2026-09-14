import java.util.Scanner;

public class MesesAnio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mes;

        // Validación de entrada
        do {
            System.out.print("Ingrese un número de mes (1-12): ");
            mes = sc.nextInt();
            if (mes < 1 || mes > 12) {
                System.out.println("Error: el mes debe estar entre 1 y 12.");
            }
        } while (mes < 1 || mes > 12);

        String nombre = "";
        int dias = 0;

        switch (mes) {
            case 1:  nombre = "Enero";       dias = 31; break;
            case 2:  nombre = "Febrero";     dias = 28; break;
            case 3:  nombre = "Marzo";       dias = 31; break;
            case 4:  nombre = "Abril";       dias = 30; break;
            case 5:  nombre = "Mayo";        dias = 31; break;
            case 6:  nombre = "Junio";       dias = 30; break;
            case 7:  nombre = "Julio";       dias = 31; break;
            case 8:  nombre = "Agosto";      dias = 31; break;
            case 9:  nombre = "Septiembre";  dias = 30; break;
            case 10: nombre = "Octubre";     dias = 31; break;
            case 11: nombre = "Noviembre";   dias = 30; break;
            case 12: nombre = "Diciembre";   dias = 31; break;
        }

        System.out.println("El mes es: " + nombre);
        System.out.println("Tiene " + dias + " días.");
        sc.close();
    }
}