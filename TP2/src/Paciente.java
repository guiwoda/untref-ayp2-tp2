import java.util.LinkedList;
import java.util.List;

public class Paciente {
	private static Integer lastId = 0;

	private Integer id;
	private String nombre;
	private Integer telefono;
	private DNI dni;
	private String email;
	private List<Prestacion> prestaciones = new LinkedList<>();

	public Paciente(int id, String nombre, Integer telefono, DNI dni, String email) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.dni = dni;
		this.email = email;
	}

	public Paciente(String nombre, Integer telefono, DNI dni, String email) {
		this(++lastId, nombre, telefono, dni, email);
	}

	public void agregarPrestacion(Prestacion prestacion) {
		prestaciones.add(prestacion);
	}

	public List<Prestacion> getPrestaciones() {
		return prestaciones;
	}

	public Boolean compareTo(Paciente other) {
		return (this.id.equals(other.id));
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public DNI getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	public Integer getTelefono() {
		return telefono;
	}
}
