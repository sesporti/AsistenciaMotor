package es.mdef.averia;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import es.mdef.repuestos.PiezaRepuesto;
import es.mdef.repuestos.Repuesto;
import es.mdef.vehiculos.Vehiculo;


public class Averia<T, K> implements Averiable<Repuesto<K>> {

	private Identificador identificador;
	private String nombreAveria;
	private LocalDate fechaAveria;
	private Map<Repuesto<K>, Integer> repuestosAveria;
	private Vehiculo vehiculo;
	private double horasEstimadas;
	
	
	public Averia (String nombreAveria, LocalDate fechaAveria, Vehiculo vehiculo, double horas){
		identificador = new Identificador();
		this.nombreAveria = nombreAveria;
		this.fechaAveria = fechaAveria;
		repuestosAveria = new TreeMap<Repuesto<K>, Integer>();
		this.vehiculo = vehiculo;
		horasEstimadas = horas;
	}
	
	public Averia (LocalDate fechaAveria, Vehiculo vehiculo, double horas){
		this("Sin definir", fechaAveria, vehiculo, horas);
	}
	

	@Override
	public Identificador getIdAveria() {
		
		return identificador;
	}

	@Override
	public String getNombreAveria() {
		
		return nombreAveria;
	}

	@Override
	public LocalDate getFechaAveria() {
		
		return fechaAveria;
	}

	@Override
	public Map<Repuesto<K>, Integer> getRepuestosAveria() {
		
		return repuestosAveria;
	}
	
	/**
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * @return the horasEstimadas
	 */
	public double getHorasEstimadas() {
		return horasEstimadas;
	}

	@Override
	public boolean agregarRepuestoAveria(Repuesto<K> repuesto, int cantidad) {
		boolean agregado = false;
		if (getRepuestosAveria().containsKey(repuesto)) {
			getRepuestosAveria().put(repuesto, getRepuestosAveria().get(repuesto) + cantidad);
			agregado = true;
		} else {
			getRepuestosAveria().putIfAbsent(repuesto, cantidad);
			agregado = true;
		}
		
		return agregado;
	}

	@Override
	public boolean eliminarRepuestoAveria(Repuesto<K> repuesto, int cantidad) {
		boolean eliminado = false;
		if (getRepuestosAveria().containsKey(repuesto)) {
			getRepuestosAveria().put(repuesto, getRepuestosAveria().get(repuesto) - cantidad);
			eliminado = true;
		} else {
			
			System.out.println("Error: El repuesto no esta añadido a la avería.");
		}
		
		return eliminado;
	}
	
	/**
	 * @param repuesto
	 * @return true, si se realiza la eliminacion del total del repuesto.
	 */
	public boolean eliminarTotalRepuestoAveria(PiezaRepuesto<T> repuesto) {
				
		return getRepuestosAveria().remove(repuesto, getRepuestosAveria().get(repuesto));
	}
	
	/* (non-Javadoc)
	 * @see es.mdef.taller.Averiable#informeRepuestos()
	 */
	@Override
	public String informeRepuestos() {
		
		String informe ="";
		
		Map<Repuesto<K>, Integer> hMap = new TreeMap<>(getRepuestosAveria());
		Iterator<Entry<Repuesto<K>, Integer>> iterator = hMap.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry<Repuesto<K>, Integer> entry = (Entry<Repuesto<K>, Integer>) iterator.next();
			informe += entry.getKey().toString() + ", cantidad = " + entry.getValue() + "\n";	
		}
		
		return informe;
		
	}
	
	@Override
	public double calcularPresuRepuestos() {
		double presuRepuestos = 0;
		
		Map<Repuesto<K>, Integer> hMap = new TreeMap<>(getRepuestosAveria());
		Iterator<Entry<Repuesto<K>, Integer>> iterator = hMap.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry<Repuesto<K>, Integer> entry = (Entry<Repuesto<K>, Integer>) iterator.next();
			presuRepuestos += entry.getKey().getPrecio() * entry.getValue();	
		}
		
		return presuRepuestos;
	}

	@Override
	public double calcularPresuHoras() {
			
		return PRECIO_HORA * getHorasEstimadas();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Averia (" + getIdAveria() + "), Descripcion averia: " + getNombreAveria()
				+ ", FechaAveria(" + getFechaAveria() + "), Vehiculo: " + getVehiculo().toString()
				+ ", HorasEstimadas = " + getHorasEstimadas() + "\nInforme Repuestos:" + informeRepuestos();
	}
	
	public String facturaAveria (String tipoIva) {
		return toString() + "\nTotal de Repuestos = " + calcularPresuRepuestos() + " €.\nTotal de Mano Obra = "
				+ calcularPresuHoras() + " €.\nTOTAL PRESUPUESTO = " + calcularPresuTotal(tipoIva) + " €."; 
	}
	
		
}
