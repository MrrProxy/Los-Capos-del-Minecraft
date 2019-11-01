package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

import TiendaPersonaje.CProteccion;
import Visitor.VisitorPremio;

public class CampoProteccion extends Premio {
	
	private CampoProteccion boton;

	public CampoProteccion(Point p, int x, int y) {
		super(p, x, y);
		miVisitor = new VisitorPremio(this);
		puntosVida=1;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Campo.png"));
		// TODO Auto-generated constructor stub
	}
	
	public void fuisteClickeado(){
		if (!activado){
			morir();
			CProteccion.getInstance().sumarContador();}
		
		}

}
