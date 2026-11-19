import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDoble listaDoble = new ListaDoble();
        ListaCircular listaCircular = new ListaCircular();

        int opcionPrincipal = 0;

        while (opcionPrincipal != 3) {
            System.out.println("\n================================================");
            System.out.println("   PRÁCTICA: LISTAS ENLAZADAS (DOBLES Y CIRCULARES)");
            System.out.println("================================================");
            System.out.println("1. Trabajar con Lista Doblemente Enlazada");
            System.out.println("2. Trabajar con Lista Circular");
            System.out.println("3. Salir del programa");
            System.out.print("Elige una opción: ");

            try {
                opcionPrincipal = sc.nextInt();
                switch (opcionPrincipal) {
                    case 1:
                        menuListaDoble(sc, listaDoble);
                        break;
                    case 2:
                        menuListaCircular(sc, listaCircular);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa... ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("❌ Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: Ingresa un número válido.");
                sc.nextLine();
                opcionPrincipal = 0;
            }
        }
        sc.close();
    }

    public static void menuListaDoble(Scanner sc, ListaDoble lista) {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n--- MENÚ LISTA DOBLE ---");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Eliminar al inicio");
            System.out.println("4. Eliminar al final");
            System.out.println("5. Mostrar lista (Adelante y Atrás)");
            System.out.println("6. Regresar al menú principal");
            System.out.print("Elige una opción: ");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("Número: ");
                        lista.insertarAlInicio(sc.nextInt());
                        break;
                    case 2:
                        System.out.print("Número: ");
                        lista.insertarAlFinal(sc.nextInt());
                        break;
                    case 3:
                        lista.eliminarAlInicio();
                        break;
                    case 4:
                        lista.eliminarAlFinal();
                        break;
                    case 5:
                        lista.mostrarAdelante();
                        lista.mostrarAtras();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("❌ Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: Ingresa un número válido.");
                sc.nextLine();
                opcion = 0;
            }
        }
    }

    public static void menuListaCircular(Scanner sc, ListaCircular lista) {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n--- MENÚ LISTA CIRCULAR ---");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Eliminar al inicio");
            System.out.println("4. Eliminar al final");
            System.out.println("5. Mostrar lista circular");
            System.out.println("6. Regresar al menú principal");
            System.out.print("Elige una opción: ");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("Número: ");
                        lista.insertarAlInicio(sc.nextInt());
                        break;
                    case 2:
                        System.out.print("Número: ");
                        lista.insertarAlFinal(sc.nextInt());
                        break;
                    case 3:
                        lista.eliminarAlInicio();
                        break;
                    case 4:
                        lista.eliminarAlFinal();
                        break;
                    case 5:
                        lista.mostrar();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("❌ Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: Ingresa un número válido.");
                sc.nextLine();
                opcion = 0;
            }
        }
    }
}