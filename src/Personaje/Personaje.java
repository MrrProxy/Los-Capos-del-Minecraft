package Personaje;

import java.awt.Point;

import Disparos.Disparo;
import Entidad.Entidad;
import Visitor.VisitorPersonaje;

/**
 * Clase abstracta Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public abstract class Personaje extends Entidad {

	// Atributos especificos de un Personaje
	protected int alcance; // cuantos cuadros de alcance tiene
	protected int tiempoEntreDisparo = 0;
	protected Disparo disparo;

	// Constructor
	protected Personaje(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		miVisitor= new VisitorPersonaje(this);
	}

	public void Accionar() {
	}
	
	
}
