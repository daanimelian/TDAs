package TDA;

public class ArrayMap<K extends Comparable<K>, V> implements Map<K, V> {
	
	private Entrada<K,V>[] array;
	private int size;
	
	public ArrayMap() {
		array = (Entrada<K,V>[])new Entrada[100];
		size = 0;
	}
	
	public V remove(K k) {
		int i=0;
		boolean encontreClave=false;
		while(!encontreClave && i<size) {
			if(array[i].getKey()==k)
				encontreClave=true;
			else
				i++;
		}
		if(!encontreClave)
			return null;
		else {
			V auxiliar = array[i].getValue();
			array[i] = array[size-1];
			size--;
			return auxiliar;
		}
	}
	
	public V get(K k) {
		int i=0;
		boolean encontreClave=false;
		while(!encontreClave && i<size) {
			if(array[i].getKey().equals(k))
				encontreClave=true;
			else
				i++;
		}
		if(!encontreClave)
			return null;
		else {
			return array[i].getValue();
		}
	}
	
	public V put(K k, V v) {
		int i=0;
		boolean encontreClave=false;
		while(!encontreClave && i<size) {
			if(array[i].getKey()==k)
				encontreClave=true;
			else
				i++;
		}
		if(!encontreClave) {
			if(size<array.length) {
				array[size] = new Entrada(k,v);
				size++;
				return v;
			}
			else
				throw new MyException("El arreglo está lleno");
		}
		else {
			V auxiliar = array[i].getValue();
			array[i].setValue(v);
			return auxiliar;
		}
	}
	
	public int size() {return size;}
	public boolean isEmpty(){return size==0;}
	
	public Entry<K,V>[] entries(){
		Entry<K,V>[] auxArray = (Entry<K,V>[])new Entrada[size];
		for(int i=0;i<size;i++)
			auxArray[i]=new Entrada(array[i].getKey(),array[i].getValue());
		return auxArray;
	}

	/*Sobre la implementación de Diccionario Simple (Map) agregar
	un método similar a entries (que devuelve el conjunto de
	claves), llamado sortedEntries que devuelva las claves
	ordenadas de menor a mayor.*/

	public Entry<K,V>[] sortedEntries() {
		// Crear copia de las entradas
		Entry<K,V>[] auxArray = entries();

		// Ordenar con insertion sort
		for (int i = 1; i < auxArray.length; i++) {
			Entry<K,V> pivot = auxArray[i];
			int j = i - 1;
			while (j >= 0 && auxArray[j].getKey().compareTo(pivot.getKey()) > 0) {
				auxArray[j + 1] = auxArray[j];
				j--;
			}
			auxArray[j + 1] = pivot;
		}

		return auxArray;
	}



	public K[] keys() {
		//me creo un arreglo auxiliar
		K[] aux = (K[])new Object[size];
		//recorro array pidiendo las claves
		for(int i=0;i<size;i++)
		//las agrego a auxiliar
			aux[i]=array[i].getKey();
		//devuelvo auxiliar
		return aux;
	}
	
	public V[] values() {
		//me creo un arreglo auxiliar
		V[] aux = (V[])new Object[size];
		//recorro array pidiendo las claves
		for(int i=0;i<size;i++)
		//las agrego a auxiliar
			aux[i]=array[i].getValue();
		//devuelvo auxiliar
		return aux;
	}

	public static <K extends Comparable<K>> void ordenar(K[] lista) {
		for (int i = 1; i < lista.length; i++) {
			K pivot = lista[i];
			int j = i - 1;

			while (j >= 0 && lista[j].compareTo(pivot) > 0) {
				lista[j + 1] = lista[j];
				j--;
			}
			lista[j + 1] = pivot;
		}
	}

	/*Realizar el método externo
	sonDiccionariosIguales que verifique si
	son iguales dos diccionarios simples
			(Map) que se reciben por parámetro.*/

	public static boolean sonIguales(ArrayMap<Integer, String> unDiccionario, ArrayMap<Integer,String> otroDiccionario){

		if(unDiccionario.size()!=otroDiccionario.size())
			return false;
		Entry<Integer,String>[] entradasUnDiccionario = unDiccionario.entries();
		int i =0;
		boolean sonIguales=true;
		while(i<entradasUnDiccionario.length && sonIguales) {

			if (otroDiccionario.get(entradasUnDiccionario[i].getKey()) == null) {
				sonIguales=false;
			}
			else {
				sonIguales=otroDiccionario.get(entradasUnDiccionario[i].getKey()).equals(entradasUnDiccionario[i].getValue());
			}
			i++;
		}
		return sonIguales;

	}


}
