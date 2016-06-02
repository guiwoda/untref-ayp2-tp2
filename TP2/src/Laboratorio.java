import java.util.Date;
import java.util.TreeMap;

public class Laboratorio {

	// para llevar listado de Pacientes
	private TreeMap<Integer, Paciente> pacientes;
	// para estadistica
	private TreeMap<String, TipoPrestacion>	estudios;

	// Dos metodos para ingreso paciente de acuerdo si existe o no
	public void ingresoPaciente(String nombre, Integer dni, Integer telefono, String mail, TipoPrestacion[] prestaciones) {
		Paciente paciente = new Paciente(nombre, dni, telefono, mail);

		pacientes.put(paciente.getId(), paciente);

		registrarVisita(paciente, new Date(), prestaciones);
	}

	public void ingresoPaciente(Integer id, String nombre, Integer dni, Integer telefono, String mail, TipoPrestacion[] prestaciones) {
		Paciente paciente = pacientes.get(id);

		paciente.actualizarDatos(nombre, telefono, dni, mail);

		registrarVisita(paciente, new Date(), prestaciones);
	}

	public void registrarVisita(Paciente paciente, Date fecha, TipoPrestacion[] prestaciones) {
		for (TipoPrestacion tipo : prestaciones) {
			Prestacion prestacion = new Prestacion(tipo, paciente, fecha);

		}
	}

	public void estadistica() {

		Estadistico estadistico = new Estadistico();
	}
}
