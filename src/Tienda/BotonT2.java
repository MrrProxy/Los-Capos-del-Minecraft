package Tienda;

import java.awt.Point;
import java.util.LinkedList;

import Entidad.Entidad;
import GUI.GUI;
import Personaje.KnightHacha;

public class BotonT2 extends FabricaBoton {

	private static final long serialVersionUID = 1L;

	public void AccionarBoton(GUI gui, LinkedList<FabricaBoton> botones) {
		// System.out.println("entre al acionar de boton2 ...");
		Entidad entidad = new KnightHacha(new Point(0, 0), 70, 70);
		Accionar(entidad, botones, gui);
	}
}
