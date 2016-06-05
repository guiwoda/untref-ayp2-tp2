
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class GrupoEstudiosTest {
	private GrupoEstudios grupo;
	private List<TipoPrestacion> prestaciones;
	private Estudio cardio;
	private Estudio radio;
	@Before
	public void setUp(){
		cardio = new EstudioCardiologico("electro", "Debe tener una linea que sube y baja");
		radio = new EstudioRadiologico("Placa dental", "Debe tener de 2 a 128 dientes");

		prestaciones = new LinkedList<>();
		prestaciones.add(cardio);
		prestaciones.add(radio);

		grupo = new GrupoEstudios("Electro y placa dental", prestaciones);
	}
	@Test
	public void testMostrar() {
		Map<TipoPrestacion, Resultado> mapa = new HashMap<>();
		ResultadoEstudio subresultado = new ResultadoEstudio(true);

		mapa.put(cardio, subresultado);
		mapa.put(radio, subresultado);

		ResultadoGrupoEstudios resultado = new ResultadoGrupoEstudios(mapa);

		assertEquals("Electro y placa dental\n" +
			"  Estudio Cardiológico: electro Normal Debe tener una linea que sube y baja\n" +
			"  Estudio Radiologico: Placa dental Normal Debe tener de 2 a 128 dientes\n", grupo.mostrar(resultado));
	}

}
