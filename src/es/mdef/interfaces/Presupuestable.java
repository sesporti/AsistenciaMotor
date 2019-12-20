package es.mdef.interfaces;

import java.util.Collection;

import es.mdef.taller.Repuesto;

public interface Presupuestable {
	
	Double calcularPresupuesto(Collection<Repuesto> repuestos);
	

}
