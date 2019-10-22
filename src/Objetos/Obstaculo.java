package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

import Entidad.Entidad;
import Visitor.Visitor;
import Visitor.VisitorObstaculo;

public class Obstaculo extends Entidad {
	
	public Obstaculo(Point p, int x, int y){
		super(p,x,y);
		puntosVida=10;
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/roca.jpg"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/roca.jpg"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		
		miVisitor = new VisitorObstaculo(this);
	}

	@Override
	public void Accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Aceptar(Visitor v) {
		v.afectar(this);
		
	}

}
