package segundaFase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class MapaAutores {
	
	private HashMap<String, Autor> mapaAutores;
	
	public MapaAutores() {
		mapaAutores = new HashMap<>();
	}
	

	//Lee los datos del fichero que relaciona el identificador de cada autor con su nombre.
	//y los guarda en un mapa que tiene como clave el identificador del autor y el propio autor como valor.
	public void cargarAutores(String nombre) { //Leer del fichero los codigos de AUTORES
		try {									// con el Scanner
			Scanner entrada = new Scanner(new FileReader(nombre)); //Abrimos el scanner. nombre=nombre del fichero
			String linea; //Declaramos un tipo string llamado línea, será la línea que leamos
			while (entrada.hasNextLine()) { //Mientras en el fichero exista una siguiente linea que leer
				linea = entrada.nextLine(); //linea es la linea que estamos leyendo
				String info[] = linea.split("\\s+#\\s+"); //Guardamos en la variable info el código y el nombre del autor
													// separando ambos datos con el .split cuando aparezca un #
				if (info.length ==2) {
				Autor a = new Autor(info[0], info[1]); //Relacionamos código y nombre en el objeto Autor
				mapaAutores.put(info[0], a); //Lo añadimos a la mapaAutores
				}
			}
			entrada.close(); //Cerramos el scanner
		} catch (IOException e) {   //Excepcion que salta (si no se puede leer el fichero)
			e.printStackTrace();
		}
	}
	

	public void guardarAutores(String nombre) { //
		try {
			PrintWriter salida = new PrintWriter(new File(nombre));
			for (Autor a: mapaAutores.values()) {
				salida.println(a.getId()+" # "+a.getNombre());
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Dado un autor, devolver una lista con sus publicaciones
	public void aniadirAutor (String id, String nom) {
		Autor a = new Autor(id, nom);
		mapaAutores.put(id, a);
	}
	
	//Borrar un autor
	public void eliminarAutor (Autor a) {
		mapaAutores.remove(a.getId());
	}
	
	//metodo para comprobar qie se ha cargado el fichero
	public int comprobarNumAutores () {
		return mapaAutores.keySet().size();
	}
	
	
	public Autor buscarAutor(String idAutor) {
		return mapaAutores.get(idAutor);
	}
	
}
