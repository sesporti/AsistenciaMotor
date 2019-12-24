package es.mdef.interfaces;

import es.mdef.taller.RepuestoAlmacen;


public interface Almacenable{
	
	
	void agregarStock (RepuestoAlmacen repuesto, int cantidad);
	void eliminarStock (RepuestoAlmacen repuesto, int cantidad);
	Integer solicitarRepuesto (RepuestoAlmacen repuesto, Integer cantidadNecesaria);
	Boolean hayRepuesto (RepuestoAlmacen repuesto, Integer cantidadNecesaria);


}
