package es.mdef.taller;

import java.util.ArrayList;
import java.util.Collection;

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
		Moto moto = new Moto("azul", "Yamaha XJ6N");
		Moto moto1 = new Moto("blanco", "Kawasaki Z800");
		Moto moto2 = new Moto("gris", "BMW 1200GS");
		
		/*
		 * CREO CLIENTES
		 */
		Cliente cliente = new Cliente("Sergio", "Espejel", coche);
		Cliente cliente1 = new Cliente("Laura", "Rodríguez", coche1);
		Cliente cliente2 = new Cliente("Alfonso", "García", moto);
		Cliente cliente3 = new Cliente("Cristina", "Gómez", coche2);
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

		/*
		 * AÑADO LOS CLIENTES AL TALLER
		 */
		quevedo.getClientes().addAll(clientes);
//		System.out.println(quevedo.getClientes().toString());

		/*
		 * CREO REPUESTO PARA EL ALMACEN Y LOS AÑADO AL ALMACEN DEL TALLER
		 */
		
		RepuestoAlmacen repuestoAlmacen = new RepuestoAlmacen("00000001", 158.25, 10, 5);
		RepuestoAlmacen repuestoAlmacen1 = new RepuestoAlmacen("00000002", 56.75, 25, 10);
		RepuestoAlmacen repuestoAlmacen2= new RepuestoAlmacen("00000003", 568.95, 2, 1);
		RepuestoAlmacen repuestoAlmacen3 = new RepuestoAlmacen("00000004", 20.0, 50, 20);
		
		repuestoAlmacen.nombre = "Correa distribución";
		repuestoAlmacen1.nombre = "Luna delantera";
		repuestoAlmacen2.nombre = "Motor 2.0 HDI";
		repuestoAlmacen3.nombre = "Brida sujeccion tubería";
		
		quevedo.getAlmacen().darAltaRepuesto(repuestoAlmacen);
		quevedo.getAlmacen().darAltaRepuesto(repuestoAlmacen3);
		quevedo.getAlmacen().darAltaRepuesto(repuestoAlmacen2);
		quevedo.getAlmacen().darAltaRepuesto(repuestoAlmacen1);
		
//		System.out.println(quevedo.getAlmacen().toString());
		
		quevedo.ingresarVehiculo(coche);
		

		
	}

}
