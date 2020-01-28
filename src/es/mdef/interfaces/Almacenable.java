package es.mdef.interfaces;

import es.mdef.taller.RepuestoAlmacen;
import es.mdef.taller.RepuestoAveria;

// Sin verlo esperaria algo que pueda ser almacenado (como los Repuestos)
public interface Almacenable {
	
	// Es muy mala practica usar una implementacion en una interface
	// Ya te estas atando a una implementacion concreta
	void agregarStock (RepuestoAlmacen repuesto, int cantidad);
	void eliminarStock (RepuestoAlmacen repuesto, int cantidad);
	Integer solicitarRepuesto (RepuestoAveria repuesto);
	Boolean hayRepuesto (RepuestoAveria repuesto);


}
