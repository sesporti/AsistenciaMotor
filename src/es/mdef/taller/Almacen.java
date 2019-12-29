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
//			System.out.println("Actualizada cantidad en Almacen: " + repuesto.toString());
		} else {
			darAltaRepuesto(repuesto);
			repuesto.agregarCantidad(cantidadAgregada);
			System.out.println("Repuesto dado de alta en Almacen");
		}
	}
	@Override
	public void eliminarStock(RepuestoAlmacen repuesto, int cantidadEliminada) {
		if (getStock().contains(repuesto)) {
			repuesto.eliminarCantidad (cantidadEliminada);
//			System.out.println("Actualizada cantidad en Almacen: "+ repuesto.toString());
		}else {
			System.out.println("El repuesto " + repuesto.toString() + " NO se encuentra en inventario del Almacen para ser eliminado");
		}
		
	}
	@Override
	public Integer solicitarRepuesto (RepuestoAveria repuesto) {
		Integer necesidadRepuesto = 0;
		for (RepuestoAlmacen repuestoAlmacen : stock) {
			if (! hayRepuesto(repuesto) && repuestoAlmacen.getReferencia().equalsIgnoreCase(repuesto.getReferencia())) {
				necesidadRepuesto = repuesto.getCantidad()+(repuestoAlmacen.getNivelMin()-repuestoAlmacen.getCantidad());				
			} else {
				System.out.println("El repuesto no existe en inventario de almacen, proceder a dar de alta como repuesto de almacen.");
			}
		}
		
		return necesidadRepuesto;		
	}
	@Override
	public Boolean hayRepuesto(RepuestoAveria repuesto) {
		Boolean existencia = false;
		for (RepuestoAlmacen repuesto2 : stock) {
			if (repuesto2.getReferencia().equals(repuesto.getReferencia()) && repuesto2.getCantidad() >= repuesto.getCantidad()) {
				existencia = true;
			}
		}
		return existencia;
	}
	public RepuestoAlmacen getRepuestoAlmacen (RepuestoAveria repuestoAveria) {
		RepuestoAlmacen repuestoAlmacen=null;
		for (RepuestoAlmacen repuesto2 : stock) {
			if (repuesto2.getReferencia().equals(repuestoAveria.getReferencia())) {
				repuestoAlmacen=repuesto2;
			}
		}		
		return repuestoAlmacen;
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
		ArrayList<RepuestoAlmacen> copiaStock = ordenarInventario(getStock());
		String inventario = "";
		for (RepuestoAlmacen repuesto : copiaStock) {
			inventario += repuesto.toString();
		}
		
		return "\nINVENTARIO DEL ALMACEN (por orden alfabético):\n" + inventario;
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

	
}
