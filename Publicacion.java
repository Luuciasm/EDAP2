package segundaFase;
public class Publicacion {

	private String titulo;
	private String id;
	
	
	public Publicacion(String id, String titulo) {
		this.titulo = titulo;
		this.id = id;
	}


	public Publicacion() {
		
	}

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
}
