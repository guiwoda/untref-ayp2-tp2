import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class GrupoEstudiosTest {
	private GrupoEstudios grupo;
	private Estudio cardio;
	private Estudio radio;
	private ResultadoGrupoEstudios resultado;
	private List<Prestacion> prestaciones;

	@Before
	public void setUp() {
		cardio = new EstudioCardiologico("electro", "Debe tener una linea que sube y baja");
		radio = new EstudioRadiologico("Placa dental", "Debe tener de 2 a 128 dientes");

		List<TipoPrestacion> subestudios = new LinkedList<>();
		subestudios.add(cardio);
		subestudios.add(radio);

		Map<TipoPrestacion, Resultado> mapa = new HashMap<>();
		ResultadoEstudio subresultado = new ResultadoEstudio(true);

		mapa.put(cardio, subresultado);
		mapa.put(radio, subresultado);

		resultado = new ResultadoGrupoEstudios(mapa);

		Paciente pepe = new Paciente("Pepe", 45678765, DNI.masculino(34167890), "pepe@untref.edu.ar");

		prestaciones = new ArrayList<>();

		Prestacion prestaCardio = new Prestacion(cardio, pepe, new Date());
		Prestacion prestaRadio = new Prestacion(radio, pepe, new Date());
		prestaCardio.setResultado(subresultado);
		prestaRadio.setResultado(subresultado);
		prestaciones.add(prestaCardio);
		prestaciones.add(prestaRadio);
		cardio.addPrestacion(prestaCardio);
		radio.addPrestacion(prestaRadio);


		grupo = new GrupoEstudios("Electro y placa dental", subestudios);
	}

	@Test
	public void testMostrar() {
		assertEquals("Electro y placa dental\n" +
			"  Estudio Cardiológico: electro Normal Debe tener una linea que sube y baja\n" +
			"  Estudio Radiologico: Placa dental Normal Debe tener de 2 a 128 dientes\n", grupo.mostrar(resultado));
	}

	@Test
	public void testEstadisticas() {
		assertEquals(
			"Electro y placa dental:\n" +
				"electro: \n" +
				"Cantidad de pacientes: 1\n" +
				"Resultados normales: 1\n" +
				"Resultados anormales: 0\n" +
				"\n" +
				"Placa dental: \n" +
				"Cantidad de pacientes: 1\n" +
				"Resultados normales: 1\n" +
				"Resultados anormales: 0\n" +
				"\n",
			grupo.getEstadisticas(prestaciones)
		);
	}
}
