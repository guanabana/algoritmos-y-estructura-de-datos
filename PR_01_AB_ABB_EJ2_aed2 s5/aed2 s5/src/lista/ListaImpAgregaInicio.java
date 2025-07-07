package lista;

public class ListaImpAgregaInicio implements Lista {

    private Nodo inicio;
    private int cant;

    public ListaImpAgregaInicio() {
        this.inicio = null;
        this.cant = 0;
    }

    @Override
    public void agregar(int dato) {
        inicio = new Nodo(dato, inicio);
        cant++;
    }

    @Override
    public int largo() {
        return cant;
    }

    //pre existe un elemento en la pos indice
    @Override
    public int obtener(int indice) {
        Nodo aux = inicio;
        int actual = indice;
        while (actual != 0) {
            aux = aux.getSig();
            actual--;
        }
        return aux.getDato();
    }

    public int obtenerV1(int indice) {
        Nodo aux = inicio;
        int actual = 0;
        while (actual != indice) {
            aux = aux.getSig();
            actual++;
        }
        return aux.getDato();
    }

    @Override
    public void mostrar() {
        mostrar(inicio);
        System.out.println("");
    }

    private void mostrar(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            mostrar(nodo.getSig());
        }
    }
}
