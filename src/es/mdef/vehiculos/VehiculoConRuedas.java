package es.mdef.vehiculos;

public abstract class VehiculoConRuedas extends Vehiculo {

	public abstract int getNumeroDeRuedas();
	
	public VehiculoConRuedas() {
		super();
	}

	public VehiculoConRuedas(String modelo, String color) {
		super(modelo, color);
	}

	@Override
	public String toString() {
		return super.toString() + ", con " + getNumeroDeRuedas() + " ruedas ";
	}

	
	
}
