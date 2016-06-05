import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Laboratorio {

	// para llevar listado de Pacientes
	private Map<Integer, Paciente> pacientes = new TreeMap<>();
	// para estadistica
	private Map<String, TipoPrestacion>	estudios = new TreeMap<>();

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
			//si no tengo el TipoPrestacion ya cargado. Decision de diseño: poder dar de alta prestaiones
			if(!estudios.containsKey(tipo.getNombre())){
				estudios.put(tipo.getNombre(), tipo);
			}

			TipoPrestacion tipoPrestacion = estudios.get(tipo.getNombre());
			Prestacion prestacion = new Prestacion(tipo, paciente, fecha);
			tipoPrestacion.addPrestacion(prestacion);
			paciente.agregarPrestacion(prestacion);
			// prestaciones pendientes? -> dentro del paciente?
			
		}
	}

	public String estadistica(Date inicio, Date fin) {
		StringBuilder result = new StringBuilder();

		for (TipoPrestacion tipo : estudios.values()) {
			result.append(tipo.getEstadisticas(inicio, fin)).append("\n");
		}

		return result.toString();
	}
	
	public void ingresarResultadosPorEstudio(Map<Prestacion, Boolean> informacionResultados){

		Set<Map.Entry<Prestacion, Boolean>> informacionResultado = informacionResultados.entrySet();

	        for (Map.Entry<Prestacion, Boolean> info : informacionResultado) {
	        	Boolean esNormal = info.getValue();
	        	ResultadoEstudio resultado = new ResultadoEstudio(esNormal);
	        	Prestacion prestacion = info.getKey();
	        	prestacion.setResultado(resultado);
	        }
	}
	
	public void ingresarResultadosAnalisis(Map<Prestacion, Integer> informacionResultados) {

		Set<Map.Entry<Prestacion, Integer>> informacionResultado = informacionResultados.entrySet();

        for (Map.Entry<Prestacion, Integer> info : informacionResultado) {
        	Integer valorMedido = info.getValue();
        	ResultadoAnalisis resultado = new ResultadoAnalisis(valorMedido);
        	Prestacion prestacion = info.getKey();
        	prestacion.setResultado(resultado);
        }
	}
}
