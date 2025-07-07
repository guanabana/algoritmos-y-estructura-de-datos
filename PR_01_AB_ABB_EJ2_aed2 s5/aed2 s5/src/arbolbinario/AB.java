package arbolbinario;

import lista.Lista;

public interface AB {

    int cantidadDeNodos();

    int cantidadDeHojas();

    int altura();

    boolean todosPares();

    boolean pertenece(int dato);

    boolean equilibrado();

    int cantidadDeElementosMayores(int k);

    int acumuladoDeElementosMayores(int k);

    void mostrarElementosMayores(int k);

    Lista obtenerElementosMayores(int k);

    void imprimirElementosDelNivel(int nivel);


}
