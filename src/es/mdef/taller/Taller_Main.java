package es.mdef.taller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import es.mdef.vehiculos.Coche;
import es.mdef.vehiculos.Moto;


public class Taller_Main {

	public static void main(String[] args) {
		/*
		 * CREO VEHICULOS
		 */
		Coche coche = new Coche("rojo", "Ford Focus");
		Coche coche1 = new Coche("negro", "Seat Ibiza");
		Coche coche2 = new Coche("blanco", "Citroen DS4");
		Coche coche3 = new Coche("blanco", "BMW 320i");
		Moto moto = new Moto("azul", "Yamaha XJ6N");
		Moto moto1 = new Moto("blanco", "Kawasaki Z800");
		Moto moto2 = new Moto("gris", "BMW 1200GS");
		
		coche.setMatricula("7308GCR");
		coche1.setMatricula("1234AAA");
		coche2.setMatricula("5678BBB");
		coche3.setMatricula("1234CCC");
		moto.setMatricula("5678DDD");
		moto1.setMatricula("0000ABC");
		moto2.setMatricula("1111AAA");
		/*
		 * CREO CLIENTES
		 */
		Cliente cliente = new Cliente("Sergio", "Espejel", coche);
		Cliente cliente1 = new Cliente("Laura", "Rodríguez", coche1);
		Cliente cliente2 = new Cliente("Alfonso", "García", moto);
		Cliente cliente3 = new Cliente("Cristina", "Gómez", coche2);
		
		cliente.setDireccion("C/ Limón, 12, 7B, 28024. Madrid");
		cliente.setTelefono("917235065/647790455");
		/*
		 * AÑADO MAS VEHICULOS A LOS CLIENTES
		 */
		cliente.getVehiculos().add(moto2);
		cliente1.getVehiculos().add(moto1);

		/*
		 * CREO EL TALLER
		 */
		Taller quevedo = new Taller();
		/*
		 * CREO UNA COLLECTION DE CLIENTES
		 */
		Collection<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente);
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);

			
		ArrayList<Cliente> misClientes = (ArrayList<Cliente>) clientes;
		
		misClientes.sort(new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				
				return o1.getNombre().compareTo(o2.getNombre());
			}
		});
		
		/*
		 * AÑADO LOS CLIENTES AL TALLER
		 */
		quevedo.getClientes().addAll(misClientes);
		
		System.out.println(quevedo.getClientes().toString());// es lo mismo: System.out.println(misClientes);
		

		/*
		 * CREO REPUESTO PARA EL ALMACEN Y LOS AÑADO AL ALMACEN DEL TALLER
		 */
		
		RepuestoAlmacen repuestoAlmacen = new RepuestoAlmacen("1", 158.25, 10, 5);
		RepuestoAlmacen repuestoAlmacen1 = new RepuestoAlmacen("2", 56.75, 25, 10);
		RepuestoAlmacen repuestoAlmacen2= new RepuestoAlmacen("3", 568.95, 2, 1);
		RepuestoAlmacen repuestoAlmacen3 = new RepuestoAlmacen("4", 20.0, 50, 20);
		RepuestoAlmacen repuestoAlmacen4 = new RepuestoAlmacen("5", 120.30, 15, 5);
		
		repuestoAlmacen.nombre = "Correa distribución";
		repuestoAlmacen1.nombre = "Luna delantera";
		repuestoAlmacen2.nombre = "Motor 2.0 HDI";
		repuestoAlmacen3.nombre = "Brida sujección tubería";
		repuestoAlmacen4.nombre = "Motor elevalunas eléctrico";
		
		quevedo.getAlmacen().darAltaRepuesto(repuestoAlmacen);
		quevedo.getAlmacen().darAltaRepuesto(repuestoAlmacen3);
		quevedo.getAlmacen().darAltaRepuesto(repuestoAlmacen2);
		quevedo.getAlmacen().darAltaRepuesto(repuestoAlmacen1);
		quevedo.getAlmacen().darAltaRepuesto(repuestoAlmacen4);
		
				
		System.out.println(quevedo.getAlmacen().toString());
		
//		System.out.println("NO hay Averias? "+quevedo.getAverias().isEmpty());
//		System.out.println("NO hay Clientes? "+quevedo.getClientes().isEmpty());
//		System.out.println("NO hay Repuestos en Almacen? "+quevedo.getAlmacen().getStock().isEmpty());
//		System.out.println("NO Hay Reparaciones? "+quevedo.getRepaciones().isEmpty());
		
