import java.util.Date;

public class Prestacion implements Comparable<Prestacion> {
	private static int lastId = 0;
	
	private int id;
	private TipoPrestacion tipo;
	private Paciente paciente;
	private Date fecha;
	private Resultado resultado;
	
	public Prestacion(TipoPrestacion tipo, Paciente paciente, Date fecha) {
		this.id = ++lastId;
		this.tipo = tipo;
		this.paciente = paciente;
		this.fecha = fecha;
		
		tipo.addPrestacion(this);
	}
	
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	public String toString() {
		return this.tipo.mostrar(this.resultado);
	}

	@Override
	public int compareTo(Prestacion otra) {
		return tipo.getNombre().compareTo(otra.tipo.getNombre());
	}
}
