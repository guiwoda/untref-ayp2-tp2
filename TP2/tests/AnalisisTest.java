

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AnalisisTest {
	private Analisis glucemia;
	private Resultado resultado;

	@Before
	public void creoAnalisisYResultado() {
		glucemia = new Analisis(4, "glucemia", 10, 100, "Con globulos en estado critico.");
		resultado = new ResultadoAnalisis();
		//no le puedo setear un ValorMedido a resultado; no puedo probar Analisis.mostrar()
		//no faltaria un constructor de ResultadoAnalisis que nos permita agregarle el valorMedido
	}

	@Test
	public void obtenerValorNormalMinimo(){
		assertEquals(10, glucemia.getValorNormalMinimo(), 1.0);
	}
	
	@Test
	public void obtenerValorNormalMaximo(){
		assertEquals(100, glucemia.getValorNormalMaximo(), 1.0);
	}
	
//	@Test
//	public void mostrar(){
//		
//	}
	

}
