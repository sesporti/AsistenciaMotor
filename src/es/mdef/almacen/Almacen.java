package es.mdef.almacen;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Almacen<T> implements Almacenable<T> {
	
	private Map<T, Integer> stock;
		
	public Almacen () {
		stock = new TreeMap<>();
	}
	
	/**
	 * @return the stock
	 */
	public Map<T, Integer> getStock() {
		return stock;
	}

	public boolean eliminarArticulo (T articulo) {
		boolean existe = false;
		if (hayArticulo(articulo)) {
			getStock().remove(articulo);
			existe = true;
			
		}
		return existe;
	}

	@Override
	public void agregarStock(T articulo, int cantidad) {
		if (getStock().containsKey(articulo)) {
			getStock().put(articulo, getStock().get(articulo) + cantidad);
		} else {
			getStock().putIfAbsent(articulo, cantidad);
		}
	}

	@Override
	public void eliminarStock(T articulo, int cantidad) {
		getStock().put(articulo, getStock().get(articulo) - cantidad);
		
	}

	@Override
	public boolean hayArticulo(T articulo) {
		return getStock().containsKey(articulo);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String inventario = "";
		
		Map<T, Integer> hMap = new TreeMap<>(getStock());
		Iterator<Entry<T, Integer>> iterator = hMap.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry<T, Integer> entry = (Map.Entry<T, Integer>) iterator.next();
			inventario += entry.getKey() + " --> " + entry.getValue()+ " uds.\n";
			
		}	
		return "Inventario Almacen:\n" + inventario;
	}
	
}
