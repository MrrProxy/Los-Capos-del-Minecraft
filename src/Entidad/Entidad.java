package Entidad;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase abstracta Entidad.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public abstract class Entidad {
	
	//Atributos especificos de una entidad
	protected int puntosVida;
	protected int ancho;
	protected int alto;
	protected Point pos;
	protected int danioImpacto;

	

	// constructor
	protected Entidad(Point p, int ancho, int alto) {
		pos = p;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public Point obtenerPosicion(){
		return pos;
	}
	
	public abstract ImageIcon obtenerGrafico();
	
}
