package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Objetos.Obstaculo;
import Personaje.Personaje;

public class VisitorObstaculo extends Visitor{
	
	public VisitorObstaculo(Obstaculo o){
		super(o);
	}

	@Override
	public void afectar(Personaje p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Disparo d) {
		// TODO Auto-generated method stub
		
	}

}
