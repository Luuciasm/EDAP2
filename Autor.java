package segundaFase;

public class Autor {

	private String nombre;
	private String id;
	
	public Autor(String id, String nombre) {
		this.nombre = nombre;
		this.id = id;
	}

	public Autor() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



}
