
package segundaFase;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PublicacionesYAutoresTest {
	
	private PublicacionesYAutores pa;

	@Before
	public void setUp() throws Exception {
		pa = new PublicacionesYAutores();
	}

	@After
	public void tearDown() throws Exception {
		pa = null;
	}

	@Test
	public void testPublicacionesYAutores() {
		assertNotNull(pa);
	}

	@Test
	public void testObtenerListaAutores() {
		Publicacion p = new Publicacion("Q38075012", "Plant protein interactomes");
		ArrayList<Autor> lista = pa.obtenerListaAutores(p);
		assertNotNull(lista);
	}

}
