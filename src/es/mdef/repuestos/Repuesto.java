package es.mdef.repuestos;

public class Repuesto<T> implements Coste, Nivelable, PiezaRepuesto<T> {

	private String nombre;
	private T referencia;//se podría haber creado un tipo referencia con numeros y letras (identificando el proveedor con letra y con numero secuencial de referencia del proveedor. Intento genericos.
	private String marca;
	private double precio;
	private int nivelMin;//es una caracteristica del repuesto y no del almacen. Por defecto es 0.

	public Repuesto() {
		super();
	}
	public Repuesto (String nombre, T referencia, String marca, double precio) {
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
	public T getReferencia() {
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
	
	@Override
	public int getNivelMin() {
		// TODO Auto-generated method stub
		return nivelMin;
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
	 * Comparable por la referencia del repuesto
	 */
//	@Override
//	public int compareTo(PiezaRepuesto<T> o) {
//		
//		return ((PiezaRepuesto<T>) getReferencia()).compareTo((PiezaRepuesto<T>) o.getReferencia());
//	}

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
		Repuesto<?> other = (Repuesto<?>) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}

}
