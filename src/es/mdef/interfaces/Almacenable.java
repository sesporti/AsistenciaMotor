package es.mdef.interfaces;

public interface Almacenable<T> {
	
	void agregarStock (T articulo, int cantidad);
	void eliminarStock (T articulo, int cantidad);
	boolean hayArticulo (T articulo);


}
