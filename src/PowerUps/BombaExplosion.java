package PowerUps;

import java.awt.Point;
import javax.swing.ImageIcon;
import Entidad.Entidad;
import Visitor.Visitor;
import Visitor.VisitorExplosion;

public class BombaExplosion extends Entidad{

	public BombaExplosion(Point p, int x, int y) {
		super(p, x, y);
		miVisitor = new VisitorExplosion(this);
		puntosVida=1;
		danioImpacto=100000;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/BombaExplotando.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/ExplosionGrande.gif"));
	}
	
	public void recibirDaņo(int danioImpacto){};
	
	public synchronized void actuar(){
		BombaExplosion b= this;
		b.width=150;
		b.height=140;
			for (Entidad ent: juego.getEntidades()){
				if (ent.chocan(b) && b!=ent)
					ent.recibirDaņo(danioImpacto);
			}
		morir();
	}
	
	public void Accionar() {
		
	}
	public void Aceptar(Visitor v) {
		v.afectar(this);
		
	}

	
	

}
