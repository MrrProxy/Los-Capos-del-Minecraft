package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Clase Araña que extiende de Enemigo.
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Araña extends Enemigo{

	//Constructor
	public Araña(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Running.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Running.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Running.gif"));
		this.imagen[3] = null;
		velocidad=6;
		puntosVida=10;
		monedas=10;
		puntaje=10;
	}

	@Override
	public void Aceptar() {
		// TODO Auto-generated method stub
		
	}
}
