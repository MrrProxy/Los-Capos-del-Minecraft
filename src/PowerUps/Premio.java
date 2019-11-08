package PowerUps;

import java.awt.Point;

import Entidad.Entidad;
import Visitor.Visitor;

public class Premio extends Entidad {
	
	protected boolean activado;
	
	public Premio(Point p, int x, int y){
		super(p,x,y);
		activado=false;
	}

	@Override
	public void Accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override

	
	public void fuisteClickeado(){
		System.out.println("Click en premio!");
	}

	@Override
	public void Aceptar(Visitor v) {
		v.afectar(this);
		
	}
	
    public void activarPowerUp() {
		
	}

}