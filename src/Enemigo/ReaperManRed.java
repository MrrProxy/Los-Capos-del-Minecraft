package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;
/**
 * Clase Araña que extiende de Enemigo.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class ReaperManRed extends Enemigo {

	// Constructor
	public ReaperManRed(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Running.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Attack.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Dying.gif"));
		this.imagen[3] = null;
		velocidad = 28;
		puntosVida = 1000;
		monedas = 10;
		puntaje = 10;
		velocidadInicial=velocidad;

	}

	public void setGrafico(int dir){
		if(this.grafico != null){
			if(dir==2) {
				this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Dying.gif"));
			}
			this.grafico.setIcon(this.imagen[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}
}
