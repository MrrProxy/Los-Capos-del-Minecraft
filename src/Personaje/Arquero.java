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
	boolean disparar;

	// Constructor
	public Arquero(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_ARQUERO_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_ARQUERO_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_ARQUERO_1.gif"));
		this.imagen[3] = null;
		puntosVida = 200;
		precioPersonaje = 300;
		danioImpacto = 5;
		alcance = 350;
		disparar = false;
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

	@Override
	public void morir() {
	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
	}

//	public boolean chocan(Entidad e2) {
//		boolean colisionan=false;
//		Rectangle rectangle = new Rectangle(this.getPosition().x, this.getPosition().y,this.anchoEntidad() + this.alcance, this.altoEntidad());
//		Rectangle rectangle2 = e2.getRectangle();
//		if(rectangle.x +alcance<=rectangle2.x && rectangle.y==rectangle2.y) {
//			colisionan=true;
//		}
//		if (colisionan) {
//			disparar();
//		}
//		disparar = colisionan;
//		return colisionan;
//	}
//
//	public void disparar() {
//		Juego juego = Juego.getInstance();
//		if (tiempoEntreDisparo == 0 ) {
//			Point point = new Point(this.getPosition());
//			disparo = new DisparoArquero(point, 50, 50, danioImpacto, alcance);
//			juego.agregarEntidad(disparo, true);
//			tiempoEntreDisparo = 20;
//		}
//		tiempoEntreDisparo--;
//	}

}
