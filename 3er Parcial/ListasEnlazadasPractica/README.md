# 🚀 Práctica: Listas Enlazadas Dobles y Circulares en Java

Este proyecto es una aplicación de consola interactiva desarrollada en **Java** que implementa desde cero (usando nodos y punteros) dos estructuras de datos dinámicas: **Listas Doblemente Enlazadas** y **Listas Circulares**.

Fue desarrollado como parte de la práctica de la materia de Estructuras de Datos, demostrando el manejo de memoria dinámica, referencias autorreferenciales y punteros.

---

## 🛠️ Características del Programa

El programa cuenta con un menú interactivo en consola donde el usuario puede elegir entre trabajar con una lista doble o una circular, realizando las siguientes operaciones:

### Lista Doblemente Enlazada
*   **Insertar al inicio:** Agrega un nodo al principio, actualizando los punteros `anterior` y `siguiente`.
*   **Insertar al final:** Agrega un nodo al final, enlazándolo con la cola actual.
*   **Eliminar al inicio:** Remueve el primer nodo y actualiza la nueva cabeza.
*   **Eliminar al final:** Remueve el último nodo y actualiza la nueva cola.
*   **Mostrar lista:** Recorre la lista en **ambas direcciones** (hacia adelante y hacia atrás), demostrando la naturaleza bidireccional de la estructura.

### Lista Circular
*   **Insertar al inicio / final:** Mantiene el enlace circular donde el último nodo siempre apunta de vuelta a la cabeza.
*   **Eliminar al inicio / final:** Ajusta los punteros para no romper el círculo.
*   **Mostrar lista:** Recorre la lista de forma infinita hasta volver a encontrar el nodo inicial.

---

## 📂 Estructura del Proyecto

El proyecto está dividido en 4 clases principales para mantener una arquitectura limpia y modular:

*   **`NodoDoble.java`**: Clase autorreferencial que define la estructura de un nodo. Contiene el dato (`int`) y dos punteros (`siguiente` y `anterior`).
*   **`ListaDoble.java`**: Contiene toda la lógica, métodos y manejo de punteros para la lista doblemente enlazada.
*   **`ListaCircular.java`**: Contiene la lógica para la lista circular (donde el último nodo apunta al primero).
*   **`Main.java`**: Es el punto de entrada del programa. Contiene el método `main`, el objeto `Scanner` y los menús interactivos para el usuario.

---

## 💻 ¿Cómo ejecutar el programa?

1. Abre el proyecto en **IntelliJ IDEA** (o cualquier IDE de Java).
2. Asegúrate de tener configurado el **JDK** (Java Development Kit).
3. Abre el archivo **`Main.java`**.
4. Haz clic en el botón verde de **Run** (▶) al lado del método `public static void main`.
5. Sigue las instrucciones en la consola interactuando con tu teclado.

---

## 📝 Nota Adicional (Implementación vs. Java Nativo)

Este proyecto implementa las listas **desde cero (Low-Level)** manipulando nodos y punteros manualmente, lo cual es fundamental para comprender cómo funcionan las estructuras de datos en memoria. 

Sin embargo, en el ámbito profesional, **Java** ya incluye la clase nativa `java.util.LinkedList`, la cual maneja internamente estos punteros. A modo de comparación, se incluyó un script alternativo (`enlazadalink.java`) que demuestra cómo se puede lograr la misma funcionalidad usando las utilidades nativas de Java.

---
*Desarrollado por: Carlos Navarrete Tapia*