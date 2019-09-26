package Hilo;

import Juego.Juego;
import Mapa.Nivel;

public class HiloOleadas extends Thread {
	// Atributos
	private  Juego elJuego;
	private Nivel nivel;
	// Constructor
	
	private static HiloOleadas instanceHiloOleadas;
	
	public static HiloOleadas getInstace() {
		if(instanceHiloOleadas==null)
			instanceHiloOleadas=new HiloOleadas();
		return instanceHiloOleadas;
	}
	
	private HiloOleadas() {
		this.elJuego = Juego.getInstance();
	}

	// Hilo
	public void run() {
		while (true) {
			try {
				Thread.sleep(120);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
