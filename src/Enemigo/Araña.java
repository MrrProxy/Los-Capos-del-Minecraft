package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase Araña que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Araña extends Enemigo{

	//Constructor
	public Araña(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}
	
	//Devuelve el grafico del enemigo
	public ImageIcon obtenerGrafico(){
		return new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/Araña.jpg"));
	}

}
