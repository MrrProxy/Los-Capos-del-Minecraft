package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase SteveHierro que extiende de Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class SteveHierro extends Personaje {
	
	//Constructor
	public SteveHierro(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}

	// Devuelve la imagen grafica de la torre
	public ImageIcon obtenerGrafico() {
		return new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/Bruja.jpg"));
	}

}
