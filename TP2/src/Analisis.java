import java.util.Date;
import java.util.List;

public class Analisis extends TipoPrestacion {

    private Integer valorNormalMinimo;
    private Integer valorNormalMaximo;
    private String indicaciones;

    public Analisis(String nombre, Integer valorNormalMinimo, Integer valorNormalMaximo, String indicaciones) {
        super(nombre);

        this.valorNormalMinimo = valorNormalMinimo;
        this.valorNormalMaximo = valorNormalMaximo;
        this.indicaciones = indicaciones;
    }

	public Integer getValorNormalMinimo(){
		return this.valorNormalMinimo;
	}
	
	public Integer getValorNormalMaximo(){
		return this.valorNormalMaximo;
	}
	

	public String mostrar(Resultado resultado) {
		return  "Analisis: " + nombre + " " + ((ResultadoAnalisis) resultado).evaluarNormalidad(valorNormalMinimo, valorNormalMaximo)
				+ " " + ((ResultadoAnalisis) resultado).getValorMedido() + " en el rango de valores " + this.valorNormalMinimo.toString() + " - "
				+ this.valorNormalMaximo.toString();
	}

	public void cargarResultado(ResultadoAnalisis resultado){
		for (Prestacion prestacion : prestaciones){
			prestacion.setResultado(resultado);
		}
	}
    @Override
    public String getEstadisticas(List<Prestacion> prestaciones) {
        StringBuilder result = new StringBuilder();

        result.append(nombre).append(": ").append("\n");

        int cantidad = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (Prestacion prestacion : prestaciones) {
            ResultadoAnalisis resultado = (ResultadoAnalisis) prestacion.getResultado();

            if (resultado == null) {
                continue;
            }

            cantidad++;
            Integer valorMedido = resultado.getValorMedido();

            if (valorMedido < min) {
                min = valorMedido;
            }

            if (valorMedido > max) {
                max = valorMedido;
            }

            sum += valorMedido;
        }

        if (cantidad == 0) {
            return result.append("No hay prestaciones entre las fechas pedidas.").toString();
        }

        result.append("Cantidad de pacientes: ").append(cantidad).append("\n");
        result.append("Valor mínimo medido: ").append(min).append("\n");
        result.append("Valor máximo medido: ").append(max).append("\n");
        result.append("Promedio de valores: ").append(sum / cantidad).append("\n");

        return result.toString();
    }
}
