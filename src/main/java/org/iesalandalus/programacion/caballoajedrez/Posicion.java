package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {

	private int fila;
	private char columna;

	private static final int FILA_MIN = 1;
	private static final int FILA_MAX = 8;
	private static final char COLUMNA_MIN = 'a';
	private static final char COLUMNA_MAX = 'h';

	public void setFila(int fila) {
		if (fila < FILA_MIN | fila > FILA_MAX) {
			throw new IllegalArgumentException("El valor introducido para la fila no es correcto.");
		} else {
			this.fila = fila;
		}
	}

	public int getFila(int fila) {
		return fila;
	}

	public void setColumna(char columna) {
		if (columna < COLUMNA_MIN | columna > COLUMNA_MAX) {
			throw new IllegalArgumentException("El valor introducido para la columna no es correcto");
		} else {
			this.columna = columna;
		}
	}

	public char getColumna(char columna) {
		return columna;
	}
}
