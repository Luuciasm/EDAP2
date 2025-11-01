package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> last;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList() {
        	last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondici�n: 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T info = null;
		if(last!=null) {
			if(last.next==null) {
				info = last.data;
				last = null;
			}else {
				info = last.next.data;
				last.next.prev = last;
				last.next = last.next.next;
			}
			count--;
		}
		return info;

	}

	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: 
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T info = null;
		if(last!=null) {
			if(last.next == last) {
				info = last.data;
				last = null;
			}else {
				info = last.data;
				last.next.prev = last.prev;
				last.prev.next = last.next;
				last = last.prev;
			}
			count--;
		}
		return info;
		   }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T info = null;
		boolean esta = false;
		if(last!=null) {
			Node<T> actual = last;
			do {
				if(actual.data.equals(elem)) {
					esta = true;
				}else {
					actual = actual.next;
				}
			}while(!esta && actual != last);
			if(esta) {
				if(actual.next == actual) {
					info = last.data;
					last = null;
				}else {
					actual.prev.next = actual.next;
					actual.next.prev = actual.prev;
					if(actual == last) {
						last = last.prev;
					}
				}
				count --;
			}
		}
		return info;
	}
	
	public void removeAll(T elem) {
	//Elimina todas las apariciones de un elemento de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(last!=null) {
			Node<T> actual = last;//O(1)
			do {
				if(actual.data.equals(elem)) {
					if(actual==actual.next) {
						last=null; //O(1)
					}else {
						actual.prev.next = actual.next;
						actual.next.prev = actual.prev;
						if(actual == last) {
							last = last.prev;
						}
					}
					count --;
				}else {
					actual = actual.next;
				}
			}while(actual.prev != last);
		}
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T first = null;
		if(last != null) {
			first = last.next.data;
		}
		return first;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T ult = null;
		if(last != null) {
			ult = last.data;
		}
		return ult;
	}

	public DoubleLinkedList<T> clone(){
		// Devuelve una copia de la lista (no duplica el puntero)
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		DoubleLinkedList<T> nueva = new DoubleLinkedList<T>();
	    Node<T> actual = last.next;
	    nueva.last = null;
	    do {
	        Node<T> nuevo = new Node<>(actual.data);
	        if (nueva.last == null) {
	            nueva.last = nuevo;
	            nuevo.next = nuevo;
	            nuevo.prev = nuevo;
	        } else {
	            nuevo.prev = nueva.last;
	            nueva.last.next = nuevo;
	            nuevo.next = nueva.last;
	            nueva.last.prev = nuevo;
	            nueva.last = nuevo; // avanzar el puntero "last"
	        }
	        actual = actual.next;
	        nueva.count++;
	    } while (actual.prev != last.next);
	    return nueva;
	} 


	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
	      boolean rdo = true;
	      if(find(elem) == null) {
				rdo = false;
			}
			return rdo;
		      
	}

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T rdo = null;
		boolean esta = false;
		Node <T> actual = last.next;
		do {
			if(actual.data.equals(elem)) {
				esta = true;
			}else {
				actual = actual.next;
			}
		}while(!esta && actual.prev != last);
		if(esta) {
			rdo = actual.data;
		}
		return rdo;

	}

	public boolean isEmpty(){ 
	//Determina si la lista est� vac�a
	 // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(last == null) {
			return true;
		}else {
			 return false;
		}
}
	
	public int size(){ 
	//Determina el n�mero de elementos de la lista
	 // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		return count;
}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 

		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		   Node<T> actual;
			int cont;
			public ListIterator() {
				cont = 0;
				if(last == null) {
					actual = null;
				}else {
					actual = last.next;
				}

			} // private class
			@Override
			public boolean hasNext() {
				if(cont == count) {
					return false;
				}
				return true;
			}


			@Override
			public T next() {
				T info = actual.data;
				actual = actual.next;
				cont ++;
				return info;
			}


		   

		   }
		
		
         public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "DoubleLinkedList " + result + "]";
		}



}
