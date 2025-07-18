package arbolbinario;

public class Nodo {
    private int dato;
    private Nodo izq;
    private Nodo der;

    public Nodo(int unDato) {
        this.dato = unDato;
        this.izq = null;
        this.der = null;
    }

    public Nodo(int dato, Nodo izq, Nodo der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public boolean esHoja() {
        return this.der == null && this.izq == null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    @Override
    public String toString() {
        return dato + "";
    }

}
