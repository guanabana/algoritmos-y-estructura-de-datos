package inicio;

import arbolbinario.*;
import lista.Lista;

public class MainABB {
    public static void main(String[] args) {
        ABB abb = new ABBImp();
        abb.insertar(4);
        abb.insertar(2);
        abb.insertar(6);
        abb.insertar(1);
        abb.insertar(3);
        abb.insertar(5);
        abb.insertar(7);
        abb.listarAscendente();
        Lista lista = abb.aplanarDecreciente();
        System.out.println("Cantidad de elementos " + lista.largo());
        lista.mostrar();
        System.out.println("");
        abb.imprimirElementosDelNivel(2);
        System.out.println();
        abb.imprimirABBPorNiveles();
    }
}
