package Tienda;

import java.util.LinkedList;

import GUI.GUI;

public class BotonComprar extends Tienda {

	private static final long serialVersionUID = 1L;

	// Constructor
	public BotonComprar(String string) {
		this.setText(string);
	}

	// Accion del boton Comprar
	public void AccionarBoton(GUI gui, LinkedList<Tienda> tiendas) {
		for (Tienda tienda : tiendas) {
			if (tienda.getText().equals("Comprar"))
				tienda.setEnabled(false);
			else {
				tienda.setEnabled(true);
			}
			
		}

	}
}