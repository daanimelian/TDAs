package TDA;

import java.util.Arrays;

public class ArrayDictionary<K extends Comparable<K>, V> implements Dictionary<K, V> {
	
	private Entry<K, V[]>[] array;
	private int size;
	
	public ArrayDictionary() {
		array = (Entry<K, V[]>[]) new Entrada[100];
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Iterable<V> get(K k) {
		// TODO Auto-generated method stub
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
			V[] valores = array[i].getValue();
			int sizeValores = 0;
			while (sizeValores < valores.length && valores[sizeValores] != null) {
				sizeValores++;
			}
			V[] copiaValores = (V[]) new Object[sizeValores];
			for (int j=0; j < sizeValores; j++) {
				copiaValores[j] = valores[j];
			}
			return Arrays.asList(copiaValores);
		}
	}

	@Override
	public void put(K k, V v) {
		// TODO Auto-generated method stub
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
				V[] valores = (V[]) new Object[100];
				valores[0] = v;
				array[size] = new Entrada<K, V[]>(k, valores);
				size++;
			}
			else
				throw new MyException("El arreglo de claves está lleno");
		}
		else {
			V[] valores = array[i].getValue();
			int j = 0;
			while (j < valores.length && valores[j] != null) {
				j++;
			}
			if (j < valores.length) {  
				valores[j] = v;
			}
			else
				throw new MyException("El arreglo de valores está lleno");
		}
	}

	@Override
	public Iterable<V> remove(K k) {
		// TODO Auto-generated method stub
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
			V[] valores = array[i].getValue();
			int sizeValores = 0;
			while (sizeValores < valores.length && valores[sizeValores] != null) {
				sizeValores++;
			}
			V[] copiaValores = (V[]) new Object[sizeValores];
			for (int j=0; j < sizeValores; j++) {
				copiaValores[j] = valores[j];
			}
			array[i] = array[size-1];
			array[size-1] = null;
			size--;
			return Arrays.asList(copiaValores);
		}
	}

	@Override
	public V remove(K k, V v) {
		// TODO Auto-generated method stub
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
			V[] valores = array[i].getValue();
			int j = 0;
			boolean encontreValor = false;
			while (!encontreValor && j < valores.length && valores[j] != null) {
				if(valores[j] == v)
					encontreValor = true;
				else
					j++;
			}
			if (!encontreValor)
				return null;
			else {
				int sizeValores = j;
				while (sizeValores < valores.length && valores[sizeValores] != null) {
					sizeValores++;
				}
				valores[j] = valores[sizeValores - 1];
				valores[sizeValores - 1] = null;
				if (sizeValores - 1 == 0) {
					array[i] = array[size-1];
					array[size-1] = null;
					size--;
				}
				return v;
			}
		}
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		K[] aux = (K[]) new Object[size];
		for(int i=0; i<size; i++)
			aux[i]=array[i].getKey();
		return Arrays.asList(aux);
	}

	@Override
	public Iterable<Entrada<K, Iterable<V>>> entries() {
		// TODO Auto-generated method stub
		Entrada<K, Iterable<V>>[] entradas = (Entrada<K, Iterable<V>>[]) new Entrada[size];
		for (int i = 0; i < size; i++) {
			V[] valores = array[i].getValue();
			int sizeValores = 0;
			while (sizeValores < valores.length && valores[sizeValores] != null) {
				sizeValores++;
			}
			V[] copiaValores = (V[]) new Object[sizeValores];
			for (int j = 0; j < sizeValores; j++) {
				copiaValores[j] = valores[j];
			}
			entradas[i] = new Entrada<K, Iterable<V>>(array[i].getKey(), Arrays.asList(copiaValores));
		}
		return Arrays.asList(entradas);
	}

}
