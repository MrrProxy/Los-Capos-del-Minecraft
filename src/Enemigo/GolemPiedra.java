package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;


/**
 * Clase Bruja que extiende de Enemigo.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class GolemPiedra extends Enemigo {

	public GolemPiedra(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemPiedra_Running.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemPiedra_Attack.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemPiedra_Dying.gif"));
		this.imagen[3] = null;
		velocidad = 6;
		puntosVida = 1000;
		monedas = 10;
		puntaje = 10;
		velocidadInicial=velocidad;


	}
}
