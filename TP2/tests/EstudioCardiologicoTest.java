import static org.junit.Assert.*;
import org.junit.Test;

public class EstudioCardiologicoTest {
	private EstudioCardiologico electrocardiograma = new EstudioCardiologico("Electrocardiograma", "No presenta arritmias.");
	private ResultadoEstudio resultado = new ResultadoEstudio(true);

	@Test
	public void mostrarResultadoPorPantalla(){
		assertEquals("Estudio Cardiológico: Electrocardiograma Normal No presenta arritmias.", electrocardiograma.mostrar(resultado));
	}
}
