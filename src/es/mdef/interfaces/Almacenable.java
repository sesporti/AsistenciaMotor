package es.mdef.interfaces;

import es.mdef.taller.Repuesto;

public interface Almacenable{
	
	
	void agregarStock (Repuesto repuesto, int cantidad);
	void eliminarStock (Repuesto repuesto, int cantidad);
	Integer solicitarRepuesto (Repuesto repuesto);
	void darAltaRepuesto (Repuesto repuesto);
	void darBajaRepuesto (Repuesto repuesto);


}
