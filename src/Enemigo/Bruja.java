package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase Bruja que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Bruja extends Enemigo {
	
	protected Bruja(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}
	
	public ImageIcon obtenerGrafico(){
		return new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/Bruja.jpg"));
	}


}
