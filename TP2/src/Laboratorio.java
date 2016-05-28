import java.sql.Date;
import java.util.TreeMap;
import java.util.TreeSet;

public class Laboratorio {
	
	//para llevar listado de Pacientes
	private TreeSet <Paciente> pacientes;
	//para estadistica
	private TreeMap <String, TipoPrestacion> estudios;
	
	//Dos metodos para ingreso paciente de acuerdo si existe o no
	public void ingresoPacienteNuevo(String nombre, Integer dni, Integer telefono, String mail){
			
			Paciente paciente = new Paciente(nombre, dni, telefono, mail);
			pacientes.add(paciente);
			//registrarVisita(paciente, Date fecha, Prestacion[] prestaciones);
	}
	
	public void ingresoPacienteExistente(Paciente paciente){
		//registrarVisita(Paciente paciente, Date fecha, Prestacion[] prestaciones);
	}
	
	public void registrarVisita(Paciente paciente, Date fecha, TipoPrestacion[] prestaciones){
		
	}
	
	public void estadistica(){
		
		Estadistico estadistico = new Estadistico();		
	}
}
