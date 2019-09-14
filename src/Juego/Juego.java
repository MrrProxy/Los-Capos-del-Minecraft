package Juego;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JLabel;

import Enemigo.Zombie;
import Entidad.Entidad;
import GUI.GUI;
import Mapa.Mapa;

/**
 * Clase Juego .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Juego {
	protected int cantMonedas = 1000;
	protected Mapa map;
	private GUI gui;
	private Entidad malos;
	int i=0;
	private LinkedList<Entidad> entidades;

	private static Juego instance;

	private Juego() {

	}

	public static Juego getInstance() {
		if (instance == null)
			instance = new Juego();
		return instance;

	}

//	
//	public boolean agregarEntidad(Entidad e){
//		boolean toReturn= map.agregarEntidadMap(e);
//		return toReturn;
//				
//	}

	public void establecerGrafica(GUI g) {
		if (gui == null)
			gui = g;
	}
	// Inicia el juego

	public void iniciarJuego() {
		map = new Mapa();

		//disparos = new LinkedList<Disparo>();
		entidades= new LinkedList<Entidad>();
		
		int x=40;
		for(int i=0;i<6;i++) {
			int valorX = (int) (1 * 800);
			malos= new Zombie(new Point(valorX, x), 42, 42);
			entidades.addLast(malos);
			gui.agregarAlJuego(malos.getGrafico(1));
			x+=95;
		}
	}

	public void Accionar() {
		
		for(Entidad e: entidades) {
			e.Accionar();
		}
		/*if (tiempoDisparos == 0) {
			for (Entidad d : entidades) {
				DisparoTorre nuevo = d.disparar();
				JLabel test = nuevo.getGrafico(1);
				gui.agregarAlJuego(test);
				disparos.addLast(nuevo);
			}
			tiempoDisparos = 100;
		}
		tiempoDisparos--;
	}*/
	}
	public void agregarEntidad(Entidad e) {
		entidades.add(e);
	}
	public void agregarGrafica(Entidad e) {
		JLabel j=e.getGrafico(1);
		gui.agregarAlJuego(j);
	}

	/**
	 * Devuelve las monedas disponibles
	 * 
	 * @return cantMonedas
	 */
	public int getCantMonedas() {
		return cantMonedas;
	}

	/**
	 * Actualiza la cantidad de monedas disponibles
	 * 
	 * @param monedas
	 */
	public void setCantMonedas(int monedas) {
		cantMonedas = monedas;
	}
}// Fin clase Juego
