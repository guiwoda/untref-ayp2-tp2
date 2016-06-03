public class EstudioRadiologico extends Estudio {
	public EstudioRadiologico(String nombre, String indicaciones) {
		super(nombre, indicaciones);
	}
	
	public String toString(){
		return nombre;
	}

	public String mostrar(Resultado resultado){
		return "Estudio Radiologico: " + nombre + " " 
			+ ((ResultadoEstudio) resultado).evaluarNormalidad() 
			+ " " + indicaciones;
	}
}
