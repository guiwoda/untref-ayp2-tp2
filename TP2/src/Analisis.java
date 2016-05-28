import java.sql.Date;

public class Analisis extends Prestacion {

	private Integer valorNormalMinimo;
	private Integer valorNormalMaximo;
	private String indicaciones;
	private ResultadoAnalisis resultado;
	// no sabemos todavia
	private Date fecha;

	public Analisis(Integer id, String nombre, Integer valorNormalMinimo, Integer valorNormalMaximo, String indicaciones){
		super.setId(id);
		super.setNombre(nombre);
		this.valorNormalMinimo=valorNormalMinimo;
		this.valorNormalMaximo=valorNormalMaximo;
		this.indicaciones=indicaciones;
	} 

	public Integer getValorNormalMinimo(){
		return this.valorNormalMinimo;
	}
	
	public Integer getValorNormalMaximo(){
		return this.valorNormalMaximo;
	}
	
	// Para mostrar resultados
	public String toString() {
		// Falta inicializar normalidad
		return  super.getNombre() + " " + resultado.getValorMedido().toString() + " " + resultado.evaluarNormalidad()
				+ " dentro del valor minimo " + this.valorNormalMinimo.toString() + " y valor maximo  "
				+ this.valorNormalMaximo.toString();
	}

	// Para la estadistica
	// aca me falta el visitor pero no se como se escribe. Invento el nombre
	public Prestacion esVisitado(Estadistico estadistico) {
		return this;
	}
}
