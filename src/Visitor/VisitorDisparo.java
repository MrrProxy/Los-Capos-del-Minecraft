package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Objetos.Obstaculo;
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
		e.recibirDaño(miEntidad.getDanio());
		miEntidad.morir();	

	}

	public void afectar(Disparo d) {
		miEntidad.Accionar();
	}

	@Override
	public void afectar(Obstaculo o) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
