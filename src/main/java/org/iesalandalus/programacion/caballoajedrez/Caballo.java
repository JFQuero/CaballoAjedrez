package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {

	private Color color;
	private Posicion posicion;

	/* Metodos para color */
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/* Metodos para posicion */
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
}
