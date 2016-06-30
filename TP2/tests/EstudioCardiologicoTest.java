import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EstudioCardiologicoTest {
	private EstudioCardiologico electrocardiograma;
	private ResultadoEstudio resultado;

	@Before
	public void setUp() {
		resultado = new ResultadoEstudio(true);
		electrocardiograma = new EstudioCardiologico("Electrocardiograma", "No presenta arritmias.");
	}

	@Test
	public void mostrarResultadoPorPantalla() {
		assertEquals("Estudio Cardiológico: Electrocardiograma Normal No presenta arritmias.", electrocardiograma.mostrar(resultado));
	}
}
