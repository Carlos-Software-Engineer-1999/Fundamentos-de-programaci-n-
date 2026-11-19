public class ListaDoble {
    NodoDoble cabeza;
    NodoDoble cola;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarAlInicio(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        System.out.println("✅ Insertado al inicio: " + dato);
    }

    public void insertarAlFinal(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cola == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.anterior = cola;
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        System.out.println("✅ Insertado al final: " + dato);
    }

    public void eliminarAlInicio() {
        if (cabeza == null) {
            System.out.println("❌ La lista está vacía.");
            return;
        }
        System.out.println("❌ Eliminado del inicio: " + cabeza.dato);
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
    }

    public void eliminarAlFinal() {
        if (cola == null) {
            System.out.println("❌ La lista está vacía.");
            return;
        }
        System.out.println("❌ Eliminado del final: " + cola.dato);
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }
    }

    public void mostrarAdelante() {
        NodoDoble actual = cabeza;
        System.out.print("Lista Doble (Adelante): null <-> ");
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void mostrarAtras() {
        NodoDoble actual = cola;
        System.out.print("Lista Doble (Atrás):    null <-> ");
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }
}