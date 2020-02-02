package es.mdef.taller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import es.mdef.interfaces.PiezaRepuesto;
import es.mdef.vehiculos.Coche;
import es.mdef.vehiculos.Moto;

public class Taller_Main {

	public static void main(String[] args) {
		
		Almacen<PiezaRepuesto<String>> almacen = new Almacen<>();
		
		Repuesto repuesto = new Repuesto("Correa distribución", "2", "Bosch", 125.99);
		PiezaRepuesto<String> repuesto2 = new Repuesto("Luna delantera", "1", "Carglass", 250);
		PiezaRepuesto<String> repuesto3 = new Repuesto("Brida sujeccion turbo", "4", "Stockholme", 10);
		PiezaRepuesto<String> repuesto4 = new Repuesto("Motor elevalunas", "3", "Eleva", 55);
		
		almacen.agregarStock(repuesto, 20);
		almacen.agregarStock(repuesto2, 58);
		almacen.agregarStock(repuesto4, 10);
		almacen.eliminarArticulo(repuesto);
		almacen.agregarStock(repuesto, 20);
		almacen.agregarStock(repuesto3, 20);
		almacen.eliminarStock(repuesto, 10);
		
		System.out.println(almacen.toString());
		
		
//		/*
//		 * CREO VEHICULOS
//		 */
//		// Acostumbrate a utilizar para el tipo de la variable la mas
//		// basica que necesites. Si ves que te hace falta especializarla ya
//		// tendras tiempo de refactorizar pero pensando si de verdad es asi
//		// o estas empezando a acoplar tu componente
//		// Incluso el nombre importa
//		Coche coche = new Coche("rojo", "Ford Focus");
//		Coche coche1 = new Coche("negro", "Seat Ibiza");
//		Coche coche2 = new Coche("blanco", "Citroen DS4");
//		Coche coche3 = new Coche("blanco", "BMW 320i");
//		Moto moto = new Moto("azul", "Yamaha XJ6N");
//		Moto moto1 = new Moto("blanco", "Kawasaki Z800");
//		Moto moto2 = new Moto("gris", "BMW 1200GS");
//		
//		// Matricula podria ser parte del constructor si ves que hace falta
//		// En este caso tiene mucho sentido por como lo usas
//		coche.setMatricula("7308GCR");
//		coche1.setMatricula("1234AAA");
//		coche2.setMatricula("5678BBB");
//		coche3.setMatricula("1234CCC");
//		moto.setMatricula("5678DDD");
//		moto1.setMatricula("0000ABC");
//		moto2.setMatricula("1111AAA");
//		/*
//		 * CREO CLIENTES
//		 */
//		// Aqui sin embargo no obligaria a tener que pasar un vehiculo
//		// para tener un cliente. Asi podras usar la clase cliente en mas
//		// aplicaciones. Relacionar cliente con vehiculo/telefono o lo que
//		// sea que debe reparar tu taller debe estar fuar de cliente y
//		// lo que se averia. Asi tu diseño esta menos acoplado y te
//		// dara mas flexibilidad
//		Cliente cliente = new Cliente("Sergio", "Espejel", coche);
//		Cliente cliente1 = new Cliente("Laura", "Rodríguez", coche1);
//		Cliente cliente2 = new Cliente("Alfonso", "García", moto);
//		Cliente cliente3 = new Cliente("Cristina", "Gómez", coche2);
//		
//		cliente.setDireccion("C/ Limón, 12, 7B, 28024. Madrid");
//		cliente.setTelefono("917235065/647790455");
//		/*
//		 * AÑADO MAS VEHICULOS A LOS CLIENTES
//		 */
//		// Fijate que aqui luego añades otros vehiculos.
//		// Yo lo cambiaria para llamarlo asi:
//		//     miGestorVehiculos.getVehiculos(cliente1).add(moto2);
//		cliente.getVehiculos().add(moto2);
//		cliente1.getVehiculos().add(moto1);
//
//		/*
//		 * CREO EL TALLER
//		 */
//		Taller quevedo = new Taller();
//		/*
//		 * CREO UNA COLLECTION DE CLIENTES
//		 */
//		Collection<Cliente> clientes = new ArrayList<>();
//		clientes.add(cliente);
//		clientes.add(cliente1);
//		clientes.add(cliente2);
//		clientes.add(cliente3);
//
//		// Aqui si es fundamental que uses una interface en vez de directamente
//		// el ArrayList<Cliente>. El casteo es algo mejor a evitar.
//		// En tu caso me haria una List<Cliente> lista = new ArrayList<>(clientes);
//		// Aqui esta claro que no te va a fallar, pero es por coger buenas practicas
//		ArrayList<Cliente> misClientes = (ArrayList<Cliente>) clientes;
//		
//		misClientes.sort(new Comparator<Cliente>() {
//
//			@Override
//			public int compare(Cliente o1, Cliente o2) {
//				
//				return o1.getNombre().compareTo(o2.getNombre());
//			}
//		});
//		
//		/*
//		 * AÑADO LOS CLIENTES AL TALLER
//		 */
//		quevedo.getClientes().addAll(misClientes);
//		
//		// El toString() sobra
//		System.out.println(quevedo.getClientes().toString());// es lo mismo: System.out.println(misClientes);
//		
//
//		/*
//		 * CREO REPUESTO PARA EL ALMACEN Y LOS AÑADO AL ALMACEN DEL TALLER
//		 */
//		
//		RepuestoAlmacen repuestoAlmacen = new RepuestoAlmacen("1", 158.25, 10, 5);
//		RepuestoAlmacen repuestoAlmacen1 = new RepuestoAlmacen("2", 56.75, 25, 10);
//		RepuestoAlmacen repuestoAlmacen2= new RepuestoAlmacen("3", 568.95, 2, 1);
//		RepuestoAlmacen repuestoAlmacen3 = new RepuestoAlmacen("4", 20.0, 50, 20);
//		RepuestoAlmacen repuestoAlmacen4 = new RepuestoAlmacen("5", 120.30, 15, 5);
//		
//		repuestoAlmacen.nombre = "Correa distribución";
//		repuestoAlmacen1.nombre = "Luna delantera";
//		repuestoAlmacen2.nombre = "Motor 2.0 HDI";
//		repuestoAlmacen3.nombre = "Brida sujección tubería";
//		repuestoAlmacen4.nombre = "Motor elevalunas eléctrico";
//		
//		quevedo.getAlmacen().darAltaArticulo(repuestoAlmacen);
//		quevedo.getAlmacen().darAltaArticulo(repuestoAlmacen3);
//		quevedo.getAlmacen().darAltaArticulo(repuestoAlmacen2);
//		quevedo.getAlmacen().darAltaArticulo(repuestoAlmacen1);
//		quevedo.getAlmacen().darAltaArticulo(repuestoAlmacen4);
//		
//				
//		System.out.println(quevedo.getAlmacen().toString());
//		
////		System.out.println("NO hay Averias? "+quevedo.getAverias().isEmpty());
////		System.out.println("NO hay Clientes? "+quevedo.getClientes().isEmpty());
////		System.out.println("NO hay Repuestos en Almacen? "+quevedo.getAlmacen().getStock().isEmpty());
////		System.out.println("NO Hay Reparaciones? "+quevedo.getRepaciones().isEmpty());
//		/*
//		 * Lo siguiente se puede utilizar para interactuar con la consola (ingresarVehiculo).
//		 */
////		quevedo.ingresarVehiculo(coche);
////		quevedo.ingresarVehiculo(moto1);		
////		quevedo.ingresarVehiculo(coche3);
//			
//		
//		/*
//		 * A PARTIR DE AQUI, SE REALIZA PASO POR PASO LO QUE REALIZARÍA INGRESAR VEHICULO HASTA QUE SE LE DA EL TURNO A CADA AVERIA CREADA.
//		 * CREO REPUESTOS PARA LAS AVERIAS
//		 */
//		RepuestoAveria repuestoAveria = new RepuestoAveria("3", 568.95, 1);
//		RepuestoAveria repuestoAveria2 = new RepuestoAveria("4", 20.0, 2);
//		RepuestoAveria repuestoAveria3 = new RepuestoAveria("5", 120.3, 2);
//		RepuestoAveria repuestoAveria4 = new RepuestoAveria("6", 15.25, 1);
//		RepuestoAveria repuestoAveria5 = new RepuestoAveria("SIN REFERENCIA ALMACEN", 0.0, 5);
//		
//		/*
//		 * AÑADO REPUESTOS A LA AVERIA, CREANDO UNA LIST DE REPUESTOS PARA CADA AVERIA.
//		 */
//		// Recuerda usar interfaces antes que implementaciones
//		ArrayList<RepuestoAveria> repuestos = new ArrayList<>();
//		
//		repuestos.add(repuestoAveria);
//		repuestos.add(repuestoAveria2);
//		repuestos.add(new RepuestoAveria("1", 158.25, 1));
//		
//		for (RepuestoAveria repuestoNecesario : repuestos) {
//			if (quevedo.getAlmacen().hayRepuesto(repuestoNecesario)) {
//			
//				// Aqui empieza a verse miserias de tu diseño. No parece natural esto
//				// y el dia de mañana sera un problema de mantenimiento
//				RepuestoAlmacen repuestoAlma = quevedo.getAlmacen().getArticuloAlmacen(repuestoNecesario);//convierto el Repuesto de averia en un repuesto de almacen para poder eliminar la cantidad asignada a la averia del almacen.
//				
//				quevedo.getAlmacen().eliminarStock(repuestoAlma, repuestoNecesario.getCantidad());
//		
//			} else {
//				System.out.println("SIN REPUESTO: El repuesto no existe o no hay suficiente cantidad.");
//				quevedo.getAlmacen().solicitarRepuesto(repuestoNecesario);
//				repuestoNecesario.setCantidadAsignada(- repuestoNecesario.getCantidad());
//				
//			}
//		}
//		
//		//Creo la averia con los repuestos ha utilizar y las horas de trabajo, asignandola a un vehiculo.		
//		
//		Averia averia = new Averia("Cambio de motor", LocalDate.of(2019, 12, 31), repuestos, 23, coche);
//		
//		//Añado la averia al total de averias del taller
//		
//		quevedo.getAverias().add(averia);
//		
//		// Si vas a hacer lo mismo encapsulalo. Aunque pienses que son solo pruebas
//		// las pruebas son codigo y encapsulandolo te queda todo mas limpio y puedes
//		// pasarle muchos mas casos de prueba sin tener que hacer copy&paste
//		// Refactoriza todo lo de abajo para que este en un metodo
//		/*
//		 * REALIZO LO MISMO CON MOTO2, cambiado a COCHE
//		 */
//				
//		ArrayList<RepuestoAveria> repuestos2 = new ArrayList<>();
//		
//		repuestos2.add(repuestoAveria3);
//		
//		for (RepuestoAveria repuestoNecesario : repuestos2) {
//			if (quevedo.getAlmacen().hayRepuesto(repuestoNecesario)) {
//			
//				RepuestoAlmacen repuestoAlma = quevedo.getAlmacen().getArticuloAlmacen(repuestoNecesario);//convierto el Repuesto de averia en un repuesto de almacen para poder eliminar la cantidad asignada a la averia del almacen.
//				
//				quevedo.getAlmacen().eliminarStock(repuestoAlma, repuestoNecesario.getCantidad());
//		
//			} else {
//				System.out.println("SIN REPUESTO: El repuesto no existe o no hay suficiente cantidad.");
//				quevedo.getAlmacen().solicitarRepuesto(repuestoNecesario);
//				repuestoNecesario.setCantidadAsignada(- repuestoNecesario.getCantidad());
//			}
//		}
//		Averia averia2 = new Averia("Diagnostico averia", LocalDate.of(2019, 11, 20), repuestos2, 2, coche);
//		
//		quevedo.getAverias().add(averia2);
//		
//		/*
//		 * REALIZO LO MISMO CON COCHE 1
//		 */
//		
//		ArrayList<RepuestoAveria> repuestos3 = new ArrayList<>();
//		
//		quevedo.getAlmacen().darAltaArticulo(new RepuestoAlmacen("6", 15.25, 25, 10));
//		for (RepuestoAlmacen repuesto : quevedo.getAlmacen().getArticulos()) {
//			if (repuesto.getReferencia().equals("6")) {
//				repuesto.nombre = "Válvula neumático";
//			}
//		}
//		
//		repuestos3.add(repuestoAveria4);
//		
//		for (RepuestoAveria repuestoNecesario : repuestos3) {
//			if (quevedo.getAlmacen().hayRepuesto(repuestoNecesario)) {
//			
//				RepuestoAlmacen repuestoAlma = quevedo.getAlmacen().getArticuloAlmacen(repuestoNecesario);//convierto el Repuesto de averia en un repuesto de almacen para poder eliminar la cantidad asignada a la averia del almacen.
//				
//				quevedo.getAlmacen().eliminarStock(repuestoAlma, repuestoNecesario.getCantidad());
//		
//			} else {
//				System.out.println("SIN REPUESTO: El repuesto no existe o no hay suficiente cantidad.");
//				quevedo.getAlmacen().solicitarRepuesto(repuestoNecesario);
//				repuestoNecesario.setCantidadAsignada(- repuestoNecesario.getCantidad());
//			}
//		}
//		
//		Averia averia3 = new Averia("Averia Seat Ibiza", LocalDate.of(2019, 11, 20), repuestos3, 3, coche1);
//				
//		quevedo.getAverias().add(averia3);
//
//		/*
//		 * REALIZO LO MISMO CON MOTO2
//		 */
//		
//		ArrayList<RepuestoAveria> repuestos4 = new ArrayList<>();
//		
//		repuestos4.add(repuestoAveria2);
//		repuestos4.add(repuestoAveria4);
//		repuestos4.add(repuestoAveria5);
//		for (RepuestoAveria repuestoNecesario : repuestos4) {
//			if (quevedo.getAlmacen().hayRepuesto(repuestoNecesario)) {
//			
//				RepuestoAlmacen repuestoAlma = quevedo.getAlmacen().getArticuloAlmacen(repuestoNecesario);//convierto el Repuesto de averia en un repuesto de almacen para poder eliminar la cantidad asignada a la averia del almacen.
//				
//				quevedo.getAlmacen().eliminarStock(repuestoAlma, repuestoNecesario.getCantidad());
//		
//			} else {
//				System.out.println("SIN REPUESTO: El repuesto no existe o no hay suficiente cantidad.");
//				quevedo.getAlmacen().solicitarRepuesto(repuestoNecesario);
//				repuestoNecesario.setCantidadAsignada(- repuestoNecesario.getCantidad());
//			}
//		}
//		
//		Averia averia4 = new Averia("Averia con repuesto no existente en almacen", LocalDate.of(2019, 12, 31), repuestos4, 10, moto2);
//				
//		quevedo.getAverias().add(averia4);		
//		
//		
//		//DOY TURNO A TODAS LAS AVERIAS DEL TALLER
//		// Mejor con algo que no sea el taller como vimos con GeneradorTurno
//		quevedo.darTurno();
//		
//		
//		System.out.println(quevedo.mostrarAverias(coche));
//		System.out.println(quevedo.mostrarAverias(moto2));
//		System.out.println(quevedo.mostrarAverias(coche1));
//		
//		// Interface...
//		ArrayList<Averia> averias = new ArrayList<>(quevedo.getAverias());
//		// Recuerda que si implementa Comparable no te hace falta definir un comparador
//		// si vas a usar la comparacion por defecto como estas haciendo. Pasas null y listo
//		averias.sort(new Comparator<Averia>() {
//
//			@Override
//			public int compare(Averia o1, Averia o2) {
//				
//				return o1.compareTo(o2);
//			}
//			
//		});
//		
//			
//		System.out.println("************** Averias en el Taller **************\n" + averias.toString());
//		System.out.println(quevedo.getAlmacen().toString());
//		System.out.println(quevedo.averiasSinRepuesto());
//		
//		/*
//		 * HAGO REPARACIONES PARA QUE PASEN A COLLECTION REPARACIONES
//		 */
//		quevedo.repararAveria(averia);
//		
//		System.out.println(quevedo.mostrarReparaciones(coche, LocalDate.now()));//tienen que aparecer reparaciones
//		
//		quevedo.repararAveria(averia2);//reparo la averia2 del coche, se puede reparar porque cumple requisitos
//		
//		System.out.println("-----------REPARACIONES REALIZADAS------------------\n"+quevedo.getRepaciones().toString());//tiene que aparecer la anterior averia reparada.
//		
//		
//		
//		Reparacion reparacion = new Reparacion(LocalDate.of(2018, 10, 25));
//		
//		// Se ve un poco de lio en como esta diseñado y se hacen las llamadas a las otras clases:
//		// reparacion.agregarAveriaReparada(averia) y dentro de eso llamas a averia.getReparacion()
//		// ¿No te parece redundante?
//		reparacion.agregarAveriaReparada(averia3);//no estaba reparada previamente, se repara automaticamente y se agrega a averiasReparadas
//		reparacion.agregarAveriaReparada(averia);
//		System.out.println(reparacion.getAveriasReparadas().toString());
//		quevedo.getRepaciones().add(reparacion);
//		System.out.println(reparacion.estaEnGarantia());
//		System.out.println("-----------REPARACIONES REALIZADAS------------------\n"+quevedo.getRepaciones().toString());
//		
//		
	}

}
