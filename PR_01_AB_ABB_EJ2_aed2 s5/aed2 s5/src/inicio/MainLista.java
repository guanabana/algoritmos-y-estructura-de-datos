package inicio;

import lista.*;

public class MainLista {
    public static void main(String[] args) {
        Lista lista = new ListaImpAgregaFinal();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        System.out.println("");

        for (int i = 0; i < lista.largo(); i++) {
            System.out.println("Pos " + i + " " + lista.obtener(i));
        }
        lista.mostrar();
    }
}
