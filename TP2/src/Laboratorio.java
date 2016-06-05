import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
			//si no tengo el TipoPrestacion ya cargado. Decision de diseño: poder dar de alta prestaiones
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
	
	public void ingresarResultadosPorEstudio(HashMap<Boolean, Prestacion> informacionResultados){

		Set<Map.Entry<Boolean, Prestacion>> informacionResultado = informacionResultados.entrySet();

	        for (Map.Entry<Boolean, Prestacion> info : informacionResultado) {
	        	Boolean esNormal = info.getKey();
	        	ResultadoEstudio resultado = new ResultadoEstudio(esNormal);
	        	Prestacion prestacion = info.getValue();
	        	prestacion.setResultado(resultado);
	        }
				
//		for (ResultadoEstudio informacionResultado : informacionResultado) {
//			Prestacion estudioConResultado = resultado.getPrestacion();
//			Estudio tipoEstudioConResultado = (Estudio) estudioConResultado.getTipoPrestacion();
//			
//			if(estudios.containsKey(tipoEstudioConResultado.getNombre())){
//				Estudio estudioACompletar = (Estudio)estudios.get(tipoEstudioConResultado);
//				estudioACompletar.cargarResultado(resultado);
//			}
//			
//		}
	}
	
	public void ingresarResultadosAnalisis(HashMap<Integer, Prestacion> informacionResultados) {
		
		Set<Map.Entry<Integer, Prestacion>> informacionResultado = informacionResultados.entrySet();

        for (Map.Entry<Integer, Prestacion> info : informacionResultado) {
        	Integer valorMedido = info.getKey();
        	ResultadoAnalisis resultado = new ResultadoAnalisis(valorMedido);
        	Prestacion prestacion = info.getValue();
        	prestacion.setResultado(resultado);
        }
        
        
//		for (ResultadoAnalisis resultado : resultados) {
//			Prestacion analisisConResultado = resultado.getPrestacion();
//			Analisis tipoAnalisisConResultado = (Analisis) analisisConResultado.getTipoPrestacion();
//			
//			if(estudios.containsKey(tipoAnalisisConResultado.getNombre())){
//				Analisis analisisACompletar = (Analisis)estudios.get(tipoAnalisisConResultado);
//				analisisACompletar.cargarResultado(resultado);
//			}
//			
//		}
	}
}
