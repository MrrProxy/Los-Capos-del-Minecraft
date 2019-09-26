package Juego;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JLabel;

import Disparos.Disparo;
import Enemigo.Zombie;
import Entidad.Entidad;
import GUI.GUI;
import Mapa.Mapa;
import Enemigo.Enemigo;

/**
 * Clase Juego .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Juego {
	protected int cantMonedas = 10000;
	protected Mapa map;
	private GUI gui;
	private Entidad malos;
	int i = 0;
	private LinkedList<Entidad> entidades;
	private LinkedList<Enemigo> enemigos;
	private LinkedList<Disparo> disparos;
	private LinkedList<Entidad> eliminados;

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
		System.out.println("Cantidad de monedas con la cual empieza el juego: "+cantMonedas);
		entidades = new LinkedList<Entidad>();
		disparos=new LinkedList<Disparo>();
		eliminados = new LinkedList<Entidad>();

		int x = 40;
		for (int i = 0; i < 6; i++) {
			int valorX = (int) (1 * 800);
			malos = new Zombie(new Point(valorX, x), 42, 42);
			entidades.addLast(malos);
			gui.agregarAlJuego(malos.getGrafico(1));
			x += 95;
		}
	}

	public synchronized void Accionar() {
		synchronized (entidades) {
			for (Entidad e : entidades) {
				if (e.getVida()!=0)
					e.Accionar();
				else
					eliminados.addLast(e);
			}
			
			for (Entidad e: eliminados) {
				entidades.remove(e);
				gui.eliminarEntidad(e.getGrafico(1));
				gui.remove(e.getGrafico(1));
			}
			
			eliminados= new LinkedList<>();

		}
	}

	public void agregarEntidad(Entidad e) {
		if (e != null) {
			entidades.add(e);
			gui.agregarAlJuego(e.getGrafico(1));
			

		}
	}

	public void agregarGrafica(Entidad e) {
		JLabel j = e.getGrafico(3);
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

	public LinkedList<Disparo> obtenerDisparos() {
		return disparos;
	}

	public LinkedList<Entidad> obtenerEntidades() {
		return entidades;
	}

	public void agregarEnemigo(Enemigo e) {
		if (e != null) {
			enemigos.add(e);
			gui.add(e.getGrafico(1), 0);
		}
	}

	public void eliminarEntidades() {
		for(Entidad e: entidades) {
			e.morir();
			cantMonedas=cantMonedas+e.getMonedas();
		}
		System.out.println("Monedas:" +cantMonedas);
	}


	public void addDisparoEnemigo(Disparo dE) {
		if (dE != null) {
			synchronized (disparos) {
				disparos.add(dE);
			}
		}
	}
	
	public void eliminarDisparo(Disparo dE) {
			for(Disparo d: disparos) {
				if(d.equals(dE))
					disparos.remove(d);
		}
	}

	public void addDisparoJugador(Disparo dJ) {
		if (dJ != null) {
			synchronized (disparos) {
				disparos.add(dJ);
			}
		}
	}
}// Fin clase Juego
