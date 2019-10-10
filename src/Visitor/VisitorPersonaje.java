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
		e.recibirDaņo(miEntidad.getDanio());
		miEntidad.setGraficoActual(1);
		if(e.getVida()<=0) {
			miEntidad.setGrafico(0);
		}
		miEntidad.Accionar();
	}

	public void afectar(Disparo d) {
		
	}

}
