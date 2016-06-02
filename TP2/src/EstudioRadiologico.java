public class EstudioRadiologico extends Estudio {
	
	//que onda es identico al de la madre
	public EstudioRadiologico(int id, String nombre, String indicaciones) {
		super(id, nombre, indicaciones);
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
