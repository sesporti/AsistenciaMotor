package es.mdef.taller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import es.mdef.interfaces.Almacenable;

// Ok, he visto que tambien has visto que te hace falta una clase Almacen
// pero la pega es que al final el que se encarga de controlar la cantidad es el 
// Repuesto. Esto es lo incorrecto
// La interfaz Almacenable me sonaria mas a lo que se puede almacenar: El Repuesto, mas que
// a lo que controla el almacen
// Este almacen podria usarse con genericos. Y podrias limitarlo a <T extends Repuesto> por ejemplo
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
	// Estas regando todo el codigo ya con una implementacion cuando no hace falta
	// Recuerda la potencia de las interfaces. Tendrias que haber usado la interface Repuesto
	// o Almacenable si es lo que vas a usar aqui
	@Override
	public void agregarStock(RepuestoAlmacen repuesto, int cantidadAgregada) {
		if (getStock().contains(repuesto)) {
			// Si te das cuenta, la responsabilidad de tener la cantidad es del Repuesto
			// no del Almacen
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
		// Ojo, mejor inicializar al estado que consideres mas probable o que esperes por defecto
		// en este caso mejor false para que por defecto no te de un falso positivo.
		// Si te fijas, si no tuvieras ninguna pieza de respuesto te daria como que hay en inventario
		// y una necesidadRepuesto de 0
		boolean hayInventario = true;
		for (RepuestoAlmacen repuestoAlmacen : stock) {
			if (! hayRepuesto(repuesto) && repuestoAlmacen.getReferencia().equalsIgnoreCase(repuesto.getReferencia())) {
				necesidadRepuesto = repuesto.getCantidad()+(repuestoAlmacen.getNivelMin()-repuestoAlmacen.getCantidad());
				hayInventario = true;
			} else {
				hayInventario= false;
			}
		}
		if (!hayInventario) {
			System.out.println("NO EXISTE REPUESTO = "+repuesto.getReferencia()+" en inventario de almacen: solicite la cantidad de "+ repuesto.getCantidad() + " uds.\n");
		}
		
		return necesidadRepuesto;		
	}
	@Override
	public Boolean hayRepuesto(RepuestoAveria repuesto) {
		// Aqui mejor, inicializando a false, pero usa tipos primitivos siempre que puedas
		// Aqui no ganas nada pudiendo hacer null a existencia y de hecho no lo usas asi
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
		// No se usa un try-catch para capturar un NullPointerException
		// Debes controlarlo comprobando que lo que te puede dar null no te lo da
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
			// Lee la descripcion del metodo remove. Creo que verás que puedes simplificar
			// y ahorrar codigo y comprobaciones
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
			// Aqui es donde pondrías el salto de linea, no en el toString()
			inventario += repuesto.toString();
		}
		
		return "\nINVENTARIO DEL ALMACEN (por orden alfabético):\n" + inventario;
	}
	ArrayList<RepuestoAlmacen> ordenarInventario (Collection<RepuestoAlmacen> inventario) {
		
		// Aqui si lo estas haciendo bien, pero puedes mejorarlo usando List en vez de ArrayList
		// solo observando buenas practicas constantemente se quedan grabadas
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
