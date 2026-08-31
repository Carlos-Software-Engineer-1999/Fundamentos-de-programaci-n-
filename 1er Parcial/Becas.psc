Algoritmo Becas
    // Declarar variables
    Definir edad Como Entero
    Definir promedio, beca Como Real
    Definir mensaje Como Caracter
    
    // Entrada de datos
    Escribir "Ingrese la edad:"
    Leer edad
    Escribir "Ingrese el promedio:"
    Leer promedio
    
    // Inicializar variables
    beca <- 0
    mensaje <- ""
    
    // Proceso para mayores de 18 años
    Si edad > 18 Entonces
        Si promedio >= 9 Entonces
            beca <- 10000
        Sino
            Si promedio >= 7.5 Entonces
                beca <- 8000
            Sino
                Si promedio >= 6.0 Entonces
                    beca <- 5000
                Sino
                    mensaje <- "Carta de invitación"
                FinSi
            FinSi
        FinSi
        
		// Proceso para menores o iguales a 18 años
    Sino
        Si promedio >= 9 Entonces
            beca <- 8000
        Sino
            Si promedio >= 8 Entonces
                beca <- 6000
            Sino
                Si promedio >= 6 Entonces
                    beca <- 4000
                Sino
                    mensaje <- "Carta de invitación"
                FinSi
            FinSi
        FinSi
    FinSi
    
    // Mostrar resultado final
    Si mensaje <> "" Entonces
        Escribir mensaje
    Sino
        Escribir "Beca: $", beca
    FinSi
    
FinAlgoritmo