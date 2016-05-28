import java.util.Map;

public class ResultadoGrupoEstudios extends Resultado {
	private Map<TipoPrestacion, Resultado> resultados;
	
	public ResultadoGrupoEstudios(Map<TipoPrestacion, Resultado> resultados) {
		this.resultados = resultados;
	}
	
	public Resultado getResultado(TipoPrestacion tipoPrestacion) {
		return resultados.get(tipoPrestacion);
	}
}
