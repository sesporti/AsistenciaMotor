package es.mdef.averia;

import java.time.LocalDate;
import java.util.Map;

public interface Averiable<T> extends Presupuestable, Comparable<Averiable<T>> {//Comparable para ordenar por fecha de entrada averia
	
	Identificador getIdAveria();
	
	String getNombreAveria();
	
	LocalDate getFechaAveria();
	
	Map<T, Integer> getRepuestosAveria();
	
	boolean agregarRepuestoAveria(T piezaRepuesto, int cantidad);
	
	boolean eliminarRepuestoAveria(T piezaRepuesto, int cantidad);
	
	String informeRepuestos();	
	
	default int compareTo(Averiable<T> o) {
		if (getFechaAveria().isBefore(o.getFechaAveria())) {
			return -1;
		} else if (getFechaAveria().equals(o.getFechaAveria())) {
			return 0;
		} else {
			return 1;
		}
		
	}

}
