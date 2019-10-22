package Hilo;

import Mapa.Nivel;
import Sonidos.sonidosMp3;

public class HiloOleadas extends Thread {
	// Atributos
	private Nivel nivel;
	private boolean ejecutar;
	private sonidosMp3 sonidosMp3;
	private int soudtrack;
	// Constructor

	private static HiloOleadas instanceHiloOleadas;

	public static HiloOleadas getInstace() {
		if (instanceHiloOleadas == null)
			instanceHiloOleadas = new HiloOleadas();
		return instanceHiloOleadas;
	}

	private HiloOleadas() {
		nivel = Nivel.getInstance();
		ejecutar = true;
		sonidosMp3 = new sonidosMp3();
		soudtrack=0;

	}

	// Hilo
	public void run() {
		while (ejecutar) {
			try {
				soudtrackNivel();
				nivel.agregarEnemigos();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			

		}
	}

	public void setEjecutar(boolean b) {
		ejecutar = b;
	}
	public sonidosMp3 getSoudtrack() {
		return sonidosMp3;
	}
	private void soudtrackNivel() {
		if (nivel.obtenerNivelActual() != soudtrack) {
			soudtrack = nivel.obtenerNivelActual();
			sonidosMp3.stop();
			sonidosMp3.abrirArchivo("bsound" + nivel.obtenerNivelActual());
		} else {
			sonidosMp3.loop();

		}
	}
}
