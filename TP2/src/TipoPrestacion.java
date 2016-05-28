public abstract class TipoPrestacion {
	protected Integer id;
	protected String nombre;
	
	public TipoPrestacion(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public String toString(){
		return getNombre();	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	abstract public String mostrar(Resultado resultado);

	//aca me falta el visitor pero no se como se escribe. Invento el nombre
	//public Prestacion esVisitado(Estadistico estadistico){
		
	//}
}
