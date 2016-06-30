import java.util.*;

public class Laboratorio {
	private static Laboratorio instance = new Laboratorio();

	private Set<Paciente> pacientes = new TreeSet<>();
	private Map<String, TipoPrestacion> estudios = new TreeMap<>();

	private Laboratorio(){}

	public static Laboratorio getInstance() {
		return instance;
	}

	public void ingresoPaciente(String nombre, Integer telefono, DNI dni, String mail, TipoPrestacion[] prestaciones) {
		ingreso(new Paciente(nombre, telefono, dni, mail), prestaciones);
	}

	public void ingresoPaciente(int id, String nombre, Integer telefono, DNI dni, String mail, TipoPrestacion[] prestaciones) {
		Paciente paciente = new Paciente(id, nombre, telefono, dni, mail);
		pacientes.remove(paciente);

		ingreso(paciente, prestaciones);
	}

	private void ingreso(Paciente paciente, TipoPrestacion[] prestaciones) {
		pacientes.add(paciente);

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

		}
	}

	public String estadistica(Date inicio, Date fin) {
		StringBuilder result = new StringBuilder();

		for (TipoPrestacion tipo : estudios.values()) {
			result.append(
				tipo.getEstadisticas(tipo.getPrestacionesEntre(inicio, fin))
			).append("\n");
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
	
	public String mostrarResultados(){
		StringBuilder builder = new StringBuilder();

		for (Paciente paciente : pacientes) {
			builder.append(paciente.getNombre()).append("\n");
			
			for (Prestacion prestacion : paciente.getPrestaciones()) {
				builder
					.append(prestacion.getFecha()).append("\n")
					.append(prestacion.toString()).append("\n");
			}

			builder.append("\n");
		}
		return builder.toString();
	}
}
