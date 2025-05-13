package TDA;

public interface List<T> {
        public void addFirst(T newElement);
                public void addLast(T newElement);
                public void removeFirst()throws MyException;
                public void removeLast()throws MyException;
                public void remove(T element)throws MyException;
                T getFirst();
                T getLast();
                public void advance();
                public T getCurrent();
                public boolean atEnd();
                public int getSize();
        }
