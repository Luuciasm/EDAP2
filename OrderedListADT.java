package segundaFase;

public interface OrderedListADT<T>  extends ListADT<T> {
	
	public void add(T elem);
	// A�ade un elemento a la lista (en el lugar de orden que le corresponde)

	public OrderedDoubleLinkedList<T> intersection(OrderedDoubleLinkedList<T> lista);

}
