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
		
	}

	@Override
	public void afectar(Enemigo e) {
	}

	@Override
	public void afectar(Disparo d) {
		d.morir();
		miEntidad.recibirDaño(5);
		System.out.println("entre");
	}

}
