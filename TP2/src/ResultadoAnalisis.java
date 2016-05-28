
public class ResultadoAnalisis extends Resultado {
	// id iria el del super
	private Integer valorMedido;
	private Analisis analisis;

	public Integer getValorMedido() {
		return this.valorMedido;
	}

	public String evaluarNormalidad() {
		return getNormalidad(
			this.valorMedido < analisis.getValorNormalMaximo() && 
			this.valorMedido> analisis.getValorNormalMinimo()
		);
	}
}
