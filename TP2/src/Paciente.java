
public class Paciente {

	private Integer id;
	private String nombre;
	private Integer telefono;
	private Integer dni;
	private String mail;
	
	
	public void actualizarDatos(String nombre, Integer telefono, Integer dni, String mail ){
		this.nombre=nombre;
		this.telefono=telefono;
		this.dni=dni;
		this.mail=mail;
	}
	
}
