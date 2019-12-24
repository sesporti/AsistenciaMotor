package es.mdef.taller;

import java.time.LocalDate;
import java.util.ArrayList;
import es.mdef.interfaces.Garantizable;
import es.mdef.interfaces.Presupuestable;

public class Reparacion implements Presupuestable, Garantizable {
	
	private LocalDate fechaEntrega;
	private ArrayList<Averia> averiasReparadas;
		
	public Reparacion (LocalDate fechaReparacion) {
		this.fechaEntrega = fechaReparacion;
		averiasReparadas = new ArrayList<>();
	}
	
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


	@Override
	public Double calcularPresupuesto() {
		Double presupuestoTotal = 0.0;
		for (Averia averia : averiasReparadas) {
			presupuestoTotal += averia.calcularPresupuesto();
		}
//		System.out.println("El TOTAL DE REPARACION ES: " + presupuestoTotal + " EUROS.");
		return presupuestoTotal;
	}
	@Override
	public Double calcularHoras() {
		Double horasTotal = 0.0;
		for (Averia averia : averiasReparadas) {
			horasTotal += horasTotal + averia.calcularHoras();
		}
		return horasTotal;
	}
	@Override
	public Boolean estaEnGarantia() {
		Boolean garantia = false;
		LocalDate fechaActual = LocalDate.now();
		if (fechaEntrega.until(fechaActual).toTotalMonths() <= PERIODO_GARANTIA) {
			garantia = true;
		}
		return garantia;
	}
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
		return "REPARACION [Fecha de Entrega=" + getFechaEntrega() + ", AVERIAS REPARADAS = " + getAveriasReparadas().toString()
				+ ", PRESUPUESTO REPARACION = " + (calcularPresupuesto()+calcularHoras()) + " euros.]";
	}

}
