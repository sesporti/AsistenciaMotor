package es.mdef.taller;

// Echo en falta una interfaz PiezaRepuesto o algo asi 
public abstract class RepuestoGeneral implements Comparable<RepuestoGeneral> {

	// Tienes que dividir al minimo posible cualquier "entidad" de tu aplicacion
	// ¿Hace falta tener un proveedor para referirme a un Repuesto?
	// ¿El modelo tendra relacion directa con la marca?
	// ¿Hace falta tener un precio para referirme a un Repuesto?
	// Todo lo que sea 'NO' (es decir, las 3 preguntas) es mejor estar fuera de aqui:
	//     Los proveedores seran de un tipo Proveedor y tendran precios para lo que vendan (Repuesto)
	//	   Un modelo de repuesto sera de una marca
	//	   etc... asi aprovecharas mas todo lo que hagas aunque al principio te parezca mas complicado
	// Si algo no querias implementarlo (pej. el Proveedor) directamente no lo pongas hasta que no
	// te haga falta.
	protected String nombre;
	protected String referencia;
	protected String marca;
	protected String modelo;
	protected String proveedor;
	protected Double precio;

	public RepuestoGeneral() {
		super();
	}
	public RepuestoGeneral (String nombre, String referencia, Double precio) {
		this.nombre= nombre;
		this.referencia = referencia;
		this.precio = precio;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getNombre() + " (" + getReferencia() + "), precio = " + getPrecio() +" euros";
	}

	@Override
	public int compareTo(RepuestoGeneral o) {
		
		return getReferencia().compareTo(o.getReferencia());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepuestoGeneral other = (RepuestoGeneral) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}

}