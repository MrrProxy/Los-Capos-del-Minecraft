package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Objetos.Obstaculo;
import Objetos.Premio;
import Personaje.Personaje;

public class VisitorEnemigoSuicida extends Visitor {
	
	public VisitorEnemigoSuicida(Entidad e) {
		super(e);
	}

	public void afectar(Personaje p) {
		p.recibirDaño(miEntidad.getDanio());
		miEntidad.morir();
	}

	public void afectar(Enemigo e) {
		e.setEstado(2);
	}

	public void afectar(Disparo d) {
		miEntidad.Accionar();
	}

	@Override
	public void afectar(Obstaculo o) {
		o.recibirDaño(miEntidad.getDanio());
	}

	@Override
	public void afectar(Premio p) {
		miEntidad.Accionar();
	}

}
