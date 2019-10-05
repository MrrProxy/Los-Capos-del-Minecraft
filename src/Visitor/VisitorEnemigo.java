package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Personaje.Personaje;

public class VisitorEnemigo extends Visitor {
	
	public VisitorEnemigo(Enemigo e){
		super(e);
	}

	@Override
	public void afectar(Personaje p) {
		miEntidad.recibirDaño(p.getDanio());
		miEntidad.setGraficoActual(1);
	}

	@Override
	public void afectar(Enemigo e) {
		if (miEntidad.getPosition().getX()<e.getPosition().getX())
			e.setAvanzar(false);
	}

	@Override
	public void afectar(Disparo d) {
		miEntidad.recibirDaño(d.getDanio());
		d.morir();
	}

}
