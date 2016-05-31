import java.util.LinkedList;
import java.util.List;


public abstract class TipoPrestacion {
	protected Integer id;
	protected String nombre;
	protected List<Prestacion> prestaciones;
	
	public TipoPrestacion(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		//LinkedList porque es mas rapido para agregar/borrar en posicion intermedia
		this.prestaciones= new LinkedList<Prestacion>();
	}
	
	public String toString(){
		return getNombre();	
	}

	public String getNombre() {
		return nombre;
	}
	//este estaria de mas? lo genero con el constructor
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void addPrestacion(Prestacion prestacion) {
		this.prestaciones.add(prestacion);
	}
	
	abstract public String mostrar(Resultado resultado);

	//aca me falta el visitor pero no se como se escribe. Invento el nombre
	//public Prestacion esVisitado(Estadistico estadistico){
		
	//}
}
