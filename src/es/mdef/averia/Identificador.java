package es.mdef.averia;

public class Identificador {
	
	private Integer identificador;
	private static Integer identificadorActual = 0 ;
	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}
	/**
	 * @return the identificadorActual
	 */
	public static int getIdentificadorActual() {
		return identificadorActual;
	}
	public Identificador() {
		super();
		identificadorActual++;
		this.identificador = identificadorActual;
	}
	
	
}
