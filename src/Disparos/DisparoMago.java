package Disparos;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class DisparoMago extends Disparo {
	
	public DisparoMago(Point p, int ancho, int alto, int da�o, int alcance) {
		super(p,ancho,alto);
		this.da�o=da�o;
		this.alcance=alcance+this.pos.x;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/DisparoMago.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/DisparoMago.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/DisparoMago.gif"));
		this.imagen[3] = null;
		puntosVida=1;
		velocidad=6;

	}
	public void Accionar() {
		this.pos.x+=velocidad;
		setGrafico(1);
		if(this.pos.x>=this.alcance)
			this.morir();
	}
	@Override
	public void morir() {
		this.puntosVida=0;
	}
	@Override
	public void Aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}
}
