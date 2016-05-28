public class EstudioRadiologico extends Estudio {
	public EstudioRadiologico(int id, String nombre, String indicaciones) {
		super(id, nombre, indicaciones);
	}
	
	public String toString(){
		return nombre;
	}

	@Override
	public String mostrar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}
}
