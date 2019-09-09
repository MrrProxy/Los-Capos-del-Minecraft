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
		//System.out.println("........MAPA" + Celdas[0][0] == null);
		//System.out.println("........MAPA" + Celdas[0][0].getClass());
		for (int i = 1; i < 800; i++) {

			for (int j = 0; j < 600; j++) {
				Celdas[ i][j] = null;
				//System.out.println("........MAPA" + Celdas[i][j] == null);
			}
		}
	}

	public boolean agregarEntidadMap(Entidad e) {
		boolean EstaVacio = true;
		int x = e.obtenerPosicion().x;
		int y = e.obtenerPosicion().y;
		int ancho = e.anchoEntidad();
		int alto = e.altoEntidad();
		/*System.out.println("............MAPA" + Celdas[x][y] == null);
		if (Celdas[x][y] == null) {
			Celdas[x][y] = e;
			System.out.println("........MAPA" + Celdas[x][y] == null);
			// Guardo los elementos en cada pixel
			for (int i = 1; i <= ancho; i++) {
				if (Celdas[x+i][y] == null)
					Celdas[x + i][y] = e;
				else
					EstaVacio = false;
				for (int j = 1; j <= alto; j++) {
					if (Celdas[x][y+j] == null)
						Celdas[x][y + j] = e;
					else
						EstaVacio = false;

				}
			}
		} else {
			EstaVacio = false;
		}*/
		return EstaVacio;
	}

}
