
public abstract class Resultado {
	private final static String ANORMAL = "anormal";
	private final static String NORMAL = "normal";
	
	protected String getNormalidad(boolean esNormal) {
		if (esNormal){
			return NORMAL;
		}
		
		return ANORMAL;
	}
}
