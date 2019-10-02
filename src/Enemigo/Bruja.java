package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

/**
 * Clase Bruja que extiende de Enemigo.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Bruja extends Enemigo {

	public Bruja(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemPiedra_Running.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemPiedra_Running.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemPiedra_Running.gif"));
		this.imagen[3] = null;
		velocidad = 6;
		puntosVida = 10000;
		monedas = 10;
		puntaje = 10;
		velocidadInicial=velocidad;


	}

	public void Aceptar(Visitor v) {
		v.afectar(this);

	}
}
