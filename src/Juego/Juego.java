package Juego;

import java.util.LinkedList;
import javax.swing.JLabel;
import Entidad.Entidad;
import GUI.GUI;
import Hilo.HiloOleadas;
import Hilo.HiloPrincipal;
import Mapa.Mapa;

/**
 * Clase Juego .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Juego {
	protected int cantMonedas = 10000;
	protected Mapa map;
	protected int puntaje;
	private HiloPrincipal tiempo;
	private HiloOleadas tiempo2;
	private GUI gui;
	private LinkedList<Entidad> entidades;
	private LinkedList<Entidad> aEliminar;
	private LinkedList<Entidad> aAgregar;

	private static Juego instance;

	private Juego() {

	}

	public static Juego getInstance() {
		if (instance == null)
			instance = new Juego();
		return instance;

	}

	public void establecerGrafica(GUI g) {
		if (gui == null)
			gui = g;
	}

	// Inicia el juego

	public void iniciarJuego() {

		map = new Mapa();

		entidades = new LinkedList<Entidad>();
		aAgregar = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();

		tiempo = HiloPrincipal.getInstace();
		tiempo.start();
		tiempo2 = HiloOleadas.getInstace();
		tiempo2.start();

	}
	
	public void refreshMovement(){
		for (Entidad e : entidades)
			e.setAvanzar(true);
	}

	public synchronized void Accionar() {
		if (!entidades.isEmpty()) {
			for (Entidad e1 : entidades) {
				if (e1.getVida() > 0) {
					e1.Accionar();
					for (Entidad e2 : entidades) {
						if (e1 != e2 && map.chocan(e1, e2)) {
							e1.Aceptar(e2.getVisitor());
						}
					}
					for (Entidad e2 : entidades)
						if (e1 != e2 && map.chocan(e1, e2))
							e1.Aceptar(e2.getVisitor());
					e1.Accionar();

				} else
					aEliminar.addLast(e1);
			}
			refreshMovement();
		}
		if (!aAgregar.isEmpty()) {
			for (Entidad e : aAgregar) {
				entidades.addFirst(e);
				gui.actualizarEstadisticas(puntaje, cantMonedas);
				gui.agregarAlJuego(e.getGrafico(0));
			}
			aAgregar = new LinkedList<Entidad>();
		}
		if (!aEliminar.isEmpty()) {
			for (Entidad e : aEliminar) {
				entidades.remove(e);
				cantMonedas = cantMonedas + e.getMonedas();
				puntaje = puntaje + e.getPuntaje();
				e.setGrafico(2);
				gui.actualizarEstadisticas(puntaje, cantMonedas);
				gui.eliminarEntidad(e.getGrafico(2));
			}
			aEliminar = new LinkedList<Entidad>();
		}

	}

	public void agregarEntidad(Entidad e, boolean agregar) {
		if (e != null) {
			if (!agregar) {
				if (map.puedoAgregar(e, entidades)) {
					aAgregar.add(e);
				}
			}
			if (agregar)
				aAgregar.add(e);
		}
	}

//	public void agregarGrafica(Entidad e) {
//		JLabel j = e.getGrafico(0);
//		gui.agregarAlJuego(j);
//	}

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

	/**
	 * Devuelve el puntaje
	 * 
	 * @return puntaje
	 */
	public int getPuntaje() {
		return cantMonedas;
	}

	/**
	 * Actualiza el puntaje
	 * 
	 * @param puntaje
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public LinkedList<Entidad> getEntidades() {
		return entidades;
	}

	public void eliminarEntidades() {
		for (Entidad e : entidades) {
			e.morir();
		}
	}

}// Fin clase Juego
