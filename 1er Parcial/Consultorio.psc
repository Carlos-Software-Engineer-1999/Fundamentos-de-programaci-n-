Algoritmo Consultorio
    Leer numCita
    Si numCita <= 3 Entonces costo = 900
    Sino
        Si numCita <= 5 Entonces costo = 800
        Sino
            Si numCita <= 8 Entonces costo = 600
            Sino costo = 500
            FinSi
        FinSi
    FinSi
    Escribir "Pago por cita: ", costo
    Escribir "Total tratamiento: ", costo * numCita // Asumiendo que el tratamiento dura tantas citas como el número ingresado
FinAlgoritmo