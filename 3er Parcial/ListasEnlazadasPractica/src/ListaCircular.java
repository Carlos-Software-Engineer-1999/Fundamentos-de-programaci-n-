public class ListaCircular {
    NodoDoble cabeza;

    public ListaCircular() {
        this.cabeza = null;
    }

    public void insertarAlInicio(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            NodoDoble ultimo = cabeza;
            while (ultimo.siguiente != cabeza) {
                ultimo = ultimo.siguiente;
            }
            nuevo.siguiente = cabeza;
            ultimo.siguiente = nuevo;
            cabeza = nuevo;
        }
        System.out.println("✅ Insertado al inicio (Circular): " + dato);
    }

    public void insertarAlFinal(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            NodoDoble ultimo = cabeza;
            while (ultimo.siguiente != cabeza) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
        System.out.println("✅ Insertado al final (Circular): " + dato);
    }

    public void eliminarAlInicio() {
        if (cabeza == null) {
            System.out.println("❌ La lista circular está vacía.");
            return;
        }
        System.out.println("❌ Eliminado del inicio (Circular): " + cabeza.dato);
        if (cabeza.siguiente == cabeza) {
            cabeza = null;
        } else {
            NodoDoble ultimo = cabeza;
            while (ultimo.siguiente != cabeza) {
                ultimo = ultimo.siguiente;
            }
            cabeza = cabeza.siguiente;
            ultimo.siguiente = cabeza;
        }
    }

    public void eliminarAlFinal() {
        if (cabeza == null) {
            System.out.println("❌ La lista circular está vacía.");
            return;
        }
        if (cabeza.siguiente == cabeza) {
            System.out.println("❌ Eliminado (Circular): " + cabeza.dato);
            cabeza = null;
        } else {
            NodoDoble actual = cabeza;
            NodoDoble anterior = null;
            while (actual.siguiente != cabeza) {
                anterior = actual;
                actual = actual.siguiente;
            }
            System.out.println("❌ Eliminado del final (Circular): " + actual.dato);
            anterior.siguiente = cabeza;
        }
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista Circular: Vacía");
            return;
        }
        NodoDoble actual = cabeza;
        System.out.print("Lista Circular: ");
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(Vuelve a " + cabeza.dato + ")");
    }
}