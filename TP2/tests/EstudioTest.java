import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EstudioTest {
	private Estudio cardio;
	private Estudio radio;
	private ResultadoEstudio resultado;

	@Before
	public void setUp() {
		cardio = new EstudioCardiologico("electro", "Debe tener una linea que sube y baja");
		radio = new EstudioRadiologico("Placa dental", "Debe tener de 2 a 128 dientes");
		resultado = new ResultadoEstudio(true);
	}

	@Test
	public void estudioTieneIndicaciones() {
		assertEquals("Debe tener una linea que sube y baja", cardio.getIndicaciones());
		assertEquals("Debe tener de 2 a 128 dientes", radio.getIndicaciones());
	}

	@Test
	public void estudioTieneNombre() {
		assertEquals("electro", cardio.getNombre());
		assertEquals("Placa dental", radio.getNombre());
	}

	@Test
	public void estudioCargaResultado() {
		cardio.cargarResultado(resultado);
		//pendiente.
	}
}
