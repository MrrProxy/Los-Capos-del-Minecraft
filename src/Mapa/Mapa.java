package Mapa;

import java.util.LinkedList;

import Entidad.Entidad;
import Juego.Juego;

/**
 * Clase Mapa.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Mapa {

	// Atributos mapa
	private LinkedList<Entidad> entidades;
	private Juego juego;

	// Constructor
	public Mapa() {
		juego.getInstance();
	}

	public void colocar() {

	}

	public boolean puedoAgregar(Entidad entidad) {
		boolean toReturn = true;
		for (Entidad e : entidades) {
			if (chocan(e, entidad))
				toReturn = false;

		}
		return toReturn;
	}

	private boolean chocan(Entidad e1,Entidad e2) {
		return true;

	}

}
