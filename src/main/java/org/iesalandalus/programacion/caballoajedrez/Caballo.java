package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {

	private Color color;
	private Posicion posicion;
	
	/* Constructores */
	public Caballo() {
		color = Color.NEGRO;
		posicion = new Posicion(8,'b');
	}
	
	public Caballo(Color color) {
		this();
		setColor(color);
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1,'b');
		}
	}
	
	public Caballo(Color color, char columna) {
        setColor(color);
        if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
        if (columna !='b' & columna!='g') {
        	throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
        }
        if (color == Color.BLANCO) {
        	posicion = new Posicion(1,columna);
        } else {
        	posicion = new Posicion(8,columna);
        }
    }

	/* Metodos para color */
	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		this.color = color;
	}

	/* Metodos para posicion */
	public Posicion getPosicion() {
		return posicion;
	}
	
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
}
