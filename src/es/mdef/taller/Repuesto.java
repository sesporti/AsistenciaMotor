package es.mdef.taller;


import es.mdef.interfaces.Coste;
import es.mdef.interfaces.PiezaRepuesto;

public class Repuesto implements Coste, PiezaRepuesto<String> {

	private String nombre;
	private String referencia;
	private String marca;
	private double precio;

	public Repuesto() {
		super();
	}
	public Repuesto (String nombre, String referencia, String marca, double precio) {
		this.nombre= nombre;
		this.referencia = referencia;
		this.precio = precio;
		this.marca = marca;
	}

	/* (non-Javadoc)
	 * @see es.mdef.taller.PiezaRepuesto#getNombre()
	 */
	@Override
	public String getNombre() {
		return nombre;
	}

	/* (non-Javadoc)
	 * @see es.mdef.taller.PiezaRepuesto#getReferencia()
	 */
	@Override
	public String getReferencia() {
		return referencia;
	}

	/* (non-Javadoc)
	 * @see es.mdef.taller.PiezaRepuesto#getMarca()
	 */
	@Override
	public String getMarca() {
		return marca;
	}

	@Override
	public double getPrecio() {
		return precio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see es.mdef.taller.PiezaRepuesto#toString()
	 */
	@Override
	public String toString() {
		return " (" + getReferencia() + "), " + getNombre() + ", precio = " + getPrecio() +" euros";
	}

	/* (non-Javadoc)
	 * @see es.mdef.taller.PiezaRepuesto#compareTo(es.mdef.taller.Repuesto)
	 */
	@Override
	public int compareTo(PiezaRepuesto<String> o) {
		
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
		Repuesto other = (Repuesto) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}
}
