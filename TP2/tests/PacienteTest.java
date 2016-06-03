import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PacienteTest {
	Paciente pacienteJuan;
	Paciente pacienteLali;
	
	@Before
	public void setup(){
		pacienteJuan = new Paciente("Juan Carlos", 46532409, DNI.masculino(33097654), "mail@otromail.com");
		pacienteLali = new Paciente("Lali Esteb", 46432409, DNI.femenino(3548654), "unMail@otromail.com");
		
	}
	
	@Test
	public void chequeoDeIdCuandoHayVariosPacientes(){
		assertEquals(2, pacienteLali.getId(), 1.0);
	}
}
