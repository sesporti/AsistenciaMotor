package es.mdef.vehiculos;

import es.mdef.interfaces.Arrancable;
import es.mdef.interfaces.Matriculable;

public class Coche extends VehiculoConRuedas implements Arrancable, Matriculable {
	
	int numeroDeRuedas;
	String matricula;

	void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public int getNumeroDeRuedas() {
		return numeroDeRuedas;
	}

	@Override
	public String toString() {
		return "Placa " + mostrarMatricula() + " - " + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}

	@Override
	public boolean arrancar() {
		System.out.println("Arranco con la llave.");
		return true;
	}

	@Override
	public String getMatricula() {
		
		return matricula;
	}
//	public Coche() {
//	numeroDeRuedas = 4;
//}

	public Coche(String color) {
	//	this();
	//	setColor(color); // como ya tengo el setter lo utilizo
		this(color, null);
	}

	public Coche(String color, String modelo) {
	//	this(color);
	//	this.modelo = modelo;
		super(color, modelo);
		numeroDeRuedas = 4;
	}

}
