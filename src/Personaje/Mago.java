package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;
import Disparos.DisparoMago;
import Juego.Juego;
import Visitor.Visitor;

/**
 * Clase Mago que extiende de Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Mago extends Personaje {
	
	//Constructor
	public Mago(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_MAGO_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_MAGO_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_MAGO_1.gif"));
		this.imagen[3] = null;
		puntosVida=200;
		precioPersonaje=600;
	}
	
	public void Accionar() {
		Juego juego = Juego.getInstance();
		if (tiempoEntreDisparo == 0) {
			Point point = new Point(this.getPosition());
			point.x =(int) (point.getX()+this.anchoEntidad());
			disparo = new DisparoMago(point, 50, 50, 50, 200);
			juego.agregarEntidad(disparo);
			tiempoEntreDisparo = 30;
			//sonidos.playSoundEffect("sound1");
			//
		} 
			tiempoEntreDisparo--;

	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
