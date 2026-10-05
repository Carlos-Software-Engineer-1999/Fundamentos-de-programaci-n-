// =====================================================
// PROGRAMA: Sistema de Cobro Tienda en Línea
// DESCRIPCIÓN: Calcula el total de una compra considerando
//              subtotal, descuento, envío e impuesto.
// =====================================================

Algoritmo TiendaEnLinea
	
	// --- DECLARACIÓN DE VARIABLES ---
	Definir precio1, precio2, precio3 Como Real
	Definir cant1, cant2, cant3, tipoCliente Como Entero
	Definir codigoPostal Como Cadena
	Definir sub1, sub2, sub3, subtotalGeneral Como Real
	Definir descuento, envio, subtotalConDescuento, impuesto, total Como Real
	
	// --- ENTRADA DE DATOS ---
	Escribir "--- SISTEMA DE COBRO TIENDA EN LÍNEA ---"
	
	Escribir Sin Saltar "Ingrese el precio del producto 1: $"
	Leer precio1
	Escribir Sin Saltar "Ingrese la cantidad del producto 1: "
	Leer cant1
	
	Escribir Sin Saltar "Ingrese el precio del producto 2: $"
	Leer precio2
	Escribir Sin Saltar "Ingrese la cantidad del producto 2: "
	Leer cant2
	
	Escribir Sin Saltar "Ingrese el precio del producto 3: $"
	Leer precio3
	Escribir Sin Saltar "Ingrese la cantidad del producto 3: "
	Leer cant3
	
	Escribir Sin Saltar "Ingrese el tipo de cliente (1 = Regular, 2 = Frecuente): "
	Leer tipoCliente
	
	Escribir Sin Saltar "Ingrese el código postal (5 dígitos): "
	Leer codigoPostal
	
	// --- VALIDACIÓN DE DATOS ---
	// Verifica precios positivos, cantidades positivas, tipo de cliente válido y CP de 5 dígitos.
	Si precio1 <= 0 O precio2 <= 0 O precio3 <= 0 O cant1 <= 0 O cant2 <= 0 O cant3 <= 0 O (tipoCliente <> 1 Y tipoCliente <> 2) O Longitud(codigoPostal) <> 5 Entonces
		Escribir "Error: Datos inválidos. Verifique precios, cantidades, tipo de cliente o código postal."
	SiNo
		// --- CÁLCULOS ---
		sub1 <- calcularSubtotalProducto(precio1, cant1)
		sub2 <- calcularSubtotalProducto(precio2, cant2)
		sub3 <- calcularSubtotalProducto(precio3, cant3)
		subtotalGeneral <- calcularSubtotalGeneral(sub1, sub2, sub3)
		
		descuento <- calcularDescuento(subtotalGeneral, tipoCliente)
		envio <- calcularEnvio(subtotalGeneral, codigoPostal)
		subtotalConDescuento <- subtotalGeneral - descuento
		impuesto <- calcularImpuesto(subtotalConDescuento)
		
		total <- calcularTotal(subtotalGeneral, descuento, impuesto, envio)
		
		// --- SALIDA DE RESULTADOS ---
		Escribir ""
		Escribir "--- RESUMEN DE COMPRA ---"
		Escribir "Subtotal General: $", subtotalGeneral
		Escribir "Descuento: -$", descuento
		Escribir "Envío: $", envio
		Escribir "Impuesto (16%): $", impuesto
		Escribir "Total a Pagar: $", total
	FinSi
	
FinAlgoritmo


// =====================================================
// SUBPROCESO: Calcular subtotal de un producto
// Fórmula: precio × cantidad
// =====================================================
SubProceso resultado <- calcularSubtotalProducto(precio, cantidad)
	Definir resultado Como Real
	resultado <- precio * cantidad
FinSubProceso

// =====================================================
// SUBPROCESO: Sumar los subtotales de los 3 productos
// =====================================================
SubProceso resultado <- calcularSubtotalGeneral(subtotal1, subtotal2, subtotal3)
	Definir resultado Como Real
	resultado <- subtotal1 + subtotal2 + subtotal3
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular descuento según tipo de cliente
// - Cliente frecuente (2): -10%
// - Cliente regular (1): sin descuento
// =====================================================
SubProceso resultado <- calcularDescuento(subtotal, tipoCliente)
	Definir resultado Como Real
	Si tipoCliente = 2 Entonces
		resultado <- subtotal * 0.10
	SiNo
		resultado <- 0
	FinSi
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular costo de envío según subtotal
// - Menos de $1000: $150
// - Entre $1000 y $2999.99: $80
// - $3000 o más: envío gratis
// =====================================================
SubProceso resultado <- calcularEnvio(subtotal, codigoPostal)
	Definir resultado Como Real
	Si subtotal < 1000 Entonces
		resultado <- 150
	SiNo
		Si subtotal < 3000 Entonces
			resultado <- 80
		SiNo
			resultado <- 0
		FinSi
	FinSi
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular impuesto (16% sobre subtotal con descuento)
// =====================================================
SubProceso resultado <- calcularImpuesto(subtotalConDescuento)
	Definir resultado Como Real
	resultado <- subtotalConDescuento * 0.16
FinSubProceso

// =====================================================
// SUBPROCESO: Calcular total final a pagar
// Fórmula: subtotal - descuento + impuesto + envío
// =====================================================
SubProceso resultado <- calcularTotal(subtotal, descuento, impuesto, envio)
	Definir resultado Como Real
	resultado <- subtotal - descuento + impuesto + envio
FinSubProceso