Algoritmo Estacionamiento
    Leer horas
    Si horas <= 2 Entonces total = horas * 30
    Sino
        Si horas <= 5 Entonces total = 60 + (horas - 2) * 25
        Sino
            Si horas <= 10 Entonces total = 60 + 75 + (horas - 5) * 20
            Sino total = 380
            FinSi
        FinSi
    FinSi
    Escribir "Total a pagar: $", total
FinAlgoritmo