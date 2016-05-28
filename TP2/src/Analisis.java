public class Analisis extends TipoPrestacion {

	private Integer valorNormalMinimo;
	private Integer valorNormalMaximo;
	private String indicaciones;

	public Analisis(int id, String nombre, Integer valorNormalMinimo, Integer valorNormalMaximo, String indicaciones){
		super(id, nombre);
		
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
	
	// Para mostrar resultados
	public String mostrar(Resultado resultado) {
		return  nombre + " " + resultado.toString()
				+ " dentro del valor minimo " + this.valorNormalMinimo.toString() + " y valor maximo  "
				+ this.valorNormalMaximo.toString();
	}

	// Para la estadistica
	// aca me falta el visitor pero no se como se escribe. Invento el nombre
	public TipoPrestacion esVisitado(Estadistico estadistico) {
		return this;
	}
}
