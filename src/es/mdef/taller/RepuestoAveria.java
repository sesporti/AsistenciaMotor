package es.mdef.taller;

public class RepuestoAveria extends RepuestoGeneral {
	
	private Integer cantidadAsignada;
	
	
	public RepuestoAveria (String referencia, Double precio, Integer cantidad) {
		super("Sin definir", referencia, precio);
		this.cantidadAsignada = cantidad;
	}
	
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidadAsignada;
	}

	@Override
	public String toString() {
		
		return "Info Repuesto Averia: [" + getNombre() + " (" + getReferencia() + "), cantidad = " + getCantidad() + ", precio = " + getPrecio()+"]";
	}
}
