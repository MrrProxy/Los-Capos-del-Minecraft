package Personaje;

import java.awt.Point;

import Disparos.Disparo;
import Entidad.Entidad;
import Visitor.VisitorPersonaje;
import Objetos.*;

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
	
	public void addCampo(){
		Point nuevoPunto= new Point((pos.x-5),pos.y);
		CampoProteccion campo= new CampoProteccion(nuevoPunto,80,80);
		campo.setActivado(true);
		juego.agregarEntidad(campo, true);
	}
	
	public void DanioDuplicado() {
		danioImpacto = danioImpacto*2;
		
	}
	
}
