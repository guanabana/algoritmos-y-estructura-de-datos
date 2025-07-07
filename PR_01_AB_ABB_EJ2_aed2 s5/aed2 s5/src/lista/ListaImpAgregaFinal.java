package lista;

public class ListaImpAgregaFinal implements Lista {

    private Nodo inicio;
    private int cant;

    public ListaImpAgregaFinal() {
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
        int actual = cant - indice - 1;
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
            mostrar(nodo.getSig());
            System.out.print(nodo.getDato() + " ");
        }
    }
}
