import java.util.*;

public class GrupoEstudios extends TipoPrestacion {
	private List<TipoPrestacion> subestudios;
	
	public GrupoEstudios(String nombre, List<TipoPrestacion> subestudios) {
		super(nombre);
		
		this.subestudios = subestudios;
	}
	
	public String mostrar(Resultado resultado) {
		if (! (resultado instanceof ResultadoGrupoEstudios)) {
			throw new RuntimeException("Un grupo de estudios debe tener un grupo de resultados.");
		}
		
		ResultadoGrupoEstudios resultados = (ResultadoGrupoEstudios) resultado;
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(nombre).append("\n");
		
		for (TipoPrestacion subestudio : subestudios) {
			builder
				.append("  ")
				.append(subestudio.mostrar(resultados.getResultado(subestudio)))
				.append("\n");
		}
		
		return builder.toString();
	}

	@Override
	public String getEstadisticas(List<Prestacion> prestaciones) {
		StringBuilder builder = new StringBuilder();

		Map<TipoPrestacion, List<Prestacion>> prestacionesPorTipo = new HashMap<>();

		for (TipoPrestacion tipo : subestudios) {
			prestacionesPorTipo.put(tipo, new ArrayList<Prestacion>());
		}

		for (Prestacion prestacion : prestaciones) {
			prestacionesPorTipo.get(prestacion.getTipoPrestacion()).add(prestacion);
		}

		for (TipoPrestacion tipo : subestudios) {
			builder.append(tipo.getEstadisticas(prestacionesPorTipo.get(tipo))).append("\n");
		}

		return builder.toString();
	}
}
