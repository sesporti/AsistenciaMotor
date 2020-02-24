package es.mdef.interfaces;

public interface Arrancable {

	default boolean arrancar() {
		System.err.println("Vehículo arrancado");
		return true;
	}
}
