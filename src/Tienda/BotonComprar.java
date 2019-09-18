package Tienda;

import java.util.LinkedList;

import GUI.GUI;

public class BotonComprar extends FabricaBoton {

	private static final long serialVersionUID = 1L;

	// Constructor
	public BotonComprar(String string) {
		this.setText(string);
	}

	// Accion del boton Comprar
	public void AccionarBoton(GUI gui, LinkedList<FabricaBoton> botones) {
		for (FabricaBoton tienda : botones) {
			if (tienda.getText().equals("Comprar"))
				tienda.setEnabled(false);
			else {
				tienda.setEnabled(true);
			}
			
		}

	}
}