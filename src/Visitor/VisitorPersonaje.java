package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Personaje.Personaje;

public class VisitorPersonaje extends Visitor{
	
	public VisitorPersonaje(Personaje p){
		super(p);
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
