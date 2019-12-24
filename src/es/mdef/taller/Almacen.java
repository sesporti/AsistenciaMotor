package es.mdef.taller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import es.mdef.interfaces.Almacenable;

public class Almacen implements Almacenable {
	
	private Set<RepuestoAlmacen> stock;
		
	public Almacen () {
		stock = new TreeSet<>();
	}
	/**
	 * @return the stock
	 */
	public Set<RepuestoAlmacen> getStock() {
		return stock;
	}
	@Override
	public void agregarStock(RepuestoAlmacen repuesto, int cantidadAgregada) {
		if (getStock().contains(repuesto)) {
			repuesto.agregarCantidad(cantidadAgregada);
			System.out.println("Agregada cantidad al repuesto " + repuesto.toString());
		} else {
			darAltaRepuesto(repuesto);
			repuesto.agregarCantidad(cantidadAgregada);
			System.out.println("El repuesto ha sido dado de alta en inventario");
		}
	}
	@Override
	public void eliminarStock(RepuestoAlmacen repuesto, int cantidadEliminada) {
		if (getStock().contains(repuesto)) {
			repuesto.eliminarCantidad (cantidadEliminada);
			System.out.println("Eliminada cantidad de repuesto "+ repuesto.toString());
		}else {
			System.out.println("El repuesto " + repuesto.toString() + " NO se encuentra en inventario del Almacen para ser eliminado");
		}
		
	}
	@Override
	public Integer solicitarRepuesto (RepuestoAlmacen repuesto, Integer cantidadNecesaria) {
		Integer necesidadRepuesto = 0; 
		if (repuesto.getCantidad() < repuesto.getNivelMin()) {
			necesidadRepuesto = repuesto.getNivelMin() - repuesto.getCantidad();
			System.out.println("Peligro en Stock de repuesto " + repuesto.getReferencia()+ ", necesario solicitar " + necesidadRepuesto + " unidades.");
				
		}
		return necesidadRepuesto;		
	}
	public void darAltaRepuesto(RepuestoAlmacen repuesto) {
		try {
			if (! getStock().contains(repuesto)) {
				getStock().add(repuesto);
			} else {
				System.out.println("El repuesto ya se encuentra dado de alta en inventario.");
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	public void darBajaRepuesto(RepuestoAlmacen repuesto) {
		if (getStock().contains(repuesto)) {
			getStock().remove(repuesto);
		} else {
			System.out.println("El repuesto no se encuentra en inventario.");
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		ordenarInventario(getStock());
		String inventario = "";
		for (RepuestoAlmacen repuesto : stock) {
			inventario += repuesto.toString();
		}
		return "INVENTARIO DEL ALMACEN:\n" + inventario;
	}
	ArrayList<RepuestoAlmacen> ordenarInventario (Collection<RepuestoAlmacen> inventario) {
		
		ArrayList<RepuestoAlmacen> inventarioPorNombre = new ArrayList<>(inventario);
		Comparator<RepuestoAlmacen> c = new Comparator<RepuestoAlmacen>() {

			@Override
			public int compare(RepuestoAlmacen o1, RepuestoAlmacen o2) {
				return o1.getNombre().compareTo(o2.getNombre());
			}			
		};
		inventarioPorNombre.sort(c);
		return inventarioPorNombre;
	}
	@Override
	public Boolean hayRepuesto(RepuestoAlmacen repuesto, Integer cantidadNecesaria) {
		Boolean existencia = false;
		for (RepuestoAlmacen repuesto2 : stock) {
			if (repuesto2.equals(repuesto) && repuesto2.getCantidad() >= cantidadNecesaria) {
				existencia = true;
			}
		}
		return existencia;
	}
	
}
