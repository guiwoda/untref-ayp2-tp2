

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class AnalisisTest {
	private ResultadoAnalisis resultado;
	private Paciente pacienteJuan;
	private Analisis analisis;
	private Date fecha = new Date();
	@Before
	public void setup(){
		pacienteJuan = new Paciente("Juan Carlos", 46532409, DNI.masculino(33097654), "mail@otromail.com");
		analisis = new Analisis("glucemia", 10, 100, "Con globulos en estado critico.");
		new Prestacion(analisis, pacienteJuan, fecha);
		resultado = new ResultadoAnalisis(20, analisis);
	}


	@Test
	public void obtenerValorNormalMinimo(){
		assertEquals(10, analisis.getValorNormalMinimo(), 1.0);
	}
	
	@Test
	public void obtenerValorNormalMaximo(){
		assertEquals(100, analisis.getValorNormalMaximo(), 1.0);
	}
	
	@Test
	public void mostrarResultadoPorPantalla(){
		assertEquals("Analisis: glucemia Normal en el rango de valores 10 - 100", analisis.mostrar(resultado));
	}
	

}
