package TDA;
public class ArrayPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private Entrada<K, V>[] array;
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private int capacidad;

    public ArrayPriorityQueue(int tamanio) {
        array = (Entrada<K, V>[]) new Entrada[tamanio];
        capacidad = tamanio;
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
        if (this.size == 0) {
            throw new MyException("La cola está vacía.");
        }
        return array[front];
    }

    @Override
    public void insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }

        if (size == capacidad) {
            throw new RuntimeException("La cola con prioridad está llena");
        }

        Entrada<K, V> nueva = new Entrada<>(key, value);
        int i = (front + size - 1 + capacidad) % capacidad;
        int j = (front + size) % capacidad;

        while (size > 0 && array[i] != null && array[i].getKey().compareTo(key) > 0) {
            array[j] = array[i];
            j = i;
            i = (i - 1 + capacidad) % capacidad;
            if (j == front) break;
        }

        array[j] = nueva;
        size++;
    }

    @Override
    public Entry<K, V> removeMin() {
        if (size == 0) {
            throw new RuntimeException("La cola está vacía");
        }
        Entrada<K, V> min = array[front];
        array[front] = null;
        front = (front + 1) % capacidad;
        size--;
        return min;
    }
}
