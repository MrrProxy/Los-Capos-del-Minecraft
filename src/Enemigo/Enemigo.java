package Enemigo;

import java.awt.Point;

import Entidad.Entidad;

/**
 * Clase abstracta Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */

public abstract class Enemigo extends Entidad {
	
	//Atributos especificos de un enemigo
	protected int velocidad;
	
	//Constructor
		protected Enemigo(Point p, int ancho , int alto) {
			super(p, ancho, alto);
		}
		
		
		
		

}
