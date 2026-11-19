import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class Estudiante {
    String matricula;
    String nombre;
    double calificacion;

    public Estudiante(String matricula, String nombre, double calificacion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }
}

public class SistemaEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Estudiante> lista = new LinkedList<>();
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE ESTUDIANTES ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar todos (Orden alfabético)");
            System.out.println("3. Buscar por matrícula");
            System.out.println("4. Modificar calificación");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Mostrar promedio general");
            System.out.println("7. Mostrar calificación más alta y baja");
            System.out.println("8. Mostrar estudiantes con calificación > 9");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Matrícula: ");
                    String mat = sc.nextLine();
                    // Validar duplicados
                    boolean existe = false;
                    for (Estudiante e : lista) {
                        if (e.matricula.equals(mat)) { existe = true; break; }
                    }
                    if (existe) {
                        System.out.println("❌ Error: La matrícula ya está registrada.");
                    } else {
                        System.out.print("Nombre: ");
                        String nom = sc.nextLine();
                        System.out.print("Calificación: ");
                        double cal = sc.nextDouble();
                        lista.add(new Estudiante(mat, nom, cal));
                        System.out.println("✅ Registrado con éxito.");
                    }
                    break;
                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes.");
                    } else {
                        // Ordenar alfabéticamente usando un comparador
                        lista.sort(Comparator.comparing(e -> e.nombre));
                        System.out.println("\n--- LISTA DE ESTUDIANTES ---");
                        for (Estudiante e : lista) {
                            System.out.println(e.matricula + " - " + e.nombre + " - Cal: " + e.calificacion);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Matrícula a buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;
                    for (Estudiante e : lista) {
                        if (e.matricula.equals(buscar)) {
                            System.out.println("✅ Encontrado: " + e.nombre + " - Calificación: " + e.calificacion);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("❌ Estudiante no encontrado.");
                    break;
                case 4:
                    System.out.print("Matrícula del estudiante a modificar: ");
                    String matMod = sc.nextLine();
                    boolean mod = false;
                    for (Estudiante e : lista) {
                        if (e.matricula.equals(matMod)) {
                            System.out.print("Nueva calificación: ");
                            e.calificacion = sc.nextDouble();
                            System.out.println("✅ Calificación actualizada.");
                            mod = true;
                            break;
                        }
                    }
                    if (!mod) System.out.println("❌ Estudiante no encontrado.");
                    break;
                case 5:
                    System.out.print("Matrícula a eliminar: ");
                    String matEli = sc.nextLine();
                    if (lista.removeIf(e -> e.matricula.equals(matEli))) {
                        System.out.println("✅ Estudiante eliminado.");
                    } else {
                        System.out.println("❌ Estudiante no encontrado.");
                    }
                    break;
                case 6:
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes para calcular promedio.");
                    } else {
                        double suma = 0;
                        for (Estudiante e : lista) suma += e.calificacion;
                        System.out.println("📊 Promedio general: " + (suma / lista.size()));
                    }
                    break;
                case 7:
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes.");
                    } else {
                        Estudiante max = lista.get(0);
                        Estudiante min = lista.get(0);
                        for (Estudiante e : lista) {
                            if (e.calificacion > max.calificacion) max = e;
                            if (e.calificacion < min.calificacion) min = e;
                        }
                        System.out.println("🏆 Calificación más alta: " + max.calificacion + " (" + max.nombre + ")");
                        System.out.println("📉 Calificación más baja: " + min.calificacion + " (" + min.nombre + ")");
                    }
                    break;
                case 8:
                    System.out.println("\n--- ESTUDIANTES CON CAL > 9 ---");
                    boolean hayMayores = false;
                    for (Estudiante e : lista) {
                        if (e.calificacion > 9) {
                            System.out.println(e.nombre + " - " + e.calificacion);
                            hayMayores = true;
                        }
                    }
                    if (!hayMayores) System.out.println("Ninguno supera el 9.");
                    break;
            }
        } while (opcion != 9);
        sc.close();
    }
}