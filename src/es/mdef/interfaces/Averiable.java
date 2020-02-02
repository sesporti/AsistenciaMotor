package es.mdef.interfaces;

import java.time.LocalDate;
import java.util.Map;

import es.mdef.taller.Identificador;
import es.mdef.taller.Repuesto;

public interface Averiable extends Presupuestable {
	
	Identificador getIdAveria();
	
	String getNombreAveria();
	
	LocalDate getFechaAveria();
	
	Map<Repuesto, Integer> getRepuestoCantidad();
	
	boolean agregarRepuestoCantidad();
	
	boolean eliminarRepuestoCantidad();
	
	String presupuestarAveriable();

}
