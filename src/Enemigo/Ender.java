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
	public Ender(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_running.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_running.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_running.gif"));
		this.imagen[3] = null;
		velocidad=6;
		puntosVida=10;
		monedas=10;

	}

}
