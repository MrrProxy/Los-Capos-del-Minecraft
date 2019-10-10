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

	/**
	 * Devuelve verdadero si las entidades colisionan, caso contrario falso.
	 * 
	 * @param e1 entidad1
	 * @param e2 entidad2
	 * @return verdadero si colisionan, caso contrario falso.
	 */
	public boolean chocan(Entidad e1, Entidad e2) {

		boolean colisionan=false;
		boolean salida=false;
		Rectangle rectangle = e1.getRectangle();
		Rectangle rectangle2 = e2.getRectangle();
		colisionan=rectangle.intersects(rectangle2);
		if(rectangle2.x<rectangle.x && colisionan)//Controlo si choca adelante
			salida=true;
			

		return salida;
	}
	

}
