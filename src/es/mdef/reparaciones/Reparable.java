package es.mdef.reparaciones;


import java.time.LocalDate;
import java.util.List;

import es.mdef.averia.Presupuestable;


public interface Reparable<T> extends Garantizable, Presupuestable, Comparable<Reparable<T>> {//comparable para comparar horas
	
	LocalDate fechaEntrega();
	
	List<T> getReparables();
	
	int getHorasReparacion();
	
	boolean reparar();
	
	default int compareTo (Reparable<T> reparable) {
		return getHorasReparacion() - reparable.getHorasReparacion();		
	}
	
	

}
