public class Lista {
    private NodoLista inicio;

    public NodoLista getInicio() {
        return inicio;
    }

    public void setInicio(NodoLista inicio) {
        this.inicio = inicio;
    }

    public Lista() {
        this.inicio = null;
    }

    public Lista(NodoLista inicio) {
        this.inicio = inicio;
    }

    public void agregarFinal(NodoLista nodo){
        if(inicio==null){
            inicio=nodo;
        }else{
            NodoLista aux= inicio;
            while (aux.getSiguiente()!=null){
                aux= aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }


    public void mostrarLista(){
        if(inicio!=null){
            NodoLista aux= inicio;
            while (aux.getSiguiente()!=null){
                System.out.println(aux.getDato());
                aux= aux.getSiguiente();
            }

            System.out.println(aux.getDato());
        }

    }

    public void mostrarListaConNiveles(){
        if(inicio!=null){
            NodoLista aux= inicio;
            while (aux.getSiguiente()!=null){
                System.out.println(aux.getDato() + " Nivel  " + aux.getNivel());
                aux= aux.getSiguiente();
            }

            System.out.println(aux.getDato() + " Nivel:  " + aux.getNivel() );
        }

    }


}
