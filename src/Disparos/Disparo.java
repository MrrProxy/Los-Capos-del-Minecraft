package Disparos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Entidad;

public abstract class Disparo extends Entidad {
	
	protected Disparo(Point p, int ancho, int alto) {
		super(p, ancho, alto);
	}

	protected int daño;
	protected int alcance;
	
	public abstract ImageIcon obtenerGrafico();

}
