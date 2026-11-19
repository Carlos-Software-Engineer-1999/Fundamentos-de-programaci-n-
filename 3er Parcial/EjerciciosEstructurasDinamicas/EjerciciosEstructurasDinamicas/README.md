# 📚 Práctica: Estructuras Dinámicas de Datos en Java

Este proyecto contiene la resolución de tres ejercicios prácticos enfocados en el uso de **Estructuras Dinámicas de Datos** (específicamente Listas Enlazadas y Colas) mediante el uso de la clase nativa `java.util.LinkedList` de Java. 

A diferencia de los arreglos estáticos, estas estructuras permiten que el programa solicite memoria a medida que se necesite, adaptándose al número de elementos que el usuario ingrese.

---

## 🗂️ Estructura del Proyecto

El proyecto se divide en tres programas independientes. Cada uno cuenta con su propio método `main` y se ejecuta de forma autónoma:

1.  **`SistemaEstudiantes.java`**
2.  **`SistemaClientes.java`**
3.  **`SistemaTareas.java`**

---

## 🎓 Ejercicio 1: Sistema de administración de estudiantes (`SistemaEstudiantes.java`)

Permite gestionar un grupo de estudiantes y sus calificaciones. Implementa un menú interactivo con las siguientes funcionalidades:
*   Registrar estudiantes (evitando matrículas duplicadas).
*   Mostrar la lista completa de estudiantes ordenada alfabéticamente.
*   Buscar un estudiante específico mediante su matrícula.
*   Modificar la calificación de un estudiante ya registrado.
*   Eliminar estudiantes de la lista.
*   Calcular y mostrar el promedio general del grupo.
*   Identificar al estudiante con la calificación más alta y más baja.
*   Filtrar y mostrar únicamente a los estudiantes con calificación mayor a 9.

---

## 🎓 Ejercicio 2: Sistema de atención de clientes (`SistemaClientes.java`)

Simula el funcionamiento de una fila de espera (el primero en llegar es el primero en ser atendido). Utiliza la estructura FIFO (First In, First Out) con las siguientes opciones:
*   Registrar clientes asignándoles un número de turno automático.
*   Atender al siguiente cliente en la fila (lo elimina de la espera).
*   Mostrar quién es el siguiente cliente a ser atendido sin eliminarlo.
*   Mostrar la lista completa de todos los clientes pendientes.
*   Consultar el número total de clientes esperando en la fila.
*   Cancelar un turno específico (elimina al cliente de la fila por su número de turno).

---

## 🎓 Ejercicio 3: Sistema de gestión de tareas pendientes (`SistemaTareas.java`)

Un organizador dinámico de actividades diarias que permite manipular los elementos en distintas posiciones de la lista. Menú interactivo con las siguientes funciones:
*   Registrar tareas (ID, descripción y prioridad).
*   Agregar tareas al inicio o al final de la lista.
*   Insertar una tarea en una posición específica (índice).
*   Eliminar una tarea por su identificador (ID).
*   Buscar tareas por coincidencia en la descripción.
*   Mostrar todas las tareas pendientes con su estado actual.
*   Marcar una tarea como "Completada".
*   Mostrar cuál fue la primera y la última tarea registrada.
*   Recorrer e imprimir la lista en orden inverso (del final al inicio).

---

## 💻 ¿Cómo ejecutar los programas?

**Importante:** No hay un programa principal que ejecute todo. Debes probar cada sistema por separado.

1. Abre el proyecto en **IntelliJ IDEA**.
2. Haz doble clic en cualquiera de los tres archivos (por ejemplo, `SistemaEstudiantes.java`).
3. Busca el botón verde de **Run** (▶) al lado de `public static void main(String[] args)` y haz clic en él.
4. La consola se detendrá y te mostrará un menú. **El programa no imprime datos automáticamente**; requiere que tú escribas el número de la opción que deseas probar y presiones *Enter* para interactuar con él.
5. Cuando termines de probar un sistema, cierra esa pestaña de la consola y dale "Run" al siguiente archivo.

---

## 🛠️ Detalles Técnicos
*   **Lenguaje:** Java.
*   **Entrada de datos:** Se utiliza la clase `java.util.Scanner` para leer las entradas del teclado del usuario (cumpliendo el requisito de que todos los datos son introducidos por el usuario).
*   **Estructuras dinámicas:** Se utiliza `java.util.LinkedList` para almacenar los objetos (Estudiantes, Clientes y Tareas), aprovechando sus métodos nativos como `addFirst()`, `addLast()`, `poll()`, `sort()` e iteradores inversos.

---
*Desarrollado por: Carlos Navarrete Tapia*