package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase Ender que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Ender extends Enemigo {
	
	//Constructor
	protected Ender(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}
	
	//Devuelve el grafico del enemigo
	public ImageIcon obtenerGrafico(){
		return new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/Ender.jpg"));
	}
	

}
