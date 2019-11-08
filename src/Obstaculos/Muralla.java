package Obstaculos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Muralla extends Obstaculo {

	public Muralla(Point p, int width, int height) {
		super(p, width, height);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/lava.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/lava.png"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		puntosVida=1000;
		danioImpacto=0;
	}

	public void Accionar() {
		
	}


}
