package es.mdef.reparaciones;


/**
 * @author sespo
 * <p>
 * Esta interfaz proporciona a cualquier objeto el periodo de garantía a aplicar, dependiendo del atributo final señalado.
 * </p>
 * <p>
 * El método que tendrá que implementar la clase que lo implemente es comprobar si esta en garantia.
 * </p>
 *
 */
public interface Garantizable {
	
	int PERIODO_GARANTIA = 12;//garantía en meses
		
	boolean estaEnGarantia();

}
