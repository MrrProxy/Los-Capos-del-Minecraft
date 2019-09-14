package Hilo;

import Juego.Juego;

public class HiloOleadas extends Thread {
	// Atributos
	private Juego elJuego;

	// Constructor
	public HiloOleadas(Juego j) {
		this.elJuego = j;
	}

	// Hilo
	public void run() {
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
