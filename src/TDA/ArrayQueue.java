package TDA;
public class ArrayQueue<T> implements Queue<T>{
    private int f;
    private int r;
    private int size;
    private T[] q;

    public ArrayQueue(int tamanio){
        f=0;
        r=0;
        size=0;
        q = (T[]) new Object[tamanio];;

    }

    @Override
    public void enqueue(T elemento) {
        if(size==q.length){
            throw new MyException("queue full");
        }
        else {
            q[r] = elemento;
            ++size;
            r=(r+1)%q.length;
        }


    }

    @Override
    public T dequeue() {
        T temp;
        if (this.isEmpty()) {
            throw new MyException("queue empty");
        } else {
            temp = q[f];
            q[f] = null;
            f=(f+1)%q.length;
            --size;
        }
        return temp;
    }

    @Override
    public T front() {
        if(this.isEmpty()){
            throw new MyException("queue empty");
        }
        return q[f];
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public int size() {
        return this.size;
    }
}

