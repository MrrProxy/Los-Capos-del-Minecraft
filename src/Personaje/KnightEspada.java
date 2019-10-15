package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

/**
 * Clase SteveOro que extiende de Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class KnightEspada extends Personaje {

	// Constructor
	public KnightEspada(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_KNIGHT_3.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ATTACK_KNIGHT_3.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_KNIGHT_3.gif"));
		this.imagen[3] = null;
		puntosVida = 50000;
		precioPersonaje = 300;
		danioImpacto=200;
	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
	}
	
}
