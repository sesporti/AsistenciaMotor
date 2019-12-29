package es.mdef.taller;

import java.time.LocalDate;
import java.util.Collection;

import es.mdef.interfaces.Presupuestable;
import es.mdef.vehiculos.Vehiculo;

public class Averia implements Presupuestable, Comparable<Averia>{
	
	private Identificador id;
	private String descripcion;
	private LocalDate fechaIngreso;
	private Collection<RepuestoAveria> repuestosAveria;
	private Integer horas;
	private Vehiculo vehiculo;
	private Boolean reparado;
	private Turno turno;

	
	public Averia(String descripcionAveria, LocalDate localDate, Collection<RepuestoAveria> repuestos, int horas,
			Vehiculo vehiculo) {
		super();
		this.id = new Identificador();
		setDescripcion(descripcionAveria);
		setFechaIngreso(localDate);
		setRepuestos(repuestos);
		setHoras(horas);
		setVehiculo(vehiculo);
		setReparacion(false);		
	}
	
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
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	/**
	 * @param localDate the fechaIngreso to set
	 */
	private void setFechaIngreso(LocalDate localDate) {
		this.fechaIngreso = localDate;
	}
	/**
	 * @return the repuestos
	 */
	public Collection<RepuestoAveria> getRepuestos() {
		return repuestosAveria;
	}
	/**
	 * @param repuestos the repuestos to set
	 */
	private void setRepuestos(Collection<RepuestoAveria> repuestos) {
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
	/**
	 * @return the reparacion
	 */
	public Boolean getReparacion() {
		return reparado;
	}
	/**
	 * @param reparacion the reparacion to set
	 */
	void setReparacion(Boolean reparacion) {
		this.reparado = reparacion;
	}
	/**
	 * @return the turno
	 */
	public Turno getTurno() {
		return turno;
	}
	/**
	 * @param turno the turno to set
	 */
	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "--> Averia (Turno = " + getTurno() + "): "+ "[Id=" + getId() + ", Descripcion: " + getDescripcion() + ", FechaIngreso="
				+ getFechaIngreso() + ", Repuestos = " + getRepuestos().toString() + ", Horas-Trabajo =" + getHoras()
				+ ", Vehículo = " + getVehiculo().toString() + "]\n";
	}
	public void agregarRepuesto (RepuestoAveria repuesto) {
		repuestosAveria.add(repuesto);
		
	}
	public void eliminarRepuesto (RepuestoAveria repuesto) {
		for (RepuestoAveria repuesto2 : repuestosAveria) {
			if (repuesto2.equals(repuesto)) {
				repuestosAveria.remove(repuesto);
			}
		}
	}
	@Override
	public Double calcularPresupuesto () {
		Double presupuesto = 0.0;
		for (RepuestoAveria repuesto : repuestosAveria) {
			if (repuesto.getCantidad() != null && repuesto.getPrecio() != null) {
//				System.out.println("\nPresupuesto Repuesto:" + repuesto.getReferencia() + " X " + repuesto.getCantidad() + " = " + (repuesto.getPrecio() * repuesto.getCantidad()) + " euros.");
				presupuesto += repuesto.getPrecio()*repuesto.getCantidad();
			} else {
				presupuesto += 0.0;
				System.out.println("Hay algun campo (precio o cantidad) del repuesto " + repuesto.getReferencia() + "igual a null");
			}
//			System.out.println("Total Repuestos = " + presupuesto + ", + Total Mano de Obra = " + horas + " X " + PRECIO_HORA + " = " + calcularHoras() + " euros.\n"
//					+ "TOTAL PRESUPUESTO AVERIA = " + getDescripcion()+" ("+getId() + "), " + (presupuesto + calcularHoras()) + " euros.");
		}
				
		return presupuesto;
	}
	@Override
	public Double calcularHoras() {
		return this.horas * PRECIO_HORA;
	}
	public void repararAveria() {
		setReparacion(true);
		Reparacion nuevaReparacion = new Reparacion(LocalDate.now());
		nuevaReparacion.agregarAveriaReparada(this);
		
	}

	@Override
	public int compareTo(Averia o) {
		int comparacion = getFechaIngreso().compareTo(o.getFechaIngreso());
		if (comparacion == 0) {
			comparacion = getHoras().compareTo(o.getHoras());
		}
		return comparacion;
	}
	
	
}
