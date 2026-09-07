Algoritmo PatronesAsteriscos
    // Declarar variables
    Definir n, i, j, esp Como Entero
    
    // Pedir el tamaño
    Escribir "Ingrese el tamaño n (impar):"
    Leer n
    
    // Figura 1: Cuadrado
    Escribir "Figura 1: Cuadrado"
    Para i <- 1 Hasta n Hacer
        Para j <- 1 Hasta n Hacer
            Escribir "* " Sin Saltar
        FinPara
        Escribir ""
    FinPara
    
    // Figura 2: Piramide Invertida 
    Escribir "Figura 2: Pirámide Invertida"
    Para i <- n Hasta 1 Con Paso -2 Hacer
        Para j <- 1 Hasta i Hacer
            Escribir "* " Sin Saltar
        FinPara
        Escribir ""
    FinPara
    
    // Figura 3: Rombo
    Escribir "Figura 3: Rombo"
    // Parte superior (creciente)
    Para i <- 1 Hasta n Con Paso 2 Hacer
        Para esp <- 1 Hasta (n - i) / 2 Hacer
            Escribir " " Sin Saltar
        FinPara
        Para j <- 1 Hasta i Hacer
            Escribir "*" Sin Saltar
        FinPara
        Escribir ""
    FinPara
    // Parte inferior (decreciente)
    Para i <- n - 2 Hasta 1 Con Paso -2 Hacer
        Para esp <- 1 Hasta (n - i) / 2 Hacer
            Escribir " " Sin Saltar
        FinPara
        Para j <- 1 Hasta i Hacer
            Escribir "*" Sin Saltar
        FinPara
        Escribir ""
    FinPara
    
FinAlgoritmo