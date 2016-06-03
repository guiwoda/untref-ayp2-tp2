import static org.junit.Assert.*;
import org.junit.Test;

public class EstudioRadiologicoTest {
	private EstudioRadiologico radiografiaTorax = new EstudioRadiologico("Radiografia de Torax", "No presenta malformacion alguna.");
	private ResultadoEstudio resultado = new ResultadoEstudio(true);

	@Test
	public void mostrarResultadoPorPantalla(){
		assertEquals("Estudio Radiologico: Radiografia de Torax Normal No presenta malformacion alguna.", radiografiaTorax.mostrar(resultado));
	}
}
