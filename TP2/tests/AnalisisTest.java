

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class AnalisisTest {
	private ResultadoAnalisis resultado;
	private Analisis analisis;
	@Before
	public void setup(){
		analisis = new Analisis("glucemia", 10, 100, "Con globulos en estado critico.");
		resultado = new ResultadoAnalisis(20);
	}


	@Test
	public void obtenerValorNormalMinimo(){
		assertEquals(10, analisis.getValorNormalMinimo(), 1.0);
	}
	
	@Test
	public void obtenerValorNormalMaximo(){
		assertEquals(100, analisis.getValorNormalMaximo(), 1.0);
	}
	
	@Test
	public void mostrarResultadoPorPantalla(){
		assertEquals("Analisis: glucemia Normal en el rango de valores 10 - 100", analisis.mostrar(resultado));
	}
	

}
