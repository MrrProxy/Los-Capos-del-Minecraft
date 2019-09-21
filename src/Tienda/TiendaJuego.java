package Tienda;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JButton;

import Entidad.Entidad;
import Juego.Juego;

public class TiendaJuego {
	private Juego juego;
	private Entidad nextToAdd;

	private static TiendaJuego instance;
	private LinkedList<JButton> buttons;

	public static TiendaJuego getInstance() {
		if (instance == null)
			instance = new TiendaJuego(Juego.getInstance());
		return instance;
	}

	private TiendaJuego(Juego juego) {
		this.juego = juego;
		buttons = new LinkedList<JButton>();
		this.nextToAdd = null;
	}

	public void setNextToAdd(Entidad toAdd) {
		this.nextToAdd = toAdd;
	}

	public boolean puedoAgregar(Entidad toAdd) {
		boolean toReturn = false;
		if (toAdd != null) {
			int cantMonedas = this.juego.getCantMonedas();
			int precio = toAdd.getPrecioPersonaje();
			toReturn = cantMonedas >= precio;
		}
		return toReturn;
	}

	public void agregarEntidad(int x, int y) {
		if (this.nextToAdd != null) {
			this.nextToAdd.setPosition(new Point(x, y));
			this.juego.agregarEntidad(this.nextToAdd);
			this.juego.setCantMonedas(this.juego.getCantMonedas() - nextToAdd.getPrecioPersonaje());
			
			this.nextToAdd = null;
		}
	}

	public void setBoton(JButton b) {
		buttons.add(b);
	}

	public LinkedList<JButton> getBoton() {
		return buttons;
	}

}
