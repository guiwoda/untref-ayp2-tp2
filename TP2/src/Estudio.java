import java.util.Date;

public abstract class Estudio extends TipoPrestacion {
	protected String indicaciones;
	
	public Estudio(String nombre, String indicaciones) {
		super(nombre);
		this.indicaciones = indicaciones;
	}

	public String getIndicaciones() {
		return indicaciones;
	}
	
	//Definir si en el Nombre va a aparecer que tipo de estudio es
//	public String mostrar(Resultado resultado){
//		return "Estudio: " + nombre + " " 
//				+ ((ResultadoEstudio) resultado).evaluarNormalidad() 
//				+ " " + indicaciones;
//	}
	
	@Override
	public String toString() {
		return getNombre();
	}

	public void cargarResultado(ResultadoEstudio resultado){
		for (Prestacion prestacion : prestaciones){
			prestacion.setResultado(resultado);
		}
	}

	@Override
	public String getEstadisticas(Date inicio, Date fin) {
		StringBuilder result = new StringBuilder();

		result.append(nombre).append(": ").append("\n");

		int cantidad = 0;
		int normales = 0;

		for (Prestacion prestacion : getPrestacionesEntre(inicio, fin)) {
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
