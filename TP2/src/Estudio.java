import java.util.Date;
import java.util.List;

public abstract class Estudio extends TipoPrestacion {
	protected String indicaciones;
	
	public Estudio(String nombre, String indicaciones) {
		super(nombre);
		this.indicaciones = indicaciones;
	}

	public String getIndicaciones() {
		return indicaciones;
	}
	
	public void cargarResultado(ResultadoEstudio resultado){
		for (Prestacion prestacion : prestaciones){
			prestacion.setResultado(resultado);
		}
	}

	@Override
	public String getEstadisticas(List<Prestacion> prestaciones) {
		StringBuilder result = new StringBuilder();

		result.append(nombre).append(": ").append("\n");

		int cantidad = 0;
		int normales = 0;

		for (Prestacion prestacion : prestaciones) {
			ResultadoEstudio resultado = (ResultadoEstudio) prestacion.getResultado();

			if (resultado == null){
				continue;
			}

			cantidad++;

			if (resultado.esNormal()) {
				normales++;
			}
		}

		if (cantidad == 0) {
			return result.append("No hay prestaciones entre las fechas pedidas.").toString();
		}

		result.append("Cantidad de pacientes: ").append(cantidad).append("\n");
		result.append("Resultados normales: ").append(normales).append("\n");
		result.append("Resultados anormales: ").append(cantidad - normales).append("\n");

		return result.toString();
	}
}
