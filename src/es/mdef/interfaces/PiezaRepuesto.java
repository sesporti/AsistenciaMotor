package es.mdef.interfaces;


public interface PiezaRepuesto<T> extends Comparable<PiezaRepuesto<T>>{

	/**
	 * @return the nombre
	 */
	String getNombre();

	/**
	 * @return the referencia
	 */
	T getReferencia();

	/**
	 * @return the marca
	 */
	String getMarca();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	String toString();

	int compareTo(PiezaRepuesto<T> o);

}