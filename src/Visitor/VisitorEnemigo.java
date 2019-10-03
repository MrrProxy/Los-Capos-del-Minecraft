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
		miEntidad.recibirDaņo(p.getDanio());
		/*if(miEntidad.getVida()<=0)
			p.modoActual(0, 0);
		else {
			p.modoActual(1, 0);
		}*/

	}

	@Override
	public void afectar(Enemigo e) {
		//e.setAvanzar(false);
		if (miEntidad.getPosition().getX()<e.getPosition().getX())
			e.setAvanzar(false);
		/*else
			e.setAvanzar(true);*/
			
	}

	@Override
	public void afectar(Disparo d) {
		miEntidad.recibirDaņo(d.getDanio());
		d.morir();
	}

}
