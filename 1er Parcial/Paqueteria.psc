Algoritmo Paqueteria
    Leer zona, pesoGramos
    Si pesoGramos > 5000 Entonces
        Escribir "Rechazado: peso excede 5kg"
    Sino
        Segun zona Hacer
            1: costo = 11
            2: costo = 10
            3: costo = 12
            4: costo = 25
            5: costo = 30
        FinSegun
        total = pesoGramos * costo
        Escribir "Costo: $", total
    FinSi
FinAlgoritmo