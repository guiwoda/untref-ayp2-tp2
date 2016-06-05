
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ResultadoTest {
ResultadoAnalisis resultado;
	@Before
	public void setUp(){
		resultado = new ResultadoAnalisis(39);	
	}
	
	@Test
	public void evaluaNormal() {
		assertEquals (true ,resultado.evaluarNormalidad(10, 40));
	}
	
	@Test
	public void evaluaAnormal() {
		assertEquals (false ,resultado.evaluarNormalidad(10, 12));
	}

	
}
