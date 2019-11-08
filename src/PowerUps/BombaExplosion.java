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
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Bomb.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Explosion.png"));
	}
	
	public synchronized void actuar(){
		BombaExplosion b= this;
		//Timer timer = new Timer(1, new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
				b.width=350;
				b.height=350;
				//setGrafico(1);
				for (Entidad ent: juego.getEntidades()){
					System.out.println("Ssss");
					if (ent.chocan(b) && b!=ent)
						ent.recibirDaño(danioImpacto);
				}
				
						
			//}
		//});
		
		morir();
		
		//timer.start();
	}
	
	public void Accionar() {
		
	}

	public void Aceptar(Visitor v) {
		v.afectar(this);
		
	}
	
	

}
