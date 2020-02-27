package es.mdef.vehiculos;

public class Coche extends VehiculoConRuedas implements Arrancable, Matriculable {
	
	int numeroDeRuedas;
	String matricula;
	
	public Coche(String color) {
	//	this();
	//	setColor(color); // como ya tengo el setter lo utilizo
		this(color, null, null);
	}

	public Coche(String color, String modelo, String matricula) {
	//	this(color);
	//	this.modelo = modelo;
		super(color, modelo);
		numeroDeRuedas = 4;
		setMatricula(matricula);	}
	
	@Override
	public String getMatricula() {
		
		return matricula;
	}
	
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public int getNumeroDeRuedas() {
		return numeroDeRuedas;
	}

	@Override
	public String toString() {
		return "COCHE: " + super.toString()+ " - "+ mostrarMatricula();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		return true;
	}

	@Override
	public boolean arrancar() {
		System.out.println("Arranco con la llave.");
		return true;
	}

	@Override
	public int compareTo(Matriculable o1) {//, Matriculable o2) {
		
		return getMatricula().compareTo(o1.getMatricula());
	}

}
