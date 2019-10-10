package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Personaje.Personaje;

public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(Enemigo e) {
		super(e);
	}

	@Override
	public void afectar(Personaje p) {
		p.recibirDaņo(miEntidad.getDanio());
		miEntidad.setGraficoActual(1);
		if (p.getVida() < 0) {
			miEntidad.setGrafico(0);
		}

	}

	@Override
	public void afectar(Enemigo e) {
		// if (miEntidad.getPosition().getX()<e.getPosition().getX())
		// e.setAvanzar(false);

	}

	@Override
	public void afectar(Disparo d) {
	}

}
