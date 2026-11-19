import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cliente {
    int turno;
    String nombre;

    public Cliente(int turno, String nombre) {
        this.turno = turno;
        this.nombre = nombre;
    }
}

public class SistemaClientes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Cliente> fila = new LinkedList<>();
        int opcion;
        int contadorTurno = 1;

        do {
            System.out.println("\n--- ATENCIÓN A CLIENTES ---");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Mostrar el siguiente cliente (sin atender)");
            System.out.println("4. Mostrar todos los clientes pendientes");
            System.out.println("5. Consultar cuántos clientes esperan");
            System.out.println("6. Cancelar un turno específico");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = sc.nextLine();
                    fila.add(new Cliente(contadorTurno, nombre));
                    System.out.println("✅ Cliente registrado. Turno: " + contadorTurno);
                    contadorTurno++;
                    break;
                case 2:
                    if (fila.isEmpty()) {
                        System.out.println("❌ No hay clientes en espera.");
                    } else {
                        Cliente atendido = fila.poll();
                        System.out.println("🚀 Atendiendo a: " + atendido.nombre + " (Turno " + atendido.turno + ")");
                    }
                    break;
                case 3:
                    if (fila.isEmpty()) {
                        System.out.println("❌ No hay clientes en espera.");
                    } else {
                        Cliente siguiente = fila.peek();
                        System.out.println("⏳ El siguiente es: " + siguiente.nombre + " (Turno " + siguiente.turno + ")");
                    }
                    break;
                case 4:
                    if (fila.isEmpty()) {
                        System.out.println("La fila está vacía.");
                    } else {
                        System.out.println("\n--- CLIENTES EN ESPERA ---");
                        for (Cliente c : fila) {
                            System.out.println("Turno " + c.turno + " - " + c.nombre);
                        }
                    }
                    break;
                case 5:
                    System.out.println("👥 Clientes esperando: " + fila.size());
                    break;
                case 6:
                    System.out.print("Ingresa el número de turno a cancelar: ");
                    int turnoCancelar = sc.nextInt();
                    boolean cancelado = fila.removeIf(c -> c.turno == turnoCancelar);
                    if (cancelado) {
                        System.out.println("✅ Turno " + turnoCancelar + " cancelado.");
                    } else {
                        System.out.println("❌ Turno no encontrado.");
                    }
                    break;
            }
        } while (opcion != 7);
        sc.close();
    }
}