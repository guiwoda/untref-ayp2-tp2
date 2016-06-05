import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaboratorioTest {
	private Laboratorio laboratorio = new Laboratorio();

	@Test
	public void testEstadistica() {
		TipoPrestacion[] tipoPrestaciones = new TipoPrestacion[5];

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

		for (TipoPrestacion tipoPrestacion : tipoPrestaciones) {
			List<Prestacion> prestaciones = tipoPrestacion.getPrestaciones();

			for (Prestacion prestacion : prestaciones) {
				if (tipoPrestacion instanceof Analisis) {
					resultadosAnalisis.put(prestacion, 35 + (int) (Math.random() * 100));
				} else {
					resultadosEstudios.put(prestacion, (Math.random() * 100 > 50));
				}
			}
		}

		laboratorio.ingresarResultadosAnalisis(resultadosAnalisis);
		laboratorio.ingresarResultadosPorEstudio(resultadosEstudios);

		System.out.println(laboratorio.estadistica(new Date(1462060800), new Date()));
	}
}
