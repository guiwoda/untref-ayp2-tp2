
public class EstudioCardiologico extends Estudio{

	
	public EstudioCardiologico(String nombre, String indicaciones) {
		super(nombre, indicaciones);
	}

	public String toString(){
		return getId() + " " + getNombre() + " " + getIndicaciones() + " " + resultado.evaluarNormalidad(); //falta normalidad
		
	}
	
}
