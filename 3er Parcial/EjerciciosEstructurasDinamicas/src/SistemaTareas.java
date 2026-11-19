import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Tarea {
    int id;
    String descripcion;
    String prioridad;
    boolean completada;

    public Tarea(int id, String descripcion, String prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
    }
}

public class SistemaTareas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Tarea> tareas = new LinkedList<>();
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE TAREAS ---");
            System.out.println("1. Agregar tarea al inicio");
            System.out.println("2. Agregar tarea al final");
            System.out.println("3. Insertar tarea en posición específica");
            System.out.println("4. Eliminar tarea por ID");
            System.out.println("5. Buscar tarea por descripción");
            System.out.println("6. Mostrar todas las tareas");
            System.out.println("7. Marcar tarea como completada");
            System.out.println("8. Mostrar primera y última tarea");
            System.out.println("9. Recorrer lista en orden inverso");
            System.out.println("10. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                case 2:
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();
                    System.out.print("Prioridad (Alta/Media/Baja): ");
                    String prio = sc.nextLine();
                    Tarea nueva = new Tarea(id, desc, prio);
                    if (opcion == 1) {
                        tareas.addFirst(nueva);
                        System.out.println("✅ Tarea agregada al inicio.");
                    } else {
                        tareas.addLast(nueva);
                        System.out.println("✅ Tarea agregada al final.");
                    }
                    break;
                case 3:
                    System.out.print("ID: ");
                    int idIns = sc.nextInt(); sc.nextLine();
                    System.out.print("Descripción: ");
                    String descIns = sc.nextLine();
                    System.out.print("Prioridad: ");
                    String prioIns = sc.nextLine();
                    System.out.print("¿En qué posición (índice) deseas insertarla? (0 a " + tareas.size() + "): ");
                    int pos = sc.nextInt();
                    try {
                        tareas.add(pos, new Tarea(idIns, descIns, prioIns));
                        System.out.println("✅ Tarea insertada en la posición " + pos);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("❌ Posición inválida.");
                    }
                    break;
                case 4:
                    System.out.print("ID a eliminar: ");
                    int idEli = sc.nextInt();
                    if (tareas.removeIf(t -> t.id == idEli)) {
                        System.out.println("✅ Tarea eliminada.");
                    } else {
                        System.out.println("❌ Tarea no encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Texto a buscar en la descripción: ");
                    String busqueda = sc.nextLine().toLowerCase();
                    boolean enc = false;
                    for (Tarea t : tareas) {
                        if (t.descripcion.toLowerCase().contains(busqueda)) {
                            System.out.println("🔍 Encontrada: ID " + t.id + " - " + t.descripcion + " [" + t.prioridad + "]");
                            enc = true;
                        }
                    }
                    if (!enc) System.out.println("❌ No se encontraron coincidencias.");
                    break;
                case 6:
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas pendientes.");
                    } else {
                        System.out.println("\n--- LISTA DE TAREAS ---");
                        for (Tarea t : tareas) {
                            String estado = t.completada ? "[COMPLETADA]" : "[PENDIENTE]";
                            System.out.println("ID: " + t.id + " | " + t.descripcion + " | Prioridad: " + t.prioridad + " | " + estado);
                        }
                    }
                    break;
                case 7:
                    System.out.print("ID de la tarea a completar: ");
                    int idComp = sc.nextInt();
                    boolean comp = false;
                    for (Tarea t : tareas) {
                        if (t.id == idComp) {
                            t.completada = true;
                            System.out.println("✅ Tarea marcada como completada.");
                            comp = true;
                            break;
                        }
                    }
                    if (!comp) System.out.println("❌ Tarea no encontrada.");
                    break;
                case 8:
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas.");
                    } else {
                        System.out.println("🥇 Primera tarea: " + tareas.getFirst().descripcion);
                        System.out.println("🥉 Última tarea: " + tareas.getLast().descripcion);
                    }
                    break;
                case 9:
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas.");
                    } else {
                        System.out.println("\n--- TAREAS EN ORDEN INVERSO ---");
                        Iterator<Tarea> it = tareas.descendingIterator();
                        while (it.hasNext()) {
                            Tarea t = it.next();
                            System.out.println("ID: " + t.id + " - " + t.descripcion);
                        }
                    }
                    break;
            }
        } while (opcion != 10);
        sc.close();
    }
}