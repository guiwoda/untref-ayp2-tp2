import java.sql.Date;

public class Analisis extends Prestacion {

	//private Integer id;
	//private String nombre;
	private Integer valorNormalMinimo;
	private Integer valorNormalMaximo;
	private String indicaciones;
	// no sabemos todavia
	private Date fecha;

	public Analisis(Integer id, String nombre, Integer valorNormalMinimo, Integer valorNormalMaximo, String indicaciones){
		super.setId(id);
		super.setNombre(nombre);
		this.valorNormalMinimo=valorNormalMinimo;
		this.valorNormalMaximo=valorNormalMaximo;
		this.indicaciones=indicaciones;
	} 
	
	public void evaluarNormalidad() {
		if ((getResultado().getValorMedido() < this.valorNormalMaximo)
				&& (getResultado().getValorMedido() > this.valorNormalMinimo)) {
			super.setNormalidad("normal");
		} else {
			super.setNormalidad("anormal");
		}
	}

	// Para mostrar resultados
	public String toString() {
		// Falta inicializar normalidad
		return  super.getNombre() + " " + getResultado().getValorMedido().toString() + " " + super.getNormalidad()
				+ " dentro del valor minimo " + this.valorNormalMinimo.toString() + " y valor maximo  "
				+ this.valorNormalMaximo.toString();
	}

	// Para la estadistica
	// aca me falta el visitor pero no se como se escribe. Invento el nombre
	public Prestacion esVisitado(Estadistico estadistico) {
		return this;
	}
}
