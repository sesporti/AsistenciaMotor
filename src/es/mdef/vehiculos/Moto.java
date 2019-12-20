package es.mdef.vehiculos;

import es.mdef.interfaces.Arrancable;
import es.mdef.interfaces.Matriculable;

public class Moto extends VehiculoConRuedas implements Arrancable, Matriculable {

	Object[] ruedas = new Object[2];
	String matricula;
	
	@Override
	public int getNumeroDeRuedas() {
		return ruedas.length;
	}
	
	public Moto(String color, String modelo) {
		super(color, modelo);
	}

	@Override
	public String toString() {
		return "Moto: " + super.toString() + mostrarMatricula();
	}

	@Override
	public String getMatricula() {
		
		return matricula;
	}

}
