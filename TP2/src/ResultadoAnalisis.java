public class ResultadoAnalisis extends Resultado {
	private Integer valorMedido;

	public ResultadoAnalisis(Integer valorMedido) {
		this.valorMedido = valorMedido;
	}

	public Integer getValorMedido() {
		return this.valorMedido;
	}

	public String evaluarNormalidad(Integer minimo, Integer maximo) {
		return getNormalidad(
			this.valorMedido < maximo &&
				this.valorMedido > minimo
		);
	}
}
