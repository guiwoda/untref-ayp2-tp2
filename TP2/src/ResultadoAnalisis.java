
public class ResultadoAnalisis extends Resultado {
	// id iria el del super
	private Integer valorMedido;
	private Analisis prestacionTipoAnalisis;

	//esta ok si le paso por constructor el analisis
	public ResultadoAnalisis(Integer valorMedido, Analisis analisis){
		this.valorMedido=valorMedido;
		this.prestacionTipoAnalisis=analisis;
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
