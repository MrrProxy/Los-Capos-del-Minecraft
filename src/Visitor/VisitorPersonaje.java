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
		miEntidad.recibirDaño(e.getDanio()*2);
		System.out.println(miEntidad.getVida());
		e.setAvanzar(false);
		miEntidad.setGraficoActual(1);
		e.setGraficoActual(1);
		if (miEntidad.getVida()<=0){
			e.setAvanzar(true);
			e.setGraficoActual(0);
		}
	}

	public void afectar(Disparo d) {
	}

}
