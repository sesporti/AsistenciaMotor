package es.mdef.taller;

import java.util.ArrayList;

import es.mdef.vehiculos.Vehiculo;

public class Cliente extends Persona {
	
	private Turno turno;
	private ArrayList<Vehiculo> vehiculos;

	public Turno getTurno() {
		return turno;
	}
	/**
	 * @return the vehiculos
	 */
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	public void pedirTurno() {
		turno = Turno.cogerTurno();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + ", tiene el turno = " + getTurno() + ", es propietario de vehiculos: "+ getVehiculos().toString();
	}

	public Cliente(String nombre, String apellidos) {
		super(nombre, apellidos);
		this.turno = Turno.cogerTurno();
	}
	

	
	
	

}
