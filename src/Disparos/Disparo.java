package Disparos;

import java.awt.Point;
import Entidad.Entidad;

public abstract class Disparo extends Entidad {
	protected int daño;
	protected int alcance;
	
	
	protected Disparo(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}
	
	public void Accionar() {
		pos.x+=velocidad;
		setGrafico(1);
	}



}
