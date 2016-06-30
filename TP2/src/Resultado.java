public abstract class Resultado {
	private final static String ANORMAL = "Anormal";
	private final static String NORMAL = "Normal";

	protected String getNormalidad(boolean esNormal) {
		if (esNormal) {
			return NORMAL;
		}

		return ANORMAL;
	}
}
