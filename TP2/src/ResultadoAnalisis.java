
public class ResultadoAnalisis extends Resultado {
	// id iria el del super
	private Integer valorMedido;
	
	//se borra TipoAnalisis
	//esta ok si le paso por constructor el analisis
	public ResultadoAnalisis(Integer valorMedido){
		this.valorMedido=valorMedido;
	}
	
	public Integer getValorMedido() {
		return this.valorMedido;
	}

	public String evaluarNormalidad(Integer minimo, Integer maximo) {
		return getNormalidad(
			this.valorMedido < maximo && 
			this.valorMedido> minimo
		);
	}
	
}
