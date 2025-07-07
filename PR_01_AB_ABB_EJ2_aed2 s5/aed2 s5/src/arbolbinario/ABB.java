package arbolbinario;

import lista.Lista;

public interface ABB {
    void insertar(int dato);

    boolean pertenece(int dato);

    void listarAscendente();

    void listarDescendente();

    int borrarMinimo();

    int altura();

    Lista aplanarCreciente();

    Lista aplanarDecreciente();

    int cantidadDeElementosMayores(int k);

    void imprimirElementosDelNivel(int nivel);

    void imprimirABBPorNiveles();
}
