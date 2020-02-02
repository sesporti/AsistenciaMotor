package es.mdef.taller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import es.mdef.interfaces.Averiable;
import es.mdef.vehiculos.Vehiculo;

// Echo en falta una interfaz Averiable
public class Averia<T> implements Averiable {
	
	private Identificador id;
	private String nombre;
	private LocalDate fecha;
	private Map<Repuesto, Integer> repuestos;
	private T objetoAveriado;
	
	
		
	/**
	 * @return the objetoAveriado
	 */
	public T getObjetoAveriado() {
		return objetoAveriado;
	}

	@Override
	public double calcularPresuRepuestos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcularPresuHoras() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String presupuestarAveriable() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Identificador getIdAveria() {
		
		return id;
	}

	@Override
	public String getNombreAveria() {
		
		return nombre;
	}

	@Override
	public LocalDate getFechaAveria() {
		
		return fecha;
	}

	@Override
	public Map<Repuesto, Integer> getRepuestoCantidad() {
		
		return repuestos;
	}

	@Override
	public boolean agregarRepuestoCantidad() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarRepuestoCantidad() {
		// TODO Auto-generated method stub
		return false;
	}


	
	
	
	
	
	
	
	
	
//	// Te digo lo mismo, hazte las preguntas de que cosas sobran de abajo...
//	// vehiculo? turno? reparado? fechaIngreso?
//	private Identificador id;
//	private String descripcion;
//	private LocalDate fechaIngreso;
//	private Collection<RepuestoAveria> repuestosAveria;
//	private Integer horas;
//	private Vehiculo vehiculo;
//	private Boolean reparado;
//	private Turno turno;
//
//	/**
//	 * @return the id
//	 */
//	public Integer getId() {
//		return id.getIdentificador();
//	}
//	/**
//	 * @return the nombre
//	 */
//	public String getDescripcion() {
//		return descripcion;
//	}
//	/**
//	 * @param nombre the nombre to set
//	 */
//	public void setDescripcion(String nombre) {
//		this.descripcion = nombre;
//	}
//	/**
//	 * @return the fechaIngreso
//	 */
//	public LocalDate getFechaIngreso() {
//		return fechaIngreso;
//	}
//	/**
//	 * @param localDate the fechaIngreso to set
//	 */
//	private void setFechaIngreso(LocalDate localDate) {
//		this.fechaIngreso = localDate;
//	}
//	/**
//	 * @return the repuestos
//	 */
//	public Collection<RepuestoAveria> getRepuestos() {
//		return repuestosAveria;
//	}
//	/**
//	 * @param repuestos the repuestos to set
//	 */
//	private void setRepuestos(Collection<RepuestoAveria> repuestos) {
//		this.repuestosAveria = repuestos;
//	}
//	/**
//	 * @return the horas
//	 */
//	public Integer getHoras() {
//		return horas;
//	}
//	/**
//	 * @param horas the horas to set
//	 */
//	private void setHoras(Integer horas) {
//		this.horas = horas;
//	}
//	/**
//	 * @return the vehiculo
//	 */
//	public Vehiculo getVehiculo() {
//		return vehiculo;
//	}
//	/**
//	 * @param vehiculo the vehiculo to set
//	 */
//	private void setVehiculo(Vehiculo vehiculo) {
//		this.vehiculo = vehiculo;
//	}
//	/**
//	 * @return the reparacion
//	 */
//	public Boolean getReparacion() {
//		return reparado;
//	}
//	/**
//	 * @param reparacion the reparacion to set
//	 */
//	void setReparacion(Boolean reparacion) {
//		this.reparado = reparacion;
//	}
//	/**
//	 * @return the turno
//	 */
//	public Turno getTurno() {
//		return turno;
//	}
//	/**
//	 * @param turno the turno to set
//	 */
//	public void setTurno(Turno turno) {
//		this.turno = turno;
//	}
//
//	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		return "\n--> Averia (Turno = " + getTurno() + ", ¿Reparado? " + getReparacion() + "): "+ "[Id=" + getId() + ", Descripcion: " + getDescripcion() + ", FechaIngreso="
//				+ getFechaIngreso() + "\n\tRepuestos = " + getRepuestos().toString() + "\n\tHoras-Trabajo =" + getHoras()
//				+ "\n\tVehículo = " + getVehiculo().toString() + "]\n";
//	}
//	public void agregarRepuesto (RepuestoAveria repuesto) {
//		repuestosAveria.add(repuesto);
//		
//	}
//	public void eliminarRepuesto (RepuestoAveria repuesto) {
//		for (RepuestoAveria repuesto2 : repuestosAveria) {
//			if (repuesto2.equals(repuesto)) {
//				repuestosAveria.remove(repuesto);
//			}
//		}
//	}
//	@Override
//	public double calcularPresupuesto () {
//		double presupuesto = 0.0;
//		for (RepuestoAveria repuesto : repuestosAveria) {
//			if (repuesto.getCantidad() != null && repuesto.getPrecio() != null) {
////				System.out.println("\nPresupuesto Repuesto:" + repuesto.getReferencia() + " X " + repuesto.getCantidad() + " = " + (repuesto.getPrecio() * repuesto.getCantidad()) + " euros.");
//				presupuesto += repuesto.getPrecio()*repuesto.getCantidad();
//			} else {
//				presupuesto += 0.0;
//				System.out.println("Hay algun campo (precio o cantidad) del repuesto " + repuesto.getReferencia() + "igual a null");
//			}
////			System.out.println("Total Repuestos = " + presupuesto + ", + Total Mano de Obra = " + horas + " X " + PRECIO_HORA + " = " + calcularHoras() + " euros.\n"
////					+ "TOTAL PRESUPUESTO AVERIA = " + getDescripcion()+" ("+getId() + "), " + (presupuesto + calcularHoras()) + " euros.");
//		}
//				
//		return presupuesto;
//	}
//	@Override
//	public double calcularPresuHoras() {
//		return this.horas * PRECIO_HORA;
//	}
//	public void repararAveria() {
//		setReparacion(true);
//		
//				
//	}
//	@Override
//	public int compareTo(Averia o) {
//		int comparacion = getFechaIngreso().compareTo(o.getFechaIngreso());
//		if (comparacion == 0) {
//			comparacion = getHoras().compareTo(o.getHoras());
//		}
//		return comparacion;
//	}
//	
//	// Esto esta mal colocado. Si usas un orden mantentlo, pero no pongas un constructor en una clase al final
//	// y el resto en otro sitio
//	public Averia(String descripcionAveria, LocalDate localDate, Collection<RepuestoAveria> repuestos, int horas,
//			Vehiculo vehiculo) {
//		super();
//		this.id = new Identificador();
//		setDescripcion(descripcionAveria);
//		setFechaIngreso(localDate);
//		setRepuestos(repuestos);
//		setHoras(horas);
//		setVehiculo(vehiculo);
//		setReparacion(false);		
//	}
		
}
