package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Personaje.Personaje;

public class VisitorDisparo extends Visitor {

	public VisitorDisparo(Entidad e) {
		super(e);
	}

	public void afectar(Personaje p) {
	}

	public void afectar(Enemigo e) {
	}

	public void afectar(Disparo d) {
	}
	
	

}
