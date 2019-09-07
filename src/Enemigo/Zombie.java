package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Zombie extends Enemigo {

	public Zombie(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}
	
	public ImageIcon obtenerGrafico(){
		return new ImageIcon(this.getClass().getResource("/Imagenes/Mapa/Zombie.jpg"));
	}
	
	
	

}
