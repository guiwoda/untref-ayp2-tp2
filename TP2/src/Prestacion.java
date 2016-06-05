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

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		return equals((Prestacion) obj);
	}
	
	public boolean equals(Prestacion other) {
		return id == other.id;
	}

	public TipoPrestacion getTipoPrestacion(){
		return this.tipo;
	}

	public boolean hechaEntre(Date inicio, Date fin) {
		return this.fecha.compareTo(inicio) >= 0 && this.fecha.compareTo(fin) <= 0;
	}

	public Resultado getResultado() {
		return resultado;
	}

}
