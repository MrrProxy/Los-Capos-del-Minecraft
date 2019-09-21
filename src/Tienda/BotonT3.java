package Tienda;

import java.awt.Point;
import javax.swing.ImageIcon;
import Entidad.Entidad;
import GUI.GUI;
import Personaje.KnightLanza;

public class BotonT3 extends Boton{
	
	private static final long serialVersionUID = 1L;
	
	
	public BotonT3(TiendaJuego tienda,GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 200, 200, 100);
		this.setText("Torre3 ");
		this.setEnabled(false);

	}




	protected ImageIcon getIconoBoton() {
		return null;
	}

	protected Entidad crearEntidad() {
		Entidad entidad = new KnightLanza(new Point(0, 0), 70, 70);
		return entidad;
	}


}
