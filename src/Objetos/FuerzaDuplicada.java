package Objetos;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entidad.Entidad;
import TiendaPersonaje.CProteccion;
import Visitor.VisitorPremio;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class FuerzaDuplicada extends Premio {

	public FuerzaDuplicada(Point p, int x, int y) {
		super(p, x, y);
		miVisitor = new VisitorPremio(this);
		puntosVida = 1;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/fuerza1.png"));
		// miVisitor = new VisitorFuerzaDuplicada(this);
		// duplica el daño de todos los personajes.

	}

	// por cada entidad de la lista le seteo un DanioDuplicado
	public void activarPowerUp() {
		for (Entidad e : juego.getEntidades()) {
			e.DanioDuplicado();
		}

		Timer timer = new Timer(4000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Entidad e1 : juego.getEntidades()) {
					e1.setDanio(e1.getDanio() / 2);
				}
			}
		});
		timer.start();

	}
	
	public void fuisteClickeado(){
		if (!activado){
			morir();
			CProteccion.getInstance().sumarContador();}
		
		}
}