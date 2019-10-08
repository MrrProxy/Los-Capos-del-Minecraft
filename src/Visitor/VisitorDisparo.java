package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Personaje.Personaje;

public class VisitorDisparo extends Visitor {

	public VisitorDisparo(Entidad e) {
		super(e);
	}

	public void afectar(Personaje p) {
		miEntidad.Accionar();
	}

	public void afectar(Enemigo e) {
		miEntidad.Accionar();
		e.recibirDaņo(miEntidad.getDanio());
		miEntidad.morir();
	}

	public void afectar(Disparo d) {
		miEntidad.Accionar();
	}
	
	

}
