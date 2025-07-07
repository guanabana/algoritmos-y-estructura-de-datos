import java.util.ArrayList;

public class ABBImpl implements ABB {

    private NodoABB raiz;


    @Override
    public void insertar(int dato) {
        if (raiz != null) {
            insertar(raiz, dato);
        } else {
            raiz = new NodoABB(dato);
        }

    }


    private void insertar(NodoABB nodo, int dato) {
        if (dato < nodo.getDato()) {
            if (nodo.getIzq() == null) {
                nodo.setIzq(new NodoABB(dato));
            } else {
                insertar(nodo.getIzq(), dato);
            }
        } else {
            if (nodo.getDer() == null) {
                nodo.setDer(new NodoABB(dato));
            } else {
                insertar(nodo.getDer(), dato);
            }
        }

    }

    @Override
    public boolean pertenece(int dato) {

        return pertenece(raiz, dato);
    }


    private boolean pertenece(NodoABB nodo, int dato) {

        if (nodo != null) {
            if (dato == nodo.getDato()) {
                return true;
            } else if (dato < nodo.getDato()) {
                return pertenece(nodo.getIzq(), dato);
            } else {
                return pertenece(nodo.getDer(), dato);
            }
        } else {
            return false;
        }
    }

    @Override
    public void listarAscendente() {
        // In Orden
        listarAscendente(raiz);
    }

    private void listarAscendente(NodoABB nodo) {
        if (nodo != null) {
            listarAscendente(nodo.getIzq());
            System.out.print(nodo.getDato() + "-");
            listarAscendente(nodo.getDer());
        }
    }

    @Override
    public void listarDescendente() {
        //in order
        listarDescendente(raiz);
    }

    private void listarDescendente(NodoABB nodo) {
        if (nodo != null) {
            listarDescendente(nodo.getDer());
            System.out.print(nodo.getDato() + "-");
            listarDescendente(nodo.getIzq());


        }
    }

    @Override
    public int borrarMinimo() {

        return borrarMinimo(raiz);

    }


    private int borrarMinimo(NodoABB nodo) {

        if (nodo != null) {
            if (nodo.getIzq().getIzq() == null) {
                if (nodo.getIzq().getDer() == null) {
                    int datoABorrar = nodo.getIzq().getDato();
                    nodo.setIzq(null);
                    return datoABorrar;
                } else {
                    int datoABorrar = nodo.getIzq().getDato();
                    nodo.setIzq(nodo.getIzq().getDer());
                    return datoABorrar;
                }

            } else {
                return borrarMinimo(nodo.getIzq());

            }
        } else {
            return -1;
        }

    }

    //*-------  A ------
    @Override
    public int cantidadNodosMayoresA(int valor) {
        return cantidadNodosMayoresA(raiz, valor);

    }

    private int cantidadNodosMayoresA(NodoABB nodo, int valor) {

        if (nodo != null) {

            if (nodo.getDato() > valor) {
                return 1 + cantidadNodosMayoresA(nodo.getDer(), valor) + cantidadNodosMayoresA(nodo.getIzq(), valor);
            } else {
                return cantidadNodosMayoresA(nodo.getDer(), valor);

            }
        } else {
            return 0;
        }
    }

    //---------B
    @Override
    public Lista crearListaAscendente() {
        Lista listAsc = new Lista();
        crearListaAscendente(raiz, listAsc);
        return listAsc;
    }

    private void crearListaAscendente(NodoABB nodo, Lista listAsc) {

        if (nodo != null) {
            crearListaAscendente(nodo.getIzq(), listAsc);
            listAsc.agregarFinal(new NodoLista(nodo.getDato()));
            crearListaAscendente(nodo.getDer(), listAsc);

        }


    }

    //---------- C
    @Override
    public Lista crearListaElemntosMayoresA(int valor) {
        Lista listMayA = new Lista();
        crearListaElemntosMayoresA(listMayA, raiz, valor);
        return listMayA;
    }

    private void crearListaElemntosMayoresA(Lista listMayA, NodoABB nodo, int valor) {

        if (nodo != null) {
            if (nodo.getDato() > valor) {
                listMayA.agregarFinal(new NodoLista(nodo.getDato()));
                crearListaElemntosMayoresA(listMayA, nodo.getIzq(), valor);
                crearListaElemntosMayoresA(listMayA, nodo.getDer(), valor);
            } else {
                crearListaElemntosMayoresA(listMayA, nodo.getDer(), valor);
            }
        }

    }


    //------------D
    @Override
    public int obtenerNivelDeElemento(int elemento) {

        return obtenerNivelDeElemento(raiz, 0, elemento);
    }

    private int obtenerNivelDeElemento(NodoABB nodo, int nivel, int elemento) {
        if (nodo != null) {
            if (nodo.getDato() == elemento) {
                return nivel;
            } else {
                if (nodo.getDato() < elemento) {
                    return obtenerNivelDeElemento(nodo.getDer(), nivel + 1, elemento);
                } else {
                    return obtenerNivelDeElemento(nodo.getIzq(), nivel + 1, elemento);
                }
            }

        } else {
            return -1;
        }

    }

    //------------E
    @Override
    public void mostrarElementosDeUnNivelDado(int nivel) {

        mostrarElementosDeUnNivelDado(raiz, 0, nivel);

    }


    private void mostrarElementosDeUnNivelDado(NodoABB nodo, int nivelActual, int nivelRecibido) {
        if (nodo != null) {
            if (nivelActual == nivelRecibido) {
                System.out.println(nodo.getDato());
            } else {
                mostrarElementosDeUnNivelDado(nodo.getIzq(), nivelActual + 1, nivelRecibido);
                mostrarElementosDeUnNivelDado(nodo.getDer(), nivelActual + 1, nivelRecibido);
            }

        }


    }

