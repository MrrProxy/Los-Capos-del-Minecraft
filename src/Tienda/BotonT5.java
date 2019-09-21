package Tienda;

import java.awt.Point;
import javax.swing.ImageIcon;
import Entidad.Entidad;
import GUI.GUI;
import Personaje.Arquero;

public class BotonT5 extends Boton {
	
	private static final long serialVersionUID = 1L;
	
	
	public BotonT5(TiendaJuego tienda,GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 400, 200, 100);
		this.setText("Torre5 ");
		this.setEnabled(false);

	}


	protected ImageIcon getIconoBoton() {
		return null;
	}

	@Override
	protected Entidad crearEntidad() {
		Entidad entidad = new Arquero(new Point(0, 0), 70, 70);
		return entidad;
	}

}
