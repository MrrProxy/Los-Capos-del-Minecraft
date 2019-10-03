package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Juego.Juego;
import Personaje.Personaje;

public class VisitorPersonaje extends Visitor{
	
	Juego j;
		
	public VisitorPersonaje(Personaje p){
		super(p);
		j = j.getInstance();
	}

	public void afectar(Personaje p) {
	}

	public void afectar(Enemigo e) {
		miEntidad.recibirDaño(e.getDanio()*2);
		e.setAvanzar(false);
		miEntidad.setGraficoActual(1);
		e.setGraficoActual(1);
		if (miEntidad.getVida()<=0){
			e.setAvanzar(true);
			e.setGraficoActual(0);
		}
	//	miEntidad.modoActual(1, 0);
		/*if(miEntidad.getVida()<=0)
			e.modoActual(0, e.getVelocidadInicial());
		else {
			e.modoActual(1, 0);
		}*/

	}

	public void afectar(Disparo d) {
		//d.morir();
		//miEntidad.recibirDaño(d.getDanio());
		
	}

}
