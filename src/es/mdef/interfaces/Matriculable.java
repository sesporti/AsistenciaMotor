package es.mdef.interfaces;

public interface Matriculable {
	
	public String getMatricula ();
	
	default String mostrarMatricula () {
		return ", matrícula = " + getMatricula();
	}

}
