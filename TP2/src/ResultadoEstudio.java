
public class ResultadoEstudio extends Resultado {
	private Boolean esNormal;
	private Prestacion prestacionTipoEstudio;
	
	public ResultadoEstudio(Boolean esNormal){
		this.esNormal = esNormal;
	}
	
	public String evaluarNormalidad() {
		return getNormalidad(esNormal);
	}
	
	public Prestacion getPrestacion(){
		return this.prestacionTipoEstudio;
	}
}
