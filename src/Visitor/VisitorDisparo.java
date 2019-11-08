package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.Premio;

public class VisitorDisparo extends Visitor {

	public VisitorDisparo(Entidad e) {
		super(e);
	}

	public void afectar(Personaje p) {
		miEntidad.Accionar();
	}

	public void afectar(Enemigo e) {
		miEntidad.Accionar();
		e.recibirDaño(miEntidad.getDanio());
		miEntidad.morir();	

	}

	public void afectar(Disparo d) {
		miEntidad.Accionar();
	}


	public void afectar(Premio p) {
	}

	public void afectar(ObstaculoTemporal p) {
	}

	@Override
	public void afectar(Obstaculo o) {
		
	}
	
	
	
	

}
