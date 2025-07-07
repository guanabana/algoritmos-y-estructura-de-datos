public class NodoLista {

    private int dato;
    private int nivel;
    private NodoLista siguiente;

    public NodoLista(int dato, int nivel) {
        this.dato = dato;
        this.nivel = nivel;
    }

    public NodoLista(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}
