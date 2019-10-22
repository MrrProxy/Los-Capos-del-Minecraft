package Objetos;

import java.awt.Point;
import java.awt.Rectangle;

public class Bomba extends Premio {

	public Bomba(Point p, int x, int y) {
		super(p, x, y);
		// TODO Auto-generated constructor stub
		puntosVida=1;
		danioImpacto =10000;
		
	}
	public void explotar() {
		Rectangle r = this.getRectangle();
		int nuevoX = (int) r.getCenterX();
		int nuevoY = (int) r.getCenterY();
		pos = new Point (nuevoX, nuevoY);
		width = width*3;
		height = height*3;
		
	}

}
