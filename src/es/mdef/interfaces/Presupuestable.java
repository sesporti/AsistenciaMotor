package es.mdef.interfaces;

public interface Presupuestable extends Facturable {
	
	double PRECIO_HORA = 24.50;
	
	double calcularPresuRepuestos();
	
	double calcularPresuHoras ();
	
	double calcularPresuTotal();
			

}