//		quevedo.ingresarVehiculo(coche);
//		quevedo.ingresarVehiculo(moto1);		
//		quevedo.ingresarVehiculo(coche3);
			
		
		/*
		 * CREO REPUESTOS PARA LAS AVERIAS
		 */
		RepuestoAveria repuestoAveria = new RepuestoAveria("3", 568.95, 1);
		RepuestoAveria repuestoAveria2 = new RepuestoAveria("4", 20.0, 2);
		RepuestoAveria repuestoAveria3 = new RepuestoAveria("5", 120.3, 2);
		RepuestoAveria repuestoAveria4 = new RepuestoAveria("6", 15.25, 1);
		
		/*
		 * AÑADO REPUESTOS A LA AVERIA, CREANDO UNA LIST DE REPUESTOS PARA CADA AVERIA.
		 */
		ArrayList<RepuestoAveria> repuestos = new ArrayList<>();
		
		if (quevedo.getAlmacen().hayRepuesto(repuestoAveria) && quevedo.getAlmacen().hayRepuesto(repuestoAveria2) 
			&& quevedo.getAlmacen().hayRepuesto(new RepuestoAveria("1", 158.25, 1))) {
			
			repuestos.add(repuestoAveria);
			repuestos.add(repuestoAveria2);
			repuestos.add(new RepuestoAveria("1", 158.25, 1));
			quevedo.getAlmacen().eliminarStock(repuestoAlmacen2, repuestoAveria.getCantidad());
			quevedo.getAlmacen().eliminarStock(repuestoAlmacen3, repuestoAveria2.getCantidad());
			quevedo.getAlmacen().eliminarStock(repuestoAlmacen, 1);
		}
		//Creo la averia con los repuestos ha utilizar y las horas de trabajo, asignandola a un vehiculo.		
		Averia averia = new Averia("Cambio de motor", LocalDate.of(2019, 12, 31), repuestos, 23, coche);
		//Añado la averia al total de averias del taller
		
		quevedo.getAverias().add(averia);
		
		/*
		 * REALIZO LO MISMO CON MOTO2, cambiado a COCHE
		 */
				
		ArrayList<RepuestoAveria> repuestos2 = new ArrayList<>();
		
		if (quevedo.getAlmacen().hayRepuesto(repuestoAveria3)) {
			repuestos2.add(repuestoAveria3);
			quevedo.getAlmacen().eliminarStock(repuestoAlmacen4, repuestoAveria3.getCantidad());
		}
		
		Averia averia2 = new Averia("Diagnostico averia", LocalDate.of(2019, 11, 20), repuestos2, 2, coche);
		
		quevedo.getAverias().add(averia2);
		

		/*
		 * REALIZO LO MISMO CON COCHE 1
		 */
		
		ArrayList<RepuestoAveria> repuestos3 = new ArrayList<>();
		
		quevedo.getAlmacen().darAltaRepuesto(new RepuestoAlmacen("6", 15.25, 25, 10));
		for (RepuestoAlmacen repuesto : quevedo.getAlmacen().getStock()) {
			if (repuesto.getReferencia().equals("6")) {
				repuesto.nombre = "Válvula neumático";
			}
		}
		
		if (quevedo.getAlmacen().hayRepuesto(repuestoAveria4)) {
			repuestos3.add(repuestoAveria4);
			quevedo.getAlmacen().eliminarStock(quevedo.getAlmacen().getRepuestoAlmacen(repuestoAveria4), repuestoAveria4.getCantidad());
		}
		
		Averia averia3 = new Averia("Averia con repuesto no existente en almacen", LocalDate.of(2019, 11, 20), repuestos3, 5, coche1);
				
		quevedo.getAverias().add(averia3);
		
		averia3.setTurno(Turno.cogerTurno((ArrayList<Averia>) quevedo.getAverias(), quevedo.getAlmacen()));
		averia.setTurno(Turno.cogerTurno((ArrayList<Averia>) quevedo.getAverias(), quevedo.getAlmacen()));
		averia2.setTurno(Turno.cogerTurno((ArrayList<Averia>) quevedo.getAverias(), quevedo.getAlmacen()));
		
		System.out.println(quevedo.mostrarAverias(coche));
		System.out.println(quevedo.mostrarAverias(moto2));
		System.out.println(quevedo.mostrarAverias(coche1));
		
		ArrayList<Averia> averias = new ArrayList<>(quevedo.getAverias());
		averias.sort(new Comparator<Averia>() {

			@Override
			public int compare(Averia o1, Averia o2) {
				
				return o1.compareTo(o2);
			}
			
		});
		
			
		System.out.println("************** Averias en el Taller **************\n" + averias.toString());
		System.out.println(quevedo.getAlmacen().toString());
		
	}

}