    //------------F
    @Override
    public void mostrarABBOrdenadoXNivel() {

        int altura = altura();

        for (int i = 0; i <= altura; i++) {
            mostrarElementosDeUnNivelDado(raiz, 0, i);
        }
    }


    private void mostrarABBOrdenadoXNivel(NodoABB nodo, int nivelActual, int nivelAImprimir) {

        if (nodo != null) {
            if (nivelActual == nivelAImprimir) {
                System.out.println("nivel " + nivelActual + " " + nodo.getDato());
            }
            mostrarABBOrdenadoXNivel(nodo.getIzq(), nivelActual + 1, nivelAImprimir);
            mostrarABBOrdenadoXNivel(nodo.getDer(), nivelActual + 1, nivelAImprimir);
        }

    }

    //------------G
    @Override
    public Lista listaTuplasElemConNivel() {

        Lista list = new Lista();
        listaTuplasElemConNivel(raiz, 0, list);
        return list;

    }


    private void listaTuplasElemConNivel(NodoABB nodo, int nivelActual, Lista list) {

        if (nodo != null) {
            list.agregarFinal(new NodoLista(nodo.getDato(), nivelActual));
            listaTuplasElemConNivel(nodo.getIzq(), nivelActual + 1, list);
            listaTuplasElemConNivel(nodo.getDer(), nivelActual + 1, list);
        }
    }

    //------------H
    @Override
    public int cantidadElementosNivel(int valor) {

        return cantidadElementosNivel(raiz, 0, valor);

    }

    private int cantidadElementosNivel(NodoABB nodo, int nivelActual, int valor) {

        if (nodo != null) {
            if (nivelActual == valor) {
                return 1;
            }
            return cantidadElementosNivel(nodo.getIzq(), nivelActual + 1, valor) + cantidadElementosNivel(nodo.getDer(), nivelActual + 1, valor);

        } else {
            return 0;
        }
    }

    //------------J
    @Override
    public int nivelConMasCantidadNodos(int valor) {

        int[] vec = new int[altura() + 1];
        nivelConMasCantidadNodos(raiz, 0, valor, vec);
        return eLmaxElemento(vec);
    }

    private void nivelConMasCantidadNodos(NodoABB nodo, int nivelActual, int valor, int[] vec) {

        if (nodo != null) {
            if (nivelActual <= valor) {
                vec[nivelActual] += 1;
            }
            nivelConMasCantidadNodos(nodo.getIzq(), nivelActual + 1, valor, vec);
            nivelConMasCantidadNodos(nodo.getDer(), nivelActual + 1, valor, vec);
        }


    }

    public int cantNodosNoSonHojasMayoresA(int dato) {
        return cantNodosNoSonHojasMayoresA(raiz, dato);
    }

    private int cantNodosNoSonHojasMayoresA(NodoABB nodo, int dato) {
        if (nodo == null) {
            return 0;
        }
        if (!esHoja(nodo) && dato < nodo.getDato()) {
            return 1 + cantNodosNoSonHojasMayoresA(nodo.getIzq(), dato) + cantNodosNoSonHojasMayoresA(nodo.getDer(), dato);
        } else {
            return cantNodosNoSonHojasMayoresA(nodo.getIzq(), dato) + cantNodosNoSonHojasMayoresA(nodo.getDer(), dato);
        }
    }


    public int cantNodosNoSonHojasMayoresAvABB(int dato) {
        return cantNodosNoSonHojasMayoresAvABB(raiz, dato);
    }

    private int cantNodosNoSonHojasMayoresAvABB(NodoABB nodo, int dato) {
        if (nodo == null) {
            return 0;
        }

        if (dato < nodo.getDato() && !esHoja(nodo)) {
            return 1 + cantNodosNoSonHojasMayoresAvABB(nodo.getIzq(), dato) + cantNodosNoSonHojasMayoresAvABB(nodo.getDer(), dato);
        } else {
            return cantNodosNoSonHojasMayoresAvABB(nodo.getDer(), dato);
        }

    }

    private boolean esHoja(NodoABB nodo) {
        return nodo.getIzq() == null && nodo.getDer() == null;
    }


    public int cantHojasEntrevAB(int desde, int hasta) {
        return cantHojasEntrevAB(raiz, desde, hasta);
    }

    private int cantHojasEntrevAB(NodoABB nodo, int desde, int hasta) {
        if (nodo != null) {
            if (esHoja(nodo)) {
                if (nodo.getDato() >= desde && nodo.getDato() <= hasta) {
                    return 1;
                }
            }

            int cantIzq = cantHojasEntrevAB(nodo.getIzq(), desde, hasta);
            int cantDer = cantHojasEntrevAB(nodo.getDer(), desde, hasta);
            return cantIzq + cantDer;

        } else {
            return 0;
        }

    }

    public int altura() {

        return altura(raiz);
    }

    private int altura(NodoABB nodo) {
        if (nodo == null) {
            return -1;
        } else if (nodo.getIzq() == null && nodo.getDer() == null) {
            return 0;
        } else {
            return 1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer()));
        }
    }

    //*************************************ES DE VECTORES !!! ***********************///////////////////
    public int eLmaxElemento(int[] vec) {
        return eLmaxElemento(vec, 0);
    }

    private int eLmaxElemento(int[] vector, int posDesde) {

        if (posDesde == vector.length - 1) {
            return vector[posDesde];
        }
        int minimoIzq = vector[posDesde];
        int minimoDerecha = eLmaxElemento(vector, posDesde + 1);

        return Math.max(vector[posDesde], eLmaxElemento(vector, posDesde + 1));

    }


}
