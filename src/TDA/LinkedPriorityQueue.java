//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package TDA;

public class LinkedPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    protected Node<Entrada<K, V>> head = null;
    protected int size = 0;

    public LinkedPriorityQueue() {
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Entry<K, V> min() throws MyException {
        if (this.isEmpty()) {
            throw new MyException("La cola está vacía");
        } else {
            return this.head.getElement();
        }
    }

    @Override
    public Entry<K, V> removeMin() throws MyException {
        if (this.size == 0) {
            throw new MyException("La cola está vacía");
        } else {
            Entrada<K, V> salida = this.head.getElement();
            this.head = this.head.getNext();
            this.size--;
            return salida;
        }
    }

    @Override
    public void insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }

        Entrada<K, V> nuevoElemento = new Entrada<>(key, value);
        Node<Entrada<K, V>> nuevoNodo = new Node<>(nuevoElemento, null);

        // Si la cola está vacía, simplemente agregamos el nuevo nodo
        if (this.size == 0 || this.head.getElement().getKey().compareTo(key) > 0) {
            nuevoNodo.setNext(this.head);
            this.head = nuevoNodo;
        } else {
            // Si no está vacía, recorremos hasta el lugar adecuado
            Node<Entrada<K, V>> actual = this.head;
            while (actual.getNext() != null && actual.getNext().getElement().getKey().compareTo(key) <= 0) {
                actual = actual.getNext();
            }
            // Insertamos el nuevo nodo en el lugar adecuado
            nuevoNodo.setNext(actual.getNext());
            actual.setNext(nuevoNodo);
        }
        this.size++;
    }
}
