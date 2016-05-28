
public abstract class Estudio extends Prestacion {

	private String nombre;
	private String indicaciones;
	
	
	public Estudio(String nombre, String indicaciones) {
		this.nombre = nombre;
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

}
