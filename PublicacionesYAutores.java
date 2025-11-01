
package segundaFase;
import java.util.ArrayList;
import java.util.Iterator;

public class PublicacionesYAutores {
	
	private MapaPubli mp;
	private MapaAutores ma;
	
	public PublicacionesYAutores() {
		mp = new MapaPubli();
		ma = new MapaAutores();
		mp.cargarCitadas("Datuak/publications-citedPubs-all.txt");
		mp.cargarPublicaciones("Datuak/publications-titles-all.txt");
		mp.cargarPublisAutor("Datuak/publications-authors-all-final.txt");
		ma.cargarAutores("Datuak/authors-name-all.txt");
	}
	
	public ArrayList<Autor> obtenerListaAutores (Publicacion p){
		UnorderedDoubleLinkedList<String> lista = mp.obtenerListaAutores(p);
		ArrayList<Autor> lista2 = new ArrayList<>();
		Iterator<String> iterador = lista.iterator();
		while (iterador.hasNext()) {
			String idAutor = iterador.next();
			Autor a = ma.buscarAutor(idAutor);
			lista2.add(a);
		}
		return lista2;
	}

}
