package es.mdef.taller;

import java.util.Collection;
import java.util.Date;

import es.mdef.interfaces.Presupuestable;
import es.mdef.vehiculos.Vehiculo;

public class Averia implements Presupuestable {
	
	private Identificador id;
	private String descripcion;
	private Date fechaIngreso;
	private Collection<Repuesto> repuestos;
	private int horas;
	private Vehiculo vehiculo;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id.getIdentificador();
	}
	/**
	 * @return the nombre
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setDescripcion(String nombre) {
		this.descripcion = nombre;
	}
	/**
	 * @return the fechaIngreso
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	private void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	/**
	 * @return the repuestos
	 */
	public Collection<Repuesto> getRepuestos() {
		return repuestos;
	}
	/**
	 * @param repuestos the repuestos to set
	 */
	private void setRepuestos(Collection<Repuesto> repuestos) {
		this.repuestos = repuestos;
	}
	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}
	/**
	 * @param horas the horas to set
	 */
	private void setHoras(int horas) {
		this.horas = horas;
	}
	/**
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	/**
	 * @param vehiculo the vehiculo to set
	 */
	private void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Averia [getId()=" + getId() + ", getNombre()=" + getDescripcion() + ", getFechaIngreso()="
				+ getFechaIngreso() + ", getRepuestos()=" + getRepuestos() + ", getHoras()=" + getHoras()
				+ ", getVehiculo()=" + getVehiculo().toString() + "]";
	}
	public void agregarRepuestos (Averia averia, Collection<Repuesto> repuestos) {
		averia.repuestos.addAll(repuestos);
	}
	public void eliminarRepuestos (Averia averia, Collection<Repuesto> repuestos) {
		averia.repuestos.removeAll(repuestos);
	}
	@Override
	public Double calcularPresupuesto(Collection<Repuesto> repuestos) {
		Double presupuesto = 0.0;
		for (Repuesto repuesto : repuestos) {
			if (repuesto.getCantidad() != null && repuesto.getPrecio() != null) {
				presupuesto += repuesto.getPrecio() * repuesto.getCantidad();
			} else {
				presupuesto += 0.0;
				System.out.println("Hay algun campo del calculo igual a null");
			}
		}
		
		return presupuesto;
	}

	public Averia(String descripcionAveria, Date fechaIngreso, Collection<Repuesto> repuestos, int horas,
			Vehiculo vehiculo) {
		super();
		this.id = new Identificador();
		setDescripcion(descripcionAveria);
		setFechaIngreso(fechaIngreso);
		setRepuestos(repuestos);
		setHoras(horas);
		setVehiculo(vehiculo);
	}
	
}
