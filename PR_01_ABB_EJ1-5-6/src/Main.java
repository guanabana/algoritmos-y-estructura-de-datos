// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ABB abb = new ABBImpl();
        ABB abb2 = new ABBImpl();

        abb.insertar(8);
        abb.insertar(4);
        abb.insertar(10);
        abb.insertar(1);
        abb.insertar(5);
        abb.insertar(9);
        abb.insertar(12);





        System.out.println(abb.pertenece(2));
        abb.listarAscendente();
        System.out.println();
        abb.listarDescendente();
        System.out.println();
        //System.out.println(abb.borrarMinimo());
        System.out.println();
        abb.listarAscendente();
        System.out.println(abb2.borrarMinimo());
        System.out.println(abb.cantidadNodosMayoresA(2));

        System.out.println("*******************************************************");

        Lista list= abb.crearListaAscendente();
        list.mostrarLista();
        abb.crearListaAscendente();

        System.out.println("*******************************************************");
        Lista list2= abb.crearListaElemntosMayoresA(3);
        list2.mostrarLista();

        System.out.println(abb.obtenerNivelDeElemento(80));
        System.out.println("*******************************************************");

        abb.mostrarElementosDeUnNivelDado(2);
        System.out.println("**************************** F - mostrarABBOrdenadoXNivel ***************************");
        abb.mostrarABBOrdenadoXNivel();

        System.out.println("********************* G - listaTuplasElemConNivel **********************************");
        Lista list3= abb.listaTuplasElemConNivel();
        list3.mostrarListaConNiveles();

        System.out.println("*********************** H - cantidadElementosNivel ********************************");
        System.out.println(abb.cantidadElementosNivel(1));

        System.out.println("************************  nivelConMasCantidadNodos *******************************");
        System.out.println(abb.nivelConMasCantidadNodos(3));


        System.out.println("************************ CantidadNodosNoSonHojasMayoresA versión AB*******************************");
        System.out.println(abb.cantNodosNoSonHojasMayoresA(8));

        System.out.println("************************ CantidadNodosNoSonHojasMayoresA versión ABB *******************************");
        System.out.println(abb.cantNodosNoSonHojasMayoresAvABB(11));


        System.out.println("************************ cantHojasEntrevAB versión AB *******************************");
        System.out.println(abb.cantHojasEntrevAB(10, 12));


    }
}