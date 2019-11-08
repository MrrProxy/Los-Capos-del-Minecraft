package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;
/**
 * Clase Ender que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class FallenAngel extends Enemigo {
	
	//Constructor
	public FallenAngel(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		
		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_running.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_attack.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_die.gif"));
		this.imagen[3] = null;
		velocidad=5;
		puntosVida=5000;
		monedas=2000;
		DañoAJugador=15;
		puntaje=40;
		this.danioImpacto = 40;
		velocidadInicial=velocidad;

	}

}
