package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Personaje.Personaje;

public class VisitorDisparo extends Visitor {

	public VisitorDisparo(Entidad e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afectar(Personaje p) {
		System.out.println("person");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Enemigo e) {
		//e.recibirDaño(miEntidad.getDanio());
		System.out.println("Nada");
		
	}

	@Override
	public void afectar(Disparo d) {
		System.out.println("Probando");
		
	}
	
	

}
