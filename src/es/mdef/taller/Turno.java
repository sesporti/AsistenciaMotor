package es.mdef.taller;

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

	public static Turno cogerTurno() {

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
