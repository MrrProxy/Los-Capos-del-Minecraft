package Juego;

import java.util.LinkedList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

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
	protected int cantMonedas;
	public int VidaJugador;
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
		VidaJugador= 100;
		cantMonedas=1000;
		puntaje=0;
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
		
		LogManager.getLogManager().reset();
		Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		globalLogger.setLevel(java.util.logging.Level.WARNING);

		tiempo = HiloPrincipal.getInstace();
		//tiempo.setEjecutar(true);
		tiempo.start();
		tiempo2 = HiloOleadas.getInstace();
		tiempo2.start();

	}

	public synchronized void Accionar() {
		if (!entidades.isEmpty()) {
			for (Entidad e1 : entidades) {
				if (e1.getVida() > 0) {
					boolean choco = false;
					for (Entidad e2 : entidades) {
						if (e1 != e2 && e1.chocan(e2)) {
							e1.Aceptar(e2.getVisitor());
								choco = true;
						}
					}
					if(!choco) {
						e1.Accionar();
					}
				} else {
					e1.morir();
					aEliminar.addLast(e1);
				}
			}
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
				gui.eliminarEntidad(e.getGrafico(0));
			}
			aEliminar = new LinkedList<Entidad>();
		}

	}

	public void agregarEntidad(Entidad e, boolean agregar) {
		if (agregar)
			aAgregar.add(e);
		else {
			if (e != null) {
				if (map.puedoAgregar(e, entidades)) {
					aAgregar.add(e);
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
	 * @return puntaje
	 */
	public int getPuntaje() {
		return cantMonedas;
	}

	/**
	 * Actualiza el puntaje
	 * @param puntaje
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public LinkedList<Entidad> getEntidades() {
		return entidades;
	}
	
	/**Suma o resta la vida del jugador
	 * 
	 * @param int i vida a sumar o restar
	 */
	public void setVida(int i,boolean sumar) {
		if(VidaJugador<100 && sumar) {
			VidaJugador+=i;
			if(VidaJugador>100) {
				VidaJugador=100;
			}
		}
		else {
			if(VidaJugador>0 && !sumar) {
				VidaJugador-=i;
				if(VidaJugador<=0) {
					this.terminarJuego(false);
				}
				
			}
		}
		
	}
	
	//Termina el juego
	public void terminarJuego(boolean gane) {
		tiempo.setEjecutar(false);
		tiempo2.setEjecutar(false);
		aAgregar=new LinkedList<Entidad>();
		aEliminar=new LinkedList<Entidad>();
		entidades=new LinkedList<Entidad>();
		if(!gane) {
			gui.ganar();
		}
		else {
			gui.ganar();
		}
	}


}// Fin clase Juego
