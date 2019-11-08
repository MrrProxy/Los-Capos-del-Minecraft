package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Juego.Juego;
import Objetos.BombaExplosion;
import Objetos.Obstaculo;
import Objetos.Premio;
import Personaje.Personaje;

public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(Enemigo e) {
		super(e);
	}

	@Override
	public void afectar(Personaje p) {
		p.recibirDaño(miEntidad.getDanio());
		miEntidad.setGrafico(1);
		p.setEstado(2);
	}

	@Override
	public void afectar(Enemigo e) {
		e.setEstado(2);
	}

	@Override
	public void afectar(Disparo d) {
		
	}
	
	public void afectar(Obstaculo o) {
		o.recibirDaño(miEntidad.getDanio());
	}

	@Override
	public void afectar(Premio p){
		System.out.println("Estoy entrando acá");
		if (p.getActivado()){
			p.morir();
			miEntidad.morir();
			Juego.getInstance().enemigoMuerto();
		}
		
	}
	
	public void afectar(BombaExplosion b){
		//b.actuar();
		//System.out.println("Entre??");
	}

}
