package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase SteveDiamante que extiende de Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class SteveDiamante extends Personaje {
	
	//Constructor
	public SteveDiamante(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Steve1.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Steve1.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Steve1.png"));
		this.imagen[3] = null;
		velocidad=0;
	}

	//Devuelve la imagen grafica de la torre
	public ImageIcon obtenerGrafico() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Steve1.png"));
	}
}
