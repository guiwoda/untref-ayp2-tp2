import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PacienteTest {
	private Paciente pacienteJuan;
	private Paciente pacienteLali;
	private Prestacion prestacion;
	private Analisis analisis;
	private Date fecha = new Date();
	@Before
	public void setup(){
		pacienteJuan = new Paciente("Juan Carlos", 46532409, DNI.masculino(33097654), "mail@otromail.com");
		pacienteLali = new Paciente("Lali Esteb", 46432409, DNI.femenino(3548654), "unMail@otromail.com");
		analisis = new Analisis("glucemia", 10, 100, "Con globulos en estado critico.");
		prestacion = new Prestacion(analisis, pacienteJuan, fecha);
	}
	
	@Test
	public void chequeoDeIdCuandoHayVariosPacientes(){
		assertEquals(2, pacienteLali.getId(), 1.0);
		assertEquals(1, pacienteJuan.getId(), 1.0);
	}
	
	@Test
	public void losPacientesSeComparan(){
		assertTrue(pacienteLali.compareTo(pacienteLali));
		assertTrue(pacienteJuan.compareTo(pacienteJuan));
		assertFalse(pacienteLali.compareTo(pacienteJuan));
		assertFalse(pacienteLali.compareTo(pacienteJuan));
	}
	
	@Test
	public void elPacienteActualizaDatos(){
		pacienteJuan.actualizarDatos("Juana", 92830492, DNI.femenino(99332200), "laJuanci@jolo.com");
		assertEquals("Juana", pacienteJuan.getNombre());
		assertEquals(92830492, pacienteJuan.getTelefono(), 0.1);
		assertTrue(pacienteJuan.getDni().equals(DNI.femenino(99332200)));
		assertEquals("laJuanci@jolo.com", pacienteJuan.getMail());	
	}
	@Test
	public void elPacienteAgregaPrestacion(){
		pacienteJuan.agregarPrestacion(prestacion);
		assertTrue(pacienteJuan.getPrestaciones().contains(prestacion));
	}
	
	
}
