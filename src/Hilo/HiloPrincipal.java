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
		int n=1;
		while(true){
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//n++;
			//if (n==1)
				elJuego.mover();
			//else 
				//if (n==10)
					//n=0;
		}
	}
}

