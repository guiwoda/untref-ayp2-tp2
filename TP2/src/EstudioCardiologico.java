
public class EstudioCardiologico extends Estudio {
	public EstudioCardiologico(int id, String nombre, String indicaciones) {
		super(id, nombre, indicaciones);
	}

	public String mostrar(Resultado resultado){
		return id + " " + nombre + " " + indicaciones; // falta normalidad
	}
}
