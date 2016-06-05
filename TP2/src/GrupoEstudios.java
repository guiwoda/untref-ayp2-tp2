import java.util.Date;
import java.util.List;

public class GrupoEstudios extends TipoPrestacion {
	private List<TipoPrestacion> prestaciones;
	
	public GrupoEstudios(String nombre, List<TipoPrestacion> prestaciones) {
		super(nombre);
		
		this.prestaciones = prestaciones;
	}
	
	public String mostrar(Resultado resultado) {
		if (! (resultado instanceof ResultadoGrupoEstudios)) {
			throw new RuntimeException("Un grupo de estudios debe tener un grupo de resultados.");
		}
		
		ResultadoGrupoEstudios resultados = (ResultadoGrupoEstudios) resultado;
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(nombre).append("\n");
		
		for (TipoPrestacion prestacion : prestaciones) {
			builder
				.append("  ")
				.append(prestacion.mostrar(resultados.getResultado(prestacion)))
				.append("\n");
		}
		
		return builder.toString();
	}

	@Override
	public String getEstadisticas(Date inicio, Date fin) {
		return "";
	}
}
