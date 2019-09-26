package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase Ender que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Zombie extends Enemigo {

	

	public Zombie(Point p, int x, int y) {
		super(p, x, y);
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/WALKING_GOBLIN_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/WALKING_GOBLIN_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/WALKING_GOBLIN_1.gif"));
		this.imagen[3] = null;
		velocidad=1;
		puntosVida=10;
		monedas=10;

		
	}

}
