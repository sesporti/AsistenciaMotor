package es.mdef.interfaces;



public interface Matriculable extends Comparable<Matriculable>{
	
	public String getMatricula ();
	
	default String mostrarMatricula () {
		return "Matrícula : " + getMatricula();
	}
	@Override
	default int compareTo(Matriculable o) {
		
		return getMatricula().compareToIgnoreCase(o.getMatricula());
	}

}
