package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.Premio;

public class VisitorObstaculo extends Visitor{
	
	public VisitorObstaculo(Obstaculo o){
		super(o);
	}

	public void afectar(Personaje p) {
		
	}

	public void afectar(Enemigo e) {
		
	}

	public void afectar(Disparo d) {
		
	}


	public void afectar(Premio p) {
		
	}

	public void afectar(ObstaculoTemporal p) {
		
	}

	public void afectar(Obstaculo o) {
		
	}

}
