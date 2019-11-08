package Personaje;

import java.awt.Point;
import javax.swing.ImageIcon;
import Disparos.DisparoArquero;
import Juego.Juego;
import Visitor.Visitor;

/**
 * Clase Arquero que extiende de Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 */
public class Arquero extends Personaje {

	// Constructor
	public Arquero(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_ARQUERO_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_ARQUERO_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_ARQUERO_1.gif"));
		this.imagen[3] = null;
		puntosVida = 1000;
		precioPersonaje = 1000;
		danioImpacto = 40;
		alcance = 350;
		tiempoRealDisparos=20;
	}

	public void Accionar() {
		Juego juego = Juego.getInstance();
		if (tiempoEntreDisparo == 0 ) {
			Point point = new Point(this.getPosition());
			disparo = new DisparoArquero(point, 50, 50, danioImpacto, alcance);
			juego.agregarEntidad(disparo, true);
			tiempoEntreDisparo = tiempoRealDisparos;
		}
		tiempoEntreDisparo--;

	}

	public void morir() {
	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
	}


}
