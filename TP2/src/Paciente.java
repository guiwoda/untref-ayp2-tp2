
public class Paciente {
	private static Integer lastId = 0;
	
	private Integer id;
	private String nombre;
	private Integer telefono;
	private DNI dni;
	private String mail;
	//hace falta que se cuente con prestaciones pendientes y resueltas, para el ingreso de un paciente al laboratorio
	private TipoPrestacion[] prestaciones;
	
	
	public Paciente(String nombre, Integer telefono, DNI i, String mail){
		this.id = ++lastId;
		this.nombre = nombre;
		this.telefono = telefono;
		this.dni = i;
		this.mail = mail;
	}
	
	public void actualizarDatos(String nombre, Integer telefono, DNI dni, String mail){
		this.nombre=nombre;
		this.telefono=telefono;
		this.dni=dni;
		this.mail=mail;
	}
	
	//Lo usamos para el Set de Pacientes de Laboratorio
	public Boolean compareTo(Paciente pacienteAComparar){
		return (this.id == pacienteAComparar.id);
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public DNI getDni(){
		return dni;
	}
	
	public String getMail(){
		return mail;
	}
	
	public Integer getTelefono(){
		return telefono;
	}
}
