package es.mdef.averia;

public interface Presupuestable extends Facturable {
	
	double PRECIO_HORA = 24.50;
	
	double calcularPresuRepuestos();
	
	double calcularPresuHoras ();
	
	default double calcularPresuTotal(String tipoIva) {
		return (1 + getIva(tipoIva)) * (calcularPresuHoras() + calcularPresuRepuestos());
	}
	

}
