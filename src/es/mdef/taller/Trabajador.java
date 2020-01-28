package es.mdef.taller;

// ¿Usas esta clase para algo?
public class Trabajador extends Persona {
	
	private Double salario;
	private String especialidad;
	/**
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}
	/**
	 * @param salario the salario to set
	 */
	// ¿Usas este setter para algo?
	protected void setSalario(Double salario) {
		this.salario = salario;
	}
	/**
	 * @return the especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}
	/**
	 * @param especialidad the especialidad to set
	 */
	private void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + ", especialidad: " + getEspecialidad() + ", cobra un salario de " + getSalario() + " euros";
	}
	public Trabajador(String nombre, String apellidos, String especialidad) {
		super(nombre, apellidos);
		setEspecialidad(especialidad);
	}
	
	

}
