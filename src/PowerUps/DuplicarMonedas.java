package PowerUps;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Entidad.Entidad;
import TiendaPersonaje.MDuplicada;
import Visitor.VisitorPremio;

public class DuplicarMonedas extends Premio{

	public DuplicarMonedas(Point p, int x, int y) {
		super(p, x, y);
		miVisitor = new VisitorPremio(this);
		puntosVida=1;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Campo.png"));
		// TODO Auto-generated constructor stub
	}
	
	public void activarPowerUp() {
		for (Entidad e1 : juego.getEntidades()) {
			
			}
		//juego.setMultiplicador(2);
		 Timer timer = new Timer(4000, new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				    
			    }
		    });
		    timer.start();
	}
	public void fuisteClickeado(){
		if (!activado){
			morir();
			MDuplicada.getInstance().sumarContador();}
		
		}
		// TODO Auto-generated constructor stub
}
	
	


