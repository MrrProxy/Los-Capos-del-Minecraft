package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Personaje.Personaje;

public class VisitorPersonaje extends Visitor{

	@Override
	public void afectar(Personaje p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Enemigo e) {
		e.recibirDaņo(e.getDanio());
		e.modoActual(1, 0);
		System.out.println("Entre a afectar  enemigo  en visitor personaje");

	}

	@Override
	public void afectar(Disparo d) {
		// TODO Auto-generated method stub
		
	}

}
