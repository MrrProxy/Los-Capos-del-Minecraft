package Tienda;

import java.awt.Point;
import java.util.LinkedList;

import Entidad.Entidad;
import GUI.GUI;
import Personaje.Arquero;

public class BotonT5 extends FabricaBoton {
	private static final long serialVersionUID = 1L;

	// Accion del boton Torre1
	public void AccionarBoton(GUI gui, LinkedList<FabricaBoton> botones) {
		Entidad entidad = new Arquero(new Point(0, 0), 70, 70);
		Accionar(entidad, botones, gui);
	}
}
