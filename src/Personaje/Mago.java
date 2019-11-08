package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;
import Disparos.DisparoMago;
import Juego.Juego;
import Sonidos.sonidosMp3;
import Visitor.Visitor;

/**
 * Clase Mago que extiende de Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Mago extends Personaje {
	sonidosMp3 mp3;
	// Constructor
	public Mago(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_MAGO_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ATTACK_MAGO_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_MAGO_1.gif"));
		this.imagen[3] = null;
		puntosVida = 1000;
		precioPersonaje = 4000;
		danioImpacto=200;
		alcance=500;
		tiempoRealDisparos=30;
		 mp3=new sonidosMp3();
	}

	public void Accionar() {
		Juego juego = Juego.getInstance();
		if (tiempoEntreDisparo == 0) {
			Point point = new Point(this.getPosition());
			disparo = new DisparoMago(point, 50, 50, danioImpacto, alcance);
			juego.agregarEntidad(disparo,true);
			tiempoEntreDisparo = tiempoRealDisparos;
			mp3.abrirArchivo("battle015");

		}
		tiempoEntreDisparo--;

	}

	@Override
	public void morir() {

	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
	}

}
