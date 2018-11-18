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
}
