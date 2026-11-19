
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Investigacion_ArrayList {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<String> lista = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n====================================");
            System.out.println("       INVESTIGACION ARRAYLIST");
            System.out.println("====================================");
            System.out.println("Elementos actuales: " + lista);

            System.out.println("\n1. Agregar elemento (add)");
            System.out.println("2. Obtener elemento (get)");
            System.out.println("3. Modificar elemento (set)");
            System.out.println("4. Eliminar elemento por posicion (remove)");
            System.out.println("5. Eliminar elemento por valor (remove)");
            System.out.println("6. Consultar cantidad (size)");
            System.out.println("7. Buscar elemento (contains)");
            System.out.println("8. Primera posicion (indexOf)");
            System.out.println("9. Ultima posicion (lastIndexOf)");
            System.out.println("10. Comprobar si esta vacia (isEmpty)");
            System.out.println("11. Limpiar lista (clear)");
            System.out.println("12. Ordenar lista (sort)");
            System.out.println("13. Convertir a arreglo (toArray)");
            System.out.println("14. Obtener sublista (subList)");
            System.out.println("15. Mostrar lista completa");
            System.out.println("0. Salir");
            System.out.print("\nSelecciona una opcion: ");

            opcion = leerEntero();

            switch (opcion) {

                case 1:
                    agregarElemento();
                    break;

                case 2:
                    obtenerElemento();
                    break;

                case 3:
                    modificarElemento();
                    break;

                case 4:
                    eliminarPorPosicion();
                    break;

                case 5:
                    eliminarPorValor();
                    break;

                case 6:
                    System.out.println("Cantidad de elementos: "
                            + lista.size());
                    break;

                case 7:
                    buscarElemento();
                    break;

                case 8:
                    buscarPrimeraPosicion();
                    break;

                case 9:
                    buscarUltimaPosicion();
                    break;

                case 10:
                    System.out.println(lista.isEmpty()
                            ? "La lista esta vacia."
                            : "La lista contiene elementos.");
                    break;

                case 11:
                    lista.clear();
                    System.out.println("La lista fue vaciada.");
                    break;

                case 12:
                    Collections.sort(lista);
                    System.out.println("Lista ordenada alfabeticamente.");
                    break;

                case 13:
                    String[] arreglo = lista.toArray(new String[0]);
                    System.out.println("Arreglo convertido: "
                            + java.util.Arrays.toString(arreglo));
                    break;

                case 14:
                    obtenerSublista();
                    break;

                case 15:
                    mostrarLista();
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        entrada.close();
    }

    public static void agregarElemento() {

        System.out.print("Escribe el elemento que deseas agregar: ");
        String elemento = leerTexto();

        lista.add(elemento);

        System.out.println("Elemento agregado correctamente.");
    }

    public static void obtenerElemento() {

        if (verificarListaVacia()) return;

        mostrarLista();

        System.out.print("Ingresa la posicion que deseas consultar: ");
        int posicion = leerEntero();

        if (posicion >= 0 && posicion < lista.size()) {
            System.out.println("Elemento encontrado: "
                    + lista.get(posicion));
        } else {
            System.out.println("Posicion fuera de rango.");
        }
    }

    public static void modificarElemento() {

        if (verificarListaVacia()) return;

        mostrarLista();

        System.out.print("Ingresa la posicion que deseas modificar: ");
        int posicion = leerEntero();

        if (posicion >= 0 && posicion < lista.size()) {

            System.out.print("Ingresa el nuevo elemento: ");
            String nuevo = leerTexto();

            lista.set(posicion, nuevo);

            System.out.println("Elemento modificado correctamente.");

        } else {
            System.out.println("Posicion fuera de rango.");
        }
    }

    public static void eliminarPorPosicion() {

        if (verificarListaVacia()) return;

        mostrarLista();

        System.out.print("Ingresa la posicion que deseas eliminar: ");
        int posicion = leerEntero();

        if (posicion >= 0 && posicion < lista.size()) {

            String eliminado = lista.remove(posicion);

            System.out.println("Elemento eliminado: " + eliminado);

        } else {
            System.out.println("Posicion fuera de rango.");
        }
    }

    public static void eliminarPorValor() {

        if (verificarListaVacia()) return;

        System.out.print("Ingresa el elemento que deseas eliminar: ");
        String elemento = leerTexto();

        if (lista.remove(elemento)) {
            System.out.println("Elemento eliminado correctamente.");
        } else {
            System.out.println("El elemento no existe en la lista.");
        }
    }

    public static void buscarElemento() {

        System.out.print("Ingresa el elemento que deseas buscar: ");
        String elemento = leerTexto();

        if (lista.contains(elemento)) {
            System.out.println("El elemento si existe en la lista.");
        } else {
            System.out.println("El elemento no existe en la lista.");
        }
    }

    public static void buscarPrimeraPosicion() {

        System.out.print("Ingresa el elemento que deseas localizar: ");
        String elemento = leerTexto();

        int posicion = lista.indexOf(elemento);

        if (posicion != -1) {
            System.out.println("Primera posicion encontrada: " + posicion);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }

    public static void buscarUltimaPosicion() {

        System.out.print("Ingresa el elemento que deseas localizar: ");
        String elemento = leerTexto();

        int posicion = lista.lastIndexOf(elemento);

        if (posicion != -1) {
            System.out.println("Ultima posicion encontrada: " + posicion);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }

    public static void obtenerSublista() {

        if (verificarListaVacia()) return;

        mostrarLista();

        System.out.print("Ingresa la posicion inicial: ");
        int inicio = leerEntero();

        System.out.print("Ingresa la posicion final (exclusiva): ");
        int fin = leerEntero();

        if (inicio >= 0 && fin <= lista.size()
                && inicio < fin) {

            ArrayList<String> sublista =
                    new ArrayList<>(lista.subList(inicio, fin));

            System.out.println("Sublista obtenida: " + sublista);

        } else {
            System.out.println("Rango de posiciones no valido.");
        }
    }

    public static void mostrarLista() {

        if (verificarListaVacia()) return;

        System.out.println("\nContenido de la lista:");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Posicion " + i + ": " + lista.get(i));
        }
    }

    public static boolean verificarListaVacia() {

        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia. Agrega elementos primero.");
            return true;
        }

        return false;
    }

    public static int leerEntero() {

        while (!entrada.hasNextInt()) {
            System.out.print("Entrada invalida. Ingresa un numero entero: ");
            entrada.next();
        }

        int numero = entrada.nextInt();
        entrada.nextLine();

        return numero;
    }

    public static String leerTexto() {

        String texto;

        do {
            texto = entrada.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.print("No puede estar vacio. Intenta nuevamente: ");
            }

        } while (texto.isEmpty());

        return texto;
    }
}
