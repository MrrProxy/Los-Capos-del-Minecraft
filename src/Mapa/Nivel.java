package Mapa;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import Enemigo.ReaperManRed;
import Enemigo.GolemPiedra;
import Enemigo.GolemHielo;
import Enemigo.FallenAngel;
import Enemigo.ReaperMan;
import Enemigo.Goblin;
import Entidad.Entidad;
import Hilo.HiloOleadas;
import Juego.Juego;
import Obstaculos.Agua;
import Obstaculos.Roca;

/**
 * Clase Nivel extiende Mapa .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Nivel extends Mapa {

	// Atributos de clase
	private static int N_Final = 6;
	// Atributos de instancia
	private int N_Actual;
	private LinkedList<Entidad> enemigos;
	private Juego juego;
	private int cantEnemigos;
	private int cantEnemigosMuertos = 0;;
	private Random random;
	private int r;

	private static Nivel instance;

	public static Nivel getInstance() {
		if (instance == null)
			instance = new Nivel();
		return instance;

	}

	// Constructor
	private Nivel() {
		N_Actual = 0;
		enemigos = new LinkedList<Entidad>();
		juego = Juego.getInstance();

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

	private void cargarEnemigos() {
		BufferedReader br = null;
		File fileNAct = new File(
				this.getClass().getResource("/zNiveles/Mapa/n" + N_Actual + "_enemigos.txt").getPath());

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileNAct));

			// Para cada linea del archivo
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
					random = new Random();
					r = random.nextInt(10);
					if (tipo != 'r' && tipo != 'h' && enem!=null) {
						if (r < 5) {
							enemigos.addLast(enem);
						} else {
							enemigos.addFirst(enem);
						}
					} else {
						juego.agregarEntidad(enem, false);
					}
				}

			}
			cantEnemigos = enemigos.size();

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
	}

	/**
	 * Lee desde el archivo la coordenada X o Y de tres numeros.
	 * 
	 * @param i            posición en la linea.
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

	public void agregarEnemigos() {
		random = new Random();
		r = random.nextInt(2) + 1;
		while (!enemigos.isEmpty() && r != 0) {
			juego.agregarEntidad(enemigos.getFirst(), true);
			enemigos.removeFirst();
			r--;
		}
		//System.out.println("catenemigosmuertos  "+cantEnemigosMuertos+"y cant enemigos "+cantEnemigos+" lista enemigos"+enemigos.isEmpty());
		if (enemigos.isEmpty() && N_Actual <= N_Final && cantEnemigosMuertos >= cantEnemigos) {
			try {
				HiloOleadas.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			N_Actual++;
			cargarEnemigos();
			cantEnemigosMuertos = 0;
		} else {
			if (N_Actual >= N_Final && cantEnemigosMuertos >= cantEnemigos) {
				juego.terminarJuego(true);

			}

		}
	}

	// suma 1 a la cantidad de muertos de enemigos
	public void sumarEnemigosMuertos() {
		cantEnemigosMuertos++;

	}

	/**
	 * Crea un enemigo de acuerdo al tipo que se recibe y con la posicion recibida
	 * por parametro.
	 * 
	 * @param tipo
	 * @param p    posicion a asignar.
	 * @return enemigo.
	 */
	private Entidad crearEnemigo(char tipo, Point p) {
		Entidad e = null;
		switch (tipo) {
		case 'a':
			e = new ReaperManRed(p, 70, 70);
			break;
		case 'b':
			e = new GolemPiedra(p, 70, 70);
			break;
		case 'c':
			e = new ReaperMan(p, 70, 70);
			break;
		case 'd':
			e = new FallenAngel(p, 70, 70);
			break;
		case 'e':
			e = new GolemHielo(p, 70, 70);

			break;
		case 'f':
			e = new Goblin(p, 70, 70);
			break;
		case 'r':
			e = new Roca(p, 70, 70);
			break;
		case 'h':
			e = new Agua(p, 70, 70);
			break;
		}
		return e;
	}

}
