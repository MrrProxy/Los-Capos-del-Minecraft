package Enemigo;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import Entidad.Entidad;
import Mapa.Nivel;
import PowerUps.*;
import Visitor.Visitor;
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
	protected Nivel nivel;// Es necesario para actualizar las muertes
	protected int Da�oAJugador;//Da�o que produce cada enemigo al pasar

	// Constructor
	protected Enemigo(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		miVisitor = new VisitorEnemigo(this);
		nivel = Nivel.getInstance();
		estado=1;
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
	public void Slow(int v) {
		if(velocidad==velocidadInicial) {
			velocidad-=v;
			if(velocidad<=0) {
				velocidad=1;
			}
		}
	}

	public Rectangle getRectangle() {
		return new Rectangle(this.getPosition().x - this.velocidad, this.getPosition().y, this.anchoEntidad(),
				this.altoEntidad());
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
		if (estado == 1) {
			Point point = new Point(this.getPosition().x - velocidad, this.getPosition().y);
			pos = point;
			velocidad=velocidadInicial;
			setGrafico(0);
			if (this.getPosition().x < -100) {
				this.puntosVida = 0;
				juego.setVida(Da�oAJugador, false);
			}
		}
	}

	public void morir() {
		juego.enemigoMuerto();
		Random rnd = new Random();
		int posibilidad = rnd.nextInt(5);
		if (posibilidad == 1) { // posibilidad puede ser 0,1,2,3,4. Quiero un 20% prob de soltar premio
			generarPowerUp();
		}

	}

	/**
	 * Genera un power up random
	 * @return Premio nuevoPremio
	 */
	private Premio generarPowerUp() {
	
		Premio nuevoPremio = null;
		Random rnd = new Random();
		int premioElegido = rnd.nextInt(5);
		switch (premioElegido) {
		case 0:
			nuevoPremio = new CampoProteccion(pos,80,80);
			break;
		case 1:
			nuevoPremio = new Bomba(pos, 70, 70);
			break;
		case 2:
			nuevoPremio = new DuplicarVelocidadAtaque(pos,70, 70);
			break;
		case 3:
			nuevoPremio = new Temporizador(pos, 40, 39);
			break;
		case 4:
			nuevoPremio = new FuerzaDuplicada(pos, 40, 39);
			break;
		}
		
		juego.agregarEntidad(nuevoPremio, true);
		return nuevoPremio;
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
	}

	public boolean chocan(Entidad e2) {

		boolean colisionan = false;
		boolean salida = false;
		Rectangle rectangle = this.getRectangle();
		Rectangle rectangle2 = e2.getRectangle();
		colisionan = rectangle.intersects(rectangle2);
		if (rectangle2.x < rectangle.x && colisionan) {// Controlo si choca adelante
			salida = true;
		}
		return salida;
	}
	
	public void detener(boolean d){
		if (d)
			velocidad=0;
		else{
			velocidad=velocidadInicial;
		}
	}

}
