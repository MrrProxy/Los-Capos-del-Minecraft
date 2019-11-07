package Mapa;

import java.awt.Rectangle;
import java.util.LinkedList;

import Entidad.Entidad;

/**
 * Clase Mapa.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Mapa {

	// Constructor
	public Mapa() {
	}

	/**
	 * Controla si la entidad pasada por parametro colisiona con otra entidad, de la
	 * lista de entidades.
	 * 
	 * @param entidad
	 * @param listaEntidades
	 * @return boolean toReturn
	 */
	public boolean puedoAgregar(Entidad entidad, LinkedList<Entidad> listaEntidades) {
		boolean toReturn = true;
		Rectangle rectangle = entidad.getRectangle();
		Rectangle rectangle2;
		for (Entidad e : listaEntidades) {
			rectangle2 = e.getRectangle();
			if (rectangle.intersects(rectangle2)) {
				toReturn = false;
			}
		}
		return toReturn;
	}

}
