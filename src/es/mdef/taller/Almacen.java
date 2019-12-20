package es.mdef.taller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import es.mdef.interfaces.Almacenable;

public class Almacen implements Almacenable{
	
	private Collection<Repuesto> stock;
		
	
	/**
	 * @return the nivelMin
	 */
	@Override
	public void agregarStock(Repuesto repuesto, int cantidadAgregada) {
		if (stock.contains(repuesto)) {
			repuesto.agregarCantidad(cantidadAgregada);
			System.out.println("Agregada cantidad al repuesto " + repuesto.toString());
		}
	}
	@Override
	public void eliminarStock(Repuesto repuesto, int cantidadEliminada) {
		if (stock.contains(repuesto)) {
			repuesto.eliminarCantidad (cantidadEliminada);
			System.out.println("Eliminada cantidad de repuesto "+ repuesto.toString());
		}
		
	}
	@Override
	public Integer solicitarRepuesto(Repuesto repuesto) {
		Integer cantidadNecesaria = 0; 
		if (repuesto.getCantidad() < repuesto.getNivelMin()) {
			cantidadNecesaria = repuesto.getNivelMin() - repuesto.getCantidad();
			System.out.println("Peligro de Stock de repuesto " + repuesto.getReferencia()+ ", necesario solicitar " + cantidadNecesaria + " unidades.");
			
		}
		return cantidadNecesaria;
		
	}
	@Override
	public void darAltaRepuesto(Repuesto repuesto) {
		if (! stock.contains(repuesto)) {
			stock.add(repuesto);
		}
	}
	@Override
	public void darBajaRepuesto(Repuesto repuesto) {
		if (stock.contains(repuesto)) {
			stock.remove(repuesto);
		} else {
			System.out.println("El repuesto no se encuentra en inventario.");
		}
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String inventario = "";
		for (Repuesto repuesto : stock) {
			inventario += repuesto.toString();
		}
		return "El inventario del almacen es el siguiente: " + inventario;
	}
	ArrayList<Repuesto> ordenarInventario (Collection<Repuesto> inventario) {
		
		ArrayList<Repuesto> bArrayList = new ArrayList<>(inventario);
		Comparator<Repuesto> c = new Comparator<Repuesto>() {

			@Override
			public int compare(Repuesto o1, Repuesto o2) {
				return o1.getReferencia().compareTo(o2.getReferencia());
			}
			
		};
		bArrayList.sort(c);
		return bArrayList;
	}

}
