package Tienda;


import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Entidad.Entidad;
import GUI.GUI;

public class BotonComprar extends Boton{
	
	private static final long serialVersionUID = 1L;
	
	public BotonComprar(TiendaJuego tienda,GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 600, 200, 100);
		this.setText("Comprar");
		this.setEnabled(true);

	}


	// Accion del boton Comprar
	protected void accionarBoton() {
		LinkedList<JButton> buttons=tienda.getBoton();
		this.setEnabled(false);
		for (JButton b : buttons) {
			if (b.getText().equals("Comprar"))
				b.setEnabled(false);
			else {
				b.setEnabled(true);
			}
		}
	}

	protected ImageIcon getIconoBoton() {
		return null;
	}


	protected Entidad crearEntidad() {
		return null;
	}


	protected int obtenerPrecio() {
		return 0;
	}
}