
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println(" DETECCION Y ELIMINACION DE DUPLICADOS");
        System.out.println("============================================");

        String continuar;

        do {

            procesarTransacciones();

            System.out.print("\nDesea procesar otro arreglo? (S/N): ");
            continuar = entrada.nextLine().trim();

            while (!continuar.equalsIgnoreCase("S")
                    && !continuar.equalsIgnoreCase("N")) {

                System.out.print(
                        "Respuesta no valida. Escriba S o N: "
                );

                continuar = entrada.nextLine().trim();
            }

        } while (continuar.equalsIgnoreCase("S"));

        System.out.println("Programa finalizado.");

        entrada.close();
    }

    private static void procesarTransacciones() {

        int cantidad = leerEnteroNoNegativo(
                "Cuantos identificadores de transaccion desea capturar? "
        );

        int[] original = new int[cantidad];

        for (int i = 0; i < original.length; i++) {

            original[i] = leerEntero(
                    "Identificador " + (i + 1) + ": "
            );
        }

        System.out.println(
                "\nArreglo original: " + Arrays.toString(original)
        );

        int[] ordenado = Arrays.copyOf(
                original,
                original.length
        );

        Arrays.sort(ordenado);

        int[] duplicadosOrdenados = new int[ordenado.length];

        int cantidadDuplicados = 0;
        int i = 0;

        while (i < ordenado.length) {

            int j = i + 1;

            while (j < ordenado.length
                    && ordenado[j] == ordenado[i]) {

                j++;
            }

            if (j - i > 1) {

                duplicadosOrdenados[cantidadDuplicados] =
                        ordenado[i];

                cantidadDuplicados++;
            }

            i = j;
        }

        duplicadosOrdenados = Arrays.copyOf(
                duplicadosOrdenados,
                cantidadDuplicados
        );

        int[] depuradoTemporal = new int[original.length];

        int cantidadUnicos = 0;

        for (int valor : original) {

            if (!contiene(
                    depuradoTemporal,
                    cantidadUnicos,
                    valor
            )) {

                depuradoTemporal[cantidadUnicos] = valor;
                cantidadUnicos++;
            }
        }

        int[] depurado = Arrays.copyOf(
                depuradoTemporal,
                cantidadUnicos
        );

        int[] duplicadosEnOrdenOriginal =
                new int[cantidadDuplicados];

        int mostrados = 0;

        for (int valor : original) {

            if (contiene(
                    duplicadosOrdenados,
                    duplicadosOrdenados.length,
                    valor
            ) && !contiene(
                    duplicadosEnOrdenOriginal,
                    mostrados,
                    valor
            )) {

                duplicadosEnOrdenOriginal[mostrados] = valor;
                mostrados++;
            }
        }

        duplicadosEnOrdenOriginal = Arrays.copyOf(
                duplicadosEnOrdenOriginal,
                mostrados
        );

        int registrosEliminados =
                original.length - depurado.length;

        System.out.println(
                "Arreglo depurado: " + Arrays.toString(depurado)
        );

        if (duplicadosEnOrdenOriginal.length == 0) {

            System.out.println(
                    "Identificadores duplicados: ninguno"
            );

        } else {

            System.out.println(
                    "Identificadores duplicados: "
                            + listaSeparadaPorComas(duplicadosEnOrdenOriginal)
            );
        }

        System.out.println(
                "Registros eliminados: " + registrosEliminados
        );
    }

    private static boolean contiene(
            int[] arreglo,
            int longitudUtilizada,
            int valor
    ) {

        for (int i = 0; i < longitudUtilizada; i++) {

            if (arreglo[i] == valor) {
                return true;
            }
        }

        return false;
    }

    private static String listaSeparadaPorComas(int[] valores) {

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {

            if (i > 0) {
                resultado.append(", ");
            }

            resultado.append(valores[i]);
        }

        return resultado.toString();
    }

    private static int leerEntero(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String texto = entrada.nextLine().trim();

            try {

                return Integer.parseInt(texto);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Entrada no valida. Introduzca un numero entero."
                );
            }
        }
    }

    private static int leerEnteroNoNegativo(String mensaje) {

        while (true) {

            int valor = leerEntero(mensaje);

            if (valor >= 0) {
                return valor;
            }

            System.out.println("La cantidad no puede ser negativa.");
        }
    }
}
