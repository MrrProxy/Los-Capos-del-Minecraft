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
		miEntidad.recibirDaņo(e.getDanio());
		System.out.println(miEntidad.getVida());
		e.setAvanzar(false);
		if (miEntidad.getVida()<=0)
			e.setAvanzar(true);
	//	miEntidad.modoActual(1, 0);
		/*if(miEntidad.getVida()<=0)
			e.modoActual(0, e.getVelocidadInicial());
		else {
			e.modoActual(1, 0);
		}*/

	}

	public void afectar(Disparo d) {
		d.morir();
		miEntidad.recibirDaņo(d.getDanio());
		
	}

}
