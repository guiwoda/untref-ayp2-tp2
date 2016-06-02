
public class EstudioCardiologico extends Estudio {
	
	public EstudioCardiologico(int id, String nombre, String indicaciones) {
		super(id, nombre, indicaciones);
	}

	public String mostrar(Resultado resultado){
		//Lo unico que cambia respecto de ERadio es la palabra Cardiologico, por eso no lo pongo en Estudio
		return "Estudio Cardiologico: " + nombre + " " 
			+ ((ResultadoEstudio) resultado).evaluarNormalidad() 
			+ " " + indicaciones;
	}
}
