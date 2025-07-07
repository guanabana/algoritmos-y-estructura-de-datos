public interface ABB {

    //********************************************************** --- Ejercicio 5 Pr 01 ABB ---- *************************************************

    //Pos: Inserta el dato pasado como parámetro en el árbol manteniéndolo ordenado.
    void insertar(int x);

    // Pos: Retorna true si y solo si el dato pasado como parámetro pertenece al ABB
    boolean pertenece(int x);

    //Pos: Lista en pantalla los elementos del ABB ordenados de menor a mayor.
    void listarAscendente();

    //Pos: Lista en pantalla los elementos del ABB ordenados de mayor a menor.
    void listarDescendente();

    //Pos: Elimina el menor elemento del ABB y lo retorna.
    int borrarMinimo();

    //********************************************************** --- Ejercicio 6 Pr 01 ABB ---- *************************************************
    //Nota: Considerar que el nivel de la raíz es 0.

    /*-------  A --------Desarrolle un algoritmo que, recibiendo un valor entero k, retorne la cantidad de elementos que son mayores a k*/
    int cantidadNodosMayoresA(int valor);


    /*-------  B --------Desarrolle un algoritmo que retorne una lista con sus elementos ordenados de forma ascendente*/
    Lista crearListaAscendente();


    /*-------  C --------Desarrolle un algoritmo que, recibiendo un valor entero k, retorne una lista con los elementos que son mayores a k.*/
    Lista crearListaElemntosMayoresA(int valor);


    /*-------  D -------Desarrolle un algoritmo que, recibiendo un valor entero, retorne el nivel en que se encuentra dicho valor o -1 si no se encuentra.*/
    int obtenerNivelDeElemento(int elemento);


    /*-------  E -------Desarrolle un algoritmo que, recibiendo un valor entero k, imprima los elementos del nivel k.*/
    void mostrarElementosDeUnNivelDado(int nivel);


    /*-------  F -------Desarrolle un algoritmo que imprima el ABB en orden por niveles.*/
    void mostrarABBOrdenadoXNivel();


    /*-------  G ------- Desarrolle un algoritmo que retorne una lista de tuplas con todos los elementos del ABB y el número del nivel en el que se encuentra cada uno.*/
    Lista listaTuplasElemConNivel();


    /*-------  H -------Desarrolle un algoritmo que, recibiendo un valor entero k, imprima la cantidad de elementos del nivel k.*/
    int cantidadElementosNivel(int valor);


    /*-------  J ------- Desarrolle un algoritmo que, recibiendo un valor entero k, retorne el número de nivel del árbol que tiene mayor cantidad de nodos, considerando sólo hasta nivel k.
                         Nota: Recorrer el árbol una sola vez. Considerar utilizar un array auxiliar para guardar la cantidad de nodos por nivel.*/
    int nivelConMasCantidadNodos(int valor);


     //-------  I  NO IMPLEMENTADO -------Desarrolle un algoritmo que, recibiendo un valor de tipo String, imprima el ABB en orden por niveles, separando los niveles con el valor pasado por parámetro.

    int cantNodosNoSonHojasMayoresA(int dato);


    int cantNodosNoSonHojasMayoresAvABB(int dato);


    int cantHojasEntrevAB(int desde, int hasta);

}
