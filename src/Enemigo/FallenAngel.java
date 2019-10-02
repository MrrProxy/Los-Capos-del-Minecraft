package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

/**
 * Clase Ender que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class FallenAngel extends Enemigo {
	
	//Constructor
	public FallenAngel(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_running.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_attack.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_die.gif"));
		this.imagen[3] = null;
		velocidad=6;
		puntosVida=1000;
		monedas=10;
		puntaje=10;
		this.danioImpacto = 5;
		velocidadInicial=velocidad;


	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
	}

}