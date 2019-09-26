package Disparos;

import java.awt.Point;
import javax.swing.ImageIcon;

public class DisparoArquero extends Disparo{
	
	public DisparoArquero(Point p, int x, int y, int daño, int alcance) {
		super(p,x,y);
		this.daño=daño;
		this.alcance=alcance;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/flecha.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/flecha.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/flecha.png"));
		this.imagen[3] = null;
		puntosVida=1;
		velocidad=10;

	}
	
	public void Accionar() {
		this.pos.x+=velocidad;
		setGrafico(2);
	}

	@Override
	public void morir() {
		
	}

}
