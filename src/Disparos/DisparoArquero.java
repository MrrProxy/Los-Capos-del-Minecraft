package Disparos;

import java.awt.Point;
import javax.swing.ImageIcon;

public class DisparoArquero extends Disparo{
	
	public DisparoArquero(Point p, int x, int y, int da�o, int alcance) {
		super(p,x,y);
		this.da�o=da�o;
		this.alcance=alcance;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/DisparoMago.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/DisparoMago.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Arrow.png"));
		this.imagen[3] = null;
		
		velocidad=1;

	}
	
	public void mover() {
		this.pos.x+=velocidad;
		setGrafico(2);
	}

}
