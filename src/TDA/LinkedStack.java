package TDA;

public class LinkedStack<T> implements Stack<T> {
    protected Node<T> head = null;
    protected Node<T> tail = null;
    protected int size = 0;
    protected Node<T> current;

    public LinkedStack() {}
    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        if (size == 0) {
            newNode.setNext(null);
            newNode.setPrev(null);
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            tail.setNext(newNode);
            newNode.setPrev(this.tail);
            newNode.setNext(null);
            this.tail = newNode;

        }
        ++size;

    }

    @Override
    public T pop() {
        Node<T> node;

        if (size == 0) {
            throw new MyException("Stack is empty");
        } else if (size == 1) {
            node = this.head;
            this.head = null;
            this.tail = null;
        } else {
            node = this.tail;
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }

        node.setPrev(null);
        node.setNext(null);

        --size;
        return node.getElement();
    }

    @Override
    public T top() {
         if (size == 0) {
             throw new MyException("Stack is empty");
         }
         else {
             return tail.getElement();
         }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void invertir() {
        LinkedStack<T> auxiliar = new LinkedStack<>();

        while (this.size() > 0) {
            auxiliar.push(this.pop());
        }

        while (auxiliar.size() > 0) {
            this.push(auxiliar.pop());
        }
    }


}
