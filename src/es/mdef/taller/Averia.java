package es.mdef.taller;

import java.util.Collection;
import java.util.Date;

import es.mdef.interfaces.Presupuestable;
import es.mdef.vehiculos.Vehiculo;

public class Averia implements Presupuestable {
	
	private Identificador id;
	private String descripcion;
	private Date fechaIngreso;
	private Collection<Repuesto> repuestosAveria;
	private Integer horas;
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
		return repuestosAveria;
	}
	/**
	 * @param repuestos the repuestos to set
	 */
	private void setRepuestos(Collection<Repuesto> repuestos) {
		this.repuestosAveria = repuestos;
	}
	/**
	 * @return the horas
	 */
	public Integer getHoras() {
		return horas;
	}
	/**
	 * @param horas the horas to set
	 */
	private void setHoras(Integer horas) {
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
				+ getFechaIngreso() + ", getRepuestos()=" + getRepuestos().toString() + ", getHoras()=" + getHoras()
				+ ", getVehiculo()=" + getVehiculo().toString() + "]";
	}
	public void agregarRepuestos (Averia averia, Collection<Repuesto> repuestos) {
		averia.repuestosAveria.addAll(repuestos);
	}
	public void eliminarRepuestos (Averia averia, Collection<Repuesto> repuestos) {
		averia.repuestosAveria.removeAll(repuestos);
	}
	@Override
	public Double calcularPresupuesto () {
		Double presupuesto = 0.0;
		for (Repuesto repuesto : repuestosAveria) {
			if (repuesto.getCantidad() != null && repuesto.getPrecio() != null) {
				System.out.println("\nPresupuesto Repuesto:" + repuesto.getReferencia() + " X " + repuesto.getCantidad() + " = " + (repuesto.getPrecio() * repuesto.getCantidad()) + " euros.");
				presupuesto += repuesto.getPrecio()*repuesto.getCantidad();
			} else {
				presupuesto += 0.0;
				System.out.println("Hay algun campo (precio o cantidad) del repuesto " + repuesto.getReferencia() + "igual a null");
			}
		}
		System.out.println("Total Repuestos = " + presupuesto + ", + Total Mano de Obra = " + horas + " X " + PRECIO_HORA + " = " + calcularHoras() + " euros.\n"
				+ "TOTAL PRESUPUESTO AVERIA = " + (presupuesto + calcularHoras()) + " euros.");
		
		return presupuesto;
	}
	@Override
	public Double calcularHoras() {
		return this.horas * PRECIO_HORA;
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
