package es.mdef.interfaces;


import java.time.LocalDate;
import java.util.List;

public interface Reparable extends Garantizable, Presupuestable {//comparable para comparar horas
	
	LocalDate fechaEntrega();
	
	List<Averiable> getAverias();
	
	int getHorasReparacion();
	
	boolean repararAveriable();
	
	double presupuestarReparable();
	
	

}
