import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EstudioRadiologicoTest {
	private EstudioRadiologico radiografiaTorax;
	private ResultadoEstudio resultado;

	@Before
	public void setUp() {

		radiografiaTorax = new EstudioRadiologico("Radiografia de Torax", "No presenta malformacion alguna.");
		resultado = new ResultadoEstudio(true);
	}

	@Test
	public void mostrarResultadoPorPantalla() {
		assertEquals("Estudio Radiologico: Radiografia de Torax Normal No presenta malformacion alguna.", radiografiaTorax.mostrar(resultado));
	}
}
