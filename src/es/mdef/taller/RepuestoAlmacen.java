package es.mdef.taller;

// No lo veo como un extends
// Las piezas no deberian saber nada de cuantas hay o un nivel a mantener
// En vez de eso deberias crearte una clase a la que le cargues esa responsabilidad: Almacen
// El almacen si puede tener un stock que relaciones Repuestos con sus cantidades y puedes añadir
// mas cosas como el nivel minimo, pero a una clase que se encargue solo de eso, no mezclando
// con otras responsabilidades
public class RepuestoAlmacen extends RepuestoGeneral {
	
	private Integer cantidad;
	private Integer nivelMin;
	
	// ¿No te haces ningun contructor al que le puedas añadir el nombre?
	public RepuestoAlmacen (String referencia, Double precio, Integer cantidad, Integer nivelMin) {
		super("SIN DEFINIR", referencia, precio);
		setCantidad(cantidad);
		setNivelMin(nivelMin);		
	}
	
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	private void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the nivelMin
	 */
	public Integer getNivelMin() {
		return nivelMin;
	}
	/**
	 * @param nivelMin the nivelMin to set
	 */
	private void setNivelMin(Integer nivelMin) {
		this.nivelMin = nivelMin;
	}
	
	// Utiliza el setter ya que lo tienes, sustituye el cuerpo por: setCantidad(getCantidad() + cantidad);
	public void agregarCantidad (int cantidad) {
		this.cantidad = getCantidad() + cantidad;
	}
	// Practica reutilizando metodos, sustituye el cuerpo por: agregarCantidad(-cantidad);
	public void eliminarCantidad(int cantidadEliminada) {
		
		this.cantidad = getCantidad() - cantidadEliminada;
		
	}

	@Override
	public String toString() {
		// El "\n" final me sobra. No formatees en el toString()
		return "Repuesto: ["+ super.toString() + ", cantidad = "+ getCantidad()+ ", nivel minimo = "+getNivelMin()+ "]\n";
	}

}
