package TDA;

public class LinkedDictionary<K extends Comparable<K>, V> implements Dictionary<K, V> {

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
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterable<V> get(K k) {
		if (size == 0) {
			return null;
		}
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null && !actual.getElement().getKey().equals(k)) {
			actual = actual.getNext();
		}
		if (actual != null) {
			List<V> listaValores = actual.getElement().getValue();
			LinkedList<V> copiaValores = new LinkedList<>();
			listaValores.getFirst();
			while (!listaValores.atEnd()) {
				copiaValores.addLast(listaValores.getCurrent());
				listaValores.advance();
			}
			return copiaValores;
		}
		return null;
	}

	@Override
	public void put(K k, V v) {
		if (size == 0) {
			List<V> listaValores = new LinkedList<>();
			listaValores.addFirst(v);
			Entrada<K, List<V>> entrada = new Entrada<>(k, listaValores);
			Node<Entrada<K, List<V>>> nuevoNodo = new Node<>(entrada, null, null);
			head = nuevoNodo;
			tail = nuevoNodo;
			size++;
		} else {
			Node<Entrada<K, List<V>>> actual = head;
			while (actual != null && !actual.getElement().getKey().equals(k)) {
				actual = actual.getNext();
			}
			if (actual != null) {
				actual.getElement().getValue().addLast(v);
			} else {
				List<V> listaValores = new LinkedList<>();
				listaValores.addFirst(v);
				Entrada<K, List<V>> entrada = new Entrada<>(k, listaValores);
				Node<Entrada<K, List<V>>> nuevoNodo = new Node<>(entrada, null, tail);
				tail.setNext(nuevoNodo);
				tail = nuevoNodo;
				size++;
			}
		}
	}

	@Override
	public Iterable<V> remove(K k) {
		if (size == 0) {
			return null;
		}
		if (head.getElement().getKey().equals(k)) {
			List<V> listaValores = head.getElement().getValue();
			LinkedList<V> copiaValores = new LinkedList<>();
			listaValores.getFirst();
			while (!listaValores.atEnd()) {
				copiaValores.addLast(listaValores.getCurrent());
				listaValores.advance();
			}
			head = head.getNext();
			if (head != null) {
				head.setPrev(null);
			}
			size--;
			return copiaValores;
		}
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null && !actual.getElement().getKey().equals(k)) {
			actual = actual.getNext();
		}
		if (actual != null) {
			List<V> listaValores = actual.getElement().getValue();
			LinkedList<V> copiaValores = new LinkedList<>();
			listaValores.getFirst();
			while (!listaValores.atEnd()) {
				copiaValores.addLast(listaValores.getCurrent());
				listaValores.advance();
			}
			if (actual.getPrev() != null) {
				actual.getPrev().setNext(actual.getNext());
			}
			if (actual.getNext() != null) {
				actual.getNext().setPrev(actual.getPrev());
			} else {
				tail = actual.getPrev();
			}
			size--;
			return copiaValores;
		}
		return null;
	}

	@Override
	public V remove(K k, V v) {
		if (size == 0) {
			return null;
		}
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null && !actual.getElement().getKey().equals(k)) {
			actual = actual.getNext();
		}
		if (actual != null) {
			List<V> listaValores = actual.getElement().getValue();
			try {
				listaValores.remove(v);
				if (listaValores.getSize() == 0) {
					if (actual.getPrev() != null) {
						actual.getPrev().setNext(actual.getNext());
					}
					if (actual.getNext() != null) {
						actual.getNext().setPrev(actual.getPrev());
					} else {
						tail = actual.getPrev();
					}
					size--;
				}
				return v;
			} catch (MyException e) {
				return null;
			}
		}
		return null;
	}

	@Override
	public Iterable<K> keys() {
		LinkedList<K> claves = new LinkedList<>();
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null) {
			claves.addLast(actual.getElement().getKey());
			actual = actual.getNext();
		}
		return claves;
	}

	@Override
	public Iterable<Entrada<K, Iterable<V>>> entries() {
		LinkedList<Entrada<K, Iterable<V>>> entradas = new LinkedList<>();
		Node<Entrada<K, List<V>>> actual = head;
		while (actual != null) {
			List<V> listaValores = actual.getElement().getValue();
			LinkedList<V> copiaValores = new LinkedList<>();
			listaValores.getFirst();
			while (!listaValores.atEnd()) {
				copiaValores.addLast(listaValores.getCurrent());
				listaValores.advance();
			}
			entradas.addLast(new Entrada<>(actual.getElement().getKey(), copiaValores));
			actual = actual.getNext();
		}
		return entradas;
	}
}
