package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Objetos.Obstaculo;
import Objetos.Premio;
import Personaje.Personaje;

public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(Enemigo e) {
		super(e);
	}

	@Override
	public void afectar(Personaje p) {
		p.recibirDaņo(miEntidad.getDanio());
		miEntidad.setGrafico(1);
		p.setEstado(2);
	}

	@Override
	public void afectar(Enemigo e) {
		e.setEstado(2);
	}

	@Override
	public void afectar(Disparo d) {
		
	}
	
	public void afectar(Obstaculo o) {
		o.recibirDaņo(miEntidad.getDanio());
		//miEntidad.setGraficoActual(1);
		//if (o.getVida() < 0) {
		
		
		//}
	}

	@Override
	public void afectar(Premio p){
		
	}

}
