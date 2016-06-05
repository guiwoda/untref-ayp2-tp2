
public class ResultadoAnalisis extends Resultado {
	// id iria el del super
	private Integer valorMedido;
	private Prestacion prestacionTipoAnalisis;

	//esta ok si le paso por constructor el analisis
	public ResultadoAnalisis(Integer valorMedido, Prestacion glucemia){
		this.valorMedido=valorMedido;
		this.prestacionTipoAnalisis=glucemia;
	}
	
	public Integer getValorMedido() {
		return this.valorMedido;
	}

	public String evaluarNormalidad() {
		Analisis tipoAnalisis = (Analisis) prestacionTipoAnalisis.getTipoPrestacion();
		return getNormalidad(
			this.valorMedido < tipoAnalisis.getValorNormalMaximo() && 
			this.valorMedido> tipoAnalisis.getValorNormalMinimo()
		);
	}
	
	public Prestacion getPrestacion(){
		return prestacionTipoAnalisis;
	}
}
