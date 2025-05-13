package TDA;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


public interface PriorityQueue<K extends Comparable<K>, V> {
    /*Retorna el número de entradas en P.*/
    int size();

    /*Testea si P es vacía*/
    boolean isEmpty();

   /* Retorna (pero no remueve) una entrada de P con la prioridad más pequeña;
    ocurre un error si P está vacía.*/
    Entry<K, V> min();

    /*Inserta en P una entrada con prioridad k y valor v; ocurre un error si k es
    inválida (k es nula).*/
    void insert(K var1, V var2);

    /*Remueve de P y retorna una entrada con la prioridad más pequeña; ocurre
    una condición de error si P está vacía*/
    Entry<K, V> removeMin();
}
