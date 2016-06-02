
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EstudioCardiologicoTest {
	private EstudioCardiologico electrocardiograma;
	private ResultadoEstudio resultado;

	@Before 
	public void setupConResultadoNormal() {
		electrocardiograma = new EstudioCardiologico(7, "Electrocardiograma", "No presenta arritmias.");
		resultado = new ResultadoEstudio(true);
	}

	@Test
	public void mostrarResultadoPorPantalla(){
		System.out.println(electrocardiograma.mostrar(resultado));
	}

}
