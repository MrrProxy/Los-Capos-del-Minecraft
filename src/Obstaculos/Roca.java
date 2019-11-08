package Obstaculos;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class Roca extends Obstaculo{

	public Roca(Point p, int width, int height) {
		super(p, width, height);
		puntosVida=10;
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/roca.jpg"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/roca.jpg"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		
		
	}

	public void Accionar() {
		
	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
		
	}

}
