package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;
import Visitor.VisitorEnemigo;
import Visitor.VisitorEnemigoSuicida;


/**
 * Clase Esqueleto que extiende de Enemigo.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class ReaperMan extends Enemigo {

	// Constructor
	public ReaperMan(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperMan_Running.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperMan_Attack.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/Explosion.gif"));
		this.imagen[3] = null;
		velocidad = 26;
		puntosVida = 1000;
		monedas = 10;
		puntaje = 10;
		danioImpacto=200;
		velocidadInicial=velocidad;
		miVisitor = new VisitorEnemigoSuicida(this);

	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
	}
}