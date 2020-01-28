package es.mdef.taller;

// Veo que sigues mezclando responsabilidades
// ¿Por que no poner esto en una clase Reparacion?
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

	/**
	 * @param cantidadAsignada the cantidadAsignada to set
	 */
	void setCantidadAsignada(Integer cantidadAsignada) {
		this.cantidadAsignada = cantidadAsignada;
	}

	@Override
	public String toString() {
		
		return "Repuesto Averia: [" + super.toString() + ", cantidad = " + getCantidad() +"]";
	}
}
