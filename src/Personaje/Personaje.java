package Personaje;

import java.awt.Point;

import Disparos.Disparo;
import Entidad.Entidad;
import PowerUps.*;
import Visitor.VisitorPersonaje;

/**
 * Clase abstracta Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public abstract class Personaje extends Entidad {

	// Atributos especificos de un Personaje
	//protected int alcance; // cuantos cuadros de alcance tiene
	protected int tiempoEntreDisparo = 0;
	protected int tiempoRealDisparos;
	protected Disparo disparo;

	// Constructor
	protected Personaje(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		miVisitor= new VisitorPersonaje(this);
	}
	
	public void setTiempoDisparo(int t){
		tiempoRealDisparos=t;
	}
	
	public int getTiempoDisparos(){
		return tiempoRealDisparos;
	}

	public void Accionar() {
	}
	
	public void addCampo(){
		Point nuevoPunto= new Point((pos.x-5),pos.y);
		CampoProteccionActivado campo= new CampoProteccionActivado(nuevoPunto,80,80);
		juego.agregarEntidad(campo, true);
	}
	
	public void DanioDuplicado() {
		danioImpacto = danioImpacto*2;
		
	}
	
}
