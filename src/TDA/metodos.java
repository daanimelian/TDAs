package TDA;

public class metodos {

    public static void ordenar(int[] array){
        int size = array.length;

        for(int i=0; i < size; i++){

            for(int j=0; j < size - 1- i; j++){

                if(array[j]>array[j+1]){
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }

            }
        }

    }

}
