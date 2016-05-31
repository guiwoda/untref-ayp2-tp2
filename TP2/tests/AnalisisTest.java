

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AnalisisTest {
	private Analisis glucemia;
	private ResultadoAnalisis resultado;

	@Before 
	public void creoAnalisisYResultadoNormal() {
		glucemia = new Analisis(4, "glucemia", 10, 100, "Con globulos en estado critico.");
		resultado = new ResultadoAnalisis(20, glucemia);
		//no le puedo setear un ValorMedido a resultado; no puedo probar Analisis.mostrar()
		//para que funcione modifique constructor de ResultadoAnalisis pasandole el valorMedido y el analisis
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
		System.out.println(glucemia.mostrar(resultado));
	}
	

}
