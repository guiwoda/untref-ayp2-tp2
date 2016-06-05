
public class ResultadoAnalisis extends Resultado {
	// id iria el del super
	private Integer valorMedido;
	private Analisis analisis;

	//esta ok si le paso por constructor el analisis
	public ResultadoAnalisis(Integer valorMedido, Analisis analisis){
		this.valorMedido=valorMedido;
		this.analisis=analisis;
	}
	
	public Integer getValorMedido() {
		return this.valorMedido;
	}

	public String evaluarNormalidad() {
		return getNormalidad(
			this.valorMedido < analisis.getValorNormalMaximo() && 
			this.valorMedido> analisis.getValorNormalMinimo()
		);
	}
	
	public Analisis getAnalisis(){
		return analisis;
	}
}
