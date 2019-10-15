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
		p.recibirDa�o(miEntidad.getDanio());
		miEntidad.setGrafico(1);
	}

	@Override
	public void afectar(Enemigo e) {
	}

	@Override
	public void afectar(Disparo d) {
		
	}

}
