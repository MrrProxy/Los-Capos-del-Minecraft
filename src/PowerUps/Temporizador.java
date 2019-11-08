package PowerUps;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Entidad.Entidad;

import TiendaPersonaje.Temp;
import Visitor.VisitorPremio;

public class Temporizador extends Premio{

	public Temporizador(Point p, int x, int y) {
		super(p, x, y);
		puntosVida = 1;
		miVisitor = new VisitorPremio(this);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/reloj.png"));
		
	}
	//setea la velocidad de todos los enemigos a 0 por un tiempo.
	public void activarPowerUp() {
		for (Entidad e1 : juego.getEntidades()) {
			e1.detener(true);
		}

		 
		 Timer timer = new Timer(4000, new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				    for (Entidad e1 : juego.getEntidades()) {
					    e1.detener(false);
				    }
			    }
		    });
		    timer.start();
	}
	
	public void fuisteClickeado(){
		if (!activado){
			morir();
			Temp.getInstance().sumarContador();}
		
		}
}
