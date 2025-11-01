
package segundaFase;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapaAutoresTest {
	
	private MapaAutores ma;


	@Before
	public void setUp() throws Exception {
		ma = new MapaAutores();

	}

	@After
	public void tearDown() throws Exception {
		ma = null;

	}

	@Test
	public void testMapaAutores() {
		assertNotNull(ma);
	}

	@Test
	public void testCargarAutores() {
		ma.cargarAutores("Datuak/authors-name-all.txt");
		assertTrue(ma.comprobarNumAutores() !=0);
	}


	@Test
	public void testAniadirAutor() {
		//ma.aniadirAutor("Q60320741", "Eric Waclawik");
		//assertTrue(ma.buscarAutor("Q60320741"));
		ma.aniadirAutor("Q60320741", "Pepito");
		assertEquals(ma.buscarAutor("Q60320741").getId(),"Q60320741" );
	}

	@Test
	public void testEliminarAutor() {
		Autor a2 = new Autor("Q60320741", "Eric Waclawik");
		ma.aniadirAutor(a2.getId(), a2.getNombre());
		ma.eliminarAutor(a2);
		Boolean booleano = true;
		if (ma.buscarAutor(a2.getId())== null) {
			booleano = false;
		}
		assertFalse(booleano);
	}

}
