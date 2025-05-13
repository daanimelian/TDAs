package TDA;


public class LinkedMap<K extends Comparable<K>, V> implements Map<K, V> {
    private Node<Entrada<K,V>> head;
    private Node<Entrada<K,V>> tail;
    private int size;
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public V get(K k) {
        if(size==0) throw new MyException("El diccionario esta vacio.");
        Node<Entrada<K,V>> element=head;
        V val = null;
        for(int i=0; i<size && element.getElement() != null; i++) {
            if(element.getElement().getKey().equals(k)){
                val = element.getElement().getValue();
                i=size;
            }
            else{
                element=element.getNext();
            }

        }

            return val;
    }

    @Override
    public V put(K k, V v) {
        Entrada<K,V> newEntrada = new Entrada<>(k,v);
        Node<Entrada<K,V>> newElement = new Node<>(newEntrada);

        if(size == 0){
            this.head = newElement;
            this.tail = newElement;
            size++;
        }
        else{

            if(get(k) == null) {
                newElement.setPrev(this.tail);
                newElement.setNext(null);
                this.tail.setNext(newElement);
                this.tail = newElement;
                size++;
            }
            else{
                Node<Entrada<K,V>> elemento = head;
                for(int i=0; i<size; i++) {
                    if (elemento.getElement().getKey().equals(k)) {
                        elemento.getElement().setValue(v);
                        i=size;
                    }
                    else{
                        elemento = elemento.getNext();}

                }
            }
        }

        return v;
    }

    @Override
    public V remove(K k) {

        if(size==0) throw new MyException("El diccionario esta vacio.");
        Node<Entrada<K,V>> element=head;
        V val = null;

        for(int i=0; i<size && element.getElement() != null; i++) {

            if(size==1 && element.getElement().getKey().equals(k)){
                val = element.getElement().getValue();
                this.head.setNext(null);
                this.tail.setPrev(null);
                this.head = null;
                this.tail = null;
                i=size;
            }

            else if(element.getElement().getKey().equals(k) && size>1){
                val = element.getElement().getValue();
                if (element.equals(this.head)){
                    this.head = element.getNext();
                    element.setNext(null);
                    element.setPrev(null);
                    if(this.head != null){
                        this.head.setPrev(null);
                    }
                }
                else if(element.equals(this.tail)){
                    this.tail = element.getPrev();
                    element.setNext(null);
                    element.setPrev(null);
                    if(this.tail != null){
                        this.tail.setNext(null);
                    }

                }
                else{
                    Node<Entrada<K,V>> prev = element.getPrev();
                    Node<Entrada<K,V>> next = element.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                    element.setPrev(null);
                    element.setNext(null);
                }
                i=size;

            }
            else{

                element=element.getNext();
            }
        }
        if (val==null)
            throw new MyException("La key no existe.");
        else {
            size--;
            return val;
        }
    }

    @Override
    public K[] keys() {
        if(size==0) throw new MyException("El diccionario esta vacio.");
        K[] keys = (K[])new Object[size];
        Node<Entrada<K,V>> element=head;
        for(int i=0; i<size; i++) {
            K key = element.getElement().getKey();
            keys[i]=key;
            element=element.getNext();
        }
        return keys;
    }

    @Override
    public V[] values() {
        if(size==0) throw new MyException("El diccionario esta vacio.");
        V[] values = (V[])new Object[size];
        Node<Entrada<K,V>> element=head;
        for(int i=0; i<size; i++) {
            V value = element.getElement().getValue();
            values[i]=value;
            element=element.getNext();
        }

        return values;
    }

    @Override
    public Entry<K, V>[] entries() {
        if(size==0) throw new MyException("El diccionario esta vacio.");
        Entry<K, V>[] entries = (Entry<K, V>[])new Object[size];
        Node<Entrada<K,V>> element=head;
        for(int i=0; i<size; i++) {
            Entry<K, V> entry = element.getElement();
            entries[i] = entry;
            element=element.getNext();
        }
        return entries;
    }
}
