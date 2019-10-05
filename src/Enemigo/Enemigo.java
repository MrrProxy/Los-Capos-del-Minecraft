package Enemigo;

import java.awt.Point;

import Entidad.Entidad;
import Visitor.VisitorEnemigo;

/**
 * Clase abstracta Enemigo.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */

public abstract class Enemigo extends Entidad {

	// Atributos especificos de un enemigo
	protected int puntaje;
	protected int velocidadInicial;

	// Constructor
	protected Enemigo(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		miVisitor = new VisitorEnemigo(this);

	}

	/**
	 * Devuelve la velocidad de desplazamiento de la entidad.
	 * 
	 * @return velocidad de desplazamiento de la entidad.
	 */
	public int getVelocidad() {
		return velocidad;
	}

	public int getVelocidadInicial() {
		return velocidadInicial;
	}

	/**
	 * Establece la velocidad de desplazamiento de la entidad por la recibida como
	 * parametro.
	 * 
	 * @param v velocidad a establecer.
	 */
	public void setVelocidad(int v) {
		velocidad = v;
	}

	/**
	 * Produce el movimiento de los enemigos
	 * 
	 * @param v velocidad con la que se desplaza el enemigo
	 */
	public void Accionar() {
			if (puedoAvanzar){
				Point point = new Point(this.getPosition().x - velocidad, this.getPosition().y);	
				pos = point;
			}
			setGrafico(graficoActual);
		
	}

	public void morir() {
		puntosVida = 0;

	}

	public int getPuntaje() {
		return puntaje;
	}

}
