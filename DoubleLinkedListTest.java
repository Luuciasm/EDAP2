package segundaFase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {
	
	private DoubleLinkedList<Integer> lista;

	@Before
	public void setUp() throws Exception {
		lista = new DoubleLinkedList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		lista = null;
	}
	@Test
	public void setDescr() {
		lista.setDescr("DoubleLinkedList");
		assertEquals("DoubleLinkedList", lista.getDescr());
		}
	
	@Test
	public void getDescr() {
		lista.setDescr("DoubleLinkedList");
		assertEquals("DoubleLinkedList", lista.getDescr());
	}

	@Test
	public void testDoubleLinkedList() {
		assertNotNull(lista);
	}


	@Test
	public void testRemoveFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		assertTrue(lista.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0,lista.size());
	}
	
	@Test
	public void testIterator() {
		assertNotNull(lista.iterator());
	}

	@Test
	public void testVisualizarNodos() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		assertEquals("DoubleLinkedList ]", lista.toString());
	}

}
