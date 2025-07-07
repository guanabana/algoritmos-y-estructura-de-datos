package arbolbinario;

import lista.*;

public class ABBImp implements ABB {

    private Nodo raiz;

    public ABBImp() {
        this.raiz = null;
    }

    @Override
    public void insertar(int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
        } else {
            insertar(raiz, dato);
        }
    }

    public void insertar(Nodo nodo, int dato) {
        if (nodo.getDato() < dato) {
            if (nodo.getDer() == null) {
                nodo.setDer(new Nodo(dato));
            } else {
                insertar(nodo.getDer(), dato);
            }
        } else {
            if (nodo.getIzq() == null) {
                nodo.setIzq(new Nodo(dato));
            } else {
                insertar(nodo.getIzq(), dato);
            }
        }
    }

    @Override
    public boolean pertenece(int dato) {
        return pertenece(raiz, dato);
    }

    private boolean pertenece(Nodo nodo, int dato) {
        if (nodo == null) {
            return false;
        }
        if (nodo.getDato() == dato) {
            return true;
        }
        if (dato > nodo.getDato()) {
            return pertenece(nodo.getDer(), dato);
        } else {
            return pertenece(nodo.getIzq(), dato);
        }
    }

    @Override
    public void listarAscendente() {
        listarAscendente(raiz);
        System.out.println("");
    }

    private void listarAscendente(Nodo nodo) {
        if (nodo != null) {
            listarAscendente(nodo.getIzq());
            System.out.print(nodo.getDato() + " ");
            listarAscendente(nodo.getDer());
        }
    }

    @Override
    public void listarDescendente() {
        listarDescendente(raiz);
        System.out.println("");
    }


    private void listarDescendente(Nodo nodo) {
        if (nodo != null) {
            listarDescendente(nodo.getDer());
            System.out.print(nodo.getDato() + " ");
            listarDescendente(nodo.getIzq());
        }
    }

    @Override
    public int borrarMinimo() {
        return 0;
    }

    @Override
    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        if (nodo.esHoja()) {
            return 0;
        }
        int izq = altura(nodo.getIzq());
        int der = altura(nodo.getDer());
        return 1 + Math.max(izq, der);
    }

    @Override
    public Lista aplanarCreciente() {
        Lista lista = new ListaImpAgregaFinal();
        aplanar(raiz, lista);
        return lista;
    }

    //Para agregar elementos ordenados de forma creciente
    // recorro izq - agregoAlFinal - der
    // recorro der - agregoAlInicio - izq

    //Para agregar elementos ordenados de forma decreciente cambio la recorrida o la forma de agregar en la lista.
    //Para agregar elementos ordenados de forma decreciente
    // recorro izq - agregoAlInicio - der
    // recorro der - agregoAlFinal - izq

    // resumen
    // recorro izq - agregoAlFinal - der  / forma creciente
    // recorro der - agregoAlFinal - izq  / forma decreciente


    private void aplanar(Nodo nodo, Lista lista) {
        if (nodo != null) {
            aplanar(nodo.getIzq(), lista);
            lista.agregar(nodo.getDato());
            aplanar(nodo.getDer(), lista);
        }
    }

    @Override
    public Lista aplanarDecreciente() {
        Lista lista = new ListaImpAgregaInicio();
        aplanar(raiz, lista);
        return lista;
    }

    @Override
    public int cantidadDeElementosMayores(int k) {
        return cantidadDeElementosMayores(raiz, k);
    }

    private int cantidadDeElementosMayores(Nodo nodo, int k) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.getDato() <= k) { //Si el valor del nodo no me sirve tampoco su subarbol izquierdo, por lo que me voy hacia la derecha
            return cantidadDeElementosMayores(nodo.getDer(), k);
        } else {
            return 1 + cantidadDeElementosMayores(nodo.getDer(), k) + cantidadDeElementosMayores(nodo.getIzq(), k);
        }
    }

    @Override
    public void imprimirElementosDelNivel(int nivel) {
        imprimirElementosDelNivel(raiz, 0, nivel);
        System.out.println();
    }

    private void imprimirElementosDelNivel(Nodo nodo, int nivelActual, int nivel) {
        if (nodo != null) {
            if (nivelActual == nivel) {
                System.out.print(nodo.getDato() + " ");
            }
            if (nivelActual < nivel) {
                imprimirElementosDelNivel(nodo.getIzq(), nivelActual + 1, nivel);
                imprimirElementosDelNivel(nodo.getDer(), nivelActual + 1, nivel);
            }
        }
    }

    @Override
    public void imprimirABBPorNiveles() {
        int cant = altura(raiz);
        for (int i = 0; i <= cant; i++) {
            imprimirElementosDelNivel(i);
        }
    }


}
