package Disparos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DisparoTorre extends Disparo {
	
	public DisparoTorre(Point p, int x, int y, int daño, int alcance) {
		super(p,x,y);
		this.daño=daño;
		this.alcance=alcance;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Arrow.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Arrow.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Arrow.png"));
		this.imagen[3] = null;
		
		velocidad=10;

	}
	
	

	
	public ImageIcon obtenerGrafico(){
		return new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Arrow.png"));
	}

}
