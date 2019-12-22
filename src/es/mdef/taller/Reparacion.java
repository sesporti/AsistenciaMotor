package es.mdef.taller;

import java.time.LocalDate;
import java.util.ArrayList;
import es.mdef.interfaces.Garantizable;
import es.mdef.interfaces.Presupuestable;

public class Reparacion implements Presupuestable, Garantizable {
	
	private LocalDate fechaEntrega;
	private ArrayList<Averia> averiasReparadas;
		
	
	
	@Override
	public Double calcularPresupuesto() {
		Double presupuestoTotal = 0.0;
		for (Averia averia : averiasReparadas) {
			presupuestoTotal += averia.calcularPresupuesto();
		}
		System.out.println("El TOTAL DE REPARACION ES: " + presupuestoTotal + " EUROS.");
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


}
