
public class ResultadoEstudio extends Resultado {
	private Boolean esNormal;
	
	public ResultadoEstudio(Boolean esNormal){
		this.esNormal = esNormal;
	}
	
	public String evaluarNormalidad() {
		return getNormalidad(esNormal);
	}
}
