import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PrestacionTest {
	private Prestacion	prestacion;
	private Analisis	analisis;
	private Paciente	paciente	= new Paciente("Estefania Diaz", 46759087, DNI.masculino(33456987), "mail@mail.com");
	private Date		fecha		= new Date();
	private Resultado	resultado;

	@Before
	public void inicializoPrestacionConAnalisis() {
		// creo Prestacion con TipoPrestacion Analisis
		analisis	= new Analisis("glucemia", 10, 100, "Con globulos en estado critico.");
		prestacion = new Prestacion(analisis, paciente, fecha);
		resultado = new ResultadoAnalisis(20);

	}

	@Test
	public void seteoResultadoConAnalisisEImprimoPantalla() {
		prestacion.setResultado(resultado);
		assertEquals("Analisis: glucemia Normal en el rango de valores 10 - 100", prestacion.toString());
	}

	@Test
	public void seOrdenanPorNombreDelTipoDePrestacion() {
		EstudioCardiologico estudio = new EstudioCardiologico("electrocardiograma", "ninguna.");

		Prestacion otra = new Prestacion(estudio, paciente, fecha);

		assertTrue(prestacion.compareTo(otra) > 0);
		assertTrue(otra.compareTo(prestacion) < 0);
	}

	@Test
	public void testEquals() {
		assertTrue(prestacion.equals(prestacion));
		assertFalse(prestacion.equals(resultado));

		EstudioCardiologico estudio = new EstudioCardiologico("electrocardiograma", "ninguna.");
		Prestacion otra = new Prestacion(estudio, paciente, fecha);
		
		assertFalse(prestacion.equals(otra));
	}
}
