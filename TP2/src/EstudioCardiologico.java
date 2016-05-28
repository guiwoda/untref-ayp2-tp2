

public class EstudioCardiologico extends Estudio{

	
	public EstudioCardiologico(String nombre, String indicaciones) {
		super(nombre, indicaciones);
		// TODO Apéndice de constructor generado automáticamente
	}

	public String toString(){
		return getId() + " " + getNombre() + " " + getIndicaciones() + " " + getNormalidad();
		
	}
	
}
