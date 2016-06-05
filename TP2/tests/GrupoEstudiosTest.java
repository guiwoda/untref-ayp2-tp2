
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class GrupoEstudiosTest {
	private GrupoEstudios grupo;
	private List<TipoPrestacion> prestaciones;
	private Estudio cardio;
	private Estudio radio;
	private ResultadoEstudio resultado;
	@Before
	public void setUp(){
		cardio = new EstudioCardiologico("electro", "Debe tener una linea que sube y baja");
		radio = new EstudioRadiologico("Placa dental", "Debe tener de 2 a 128 dientes");
		resultado = new ResultadoEstudio(true);
		cardio.cargarResultado(resultado);
		radio.cargarResultado(resultado);
		prestaciones = new LinkedList<>();
		prestaciones.add(cardio);
		prestaciones.add(radio);
		grupo = new GrupoEstudios("Electro y placa dental", prestaciones);
	}
	@Test
	public void test() {
		assertEquals("", grupo.mostrar(resultado));
	}

}
