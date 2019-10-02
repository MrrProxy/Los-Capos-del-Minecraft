package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Personaje.Personaje;

public class VisitorPersonaje extends Visitor{
	
	public VisitorPersonaje(Personaje p){
		super(p);
	}

	public void afectar(Personaje p) {
	}

	public void afectar(Enemigo e) {
		miEntidad.recibirDaño(e.getDanio());
		miEntidad.modoActual(1, 0);
		if(miEntidad.getVida()<=0)
			e.modoActual(0, e.getVelocidadInicial());
		else {
			e.modoActual(1, 0);
		}

	}

	public void afectar(Disparo d) {
		d.morir();
		miEntidad.recibirDaño(d.getDanio());
		
	}

}
