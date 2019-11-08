package Disparos;

import java.awt.Point;
import javax.swing.ImageIcon;

import Visitor.Visitor;

public class DisparoArquero extends Disparo {

	//Constructor
	public DisparoArquero(Point p, int x, int y, int da�o, int alcance) {
		super(p, x, y);
		danioImpacto = da�o;
		this.alcance = this.pos.x + alcance;
		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/flecha.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/flecha.png"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		puntosVida = 1;
		velocidad = 10;

	}

	public void Accionar() {
		this.pos.x += velocidad;
		setGrafico(MOVIMIENTO);
		if (this.pos.x >= alcance) {
			this.morir();
		}
	}

	@Override
	public void morir() {
		this.puntosVida = 0;
	}

	@Override
	public void Aceptar(Visitor v) {
		v.afectar(this);
	}


}
