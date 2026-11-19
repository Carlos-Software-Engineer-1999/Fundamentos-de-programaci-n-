
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int n, m;

        do {
            System.out.print("Ingrese la cantidad de estudiantes: ");
            n = entrada.nextInt();

            System.out.print("Ingrese la cantidad de examenes: ");
            m = entrada.nextInt();

            if (n <= 0 || m <= 0) {
                System.out.println("Las cantidades deben ser mayores que cero.");
            }
        } while (n <= 0 || m <= 0);

        entrada.nextLine();

        String[] nombres = new String[n];
        double[][] calificaciones = new double[n][m];
        double[] promedios = new double[n];
        double[] promedioExamen = new double[m];

        System.out.println("\n--- CAPTURA DE ESTUDIANTES ---");

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = entrada.nextLine();

            double suma = 0;

            for (int j = 0; j < m; j++) {
                double nota;

                do {
                    System.out.print("Calificacion del examen " + (j + 1) + ": ");
                    nota = entrada.nextDouble();

                    if (nota < 0 || nota > 10) {
                        System.out.println("La calificacion debe estar entre 0 y 10.");
                    }
                } while (nota < 0 || nota > 10);

                calificaciones[i][j] = nota;
                suma += nota;
                promedioExamen[j] += nota;
            }

            promedios[i] = suma / m;
            entrada.nextLine();
        }

        for (int j = 0; j < m; j++) {
            promedioExamen[j] /= n;
        }

        System.out.println("\n--- MATRIZ DE CALIFICACIONES ---");

        for (int i = 0; i < n; i++) {
            System.out.print(nombres[i] + ": ");

            for (int j = 0; j < m; j++) {
                System.out.printf("%.2f ", calificaciones[i][j]);
            }

            System.out.printf("| Promedio: %.2f%n", promedios[i]);
        }

        double mejorPromedio = promedios[0];

        for (int i = 1; i < n; i++) {
            if (promedios[i] > mejorPromedio) {
                mejorPromedio = promedios[i];
            }
        }

        System.out.println("\n--- ESTUDIANTE(S) CON MEJOR PROMEDIO ---");

        for (int i = 0; i < n; i++) {
            if (Math.abs(promedios[i] - mejorPromedio) < 0.000001) {
                System.out.printf("%s - %.2f%n", nombres[i], promedios[i]);
            }
        }

        int cantidadAltos = 0;
        int cantidadBajos = 0;

        for (int i = 0; i < n; i++) {
            if (promedios[i] >= 9 && promedios[i] <= 10) {
                cantidadAltos++;
            }

            if (promedios[i] < 7) {
                cantidadBajos++;
            }
        }

        String[] alumnosAltos = new String[cantidadAltos];
        double[] notasAltas = new double[cantidadAltos];

        String[] alumnosBajos = new String[cantidadBajos];
        double[] notasBajas = new double[cantidadBajos];

        int indiceAlto = 0;
        int indiceBajo = 0;

        for (int i = 0; i < n; i++) {
            if (promedios[i] >= 9 && promedios[i] <= 10) {
                alumnosAltos[indiceAlto] = nombres[i];
                notasAltas[indiceAlto] = promedios[i];
                indiceAlto++;
            }

            if (promedios[i] < 7) {
                alumnosBajos[indiceBajo] = nombres[i];
                notasBajas[indiceBajo] = promedios[i];
                indiceBajo++;
            }
        }

        System.out.println("\n--- ALUMNOS CON PROMEDIO ENTRE 9 Y 10 ---");

        if (cantidadAltos == 0) {
            System.out.println("No hay estudiantes en este rango.");
        } else {
            for (int i = 0; i < cantidadAltos; i++) {
                System.out.printf("%s - %.2f%n", alumnosAltos[i], notasAltas[i]);
            }
        }

        System.out.println("\n--- ALUMNOS CON PROMEDIO INFERIOR A 7 ---");

        if (cantidadBajos == 0) {
            System.out.println("No hay estudiantes en este rango.");
        } else {
            for (int i = 0; i < cantidadBajos; i++) {
                System.out.printf("%s - %.2f%n", alumnosBajos[i], notasBajas[i]);
            }
        }

        double mayorExamen = promedioExamen[0];
        double menorExamen = promedioExamen[0];

        for (int j = 1; j < m; j++) {
            if (promedioExamen[j] > mayorExamen) {
                mayorExamen = promedioExamen[j];
            }

            if (promedioExamen[j] < menorExamen) {
                menorExamen = promedioExamen[j];
            }
        }

        System.out.println("\n--- EXAMENES CON PROMEDIO MAS ALTO ---");

        for (int j = 0; j < m; j++) {
            if (Math.abs(promedioExamen[j] - mayorExamen) < 0.000001) {
                System.out.printf("Examen %d: %.2f%n", j + 1, promedioExamen[j]);
            }
        }

        System.out.println("\n--- EXAMENES CON PROMEDIO MAS BAJO ---");

        for (int j = 0; j < m; j++) {
            if (Math.abs(promedioExamen[j] - menorExamen) < 0.000001) {
                System.out.printf("Examen %d: %.2f%n", j + 1, promedioExamen[j]);
            }
        }

        entrada.close();
    }
}

