Algoritmo MultaVelocidad
    Leer velocidad, esCumple
    limite = 60
    Si esCumple = Verdadero Entonces limite = limite * 5
    FinSi
    Si velocidad <= limite Entonces resultado = 0
    Sino
        Si velocidad <= (limite + 20) Entonces resultado = 1
        Sino resultado = 2
        FinSi
    FinSi
    Escribir resultado
FinAlgoritmo