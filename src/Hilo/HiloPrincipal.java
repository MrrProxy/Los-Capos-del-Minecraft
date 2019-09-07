package Hilo;

import Juego.Juego;

public class HiloPrincipal extends Thread {
	//Atributos
	private Juego elJuego;

	//Constructor
	public HiloPrincipal(Juego j) {
		this.elJuego = j;
	}

	//Hilo
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.mover();
		}
	}
}

