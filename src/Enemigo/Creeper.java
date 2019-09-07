package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase Creeper que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Creeper extends Enemigo {
	
	protected Creeper(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}
	
	public ImageIcon obtenerGrafico(){
		return new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/Creeper.jpg"));
	}

}
