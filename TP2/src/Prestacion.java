import java.sql.Date;

public abstract class Prestacion {

	private String nombre;
	private Date fecha;
	private Integer id;
		
	public String toString(){
		return nombre;
		
	}
		
	//aca me falta el visitor pero no se como se escribe. Invento el nombre
	//public Prestacion esVisitado(Estadistico estadistico){
		
	//}
}
