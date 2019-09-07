package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase Ara�a que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Ara�a extends Enemigo{

	protected Ara�a(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}
	
	public ImageIcon obtenerGrafico(){
		return new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/Ara�a.jpg"));
	}

}
