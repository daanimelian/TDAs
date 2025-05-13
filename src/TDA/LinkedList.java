package TDA;

public class LinkedList<T> implements List<T>{
    protected Node<T> head = null;
    protected Node<T> tail = null;
    protected int size = 0;
    protected Node<T> current;


    public LinkedList() {}

    public void addFirst(Node<T> node) {
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
            node.setPrev(null);
            node.setNext(null);
        }
        else {
            node.setNext(this.head);
            this.head.setPrev(node);
            node.setPrev(null);
            this.head = node;

        }

        this.current = node;
        size++;

    }

    @Override
    public void addFirst(T o) {
        Node<T> node = new Node<>(o);
        this.addFirst(node);

    }

    public void addLast(Node<T> node){
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
            node.setPrev(null);
            node.setNext(null);
        }
        else{
            node.setPrev(this.tail);
            this.tail.setNext(node);
            node.setNext(null);
            this.tail = node;
        }
        this.current = node;
        size++;
    }

    @Override
    public void addLast(T o) {
        Node<T> node = new Node<>(o);
        this.addLast(node);

    }

    @Override
    public void removeFirst() {
        if (this.size == 0) {
            throw new MyException("List is empty");
        }
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        }
        else {
            Node<T> newHead = this.head.getNext();
            this.head.setNext(null);
            this.head = newHead;
            this.head.setPrev(null);
        }
        this.size--;
    }

    @Override
    public void removeLast() {

    }

    @Override
    public void removeElement(T o) {

    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
