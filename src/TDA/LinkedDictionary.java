package TDA;
public class LinkedDictionary<K, V> implements Dictionary<K, V> {
	
	protected Node<Entrada<K, List<V>>> head;
	protected Node<Entrada<K, List<V>>> tail;
	protected int size;
	
	public LinkedDictionary() {
		head = null;
		tail = null;
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
		if (size == 0) {
			return null;
		}
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null && !actual.getElem().getKey().equals(k)) {
			actual = actual.getNext();
		}
		if (actual != null) {
			List<V> listaValores = actual.getElem().getValue(); 
			LinkedList<V> copiaValores = new LinkedList<V>();
			listaValores.First();
			while (!listaValores.atEnd()) {
				copiaValores.addLast(listaValores.getCurrent());
				listaValores.advance();
			}
			return copiaValores;
		}
		else {
			return null;
		}
	}

	@Override
	public void put(K k, V v) {
		// TODO Auto-generated method stub
		if (size == 0) {
			List<V> listaValores = new LinkedList<V>();
			listaValores.addFirst(v);
			Entrada<K, List<V>> entrada = new Entrada<K, List<V>>(k, listaValores);
			Node<Entrada<K, List<V>>> nuevoNodo = new Node<Entrada<K, List<V>>>(entrada, null, null);
			head = nuevoNodo;
			tail = nuevoNodo;
			size++;
		}
		else if (head.getElem().getKey().equals( k)) {
			head.getElem().getValue().addLast(v);
		}
		else {
			Node<Entrada<K, List<V>>> actual = head;
			while (actual != null && !actual.getElem().getKey().equals(k)) {
				actual = actual.getNext();
			}
			if (actual != null) {
				actual.getElem().getValue().addLast(v);
			}
			else {
				List<V> listaValores = new LinkedList<V>();
				listaValores.addFirst(v);
				Entrada<K, List<V>> entrada = new Entrada<K, List<V>>(k, listaValores);
				Node<Entrada<K, List<V>>> nuevoNodo = new Node<Entrada<K, List<V>>>(entrada, null, tail);
				tail.setNext(nuevoNodo);	
				tail = nuevoNodo;
				size++;
			}
		}
	}

	@Override
	public Iterable<V> remove(K k) {
		// TODO Auto-generated method stub
		if (size == 0) {
			return null;
		}
		if (head.getElem().getKey().equals( k)) {
			List<V> listaValores = head.getElem().getValue();
			LinkedList<V> copiaValores = new LinkedList<V>();
			listaValores.First();
			while (!listaValores.atEnd()) {
				copiaValores.addLast(listaValores.getCurrent());
				listaValores.advance();
			}
			head.getNext().setPrevious(null);
			head = head.getNext();
			size--;
			return copiaValores;
		}
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null && actual.getElem().getKey().equals(k)) {
			actual = actual.getNext();
		}
		if (actual != null) {
			List<V> listaValores = actual.getElem().getValue();
			LinkedList<V> copiaValores = new LinkedList<V>();
			listaValores.First();
			while (!listaValores.atEnd()) {
				copiaValores.addLast(listaValores.getCurrent());
				listaValores.advance();
			}
			actual.getPrevious().setNext(actual.getNext());
			if (actual.getNext() != null) {
				actual.getNext().setPrevious(actual.getPrevious());
			}
			else {
				tail = actual.getPrevious();
			}
			size--;
			return copiaValores;
		}
		else {
			return null;
		}
	}

	@Override
	public V remove(K k, V v) {
		// TODO Auto-generated method stub
		if (size == 0) {
			return null;
		}
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null && actual.getElem().getKey() != k) {
			actual = actual.getNext();
		}
		if (actual != null) {
			List<V> listaValores = actual.getElem().getValue();
			try {
				listaValores.remove(v);
				if (listaValores.getSize() == 0) {
					actual.getPrevious().setNext(actual.getNext());
					if (actual.getNext() != null) {
						actual.getNext().setPrevious(actual.getPrevious());
					}
					else {
						tail = actual.getPrevious();
					}
					size--;
				}
				return v;
			}
			catch (MyException e) {
				return null;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		LinkedList<K> claves = new LinkedList<K>();
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null) {
			claves.addLast(actual.getElem().getKey());
			actual = actual.getNext();
		}
		return claves;
	}

	@Override
	public Iterable<Entrada<K, Iterable<V>>> entries() {
		// TODO Auto-generated method stub
		LinkedList<Entrada<K, Iterable<V>>> entradas = new LinkedList<Entrada<K, Iterable<V>>>();
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null) {
			List<V> listaValores = actual.getElem().getValue();
			LinkedList<V> copiaValores = new LinkedList<V>();
			listaValores.First();
			while (!listaValores.atEnd()) {
				copiaValores.addLast(listaValores.getCurrent());
				listaValores.advance();
			}
			entradas.addLast(new Entrada<K, Iterable<V>>(actual.getElem().getKey(), copiaValores));
			actual = actual.getNext();
		}
		return entradas;
	}

}
