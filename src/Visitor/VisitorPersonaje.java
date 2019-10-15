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
		e.recibirDaño(miEntidad.getDanio());
		miEntidad.setGrafico(1);
		if(e.getVida()<=0) {
			miEntidad.setGrafico(0);
		}
		
	}

	public void afectar(Disparo d) {
		
	}

}
