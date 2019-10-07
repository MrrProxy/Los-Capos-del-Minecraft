package Tienda;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Entidad.Entidad;
import GUI.GUI;
import Sonidos.Sonidos;
import Sonidos.SonidosMp3;

public class BotonSonido extends Boton {
	
	private static final long serialVersionUID = 1L;
	GUI gui;

	public BotonSonido(TiendaJuego tienda, GUI gui) {
		super(tienda, gui);
		this.gui = gui;
		this.setBounds(0, 500, 200, 100);
		this.setText("Sonido");
		this.setEnabled(true);

	}

	// Accion del boton Comprar
	protected void accionarBoton() {
		SonidosMp3 sonidos=new SonidosMp3();
		System.out.print("q mierda pasa");
		try {
			sonidos.Stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
