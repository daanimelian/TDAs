package TDA;

public class ArrayStack<T> implements Stack<T> {
    private T[] pila;
    private int size;

    public ArrayStack(int tamanio) {
        pila = (T[]) new Object[tamanio];
        size = 0;
    }

    @Override
    public void push(T item) {
        if (size == pila.length) {
            this.resize();
        }
        pila[this.size] = item;
        ++this.size;

    }

    @Override
    public T pop() {
            if (size == 0) {
                throw new MyException("La pila está vacía");
            }

            T lastElement = this.pila[this.size - 1];
            this.pila[this.size - 1] = null;
            this.size--;
            return lastElement;
        }


    @Override
    public T top() {
        if (size == 0) {
            throw new MyException("La lista esta vacia");

        }
        return this.pila[this.size-1];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void resize(){
        Object[] newArray = new Object[2 * this.pila.length];

        for(int i = 0; i < this.pila.length; ++i) {
            newArray[i] = this.pila[i];
        }

        this.pila = (T[])newArray;
    }

    public void invertir() {
        ArrayStack<T> auxiliar = new ArrayStack<>(this.size());

        while (this.size() > 0) {
            T elemento = this.pop();
            auxiliar.push(elemento);
        }

        while (auxiliar.size() > 0) {
            this.push(auxiliar.pop());
        }
    }


}
