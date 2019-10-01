package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase SteveHierro que extiende de Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class KnightHacha extends Personaje {
	
	//Constructor
	public KnightHacha(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_KNIGHT_2.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_KNIGHT_2.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_KNIGHT_2.gif"));
		this.imagen[3] = null;
		puntosVida=200;	
		precioPersonaje=300;
	
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Aceptar() {
		// TODO Auto-generated method stub
		
	}


}
