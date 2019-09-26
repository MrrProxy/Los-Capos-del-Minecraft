package Disparos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class DisparoMago extends Disparo {
	
	public DisparoMago(Point p, int x, int y, int daño, int alcance) {
		super(p,x,y);
		this.daño=daño;
		this.alcance=alcance;
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
	}
	@Override
	public void morir() {
		
	}
}
