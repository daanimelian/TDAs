package TDA;

public interface Stack<E> {

        //Agregar elementos a la pila
        public void push(E item);
        //Desapilar y devolver el ultimo elementoa de la pila
        public E pop();
        //Devuelve el ultimo elemento agregado a la pila
        public E top();
        //Checkea si la pila esta vacia
        public boolean isEmpty();
        //Devuelve el ultimo elemento de la pila
        public int size();
    }

