import java.util.Date;
import java.util.TreeMap;

public class Laboratorio {

	// para llevar listado de Pacientes
	private TreeMap<Integer, Paciente> pacientes;
	// para estadistica
	private TreeMap<String, TipoPrestacion>	estudios;

	// Dos metodos para ingreso paciente de acuerdo si existe o no
	public void ingresoPaciente(String nombre, Integer telefono, DNI dni, String mail, TipoPrestacion[] prestaciones) {
		Paciente paciente = new Paciente(nombre, telefono, dni, mail);

		pacientes.put(paciente.getId(), paciente);

		registrarVisita(paciente, new Date(), prestaciones);
	}

	public void ingresoPaciente(Integer id, String nombre, Integer telefono, DNI dni, String mail, TipoPrestacion[] prestaciones) {
		Paciente paciente = pacientes.get(id);

		paciente.actualizarDatos(nombre, telefono, dni, mail);

		registrarVisita(paciente, new Date(), prestaciones);
	}

	public void registrarVisita(Paciente paciente, Date fecha, TipoPrestacion[] prestaciones) {
		for (TipoPrestacion tipo : prestaciones) {
			//si no tengo el TipoPrestacion ya cargado
			if(!estudios.containsKey(tipo)){
				estudios.put(tipo.getNombre(), tipo);
			}
			TipoPrestacion tipoPrestacion = estudios.get(tipo.getNombre());
			Prestacion prestacion = new Prestacion(tipo, paciente, fecha);
			tipoPrestacion.addPrestacion(prestacion);
			paciente.agregarPrestacion(prestacion);
			// prestaciones pendientes? -> dentro del paciente?
			
		}
	}

	public void estadistica() {

		Estadistico estadistico = new Estadistico();
	}
	
	// public void ingresarResultadosPorEstudio(TipoPrestacion tipo, Resultado[] resultados)
	
//	public void ingresarResultadosAnalisis(ResultadoAnalisis[] resultados) {
//		for (ResultadoAnalisis resultado : resultados) {
//			Prestacion analisisConResultado = resultado.getPrestacion();
//			if(estudios.containsKey(analisisConResultado.getNombre())){
//				TipoPrestacion analisisACompletar = estudios.get(analisisConResultado);
//				analisisACompletar.s
//			}
//			
//		}
//	}
}
