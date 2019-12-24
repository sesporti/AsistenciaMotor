package es.mdef.taller;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


import es.mdef.vehiculos.Vehiculo;

public class Taller  {

	private final String NOMBRE = "Talleres QUEVEDO SA.";
	private final String CIF = "123456789-A";
//	private Collection<Trabajador> personal;
	private Almacen almacen;
	private Collection<Cliente> clientes;
	private Collection<Averia> averias;
	private Collection<Reparacion> repaciones;
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
		return repaciones;
	}
	
	public void ingresarVehiculo (Vehiculo vehiculo) {
		entradaDatos = new Scanner(System.in);
		for (Cliente cliente : clientes) {
			if (cliente.getVehiculos().contains(vehiculo)) {
				ArrayList<Averia> averias = new ArrayList<>();
				String agregarAveria;
				System.out.println("¿Agregar averia? (Y o N)");
				agregarAveria = entradaDatos.next();
				while (agregarAveria.equalsIgnoreCase("Y")) {
					Averia averia = new Averia("Diagnostico Inicial", LocalDate.now(), new ArrayList<>(), 1, vehiculo);
					String necesitaRepuesto;
					System.out.println("¿Agregar repuesto necesario? (Y o N)");
					necesitaRepuesto = entradaDatos.next();
					while (necesitaRepuesto.equalsIgnoreCase("Y")) {
						System.out.println("Introduca referencia y cantidad.");
						String referencia = entradaDatos.next();
						Integer cantidad = entradaDatos.nextInt();
						Boolean pendienteRepuesto = false;
						for (RepuestoAlmacen repuestoAlmacen : almacen.getStock()) {
							
							if (repuestoAlmacen.getReferencia().equals(referencia) && repuestoAlmacen.hayRepuesto(repuestoAlmacen, cantidad)) {
								averia.agregarRepuesto(new RepuestoAveria(referencia, repuestoAlmacen.getPrecio(), cantidad));
							} else if (repuestoAlmacen.getReferencia().equals(referencia) && ! repuestoAlmacen.hayRepuesto(repuestoAlmacen, cantidad)) {
								System.out.println("Sin Repuesto, solicitar a proveedor "+ repuestoAlmacen.solicitarRepuesto(repuestoAlmacen, cantidad) + " unidades.");
								pendienteRepuesto = true;
							} else {
								System.out.println("El repuesto NO se encuentra en inventario del almacen, solicitar a proveedor y dar de alta");
								pendienteRepuesto = true;
							}
						}
						System.out.println("¿Agregar otro repuesto? (Y o N)");
						necesitaRepuesto = entradaDatos.next();
					}
					averias.add(averia);
					System.out.println("¿Agregar otra averia? (Y o N)");
					agregarAveria = entradaDatos.next();
				}
			} else {
				System.out.println("Introduzca nombre y apellidos del nuevo cliente: ");
				clientes.add(new Cliente(entradaDatos.next(), entradaDatos.next(), vehiculo));
				ingresarVehiculo(vehiculo);
			}
			cliente.pedirTurno();
		}
				
	}
	public String diagnosticarVehiculo (Vehiculo vehiculo) {
		Double presupuestoTotal = 0.0;
		Double calculohorasTotal = 0.0;
		Integer tiempo = 0;
		for (Averia averia : averias) {
			if (averia.getVehiculo().equals(vehiculo) && averia.getReparacion().equals(false)) {
				presupuestoTotal+= averia.calcularPresupuesto();
				calculohorasTotal += averia.calcularHoras();
				tiempo +=averia.getHoras();
			}			
		}
		return "Reparacion Inicial:\nPresupuesto estimado = " + presupuestoTotal + " (Mano de obra = " + calculohorasTotal + ")" +
				"\nTOTAL PRESUPUESTO INICIAL: "+ (presupuestoTotal + calculohorasTotal) +" euros.\nEl numero de horas estimado es: " + tiempo + " horas.";
	}
	public Taller () {
		this.clientes = new ArrayList<>();
		this.averias = new ArrayList<>();
		this.repaciones = new ArrayList<>();
		this.almacen = new Almacen();
	}
	
}
