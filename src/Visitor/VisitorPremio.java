package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Objetos.Obstaculo;
import Objetos.Premio;
import Personaje.Personaje;

public class VisitorPremio extends Visitor{
	
	public VisitorPremio(Premio p){
		super(p);
	}

	@Override
	public void afectar(Personaje p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Enemigo e) {
		//e.Accionar();
		
	}

	@Override
	public void afectar(Disparo d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Obstaculo o) {
		// TODO Auto-generated method stub
		
	}
	
	public void afectar(Premio p){
		
	}

}