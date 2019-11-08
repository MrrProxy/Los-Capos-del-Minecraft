package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;
/**
 * Clase Araña que extiende de Enemigo.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class ReaperManRed extends Enemigo {

	// Constructor
	public ReaperManRed(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Running.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Attack.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Dying.gif"));
		this.imagen[3] = null;
		velocidad = 5;
		puntosVida = 2000;
		monedas = 10;
		puntaje = 10;
		danioImpacto=35;
		DañoAJugador=10;
		velocidadInicial=velocidad;

	}
}
