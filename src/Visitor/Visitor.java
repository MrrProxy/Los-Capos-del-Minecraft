package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Objetos.Obstaculo;
import Personaje.Personaje;

public abstract class Visitor {
	
	protected Entidad miEntidad;
	
	protected Visitor(Entidad e){
		miEntidad=e;
	}
	
	public abstract void afectar(Personaje p);
	public abstract void afectar(Enemigo e);
	public abstract void afectar(Disparo d);
	public abstract void afectar(Obstaculo o);
	//public abstract void 

}
