package es.mdef.taller;

import java.time.LocalDate;
import java.util.ArrayList;
import es.mdef.interfaces.Garantizable;
import es.mdef.interfaces.Presupuestable;
import es.mdef.vehiculos.Vehiculo;

public class Reparacion implements Presupuestable, Garantizable {
	
	private LocalDate fechaEntrega;
	private ArrayList<Averia> averiasReparadas;

	/**
	 * @return the fechaEntrega
	 */
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @return the averiasReparadas
	 */
	public ArrayList<Averia> getAveriasReparadas() {
		return averiasReparadas;
	}
	public Vehiculo getVehiculoReparado() {
		return averiasReparadas.get(0).getVehiculo();
	}
	@Override
	public Double calcularPresupuesto() {
		Double presupuestoTotal = 0.0;
		if (estaEnGarantia() && ! getFechaEntrega().equals(LocalDate.now())) {
			presupuestoTotal = 0.0;
		} else {
			for (Averia averia : averiasReparadas) {
				presupuestoTotal += averia.calcularPresupuesto();
			}
		}
		
		return presupuestoTotal;
	}
	@Override
	public Double calcularHoras() {
		Double horasTotal = 0.0;
		if (estaEnGarantia() && ! getFechaEntrega().equals(LocalDate.now())) {
			horasTotal = 0.0;
		} else {
			for (Averia averia : averiasReparadas) {
				horasTotal += averia.calcularHoras();
			}
		}
		
		return horasTotal;
	}
	@Override
	// Abusas de las clases wrapper cuando no hacen falta: usa boolean
	public Boolean estaEnGarantia() {
		Boolean garantia = false;
		LocalDate fechaActual = LocalDate.now();
		if (fechaEntrega.until(fechaActual).toTotalMonths() <= PERIODO_GARANTIA) {
			garantia = true;
		}
		return garantia;
	}
	// Vigila los espacios verticales
	public void agregarAveriaReparada (Averia averiaReparada) {
		if (averiaReparada.getReparacion()) {
			averiasReparadas.add(averiaReparada);
		} else {
			averiaReparada.setReparacion(true);
			averiasReparadas.add(averiaReparada);
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n**REPARACION: Fecha de Entrega=" + getFechaEntrega() + "\n--AVERIAS REPARADAS = " + getAveriasReparadas().toString()
				+ "\n--PRESUPUESTO REPARACION = " + (calcularPresupuesto()+calcularHoras()) + " euros.";
	}
	
	public Reparacion (LocalDate fechaReparacion) {
		fechaEntrega = fechaReparacion;
		averiasReparadas = new ArrayList<Averia>();
	}
}
