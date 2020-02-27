package es.mdef.averia;

public interface Facturable {

	double IVA_NORMAL = 0.21;
	double IVA_REDUCIDO = 0.04;
	
	default double getIva(String tipoIva) {
		if (tipoIva.equalsIgnoreCase("reducido")) {
			return IVA_REDUCIDO;
		} else {
			return IVA_NORMAL;
		}
	}
}