// =====================================================
// PROGRAMA: Control de Consumo Eléctrico
// DESCRIPCIÓN: Calcula el monto mensual de electricidad
//              según el consumo en kWh y una tarifa escalonada.
// =====================================================

Algoritmo ConsumoElectrico
	
	// --- DECLARACIÓN DE VARIABLES ---
	Definir lecturaAnterior, lecturaActual, consumo Como Real
	Definir costoConsumo, cargoFijo, baseImponible Como Real
	Definir descuento, impuesto, total Como Real
	Definir tieneApoyo Como Logico
	
	// --- ENTRADA DE DATOS ---
	Escribir "--- CONTROL DE CONSUMO ELÉCTRICO ---"
	
	Escribir Sin Saltar "Ingrese la lectura anterior (kWh): "
	Leer lecturaAnterior
	
	Escribir Sin Saltar "Ingrese la lectura actual (kWh): "
	Leer lecturaActual
	
	Escribir Sin Saltar "¿La vivienda pertenece al programa de apoyo? (Verdadero/Falso): "
	Leer tieneApoyo
	
	// --- VALIDACIÓN DE DATOS ---
	// El consumo se calcula como lectura actual - lectura anterior.
	// Si la lectura actual es menor o el consumo supera 10,000 kWh, es inválido.
	consumo <- lecturaActual - lecturaAnterior
	Si lecturaAnterior < 0 O lecturaActual < lecturaAnterior O consumo > 10000 Entonces
		Escribir "Error: Lecturas inválidas. La lectura actual debe ser mayor o igual a la anterior y el consumo máximo es 10,000 kWh."
	SiNo
		// --- CÁLCULOS ---
		costoConsumo <- calcularCostoConsumo(consumo)
		cargoFijo <- 95
		baseImponible <- costoConsumo + cargoFijo
		
		descuento <- calcularDescuentoApoyo(consumo, baseImponible, tieneApoyo)
		impuesto <- calcularImpuesto(baseImponible)
		total <- calcularTotal(costoConsumo, cargoFijo, descuento, impuesto)
		
		// --- SALIDA DE RESULTADOS ---
		mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total)
	FinSi
	
FinAlgoritmo


// =====================================================
// SUBPROCESO: Calcular consumo (lectura actual - anterior)
// =====================================================
SubProceso resultado <- calcularConsumo(lecturaAnterior, lecturaActual)
	Definir resultado Como Real
	resultado <- lecturaActual - lecturaAnterior
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular costo según tarifa escalonada
// - Primeros 150 kWh: $1.20 por kWh
// - Siguientes 250 kWh (151-400): $1.80 por kWh
// - Superior a 400 kWh: $2.75 por kWh
// =====================================================
SubProceso resultado <- calcularCostoConsumo(consumo)
	Definir resultado Como Real
	Si consumo <= 150 Entonces
		resultado <- consumo * 1.20
	SiNo
		Si consumo <= 400 Entonces
			resultado <- (150 * 1.20) + ((consumo - 150) * 1.80)
		SiNo
			resultado <- (150 * 1.20) + (250 * 1.80) + ((consumo - 400) * 2.75)
		FinSi
	FinSi
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular descuento del programa de apoyo
// - Si pertenece al programa Y consume <=250 kWh: -30%
// =====================================================
SubProceso resultado <- calcularDescuentoApoyo(consumo, costoAntesImpuesto, tieneApoyo)
	Definir resultado Como Real
	Si tieneApoyo Y consumo <= 250 Entonces
		resultado <- costoAntesImpuesto * 0.30
	SiNo
		resultado <- 0
	FinSi
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular impuesto (16% sobre base imponible)
// =====================================================
SubProceso resultado <- calcularImpuesto(baseImponible)
	Definir resultado Como Real
	resultado <- baseImponible * 0.16
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular total final a pagar
// Fórmula: (costoConsumo + cargoFijo) - descuento + impuesto
// =====================================================
SubProceso resultado <- calcularTotal(costoConsumo, cargoFijo, descuento, impuesto)
	Definir resultado Como Real
	resultado <- (costoConsumo + cargoFijo) - descuento + impuesto
FinSubProceso

// =====================================================
// SUBPROCESO: Mostrar recibo final con todos los detalles
// =====================================================
SubProceso mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total)
	Escribir ""
	Escribir "--- RECIBO DE LUZ ---"
	Escribir "Consumo Total: ", consumo, " kWh"
	Escribir "Costo por Consumo: $", costoConsumo
	Escribir "Cargo Fijo: $95.0"
	Escribir "Descuento Apoyo: -$", descuento
	Escribir "Impuesto (16%): $", impuesto
	Escribir "TOTAL A PAGAR: $", total
FinSubProceso