package PowerUps;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Entidad.Entidad;
import TiendaPersonaje.VelocidadDuplicada;
import Visitor.VisitorPremio;

public class DuplicarVelocidadAtaque extends Premio{

	public DuplicarVelocidadAtaque(Point p, int x, int y) {
		super(p, x, y);
		miVisitor = new VisitorPremio(this);
		puntosVida=1;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/VelocidadAtaque.png"));
		// TODO Auto-generated constructor stub
	}
	
	public void activarPowerUp() {
		for (Entidad e1 : juego.getEntidades()) {
				e1.setTiempoDisparo(e1.getTiempoDisparos()/2);
			}
		//juego.setMultiplicador(2);
		 Timer timer = new Timer(10000, new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				    for (Entidad e1 : juego.getEntidades())
				    	e1.setTiempoDisparo(e1.getTiempoDisparos()*2);
			    }
		    });
		    timer.start();
	}
	public void fuisteClickeado(){	
			System.out.println("entre40");
			morir();
			VelocidadDuplicada.getInstance().sumarContador();
	}
		// TODO Auto-generated constructor stub
}
	
	


