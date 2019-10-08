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
		//e.recibirDaño(miEntidad.getDanio());
		//e.setAvanzar(false);
		miEntidad.setGraficoActual(1);
		
		if (miEntidad.getVida()<=0){
			//e.setAvanzar(true);
			e.setGraficoActual(0);
		}
		miEntidad.Accionar();
	}

	public void afectar(Disparo d) {
	}

}
