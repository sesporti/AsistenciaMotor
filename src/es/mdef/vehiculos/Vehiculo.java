package es.mdef.vehiculos;

//import java.util.Objects;

//import es.mdef.interfaces.Coloreable;



public class Vehiculo {//implements Coloreable{

	protected String modelo;
	String color;
	

	/** Sirve para cambiar el color de un vehiculo si no tiene el mismo que
	 * se pase por parametro.
	 * @param vehiculo a pintar
	 * @param color para pintar
	 * @return vehiculo si se pinta o null si ya tiene el mismo color
	 */
//	public static Coloreable pintarVehiculo(Vehiculo vehiculo, String color) {
//		Coloreable vehiculoAux = null;
//		if(!Objects.equals(vehiculo.getColor().toUpperCase(), color.toUpperCase())) {
//			vehiculo.setColor(color);
//			vehiculoAux = vehiculo;
//		}
//		return vehiculoAux;
//	}
	
	public String getModelo() {
		return modelo;
	}

	//@Override
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Vehiculo() {
		super();
//		System.out.println("Constructor Vehiculo");
	}
	
	public Vehiculo(String color) {
		this();
		setColor(color); // como ya tengo el setter lo utilizo
	}

	public Vehiculo(String color, String modelo) {
		this(color);
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return modelo + " (" + getColor().toUpperCase() + ")";
	}



}