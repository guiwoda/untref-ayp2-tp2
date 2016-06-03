public class Analisis extends TipoPrestacion {

	private Integer valorNormalMinimo;
	private Integer valorNormalMaximo;
	private String indicaciones;

	public Analisis(String nombre, Integer valorNormalMinimo, Integer valorNormalMaximo, String indicaciones){
		super(nombre);
		
		this.valorNormalMinimo = valorNormalMinimo;
		this.valorNormalMaximo = valorNormalMaximo;
		this.indicaciones = indicaciones;
	}

	public Integer getValorNormalMinimo(){
		return this.valorNormalMinimo;
	}
	
	public Integer getValorNormalMaximo(){
		return this.valorNormalMaximo;
	}
	

	public String mostrar(Resultado resultado) {
		//Me obliga a hacer downcasting si quiero usar el metodo especifico
		return  "Analisis: " + nombre + " " + ((ResultadoAnalisis) resultado).evaluarNormalidad()
				+ " en el rango de valores " + this.valorNormalMinimo.toString() + " - "
				+ this.valorNormalMaximo.toString();
	}

	// Para la estadistica
	// aca me falta el visitor pero no se como se escribe. Invento el nombre
	public TipoPrestacion esVisitado(Estadistico estadistico) {
		return this;
	}
}
