package Hilo;

import Mapa.Nivel;

public class HiloOleadas extends Thread {
	// Atributos
	private Nivel nivel;
	private boolean ejecutar;

	private static HiloOleadas instanceHiloOleadas;

	public static HiloOleadas getInstace() {
		if (instanceHiloOleadas == null)
			instanceHiloOleadas = new HiloOleadas();
		return instanceHiloOleadas;
	}

	// Constructor

	private HiloOleadas() {
		nivel = Nivel.getInstance();
		ejecutar = true;

	}

	// Hilo
	public void run() {
		while (ejecutar) {
			try {
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

}