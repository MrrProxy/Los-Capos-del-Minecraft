package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;
import Disparos.DisparoMago;
import Visitor.Visitor;

/**
 * Clase SteveDiamante que extiende de Personaje.
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class KnightLanza extends Personaje {

	// Constructor
	public KnightLanza(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_KNIGHT_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ATTACK_KNIGHT_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_KNIGHT_1.gif"));
		this.imagen[3] = null;
		puntosVida = 200;
		precioPersonaje = 300;
		danioImpacto=5;
		alcance=0;
	}

	// Devuelve la imagen grafica de la torre
	public ImageIcon obtenerGrafico() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Steve1.png"));
	}

	public DisparoMago disparar() {
		DisparoMago nuevo = new DisparoMago(new Point(pos.x + 50, pos.y), 46, 16, 15, 15);
		return nuevo;
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub

	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
	}
}
