package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.BombaExplosion;
import PowerUps.CampoProteccionActivado;
import PowerUps.Premio;

public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(Enemigo e) {
		super(e);
	}

	@Override
	public void afectar(Personaje p) {
		p.recibirDaņo(miEntidad.getDanio());
		miEntidad.setGrafico(1);
		p.setEstado(2);
	}

	@Override
	public void afectar(Enemigo e) {
		e.setEstado(2);
	}
	
	public void afectar(CampoProteccionActivado c){
		c.morir();
		miEntidad.morir();
	}

	@Override
	public void afectar(Disparo d) {

	}

	public void afectar(Premio p) {
	}

	public void afectar(BombaExplosion b) {
	}

	public void afectar(ObstaculoTemporal p) {
	}

	public void afectar(Obstaculo o) {
		o.recibirDaņo(miEntidad.getDanio());

	}

}
