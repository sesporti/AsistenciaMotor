package es.mdef.interfaces;

import es.mdef.taller.RepuestoAlmacen;
import es.mdef.taller.RepuestoAveria;


public interface Almacenable {
	
	
	void agregarStock (RepuestoAlmacen repuesto, int cantidad);
	void eliminarStock (RepuestoAlmacen repuesto, int cantidad);
	Integer solicitarRepuesto (RepuestoAveria repuesto);
	Boolean hayRepuesto (RepuestoAveria repuesto);


}
