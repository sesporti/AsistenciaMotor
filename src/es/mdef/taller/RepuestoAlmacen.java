package es.mdef.taller;


public class RepuestoAlmacen extends RepuestoGeneral {
	
	private Integer cantidad;
	private Integer nivelMin;
	
	public RepuestoAlmacen (String referencia, Double precio, Integer cantidad, Integer nivelMin) {
		super("SIN DEFINIR", referencia, precio);
		setCantidad(cantidad);
		setNivelMin(nivelMin);		
	}
	
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	private void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the nivelMin
	 */
	public Integer getNivelMin() {
		return nivelMin;
	}
	/**
	 * @param nivelMin the nivelMin to set
	 */
	private void setNivelMin(Integer nivelMin) {
		this.nivelMin = nivelMin;
	}
	
	public void agregarCantidad (int cantidad) {
		
		this.cantidad = getCantidad() + cantidad;
	}
	public void eliminarCantidad(int cantidadEliminada) {
		
		this.cantidad = getCantidad() - cantidadEliminada;
		
	}

	@Override
	public String toString() {
		
		return "Repuesto: ["+ super.toString() + ", cantidad = "+ getCantidad()+ ", nivel minimo = "+getNivelMin()+ "]\n";
	}

}
