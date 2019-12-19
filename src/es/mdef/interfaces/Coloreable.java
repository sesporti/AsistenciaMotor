package es.mdef.interfaces;

import java.awt.Color;

public interface Coloreable extends Comparable<Coloreable> {

	String BLANCO = "Blanco";
	String ROJO = new Color(255, 0, 0, 1).toString();
	
	String getColor();
	
	@Override
	default int compareTo(Coloreable otroColoreable) {
		return getColor().compareToIgnoreCase(otroColoreable.getColor());
	}

}