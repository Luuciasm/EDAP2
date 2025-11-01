package segundaFase;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo = new Node<T>(elem);
		if(last == null) {
			last = nuevo;
			nuevo.next = last;
			nuevo.prev = last;
			count ++;
		}else {
			boolean esta = false;
			Node<T> actual = last.next;
			do {
				if(((Comparable<T>)actual.data).compareTo(elem) > 0) {
					esta = true;
				}else {
					actual = actual.next;
				}
			}while(!esta && actual.prev != last);
			if(esta) {
				actual.prev.next = nuevo;
				nuevo.prev = actual.prev;
				actual.prev = nuevo;
				nuevo.next = actual;
			}else {
				nuevo.prev = last;
				nuevo.next = last.next;
				last.next.prev = nuevo;
				last.next = nuevo;
				last = nuevo;
			}
			count ++;
		}

	}
	
	public OrderedDoubleLinkedList<T> intersection(OrderedDoubleLinkedList<T> lista){
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		OrderedDoubleLinkedList<T> nueva = new OrderedDoubleLinkedList<T>();
		nueva.last = null;
		Node<T> actual1 = last.next;
		Node<T> actual2 = lista.last.next;
		while(actual1 != last && actual2 != lista.last) {
			if(actual1.data.equals(actual2.data)) {
				nueva.add(actual1.data);
				actual1 = actual1.next;
				actual2 = actual2.next;
			}else if(((Comparable<T>)actual1.data).compareTo(actual2.data) < 0) {
				actual1 = actual1.next;
			}else {
				actual2 = actual2.next;
			}
		}
		return nueva;

	}

}
