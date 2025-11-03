package segundaFase;

import java.util.Iterator;


public class PruebaDoubleLinkedList {
	
	public static void visualizarNodos(UnorderedDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
	}
	
	
	public static void main(String[] args)  {
		
		UnorderedDoubleLinkedList<Integer> l = new UnorderedDoubleLinkedList<Integer>();
		
		System.out.print(" Lista ...............");
		System.out.println("Prueba addToRear ...............");
		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(9);
		l.addToRear(6);
		l.addToRear(9);
		l.addToRear(7);
		visualizarNodos(l);
		
		System.out.println("Prueba addToFront ...............");
		l.addToFront(4);
		visualizarNodos(l);
		
		System.out.println("Prueba addAfter ...............");
		l.addAfter(15, 9);
		visualizarNodos(l);
		
		System.out.println("Prueba remove ...............");
		l.remove(1);
		visualizarNodos(l);
		
		
		System.out.println("Prueba removeAll ...............");
		UnorderedDoubleLinkedList<Integer> l2 = new UnorderedDoubleLinkedList<Integer>();
		l2.addToRear(9);
		l2.addToRear(9);
		l2.addToRear(9);
		l2.addToRear(9);
		l2.addToRear(9);
		l2.addToRear(9);
		l2.removeAll(9);
		visualizarNodos(l2);
		
		System.out.println("Prueba removeFirst ...............");
		l.removeFirst();
		visualizarNodos(l);
		
		System.out.println("Prueba removeLast ...............");
		l.removeLast();
		visualizarNodos(l);
		
		
		System.out.println(" Num elementos: " + l.size());
		System.out.println(" Primer elemento: " + l.first());
		System.out.println(" Último elemento: " + l.last());
		
		System.out.println("Prueba Clone ...............");
		DoubleLinkedList<Integer> listaClonada = l.clone();
		System.out.println(" Num elementos lista clonada: " + listaClonada.size());
		listaClonada.visualizarNodos();	

		System.out.println("Prueba Find ...............");
		System.out.println("15? " + l.find(15));
		System.out.println("3? " + l.find(3));
		System.out.println("7? " + l.find(7));
		
		System.out.println("Prueba Contains ...............");
		System.out.println("6? " + l.contains(6));
		System.out.println("11? " + l.contains(11));
		
		System.out.println("Prueba isEmpty ...............");
		DoubleLinkedList<Integer> listaVacia = new DoubleLinkedList<Integer>();
		System.out.println("La lista listaVacia esta vacia? " + listaVacia.isEmpty());
		System.out.println("La lista l esta vacia? " + l.isEmpty());
		

		
}
}
