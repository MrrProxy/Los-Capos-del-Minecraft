package Hilo;

import Juego.Juego;

public class HiloPrincipal extends Thread {
	// Atributos

	private static HiloPrincipal instaceHiloPrincipal;
	private Juego juego;
	private boolean ejecutar;

	public static HiloPrincipal getInstace() {
		if (instaceHiloPrincipal == null)
			instaceHiloPrincipal = new HiloPrincipal();
		return instaceHiloPrincipal;
	}

	// Constructor
	private HiloPrincipal() {
		juego = Juego.getInstance();
		ejecutar=true;
	}

	// Metodos

	@Override
	public void run() {

		while (ejecutar) {
			try {
				Thread.sleep(100);
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// nivel.cargarEntidadesAlJuego();
			juego.Accionar();

		}

	}
	
	public void setEjecutar(boolean b) {
		ejecutar=b;
		
	}
}
