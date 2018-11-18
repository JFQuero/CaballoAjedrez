package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {

	private int fila;
	private char columna;

	private static final int FILA_MIN = 1;
	private static final int FILA_MAX = 8;
	private static final char COLUMNA_MIN = 'a';
	private static final char COLUMNA_MAX = 'h';

	/* Constructores */

	public Posicion(int fila, char columna) {
		if (fila < FILA_MIN | fila > FILA_MAX) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		} else {
			setFila(fila);
			;
		}
		if (columna < COLUMNA_MIN | columna > COLUMNA_MAX) {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		} else {
			setColumna(columna);
		}
	}

	public Posicion(Posicion posicion) {
		if (posicion == null) {
			throw new IllegalArgumentException("ERROR: No es posible copiar una posición nula.");
		}
		posicion.fila = this.getFila();
		posicion.columna = this.getColumna();
	}

	/* Metodos para fila */
	public void setFila(int fila) {
		if (fila < FILA_MIN | fila > FILA_MAX) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		} else {
			this.fila = fila;
		}
	}

	public int getFila() {
		return fila;
	}

	/* Metodos para Columna */
	public void setColumna(char columna) {
		if (columna < COLUMNA_MIN | columna > COLUMNA_MAX) {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		} else {
			this.columna = columna;
		}
	}

	public char getColumna() {
		return columna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
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
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}
}
