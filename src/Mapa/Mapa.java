package Mapa;

import Entidad.Entidad;

/**
 * Clase Mapa.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Mapa {

	// Atributos mapa
	protected Entidad[][] Celdas;

	// Constructor
	public Mapa() {
		Celdas = new Entidad[800][600];
		for (int i = 1; i < 800; i++) {

			for (int j = 0; j < 600; j++) {
				Celdas[i][j] = null;
			}
		}
	}

	public boolean EstaVacioLugar(Entidad e) {
		boolean vacio = false;
		int x = e.obtenerPosicion().x;
		int y = e.obtenerPosicion().y;
		if (Celdas[x][y] == null)
			vacio = true;
		return vacio;
	}

	public void agregarEntidadMap(Entidad e) {
		int x = e.obtenerPosicion().x;
		int y = e.obtenerPosicion().y;
		int ancho = e.anchoEntidad();
		int alto = e.altoEntidad();
		// Guardo los elementos en cada pixel
		for (int i = 0; i <= ancho; i++) {
			for (int j = 0; j < alto; j++) {
				if (Celdas[x+i][y + j] == null)
					Celdas[x+i][y + j] = e;
			}
		}
	}

}
