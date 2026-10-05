// =====================================================
// PROGRAMA: Cotización de Seguro de Automóvil
// DESCRIPCIÓN: Calcula el costo anual de una póliza
//              basándose en valor, edad y accidentes.
// =====================================================

Algoritmo SeguroAuto
	
	// --- DECLARACIÓN DE VARIABLES ---
	Definir valorVehiculo, tarifaBase, recargoEdad, recargoAccidentes Como Real
	Definir subtotal, descuento, costoFinal Como Real
	Definir edad, accidentes Como Entero
	Definir tieneSeguridad Como Logico
	
	// --- ENTRADA DE DATOS ---
	Escribir "--- COTIZACIÓN DE SEGURO DE AUTOMÓVIL ---"
	
	Escribir Sin Saltar "Ingrese el valor del vehículo: $"
	Leer valorVehiculo
	
	Escribir Sin Saltar "Ingrese la edad del conductor: "
	Leer edad
	
	Escribir Sin Saltar "Ingrese la cantidad de accidentes reportados: "
	Leer accidentes
	
	Escribir Sin Saltar "¿Cuenta con sistema de seguridad adicional? (Verdadero/Falso): "
	Leer tieneSeguridad
	
	// --- VALIDACIÓN DE DATOS ---
	// Si algún dato es inválido, se muestra error y termina.
	Si valorVehiculo <= 0 O edad < 18 O edad > 100 O accidentes < 0 Entonces
		Escribir "Error: Datos inválidos. Verifique el valor del vehículo, la edad (18-100) y los accidentes (>=0)."
	SiNo
		// --- CÁLCULOS PRINCIPALES ---
		tarifaBase <- calcularTarifaBase(valorVehiculo)
		recargoEdad <- calcularRecargoPorEdad(tarifaBase, edad)
		recargoAccidentes <- calcularRecargoPorAccidentes(tarifaBase, accidentes)
		subtotal <- tarifaBase + recargoEdad + recargoAccidentes
		descuento <- calcularDescuentoSeguridad(subtotal, tieneSeguridad)
		costoFinal <- calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento)
		
		// --- SALIDA DE RESULTADOS ---
		Escribir ""
		Escribir "--- RESUMEN DE COTIZACIÓN ---"
		Escribir "Tarifa Base (4%): $", tarifaBase
		Escribir "Recargo por Edad: $", recargoEdad
		Escribir "Recargo por Accidentes: $", recargoAccidentes
		Escribir "Subtotal: $", subtotal
		Escribir "Descuento por Seguridad: -$", descuento
		Escribir "Costo Final Anual: $", costoFinal
	FinSi
	
FinAlgoritmo


// =====================================================
// SUBPROCESO: Calcular tarifa base (4% del vehículo)
// =====================================================
SubProceso resultado <- calcularTarifaBase(valorVehiculo)
	Definir resultado Como Real
	resultado <- valorVehiculo * 0.04
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular recargo por edad del conductor
// - Menores de 25 años: +20%
// - Mayores de 60 años: +10%
// - Entre 25 y 60 años: sin recargo
// =====================================================
SubProceso resultado <- calcularRecargoPorEdad(tarifaBase, edad)
	Definir resultado Como Real
	Si edad < 25 Entonces
		resultado <- tarifaBase * 0.20
	SiNo
		Si edad > 60 Entonces
			resultado <- tarifaBase * 0.10
		SiNo
			resultado <- 0
		FinSi
	FinSi
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular recargo por accidentes (+8% c/u)
// =====================================================
SubProceso resultado <- calcularRecargoPorAccidentes(tarifaBase, accidentes)
	Definir resultado Como Real
	resultado <- tarifaBase * 0.08 * accidentes
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular descuento por sistema de seguridad
// - Si tiene seguridad: -5% sobre el subtotal
// =====================================================
SubProceso resultado <- calcularDescuentoSeguridad(subtotal, tieneSeguridad)
	Definir resultado Como Real
	Si tieneSeguridad Entonces
		resultado <- subtotal * 0.05
	SiNo
		resultado <- 0
	FinSi
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular costo final de la póliza
// Fórmula: tarifaBase + recargos - descuento
// =====================================================
SubProceso resultado <- calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento)
	Definir resultado Como Real
	resultado <- tarifaBase + recargoEdad + recargoAccidentes - descuento
FinSubProceso