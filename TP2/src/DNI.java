public class DNI {
	private static final String FEMENINO = "F";
	private static final String MASCULINO = "M";
	
	private String sexo;
	private int numero;
	
	private DNI(String sexo, int numero){
		this.sexo = sexo;
		this.numero = numero;
	}
	
	public static DNI masculino(int numero) {
		return new DNI(MASCULINO, numero);
	}
	
	public static DNI femenino(int numero) {
		return new DNI(FEMENINO, numero);
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getSexo(){
		return sexo;
	}
	
	@Override
	public String toString() {
		return sexo + String.valueOf(numero);
	}

	public boolean isMasculino() {
		return sexo == MASCULINO;
	}

	public boolean isFemenino() {
		return sexo == FEMENINO;
	}
	
	public boolean equals(DNI dniAComparar){
		return (this.getNumero() == dniAComparar.getNumero()) && (this.sexo == dniAComparar.getSexo());
	}
}
