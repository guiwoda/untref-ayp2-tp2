import static org.junit.Assert.*;
import org.junit.Test;

public class DNITest {
	@Test
	public void testMasculino() {
		DNI dni = DNI.masculino(12345678);
		
		assertTrue(dni.isMasculino());
		assertFalse(dni.isFemenino());
	}

	@Test
	public void testFemenino() {
		DNI dni = DNI.femenino(87654321);
		
		assertTrue(dni.isFemenino());
		assertFalse(dni.isMasculino());
	}

	@Test
	public void testGetNumero() {
		int numero = 13243546;
		DNI dni = DNI.femenino(numero);
		
		assertEquals(numero, dni.getNumero());
	}

	@Test
	public void testToString() {
		DNI dni = DNI.masculino(97867564);
		
		assertEquals("M97867564", dni.toString());
	}
	@Test
	public void testEquals(){
		DNI dni = DNI.masculino(97867564);
		assertEquals(true, dni.equals(dni));
	}
	
	
}
