
public abstract class Estudio extends TipoPrestacion {
	protected String indicaciones;
	
	public Estudio(int id, String nombre, String indicaciones) {
		super(id, nombre);
		this.indicaciones = indicaciones;
	}

	public String toString() {
		return getNombre();
	}

	public String getNombre() {
		return nombre;
	}

	public String getIndicaciones() {
		return indicaciones;
	}
	
	//Definir si en el Nombre va a aparecer que tipo de estudio es
//	public String mostrar(Resultado resultado){
//		return "Estudio: " + nombre + " " 
//				+ ((ResultadoEstudio) resultado).evaluarNormalidad() 
//				+ " " + indicaciones;
//	}
}
