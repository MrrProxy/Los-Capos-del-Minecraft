package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.Premio;

public class VisitorCampoActivado extends Visitor {

	public VisitorCampoActivado(Entidad e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afectar(Personaje p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Enemigo e) {
		e.morir();
		miEntidad.morir();
		
	}

	@Override
	public void afectar(Disparo d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Obstaculo o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Premio p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(ObstaculoTemporal p) {
		// TODO Auto-generated method stub
		
	}

}
