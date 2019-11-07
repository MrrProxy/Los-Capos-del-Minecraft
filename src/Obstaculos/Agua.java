package Obstaculos;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class Agua extends ObstaculoTemporal{
	
	
	public Agua(Point p, int x, int y){
		super(p,x,y);
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/lava.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/lava.png"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		puntosVida=100;
		danioImpacto=5;

	}
	
	public void Aceptar(Visitor v) {
		v.afectar(this);
	}

	public void Accionar() {
		
	}

}

