package Obstaculos;

import java.awt.Point;

import Visitor.Visitor;
import Visitor.VisitorObstaculoTemporal;

public class ObstaculoTemporal extends Obstaculo{

	protected int tiempo;
	protected int slow;
	
	public ObstaculoTemporal(Point p, int width, int height) {
		super(p, width, height);
		miVisitor=new VisitorObstaculoTemporal(this);
		danioImpacto=5;
		slow=0;
	}

	public void Accionar() {
		tiempo++;
		if(tiempo==500) {
			this.setGrafico(MUERTE);
			this.morir();
		}
	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
	}
	
	public int getSlow() {
		return slow;
	}
	
}

