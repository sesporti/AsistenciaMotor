package es.mdef.vehiculos;

import es.mdef.interfaces.Arrancable;
import es.mdef.interfaces.Matriculable;

public class Moto extends VehiculoConRuedas implements Arrancable, Matriculable {

	Object[] ruedas = new Object[2];
	String matricula;
	
	public Moto(String color, String modelo) {
		super(color, modelo);
	}

	@Override
	public int getNumeroDeRuedas() {
		return ruedas.length;
	}
	
	@Override
	public String toString() {
		return "MOTO: " + super.toString() +" - "+ mostrarMatricula();
	}

	@Override
	public String getMatricula() {
		
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moto other = (Moto) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public int compareTo(Matriculable o1) {//, Matriculable o2) {
		
		return getMatricula().compareTo(o1.getMatricula());
	}

}
