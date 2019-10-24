package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase Ender que extiende de Enemigo.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Goblin extends Enemigo {

	public Goblin(Point p, int x, int y) {
		super(p, x, y);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/WALKING_GOBLIN_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ATTACK_GOBLIN_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/DYING_GOBLIN_1.gif"));
		this.imagen[3] = null;
		velocidad = 8;
		velocidad = 10;
		puntosVida = 1000;
		monedas = 10;
		puntaje = 10;
		danioImpacto=5;
		velocidadInicial=velocidad;

	}

}
