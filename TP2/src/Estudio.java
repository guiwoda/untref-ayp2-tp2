public abstract class Estudio extends TipoPrestacion {
	protected String indicaciones;
	
	public Estudio(String nombre, String indicaciones) {
		super(nombre);
		this.indicaciones = indicaciones;
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
	
	@Override
	public String toString() {
		return getNombre();
	}
	
//	public void cargarResultado(ResultadoEstudio resultado){
//		for (Prestacion prestacion : prestaciones){
//			if(prestacion==resultado.getPrestacion())
//			prestacion.setResultado(resultado);
//		}
//	}
}
