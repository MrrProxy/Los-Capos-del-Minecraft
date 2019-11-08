package Tienda;

import java.awt.Point;

import javax.swing.ImageIcon;

import Entidad.Entidad;
import GUI.GUI;
import Obstaculos.Lava;

public class BotonMuralla extends Boton{
	
private static final long serialVersionUID = 1L;
	
	public BotonMuralla(TiendaJuego tienda, GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 500, 200, 100);
		this.setBorder(null);
		this.setEnabled(false);
		this.setVisible(false);

	}


	@Override
	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Boton2.png"));

	}

	@Override
	protected Entidad crearEntidad() {
		Entidad entidad =new Lava(new Point(0,0),100,65);
		return entidad;
	}

}


