import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class LaboratorioTest {
	private Laboratorio laboratorio = Laboratorio.getInstance();
	private TipoPrestacion[] tipoPrestaciones = new TipoPrestacion[5];

	@Before
	public void setup(){

		for(int i = 0; i < 5; i++) {
			String s = String.valueOf(i + 1);
			if (i % 2 == 1) {
				tipoPrestaciones[i] = new Analisis("Analisis " + s, i, i + 10, "Indicaciones para " + s);
			} else {
				tipoPrestaciones[i] = new EstudioCardiologico("Estudio " + s, "Indicaciones para estudio " + s);
			}
		}

		laboratorio.ingresoPaciente("Pepe", 45678765, DNI.masculino(34167890), "pepe@untref.edu.ar", tipoPrestaciones);
		laboratorio.ingresoPaciente("José", 45678665, DNI.masculino(34567890), "jose@untref.edu.ar", tipoPrestaciones);
		laboratorio.ingresoPaciente("Karina", 45658765, DNI.femenino(33567890), "karina@untref.edu.ar", tipoPrestaciones);
		laboratorio.ingresoPaciente("Juana", 45671765, DNI.femenino(34167890), "juana@untref.edu.ar", tipoPrestaciones);

		Map<Prestacion, Integer> resultadosAnalisis = new HashMap<>();
		Map<Prestacion, Boolean> resultadosEstudios = new HashMap<>();

		for (int i = 0; i < tipoPrestaciones.length; i++) {
			TipoPrestacion tipoPrestacion = tipoPrestaciones[i];

			List<Prestacion> prestaciones = tipoPrestacion.getPrestaciones();

			for (int j = 0; j < prestaciones.size(); j++) {
				Prestacion prestacion = prestaciones.get(j);

				if (tipoPrestacion instanceof Analisis) {
					resultadosAnalisis.put(prestacion, (i + j) * 100);
				} else {
					resultadosEstudios.put(prestacion, (i + j) % 2 == 0);
				}
			}
		}

		laboratorio.ingresarResultadosAnalisis(resultadosAnalisis);
		laboratorio.ingresarResultadosPorEstudio(resultadosEstudios);

	}

	@Test
	public void testEstadistica() {


		String result = laboratorio.estadistica(new Date(1462060800), new Date());

		assertEquals("Analisis 2: \n" +
			"Cantidad de pacientes: 4\n" +
			"Valor mínimo medido: 100\n" +
			"Valor máximo medido: 400\n" +
			"Promedio de valores: 250\n" +
			"\n" +
			"Analisis 4: \n" +
			"Cantidad de pacientes: 4\n" +
			"Valor mínimo medido: 300\n" +
			"Valor máximo medido: 600\n" +
			"Promedio de valores: 450\n" +
			"\n" +
			"Estudio 1: \n" +
			"Cantidad de pacientes: 4\n" +
			"Resultados normales: 2\n" +
			"Resultados anormales: 2\n" +
			"\n" +
			"Estudio 3: \n" +
			"Cantidad de pacientes: 4\n" +
			"Resultados normales: 2\n" +
			"Resultados anormales: 2\n" +
			"\n" +
			"Estudio 5: \n" +
			"Cantidad de pacientes: 4\n" +
			"Resultados normales: 2\n" +
			"Resultados anormales: 2\n\n",
			result);

		System.out.println(result);
	}

	@Test
	public void testMostrarResultados(){
		String today = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

		assertEquals(
			"José\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 1 Anormal Indicaciones para estudio 1\n" +
			today + "\n" +
			"Analisis: Analisis 2 Anormal 200 en el rango de valores 1 - 11\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 3 Anormal Indicaciones para estudio 3\n" +
			today + "\n" +
			"Analisis: Analisis 4 Anormal 400 en el rango de valores 3 - 13\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 5 Anormal Indicaciones para estudio 5\n" +
			"\n" +
			"Juana\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 1 Anormal Indicaciones para estudio 1\n" +
			today + "\n" +
			"Analisis: Analisis 2 Anormal 400 en el rango de valores 1 - 11\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 3 Anormal Indicaciones para estudio 3\n" +
			today + "\n" +
			"Analisis: Analisis 4 Anormal 600 en el rango de valores 3 - 13\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 5 Anormal Indicaciones para estudio 5\n" +
			"\n" +
			"Karina\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 1 Normal Indicaciones para estudio 1\n" +
			today + "\n" +
			"Analisis: Analisis 2 Anormal 300 en el rango de valores 1 - 11\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 3 Normal Indicaciones para estudio 3\n" +
			today + "\n" +
			"Analisis: Analisis 4 Anormal 500 en el rango de valores 3 - 13\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 5 Normal Indicaciones para estudio 5\n" +
			"\n" +
			"Pepe\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 1 Normal Indicaciones para estudio 1\n" +
			today + "\n" +
			"Analisis: Analisis 2 Anormal 100 en el rango de valores 1 - 11\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 3 Normal Indicaciones para estudio 3\n" +
			today + "\n" +
			"Analisis: Analisis 4 Anormal 300 en el rango de valores 3 - 13\n" +
			today + "\n" +
			"Estudio Cardiológico: Estudio 5 Normal Indicaciones para estudio 5\n" +
			"\n",
			laboratorio.mostrarResultados());
	}
}
