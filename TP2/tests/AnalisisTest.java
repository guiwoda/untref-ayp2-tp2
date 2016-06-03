

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AnalisisTest {
	private Analisis glucemia = new Analisis("glucemia", 10, 100, "Con globulos en estado critico.");
	private ResultadoAnalisis resultado;

	@Before 
	public void setupConResultadoNormal() {
		resultado = new ResultadoAnalisis(20, glucemia);
	}

	@Test
	public void obtenerValorNormalMinimo(){
		assertEquals(10, glucemia.getValorNormalMinimo(), 1.0);
	}
	
	@Test
	public void obtenerValorNormalMaximo(){
		assertEquals(100, glucemia.getValorNormalMaximo(), 1.0);
	}
	
	@Test
	public void mostrarResultadoPorPantalla(){
		assertEquals("Analisis: glucemia Normal en el rango de valores 10 - 100", glucemia.mostrar(resultado));
	}
	

}
