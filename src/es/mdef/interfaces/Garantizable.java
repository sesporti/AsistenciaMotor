package es.mdef.interfaces;

// ¿Usas esta interface para algo?
public interface Garantizable {
	// Pues eso, que abusas de los wrappers: tanto Integer como Boolean
	Integer PERIODO_GARANTIA = 12;//garantía en meses
	
	Boolean estaEnGarantia();

}
