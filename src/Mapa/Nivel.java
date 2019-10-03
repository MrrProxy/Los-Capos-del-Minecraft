package Mapa;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Enemigo.Araña;
import Enemigo.Bruja;
import Enemigo.Creeper;
import Enemigo.FallenAngel;
import Enemigo.Enemigo;
import Enemigo.Esqueleto;
import Enemigo.Zombie;
import Entidad.Entidad;
import Hilo.HiloOleadas;
import Juego.Juego;

/**
 * Clase Nivel extiende Mapa .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Nivel extends Mapa {

	// Atributos de clase
	private static int N_Inicial = 1;
	private static int N_Final = 3;
	private int tiempoDeEspera=0;
	// Atributos de instancia
	private int N_Actual;

	// Constructor
	public Nivel() {
		N_Actual = N_Inicial;
		
	}

	// Metodos

	/**
	 * Devuelve el nivel actual del juego
	 * 
	 * @return nivel actual del juego.
	 */
	public int obtenerNivelActual() {
		return N_Actual;
	}

	/**
	 * Devuelve el nivel maximo del juego
	 * 
	 * @return nivel maximo.
	 */
	public int obtenerNivelMax() {
		return N_Final;
	}

	/**
	 * Devuelve verdadero si se pudo establecer el siguiente nivel, caso contrario
	 * falso, indicando que no hay mas niveles.
	 * 
	 * @return verdadero si hay avanzo de nivel, caso contrario falso.
	 */
	public boolean siguienteNivel() {
		boolean haySig = false;
		if (N_Actual < N_Final) {
			N_Actual++;
			haySig = true;
		}
		return haySig;
	}

	/**
	 * Carga las entidades correspondientes al juego de acuerdo al nivel actual,
	 * requiere que se establezca el siguiente nivel.
	 */
	public void cargarEntidadesAlJuego() {
		cargarEnemigos();
		// cargarObstaculos();
	}

	// Metodos privados

	/**
	 * Carga los enemigos al juego.
	 */
	private void cargarEnemigos() {
		Juego juego = Juego.getInstance();

		BufferedReader br = null;
		File fileNAct = new File(
				this.getClass().getResource("/zNiveles/Mapa/n" + N_Actual + "_enemigos.txt").getPath());

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileNAct));
			
			// Para cada linea del archivo
			if(tiempoDeEspera==0) {
			while ((sCurrentLine = br.readLine()) != null) {
				// Para cada letra de la linea
				int i = 0;
				
				while (i < sCurrentLine.length()) {
					char tipo = sCurrentLine.charAt(i); // Obtengo tipo de enemmigo
					int x = 0;
					int y = 0;
					i++;
					
					while (i < sCurrentLine.length() && sCurrentLine.charAt(i) != ' ') {
						x = leerVariable(i, sCurrentLine);
						i = i + 3;
						y = leerVariable(i, sCurrentLine);
						i = i + 3;
					}
					if (i < sCurrentLine.length()) {
						if (sCurrentLine.charAt(i) == ' ')
							i++;
					}
					Point p = new Point(x, y);
					Entidad enem = crearEnemigo(tipo, p);
					juego.agregarEntidad(enem,false);
					tiempoDeEspera=30;
					}
				}
			
			}
			tiempoDeEspera--;

		} catch (IOException u) { // Esto es por si ocurre un error
			u.printStackTrace();
		} finally { // Esto es para que, haya ocurrido error o no
			try {
				if (br != null)
					br.close(); // Cierre el archivo
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		// asignarPowerUps(list);
	}

	/**
	 * Lee desde el archivo la coordenada X o Y de tres numeros.
	 * @param i            posiciÃ³n en la linea.
	 * @param sCurrentLine linea de archivo.
	 * @return variable.
	 */
	private int leerVariable(int i, String sCurrentLine) {
		String variable = "";
		int j = 0;
		while (j < 3 && i < sCurrentLine.length()) {
			variable = variable + sCurrentLine.charAt(i);
			i++;
			j++;
		}
		return Integer.parseInt(variable);
	}

	/**
	 * Crea un enemigo de acuerdo al tipo que se recibe y con la posicion recibida
	 * por parametro.
	 * 
	 * @param tipo
	 * @param p    posicion a asignar.
	 * @return enemigo.
	 */
	private Enemigo crearEnemigo(char tipo, Point p) {
		Enemigo e = null;
		switch (tipo) {
		case 'a':
			e = new Araña(p, 70, 70);
			break;
		case 'b':
			e = new Bruja(p, 70, 70);
			break;
		case 'c':
			e = new Creeper(p, 70, 70);
			break;
		case 'd':
			e = new FallenAngel(p, 70, 70);
			break;
		case 'e':
			e = new Esqueleto(p, 70, 70);
			break;
		case 'f':
			e=new Zombie(p, 70, 70);
			break;
		}
		return e;
	}


}
