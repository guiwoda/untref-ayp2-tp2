public class EstudioCardiologico extends Estudio {
	public EstudioCardiologico(String nombre, String indicaciones) {
		super(nombre, indicaciones);
	}

	public String mostrar(Resultado resultado) {
		//Lo unico que cambia respecto de ERadio es la palabra Cardiologico, por eso no lo pongo en Estudio
		return 
			"Estudio Cardiológico: " + nombre + 
			" " + ((ResultadoEstudio) resultado).evaluarNormalidad() + 
			" " + indicaciones;
	}
}
