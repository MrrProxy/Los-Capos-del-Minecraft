package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Enemigo.ReaperMan;
import Enemigo.ReaperManRed;
import Juego.Juego;
import Objetos.Obstaculo;
import Objetos.Premio;
import Personaje.Personaje;

public class VisitorPersonaje extends Visitor{
	
	public VisitorPersonaje(Personaje p){
		super(p);
	}

	public void afectar(Personaje p) {
	}

	public void afectar(Enemigo e) {
		e.recibirDaño(miEntidad.getDanio());
		miEntidad.setGrafico(1);
		e.setEstado(2);
		miEntidad.setEstado(2);
		if(e.getVida()<=0) {
			miEntidad.setGrafico(0);
			Juego.getInstance().enemigoMuerto();
		}
		
	}
	
	public void afectar(ReaperMan e){System.out.println("Entre acá");};

	public void afectar(Disparo d) {
		
	}

	@Override
	public void afectar(Obstaculo o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Premio p) {
		// TODO Auto-generated method stub
		
	}

}
