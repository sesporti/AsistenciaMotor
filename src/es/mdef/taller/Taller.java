package es.mdef.taller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

import es.mdef.vehiculos.Vehiculo;

public class Taller {

	private final String NOMBRE = "Talleres QUEVEDO SA.";
	private final String CIF = "123456789-A";
//	private Collection<Trabajador> personal;//utilizar si se quiere llevar un control de trabajadores.
	private Almacen almacen;
	private Collection<Cliente> clientes;
	private Collection<Averia> averias;
	private Collection<Reparacion> reparaciones;
	private Scanner entradaDatos;

	/**
	 * @return the nOMBRE
	 */
	public String getNOMBRE() {
		return NOMBRE;
	}
	/**
	 * @return the cIF
	 */
	public String getCIF() {
		return CIF;
	}
	/**
	 * @return the personal
	 */
/*	public Collection<Trabajador> getPersonal() {
		return personal;
	}
*/
	/**
	 * @return the almacen
	 */
	public Almacen getAlmacen() {
		return almacen;
	}
	/**
	 * @return the clientes
	 */
	public Collection<Cliente> getClientes() {
		return clientes;
	}
	/**
	 * @return the averias
	 */
	public Collection<Averia> getAverias() {
		return averias;
	}
	/**
	 * @return the repaciones
	 */
	public Collection<Reparacion> getRepaciones() {
		return reparaciones;
	}
	
