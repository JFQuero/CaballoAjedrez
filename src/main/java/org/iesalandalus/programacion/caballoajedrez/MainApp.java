package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Caballo caballo = null;

	public static void main(String[] args) {

		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez por Juan Fernandez Quero");
		mostrarMenu();
	}

	/* MENU INICIAL Y EJECUCION */
	private static void mostrarMenu() {

		System.out.println("- - - - - - - - - - MENU - - - - - - - - - -");
		System.out.println("1 - Crear un nuevo Caballo por defecto.");
		System.out.println("2 - Crear un nuevo Caballo con el color deseado.");
		System.out.println("3 - Crear un nuevo Caballo con el color y la columna inicial deseada.");
		System.out.println("4 - Mover el Caballo.");
		System.out.println("5 - Salir.");
		ejecutarOpcion(elegirOpcion());
	}

	private static int elegirOpcion() {

		int seleccion;
		System.out.println("¿Que quieres hacer?");
		do {
			System.out.println("[Introduce un numero valido]");
			seleccion = Entrada.entero();
		} while (seleccion < 1 | seleccion > 5);
		return seleccion;
	}

	private static void ejecutarOpcion(int seleccion) {

		switch (seleccion) {
		case 1:
			crearCaballoDefecto();
			mostrarMenu();
			break;
		case 2:
			crearCaballoDefectoColor();
			mostrarMenu();
			break;
		case 3:
			crearCaballoColorPosicion();
			mostrarMenu();
			break;
		case 4:
			if (caballo == null) {
				System.out.println("No se ha creado ningun caballo aun.");
				mostrarMenu();
			} else {
				mostrarMenuDirecciones();
			}
			break;
		case 5:
			System.out.println("¡Adios!");
			System.exit(0);
			break;
		}
	}

	/* CREADORES DE CABALLOS */
	private static void crearCaballoDefecto() {
		caballo = new Caballo();
		System.out.println("Se ha creado un nuevo caballo por defecto " + caballo);
	}

	private static void crearCaballoDefectoColor() {
		caballo = new Caballo(elegirColor());
		System.out.println("Se ha creado un nuevo caballo " + caballo);
	}

	private static void crearCaballoColorPosicion() {
		caballo = new Caballo(elegirColor(), elegirColumnaInicial());
		System.out.println("Se ha creado un nuevo caballo " + caballo);
	}

	/* PARAMETROS DE LOS CREADORES DE CABALLO */
	private static Color elegirColor() {
		int seleccion;
		Color color;
		System.out.println("¿De que color sera el caballo?");
		System.out.println("1 - Negro.");
		System.out.println("2 - Blanco.");
		do {
			System.out.println("[Introduce un numero valido]");
			seleccion = Entrada.entero();
		} while (seleccion < 1 | seleccion > 2);
		if (seleccion == 1) {
			color = Color.NEGRO;
		} else {
			color = Color.BLANCO;
		}
		return color;
	}

	private static char elegirColumnaInicial() {
		int seleccion;
		char columna;
		System.out.println("¿En que columna comenzara el caballo?");
		System.out.println("1 - B.");
		System.out.println("2 - G.");
		do {
			System.out.println("[Introduce un numero valido]");
			seleccion = Entrada.entero();
		} while (seleccion < 1 | seleccion > 2);
		if (seleccion == 1) {
			columna = 'b';
		} else {
			columna = 'g';
		}
		return columna;
	}

	/* MENU DE MOVIMIENTO Y EJECUCION */

	private static void mostrarMenuDirecciones() {

		System.out.println("- - - - - - - - - - DIRECCIONES - - - - - - - - - -");
		System.out.println("1 - ARRIBA IZQUIERDA.");
		System.out.println("2 - ARRIBA DERECHA.");
		System.out.println("3 - IZQUIERDA ARRIBA.");
		System.out.println("4 - IZQUIERDA ABAJO.");
		System.out.println("5 - ABAJO IZQUIERDA.");
		System.out.println("6 - ABAJO DERECHA.");
		System.out.println("7 - DERECHA ARRIBA.");
		System.out.println("8 - DERECHA ABAJO.");

		mover();
	}

	private static Direccion elegirDireccion() {

		Direccion movimiento = null;
		int seleccion;

		System.out.println("¿Hacia donde te quieres mover?");
		do {
			System.out.println("[Introduce un numero valido]");
			seleccion = Entrada.entero();
		} while (seleccion < 1 | seleccion > 8);

		switch (seleccion) {
		case 1:
			movimiento = Direccion.ARRIBA_IZQUIERDA;
			break;
		case 2:
			movimiento = Direccion.ARRIBA_DERECHA;
			break;
		case 3:
			movimiento = Direccion.IZQUIERDA_ARRIBA;
			break;
		case 4:
			movimiento = Direccion.IZQUIERDA_ABAJO;
			break;
		case 5:
			movimiento = Direccion.ABAJO_IZQUIERDA;
			break;
		case 6:
			movimiento = Direccion.ABAJO_DERECHA;
			break;
		case 7:
			movimiento = Direccion.DERECHA_ARRIBA;
			break;
		case 8:
			movimiento = Direccion.DERECHA_ABAJO;
			break;
		}
		return movimiento;
	}

	private static void mover() {
		try {
			caballo.mover(elegirDireccion());
			System.out.println("El caballo se ha movido! " + caballo);
			mostrarMenu();
		} catch (OperationNotSupportedException e) {
			System.out.println("ERROR: Movimiento no valido!");

		}
		mover();
	}
}