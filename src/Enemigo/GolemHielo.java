package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;


/**
 * Clase Creeper que extiende de Enemigo.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class GolemHielo extends Enemigo {

	// Constructor
	public GolemHielo(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemHielo_Running.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemHielo_Attack.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemHielo_Dying.gif"));
		this.imagen[3] = null;
		velocidad = 5;
		puntosVida = 800;
		monedas = 300;
		puntaje = 5;
		danioImpacto=5;
		DaņoAJugador=2;
		velocidadInicial=velocidad;


	}


}
