import java.sql.Date;

public abstract class Prestacion {
	private String nombre;
	private Date fecha;
	private Integer id;
	private Resultado resultado;
	private String normalidad;
		
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

	public String getNormalidad() {
		return normalidad;
	}

	public void setNormalidad(String normalidad) {
		this.normalidad = normalidad;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	

		
	//aca me falta el visitor pero no se como se escribe. Invento el nombre
	//public Prestacion esVisitado(Estadistico estadistico){
		
	//}
}
