package es.mdef.taller;

public class Repuesto implements Comparable<Repuesto>{
	
	private String nombre, referencia, marca, modelo, proveedor;
	private Double precio;
	private Integer cantidad;
	private Integer nivelMin;
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @return the proveedor
	 */
	public String getProveedor() {
		return proveedor;
	}
	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @return the nivelMin
	 */
	public Integer getNivelMin() {
		return nivelMin;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Repuesto [getReferencia()=" + getReferencia() + ", getPrecio()=" + getPrecio() + ", getCantidad()="
				+ getCantidad() + " (NivelMinimo: " + getNivelMin() + ")]\n";
	}
	public void agregarCantidad (int cantidad) {
		
		this.cantidad = getCantidad() + cantidad;
	}
	public void eliminarCantidad(int cantidadEliminada) {
		
		this.cantidad = getCantidad() - cantidadEliminada;
		
	}
	@Override
	public int compareTo(Repuesto o) {
		
		return getReferencia().compareTo(o.getReferencia());
	}

	
	public Repuesto (String referencia, Double precio, Integer cantidad, Integer nivelMin) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.referencia = referencia;
		this.nivelMin = nivelMin;
		nombre = "Pendiente definir";
		marca = "Pendiente definir";
		modelo = "Pendiente definir";
		proveedor = "Pendiente definir";
	}

}
