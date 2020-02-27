package es.mdef.personal;

// ¿Usas esta clase para algo? Solo si se quiere utilizar en clase Taller, para llevar un control de empleados.
public class Trabajador extends Persona {
	
	private double salario;
	private String especialidad;
	
	public Trabajador(String nombre, String apellidos, String especialidad, double salario) {
		super(nombre, apellidos);
		setEspecialidad(especialidad);
		setSalario(salario);
	}
	
	/**
	 * @return the salario
	 */
	public double getSalario() {
		return salario;
	}
	/**
	 * @param salario the salario to set
	 */
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

	
	

}
