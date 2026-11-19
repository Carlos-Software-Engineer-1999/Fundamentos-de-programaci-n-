
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ejercicio1 {

    private static final Scanner entrada = new Scanner(System.in);

    private static final String[] MESES = {
            "Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto",
            "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    private static class Sucursal {
        String nombre;
        double totalAnual;
        double promedioMensual;
        double mayoresVentasMensuales;
        String mesesConMayoresVentas;

        Sucursal(String nombre, double totalAnual,
                 double promedioMensual, double mayoresVentasMensuales) {
            this.nombre = nombre;
            this.totalAnual = totalAnual;
            this.promedioMensual = promedioMensual;
            this.mayoresVentasMensuales = mayoresVentasMensuales;
            this.mesesConMayoresVentas = "";
        }
    }

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println(" ANALISIS ESTADISTICO DE VENTAS POR SUCURSAL");
        System.out.println("============================================");

        int cantidadSucursales =
                leerEnteroPositivo("Ingrese la cantidad de sucursales: ");

        String[] nombres = new String[cantidadSucursales];
        double[][] ventas = new double[cantidadSucursales][12];
        double[] totalesAnuales = new double[cantidadSucursales];

        double sumaGlobal = 0.0;

        Sucursal[] resultados = new Sucursal[cantidadSucursales];

        for (int i = 0; i < cantidadSucursales; i++) {

            System.out.print("\nNombre de la sucursal " + (i + 1) + ": ");
            nombres[i] = entrada.nextLine().trim();

            while (nombres[i].isEmpty()) {
                System.out.print("El nombre no puede quedar vacio. Intente nuevamente: ");
                nombres[i] = entrada.nextLine().trim();
            }

            System.out.println("Captura de ventas para " + nombres[i] + ":");

            for (int mes = 0; mes < 12; mes++) {

                ventas[i][mes] = leerDoubleNoNegativo(
                        "Ventas de " + MESES[mes] + ": "
                );

                totalesAnuales[i] += ventas[i][mes];
            }

            sumaGlobal += totalesAnuales[i];

            double mayorVentaMensual = ventas[i][0];

            for (int mes = 1; mes < 12; mes++) {
                if (ventas[i][mes] > mayorVentaMensual) {
                    mayorVentaMensual = ventas[i][mes];
                }
            }

            resultados[i] = new Sucursal(
                    nombres[i],
                    totalesAnuales[i],
                    totalesAnuales[i] / 12.0,
                    mayorVentaMensual
            );

            StringBuilder mesesMaximos = new StringBuilder();

            for (int mes = 0; mes < 12; mes++) {

                if (Double.compare(
                        ventas[i][mes],
                        mayorVentaMensual
                ) == 0) {

                    if (mesesMaximos.length() > 0) {
                        mesesMaximos.append(", ");
                    }

                    mesesMaximos.append(MESES[mes]);
                }
            }

            resultados[i].mesesConMayoresVentas =
                    mesesMaximos.toString();
        }

        double promedioGlobalAnual =
                sumaGlobal / cantidadSucursales;

        System.out.println("\n========== REPORTE POR SUCURSAL ==========");

        for (int i = 0; i < cantidadSucursales; i++) {

            double[] ventasSucursal =
                    Arrays.copyOf(ventas[i], ventas[i].length);

            System.out.println("\nSucursal: " + nombres[i]);

            System.out.println(
                    "Ventas mensuales: " + Arrays.toString(ventasSucursal)
            );

            System.out.printf(
                    "Total anual: $%.2f%n",
                    totalesAnuales[i]
            );

            System.out.printf(
                    "Promedio mensual: $%.2f%n",
                    totalesAnuales[i] / 12.0
            );

            System.out.printf(
                    "Mayor venta mensual: $%.2f%n",
                    resultados[i].mayoresVentasMensuales
            );

            System.out.println(
                    "Mes(es) con mayores ventas: "
                            + resultados[i].mesesConMayoresVentas
            );
        }

        System.out.printf(
                "\nPromedio global anual por sucursal: $%.2f%n",
                promedioGlobalAnual
        );

        System.out.println(
                "\n========== SUCURSALES SOBRE EL PROMEDIO GLOBAL =========="
        );

        boolean algunaSupera = false;

        for (Sucursal sucursal : resultados) {

            if (sucursal.totalAnual > promedioGlobalAnual) {

                System.out.printf(
                        "%s: $%.2f%n",
                        sucursal.nombre,
                        sucursal.totalAnual
                );

                algunaSupera = true;
            }
        }

        if (!algunaSupera) {
            System.out.println(
                    "Ninguna sucursal supera el promedio global."
            );
        }

        Sucursal[] ranking =
                Arrays.copyOf(resultados, resultados.length);

        Arrays.sort(
                ranking,
                Comparator.comparingDouble(
                        (Sucursal sucursal) -> sucursal.totalAnual
                ).reversed()
        );

        System.out.println("\n========== RANKING DE SUCURSALES ==========");

        for (int i = 0; i < ranking.length; i++) {

            System.out.printf(
                    "%d. %s - Total anual: $%.2f - Promedio mensual: $%.2f - Mejor mes: %s%n",
                    i + 1,
                    ranking[i].nombre,
                    ranking[i].totalAnual,
                    ranking[i].promedioMensual,
                    ranking[i].mesesConMayoresVentas
            );
        }

        entrada.close();
    }

    private static int leerEnteroPositivo(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String texto = entrada.nextLine().trim();

            try {

                int valor = Integer.parseInt(texto);

                if (valor > 0) {
                    return valor;
                }

                System.out.println("Ingrese un entero mayor que cero.");

            } catch (NumberFormatException e) {

                System.out.println("Entrada no valida. Ingrese un numero entero.");
            }
        }
    }

    private static double leerDoubleNoNegativo(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String texto = entrada.nextLine()
                    .trim()
                    .replace(',', '.');

            try {

                double valor = Double.parseDouble(texto);

                if (Double.isFinite(valor) && valor >= 0) {
                    return valor;
                }

                System.out.println("Ingrese una cantidad decimal no negativa.");

            } catch (NumberFormatException e) {

                System.out.println("Entrada no valida. Ejemplo: 1250.50");
            }
        }
    }
}
