package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

public class Caballo {

	private Color color;
	private Posicion posicion;

	/* Constructores */
	public Caballo() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'b');
	}

	public Caballo(Color color) {
		this();
		setColor(color);
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, 'b');
		}
	}

	public Caballo(Color color, char columna) {
		setColor(color);
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		if (columna != 'b' & columna != 'g') {
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, columna);
		} else {
			posicion = new Posicion(8, columna);
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

	/* Metodos para mover */
	public void mover(Direccion direccion) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un movimiento nulo.");
		}
		switch (direccion) {
		case ARRIBA_IZQUIERDA:
			try {
				this.posicion = new Posicion((posicion.getFila() + 2), (char) (posicion.getColumna() - 1));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException exception) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ARRIBA_DERECHA:
			try {
				this.posicion = new Posicion((posicion.getFila() + 2), (char) (posicion.getColumna() + 1));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case DERECHA_ARRIBA:
			try {
				this.posicion = new Posicion((posicion.getFila() + 1), (char) (posicion.getColumna() + 2));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case DERECHA_ABAJO:
			try {
				this.posicion = new Posicion((posicion.getFila() - 1), (char) (posicion.getColumna() + 2));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ABAJO_IZQUIERDA:
			try {
				this.posicion = new Posicion((posicion.getFila() - 2), (char) (posicion.getColumna() - 1));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ABAJO_DERECHA:
			try {
				this.posicion = new Posicion((posicion.getFila() - 2), (char) (posicion.getColumna() + 1));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case IZQUIERDA_ARRIBA:
			try {
				this.posicion = new Posicion((posicion.getFila() + 1), (char) (posicion.getColumna() - 2));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case IZQUIERDA_ABAJO:
			try {
				this.posicion = new Posicion((posicion.getFila() - 1), (char) (posicion.getColumna() - 2));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		default:
			break;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
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
		Caballo other = (Caballo) obj;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
}
