package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase Creeper que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Creeper extends Enemigo {
	
	//Constructor
	protected Creeper(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}
	
	//Devuelve el grafico del enemigo
	public ImageIcon obtenerGrafico(){
		return new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/Creeper.jpg"));
	}

}
