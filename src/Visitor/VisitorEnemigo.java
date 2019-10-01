package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Personaje.Personaje;

public class VisitorEnemigo extends Visitor {

	@Override
	public void afectar(Personaje p) {
		p.recibirDaño(p.getDanio());
		
		System.out.println("Entre a afectar personaje en visitor enemigo");
	}

	@Override
	public void afectar(Enemigo e) {
	}

	@Override
	public void afectar(Disparo d) {
	}

}
