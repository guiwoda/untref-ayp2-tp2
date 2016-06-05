import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public abstract class TipoPrestacion {
	private static int lastId = 0;
	
	protected Integer id;
	protected String nombre;
	protected List<Prestacion> prestaciones;
	
	abstract public String mostrar(Resultado resultado);
	
	public TipoPrestacion(String nombre) {
		this.id = ++lastId;
		this.nombre = nombre;
		//LinkedList porque es mas rapido para agregar/borrar en posicion intermedia
		this.prestaciones= new LinkedList<Prestacion>();
	}
	
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void addPrestacion(Prestacion prestacion) {
		this.prestaciones.add(prestacion);
	}
	
	
	//aca me falta el visitor pero no se como se escribe. Invento el nombre
	//public Prestacion esVisitado(Estadistico estadistico){
		
	//}

	@Override
	public String toString(){
		return getNombre();	
	}

}
