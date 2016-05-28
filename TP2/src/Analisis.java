import java.sql.Date;

public class Analisis extends Prestacion {

	private Integer id;
	private String nombre;
	private Integer valorNormalMinimo;
	private Integer valorNormalMaximo;
	private String indicaciones;
	// no sabemos todavia
	private Date fecha;
	// A revisar
	private Resultado resultado;
	// A ver
	private String normalidad;
	
	
	
	public void evaluarNormalidad() {
		if ((resultado.getValorMedido() < this.valorNormalMaximo)
				&& (resultado.getValorMedido() > this.valorNormalMinimo)) {
			normalidad = "normal";
		} else {
			normalidad = "anormal";
		}
	}

	// Para mostrar resultados
	public String toString() {
		// Falta inicializar normalidad
		return nombre + " " + resultado.getValorMedido().toString() + " " + this.normalidad
				+ " dentro del valor minimo " + this.valorNormalMinimo.toString() + " y valor maximo  "
				+ this.valorNormalMaximo.toString();
	}

	// Para la estadistica
	// aca me falta el visitor pero no se como se escribe. Invento el nombre
	public Prestacion esVisitado(Estadistico estadistico) {
		return this;
	}
}
