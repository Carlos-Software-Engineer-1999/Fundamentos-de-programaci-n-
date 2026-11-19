
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[][] matriz = new int[4][4];
        boolean llena = false;
        int opcion;

        do {
            System.out.println("\n========== MENU MATRIZ 4x4 ==========");
            System.out.println("1. Rellenar matriz");
            System.out.println("2. Suma de cada fila y columna");
            System.out.println("3. Suma de una fila");
            System.out.println("4. Suma de una columna");
            System.out.println("5. Numero mayor y menor con posiciones");
            System.out.println("6. Contar numeros pares");
            System.out.println("7. Contar numeros impares");
            System.out.println("8. Generar matriz de cuadrados");
            System.out.println("9. Sumar diagonal principal");
            System.out.println("10. Sumar diagonal inversa");
            System.out.println("11. Calcular media");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();

            if (opcion < 0 || opcion > 11) {
                System.out.println("Opcion no valida.");
                continue;
            }

            if (opcion == 0) {
                System.out.println("Programa finalizado.");
                break;
            }

            if (!llena && opcion != 1) {
                System.out.println("Primero debes rellenar toda la matriz.");
                continue;
            }

            if (opcion == 1) {
                System.out.println("\n--- RELLENAR MATRIZ ---");

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        int numero;
                        boolean repetido;

                        do {
                            repetido = false;
                            System.out.print("Ingrese el valor [" + (i + 1) + "][" + (j + 1) + "]: ");
                            numero = entrada.nextInt();

                            for (int x = 0; x <= i; x++) {
                                for (int y = 0; y < 4; y++) {
                                    if (x == i && y >= j) {
                                        break;
                                    }

                                    if (matriz[x][y] == numero) {
                                        repetido = true;
                                    }
                                }
                            }

                            if (repetido) {
                                System.out.println("Ese numero ya existe. Introduzca otro.");
                            }
                        } while (repetido);

                        matriz[i][j] = numero;
                    }
                }

                llena = true;
                System.out.println("Matriz rellenada correctamente.");
            } else {
                System.out.println("\n--- MATRIZ ORIGINAL ---");

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        System.out.printf("%8d", matriz[i][j]);
                    }
                    System.out.println();
                }

                switch (opcion) {
                    case 2:
                        System.out.println("\nSuma de filas:");

                        for (int i = 0; i < 4; i++) {
                            int suma = 0;

                            for (int j = 0; j < 4; j++) {
                                suma += matriz[i][j];
                            }

                            System.out.println("Fila " + (i + 1) + ": " + suma);
                        }

                        System.out.println("\nSuma de columnas:");

                        for (int j = 0; j < 4; j++) {
                            int suma = 0;

                            for (int i = 0; i < 4; i++) {
                                suma += matriz[i][j];
                            }

                            System.out.println("Columna " + (j + 1) + ": " + suma);
                        }
                        break;

                    case 3:
                        int fila;

                        do {
                            System.out.print("Ingrese la fila (1-4): ");
                            fila = entrada.nextInt();

                            if (fila < 1 || fila > 4) {
                                System.out.println("Fila no valida.");
                            }
                        } while (fila < 1 || fila > 4);

                        int sumaFila = 0;

                        for (int j = 0; j < 4; j++) {
                            sumaFila += matriz[fila - 1][j];
                        }

                        System.out.println("Suma de la fila: " + sumaFila);
                        break;

                    case 4:
                        int columna;

                        do {
                            System.out.print("Ingrese la columna (1-4): ");
                            columna = entrada.nextInt();

                            if (columna < 1 || columna > 4) {
                                System.out.println("Columna no valida.");
                            }
                        } while (columna < 1 || columna > 4);

                        int sumaColumna = 0;

                        for (int i = 0; i < 4; i++) {
                            sumaColumna += matriz[i][columna - 1];
                        }

                        System.out.println("Suma de la columna: " + sumaColumna);
                        break;

                    case 5:
                        int mayor = matriz[0][0];
                        int menor = matriz[0][0];

                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                if (matriz[i][j] > mayor) mayor = matriz[i][j];
                                if (matriz[i][j] < menor) menor = matriz[i][j];
                            }
                        }

                        System.out.println("Numero mayor: " + mayor);

                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                if (matriz[i][j] == mayor) {
                                    System.out.println("Posicion: fila " + (i + 1) + ", columna " + (j + 1));
                                }
                            }
                        }

                        System.out.println("Numero menor: " + menor);

                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                if (matriz[i][j] == menor) {
                                    System.out.println("Posicion: fila " + (i + 1) + ", columna " + (j + 1));
                                }
                            }
                        }
                        break;

                    case 6:
                        int pares = 0;

                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                if (matriz[i][j] % 2 == 0) pares++;
                            }
                        }

                        System.out.println("Cantidad de pares: " + pares);
                        break;

                    case 7:
                        int impares = 0;

                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                if (matriz[i][j] % 2 != 0) impares++;
                            }
                        }

                        System.out.println("Cantidad de impares: " + impares);
                        break;

                    case 8:
                        int[][] cuadrados = new int[4][4];

                        System.out.println("\nMatriz de cuadrados:");

                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                cuadrados[i][j] = matriz[i][j] * matriz[i][j];
                                System.out.printf("%8d", cuadrados[i][j]);
                            }
                            System.out.println();
                        }
                        break;

                    case 9:
                        int principal = 0;

                        for (int i = 0; i < 4; i++) {
                            principal += matriz[i][i];
                        }

                        System.out.println("Suma diagonal principal: " + principal);
                        break;

                    case 10:
                        int inversa = 0;

                        for (int i = 0; i < 4; i++) {
                            inversa += matriz[i][3 - i];
                        }

                        System.out.println("Suma diagonal inversa: " + inversa);
                        break;

                    case 11:
                        int sumaTotal = 0;

                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                sumaTotal += matriz[i][j];
                            }
                        }

                        double media = sumaTotal / 16.0;
                        System.out.println("Media de la matriz: " + media);
                        break;
                }
            }

        } while (true);

        entrada.close();
    }
}
