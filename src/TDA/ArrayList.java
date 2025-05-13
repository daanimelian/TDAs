package TDA;
public class ArrayList <T> implements List <T>{

    private T [] lista;
    private int size;
    public ArrayList(int tamanio) {
        lista = (T[]) new Object[tamanio];
        size = 0;
    }

    public void addFirst(T newElement) {
        if(size == lista.length)
            resize();
        for(int i=size; i>0;i--) {
            lista[i] = lista[i-1];
        }
        lista[0]=newElement;
        size++;
    }
    public void addLast(T newElement) {
        if(size == lista.length)
            resize();
        lista[size] = newElement;
        size++;
    }
    public void removeFirst() {
        if(size == 0)
            throw new MyException("La lista esta vacia");
        for(int i =0; i<size;i++) {
            lista[i]=lista[i+1];
        }
        size--;
    }
    public void removeLast() {
        if(size == 0)
            throw new MyException("La lista esta vacia");
        lista[size-1]= null;
        size--;
    }

    @Override
    public void removeElement(T o) {

    }

    public void remove(T element) {
        if(size == 0)
            throw new MyException("La lista esta vacia");
        int indiceAEliminar = 0;
        for(int i =0; i<size;i++) {
            if(element.equals(lista[i]))
                indiceAEliminar = i;
        }
        for(int i = indiceAEliminar;i<size;i++) {
            lista[i]=lista[i+1];
        }
        size--;
    }
    public T getFirst() {
        if(size == 0)
            throw new MyException("La lista esta vacia");
        return lista[0];
    }
    public T getLast() {
        if(size == 0)
            throw new MyException("La lista esta vacia");
        return lista[size-1];
    }


    public int getSize() {
        return size;
    }
    private void resize() {
        int nuevoTamanio = lista.length *2;
        T [] listaNueva = (T[]) new Object[nuevoTamanio];
        for (int i=0; i<lista.length;i++) {
            listaNueva[i]=lista[i];
        }
        lista=listaNueva;
    }

    public T get(int index) {
        return lista[index];
    }


}