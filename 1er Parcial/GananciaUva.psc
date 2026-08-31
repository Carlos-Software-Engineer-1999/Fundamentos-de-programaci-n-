Algoritmo GananciaUva
    // 1. Declaración de variables
    Definir tipo Como Caracter
    Definir tamaño Como Entero
    Definir kilos, precioInicial, ganancia Como Real
	
    // 2. Entrada de datos (sin paréntesis ni textos extra)
    Escribir "Ingrese el tipo (A/B):"
    Leer tipo
    Escribir "Ingrese el tamaño (1/2):"
    Leer tamaño
    Escribir "Ingrese los kilos:"
    Leer kilos
	
    // 3. Proceso
    precioInicial = 0
    Si tipo = "A" Entonces
        Si tamaño = 1 Entonces
            precioInicial = precioInicial + 0.20
        Sino
            precioInicial = precioInicial + 0.30
        FinSi
    Sino
        Si tamaño = 1 Entonces
            precioInicial = precioInicial - 0.30
        Sino
            precioInicial = precioInicial - 0.50
        FinSi
    FinSi
	
    ganancia = kilos * precioInicial
	
    // 4. Salida
    Escribir "La ganancia obtenida es: $", ganancia
FinAlgoritmo