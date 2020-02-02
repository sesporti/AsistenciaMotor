package es.mdef.taller;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import es.mdef.interfaces.Averiable;
import es.mdef.interfaces.Facturable;
import es.mdef.interfaces.Garantizable;
import es.mdef.interfaces.PiezaRepuesto;
import es.mdef.interfaces.Presupuestable;
import es.mdef.interfaces.Reparable;
import es.mdef.vehiculos.Vehiculo;

public class Reparacion implements Facturable, Reparable, Averiable, Comparable<Reparacion>{
	
	
	
	private boolean ivaNormal;
	private Identificador idAveria;
	
	


	/**
	 * @return the ivaNormal
	 */
	public boolean isIvaNormal() {
		return ivaNormal;
	}

	/**
	 * @param ivaNormal the ivaNormal to set
	 */
	private void setIvaNormal(boolean ivaNormal) {
		this.ivaNormal = ivaNormal;
	}

	@Override
	public boolean estaEnGarantia() {
		
		boolean enGarantia = false;
		LocalDate fechaActual = LocalDate.now();
		
		if ( getFechaAveria().plusMonths(Garantizable.PERIODO_GARANTIA).isBefore(fechaActual) ||
				getFechaAveria().plusMonths(Garantizable.PERIODO_GARANTIA).isEqual(fechaActual)) {
			enGarantia = true;
		}
		return enGarantia;
		
	}

	@Override
	public double calcularPresuRepuestos() {

		double presupuesto = 0;
		
		if (!estaEnGarantia()) {
			
			Map<Repuesto, Integer> hMap = new TreeMap<>(getRepuestoCantidad());
			
			Iterator<Entry<Repuesto, Integer>> iterator = hMap.entrySet().iterator();
			
			while (iterator.hasNext()) {
				
				Map.Entry<Repuesto, Integer> entry = (Map.Entry<Repuesto, Integer>) iterator.next();
				presupuesto += entry.getKey().getPrecio() * entry.getValue();
				
			}
		}
		
		return presupuesto;
	}

	@Override
	public double calcularPresuHoras() {
		
		double presupuesto = 0;
		
		if (! estaEnGarantia()) {
			presupuesto = getHorasReparacion()*Presupuestable.PRECIO_HORA;
		}
		
		return presupuesto;
	}

	@Override
	public double presupuestarReparable() {
		
		double presupuesto = calcularPresuHoras() + calcularPresuRepuestos();
		
		if (isIvaNormal()) {
			presupuesto = presupuesto * (1 + Facturable.IVA_NORMAL);
		} else {
			presupuesto = presupuesto * (1 + Facturable.IVA_REDUCIDO);
		}
		return presupuesto;
	}

	@Override
	public Identificador getIdAveria() {
		
		return idAveria;
	}

	@Override
	public String getNombreAveria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDate getFechaAveria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Repuesto, Integer> getRepuestoCantidad() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public String presupuestarAveriable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDate fechaEntrega() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Averiable> getAverias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHorasReparacion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean repararAveriable() {
		// TODO Auto-generated method stub
		return false;
	}

		@Override
	public int compareTo(Reparacion o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
	
	
	
//	private LocalDate fechaEntrega;
//	private ArrayList<Averia> averiasReparadas;
//
//	/**
//	 * @return the fechaEntrega
//	 */
//	public LocalDate getFechaEntrega() {
//		return fechaEntrega;
//	}
//	/**
//	 * @return the averiasReparadas
//	 */
//	public ArrayList<Averia> getAveriasReparadas() {
//		return averiasReparadas;
//	}
//	public Vehiculo getVehiculoReparado() {
//		return averiasReparadas.get(0).getVehiculo();
//	}
//	// Vigila los espacios verticales
//	public void agregarAveriaReparada (Averia averiaReparada) {
//		if (averiaReparada.getReparacion()) {
//			averiasReparadas.add(averiaReparada);
//		} else {
//			averiaReparada.setReparacion(true);
//			averiasReparadas.add(averiaReparada);
//		}
//	}
//	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		return "\n**REPARACION: Fecha de Entrega=" + getFechaEntrega() + "\n--AVERIAS REPARADAS = " + getAveriasReparadas().toString()
//				+ "\n--PRESUPUESTO REPARACION = " + (calcularPresupuesto()+calcularPresHorNormal()) + " euros.";
//	}
//	
//	public Reparacion (LocalDate fechaReparacion) {
//		fechaEntrega = fechaReparacion;
//		averiasReparadas = new ArrayList<Averia>();
//	}
}
