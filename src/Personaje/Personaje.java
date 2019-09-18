package Personaje;

import java.awt.Point;

import Disparos.Disparo;
import Disparos.DisparoTorre;
import Entidad.Entidad;
import Juego.Juego;

/**
 * Clase abstracta Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public abstract class Personaje extends Entidad {

	// Atributos especificos de un Personaje
	protected int alcance; // cuantos cuadros de alcance tiene
	protected int tiempoEntreDisparo=0;
	protected Disparo disparo;

	// Constructor
	protected Personaje(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}

	public void Accionar() {
		Juego juego = Juego.getInstance();
		if (tiempoEntreDisparo == 0) {
			Point point=new Point(this.obtenerPosicion());
			disparo = new DisparoTorre(point, 50, 50, 50, 50);
			juego.addDisparoJugador(disparo);
			juego.agregarGrafica(disparo);
			for(Disparo d :juego.obtenerDisparos()) {
				d.mover();
			}
			//System.out.println("Entre en personaje "+tiempoEntreDisparo+" "+juego.obtenerDisparos().size()+" pos "+this.obtenerPosicion());
			tiempoEntreDisparo = 20;
		} else {
			tiempoEntreDisparo--;
			for(Disparo d :juego.obtenerDisparos()) {
				d.mover();
			}	
	}
}
}
