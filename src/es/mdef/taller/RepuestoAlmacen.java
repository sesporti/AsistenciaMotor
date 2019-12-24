package es.mdef.taller;

import es.mdef.interfaces.Almacenable;

public class RepuestoAlmacen extends RepuestoGeneral implements Almacenable{
	
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
	public void agregarStock(RepuestoAlmacen repuesto, int cantidad) {
		repuesto.cantidad += cantidad;
		
	}
	@Override
	public void eliminarStock(RepuestoAlmacen repuesto, int cantidad) {
		repuesto.cantidad -= cantidad;
		
	}
	@Override
	public Integer solicitarRepuesto(RepuestoAlmacen repuesto, Integer cantidadNecesaria) {
		Integer necesidadRepuesto = 0;
		if (! hayRepuesto(repuesto, cantidadNecesaria)) {
			necesidadRepuesto = cantidadNecesaria + (repuesto.getNivelMin() - repuesto.getCantidad());
		}
		return necesidadRepuesto;
	}
	@Override
	public Boolean hayRepuesto(RepuestoAlmacen repuesto, Integer cantidadNecesaria) {
		Boolean existencia=true;
		if (repuesto.getCantidad() < cantidadNecesaria) {
			existencia = false;
		}
		return existencia;
	}
	@Override
	public String toString() {
		
		return "Repuesto: ["+ getNombre()+ " ("+ getReferencia()+"), precio = "+ getPrecio()+ " euros, cantidad = "+ getCantidad()+ ", nivel minimo = "+getNivelMin()+ "]\n";
	}

}