	/**
	 * @param vehiculo
	 * @return Devuelve las acciones necesarias para ingresar un vehiculo en el taller. Permite dar de alta un vehiculo si no existe, e incluso un cliente si este no existe.
	 * Durante el ingreso se realizará el diagnostico inicial del vehículo y se da un presupuesto inicial de reparacion de todas las averias.
	 */
	public void ingresarVehiculo (Vehiculo vehiculo) {
		entradaDatos = new Scanner(System.in);
		boolean encontrado = false;
		for (Cliente cliente : clientes) {
			if (cliente.getVehiculos().contains(vehiculo)) {
				diagnosticarVehiculo(vehiculo);
				System.out.println(presupuestoInicial(vehiculo));
				encontrado = true;
			}	
		}
		if (!encontrado) {
			 System.out.println("El vehiculo no encontrado, asociar vehiculo a cliente o crear nuevo cliente con vehiculo.");
			 System.out.println("Introduzca nombre y apellidos del cliente (en orden y pulsando intro)");
			 String nombre = entradaDatos.next();
			 String apellidos = entradaDatos.next();
			 boolean clienteEncontrado = false;
			 for (Cliente cliente : getClientes()) {
				if (cliente.getNombre().equalsIgnoreCase(nombre) && cliente.getApellidos().equalsIgnoreCase(apellidos)) {
					cliente.agregarVehiculo(vehiculo);
					clienteEncontrado = true;
					ingresarVehiculo(vehiculo);
				}
			}
			if (!clienteEncontrado) {
				System.out.println("Cliente no encontrado, Cliente dado de alta");
				Cliente nuevoCliente = new Cliente(nombre, apellidos, vehiculo);
				getClientes().add(nuevoCliente);
				ingresarVehiculo(vehiculo);
			}
		}
	}
	/**
	 * @param vehiculo
	 * @return Devuelve en consola acciones para dar de alta averias, asociar repuestos a averias y dar turno a todas las averias
	 */
	private void diagnosticarVehiculo (Vehiculo vehiculo) {
		
		System.out.println("Diagnosticando " + vehiculo.toString());
		
		ArrayList<Averia> averias1 = new ArrayList<>();//creo ArrayList para incluir todas las averias asociadas al vehiculo
		
		String masAverias = "Y";
		System.out.println("Desea añadir una averia? Y o N");
		masAverias = entradaDatos.next();
		
		while (masAverias.equalsIgnoreCase("Y")) {
			ArrayList<RepuestoAveria> repuestosAveria = new ArrayList<>();//creo arraylist de repuestos para incluir todos los repuestos asociados a la averia.
			
			HashSet<RepuestoAlmacen> repuestosAlmacen = new HashSet<>(almacen.getArticulos());//creo un conjunto (sin repeticiones) segun orden de inserción para repuestos de almacen
			
			String masRepuestos = "Y";
			
			while (masRepuestos.equalsIgnoreCase("Y")) {
				
//				JOptionPane.showMessageDialog(null, repuestosAlmacen.toString(), "Inventario Almacen", JOptionPane.INFORMATION_MESSAGE);//NO FUNCIONA, SI EN EL MAIN.
				
				System.out.println(repuestosAlmacen.toString());
				System.out.println("Elija un repuesto de la lista anterior: introduciendo referencia y cantidad necesaria (por este orden, pulsando intro con cada dato introducido)");
				
				String referencia = entradaDatos.next();
				RepuestoAlmacen repuestoAlmacen1 = null;
				for (RepuestoAlmacen repuestoAlmacen : repuestosAlmacen) {
					if (repuestoAlmacen.getReferencia().equalsIgnoreCase(referencia)) {
						repuestoAlmacen1 = repuestoAlmacen;
					}
				}
				Double precio = repuestoAlmacen1.getPrecio();
				//creo un repuesto de averia (con datos introducidos por usuario) para asignarlo a la averia.				
				RepuestoAveria repuestoNecesario = new RepuestoAveria(referencia, precio, entradaDatos.nextInt());
				
				if (almacen.hayRepuesto(repuestoNecesario)) {
					
					repuestosAveria.add(repuestoNecesario);
					
					RepuestoAlmacen repuestoAlmacen = getAlmacen().getArticuloAlmacen(repuestoNecesario);//convierto el Repuesto de averia en un repuesto de almacen para poder eliminar la cantidad asignada a la averia del almacen.
					
					getAlmacen().eliminarStock(repuestoAlmacen, repuestoNecesario.getCantidad());
				
				} else {
					
					System.out.println("SIN REPUESTO: El repuesto no existe o no hay suficiente cantidad.");
					System.out.println("SIN STOCK, solicitar a proveedor la cantidad de:\n " + getAlmacen().solicitarRepuesto(repuestoNecesario));
					
					repuestoNecesario.setCantidadAsignada(- repuestoNecesario.getCantidad());
				}
			
				System.out.println("Desea añadir otro repuesto? Y o N");
				masRepuestos = entradaDatos.next();
				
			}
			
			System.out.println("Introduzca horas de trabajo asociadas a la averia");
			int horas = entradaDatos.nextInt();
			
			Averia averia = new Averia("Diagnostico inicial", LocalDate.now(), repuestosAveria, horas, vehiculo);//creo una averia, podría quitar la fecha como LocalDate para evitar que todas las fechas sean las del dia actual

			averias.add(averia);//averias del vehiculo
			averias1.add(averia);//averias de todo el taller
			System.out.println("Desea añadir otra averia? Y o N");
			masAverias = entradaDatos.next();
		}
		
		darTurno();		
		averias1.sort(new Comparator<Averia>() {

			@Override
			public int compare(Averia o1, Averia o2) {
				
				return o1.compareTo(o2);
			}
		});
		
		
		System.out.println("AVERIAS asociadas al Vehiculo "+ vehiculo.toString() + ":\n" + averias1.toString());
			
	}
	public void repararAveria (Averia averia) {
		if (!averia.getReparacion() && averia.getTurno()!= null) {
			averia.repararAveria();
			Reparacion nuevaReparacion = new Reparacion(LocalDate.now());
			nuevaReparacion.agregarAveriaReparada(averia);
			getRepaciones().add(nuevaReparacion);
		} else {
			System.out.println("No se puede reparar, sin repuestos suficientes.");
		}
	}
	public void darTurno () {
		ArrayList<Averia> averias = new ArrayList<>(getAverias());
		averias.sort(new Comparator<Averia>() {

			@Override
			public int compare(Averia o1, Averia o2) {
				
				return o1.compareTo(o2);
			}
			
		});
		Turno.cogerTurno(averias);
	}
	public String presupuestoInicial (Vehiculo vehiculo) {
		Double presupuestoTotal = 0.0;
		Double calculohorasTotal = 0.0;
		Integer tiempo = 0;
		for (Averia averia : averias) {
			if (averia.getVehiculo().equals(vehiculo) && averia.getReparacion().equals(false)) {
				presupuestoTotal+= averia.calcularPresupuesto();
				calculohorasTotal += averia.calcularPresuHoras();
				tiempo +=averia.getHoras();
			}			
		}
		return "Reparacion Inicial:\nPresupuesto estimado = " + presupuestoTotal + " euros (Mano de obra = " + calculohorasTotal + " euros)" +
				"\nTOTAL PRESUPUESTO INICIAL: "+ (presupuestoTotal + calculohorasTotal) +" euros.\nEl numero de horas estimado es: " + tiempo + " horas.";
	}
	public String mostrarAverias (Vehiculo vehiculo) {
		ArrayList<Averia> averias = new ArrayList<>(getAverias());
		
		averias.sort(new Comparator<Averia>() {

			@Override
			public int compare(Averia o1, Averia o2) {
				
				return o1.compareTo(o2);
			}
			
		});
		
		System.out.println("Averias del vehiculo: " + vehiculo.toString());
		String averiados = "";
		for (Averia averia : averias) {
			if (!averia.getReparacion() && averia.getVehiculo().equals(vehiculo)) {
				averiados += averia.toString()+"\n";
			}
		}
		return averiados;
	}
	public String mostrarReparaciones (Vehiculo vehiculo, LocalDate fechaEntrega) {
		System.out.println("\n---------------Reparaciones del vehiculo " + vehiculo.toString() + "----------------------------\nFecha reparacion: " + fechaEntrega);
		String reparados = "";
	
		for (Reparacion reparacion : reparaciones) {
			if (reparacion.getVehiculoReparado().equals(vehiculo) && reparacion.getFechaEntrega().equals(fechaEntrega)) {
				reparados += reparacion.toString()+"\n";
			}
		}
		return reparados;
	}
	public Boolean estaGarantiaReparacion (Vehiculo vehiculo, Reparacion reparacion) {
		Boolean garantia = false;
		for (Reparacion reparacion2 : reparaciones) {
			if (vehiculo.equals(reparacion2.getVehiculoReparado()) && reparacion2.equals(reparacion) && reparacion.estaEnGarantia()) {
				garantia = true;
			}
		}
		return garantia;
				
	}
 	public String averiasSinRepuesto () {
		ArrayList<Averia> averias = new ArrayList<>(getAverias());
		
		averias.sort(new Comparator<Averia>() {

			@Override
			public int compare(Averia o1, Averia o2) {
				
				return o1.compareTo(o2);
			}
			
		});
		System.out.println("-------------Averias SIN REPUESTO--------------");
		String sinRepuesto = "";
		for (int i = 0; i < averias.size(); i++) {
			for (RepuestoAveria repuestoAveria : averias.get(i).getRepuestos()) {
				if (repuestoAveria.getCantidad() < 0) {
					sinRepuesto += averias.get(i).toString()+"\n";
				}
			}
		}
		
		return sinRepuesto;
	}

	public Taller () {
		this.clientes = new ArrayList<>();
		this.averias = new ArrayList<>();
		this.reparaciones = new ArrayList<>();
		this.almacen = new Almacen();
	}

	
}
