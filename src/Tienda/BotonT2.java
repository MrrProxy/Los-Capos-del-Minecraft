package Tienda;

import java.awt.Point;
import javax.swing.ImageIcon;
import Entidad.Entidad;
import GUI.GUI;
import Personaje.KnightHacha;

public class BotonT2 extends Boton {
	
	private static final long serialVersionUID = 1L;
	
	public BotonT2(TiendaJuego tienda, GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 100, 200, 100);
		this.setText("Torre2 ");
		this.setEnabled(false);


	}


	public void AccionarBoton() {
	}

	protected ImageIcon getIconoBoton() {
		return null;
	}

	protected Entidad crearEntidad() {
		Entidad entidad = new KnightHacha(new Point(0, 0), 70, 70);
		return entidad;
	}
}
