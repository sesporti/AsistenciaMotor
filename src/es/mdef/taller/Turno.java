package es.mdef.taller;

import java.util.ArrayList;
//import java.util.Comparator;

public class Turno {

	private static Turno turnoActual = new Turno(1);
	private static int contador = turnoActual.getValor();
	private final int valor;
	
	private Turno(int valor) {
		this.valor = valor;
	}
	
	public static Turno getTurnoActual() {
		return new Turno(verValorActual());
	}

	public int getValor() {
		return valor;
	}

	protected static void pasaTurno() {
		turnoActual = new Turno(turnoActual.getValor() + 1);
		System.out.println("info: pasado turno a "
				+ turnoActual.getValor());
	}
	
	public static int verValorActual() {
		return turnoActual.getValor();
	}

	@Override
	public String toString() {
		return "Turno " + getValor();
	}

	public static void cogerTurno(ArrayList<Averia> averias) {
		Turno turno = new Turno(1);
		boolean darTurno = true;

		for (int i = 0; i < averias.size(); i++) {
			for (RepuestoAveria repuesto : averias.get(i).getRepuestos()) {
				if (repuesto.getCantidad() < 0) {//> (almacen.getRepuestoAlmacen(repuesto).getCantidad() + repuesto.getCantidad())) {
					darTurno = false;
				} else {
					darTurno = true;
				}			
			}
			
			if (!darTurno) {
				
				turno = null;
				averias.get(i).setTurno(turno);

			} else {
				
				turno = new Turno(contador++);
				averias.get(i).setTurno(turno);
			
			}
			
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turno other = (Turno) obj;
		if (valor != other.valor)
			return false;
		return true;
	}

}
