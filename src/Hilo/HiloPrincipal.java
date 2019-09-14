package Hilo;

import Juego.Juego;

public class HiloPrincipal extends Thread {
	//Atributos
	private Juego elJuego;
	protected  static HiloPrincipal instance;
	
	public static HiloPrincipal getInstace() {
		if (instance == null)
			instance = new HiloPrincipal();
		return instance;
	}

	//Constructor
	private HiloPrincipal() {
		this.elJuego = Juego.getInstance();
	}

	//Hilo
	public void run() {
		while(true){
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				elJuego.Accionar();
		}
	}
}

