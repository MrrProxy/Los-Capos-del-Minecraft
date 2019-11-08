package Objetos;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import TiendaPersonaje.Bombas;
import TiendaPersonaje.CProteccion;
import Visitor.VisitorPremio;

public class Bomba extends Premio {

	public Bomba(Point p, int x, int y) {
		super(p, x, y);
		miVisitor = new VisitorPremio(this);
		puntosVida=1;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Bomb.png"));
		
	}
	
	public void fuisteClickeado(){
		if (!activado){
			morir();
			Bombas.getInstance().sumarContador();
		}
		
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
