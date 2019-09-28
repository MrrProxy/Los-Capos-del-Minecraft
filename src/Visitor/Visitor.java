package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Personaje.Personaje;

public abstract class Visitor {
	
	public abstract void afectar(Personaje p);
	public abstract void afectar(Enemigo e);
	public abstract void afectar(Disparo d);
	//public abstract void afectar(Objeto o);
	//public abstract void 

}
