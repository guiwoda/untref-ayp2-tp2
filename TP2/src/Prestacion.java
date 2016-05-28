import java.util.Date;

public class Prestacion {
	private int id;
	private TipoPrestacion tipo;
	private Paciente paciente;
	private Date fecha;
	private Resultado resultado;
	
	public Prestacion(int id, TipoPrestacion tipo, Paciente paciente, Date fecha) {
		this.id = id;
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
}
