import java.sql.Date;
import java.util.TreeMap;
import java.util.TreeSet;

public class Laboratorio {
	
	//para llevar listado de Pacientes
	private TreeSet <Paciente> pacientes;
	//para estadistica
	private TreeMap <String, Prestacion> estudios;
	
	//En los parametros me parece que va directo la info id y nombre y no ya un paciente
	public void ingresoPaciente(Paciente paciente){
			if (!pacientes.contains(paciente)){
				//aca deberiamos crear un paciente y no recibirlo por parametro
				pacientes.add(paciente);
			}
			//lo hace siempre sea nuevo o paciente existente
			//registrarVisita(Paciente paciente, Date fecha, Prestacion[] prestaciones);
	}
	
	public void registrarVisita(Paciente paciente, Date fecha, Prestacion[] prestaciones){
		
	}
	
	public void estadistica(){
		
		Estadistico estadistico = new Estadistico();		
	}
}
