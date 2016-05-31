
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class PrestacionTest {
	private Prestacion prestacion;
	private Analisis analisis; 
	private Paciente paciente;
	private Date fecha;
	private Resultado resultado;
	
	
	@Before
	public void inicializoPrestacionConAnalisis() {
		analisis = new Analisis (4, "glucemia", 10, 100, "Con globulos en estado critico.");
		paciente = new Paciente ("Estefania Diaz", 46759087, 33456987, "mail@mail.com");
		fecha = new Date();
		resultado = new ResultadoAnalisis(20, analisis);
		//creo Prestacion con TipoPrestacion Analisis
		prestacion = new Prestacion(analisis, paciente, fecha);

	}

	@Test
	public void seteoResultadoConAnalisisEImprimoPantalla(){
		prestacion.setResultado(resultado);
		System.out.println(prestacion.toString());
	}	

}
