Algoritmo TablaMultiplicar
    Definir num, i, resultado Como Entero
    Repetir
        Escribir "Ingrese un numero (0 para terminar):"
        Leer num
        Si num <> 0 Entonces
            Para i <- 1 Hasta 10 Hacer
                resultado <- num * i
                Escribir num, " x ", i, " = ", resultado
            FinPara
        FinSi
    Hasta Que num = 0
FinAlgoritmo