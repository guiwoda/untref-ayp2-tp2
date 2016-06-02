
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EstudioRadiologicoTest {
	private EstudioRadiologico radiografiaTorax;
	private ResultadoEstudio resultado;

	@Before 
	public void setupConResultadoNormal() {
		radiografiaTorax = new EstudioRadiologico(7, "Radiografia de Torax", "No presenta malformacion alguna.");
		resultado = new ResultadoEstudio(true);
	}

	@Test
	public void mostrarResultadoPorPantalla(){
		System.out.println(radiografiaTorax.mostrar(resultado));
	}
}
