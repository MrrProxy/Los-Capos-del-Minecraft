package Tienda;

import java.awt.Point;
import java.util.LinkedList;

import GUI.GUI;
import Juego.Juego;
import Personaje.KnightHacha;

public class BotonT2 extends Tienda {

	private static final long serialVersionUID = 1L;

	public void AccionarBoton(GUI gui, LinkedList<Tienda> tiendas) {
		// System.out.println("entre al acionar de boton2 ...");
		entidad = new KnightHacha(new Point(0, 0), 70, 70);
		juego = Juego.getInstance();
		juego.agregarEntidad(entidad);
		// Controlo que disponga de la plata para comprar la torre
		int precio=entidad.getPrecioPersonaje();
		int monedas=juego.getCantMonedas();
		if(precio<=monedas) {
			gui.agregarTorre(entidad);
			juego.setCantMonedas(monedas-precio);
		}
		//Habilito el boton comprar y desabilito el resto
		for (Tienda tienda : tiendas) {
			if (tienda.getText().equals("Comprar"))
				tienda.setEnabled(true);
			else {
				tienda.setEnabled(false);
			}

		}
	}
}
