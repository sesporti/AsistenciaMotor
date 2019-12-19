package es.mdef.taller;

public class Turno {

	private static Turno turnoActual = new Turno(5);
	private static int contador = turnoActual.getValor();
	private final int valor;// = -1;

	public static Turno getTurnoActual() {
		return new Turno(verValorActual());
	}

	public int getValor() {
		return valor;
	}

//	private void setValor(int valor) {
//		this.valor = valor;
//	}
	
//	private Turno() {
//		valor = new OtraClaseQuePuedeRomper("onif", true);
//	}
	
	private Turno(int valor) {
//		setValor(valor);
		this.valor = valor;
	}

	protected static void pasaTurno() {
//		turnoActual.setValor(turnoActual.getValor() + 1);
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

	public static Turno cogerTurno() {
//		Turno nuevoTurno = new Turno();
//		nuevoTurno.setValor(contador++);
//		return nuevoTurno;
		
		return new Turno(contador++);
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
