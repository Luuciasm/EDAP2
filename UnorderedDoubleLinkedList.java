package segundaFase;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo = new Node<T>(elem);
		if(last == null) {
			last = nuevo;
			nuevo.next = last;
			nuevo.prev = last;
		}else {
			last.next.prev = nuevo;
			nuevo.next = last.next;
			last.next = nuevo;
			nuevo.prev = last;
		}
		count ++;

	}

	public void addToRear(T elem) {
	// a�ade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		addToFront(elem);
		last = last.next;

	}
	
	public void addAfter(T elem, T target) {
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		boolean esta = false;
		Node<T> actual = last.next;
		do {
			if(actual.data.equals(target)) {
				esta = true;
			}else {
				actual = actual.next;
			}
		}while(!esta && actual != last.next);
		Node<T> nuevo = new Node<T>(elem);
		nuevo.next = actual.next;
		nuevo.prev = actual;
		actual.next.prev = nuevo;
		actual.next = nuevo;
		if(actual == last) {
			last = nuevo;
		}
		count ++;
	}

}
