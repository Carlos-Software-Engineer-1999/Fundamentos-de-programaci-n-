import java.util.Arrays;
import java.util.Scanner;

public class InvestigacionArrays {
    private static final Scanner entrada = new Scanner(System.in);
    private static int[] datos = null;

    public static void main(String[] args) {
        int opcion;

        System.out.println("==========================================");
        System.out.println(" DEMOSTRACION INTERACTIVA DE java.util.Arrays");
        System.out.println("==========================================");

        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona una opcion: ");

            switch (opcion) {
                case 1:
                    crearArreglo();
                    break;
                case 2:
                    mostrarArreglo();
                    break;
                case 3:
                    ordenarArreglo();
                    break;
                case 4:
                    buscarElemento();
                    break;
                case 5:
                    rellenarArreglo();
                    break;
                case 6:
                    copiarArreglo();
                    break;
                case 7:
                    copiarRango();
                    break;
                case 8:
                    compararArreglos();
                    break;
                case 0:
                    System.out.println("Gracias por utilizar el programa.");
                    break;
                default:
                    System.out.println("Opcion no valida. Elige una opcion del 0 al 8.");
            }
        } while (opcion != 0);

        entrada.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--------------- MENU ---------------");
        System.out.println("1. Crear o reemplazar el arreglo");
        System.out.println("2. Mostrar el arreglo (Arrays.toString)");
        System.out.println("3. Ordenar el arreglo (Arrays.sort)");
        System.out.println("4. Buscar un numero (Arrays.binarySearch)");
        System.out.println("5. Rellenar el arreglo (Arrays.fill)");
        System.out.println("6. Copiar y cambiar longitud (Arrays.copyOf)");
        System.out.println("7. Copiar un rango (Arrays.copyOfRange)");
        System.out.println("8. Comparar con otro arreglo (Arrays.equals)");
        System.out.println("0. Salir");
        System.out.println("------------------------------------");
    }

    private static void crearArreglo() {
        int cantidad;
        do {
            cantidad = leerEntero("Cuantos elementos tendra el arreglo? ");
            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que cero.");
            }
        } while (cantidad <= 0);

        int[] nuevo = new int[cantidad];
        for (int i = 0; i < nuevo.length; i++) {
            nuevo[i] = leerEntero("Introduce el elemento de la posicion " + i + ": ");
        }

        datos = nuevo;
        System.out.println("Arreglo creado: " + Arrays.toString(datos));
    }

    private static boolean hayArreglo() {
        if (datos == null) {
            System.out.println("Primero debes crear el arreglo con la opcion 1.");
            return false;
        }
        return true;
    }

    private static void mostrarArreglo() {
        if (hayArreglo()) {
            System.out.println("Contenido: " + Arrays.toString(datos));
            System.out.println("Longitud: " + datos.length);
        }
    }

    private static void ordenarArreglo() {
        if (!hayArreglo()) return;

        Arrays.sort(datos);
        System.out.println("Arreglo ordenado de menor a mayor: " + Arrays.toString(datos));
        System.out.println("Nota: Arrays.sort modifica el arreglo original.");
    }

    private static void buscarElemento() {
        if (!hayArreglo()) return;

        int[] ordenado = Arrays.copyOf(datos, datos.length);
        Arrays.sort(ordenado);

        int buscado = leerEntero("Que numero deseas buscar? ");
        int posicion = Arrays.binarySearch(ordenado, buscado);

        System.out.println("Arreglo utilizado para buscar: " + Arrays.toString(ordenado));
        if (posicion >= 0) {
            System.out.println("El numero " + buscado + " se encuentra en el indice " + posicion
                    + " del arreglo ordenado.");
        } else {
            System.out.println("El numero no se encuentra en el arreglo.");
        }
    }

    private static void rellenarArreglo() {
        if (!hayArreglo()) return;

        int valor = leerEntero("Que valor deseas colocar en todas las posiciones? ");
        Arrays.fill(datos, valor);
        System.out.println("Arreglo despues de Arrays.fill: " + Arrays.toString(datos));
    }

    private static void copiarArreglo() {
        if (!hayArreglo()) return;

        int nuevaLongitud;
        do {
            nuevaLongitud = leerEntero("Indica la nueva longitud (mayor que cero): ");
            if (nuevaLongitud <= 0) {
                System.out.println("La longitud debe ser mayor que cero.");
            }
        } while (nuevaLongitud <= 0);

        int[] copia = Arrays.copyOf(datos, nuevaLongitud);
        System.out.println("Arreglo original: " + Arrays.toString(datos));
        System.out.println("Copia:             " + Arrays.toString(copia));
        System.out.println("Si la copia es mas larga, las posiciones nuevas se inicializan en cero.");
    }

    private static void copiarRango() {
        if (!hayArreglo()) return;

        System.out.println("El rango usa indice inicial incluido e indice final excluido.");
        int inicio;
        int fin;

        do {
            inicio = leerEntero("Indice inicial (0 a " + datos.length + "): ");
            fin = leerEntero("Indice final (mayor o igual al inicial): ");

            if (inicio < 0 || inicio > datos.length || fin < inicio) {
                System.out.println("Rango no valido. Intenta nuevamente.");
            }
        } while (inicio < 0 || inicio > datos.length || fin < inicio);

        int[] copia = Arrays.copyOfRange(datos, inicio, fin);
        System.out.println("Rango copiado: " + Arrays.toString(copia));
        System.out.println("Longitud de la copia: " + copia.length);
    }

    private static void compararArreglos() {
        if (!hayArreglo()) return;

        int cantidad;
        do {
            cantidad = leerEntero("Cuantos elementos tendra el segundo arreglo? ");
            if (cantidad < 0) {
                System.out.println("La cantidad no puede ser negativa.");
            }
        } while (cantidad < 0);

        int[] segundo = new int[cantidad];
        for (int i = 0; i < segundo.length; i++) {
            segundo[i] = leerEntero("Elemento " + i + " del segundo arreglo: ");
        }

        System.out.println("Primer arreglo:  " + Arrays.toString(datos));
        System.out.println("Segundo arreglo: " + Arrays.toString(segundo));

        if (Arrays.equals(datos, segundo)) {
            System.out.println("Arrays.equals: los arreglos tienen el mismo contenido y orden.");
        } else {
            System.out.println("Arrays.equals: los arreglos son diferentes.");
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (entrada.hasNextInt()) {
                return entrada.nextInt();
            }
            System.out.println("Entrada no valida. Debes introducir un numero entero.");
            entrada.next();
        }
    }
}
