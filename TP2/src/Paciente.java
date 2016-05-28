
public class Paciente {

	private Integer id;
	private String nombre;
	private Integer telefono;
	private Integer dni;
	private String mail;
	
	
	public Paciente(Integer id, String nombre, Integer telefono, Integer dni, String mail){
		this.id=id;
		this.nombre=nombre;
		this.telefono=telefono;
		this.dni=dni;
		this.mail=mail;
	}
	
	public void actualizarDatos(String nombre, Integer telefono, Integer dni, String mail){
		this.nombre=nombre;
		this.telefono=telefono;
		this.dni=dni;
		this.mail=mail;
	}
	
	//Lo usamos para el Set de Pacientes de Laboratorio
	public Boolean compareTo(Paciente pacienteAComparar){
		return (this.id == pacienteAComparar.id);
	}
	
}
