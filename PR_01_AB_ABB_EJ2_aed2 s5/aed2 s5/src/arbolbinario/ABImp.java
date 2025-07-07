package arbolbinario;

import lista.*;

public class ABImp implements AB {
    private final Nodo raiz;

    public ABImp(Nodo raiz) {
        this.raiz = raiz;
    }

    @Override
    public int cantidadDeNodos() {
        return cantidadDeNodos(this.raiz);
    }

    private int cantidadDeNodos(Nodo nodo) {
        //1.- definir casos base
        if (nodo == null) {
            return 0;
        }
        //2.- paso recursivo
        int cantDeNodosIzq = cantidadDeNodos(nodo.getIzq());
        int cantDeNodosDer = cantidadDeNodos(nodo.getDer());
        //unir soluciones
        return 1 + cantDeNodosIzq + cantDeNodosDer;
    }

    @Override
    public int cantidadDeHojas() {
        return cantidadDeHojas(this.raiz);
    }

    private int cantidadDeHojas(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.getDer() == null && nodo.getIzq() == null) {
            return 1;
        }
        int cantHojasIzq = cantidadDeHojas(nodo.getIzq());
        int cantHojasDer = cantidadDeHojas(nodo.getDer());
        return cantHojasIzq + cantHojasDer;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
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
    public boolean todosPares() {
        return todosPares(this.raiz);
    }

    private boolean todosPares(Nodo nodo) {
        if (nodo == null) {
            return true;
        }
        if (nodo.getDato() % 2 != 0) {
            return false;
        }
        return todosPares(nodo.getIzq()) && todosPares(nodo.getDer());
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
        return pertenece(nodo.getIzq(), dato) || pertenece(nodo.getDer(), dato);
    }

    @Override
    public boolean equilibrado() {
        return equilibrado(raiz);
    }

    @Override
    public int cantidadDeElementosMayores(int k) {
        return cantidadDeElementosMayores(raiz, k);
    }

    private int cantidadDeElementosMayores(Nodo nodo, int k) {
        if (nodo == null) {
            return 0;
        }
        int cant = 0;
        if (nodo.getDato() > k) {
            cant++;
        }
        return cant + cantidadDeElementosMayores(nodo.getDer(), k) + cantidadDeElementosMayores(nodo.getIzq(), k);
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
            imprimirElementosDelNivel(nodo.getIzq(), nivelActual + 1, nivel);
            imprimirElementosDelNivel(nodo.getDer(), nivelActual + 1, nivel);
        }
    }

    // | altura(subárbol_izq) - altura(subárbol_der) | <= 1
    private boolean equilibrado(Nodo nodo) {
        if (nodo == null) {
            return true;
        }
        if (Math.abs(altura(nodo.getIzq()) - altura(nodo.getDer())) > 1) {
            return false;
        }
        if (altura(nodo.getIzq()) - altura(nodo.getDer()) < -1 || altura(nodo.getIzq()) - altura(nodo.getDer()) > 1) {
            return false;
        }
        return equilibrado(nodo.getIzq()) && equilibrado(nodo.getDer());
    }

    private boolean equilibradoV2(Nodo nodo) {
        if (nodo == null) {
            return true;
        }
        return Math.abs(altura(nodo.getIzq()) - altura(nodo.getDer())) <= 1 && equilibrado(nodo.getIzq()) && equilibrado(nodo.getDer());
    }

    @Override
    public int acumuladoDeElementosMayores(int k) {
        return acumuladoDeElementosMayores(raiz, k);
    }

    private int acumuladoDeElementosMayores(Nodo nodo, int k) {
        if (nodo == null) {
            return 0;
        }
        int dato = 0;
        if (nodo.getDato() > k) {
            dato = nodo.getDato();
        }
        return dato + cantidadDeElementosMayores(nodo.getDer(), k) + cantidadDeElementosMayores(nodo.getIzq(), k);
    }

    @Override
    public void mostrarElementosMayores(int k) {
        mostrarElementosMayores(raiz, k);
    }

    private void mostrarElementosMayores(Nodo nodo, int k) {
        if (nodo != null) {
            cantidadDeElementosMayores(nodo.getIzq(), k);
            if (nodo.getDato() > k) {
                System.out.print(nodo.getDato() + " ");
            }
            cantidadDeElementosMayores(nodo.getDer(), k);
        }
    }

    @Override
    public Lista obtenerElementosMayores(int k) {
        Lista lista = new ListaImpAgregaFinal();
        obtenerElementosMayores(raiz, k, lista);
        return lista;
    }

    private void obtenerElementosMayores(Nodo nodo, int k, Lista lista) {
        if (nodo != null) {
            obtenerElementosMayores(nodo.getIzq(), k, lista);
            if (nodo.getDato() > k) {
                lista.agregar(nodo.getDato());
            }
            obtenerElementosMayores(nodo.getDer(), k, lista);
        }
    }


}
