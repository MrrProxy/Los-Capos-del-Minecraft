package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Objetos.Obstaculo;
import Objetos.Premio;
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
		e.Accionar();
		miEntidad.morir();	

	}

	public void afectar(Disparo d) {
		miEntidad.Accionar();
	}

	@Override
	public void afectar(Obstaculo o) {
		miEntidad.Accionar();
		
	}

	@Override
	public void afectar(Premio p) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
