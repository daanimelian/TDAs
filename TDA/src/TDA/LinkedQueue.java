package TDA;
public class LinkedQueue<E> implements Queue<E> {
    protected Node<E> head = null;
    protected Node<E> tail = null;
    protected int size = 0;

    public LinkedQueue() {
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E front() throws MyException {
        if (this.isEmpty()) {
            throw new MyException("Esta vacia");
        } else {
            return (E)this.head.getElement();
        }
    }

    public void enqueue(E elem) {
        Node<E> aux = new Node<>(elem);
        if (this.size == 0) {
            this.head = aux;
        } else {
            this.tail.setNext(aux);
        }

        this.tail = aux;
        ++this.size;
    }

    public E dequeue() throws MyException {
        if (this.size == 0) {
            throw new MyException("Esta vacia");
        } else {
            E aux = (E)this.head.getElement();
            Node<E> aux2 = this.head;
            this.head = aux2.getNext();
            aux2.setNext(null);
            --this.size;
            if (this.size == 0) {
                this.tail = null;
            }

            return aux;
        }
    }
}

