package segundaFase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MapaPubli {

    //Atributos: Declaracion de HashMaps
	private HashMap<String, OrderedDoubleLinkedList<String>> mapaPublisCitadas; //Relaciona el código con publicacion citada (String)
	private HashMap<String, Publicacion> mapaPublicaciones;//Relaciona el código con la publicacion (Publicacion)
	private HashMap<String, UnorderedDoubleLinkedList<String>> mapaPublisAutor; //Relaciona el codigo con las publicaciones del Autor (String)
                                                                // Lo hacemos de tipo String para evitar bulces infinitos
	//Constructora
    // Los HashMaps son como los ArrayList, pero mas eficientes
	public MapaPubli() {
		mapaPublisCitadas = new HashMap<>();
		mapaPublicaciones = new HashMap<>();
		mapaPublisAutor = new HashMap<>();	
	}
	

	public void cargarCitadas(String nombre) { //Crea o añade a la lista de citadas de una publi
		try {
			Scanner entrada; //Abrimos el scanner
			entrada = new Scanner(new FileReader(nombre)); //nombre=nombre del fichero
			String linea;
			while (entrada.hasNextLine()) { //Mientras exista una siguiente linea que leer
				linea = entrada.nextLine(); //Guardo la linea del fichero en la variable linea
				String info[]= linea.split("\\s+#\\s+"); //Cojo ambos datos separados por un #
				if (!mapaPublisCitadas.containsKey(info[0])) { //Si el primer codigo que he guardado no esta guardado
					mapaPublisCitadas.put(info[0], new OrderedDoubleLinkedList<String>()); //Añado el primer codigo y creo un ArrayList
                                                                            // donde guardaré las publis citadas
				}
				mapaPublisCitadas.get(info[0]).add(info[1]); // Si ya esta guardada, le añado la citada (el segundo codigo).
                                                            // Siempre se ejecuta.
			}
			entrada.close(); //Cerramos el scanner
	}catch (IOException e) { //Excepcion si no se puede leer el fichero
			e.printStackTrace();
		}
	}
	
	//Guarda las publicaciones citadas actualizadas en el fichero.
	public void guardarCitadas(String nombre) {
		try {
			PrintWriter salida = new PrintWriter(new File(nombre));
			for (String  idPublis:mapaPublisCitadas.keySet()) {
				Iterator<String> iterador = mapaPublisCitadas.get(idPublis).iterator();
				while(iterador.hasNext()) {
					String idCitas = iterador.next();
					salida.println(idPublis+" # "+idCitas);
				}
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	


	public void cargarPublicaciones(String nombre) { //Relaciona publis con sus codigos
		try {
			Scanner entrada = new Scanner(new FileReader(nombre));
			String linea;
			while (entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String info[] = linea.split("\\s+#\\s+");
				Publicacion p = new Publicacion(info[0], info[1]);
				mapaPublicaciones.put(info[0], p); //Relacionamos el codigo y la publi
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Guarda las publicaciones actualizadas en el fichero.
	public void guardarPublicaciones(String nombre) {
		try {
			PrintWriter salida = new PrintWriter(new File(nombre));
			for (Publicacion p: mapaPublicaciones.values()) {
				salida.println(p.getId()+" # "+p.getTitulo());
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	


	public void cargarPublisAutor(String nombre) { //Crea la lista de Autores de cada publi
		try {
			Scanner entrada = new Scanner(new FileReader(nombre));
			String linea;
			while (entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String info[] = linea.split("\\s+#\\s+");
				String idPubli = info[0]; //El primero codigo es el idPubli
				if (info.length == 2) {
					String idAutor = info[1]; //El segundo codigo es el idAutor
					if (!mapaPublisAutor.containsKey(idPubli)) { //Si el idPubli no se ha guardado antes
						mapaPublisAutor.put(idPubli, new UnorderedDoubleLinkedList<String>()); //Añadimos al mapa el idPubli y un array
					}                                                   //donde se guardaran los autores de esa publi
					mapaPublisAutor.get(idPubli).addToFront(idAutor); //Añadimos el idAutor aesa publi
				}                                               // se ejecuta siempre.
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void guardarAutores(String nombre) {
		try {
			PrintWriter salida = new PrintWriter(new File(nombre));
			for (String idPublis: mapaPublisAutor.keySet()) {
				Iterator<String> iterador = mapaPublisAutor.get(idPublis).iterator();
				while(iterador.hasNext()) {
					String idAutor = iterador.next();
					salida.println(idPublis+" # "+idAutor);
				}
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Publicacion buscarPubli (String id) {
		return mapaPublicaciones.get(id);
	}
	
	public void aniadirPubli (String id, String titulo) {
		Publicacion p = new Publicacion(id, titulo);
		mapaPublicaciones.put(id, p);
	}
	
	public void aniadirCita (String idPubli, String idCita) {
		if (!mapaPublisCitadas.containsKey(idPubli)) {
			mapaPublisCitadas.put(idPubli, new OrderedDoubleLinkedList<String>());
		}
		mapaPublisCitadas.get(idPubli).add(idCita);
	}
	
	public void aniadirAutorAPubli (String idPubli, String idAutor) {
		if (!mapaPublisAutor.containsKey(idPubli)) {
			mapaPublisAutor.put(idPubli, new UnorderedDoubleLinkedList<String>());
		}
		mapaPublisAutor.get(idPubli).addToFront(idAutor);
	}
	
	public OrderedDoubleLinkedList<String> obtenerListaCitas (String idPubli) {
		OrderedDoubleLinkedList<String> lista = mapaPublisCitadas.get(idPubli);
		return lista;
		
	}
	
	public UnorderedDoubleLinkedList<String> obtenerListaAutores (Publicacion p){
		UnorderedDoubleLinkedList<String> lista = mapaPublisAutor.get(p.getId());
		return lista;
	}
	
	public ArrayList<Publicacion> obtenerPublisDeAutor (Autor a){
		ArrayList<Publicacion> listaPublis = new ArrayList<>();
		for (String idPubli:mapaPublisAutor.keySet()) {
			UnorderedDoubleLinkedList<String> listaAutores = mapaPublisAutor.get(idPubli);
			if(listaAutores.contains(a.getId())) {
				Publicacion p =mapaPublicaciones.get(idPubli);
				listaPublis.add(p);
			}
		}
		return listaPublis;
	}
	
	
	public void eliminarPubli (Publicacion p) {
		mapaPublicaciones.remove(p.getId());
	}
	
	public List<Publicacion> ordenarPublis() {
	    List<Publicacion> publicaciones = new ArrayList<>(mapaPublicaciones.values());
	    return ordenarPorId(publicaciones);
	}

	private List<Publicacion> ordenarPorId(List<Publicacion> elementos) {
	    if (elementos.size() < 2) {
	        return elementos;
	    }

	    int puntoMedio = elementos.size() / 2;
	    List<Publicacion> parteIzd = new ArrayList<>(elementos.subList(0, puntoMedio));
	    List<Publicacion> parteDcha = new ArrayList<>(elementos.subList(puntoMedio, elementos.size()));

	    List<Publicacion> izdaOrdenada = ordenarPorId(parteIzd);
	    List<Publicacion> dchaOrdenada = ordenarPorId(parteDcha);

	    return combinarListas(izdaOrdenada, dchaOrdenada);
	}

	private List<Publicacion> combinarListas(List<Publicacion> izda, List<Publicacion> dcha) {
	    List<Publicacion> combinada = new ArrayList<>();
	    int indiceIzq = 0;
	    int indiceDer = 0;

	    while (indiceIzq < izda.size() && indiceDer < dcha.size()) {
	        String idIzq = izda.get(indiceIzq).getId();
	        String idDer = dcha.get(indiceDer).getId();

	        if (idIzq.compareTo(idDer) <= 0) {
	            combinada.add(izda.get(indiceIzq++));
	        } else {
	            combinada.add(dcha.get(indiceDer++));
	        }
	    }

	    if (indiceIzq < izda.size()) {
	        combinada.addAll(izda.subList(indiceIzq, izda.size()));
	    }
	    if (indiceDer < dcha.size()) {
	        combinada.addAll(dcha.subList(indiceDer, dcha.size()));
	    }

	    return combinada;
	}


	
	
	//metodo para comprobar que se ha cargado el fichero de publicaciones
		public int comprobarNumPublicaciones () {
			return mapaPublicaciones.keySet().size();
		}
	
	//metodo para comprobar que se ha cargado el fichero de citas
		public int comprobarNumCitas () {
			return mapaPublisCitadas.keySet().size();
		}

	//metodo para comprobar que se ha cargado el fichero de Publis-autores
			public int comprobarNumPublisAutores () {
				return mapaPublisAutor.keySet().size();
			}
}



















