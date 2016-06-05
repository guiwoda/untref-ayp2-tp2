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
		assertEquals(1, pacienteJuan.getId(), 1.0);
	}
	
	@Test
	public void losPacientesSeComparan(){
		assertEquals(true, pacienteLali.compareTo(pacienteLali));
		assertEquals(true, pacienteJuan.compareTo(pacienteJuan));
		assertEquals(false, pacienteLali.compareTo(pacienteJuan));
		assertEquals(false, pacienteLali.compareTo(pacienteJuan));
	}
	
	@Test
	public void elPacienteActualizaDatos(){
		pacienteJuan.actualizarDatos("Juana", 92830492, DNI.femenino(99332200), "laJuanci@jolo.com");
		assertEquals("Juana", pacienteJuan.getNombre());
		assertEquals(92830492, pacienteJuan.getTelefono(), 0.1);
		assertEquals(DNI.femenino(99332200), pacienteJuan.getDni());
		assertEquals("laJuanci@jolo.com", pacienteJuan.getMail());	
	}
}
