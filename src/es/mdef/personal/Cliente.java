package es.mdef.personal;

import java.util.ArrayList;

import es.mdef.vehiculos.Vehiculo;

public class Cliente extends Persona {
	
	private ArrayList<Vehiculo> vehiculos;

	/**
	 * @return the vehiculos
	 */
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void agregarVehiculo (Vehiculo vehiculo) {
		if (!getVehiculos().contains(vehiculo)) {
			getVehiculos().add(vehiculo);
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "**\n- Es propietario de VEHICULOS: "+ getVehiculos().toString();
	}

	public Cliente(String nombre, String apellidos, Vehiculo vehiculo) {
		super(nombre, apellidos);
		this.vehiculos = new ArrayList<>();
		vehiculos.add(vehiculo);
		
	}
	

	
	
	

}
