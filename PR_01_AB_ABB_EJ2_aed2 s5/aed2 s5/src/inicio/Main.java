package inicio;

import arbolbinario.*;

public class Main {
    //psvm
    public static void main(String[] args) {

        Nodo subArbolDer = new Nodo(100);
        Nodo subArbolIzq = new Nodo(4, new Nodo(4, null, new Nodo(55)), new Nodo(12));
        Nodo raiz = new Nodo(2, subArbolIzq, subArbolDer);
        Nodo raiz2 = raiz;
        AB ab = new ABImp(raiz);
        ab.imprimirElementosDelNivel(1);
        System.out.println("Cantidad de nodos: " + ab.cantidadDeNodos());
        System.out.println("Cantidad de hojas: " + ab.cantidadDeHojas());
        System.out.println("Altura: " + ab.altura());
        System.out.println("Todos pares: " + ab.todosPares());
        System.out.println("Pertenece: " + ab.pertenece(10));
        System.out.println("Equilibrado: " + ab.equilibrado());
    }
}
