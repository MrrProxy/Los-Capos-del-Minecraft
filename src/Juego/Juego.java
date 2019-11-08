package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import Entidad.Entidad;
import GUI.GUI;
import Hilo.HiloOleadas;
import Hilo.HiloPrincipal;
import Hilo.HiloSonido;
import Mapa.Mapa;
import Mapa.Nivel;

/**
 * Clase Juego .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Juego {
	protected int cantMonedas;
	public int VidaJugador;
	protected Mapa map;
	protected int puntaje;
	private HiloPrincipal tiempo;
	private HiloOleadas tiempo2;
	private HiloSonido tiempo3;
	private Nivel nivel;
	
	private int multiplicadorOro;

	private GUI gui;
	private LinkedList<Entidad> entidades;
	private LinkedList<Entidad> aEliminar;
	private LinkedList<Entidad> aAgregar;

	private static Juego instance;

	private Juego() {
		VidaJugador = 100;
		cantMonedas = 10000;
		puntaje = 0;
		multiplicadorOro = 1;
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
		nivel = Nivel.getInstance();
		entidades = new LinkedList<Entidad>();
		aAgregar = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();

		LogManager.getLogManager().reset();
		Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		globalLogger.setLevel(java.util.logging.Level.WARNING);

		tiempo = HiloPrincipal.getInstace();
		tiempo.start();
		tiempo2 = HiloOleadas.getInstace();
		tiempo2.start();
		tiempo3 = HiloSonido.getInstace();
		tiempo3.start();

	}

	public synchronized void Accionar() {
		if (!entidades.isEmpty()) {
			for (Entidad e1 : entidades) {
				if (!e1.estoyMuerto()) {
					boolean choco = false;
					for (Entidad e2 : entidades) {
						if (e1 != e2 && e1.chocan(e2) ) {
							e1.Aceptar(e2.getVisitor());
							choco = true;
						}
					}
					e1.Accionar();
					if (!choco) {
						e1.setEstado(1);
					}
				} else {
					e1.morir();
					aEliminar.addLast(e1);
				}
			}
		}

		if (!aAgregar.isEmpty()) {
			for (Entidad e : aAgregar) {
				if(e!=null) {
				 entidades.addFirst(e);
				 gui.actualizarEstadisticas(puntaje, cantMonedas,VidaJugador);
				 gui.agregarAlJuego(e.getGrafico(0));
				}
			}
			aAgregar = new LinkedList<Entidad>();
		}
		if (!aEliminar.isEmpty()) {
			for (Entidad e : aEliminar) {
				e.setGrafico(2);
				entidades.remove(e);
				cantMonedas = cantMonedas + e.getMonedas()*multiplicadorOro;
				puntaje = puntaje + e.getPuntaje();
				gui.actualizarEstadisticas(puntaje, cantMonedas,VidaJugador);
				gui.eliminarEntidad(e.getGrafico(2));
			}
			aEliminar = new LinkedList<Entidad>();
		}
	}

	/**
	 * 
	 */
	public void enemigoMuerto() {
		nivel.sumarEnemigosMuertos();
	}

	
	
	public void setMultiplicador(int m) {
		multiplicadorOro = m;
	}

	/**
	 * Agrega la entidad a la lista de entidades si el espacio donde se quiere
	 * agregar esta vacio(solo controla si agregar es falso) caso contrario obvia el
	 * contro y agrega la entidad.
	 * 
	 * @param Entidad e
	 * @param boolean agregar
	 */
	public synchronized void agregarEntidad(Entidad e, boolean agregar) {
		if (agregar)
			aAgregar.add(e);
		else {
			if (e != null) {
				if (map.puedoAgregar(e, entidades)) {
					aAgregar.add(e);
					cantMonedas -= e.getPrecioPersonaje();
				}
			}
		}
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

	public synchronized LinkedList<Entidad> getEntidades() {
		return entidades;
	}

	/**
	 * Suma o resta la vida del jugador
	 * 
	 * @param int i vida a sumar o restar
	 */
	public void setVida(int i, boolean sumar) {
		if (VidaJugador < 100 && sumar) {
			VidaJugador += i;
			if (VidaJugador > 100) {
				VidaJugador = 100;
			}
		} else {
			if (VidaJugador > 0 && !sumar) {
				VidaJugador -= i;
				if (VidaJugador <= 0) {
					this.terminarJuego(false);
				}
			}
		}
	}

	/**
	 * Termina el juego Si gane es verdadero llama a ganar, caso contrario llama a
	 * perder.
	 * 
	 * @param gane
	 */
	public void terminarJuego(boolean gane) {
		tiempo.setEjecutar(false);
		tiempo2.setEjecutar(false);
		tiempo3.setEjecutar(false);
		tiempo3.stopSoudtrack();
		aAgregar = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
		entidades = new LinkedList<Entidad>();
		if (!gane) {
			gui.perder();
		} else {
			gui.ganar();
		}
	}

	/**
	 * Controla si la entidad fue clickeada, en cuyo caso llama a fusteclikeado de
	 * la entidad
	 * 
	 * @param punto
	 */
	public synchronized void clickEnEntidades(Point punto) {
		for (Entidad e : entidades) {
			if (e.getRectangle().contains(punto))
				e.fuisteClickeado();
		}

	}

	/**
	 * Controla si la entidad fue clickeada, en cuyo caso agrega el campo sobre la
	 * entidad (solo si esta es un personaje)
	 * 
	 * @param punto
	 */
	public synchronized void clickEnJugadores(Point punto) {
		for (Entidad e : entidades)
			if (e.getRectangle().contains(punto))
				e.addCampo();
	}

}// Fin clase Juego
