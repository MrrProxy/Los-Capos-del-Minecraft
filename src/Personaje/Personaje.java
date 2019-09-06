package Personaje;

import java.awt.Point;

import Entidad.Entidad;

/**
 * Clase abstracta Personaje.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public abstract class Personaje extends Entidad {
	
	//Atributos especificos de un Personaje
	protected int alcance; //cuantos cuadros de alcance tiene
	protected int precioPersonaje;
	
	//Constructor
	protected Personaje(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}
	

}
