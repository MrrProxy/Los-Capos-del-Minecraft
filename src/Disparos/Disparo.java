package Disparos;

import java.awt.Point;
import Entidad.Entidad;
import Visitor.VisitorDisparo;

public abstract class Disparo extends Entidad {
	protected int daño;
	protected int alcance;
	
	
	protected Disparo(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		miVisitor=new VisitorDisparo(this);
	}
	
	public void mover() {
	}



}
